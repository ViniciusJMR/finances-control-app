package br.com.vinicius.financeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.vinicius.financeapp.R
import br.com.vinicius.financeapp.databinding.ActivityMainBinding
import br.com.vinicius.financeapp.ui.adapter.TabsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { TabsPagerAdapter(this) }

override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.vpMain.adapter = adapter

        /*
            FIXME Find a better way to set icon on tabs
         */
        TabLayoutMediator(binding.tlTopMenu, binding.vpMain){ tab, position ->
            when(position) {
                0 -> tab.setIcon(R.drawable.ic_home_24)
                else -> tab.setIcon(R.drawable.ic_money_24)
            }
        }.attach()
    }
}