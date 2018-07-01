package com.example.www.lianx;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.example.www.lianx.adapter.Fruit;
import com.example.www.lianx.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetDialogActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();


    private void init_fruit() {


        for (int i = 0; i < 10; i++) {
            Fruit fruit = new Fruit();
            fruit.setImageId(R.drawable.apple_pic);
            fruit.setName("apple");
            fruitList.add(fruit);


            Fruit fruit1 = new Fruit();

            fruit1.setName("cherry");
            fruit1.setImageId(R.drawable.cherry_pic);

            fruitList.add(fruit1);

            Fruit pear = new Fruit();

            pear.setImageId(R.drawable.pear_pic);

            pear.setName("雪梨");

            fruitList.add(pear);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_dialog);


        init_fruit();
    }


    // 显示 底部 sheetDialog
    public void showDialog(View view) {

        // 新建一个 底部的Dialog对象
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);

        // 设置可以外部关闭
        //
        bottomSheetDialog.setCanceledOnTouchOutside(true);


        // 设置可以关闭
        bottomSheetDialog.setCancelable(true);


        // 加载布局界面
        View v = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet_dialog, null);

        // bottomSheetDialog设置布局
        bottomSheetDialog.setContentView(v);

        // 从布局中获取 recyclerView对象
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view_bottom_sheet_dialog);

        // 布局管理器
        // 此布局管理器可以是垂直方向的
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);

        // 为RecyclerView设置布局管理器
        recyclerView.setLayoutManager(layoutManager);

        // 初始化 list
        //  init_fruit();

        //  为recyclerView 设置适配器
        recyclerView.setAdapter(new RecyclerViewAdapter(fruitList));



        //显示布局
        bottomSheetDialog.show();



    }
}
