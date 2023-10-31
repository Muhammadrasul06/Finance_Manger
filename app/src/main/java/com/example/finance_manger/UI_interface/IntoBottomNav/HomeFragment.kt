package com.example.finance_manger.UI_interface.IntoBottomNav

import android.graphics.Color
import android.icu.util.Calendar
import android.os.Bundle
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
import androidx.fragment.app.Fragment
import com.example.finance_manger.R
import com.example.finance_manger.StartActivity
import com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment.DailyFuns.DailyFragment
import com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment.HistoryFragment
import com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment.Monthly.MonthlyFragment
import com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment.NotificationFragment
import com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment.SettingsFragment
import com.example.finance_manger.UI_interface.OutSideFunction.HomeFragment.WeeklyFuns.WeeklyFragment
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.GregorianCalendar
import java.util.Locale


class HomeFragment : Fragment() {

    private lateinit var item1: TextView
    private lateinit var item2: TextView
    private lateinit var item3: TextView
    private lateinit var select: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val toolbar: Toolbar = view.findViewById(R.id.toolBar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val Settings = view.findViewById<LinearLayout>(R.id.imageSettings)
        val Notification = view.findViewById<ImageView>(R.id.amd_imageNotification)
        val History = view.findViewById<ImageView>(R.id.amd_imageHistory)
        val Calendar = view.findViewById<ImageView>(R.id.amd_imageCalendar)

        val leftButton = view.findViewById<ImageView>(R.id.leftButton)
        val rightButton = view.findViewById<ImageView>(R.id.rightButton)



        (activity as StartActivity).bottomNavigationView.visibility = View.VISIBLE

        Settings.setOnClickListener {
            val settingsFragment = SettingsFragment()
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, settingsFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }

        Notification.setOnClickListener {
            val notificationFragment = NotificationFragment()
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, notificationFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        History.setOnClickListener {
            val historyFragment = HistoryFragment()
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, historyFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }




        item1 = view.findViewById(R.id.item1)
        item2 = view.findViewById(R.id.item2)
        item3 = view.findViewById(R.id.item3)
        select = view.findViewById(R.id.sellect)


        item1.setOnClickListener {
            selectItem(0)
            showFragment(DailyFragment())
            selectItem(item1)
            Toast.makeText(requireContext(), "1", Toast.LENGTH_SHORT).show()
        }
        item2.setOnClickListener {
            selectItem(1)
            showFragment(WeeklyFragment())
            selectItem(item2)
        }
        item3.setOnClickListener {
            selectItem(2)
            selectItem(item3)

            showFragment(MonthlyFragment())
        }

        // Показать фрагмент по умолчанию при первом запуске приложения
        if (savedInstanceState == null) {
            selectItem(1)
            selectItem(item2)
            showFragment(WeeklyFragment())
        }


        return view
    }
    fun showWeek(week: Int) {
        val c = GregorianCalendar.getInstance()
        c.firstDayOfWeek = Calendar.MONDAY
        c.set(Calendar.DAY_OF_WEEK, c.firstDayOfWeek)
        c.add(Calendar.DAY_OF_WEEK, week)
        val df = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        var startDate: String
        var endDate: String
        startDate = df.format(c.time)
        c.add(Calendar.DAY_OF_MONTH, 6)
        endDate = df.format(c.time)
        println("Start Date = $startDate")
        println("End Date = $endDate")
    }


    // Метод для выбора активного элемента
    fun selectItem(selectedItem: TextView) {
        // Сбрасываем внешний вид всех элементов списка
        item1.setBackgroundResource(0)
        item2.setBackgroundResource(0)
        item3.setBackgroundResource(0)

        // Устанавливаем внешний вид активного элемента
        selectedItem.setBackgroundResource(R.drawable.back_sellect)

        // Обновляем отображение элементов списка
        item1.invalidate()
        item2.invalidate()
        item3.invalidate()
    }

    private fun selectItem(position: Int) {
        select.animate().x((position * item2.width).toFloat()).setDuration(100)
        item1.setTextColor(
            if (position == 0) ContextCompat.getColor(
                requireContext(),
                R.color.dark_green
            ) else Color.BLACK
        )
        item2.setTextColor(
            if (position == 1) ContextCompat.getColor(
                requireContext(),
                R.color.dark_green
            ) else Color.BLACK
        )
        item3.setTextColor(
            if (position == 2) ContextCompat.getColor(
                requireContext(),
                R.color.dark_green
            ) else Color.BLACK
        )
    }

    private fun showFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerIntofFragment, fragment)
        fragmentTransaction.commit()
    }
}

