package com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.finance_manger.R
import com.example.finance_manger.StartActivity


class SettingsFragment : Fragment() {

    private var isIncomeClicked = false


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val backButton = view.findViewById<ImageView>(R.id.back_button)

        (activity as StartActivity).bottomNavigationView.visibility = View.GONE

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val income = view.findViewById<LinearLayout>(R.id.income_button)
        val outcome = view.findViewById<LinearLayout>(R.id.outcome_button)

        val textOutcome = view.findViewById<TextView>(R.id.text_outcome)

        val textIncome = view.findViewById<TextView>(R.id.text_income)

        outcome.setOnClickListener {
            outcome.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
            outcome.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.background_rectangle_side_red_15dp
                )
            )
            income.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.background_rectangle_side_left_15dp
                )
            )

            textOutcome.setTextColor(Color.WHITE)

            textIncome.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
            isIncomeClicked = false
        }

        income.setOnClickListener {
            income.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_green))
            income.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.background_rectangle_side_green_15dp
                )
            )
            outcome.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.background_rectangle_side_right_15dp
                )
            )

            textIncome.setTextColor(Color.WHITE)

            textOutcome.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))

            isIncomeClicked = true


        }

        return view
    }



}

