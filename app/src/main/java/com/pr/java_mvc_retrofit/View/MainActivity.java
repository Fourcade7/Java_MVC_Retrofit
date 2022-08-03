package com.pr.java_mvc_retrofit.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.pr.java_mvc_retrofit.Controller.MainController;
import com.pr.java_mvc_retrofit.Model.Model.Posts;
import com.pr.java_mvc_retrofit.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MainController mainController;
    public ArrayList<Posts> postsArrayList;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview1);
        postsArrayList=new ArrayList<>();
        mainController=new MainController(this);
        mainController.loadData();


    }

    public void updateUi(){
        textView.setText(postsArrayList.get(0).getTitle());
    }
}