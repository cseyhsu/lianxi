package com.example.www.lianx;

import android.Manifest;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.content.ContentUris;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class ResultIntentActivity extends AppCompatActivity {

    private static final int CAMERA_ACTIVITY = 200;
    private ImageView imageView;

    Uri imgUri;    //用来引用拍照存盘的 Uri 对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_intent);


        // 初始化 ImageView对象
        imageView = findViewById(R.id.activity_intent_image);
    }


    // 跳转到照相机
    public void camera(View view) {

//        if (ContextCompat.checkSelfPermission(ResultIntentActivity.this,
//                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(ResultIntentActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
//        } else {
//
//
//            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//
//            String dir = getExternalCacheDir().toString();
////            String dir = Environment.getExternalStoragePublicDirectory(  //获取系统的公用图像文件路径
////                    Environment.DIRECTORY_PICTURES).toString();
//            String fname = "p" + System.currentTimeMillis() + ".jpg";  //利用当前时间组合出一个不会重复的文件名
//            File file = new File(dir+"/"+fname);
//           imgUri = FileProvider.getUriForFile(ResultIntentActivity.this, "com.example.lianxi", file);
//
//          //  imgUri = Uri.parse("content://" + dir + "/" + fname);    //按照前面的路径和文件名创建 Uri 对象
//            intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
//
//            // 使用 startActivityForResult 方法来启动一个activity
//            startActivityForResult(intent,CAMERA_ACTIVITY);
//
//
//        }
//
//



        // 创建File对象，用于存储拍照后的图片
        File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT < 24) {
            imgUri = Uri.fromFile(outputImage);
        } else {
            imgUri = FileProvider.getUriForFile(ResultIntentActivity.this, "com.example.lianxi", outputImage);
        }
        // 启动相机程序
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
        startActivityForResult(intent, CAMERA_ACTIVITY);

    }




    // **8 重写 onActivityResult 获取从系统相机返回的相片对象
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        // 判断resultCode
        switch (requestCode){

            // 启动相机的请求码
            case CAMERA_ACTIVITY:{



                // 从返回的intent中获取 Bundle对象
                Bundle bundle = data.getExtras();

                // 从系统的相机中返回的数据为空
                if(bundle == null){

                    Toast.makeText(getApplicationContext(),"打开系统相机后返回,但是没有获取到有效数据",Toast.LENGTH_LONG).show();

                    return ;

                }

                // 获取的数据有效
                // 获取 bitmap对象
                Bitmap bitmap = (Bitmap) bundle.get("data");

                // 将bitmap对象设置到 imageView
                imageView.setImageBitmap(bitmap);


            } break;
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
