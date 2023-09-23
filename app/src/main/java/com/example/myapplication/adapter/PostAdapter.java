package com.example.myapplication.adapter;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.api.model;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    public PostAdapter ( Context context , List< model > data ) {
        this.context = context;
        this.data = data;
    }

    Context context;
    List< model > data;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.item_post , parent , false );
        return new MyViewHolder ( view );
    }

    @Override
    public void onBindViewHolder ( @NonNull MyViewHolder holder , int position ) {

        holder.textView_name.setText ( data.get ( position ).getName () );
        holder.textView_loc.setText ( data.get ( position ).getLoc () );
        holder.textView_decrption.setText ( data.get ( position ).getDeckrption () );
        holder.textView_like.setText ( data.get ( position ).getFevrit () );
        holder.textView_coment.setText ( data.get ( position ).getComent () );


        Picasso.get ().load ( data.get ( position ).getImg_link_profile () ).into ( holder.imageView_profil );
        Picasso.get ().load ( data.get ( position ).getImg_link_post () ).into ( holder.imageView );


    }

    @Override
    public int getItemCount ( ) {
        return data.size ( );
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_name, textView_loc, textView_like, textView_coment, textView_decrption;
        ImageView  imageView;
        CircleImageView imageView_profil;

        public MyViewHolder ( @NonNull View itemView ) {
            super ( itemView );

            textView_name =itemView.findViewById ( R.id.text_profile );
            textView_loc =itemView.findViewById ( R.id.location );
            textView_like =itemView.findViewById ( R.id.text_like );
            textView_coment =itemView.findViewById ( R.id.text_coment );
            textView_decrption =itemView.findViewById ( R.id.decrption );

            imageView_profil = itemView.findViewById ( R.id.profile );
            imageView = itemView.findViewById ( R.id.img );




        }
    }
}
