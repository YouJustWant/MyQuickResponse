package com.bwie.myquickresponse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

public class CreateActivity extends AppCompatActivity {

    private EditText content;
    private ImageView imageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        content = findViewById(R.id.content);
        imageView = findViewById(R.id.image);
    }

    public void createLogo(View view) {
        String textContent = content.getText().toString();
        if(textContent.isEmpty()){
            Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        content.setText("");
        bitmap = CodeUtils.createImage(textContent, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        imageView.setImageBitmap(bitmap);
    }

    public void createText(View view) {
        String textContent = content.getText().toString();
        if(textContent.isEmpty()){
            Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        content.setText("");
        bitmap = CodeUtils.createImage(textContent, 400, 400, null);
        imageView.setImageBitmap(bitmap);
    }
}
