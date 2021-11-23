package blue.umbrella.dhkr.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import blue.umbrella.dhkr.Adapter.DhikrAdapter
import blue.umbrella.dhkr.Data.Dhikr.Dhikr
import blue.umbrella.dhkr.Data.Dhikr.DhikrData
import blue.umbrella.dhkr.databinding.ActivityMorningDhikrBinding

class MorningDhikr : AppCompatActivity() {

    private lateinit var binding : ActivityMorningDhikrBinding
    private var listMorningDhikr: ArrayList<Dhikr> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMorningDhikrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        listMorningDhikr.clear()
        listMorningDhikr.addAll(DhikrData.listDzikirPagi)

        binding.rvMorning.layoutManager = LinearLayoutManager(this)
        binding.rvMorning.setHasFixedSize(true)
        binding.rvMorning.adapter = DhikrAdapter(listMorningDhikr)

    }
}