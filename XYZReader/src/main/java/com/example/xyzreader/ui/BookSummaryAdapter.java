package com.example.xyzreader.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xyzreader.R;

public class BookSummaryAdapter extends RecyclerView.Adapter<BookSummaryAdapter.BookViewHolder> {
    private String bookDetails;
    Context context;

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        int layoutForBook = R.layout.book_body;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutForBook, viewGroup, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bookSummary.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(),
                "Rosario-Regular.ttf"));
        holder.bookSummary.setText(bookDetails);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public final TextView bookSummary;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookSummary = (TextView) itemView.findViewById(R.id.article_body);
        }
    }

    public void setBookBody(String mBookDetails) {
        bookDetails = mBookDetails;
        notifyDataSetChanged();
    }
}
