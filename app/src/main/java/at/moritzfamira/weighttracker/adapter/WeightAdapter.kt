package at.moritzfamira.weighttracker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import at.moritzfamira.weighttracker.R
import at.moritzfamira.weighttracker.model.Weight

class WeightAdapter(private val context: Context, private val dataset: List<Weight>): RecyclerView.Adapter<WeightAdapter.WeightViewHolder>() {
    class WeightViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val weightTextView: TextView = view.findViewById(R.id.weight_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeightViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.weight_list_item,parent,false)

        return WeightViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: WeightViewHolder, position: Int) {
        val weightItem = dataset[position]
        // TODO display more stuff
        holder.weightTextView.text =  weightItem.value.toString()
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}