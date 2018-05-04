package com.example.antalfarkas.hirplacc.ui.main.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.antalfarkas.hirplacc.R;
import com.example.antalfarkas.hirplacc.model.Article;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Article> mDataset;
    private ClickListener mListener;

    public ListAdapter() {
        mDataset = new ArrayList<>();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvDescription;
        public TextView tvSourceDomain;
        public Article mItem;
        public View mView;

        public ViewHolder(View v) {
            super(v);

            mView = v;
            tvTitle = v.findViewById(R.id.tvTitle);
            tvDescription = v.findViewById(R.id.tvDescription);
            tvSourceDomain = v.findViewById(R.id.tvSourceDomain);
        }
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_article, parent, false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Article article = mDataset.get(position);

        holder.mItem = article;
        holder.tvTitle.setText(article.getTitle());
        holder.tvDescription.setText(article.getDescription());
        holder.tvSourceDomain.setText(article.getSourceDomain());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setDataset(List<Article> articles) {
        mDataset = articles;
        this.notifyDataSetChanged();
    }

    public void setListener(ClickListener listener) {
        this.mListener = listener;
    }

    public interface ClickListener {
        void onClick(Article item);
    }
}

