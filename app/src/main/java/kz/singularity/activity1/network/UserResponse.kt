package kz.singularity.activity1.network

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val id: Int,
    val name: String,
    val email: String,
    @SerializedName("AVATAR", alternate = ["avatar", "a_vatar"]) val avatar: String,

)