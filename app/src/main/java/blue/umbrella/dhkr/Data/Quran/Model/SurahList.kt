package blue.umbrella.dhkr.Data.Quran.Network

import com.google.gson.annotations.SerializedName

data class SurahList(

	@field:SerializedName("data")
	val data: List<DataItem>? = null
)

data class DataItem(

	@field:SerializedName("translationId")
	val translationId: String? = null,

	@field:SerializedName("translationEn")
	val translationEn: String? = null,

	@field:SerializedName("asma")
	val asma: String? = null,

	@field:SerializedName("numberOfAyahs")
	val numberOfAyahs: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("typeId")
	val typeId: String? = null,

	@field:SerializedName("typeEn")
	val typeEn: String? = null,

	@field:SerializedName("orderNumber")
	val orderNumber: Int? = null

)
