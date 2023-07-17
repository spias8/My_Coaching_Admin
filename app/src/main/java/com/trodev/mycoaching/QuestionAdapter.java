package com.trodev.mycoaching;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private Context context;
    private List<QuestionData> list;

    public QuestionAdapter(Context context, List<QuestionData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);

        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {

        holder.ebookName.setText(list.get(position).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, QuestionFullImageActivity.class);
                intent.putExtra("pdfUrl",list.get(position).getPdfUrl());
                context.startActivity(intent);
            }
        });


        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent download = new Intent(Intent.ACTION_VIEW);
                download.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(download);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        private TextView ebookName;
        private ImageView ebookDownload;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);

            /*init views from data layout*/
            ebookName = itemView.findViewById(R.id.ebookName);
            ebookDownload = itemView.findViewById(R.id.ebookDownload);
        }
    }
}
