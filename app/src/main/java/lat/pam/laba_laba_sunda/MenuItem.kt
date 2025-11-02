package lat.pam.laba_laba_sunda.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val drawableRes: Int
) : Parcelable
