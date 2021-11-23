package blue.umbrella.dhkr.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import blue.umbrella.dhkr.R
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso

class MySliderAdapter() : SliderViewAdapter<MySliderAdapter.ViewHolder>() {

    private var mSliderItems = ArrayList<Int>()

    fun reNewItems(sliderItems: ArrayList<Int>){
        mSliderItems = sliderItems
        notifyDataSetChanged()
    }

    fun addItem(sliderItems: Int){
        mSliderItems.add(sliderItems)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return mSliderItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup): MySliderAdapter.ViewHolder {
       val inflate: View = LayoutInflater
           .from(parent.context)
           .inflate(R.layout.image_slider_model, null)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: MySliderAdapter.ViewHolder, position: Int) {
        Picasso
            .get()
            .load(mSliderItems[position])
            .fit()
            .into(viewHolder.imageView)
    }

    inner class ViewHolder(view: View):SliderViewAdapter.ViewHolder(view){
        var imageView : ImageView = view.findViewById(R.id.imageSlider)
    }

}