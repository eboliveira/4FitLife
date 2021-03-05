package com.github.fourfitlife.ui.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.fourfitlife.R
import com.github.fourfitlife.databinding.FragmentDayBinding
import java.util.*

class DayFragment : Fragment() {
    private lateinit var dayViewModel: DayViewModel
    private lateinit var viewModelAdapter: UserExerciseAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding: FragmentDayBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_day,
            container,
            false)

        binding.lifecycleOwner = viewLifecycleOwner
        dayViewModel = ViewModelProvider(this).get(DayViewModel::class.java)
        binding.viewModel = dayViewModel
        viewModelAdapter = UserExerciseAdapter()
        binding.root.findViewById<RecyclerView>(R.id.user_exercise_recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dayViewModel.userExercises.observe(viewLifecycleOwner, Observer { userExercises ->
            userExercises?.apply {
                viewModelAdapter.userExercises = userExercises
            }
        })
    }
}
