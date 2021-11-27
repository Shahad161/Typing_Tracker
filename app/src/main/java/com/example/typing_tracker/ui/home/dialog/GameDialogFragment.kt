package com.example.typing_tracker.ui.home.dialog

import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentAccuracyBinding
import com.example.typing_tracker.databinding.FragmentGameDialogBinding
import com.example.typing_tracker.ui.base.BaseFragment


class GameDialogFragment: BaseFragment<FragmentGameDialogBinding, GameDialogModelView>() {

    override val layoutId = R.layout.fragment_game_dialog
    override val viewModelClass = GameDialogModelView::class.java

    override fun observeEvents() {
    }

    override fun setUpBinding() {
    }
}