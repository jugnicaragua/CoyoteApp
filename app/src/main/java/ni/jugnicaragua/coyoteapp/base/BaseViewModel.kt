package ni.jugnicaragua.coyoteapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import ni.jugnicaragua.coyoteapp.util.Failure
import ni.jugnicaragua.coyoteapp.util.NetworkState

abstract class BaseViewModel : ViewModel() {

    private val _errorObserver = MutableLiveData<Failure>()
    val errorObserver: LiveData<Failure> get() = _errorObserver

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

    val handler = CoroutineExceptionHandler { _, ex ->
        _networkState.postValue(NetworkState.error(ex.message ?: "Unknown Error"))
    }

}