package com.example.rent.myapplication.Gallery;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.rent.myapplication.R;

import java.io.File;

import com.example.rent.myapplication.Drawing.DrawingMainActivity;

/**
 * Created by RENT on 2017-02-21.
 */

public class GalleryActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        File dir = getExternalFilesDir(DrawingMainActivity.DRAWING_GALLERY);
//        DRAWING_GALLERY_DIR
        File[] files = dir.listFiles();
        viewPager.setAdapter(new DrawingPagerAdapter(files));

//        getExternalFilesDir(DrawingMainActivity.DRAWING_GALLERY_DIR);
//        File[] files = dir.listFiles();
//        File file = files[0];
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            BitmapFactory.decodeStream(fileInputStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


    }

}
