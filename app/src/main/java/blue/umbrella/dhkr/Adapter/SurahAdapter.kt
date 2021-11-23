package blue.umbrella.dhkr.Adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import blue.umbrella.dhkr.Data.Quran.Network.DataItem
import blue.umbrella.dhkr.R
import blue.umbrella.dhkr.databinding.ActivityNightDhikrBinding
import blue.umbrella.dhkr.databinding.SurahModelBinding

class SurahAdapter() : RecyclerView.Adapter<SurahAdapter.ViewHolder>() {

    private val listSurah = ArrayList<DataItem>()

    fun addData(items: List<DataItem>) {
        listSurah.clear()
        listSurah.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: SurahModelBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(surah : DataItem) {
            binding.run {
                surahName.text = surah.name ?: "Surah Not Found"
                surahNum.text = surah.number.toString()
                surahAyahs.text = surah.numberOfAyahs.toString()
                surahTranslation.text = surah.translationEn
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = SurahModelBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listSurah[position])
    }

    override fun getItemCount(): Int {
        return listSurah.size
    }

}