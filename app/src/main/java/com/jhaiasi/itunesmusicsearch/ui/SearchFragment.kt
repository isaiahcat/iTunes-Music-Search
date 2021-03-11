package com.jhaiasi.itunesmusicsearch.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jhaiasi.itunesmusicsearch.R
import com.jhaiasi.itunesmusicsearch.data.Track
import com.jhaiasi.itunesmusicsearch.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class SearchFragment : Fragment(), TrackOnClickListener {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: SearchAdapter
    private lateinit var searchView: SearchView
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.noResults.isVisible = false
        binding.searchButton.setOnClickListener {
            searchView.isIconified = false
        }

        viewModel.searchResults.observe(viewLifecycleOwner) { results ->
            binding.hasSearchResults = !results.isNullOrEmpty()
            binding.noResults.isVisible = true

            val dateFormat = SimpleDateFormat("EEE MMM dd h:mma", Locale.getDefault())
            binding.timestamp.text = getString(R.string.timestamp_label)
                .plus(dateFormat.format(Calendar.getInstance().time))

            if (binding.searchList.adapter == null) {
                adapter = SearchAdapter(results, this@SearchFragment)
                binding.searchList.adapter = adapter
            } else {
                adapter.notifyDataSetChanged()
            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)

        searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.queryHint = getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.searchMusic(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onTrackClicked(track: Track) {
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToTrackFragment(
                track
            )
        )
    }
}