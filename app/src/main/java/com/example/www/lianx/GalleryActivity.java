package com.example.www.lianx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class GalleryActivity extends AppCompatActivity {

    private static final int READ_REQUEST_CODE = 100;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        imageView = findViewById(R.id.gallery_image_view);

    }

    public void openGallery(View view) {

        Intent intent;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {

            // 打开系统图库
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }

        //设置类型
        intent.setType("image/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode != READ_REQUEST_CODE || resultCode != RESULT_OK || data == null) {
            return;
        }
        // 获取uri
        Uri uri = data.getData();
        try {
            // 从...读取出数据
            Bitmap picture = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);



            //设置图片
            imageView.setImageBitmap(picture);

            Intent intent = new Intent(this, ImageActivity.class);
            //
            intent.setData(uri);

            // 不能再直接传送图片, 图片太大了
            //     Caused by: android.os.TransactionTooLargeException: data parcel size 9850076 bytes
//            Bundle bundle = new Bundle();
//
//            bundle.putParcelable("data",picture);
//         //  bundle.putBundle("data",picture);
//            intent.putExtras(bundle);
//            startActivityForResult(intent,300);
            startActivity(intent);

        }catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }
}
