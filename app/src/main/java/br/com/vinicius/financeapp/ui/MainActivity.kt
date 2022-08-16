package br.com.vinicius.financeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.vinicius.financeapp.R
import br.com.vinicius.financeapp.databinding.ActivityMainBinding
import br.com.vinicius.financeapp.ui.adapter.TabsPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { TabsPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navCtrl = findNavController(R.id.fragmentContainerView)
        binding.bnvMenu.setupWithNavController(navCtrl)
    }



}