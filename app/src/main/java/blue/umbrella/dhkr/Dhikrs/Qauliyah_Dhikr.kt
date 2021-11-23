package blue.umbrella.dhkr.Dhikrs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import blue.umbrella.dhkr.Adapter.DhikrAdapter
import blue.umbrella.dhkr.Data.Dhikr.Dhikr
import blue.umbrella.dhkr.Data.Dhikr.DhikrData
import blue.umbrella.dhkr.databinding.ActivityQauliyahDhikrBinding

class Qauliyah_Dhikr : AppCompatActivity() {

    private lateinit var binding: ActivityQauliyahDhikrBinding
    private var listQauliyah: ArrayList<Dhikr> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQauliyahDhikrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        listQauliyah.clear()
        listQauliyah.addAll(DhikrData.listQauliyah)

        binding.rvQauliyah.layoutManager = LinearLayoutManager(this)
        binding.rvQauliyah.adapter = DhikrAdapter(listQauliyah)
        binding.rvQauliyah.setHasFixedSize(true)

    }
}

