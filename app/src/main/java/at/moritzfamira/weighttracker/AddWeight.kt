package at.moritzfamira.weighttracker

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import at.moritzfamira.weighttracker.databinding.AddWeightBinding
import at.moritzfamira.weighttracker.datamodel.AppDatabase
import at.moritzfamira.weighttracker.datamodel.Weight
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date


class AddWeight : Fragment() {
    private var _binding: AddWeightBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    // create instance of database


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = AddWeightBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setting current date
        val currentDate = LocalDate.now()
        binding.currentDateTextview.text = currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")).toString()
        binding.submitButton.setOnClickListener() {
            /* might not be necessary
            val keyBoardManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            keyBoardManager.hideSoftInputFromWindow(view.windowToken,0)*/
            if(isValidNumber(binding.addWeightTextField.text.toString())) {
                // writing to database
                Thread {
                    val db = Room.databaseBuilder(
                        requireContext(),
                        AppDatabase::class.java, "database-name"
                    ).build()
                    val weightDao = db.weightDao()
                    weightDao.insert(
                        Weight(
                            LocalDateTime.now(),
                            binding.addWeightTextField.text.toString().toDouble()
                        )
                    )
                    db.close()
                }.start()
                val navController = findNavController()
                navController.navigate(R.id.listWeights)
            }
        }
    }
    private fun isValidNumber(num: String) : Boolean {
        if (num.isNotBlank()&&num.replace(".","").isDigitsOnly()&& num != ".") {
            return true
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}