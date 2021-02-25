package com.github.fourfitlife.ui.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.fourfitlife.R

class DayFragment : Fragment() {

    private lateinit var dayViewModel: DayViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dayViewModel =
                ViewModelProvider(this).get(DayViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_day, container, false)
        val textView: TextView = root.findViewById(R.id.text_day)
        dayViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
