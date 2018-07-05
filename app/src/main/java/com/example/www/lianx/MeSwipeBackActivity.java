package com.example.www.lianx;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.www.lianx.adapter.Fruit;

import java.util.ArrayList;
import java.util.List;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

// 滑动返回
public class MeSwipeBackActivity extends SwipeBackActivity {


    private ListView listView;

    static List<Fruit> mFruit = new ArrayList<>();


    static {
        for( int i = 0 ; i< 20; i++){
            Fruit apple = new Fruit();
            apple.setName("apple");
            apple.setImageId(R.drawable.apple_pic);

            mFruit.add(apple);

            Fruit pear = new Fruit();

            pear.setImageId(R.drawable.pear_pic);
            pear.setName("pear");

            mFruit.add(pear);

            Fruit cherry = new Fruit();

            cherry.setName("cherry");
            cherry.setImageId(R.drawable.cherry_pic);

            mFruit.add(cherry);
        }
    }





    private ListAdapter myAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return mFruit.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.layout_horizontial_list_view_item, null);
            }

            TextView textView = convertView.findViewById(R.id.text_view);

            ImageView imageView = convertView.findViewById(R.id.image_view);

            textView.setText(mFruit.get(position).getName());
            imageView.setImageResource(mFruit.get(position).getImageId());


            return convertView;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_swipe_back);

        listView = (ListView) findViewById(R.id.activity_swipe_back_list_view);

        listView.setAdapter(myAdapter);
    }
}
