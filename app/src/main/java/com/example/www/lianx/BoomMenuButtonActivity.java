package com.example.www.lianx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.BoomButtonBuilder;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.www.lianx.BuilderManager.getImageResource;

public class BoomMenuButtonActivity extends AppCompatActivity {

    private  BoomMenuButton bmb4;
    private Object subButtonDrawables;

    // 跳转目标
    private  Class<?>[] cls =    {
        MainActivity.class,
        BottomNavigationViewViewPageActivity.class,
        ChatSimpleActivity.class,
        BottomSheetDialogActivity.class,

    };

    //icon
    private int []drawable = {
      R.drawable.file,
      R.drawable.share,
      R.drawable.coporation,
      R.drawable.diary,
    };

    private int []textDescription ={

            R.string.file,
            R.string.share,
            R.string.coporation,
            R.string.diary,
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        new Intent(BoomMenuButtonActivity.this, MainActivity.class);


//        bmb4.init(
//                subButtonDrawables, // 子按钮的图标Drawable数组，不可以为null
//                subButtonTexts,     // 子按钮的文本String数组，可以为null
//                subButtonColors,    // 子按钮的背景颜色color二维数组，包括按下和正常状态的颜色，不可为null
//                ButtonType.HAM,     // 子按钮的类型
//                BoomType.PARABOLA,  // 爆炸类型
//                PlaceType.HAM_3_1,  // 排列类型
//                null,               // 展开时子按钮移动的缓动函数类型
//                null,               // 展开时子按钮放大的缓动函数类型
//                null,               // 展开时子按钮旋转的缓动函数类型
//                null,               // 隐藏时子按钮移动的缓动函数类型
//                null,               // 隐藏时子按钮缩小的缓动函数类型
//                null,               // 隐藏时子按钮旋转的缓动函数类型
//                null                // 旋转角度
//        );

    }

    private  static ImageView imageView;

    private  static  class  myHandler extends  Handler{
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);

            Bitmap bmp = (Bitmap) msg.obj;

            imageView.setImageBitmap(bmp);
        }
    };

        private Handler handler = new myHandler();


//    private Handler handler = new Handler() {
//
//        @Override
//        public void handleMessage(Message msg) {
//            //super.handleMessage(msg);
//
//            Bitmap bmp = (Bitmap) msg.obj;
//
//            imageView.setImageBitmap(bmp);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boom_menu_button);

        imageView = findViewById(R.id.boom_menu_image_view);

        Button button = new Button(this);

        button.setText("hello what?");


        //   加载图片
        Glide.with(this).load("http://cn.bing.com/az/hprichbg/rb/EtaAquarids_EN-US10944490288_1920x1080.jpg").into(imageView);


        BoomMenuButton bmb1 = (BoomMenuButton) findViewById(R.id.bmb1);

        for (int i = 0; i < bmb1.getPiecePlaceEnum().pieceNumber(); i++)
            bmb1.addBuilder(BuilderManager.getSquareSimpleCircleButtonBuilder());


        BoomMenuButton bmb2 = (BoomMenuButton) findViewById(R.id.bmb2);
        for (int i = 0; i < bmb2.getPiecePlaceEnum().pieceNumber(); i++)
            bmb2.addBuilder(BuilderManager.getSquareTextInsideCircleButtonBuilder());


        BoomMenuButton bmb3 = (BoomMenuButton) findViewById(R.id.bmb3);
        for (int i = 0; i < bmb3.getPiecePlaceEnum().pieceNumber(); i++)
            bmb3.addBuilder(BuilderManager.getTextOutsideCircleButtonBuilderWithDifferentPieceColor());

        bmb4 = (BoomMenuButton) findViewById(R.id.bmb4);
        for (int i = 0; i < bmb4.getPiecePlaceEnum().pieceNumber(); i++) {


            HamButton.Builder builder = new HamButton.Builder();
            builder.listener(new OnBMClickListener() {
                @Override
                public void onBoomButtonClick(int index) {
                    Toast toast = Toast.makeText(getApplicationContext(), " yooooooo " + index, Toast.LENGTH_SHORT);
                   toast. setGravity(Gravity.CENTER, 0, 0);
                   toast.show();

                    Intent intent = new Intent(getApplicationContext(), cls[index]);

                    startActivity(intent);



                }
            });
          //  builder.normalImageRes(getImageResource());
            builder.normalImageRes(drawable[i]);
            builder.normalText(getResources().getString(textDescription[i]));
          //  builder.normalText(getResources().getString(R.string.demo));
        //    builder.normalImageDrawable(getResources().getDrawable( drawable[i]));



            bmb4.addBuilder(builder);



        }

        HamButton build = (HamButton) bmb4.getBuilders().get(0).build(this);

        if(build != null){
            Toast.makeText(getApplicationContext(),"kongzhi",Toast.LENGTH_SHORT).show();

        } else {
            build.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                                   Toast.makeText(getApplicationContext(),"我的世界",Toast.LENGTH_SHORT).show();

                }
            });
        }

//        bmb4.getBuilders().get(0).button().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"我的世界",Toast.LENGTH_SHORT).show();
//            }
//        });

        // bmb4.setOnSubButtonClickListener(new )


        new Thread() {

            @Override
            public void run() {

                try {
                    URL url = new URL("http://cn.bing.com/az/hprichbg/rb/EtaAquarids_EN-US10944490288_1920x1080.jpg");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestMethod("GET");

                    int code = connection.getResponseCode();

                    if (code == HttpURLConnection.HTTP_OK) {

                        InputStream inputStream = connection.getInputStream();
                        Bitmap bmp = BitmapFactory.decodeStream(inputStream);
                        inputStream.close();
                        connection.disconnect();

                        Message msg = Message.obtain();
                        msg.obj = bmp;

                        handler.sendMessage(msg);
                    }

                } catch (Exception e) {
                    Toast.makeText(BoomMenuButtonActivity.this, "error " + e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
