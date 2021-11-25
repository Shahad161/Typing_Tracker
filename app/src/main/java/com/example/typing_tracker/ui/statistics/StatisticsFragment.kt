package com.example.typing_tracker.ui.statistics


import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentStatisticsBinding
import com.example.typing_tracker.ui.base.BaseFragment
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAOptions
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.github.aachartmodel.aainfographics.aaoptionsmodel.*
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer

class StatisticsFragment : BaseFragment<FragmentStatisticsBinding, StatisticsViewModel>(){

    override val layoutId: Int = R.layout.fragment_statistics
    override val viewModelClass = StatisticsViewModel::class.java

    override fun observeEvents() {

    }

    override fun setUpBinding() {
        val lineChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Line)
            .dataLabelsEnabled(true)
            .categories(arrayOf("2/2","2/3","2/4","2/5", "2/6","2/7","2/8","2/9","2/10","2/11","2/12","2/13"))
            .series(arrayOf(
                AASeriesElement()
                    .name("accuracy")
                    .data(arrayOf(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6)),
                AASeriesElement()
                    .name("WPM")
                    .data(arrayOf(0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5))
            ))
        binding.lineChart.aa_drawChartWithChartModel(lineChartModel)




        val pureJSStr: String = AAJSStringPurer.pureJavaScriptFunctionString(
            "Source: <a href=\"https://highcharts.uservoice.com/forums/55896-highcharts-javascript-api\">UserTests</a>"
        )
        val element: AASeriesElement = AASeriesElement()
            .name("Characters")
            .data(arrayOf(
                arrayOf("A", 1000),
                arrayOf("B", 575),
                arrayOf("C", 523),
                arrayOf("D", 427),
                arrayOf("E", 399),
                arrayOf("F", 309),
                arrayOf("G", 278),
                arrayOf("H", 239),
                arrayOf("I", 235),
                arrayOf("J", 203),
                arrayOf("K", 182),
                arrayOf("L", 157),
                arrayOf("M", 149),
                arrayOf("N", 144),
                arrayOf("O", 143),
                arrayOf("P", 137),
                arrayOf("Q", 134),
                arrayOf("R", 118),
                arrayOf("S", 118),
                arrayOf("T", 117)
            ))

        val aaOptions: AAOptions = AAOptions()
            .chart(AAChart()
                .type(AAChartType.Bar)
                .scrollablePlotArea(
                    AAScrollablePlotArea()
                        .minHeight(900)
                ))
            .title(AATitle()
                .text("Speed per Character"))
            .subtitle(AASubtitle()
                .text(pureJSStr))
            .xAxis(AAXAxis()
                .type("category"))
            .series(arrayOf(element))

        binding.barChart.aa_drawChartWithChartOptions(aaOptions)

    }


}