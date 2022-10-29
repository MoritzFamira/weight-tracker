package at.moritzfamira.weighttracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import at.moritzfamira.weighttracker.databinding.ListWeightsBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListWeightsFragment : Fragment() {

    private var _binding: ListWeightsBinding? = null

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

    override fun onResume() {

        super.onResume()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}