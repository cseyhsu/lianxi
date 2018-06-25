package com.example.www.lianx;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.www.lianx.adapter.Fruit;
import com.example.www.lianx.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


/*********************************************************************/
// 底部bottom sheet 使用recycler view 实现
public class BottomSheetRecyclerViewActivity extends AppCompatActivity {

    private View mBottomLayout;
    private BottomSheetBehavior mBottomSheetBehavior;

    private LinearLayout linearLayout;

    private List<Fruit> fruitList = new ArrayList<>();
    private ImageButton imageButton;

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
        setContentView(R.layout.activity_bottom_sheet_recycler_view);

        linearLayout = findViewById(R.id.recycler_view_bottom_sheet_parent);

        imageButton = findViewById(R.id.image_button);


        //1.通过id获得底部菜单布局的实例
        mBottomLayout = findViewById(R.id.bottom_sheet);
        //2.把这个底部菜单和一个BottomSheetBehavior关联起来
        // 底部菜单要是根view
        mBottomSheetBehavior = BottomSheetBehavior.from(linearLayout);

        


        // 强制类型转换
        RecyclerView recyclerView = (RecyclerView) mBottomLayout;


        // 布局管理器
        // 此布局管理器可以是垂直方向的
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);

        // 为RecyclerView设置布局管理器
        recyclerView.setLayoutManager(layoutManager);

        // 初始化 list
        init_fruit();

        //  为recyclerView 设置适配器
        recyclerView.setAdapter(new RecyclerViewAdapter(fruitList));

    }

    public void bottomsheet(View view) {
    }

    public void showBottomSheet(View view) {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imageButton.startAnimation(animation);

        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        int state = mBottomSheetBehavior.getState();

        Toast.makeText(getApplicationContext(),"state "+ state ,Toast.LENGTH_SHORT).show();


    }


    public void closebottomsheetrecyclerview(View view) {


        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }
}
