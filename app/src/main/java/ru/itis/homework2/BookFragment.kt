package ru.itis.homework2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

class BookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book, container, false)

        val bookId = arguments?.getInt("BOOK_ID") ?: 0
        val book = BookRepository().getBookById(bookId)

        if (book != null) {
            val bookImage: ImageView = view.findViewById(R.id.book_image)
            val bookTitle: TextView = view.findViewById(R.id.book_title)
            val bookAuthor: TextView = view.findViewById(R.id.book_author)
            val bookShortDescription: TextView = view.findViewById(R.id.book_short_description)
            val bookLongDescription: TextView = view.findViewById(R.id.book_long_description)


            Glide.with(this).load(book.imageUrl).into(bookImage)
            bookTitle.text = book.title
            bookAuthor.text = book.author
            bookShortDescription.text = book.shortDescription
            bookLongDescription.text = book.longDescription
        }

        view.findViewById<ImageView>(R.id.back_button).setOnClickListener {
            findNavController().popBackStack()
        }
        return view
    }
}