package com.example.secureshield20;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Account> accountList;
    Context context;

    public RecyclerViewAdapter(List<Account> accountList, Context context) {
        this.accountList = accountList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_account,
                parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tv_accountName.setText(accountList.get(position).getName());
        Glide.with(this.context).load(accountList.get(position).getIconUrl()).into(holder.iv_accountIcon);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, editActivity.class);
                intent.putExtra("id", accountList.get(position).getId());
                context.startActivity(intent);
                Toast.makeText(context,
                        "Sent ID #" + String.valueOf(accountList.get(position).getId()),
                        Toast.LENGTH_SHORT).show();
            }
        });
        //  TODO bind clipboard function
    }

    @Override
    public int getItemCount() {
        return accountList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_accountName;
        ImageView iv_accountIcon;
        ImageView iv_copyPassword;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_accountName = itemView.findViewById(R.id.tv_accountName);
            iv_accountIcon = itemView.findViewById(R.id.iv_accountIcon);
            iv_copyPassword = itemView.findViewById(R.id.iv_clipboard);
            parentLayout = itemView.findViewById(R.id.oneLineAccountLayout);
        }
    }
}