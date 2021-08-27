package com.example.itvec.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.itvec.Fullimageview;
import com.example.itvec.R;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter <GalleryAdapter.Galleryviewadapter>{

    private Context context;
    private List<String> images;

    public GalleryAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
        @Override
    public Galleryviewadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image,parent,false);
        return new Galleryviewadapter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Galleryviewadapter holder, int position) {
        Log.d("Position",Integer.toString(position));
        Glide.with(context).load(images.get(position)).fitCenter().into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Fullimageview.class);
                intent.putExtra("image",images.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class Galleryviewadapter extends RecyclerView.ViewHolder{

        ImageView imageView;
        public Galleryviewadapter(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image);
        }
    }
}
