package com.example.checkapartment.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.checkapartment.databinding.ItemListDataBinding;
import com.example.checkapartment.model.Item;
import java.util.ArrayList;

public class ItemAdapter  extends RecyclerView.Adapter<ItemAdapter.ViewHolderitem> {
    ArrayList<Item> itemlist;
    // referencia interface
    private PasarElemento pasarElemento;

    public ItemAdapter(ArrayList<Item> itemlist, PasarElemento pasarElemento) {
        this.pasarElemento= pasarElemento;
        this.itemlist = itemlist;
    }

    @NonNull
    @Override
    public ViewHolderitem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDataBinding mbinding;
        mbinding = ItemListDataBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolderitem(mbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderitem holder, int position) {
        holder.mdesc.setText(itemlist.get(position).getItemDescription());
        Glide.with(holder.mimgview.getContext()).load(itemlist.get(position).getUrlImage()).into(holder.mimgview);
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ViewHolderitem extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mdesc;
        public ImageView mimgview;

        public ViewHolderitem(@NonNull ItemListDataBinding mbinding) {
            super(mbinding.getRoot());
            mdesc =mbinding.tvItem;
            mimgview = mbinding.ivItem;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            Item element = itemlist.get(position);
            notifyDataSetChanged();
            pasarElemento.passElement(element);
        }
    }

    public interface PasarElemento{
        void passElement(Item elemento);
    }
}
