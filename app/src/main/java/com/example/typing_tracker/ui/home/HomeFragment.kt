package com.example.typing_tracker.ui.home


import androidx.navigation.fragment.navArgs
import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentHomeBinding
import com.example.typing_tracker.ui.base.BaseFragment
import com.example.typing_tracker.util.*





class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(){

    override val layoutId: Int = R.layout.fragment_home
    override val viewModelClass = HomeViewModel::class.java
    private val args: HomeFragmentArgs by navArgs()
    override val useActivityViewModel: Boolean =false

    override fun observeEvents() {

        viewModel.endGameEvent.observeEvent(this@HomeFragment){
            view?.goToFragment(HomeFragmentDirections.actionHomeFragmentToGameDialogFragment())
        }

        viewModel.clickBackButton.observe(this@HomeFragment){
            view?.goToFragment(HomeFragmentDirections.actionHomeFragmentToStartFragment())
        }
    }

    override fun setUpBinding() {
        viewModel.getParagraph(args.level)
    }


}