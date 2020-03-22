package ni.jugnicaragua.coyoteapp.ui.activities

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import kotlinx.android.synthetic.main.activity_main.*
import ni.jugnicaragua.coyoteapp.R
import ni.jugnicaragua.coyoteapp.imageloader.ImageLoader
import ni.jugnicaragua.coyoteapp.ui.adapter.ExchangeRateAdapter
import ni.jugnicaragua.coyoteapp.ui.viewModel.CentralBankViewModel
import ni.jugnicaragua.coyoteapp.ui.viewModel.ExchangeRateBanksViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var skeleton: Skeleton
    private val imageLoader: ImageLoader by inject()
    private val exchangeRateBanksViewModel: ExchangeRateBanksViewModel by viewModel()
    private val centralBankViewModel: CentralBankViewModel by viewModel()
    private val recyclerView: RecyclerView by lazy { rv_exchanges_rates }
    private val exchangeRateAdapter: ExchangeRateAdapter by lazy { ExchangeRateAdapter(imageLoader) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = exchangeRateAdapter
        }
        setupSkeleton()
        initBackdrop()
        centralBankViewModel.uiState.observe(this, Observer {
            val dataState = it ?: return@Observer
            if (dataState.result != null && !dataState.result.consumed){
                dataState.result.consume()?.let { result ->
                    txtExchangeValue.text = "C$ ${result.amount}"
                }
            }
            if (dataState.error != null && !dataState.error.consumed){
                dataState.error.consume()?.let { error ->
                    Toast.makeText(applicationContext, resources.getString(error), Toast.LENGTH_LONG).show()
                }
            }
        })
        exchangeRateBanksViewModel.uiState.observe(this, Observer {
            val dataState = it ?: return@Observer
            if (!dataState.showProgress)displayHideSkeleton(hide = true) else displayHideSkeleton(hide = false)
            if (dataState.result != null && !dataState.result.consumed){
                dataState.result.consume()?.let { result ->
                    exchangeRateAdapter.submitList(result)
                }
            }
            if (dataState.error != null && !dataState.error.consumed){
                dataState.error.consume()?.let { error ->
                    Toast.makeText(applicationContext, resources.getString(error), Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        exchangeRateBanksViewModel.requestExchangeRateToday()
        centralBankViewModel.requestCentralBankExchangeToday()
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        println("REENTER")
    }

    private fun displayHideSkeleton(hide: Boolean = false){
        if(hide) {
            if (skeleton.isSkeleton()) skeleton.showOriginal()
        } else skeleton.showSkeleton()
    }

    private fun setupSkeleton(){
        skeleton = rv_exchanges_rates.applySkeleton(R.layout.banks_card, 6)
        skeleton.apply {
            showShimmer = true
            shimmerDurationInMillis = 900
            maskCornerRadius = 1f
            maskColor = ContextCompat.getColor(this@MainActivity, R.color.colorPrimaryLight)
        }
    }

    private fun initBackdrop() {
        backdrop_layout.apply {
            frontSheet = front_layer
            duration = 200
            revealHeight = 150
        }.toggleBackdrop()
    }

}