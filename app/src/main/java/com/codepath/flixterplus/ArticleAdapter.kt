package com.codepath.flixterplus

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val ARTICLE_EXTRA = "ARTICLE_EXTRA"
private const val TAG = "ArticleAdapter"


class ArticleAdapter(private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = movies[position]
        holder.bind(article)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.mediaImage)
        private val titleTextView = itemView.findViewById<TextView>(R.id.mediaTitle)
        private val abstractTextView = itemView.findViewById<TextView>(R.id.mediaAbstract)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method

        override fun onClick(v: View?) {
            // TODO: Get selected article
            val article = movies[absoluteAdapterPosition]
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ARTICLE_EXTRA, article)
            context.startActivity(intent)

            // TODO: Navigate to Details screen and pass selected article
        }

        fun bind(movie: Movie) {
            titleTextView.text = movie.title
            abstractTextView.text = movie.overview

            Glide.with(context)
                .load(movie.mediaImageUrl)
                .into(mediaImageView)
        }
    }

}