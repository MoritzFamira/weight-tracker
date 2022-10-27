package at.moritzfamira.weighttracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import at.moritzfamira.weighttracker.databinding.ListWeightsBinding
import at.moritzfamira.weighttracker.datamodel.AppDatabase
import at.moritzfamira.weighttracker.datamodel.Weight
import java.time.Instant
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListWeights : Fragment() {

    private var _binding: ListWeightsBinding? = null
    private lateinit var mWeightListAdapter: WeightListAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ListWeightsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        Thread {
            val db = Room.databaseBuilder(
                requireContext(),
                AppDatabase::class.java, "database-name"
            ).build()

            val weightDao = db.weightDao()
            val weights = weightDao.getAll()
            println(weights.toString())

            // @TODO insert into list/ create ViewHolder
            //mWeightListAdapter.createViewHolder()

            binding.weightList.adapter
        }.start()

        super.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}