/*
 ************************ Assignment #InClass 03 *******************************************
 *********************** File Name- select_avatar.java *************************************
 ************************ Full Name- 1. Manali Ghare 2. Anup Deshpande (Group 19) ***********

 */


package com.example.manalighare.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class select_avatar extends AppCompatActivity implements View.OnClickListener{

    private ImageView avatar_f_1;
    private ImageView avatar_f_2;
    private ImageView avatar_f_3;
    private ImageView avatar_m_1;
    private ImageView avatar_m_2;
    private ImageView avatar_m_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar);
        setTitle("Select Avatar");

        avatar_f_1=(ImageView)findViewById(R.id.avatar_f_1);
        avatar_f_2=(ImageView)findViewById(R.id.avatar_f_2);
        avatar_f_3=(ImageView)findViewById(R.id.avatar_f_3);
        avatar_m_1=(ImageView)findViewById(R.id.avatar_m_1);
        avatar_m_2=(ImageView)findViewById(R.id.avatar_m_2);
        avatar_m_3=(ImageView)findViewById(R.id.avatar_m_3);

        avatar_f_1.setOnClickListener(this);
        avatar_f_2.setOnClickListener(this);
        avatar_f_3.setOnClickListener(this);
        avatar_m_1.setOnClickListener(this);
        avatar_m_2.setOnClickListener(this);
        avatar_m_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String image_name;
        Intent intent=new Intent();

        if(v.getId()==R.id.avatar_f_1){

            image_name="avatar_f_1";
            intent.putExtra(MainActivity.Value,image_name);
            setResult(RESULT_OK,intent);

            finish();
        }
        else if(v.getId()==R.id.avatar_f_2){

            image_name="avatar_f_2";
            intent.putExtra(MainActivity.Value,image_name);
            setResult(RESULT_OK,intent);
            finish();

        }
        else if(v.getId()==R.id.avatar_f_3){

            image_name="avatar_f_3";
            intent.putExtra(MainActivity.Value,image_name);
            setResult(RESULT_OK,intent);
            finish();
        }

        else if(v.getId()==R.id.avatar_m_1){

            image_name="avatar_m_1";
            intent.putExtra(MainActivity.Value,image_name);
            setResult(RESULT_OK,intent);
            finish();
        }

        else if(v.getId()==R.id.avatar_m_2){

            image_name="avatar_m_2";
            intent.putExtra(MainActivity.Value,image_name);
            setResult(RESULT_OK,intent);
            finish();
        }

        else if(v.getId()==R.id.avatar_m_3){

            image_name="avatar_m_3";
            intent.putExtra(MainActivity.Value,image_name);
            setResult(RESULT_OK,intent);
            finish();
        }



    }
}
