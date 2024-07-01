package ru.itis.homework2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val inputText = view.findViewById<EditText>(R.id.inputText)
        val sendButton = view.findViewById<Button>(R.id.sendButton)

        sendButton.setOnClickListener {
            val text = inputText.text.toString()
            if (text.isNotEmpty()) {
                val bundle = Bundle().apply {
                    putString("input_text", text)
                }
                findNavController().navigate(R.id.action_settingsFragment_to_displayFragment, bundle)
            } else {
                Snackbar.make(view, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_SHORT).show()
            }
        }

        return view
    }
}