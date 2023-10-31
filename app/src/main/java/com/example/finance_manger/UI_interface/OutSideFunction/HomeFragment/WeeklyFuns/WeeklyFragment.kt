package com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment.WeeklyFuns

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.finance_manger.R
import com.example.finance_manger.databinding.FragmentWeeklyBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter

class WeeklyFragment : Fragment() {

    private lateinit var binding: FragmentWeeklyBinding
    private var isIncomeClicked = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeeklyBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val barChart = binding.barChart

        // Create a list of bar entries
        val entries = listOf(
            BarEntry(0f, 740000f, "Du"),
            BarEntry(1f, 250000f, "Sh"),
            BarEntry(2f, 170000f, "Ch"),
            BarEntry(3f, 350000f, "Pa"),
            BarEntry(4f, 1000000f, "Ju"),
            BarEntry(5f, 200000f, "Sh"),
            BarEntry(6f, 800000f, "Ya")
        )

        // Create a bar data set with the entries and a label
        val barDataSet = BarDataSet(entries, "Weekdays")
        barDataSet.color = ContextCompat.getColor(requireContext(), R.color.light_green) // Set the color of the bars
        barDataSet.valueTextColor = Color.BLACK // Set the color of the values
        barDataSet.valueTextSize = 10f // Set the size of the values

        // Create a custom value formatter to display the values in a readable format
        val valueFormatter = object : ValueFormatter() {
            override fun getBarLabel(barEntry: BarEntry?): String {
                return when (barEntry?.y!!) {
                    1000000f -> "1mln" // If the value is 1 million, return "1m"
                    in 0f..999999f -> "${barEntry?.y?.toInt()?.div(1000)}k" // If the value is less than 1 million, return it in thousands with "k"
                    else -> "" // Otherwise, return an empty string
                }
            }
        }

        // Set the value formatter to the bar data set
        barDataSet.valueFormatter = valueFormatter

        // Create a bar data object with the data set
        val barData = BarData(barDataSet)
        barData.barWidth = 0.5f // Set the width of the bars

        // Set the data to the bar chart and invalidate it
        barChart.data = barData
        barChart.invalidate()

        // Customize the appearance of the bar chart
        barChart.description.isEnabled = false // Disable the description text
        barChart.setPinchZoom(false) // Disable zooming with pinch gesture
        barChart.setTouchEnabled(false) // Disable touch interaction
        barChart.setDrawGridBackground(false) // Disable grid background
        barChart.setDrawBorders(false) // Disable borders

        // Customize the x-axis of the bar chart
        val xAxis = barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM // Set the position of the x-axis to bottom
        xAxis.setDrawGridLines(false) // Disable grid lines
        xAxis.setDrawAxisLine(false) // Disable axis line
        xAxis.granularity = 1f // Set the granularity to 1
        xAxis.labelCount = 7 // Set the label count to 7
        xAxis.textSize = 12f // Set the text size to 12
        xAxis.textColor = Color.BLACK // Set the text color to black

        // Create a list of labels for the x-axis
        val labels = listOf("Mon", "Tue", "Wed", "Thu", "Fri","Sat","Sun")

        // Create a custom axis value formatter to display the labels
        val axisValueFormatter = object : IndexAxisValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return labels[value.toInt()] // Return the label at the given index
            }
        }

        // Set the axis value formatter to the x-axis
        xAxis.valueFormatter = axisValueFormatter

        // Customize the left axis of the bar chart
        val leftAxis = barChart.axisLeft
        leftAxis.isEnabled = false // Disable the left axis

        // Customize the right axis of the bar chart
        val rightAxis = barChart.axisRight
        rightAxis.isEnabled = false // Disable the right axis

        // Customize the legend of the bar chart
        val legend = barChart.legend
        legend.isEnabled = false // Disable the legend

        val income = binding.incomeButton
        val outcome = binding.outcomeButton

        val textOutcome = binding.textOutcome
        val count_of_outcome = binding.countOfOutcome
        val textValyutaOut = binding.textValyutaOut

        val textValyutaIn = binding.textValyutaIn
        val countOfIncome = binding.countOfIncome
        val textIncome = binding.textIncome

        outcome.setOnClickListener {
            outcome.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
            outcome.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.background_rectangle_15dp_red
                )
            )
            income.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.background_rectangle_15dp
                )
            )

            count_of_outcome.setTextColor(Color.WHITE)
            textOutcome.setTextColor(Color.WHITE)
            textValyutaOut.setTextColor(Color.WHITE)

            textIncome.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
            countOfIncome.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_green))
            textValyutaIn.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_green))

            isIncomeClicked = false
        }

        income.setOnClickListener {
            income.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_green))
            income.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.background_rectangle_15dp_green
                )
            )
            outcome.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.background_rectangle_15dp
                )
            )

            countOfIncome.setTextColor(Color.WHITE)
            textIncome.setTextColor(Color.WHITE)
            textValyutaIn.setTextColor(Color.WHITE)

            textOutcome.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
            count_of_outcome.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
            textValyutaOut.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))

            isIncomeClicked = true

            if (isIncomeClicked) {
                countOfIncome.text = "25000"
            } else {
                count_of_outcome.text = "25000"

            }

        }

    }

}
