package com.root14.flashlightappsmarket.view.ui.mainfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.root14.flashlightappsmarket.R
import com.root14.flashlightappsmarket.databinding.FragmentApplicationBinding
import com.root14.flashlightappsmarket.databinding.FragmentMainBinding
import com.root14.flashlightappsmarket.model.CategoryItem
import com.root14.flashlightappsmarket.view.ui.applicationFragment.AppAdapter

/**
 * main fragment listing categories
 */
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryList = createCategoryList()
        categoryAdapter = CategoryAdapter(categoryList)
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCategories.adapter = categoryAdapter
    }

    //test
    private fun createCategoryList() = listOf<CategoryItem>(
        CategoryItem(
            context?.let { ContextCompat.getDrawable(it, R.drawable.baseline_flashlight_on_24) },
            "Flashlights"
        ),
        CategoryItem(
            context?.let { ContextCompat.getDrawable(it, R.drawable.baseline_light_mode_24) },
            "Colored Lights"
        ),
        CategoryItem(
            context?.let { ContextCompat.getDrawable(it, R.drawable.baseline_sos_24) },
            "Sos Alerts"
        )
    )
}