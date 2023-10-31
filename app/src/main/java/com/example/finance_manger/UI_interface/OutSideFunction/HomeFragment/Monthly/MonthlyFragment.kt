package com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment.Monthly

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.finance_manger.R
import com.example.finance_manger.databinding.FragmentMonthlyBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter

private lateinit var binding: FragmentMonthlyBinding

class MonthlyFragment : Fragment() {

    private lateinit var binding: FragmentMonthlyBinding
    private var isIncomeClicked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMonthlyBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val barChart = binding.barChart

        // Create a list of bar entries for 30 days
        val entries = mutableListOf<BarEntry>()
        for (day in 1..30) {
            val randomValue = (100000..500000).random().toFloat() // Generate a random value between 100,000 and 999,000
            entries.add(BarEntry(day.toFloat(), randomValue).apply { data = "Day $day" })
        }

        // Create a bar data set with the entries and a label
        val barDataSet = BarDataSet(entries, "Days")
        barDataSet.color = ContextCompat.getColor(requireContext(), R.color.light_green) // Set the color of the bars
        barDataSet.valueTextColor = Color.BLACK // Set the color of the values
        barDataSet.valueTextSize = 10f // Set the size of the values

        // Create a custom value formatter to display the values in a readable format
        val valueFormatter = object : ValueFormatter() {
            override fun getBarLabel(barEntry: BarEntry?): String {
                return "${barEntry?.y?.toInt()} units" // Format the value as desired
            }
        }

        // Set the value formatter to the bar data set
        barDataSet.valueFormatter = valueFormatter

        // Create a bar data object and set the data set
        val barData = BarData(barDataSet)

        // Customize the appearance of the bar chart
        barChart.data = barData
        barChart.description.isEnabled = false // Disable the description label
        barChart.setDrawGridBackground(false) // Disable the grid background
        barChart.setDrawBarShadow(false) // Disable the bar shadows
        barChart.setPinchZoom(false) // Disable zooming
        barChart.setScaleEnabled(false) // Disable scaling
        barChart.setTouchEnabled(false) // Disable touch gestures
        barChart.axisLeft.isEnabled = false // Disable the left axis
        barChart.axisRight.isEnabled = false // Disable the right axis
        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM // Set the x-axis position to bottom
        barChart.xAxis.labelCount = entries.size // Set the number of x-axis labels to the number of entries
        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(entries.map { it.data as String }) // Set the x-axis labels to the entry labels

        // Animate the chart
        barChart.animateY(1000, Easing.EaseInOutQuad)

        // Set a legend for the chart
        val legend = barChart.legend
        legend.isEnabled = true
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        legend.orientation = Legend.LegendOrientation.VERTICAL
        legend.setDrawInside(false)
    }
}
