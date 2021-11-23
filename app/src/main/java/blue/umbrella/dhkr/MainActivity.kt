package blue.umbrella.dhkr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import blue.umbrella.dhkr.Adapter.MySliderAdapter
import blue.umbrella.dhkr.Dhikrs.DailyDhikr
import blue.umbrella.dhkr.Dhikrs.Qauliyah_Dhikr
import blue.umbrella.dhkr.Quran.Surah
import blue.umbrella.dhkr.databinding.ActivityMainBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageSlider = findViewById<SliderView>(R.id.imageSlider)
        val imageSliderList: ArrayList<Int> = ArrayList()

        imageSliderList.add(R.drawable.article1)
        imageSliderList.add(R.drawable.article2)
        imageSliderList.add(R.drawable.article3)

        setImageInSlider(imageSliderList, imageSlider)
        imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)

        binding.qauliyahDhikr.setOnClickListener {
            startActivity(Intent(this, Qauliyah_Dhikr::class.java))
        }

        binding.dailyDhikr.setOnClickListener {
            startActivity(Intent(this, DailyDhikr::class.java))
        }

        binding.generalDhikr.setOnClickListener {
            startActivity(Intent(this, Qauliyah_Dhikr::class.java))
        }

        binding.qibla.setOnClickListener {
            startActivity(Intent(this, Qauliyah_Dhikr::class.java))
        }

        binding.readQuran.setOnClickListener {
            startActivity(Intent(this, Surah::class.java))
        }

    }

    private fun setImageInSlider(images: ArrayList<Int>, imageSlider: SliderView) {
        val adapter = MySliderAdapter()
        adapter.reNewItems(images)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()
    }
}