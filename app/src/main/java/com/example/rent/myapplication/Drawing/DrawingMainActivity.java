package com.example.rent.myapplication.Drawing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rent.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.rent.myapplication.Gallery.GalleryActivity;


public class DrawingMainActivity extends AppCompatActivity {
    public static final String DRAWING_GALLERY = "Drawing_gallery";

    private SimpleDrawingView simpleDrawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawing_activity_main);
        simpleDrawingView = (SimpleDrawingView) findViewById(R.id.simple_drawing_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.clear) {
            simpleDrawingView.clear();
        } else if (item.getItemId() == R.id.save) {
            saveDrawingToFile();
        } else if(item.getItemId() == R.id.drawing_gallery){
            Intent intent = new Intent(this, GalleryActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveDrawingToFile() {
        File drawingFile = new File(getDrawingGalleryDirectory(), createFileName());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(drawingFile);
            Bitmap bitmap = convertViewToBitmap(simpleDrawingView);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String createFileName() {
        String TimeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return "my_drawing" + TimeStamp + ".png";
    }

    private File getDrawingGalleryDirectory() {
        return getExternalFilesDir(DRAWING_GALLERY);
//        DRAWING_GALLERY_DIR
    }

    private Bitmap convertViewToBitmap(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}


