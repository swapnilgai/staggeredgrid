package java.com.staggeredgrid.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

data class PhotoData(
  val albumId: Int?,
  val id: Int?,
  val title: String?,
  val url: String?,
  val thumbnailUrl: String?
) : Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString(),
    parcel.readString(),
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(albumId)
    parcel.writeValue(id)
    parcel.writeString(title)
    parcel.writeString(url)
    parcel.writeString(thumbnailUrl)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<PhotoData> {
    override fun createFromParcel(parcel: Parcel): PhotoData {
      return PhotoData(parcel)
    }

    override fun newArray(size: Int): Array<PhotoData?> {
      return arrayOfNulls(size)
    }
  }
}