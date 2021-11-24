package com.example.typing_tracker.ui.home

import android.util.Log
import androidx.navigation.fragment.navArgs
import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentHomeBinding
import com.example.typing_tracker.model.Repository
import com.example.typing_tracker.model.domain.Character
import com.example.typing_tracker.model.domain.GameResult
import com.example.typing_tracker.model.domain.Paragraph
import com.example.typing_tracker.ui.base.BaseFragment
import com.example.typing_tracker.util.Difficulty
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(){

    override val layoutId: Int = R.layout.fragment_home
    override val viewModelClass = HomeViewModel::class.java
    private val args: HomeFragmentArgs by navArgs()


    override fun observeEvents() {

    }

    override fun setUpBinding() {
        //TODO: remove messy comments
        //region tests
        Log.i("kkk", "difficulity from start fragment:"+ args.level+"\n\n")
        //test getting random paragraph for the chosen difficulity level
        Repository.getParagraphByDifficulty(enumValueOf(args.level.uppercase())).subscribeOn(Schedulers.io()).subscribe(
            {
                Log.i("kkk","paragraph: " + it+"\n\n")
            },{
                Log.i("kkk",it.message.toString())
            }
        )

        //test inserting game result
        Repository.insertGameResult(
            GameResult(0,10,56,3,64.7,63.7,Difficulty.HARD, Date(10053))
        ).subscribeOn(Schedulers.io()).subscribe()

        //test getting all games results
        Repository.getAllGamesResults().subscribeOn(Schedulers.io()).subscribe(
            {
                Log.i("kkk","all games: " + it.toString()+"\n\n")
            }, {
                Log.i("kkk",it.message.toString())
            }
        )

        //test inserting character
        Repository.insertCharacter(
            Character(0,"w",14.56,Date(10053))
        ).subscribeOn(Schedulers.io()).subscribe()

        //test getting character by id
        Repository.getCharacterStatistics(1).subscribeOn(Schedulers.io()).subscribe(
            {
                Log.i("kkk","character: " + it.toString()+"\n\n")
            }, {
                Log.i("kkk",it.message.toString())
            }
        )
        //endregion
        binding.countUpTimer.start()
    }



}