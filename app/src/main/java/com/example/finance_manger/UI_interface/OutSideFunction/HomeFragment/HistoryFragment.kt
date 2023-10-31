package com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment

import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.finance_manger.R
import com.example.finance_manger.StartActivity

class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        val toolbar: Toolbar = view.findViewById(R.id.toolBar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val backButton = view.findViewById<ImageView>(R.id.back_button)

        (activity as StartActivity).bottomNavigationView.visibility = View.GONE

        // Get the current month
        val calendar = Calendar.getInstance()
        val currentMonth = calendar.get(Calendar.MONTH)

// Get the name of the current month
        val monthNames = arrayOf(
            "Yanvar", "Fevral", "Mart", "Aprel", "May", "Iyun",
            "Iyul", "Avgust", "Sentabr", "Oktabr", "Noyabr", "Dekabr"
        )
        val currentMonthName = monthNames[currentMonth]

// Update the TextView with the name of the current month
        val monthTextView = view.findViewById<TextView>(R.id.NameOfTheMonth)
        monthTextView.text = currentMonthName

// Set onClickListeners for the left and right buttons
        val leftButton = view.findViewById<ImageView>(R.id.leftButton)
        val rightButton = view.findViewById<ImageView>(R.id.rightButton)

        leftButton.setOnClickListener {
            // Get the previous month
            calendar.add(Calendar.MONTH, -1)
            val previousMonth = calendar.get(Calendar.MONTH)

            // Get the name of the previous month
            val previousMonthName = monthNames[previousMonth]

            // Update the TextView with the name of the previous month
            monthTextView.text = previousMonthName
        }

        rightButton.setOnClickListener {
            // Get the next month
            calendar.add(Calendar.MONTH, 1)
            val nextMonth = calendar.get(Calendar.MONTH)

            // Get the name of the next month
            val nextMonthName = monthNames[nextMonth]

            // Update the TextView with the name of the next month
            monthTextView.text = nextMonthName
        }


        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }


}
