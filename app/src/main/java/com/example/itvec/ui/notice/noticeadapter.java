package com.example.itvec.ui.notice;
import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.itvec.Fullimageview;
import com.example.itvec.R;

import java.util.ArrayList;


public class noticeadapter extends RecyclerView.Adapter<noticeadapter.noticeviewadapter>  {

    private final Context context;
    private final ArrayList<noticeData> list;


    public noticeadapter(Context context, ArrayList<noticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public noticeviewadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_feed,parent,false);
        return new noticeviewadapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull noticeviewadapter holder, int position) {

        noticeData currentItem = list.get(position);

        holder.deletenoticetitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getLength());

        try {
            if (currentItem.getImage() != null) {
                Log.d("Imagedata",currentItem.getImage());
                Glide.with(context).load(currentItem.getImage()).fitCenter().into(holder.deletenoticeimage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.deletenoticeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Fullimageview.class);
                intent.putExtra("image",currentItem.getImage());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class noticeviewadapter extends RecyclerView.ViewHolder {


        private TextView deletenoticetitle,time,date;
        private ImageView deletenoticeimage;

        public noticeviewadapter(@NonNull View itemView) {
            super(itemView);
            deletenoticetitle = itemView.findViewById(R.id.deletenoticetitle);
            deletenoticeimage = itemView.findViewById(R.id.deletenoticeimage);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }

}
