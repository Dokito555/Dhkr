package blue.umbrella.dhkr.Dhikrs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import blue.umbrella.dhkr.Detail.MorningDhikr
import blue.umbrella.dhkr.Detail.NightDhikr
import blue.umbrella.dhkr.databinding.ActivityDailyDhikrBinding

class DailyDhikr : AppCompatActivity() {

    private lateinit var binding: ActivityDailyDhikrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyDhikrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        binding.eveningDhikr.setOnClickListener {
            startActivity(Intent(this, NightDhikr::class.java))
        }

        binding.morningDhikr.setOnClickListener {
            startActivity(Intent(this, MorningDhikr::class.java))
        }

    }
}