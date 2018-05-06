package com.example.antalfarkas.hirplacc.ui.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.R;
import com.example.antalfarkas.hirplacc.model.Article;

import java.io.InputStream;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailScreen {
    @Inject
    DetailPresenter detailPresenter;

    String id;
    TextView tvDetailTitle;
    TextView tvText;
    TextView tvUrl;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        HirPlaccApplication.injector.inject(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent i = getIntent();
        id = i.getStringExtra("id");


        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        tvText = findViewById(R.id.tvText);
        tvUrl = findViewById(R.id.tvUrl);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailPresenter.attachScreen(this);

        detailPresenter.loadArticle(id);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailPresenter.detachScreen();
    }

    @Override
    public void showArticle(final Article article) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("HP", article.getTitle());
                tvDetailTitle.setText(article.getTitle());
                tvText.setText(article.getText());
                tvUrl.setText(article.getUrl());
                new DownloadImageTask(imageView).execute(article.getImageUrl());
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
