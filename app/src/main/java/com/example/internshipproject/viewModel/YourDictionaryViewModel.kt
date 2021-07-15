package com.example.internshipproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshipproject.network.response.get.WordData
import com.example.internshipproject.repository.YourDictionaryRepository
import com.example.internshipproject.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YourDictionaryViewModel : ViewModel() {
    private val repository = YourDictionaryRepository()

    /** livedata for updating the components of android which are observing it **/
    private val _wordResponse = MutableLiveData<Result<WordData>>()

    val wordResponse: LiveData<Result<WordData>> = _wordResponse


    fun getWordData() {
        viewModelScope.launch(Dispatchers.IO) {
            _wordResponse.postValue(repository.getNewWord())
        }
    }


}