package com.example.www.lianx;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

import com.example.www.lianx.adapter.Fruit;
import com.example.www.lianx.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Fruit> fruitList = new ArrayList<>();
    private Toolbar toolbar;


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
        setContentView(R.layout.activity_collapsing_toolbar_layout);


        //****设置tool bar
        toolbar = findViewById(R.id.collapsing_toolbar);

        setSupportActionBar(toolbar);

        ActionBar supportActionBar = getSupportActionBar();

        if(supportActionBar != null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);

            supportActionBar.setTitle("折叠菜单展示");
        }


        //*****************设置 recycler View
        recyclerView = findViewById(R.id.collapsing_recycler_view);

        // 布局管理器
        // 此布局管理器可以是垂直方向的
      //  StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        // 为RecyclerView设置布局管理器
        recyclerView.setLayoutManager(layoutManager);

        // 初始化 list
        init_fruit();

        //  为recyclerView 设置适配器
        recyclerView.setAdapter(new RecyclerViewAdapter(fruitList));
    }
}
