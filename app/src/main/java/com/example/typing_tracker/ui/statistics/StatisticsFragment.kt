package com.example.typing_tracker.ui.statistics


import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentStatisticsBinding
import com.example.typing_tracker.ui.base.BaseFragment
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement

class StatisticsFragment : BaseFragment<FragmentStatisticsBinding, StatisticsViewModel>(){

    override val layoutId: Int = R.layout.fragment_statistics
    override val viewModelClass = StatisticsViewModel::class.java

    override fun observeEvents() {

    }

    override fun setUpBinding() {
        val lineChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Line)
            .title("overall statistics")
            .backgroundColor("#ffffff")
            .dataLabelsEnabled(true)
            .series(arrayOf(
                AASeriesElement()
                    .name("accuracy")
                    .data(arrayOf(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6)),
                AASeriesElement()
                    .name("WPM")
                    .data(arrayOf(0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5))
            )
            )
        binding.lineChart.aa_drawChartWithChartModel(lineChartModel)

        val barChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Bar)
            .title("characters accuracy")
            .backgroundColor("#ffffff")
            .dataLabelsEnabled(true)
            .series(arrayOf(
                AASeriesElement()
                    .name("a")
                    .data(arrayOf(7.0)),
                AASeriesElement()
                    .name("b")
                    .data(arrayOf(6)),
                AASeriesElement()
                    .name("c")
                    .data(arrayOf(3)),
                AASeriesElement()
                    .name("d")
                    .data(arrayOf(4))
            )
            )
        binding.barChart.aa_drawChartWithChartModel(barChartModel)

    }


}