package com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment.DailyFuns

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.finance_manger.R
import com.example.finance_manger.databinding.FragmentDailyBinding

private lateinit var binding: FragmentDailyBinding

class DailyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDailyBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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


        }

    }
}
