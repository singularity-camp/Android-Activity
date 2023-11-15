package kz.singularity.activity1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParcelableUser(
    val name: String,
    val age: Int,
    val isMale: Boolean,
    val height: Double
) : Parcelable