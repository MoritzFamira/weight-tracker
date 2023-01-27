package at.moritzfamira.weighttracker

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import at.moritzfamira.weighttracker.databinding.WeightListItemBinding
import at.moritzfamira.weighttracker.datamodel.AppDatabase
import at.moritzfamira.weighttracker.datamodel.Weight
import java.time.format.DateTimeFormatter


class WeightListAdapter(private val dataSet: ArrayList<Weight>) :
    RecyclerView.Adapter<WeightListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     **/
    inner class ViewHolder(val binding: WeightListItemBinding) : RecyclerView.ViewHolder(binding.root)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = WeightListItemBinding.inflate(LayoutInflater.from(viewGroup.context))

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.binding.weightValue.text = dataSet[position].value.toString() +" kg"
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        viewHolder.binding.weightDate.text = dataSet[position].dateOfWeight.format(formatter)
        viewHolder.binding.weightListItem.tag = dataSet[position].weightId
        viewHolder.binding.deleteWeight.setOnClickListener {
            //println(viewHolder.binding.weightValue.text.toString())
            //TODO fix incorrect data being deleted from time to time
            println(dataSet[position])
            println(dataSet.toString())
            dataSet.removeAt(position)
            notifyItemRemoved(position)
            Thread {
                val db = Room.databaseBuilder(
                    viewHolder.itemView.context,
                    AppDatabase::class.java, "database-name"
                ).build()

                val weightDao = db.weightDao()
                weightDao.deleteById(viewHolder.binding.weightListItem.tag as Int)
                db.close()
            }.start()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

