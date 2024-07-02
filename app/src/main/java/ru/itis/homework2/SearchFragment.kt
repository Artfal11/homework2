package ru.itis.homework2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val books = BookRepository().getBooks()

        val adapter = BookAdapter(books) { bookId ->
            findNavController().navigate(R.id.action_searchFragment_to_bookDetailFragment, Bundle().apply {
                putInt("BOOK_ID", bookId)
            })
        }
        recyclerView.adapter = adapter
        return view
    }
}
