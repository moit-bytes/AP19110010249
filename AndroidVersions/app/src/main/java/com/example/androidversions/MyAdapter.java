package com.example.androidversions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myHolder> {
    String myCodename[], myVersionNumber[], myApiLevel[], myReleaseDate[];
    int myImages[];
    Context ct;

    public MyAdapter(MainActivity mainActivity, int[] images, String[] codeName, String[] versionNumber, String[] apiLevel, String[] releaseDate)
    {
        ct = mainActivity;
        myImages = images;
        myCodename = codeName;
        myVersionNumber = versionNumber;
        myApiLevel = apiLevel;
        myReleaseDate = releaseDate;
    }

    @NonNull
    @Override
    public MyAdapter.myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(ct).inflate(R.layout.my_item, parent, false);
        myHolder holder = new myHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.myHolder holder, int position) {

        holder.iv.setImageResource(myImages[position]);
        holder.tv1.setText("Code Name: "+ myCodename[position]);
        holder.tv2.setText("Version: "+ myVersionNumber[position]);
        holder.tv3.setText("API level: "+ myApiLevel[position]);
        holder.tv4.setText(myReleaseDate[position]);

    }

    @Override
    public int getItemCount() {

        return myImages.length;
    }

    public class myHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv1, tv2, tv3, tv4;

        public myHolder(@NonNull View itemView)
        {
            super(itemView);

            iv = itemView.findViewById(R.id.poster);
            tv1 = itemView.findViewById(R.id.code_name);
            tv2 = itemView.findViewById(R.id.version_num);
            tv3 = itemView.findViewById(R.id.api_level);
            tv4 = itemView.findViewById(R.id.release_date);
        }
    }
}
