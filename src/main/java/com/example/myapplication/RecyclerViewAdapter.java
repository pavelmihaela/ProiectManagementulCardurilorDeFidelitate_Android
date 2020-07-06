package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Magazin> mData;

    public RecyclerViewAdapter(Context mContext, List<Magazin> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater=LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.top_carduri_2,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.txt.setText(mData.get(position).getTitlu());
        holder.img1.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,MagazinActivitate.class);
                intent.putExtra("Titlu",mData.get(position).getTitlu());
                intent.putExtra("Descriere",mData.get(position).getDescriere());
                intent.putExtra("Categorie",mData.get(position).getCategorie());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                mContext.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt;
        ImageView img1;
        CardView cardView;


        public MyViewHolder(View itemView) {
            super(itemView);

            txt=(TextView)itemView.findViewById(R.id.titlu);
            img1=(ImageView)itemView.findViewById(R.id.img_card);
            cardView=(CardView)itemView.findViewById(R.id.cardview_id);

        }
    }
}
