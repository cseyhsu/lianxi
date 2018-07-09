package com.example.www.lianx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidadvance.topsnackbar.TSnackbar;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class SpaceNavigationViewActivity extends AppCompatActivity {

    //
    private SpaceNavigationView spaceNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_navigation_view);

        SpaceItem search = new SpaceItem("SEARCH", R.drawable.icon_help);

        spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);

        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);

        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.horse));
        spaceNavigationView.addSpaceItem(search);
        spaceNavigationView.setCentreButtonSelectable(true);

        spaceNavigationView.setActiveSpaceItemColor(getResources().getColor(R.color.green500));


      //  spaceNavigationView.showBadgeAtIndex(0, 0, getResources().getColor(R.color.red));

        //设置badbeAt
       //  spaceNavigationView.showBadgeAtIndex(0,2,getResources().getColor( R.color.red) );

        spaceNavigationView.setCentreButtonIcon(R.drawable.apple_pic);


        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {

                TSnackbar.make(findViewById(android.R.id.content), "center Button click ", TSnackbar.LENGTH_LONG).show();

            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                TSnackbar.make(findViewById(android.R.id.content), "Hello from TSnackBar."+itemIndex+", name"+itemName, TSnackbar.LENGTH_LONG).show();

                spaceNavigationView.showBadgeAtIndex(itemIndex,itemIndex,getResources().getColor(R.color.red));

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });
    }
}
