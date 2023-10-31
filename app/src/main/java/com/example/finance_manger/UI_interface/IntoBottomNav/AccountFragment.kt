package com.example.finance_manger.UI_interface.IntoBottomNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finance_manger.R

// Код в фрагменте AccountFragment
class AccountFragment : Fragment() {

    companion object {
        fun newInstance(): AccountFragment {
            return AccountFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Код для создания макета фрагмента Account
        val view = inflater.inflate(R.layout.fragment_account, container, false)
        return view
    }
}