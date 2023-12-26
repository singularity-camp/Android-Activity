package kz.singularity.activity1.network

import retrofit2.http.GET

interface ApiService {

    @GET("users") // будем получать отсюда https://5e510330f2c0d300147c034c.mockapi.io/users
    suspend fun getUsers(): List<UserResponse>

}