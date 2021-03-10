package com.jhaiasi.itunesmusicsearch.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jhaiasi.itunesmusicsearch.R
import com.jhaiasi.itunesmusicsearch.com.jhaiasi.itunesmusicsearch.ui.SearchAdapter
import com.jhaiasi.itunesmusicsearch.com.jhaiasi.itunesmusicsearch.ui.TrackOnClickListener
import com.jhaiasi.itunesmusicsearch.data.Track
import com.jhaiasi.itunesmusicsearch.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), TrackOnClickListener {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: SearchAdapter
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        viewModel.searchResults.observe(viewLifecycleOwner) { channels ->
            if (binding.searchList.adapter == null) {
                adapter = SearchAdapter(channels, this@SearchFragment)
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

        val searchView = menu.findItem(R.id.search).actionView as SearchView
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
        // TODO: Goto detail fragment
    }
}