/*
 ************************ Assignment #InClass 03 *******************************************
 *********************** File Name- display_profile.java *************************************
 ************************ Full Name- 1. Manali Ghare 2. Anup Deshpande (Group 19) ***********

 */




package com.example.manalighare.inclass03;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class display_profile extends AppCompatActivity {

    private TextView name;
    private TextView dept;
    private TextView s_id;
    private ImageView dp;
    private Button edit;

    private String full_name;
    private String department;
    private String student_id;
    private String display_pic;

    public static String STUDENT_KEY1="STUDENT";
    public static int RESULT_CODE=1;

    private Student obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);
        setTitle("Display My Profile");

         obj= (Student) getIntent().getExtras().getSerializable(MainActivity.STUDENT_KEY);

        name=(TextView)findViewById(R.id.display_name);
        dept=(TextView)findViewById(R.id.display_department);
        s_id=(TextView)findViewById(R.id.display_ID);
        dp=(ImageView) findViewById(R.id.imageView);
        edit=(Button)findViewById(R.id.edit);

        full_name=obj.getFname()+" "+obj.getLname();
        department=obj.getDept();
        student_id=obj.getS_ID();
        display_pic=obj.getImage_name();

        name.setText(full_name);
        dept.setText(department);
        s_id.setText(String.valueOf(student_id));
        Log.d("student id : "," "+student_id);



        if(display_pic.equals("avatar_f_1")){
            dp.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_f_1));
        }
        else if (display_pic.equals("avatar_f_2")){
            dp.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_f_2));
        }
        else if (display_pic.equals("avatar_f_3")){
            dp.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_f_3));
        }
        else if (display_pic.equals("avatar_m_1")){
            dp.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_m_1));
        }
        else if (display_pic.equals("avatar_m_2")){
            dp.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_m_2));
        }
        else if (display_pic.equals("avatar_m_3")){
            dp.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_m_3));
        }


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra(STUDENT_KEY1,obj);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
