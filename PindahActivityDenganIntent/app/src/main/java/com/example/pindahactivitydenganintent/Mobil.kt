package com.example.pindahactivitydenganintent

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mobil(
    val merk: String?,
    val tahun: Int,
    val plat: String?
): Parcelable /*{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(merk)
        parcel.writeInt(tahun)
        parcel.writeString(plat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mobil> {
        override fun createFromParcel(parcel: Parcel): Mobil {
            return Mobil(parcel)
        }

        override fun newArray(size: Int): Array<Mobil?> {
            return arrayOfNulls(size)
        }
    }
}*/