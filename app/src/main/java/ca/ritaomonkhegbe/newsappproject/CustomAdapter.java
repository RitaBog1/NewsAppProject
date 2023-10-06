package ca.ritaomonkhegbe.newsappproject;

import static android.view.View.inflate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ca.ritaomonkhegbe.newsappproject.Models.NewsHeadlines;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsHeadlines> headlines;
    private SelectListener listener;
    private int ovalshape;
    private ViewGroup parent;
    private boolean b;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.headline_list_items, parent, false));


    }

    private void inflate(int ovalshape, ViewGroup parent, boolean b) {
        this.ovalshape = ovalshape;
        this.parent = parent;
        this.b = b;
        LayoutInflater.from(parent.getContext()).inflate(R.layout.ovalshape, parent, false);
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());

        if(headlines.get(position).getUrlToImage() != null) {
            Picasso.get().load(headlines.get(position).getUrlToImage())
                    .into(holder.img_headline);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnNewsClicked(headlines.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
