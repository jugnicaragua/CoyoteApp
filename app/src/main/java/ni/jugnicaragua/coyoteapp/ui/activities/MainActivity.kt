package ni.jugnicaragua.coyoteapp.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import ni.jugnicaragua.coyoteapp.R
import ni.jugnicaragua.coyoteapp.data.local.database.dao.BanksDao
import ni.jugnicaragua.coyoteapp.model.banks.Banks
import ni.jugnicaragua.coyoteapp.ui.viewModel.CountryViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val homeViewModel: CountryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBackdrop()
        homeViewModel.uiState.observe(this, Observer {
            println(it)
        })
        homeViewModel.requestCountry()
        homeViewModel.demo()
    }

    private fun initBackdrop() {
        backdrop_layout.apply {
            frontSheet = front_layer
            duration = 200
            revealHeight = 200
        }.toggleBackdrop()
    }

}