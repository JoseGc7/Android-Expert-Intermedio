package com.josegc7.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josegc7.horoscapp.domain.model.HoroscopeModel
import com.josegc7.horoscapp.domain.model.PredictionModel
import com.josegc7.horoscapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase):ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope: HoroscopeModel
    fun getHoroscope(sign:HoroscopeModel){
        horoscope = sign
        viewModelScope.launch {
            // Hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result: PredictionModel? =  withContext(Dispatchers.IO){getPredictionUseCase(sign.name)} // Hilo secundario
            if (result != null){
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            }else{
                _state.value = HoroscopeDetailState.Error("Ha ocurrido un error, intentelo mas tarde")
            }
        }
    }
}