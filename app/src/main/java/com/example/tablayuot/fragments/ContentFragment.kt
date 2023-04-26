package com.example.tablayuot.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.tablayuot.MainViewModel
import com.example.tablayuot.adapters.ViewAdapter
import com.example.tablayuot.databinding.ContentFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class ContentFragment : Fragment() {
    private lateinit var binding: ContentFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()
    private val fragList = listOf(
        InfoFragment.newInstance(),
        UseCaseFragment.newInstance(),
    )
    private val fragListTitles = listOf(
        "Описание",
        "Применение",
    )
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
           binding = ContentFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.plant.observe(viewLifecycleOwner){
            binding.imageMain.setImageResource(it.imageId)
        }
        val adapter = ViewAdapter(activity as AppCompatActivity, fragList)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayuot, binding.viewPager2){
                tab, position -> tab.text = fragListTitles[position]
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentFragment()
    }
}
