package com.example.finance_manger

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.finance_manger.UI_interface.IntoBottomNav.AccountFragment
import com.example.finance_manger.UI_interface.IntoBottomNav.EducationFragment
import com.example.finance_manger.UI_interface.IntoBottomNav.GoalsFragment
import com.example.finance_manger.UI_interface.IntoBottomNav.HomeFragment
import com.example.finance_manger.databinding.ActivityStartBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

// Код в активности/фрагменте
class StartActivity : AppCompatActivity() {

    lateinit var binding: ActivityStartBinding

    lateinit var bottomNavigationView: BottomNavigationView


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    // Переход на фрагмент Home
//                    val fragment = HomeFragment.newInstance
                   val  homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, homeFragment, "Home")
                        .commit()
                    // Установка filled иконки для элемента Home
                    item.setIcon(R.drawable.ic_home_filled)
                    // Установка outlined иконок для остальных элементов
                    setOutlinedIconsForOtherItems(item.itemId)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.menu_competition -> {
                    // Переход на фрагмент Competition
                    val goalsFragment = GoalsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, goalsFragment, "Competition")
                        .commit()
                    // Установка filled иконки для элемента Competition
                    item.setIcon(R.drawable.ic_competition_filled)
                    // Установка outlined иконок для остальных элементов
                    setOutlinedIconsForOtherItems(item.itemId)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.menu_education -> {
                    // Переход на фрагмент Education
                    val educationFragment = EducationFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, educationFragment, "Education")
                        .commit()
                    // Установка filled иконки для элемента Education
                    item.setIcon(R.drawable.ic_education_filled)
                    // Установка outlined иконок для остальных элементов
                    setOutlinedIconsForOtherItems(item.itemId)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.menu_account -> {
                    // Переход на фрагмент Account
                    val accountFragment = AccountFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, accountFragment, "Account")
                        .commit()
                    // Установка filled иконки для элемента Account
                    item.setIcon(R.drawable.ic_account_filled)
                    // Установка outlined иконок для остальных элементов
                    setOutlinedIconsForOtherItems(item.itemId)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.bottom_navigation)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val menuItems = intArrayOf(R.id.menu_home)

        for (itemId in menuItems) {
            bottomNavigationView.postDelayed({
                bottomNavigationView.selectedItemId = itemId
            }, 10) // Задержка в миллисекундах перед нажатием на следующий элемент
        }


        // Выбор первого элемента меню и клик по нему
        bottomNavigationView.menu.getItem(0).isChecked = true
        bottomNavigationView.menu.getItem(0).setOnMenuItemClickListener { item ->
            false
        }.itemId


        // Изменение цвета элементов внутри status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window: Window = window
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = ContextCompat.getColor(this, R.color.background_ui)
        }

        // Делаем линие вверху BottomNav
        val myView: View = findViewById(R.id.my_view)
        myView.elevation = resources.getDimension(R.dimen.my_elevation)


        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun setOutlinedIconsForOtherItems(selectedItemId: Int) {
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val menu = navView.menu

        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            if (menuItem.itemId != selectedItemId) {
                // Установка outlined иконок для неактивных элементов
                when (menuItem.itemId) {
                    R.id.menu_home -> menuItem.setIcon(R.drawable.ic_home_outlined)
                    R.id.menu_competition -> menuItem.setIcon(R.drawable.ic_competition_outlined)
                    R.id.menu_education -> menuItem.setIcon(R.drawable.ic_education_outlined)
                    R.id.menu_account -> menuItem.setIcon(R.drawable.ic_account_outlined)
                }
            }
        }
    }
}
