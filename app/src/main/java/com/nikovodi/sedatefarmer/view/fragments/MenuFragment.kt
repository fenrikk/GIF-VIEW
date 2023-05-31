package com.nikovodi.sedatefarmer.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nikovodi.sedatefarmer.databinding.FragmentMenuBinding
import com.nikovodi.sedatefarmer.viewmodel.GifMenuViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val model: GifMenuViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGoTrending.setOnClickListener {
            findNavController()
                .navigate(MenuFragmentDirections.actionMenuFragmentToGifListFragment())
        }
        model.getLink().observe(viewLifecycleOwner) { url ->
            binding.buttonGoWebView.setOnClickListener {
                findNavController().navigate(
                    MenuFragmentDirections.actionMenuFragmentToWebFragment(url)
                )
            }
            binding.link.text = "LINK FROM SERVER: \n $url"
        }
    }
}