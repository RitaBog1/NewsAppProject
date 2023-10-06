package ca.ritaomonkhegbe.newsappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import ca.ritaomonkhegbe.newsappproject.Models.NewsHeadlines;

public class DetailsActivity extends AppCompatActivity {

    NewsHeadlines headlines;
    TextView txt_title;
    TextView txt_author;
    TextView txt_time;
    TextView txt_detail;
    TextView txt_content;
    ImageView img_news;

    TextView txt_url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_time = findViewById(R.id.text_detail_time);
        txt_detail = findViewById(R.id.text_detail_detail);
        txt_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news);
        txt_url = findViewById(R.id.text_detail_url);


        txt_title.setText(headlines.getTitle());
        txt_author.setText((headlines.getAuthor()));
        txt_time.setText(headlines.getPublishedAt());
        txt_detail.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
        txt_url.setText(headlines.getUrl());
    }
}