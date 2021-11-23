package blue.umbrella.dhkr.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import blue.umbrella.dhkr.Data.Dhikr.Dhikr
import blue.umbrella.dhkr.R

class DhikrAdapter(private val listDhikr: ArrayList<Dhikr>) : RecyclerView.Adapter<DhikrAdapter.ViewHolder>() {

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val desc = view.findViewById<TextView>(R.id.item_desc)
        val lafaz = view.findViewById<TextView>(R.id.item_lafaz)
        val terjemah = view.findViewById<TextView>(R.id.item_terjemah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.dhikr_model, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listDhikir = listDhikr[position]
        holder.desc.text = listDhikir.desc
        holder.lafaz.text = listDhikir.lafaz
        holder.terjemah.text = listDhikir.terjemah
    }

    override fun getItemCount(): Int {
        return listDhikr.size
    }

}