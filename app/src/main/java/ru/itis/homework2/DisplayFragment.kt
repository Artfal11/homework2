package ru.itis.homework2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DisplayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_display, container, false)

        val displayTextView = view.findViewById<TextView>(R.id.displayTextView)
        val text = arguments?.getString("input_text") ?: "No text provided"
        displayTextView.text = text

        return view
    }
}