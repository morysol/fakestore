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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.lifecycleScope
import com.fakestore.data.remote.CategoriesUseCaseImpl
import com.fakestore.data.remote.ProductUseCaseImpl
import com.fakestore.databinding.FragmentHomeBinding
import com.fakestore.domain.CategoriesUseCase
import com.fakestore.domain.ProductUseCase
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    init {
        lifecycleScope.launch {
            // TODO val productUseCase: ProductUseCase = object ProductUseCaseImpl
            // не сработало

            //  val response = ProductUseCase.getProduct()

            val productUseCase: ProductUseCase = object : ProductUseCaseImpl() {}

            Log.d("response", Calendar.getInstance().time.toString())
            Log.d("response", productUseCase.toString())


            // val categories = CategoriesUseCase.getCategories()
            val categoriesUseCase: CategoriesUseCase = object : CategoriesUseCaseImpl() {}

            Log.d("response", Calendar.getInstance().time.toString())
            Log.d("response", categoriesUseCase.getCategories().categories.toString())
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

        // Данные для адаптера
        val items = listOf("Пункт 1", "Пункт 2", "Пункт 3")

        // Инициализация RecyclerView
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = MyAdapter(items)


    }
}