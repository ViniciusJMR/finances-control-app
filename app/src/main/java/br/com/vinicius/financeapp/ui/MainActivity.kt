package br.com.vinicius.financeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.com.vinicius.financeapp.R
import br.com.vinicius.financeapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navCtrl = findNavController(R.id.fragmentContainerView)
        binding.bnvMenu.setupWithNavController(navCtrl)
    }


}