package blue.umbrella.dhkr.Data.Quran.Network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Config {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit
        .Builder()
        .baseUrl("https://quranapi.idn.sch.id/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(SurahAPI::class.java)
}