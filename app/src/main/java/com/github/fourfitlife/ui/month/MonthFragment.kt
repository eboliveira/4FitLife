package com.github.fourfitlife.ui.month

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.fourfitlife.R

class MonthFragment : Fragment() {

    private lateinit var monthViewModel: MonthViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        monthViewModel =
                ViewModelProvider(this).get(MonthViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_month, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        monthViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
