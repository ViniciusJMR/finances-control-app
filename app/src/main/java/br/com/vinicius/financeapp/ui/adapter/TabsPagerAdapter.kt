package br.com.vinicius.financeapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.vinicius.financeapp.ui.GeneralIncomeFragment
import br.com.vinicius.financeapp.ui.HomeScreenFragment

class TabsPagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {
    private val PAGE_COUNT = 2

    override fun getItemCount() = PAGE_COUNT

    override fun createFragment(position: Int) = when (position) {
        0 -> HomeScreenFragment()
        else -> GeneralIncomeFragment()
    }


}