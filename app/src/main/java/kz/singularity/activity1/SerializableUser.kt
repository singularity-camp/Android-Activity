package kz.singularity.activity1

data class SerializableUser(
    val name: String,
    val age: Int,
    val isMale: Boolean,
    val height: Double
) : java.io.Serializable