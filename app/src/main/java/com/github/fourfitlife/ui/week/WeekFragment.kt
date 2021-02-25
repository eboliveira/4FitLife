package com.github.fourfitlife.ui.week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.fourfitlife.R

class WeekFragment : Fragment() {

    private lateinit var weekViewModel: WeekViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        weekViewModel =
                ViewModelProvider(this).get(WeekViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_week, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        weekViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
