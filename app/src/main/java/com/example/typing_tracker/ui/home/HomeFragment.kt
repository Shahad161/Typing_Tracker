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
        with(viewModel){
            //will rewritten when complete dialog
            endGameEvent.observeEvent(this@HomeFragment){
                binding.recyclerView.goToFragment(HomeFragmentDirections.actionHomeFragmentToGameDialogFragment())
            }

        }
    }

    override fun setUpBinding() {
        viewModel.getParagraph(args.level)
    }


}