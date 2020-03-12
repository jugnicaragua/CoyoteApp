package ni.jugnicaragua.coyoteapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ni.jugnicaragua.coyoteapp.model.Root
import ni.jugnicaragua.coyoteapp.repository.ComercialBanksRepository
import ni.jugnicaragua.coyoteapp.util.UseCaseResult
import kotlin.coroutines.CoroutineContext

class BanksViewModel(private val repository: ComercialBanksRepository): ViewModel(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val mRootLiveData = MutableLiveData<Root>()
    val rootLiveData get() = mRootLiveData

    fun loadFacts() {
        launch {
            try {
                mRootLiveData.value = UseCaseResult.Success(repository.getFacts())
            } catch (e: Exception) {
                mRootLiveData.value = UseCaseResult.Error
            }
        }
    }

    fun insertFacts(data: List<FactResponse.All>) {
        launch {
            repository.insertFacts(data)
        }
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}