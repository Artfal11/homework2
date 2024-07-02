package ru.itis.homework2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class BookAdapter(private val books: List<Book>, private val onItemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookImage: ImageView = itemView.findViewById(R.id.book_image)
        val bookTitle: TextView = itemView.findViewById(R.id.book_title)
        val bookAuthor: TextView = itemView.findViewById(R.id.book_author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        Picasso.get().load(book.imageUrl).into(holder.bookImage)
        holder.bookTitle.text = book.title
        holder.bookAuthor.text = book.author

        holder.itemView.setOnClickListener {
            onItemClickListener(book.id)
        }
    }

    override fun getItemCount(): Int {
        return books.size
    }
}