package com.example.coinmarketcapcriptoapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.coinmarketcapcriptoapp.R
import com.example.coinmarketcapcriptoapp.base.BaseFragment
import com.example.coinmarketcapcriptoapp.databinding.FragmentHomeBinding
import com.example.coinmarketcapcriptoapp.model.home.Data
import com.example.coinmarketcapcriptoapp.utils.Constants.API_KEY
import com.example.coinmarketcapcriptoapp.utils.Constants.LIMIT
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getData(API_KEY, LIMIT)
    }

    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreateFinished() {

    }

    override fun initializeListener() {
    }

    override fun observeEvents() {
        with(viewModel){
            cryptoResponse.observe(viewLifecycleOwner, Observer {
                it?.let {
                    it.data?.let {
                        setRecycler(it)
                    }
                }
            })
            isLoading.observe(viewLifecycleOwner, Observer {
                handleViews(it)
            })
            onError.observe(viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
            })
        }
    }

    private fun setRecycler(data:List<Data>){
        val mAdapter=HomeRecyclerAdapter(object :ItemClickListener{
            override fun onItemClick(coin: Data) {
                if(coin.symbol !=null){
                    val nav=HomeFragmentDirections.actionHomeFragmentToDetailFragment2(coin.symbol)
                    Navigation.findNavController(requireView()).navigate(nav)
                }
            }

        })
        binding.rvHome.adapter=mAdapter
        mAdapter.setList(data)
    }

    private fun handleViews(isLoading:Boolean=false){
        binding.rvHome.isVisible=!isLoading
        binding.pbHome.isVisible=isLoading
    }
}