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

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context ctx;
    List<Account> accountList;
    ArrayList<String> nameList;
    ArrayList<String> usernameList;
    ArrayList<String> passList;
    ArrayList<String> webList;
    ArrayList<String> uriList;

    public RecyclerViewAdapter(Context ctx, List<Account> accountList, ArrayList<String> nameList, ArrayList<String> usernameList, ArrayList<String> passList, ArrayList<String> webList, ArrayList<String> uriList) {
        this.ctx = ctx;
        this.nameList = nameList;
        this.usernameList = usernameList;
        this.passList = passList;
        this.webList = webList;
        this.uriList = uriList;
        this.accountList = accountList;

    }
    //    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tv_accountName.setText(accountList.get(position).getName());
        holder.tv_username.setText(accountList.get(position).getUsername());
//        Glide.with(this.ctx).load(accountList.get(position).getIconUrl()).into(holder.iv_accountIcon);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, editActivity.class);
                intent.putExtra("id", accountList.get(position).getId());
                ctx.startActivity(intent);
                Toast.makeText(ctx,
                        "Sent ID #" + String.valueOf(accountList.get(position).getId()),
                        Toast.LENGTH_SHORT).show();
            }
        });
        //  TODO bind clipboard function
    }

    public void getSPLocation() {
    }

//    @Override
//    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
//        holder.name.setText(nameList.get(position));
//        holder.username.setText(usernameList.get(position));
//        holder.password.setText(passList.get(position));
//        holder.website.setText(webList.get(position));
//        holder.uri.setText(uriList.get(position));


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_accountName;
        TextView tv_username;
        ImageView iv_copyPassword;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_accountName = itemView.findViewById(R.id.nameItem);
            tv_username = itemView.findViewById(R.id.userItem);
            iv_copyPassword = itemView.findViewById(R.id.iv_clipboard);
            parentLayout = itemView.findViewById(R.id.item);
        }
    }
//class MyViewHolder extends RecyclerView.ViewHolder{
//
//    TextView name, username, password, website, uri;
//
//    public MyViewHolder(View itemView) {
//        super(itemView);
//        ImageView iv_accountIcon;
//
//        name = (TextView) itemView.findViewById(R.id.name);
//        username = (TextView) itemView.findViewById(R.id.username);
//        password = (TextView) itemView.findViewById(R.id.password);
//        website = (TextView) itemView.findViewById(R.id.website);
//        uri = (TextView) itemView.findViewById(R.id.uri);
//        iv_accountIcon = itemView.findViewById(R.id.iv_accountIcon);
//    }
}
