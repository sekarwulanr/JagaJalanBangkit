package com.example.data.source.network.api

import com.example.data.source.network.response.*
import com.example.domain.model.Laporan
import com.google.gson.internal.LinkedHashTreeMap
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("./accounts:signInWithPassword")
    suspend fun login(@Query("key") key : String, @Body loginRequest: LoginRequest) : Response<LoginResponse>

    @GET("users")
    suspend fun getUsers(@Header("Authorization") token : String) : String

    @POST("laporans")
    suspend fun createLaporan(@Header("Authorization") token: String, @Body laporan : Laporan) : Response<LaporanResponse>

    @POST("token")
    suspend fun reLogin(refreshToken : String, grant_type : String = "refresh_token") : Response<ReauthResponse>

    @GET("laporan_user")
    suspend fun getUserLaporans(@Header("Authorization") token : String) : UserLaporanListResponse

}

