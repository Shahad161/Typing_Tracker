package com.example.typing_tracker.util

import android.text.Html
import android.view.View
import android.widget.*
import androidx.databinding.*
import com.github.aachartmodel.aainfographics.aachartcreator.*
import com.github.aachartmodel.aainfographics.aaoptionsmodel.*
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer


@BindingAdapter(value = ["app:selectedValue"])
fun selectedItem(view: Spinner, item: Difficulty?) {
    if (view.selectedItem?.toString() != item.toString()) {
        view.setSelection(view.getSelectedIndex(item))
    }
}


@InverseBindingAdapter(attribute = "selectedValue", event = "SpinnerOnItemSelected")
fun captureSelectedValue(view: Spinner): Difficulty {
    return view.selectedItem.toString().toDifficulty()
}


@BindingAdapter("SpinnerOnItemSelected")
fun setSelectedListener(view: Spinner, changeListener: InverseBindingListener) {
    view.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            changeListener.onChange()
        }
        override fun onNothingSelected(p0: AdapterView<*>?) {}
    }
}

@BindingAdapter(value = ["app:setParagraph"])
fun setParagraph(view :TextView , paragraph:String?){
    paragraph?.let {
        view.text =Html.fromHtml(it,Html.FROM_HTML_MODE_LEGACY)
    }
}

@BindingAdapter(value = ["app:startCounter"])
fun startCounter(view: Chronometer , isBegin: Boolean){
    if(isBegin) {
        view.start()
    }
}

@BindingAdapter(value = ["app:data", "app:legendTitle", "app:chartType", "app:title"])
fun setupChart(chart: AAChartView,
               data: Array<Any>?,
               legendTitle: String?,
               chartType: AAChartType?,
               chartTitle: String?

) {

    val element = AASeriesElement()
    data?.let {
        element
        .name(legendTitle)
        .data(data)

    }

    val aaOptions: AAOptions = AAOptions()
        .chart(
            AAChart()
                .type(chartType)
                .scrollablePlotArea(
                    AAScrollablePlotArea()
                        .minWidth(500)
                )
        )
        .title(
            AATitle()
                .text(chartTitle))
        .xAxis(
            AAXAxis()
                .type("category"))
        .series(arrayOf(element))

    chart.aa_drawChartWithChartOptions(aaOptions)
}