package blue.umbrella.dhkr.Quran

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import blue.umbrella.dhkr.Adapter.SurahAdapter
import blue.umbrella.dhkr.Data.Quran.Network.Config
import blue.umbrella.dhkr.Data.Quran.Network.SurahList
import blue.umbrella.dhkr.MainActivity
import blue.umbrella.dhkr.databinding.ActivitySurahBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Surah : AppCompatActivity() {

    private lateinit var binding : ActivitySurahBinding
    private val mAdapter by lazy { SurahAdapter() }
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this@Surah)
        progressDialog.setTitle("Loading")
        progressDialog.setCanceledOnTouchOutside(false)

        progressDialog.setMessage("Loading")
        progressDialog.show()

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.run {
            rvSurah.apply {
                layoutManager = LinearLayoutManager(this@Surah)
                setHasFixedSize(true)
                adapter = mAdapter
            }
            val call = Config.getService().getSurah()
            call.enqueue(object : Callback<SurahList>{

                override fun onResponse(
                    call: Call<SurahList>,
                    response: Response<SurahList>
                ) {

                    progressDialog.dismiss()

                    response.body()?.data?.let {
                        mAdapter.addData(it)
                    }
                }

                override fun onFailure(
                    call: Call<SurahList>,
                    t: Throwable
                ) {

                    progressDialog.dismiss()

                    Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG).show()
                }

            })
        }
    }
}