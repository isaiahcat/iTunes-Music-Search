package com.jhaiasi.itunesmusicsearch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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

        viewModel.searchMusic("jack johnson")

        return binding.root
    }

    override fun onTrackClicked(track: Track) {
        // TODO: Goto detail fragment
    }
}