package blue.umbrella.dhkr.Data.Quran.Network

import blue.umbrella.dhkr.Data.Quran.Network.SurahList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface SurahAPI {

    @GET("surah")
    fun getSurah(): Call<SurahList>

}