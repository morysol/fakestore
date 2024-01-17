package com.fakestore.ui.home

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.fakestore.databinding.FragmentHomeBinding
import com.fakestore.domain.CategoriesUseCase
import com.fakestore.domain.ProductUseCase
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    init {
        lifecycleScope.launch {
            val response = ProductUseCase.getProduct()
            Log.d("response", Calendar.getInstance().time.toString())
            Log.d("response", response.toString())
            val categories = CategoriesUseCase.getCategories()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        val textView: TextView = binding.textHome
        homeViewModel.homeString.observe(viewLifecycleOwner) {
            textView.text = it
        }
    }
    //TODO спросить про  binding = null и View?
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }
}