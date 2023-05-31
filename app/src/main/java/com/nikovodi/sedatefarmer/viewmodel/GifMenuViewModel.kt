package com.nikovodi.sedatefarmer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nikovodi.sedatefarmer.data.PasteApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class GifMenuViewModel(
    private val api: PasteApi
) : BaseViewModel() {

    private val url = MutableLiveData<String>()

    init {
        api.getUrl()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                url.value = it.url
            }, {
                url.value = "ERROR, NO INTERNET"
            })
            .autoDispose()
    }

    fun getLink(): LiveData<String> = url
}