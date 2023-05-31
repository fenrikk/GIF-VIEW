package com.nikovodi.sedatefarmer.data

import com.nikovodi.sedatefarmer.data.model.PasteResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PasteApi {
    @GET("/raw/ezLEttdv")
    fun getUrl(): Single<PasteResponse>
}