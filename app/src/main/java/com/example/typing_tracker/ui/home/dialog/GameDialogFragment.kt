package com.example.typing_tracker.ui.home.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentGameDialogBinding
import com.example.typing_tracker.util.*


class GameDialogFragment: DialogFragment() {

    lateinit var binding: FragmentGameDialogBinding
    private val viewModel: GameDialogModelView by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_game_dialog,
            container,
            false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.apply {
            this.viewModel = this@GameDialogFragment.viewModel
            lifecycleOwner = this@GameDialogFragment
            return root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setCancelable(true)
        observeEvents()
    }


     private fun observeEvents() {
        viewModel.navigateToStatistics.observeEvent(this){
            navigateToStatistics()
        }

        viewModel.navigateToGame.observeEvent(this){
            navigateToGame()
        }
    }

    private fun navigateToGame() {
        findNavController().navigate(GameDialogFragmentDirections.actionGameDialogFragmentToHomeFragment(Difficulty.EASY))
    }

    private fun navigateToStatistics() {
        val action = GameDialogFragmentDirections.actionGameDialogFragmentToStatisticsFragment()
        findNavController().navigate(action)
    }

}