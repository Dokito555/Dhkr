package blue.umbrella.dhkr.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import blue.umbrella.dhkr.Adapter.DhikrAdapter
import blue.umbrella.dhkr.Data.Dhikr.Dhikr
import blue.umbrella.dhkr.Data.Dhikr.DhikrData
import blue.umbrella.dhkr.databinding.ActivityNightDhikrBinding

class NightDhikr : AppCompatActivity() {

    private lateinit var binding: ActivityNightDhikrBinding
    private var listEveningDhikr: ArrayList<Dhikr> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNightDhikrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        listEveningDhikr.clear()
        listEveningDhikr.addAll(DhikrData.listDzikirPetang)

        binding.rvNight.layoutManager = LinearLayoutManager(this)
        binding.rvNight.adapter = DhikrAdapter(listEveningDhikr)
        binding.rvNight.setHasFixedSize(true)

    }
}