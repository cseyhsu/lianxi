package com.example.www.lianx.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.www.lianx.BottomSheetDialogActivity;
import com.example.www.lianx.MainActivity;
import com.example.www.lianx.R;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Fruit> mFruits;


    public RecyclerViewAdapter(List<Fruit> mFruits) {
        this.mFruits = mFruits;
    }



    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_fruit_adapter_item, null);

        ViewHolder holder = new ViewHolder(view);

        // 设置点击事件
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(parent.getContext(), BottomSheetDialogActivity.class);

                parent.getContext().startActivity(intent);

            }
        });


        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), MainActivity.class);

                parent.getContext().startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Fruit fruit = mFruits.get(position);

        holder.imageView.setImageResource(fruit.getImageId());
        holder.textView.setText(fruit.getName());



    }

    @Override
    public int getItemCount() {
        return mFruits.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.fruit_image);

            textView = itemView.findViewById(R.id.fruit_text_view);




        }
    }
}
