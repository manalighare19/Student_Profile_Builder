/*
 ************************ Assignment #InClass 03 *******************************************
 *********************** File Name- MainActivity.java *************************************
 ************************ Full Name- 1. Manali Ghare 2. Anup Deshpande (Group 19) ***********

 */




package com.example.manalighare.inclass03;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private ImageView avatar;

    private Button save;

    private EditText fname;
    private EditText lname;
    private EditText s_id;
    private RadioGroup dept_group;


    private String dept_name;
    private String first_name;
    private String last_name;
    private String student__id;
    private String image_name="";


    public static final int PICK_REQUEST2 = 2;
    public static final int PICK_REQUEST=1;
    public static String STUDENT_KEY="STUDENT";
    public static final String Value="Value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Profile");

        avatar=(ImageView) findViewById(R.id.avatar);
        save=(Button) findViewById(R.id.save);
        fname=(EditText) findViewById(R.id.f_name);
        lname=(EditText) findViewById(R.id.l_name);
        s_id=(EditText) findViewById(R.id.student_id);
        dept_group=(RadioGroup) findViewById(R.id.department);



        avatar.setOnClickListener(this);
        save.setOnClickListener(this);

        dept_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=(RadioButton) findViewById(checkedId);
                dept_name=rb.getText().toString();

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.avatar){
            Intent intent=new Intent(this,select_avatar.class);
            startActivityForResult(intent,PICK_REQUEST);
        }
        else if(v.getId()==R.id.save){

            if(fname.getText().length()==0 || lname.getText().length()==0 || s_id.getText().length()==0|| dept_group.getCheckedRadioButtonId()==-1){
                Toast.makeText(this,"Please complete the form ",Toast.LENGTH_LONG).show();
            }
            else if(s_id.getText().length()<9){
                Toast.makeText(this,"Please enter 9 digit student ID",Toast.LENGTH_LONG).show();
            }else if(image_name.length()==0){
                Toast.makeText(this,"Please choose avatar",Toast.LENGTH_LONG).show();
            }

            else{
                first_name=fname.getText().toString();
                last_name=lname.getText().toString();
                student__id=s_id.getText().toString();


                Student obj=new Student(first_name,last_name,student__id,dept_name,image_name);

                Log.d("img"," "+image_name);
                Intent intent=new Intent(MainActivity.this,display_profile.class);
                intent.putExtra(STUDENT_KEY,obj);
                startActivityForResult(intent,PICK_REQUEST2);


            }


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        Log.d("Result code is "," "+resultCode);
        Log.d("request code is : "," "+requestCode);

        if(requestCode==PICK_REQUEST){

                   if(resultCode==RESULT_OK){
                        image_name=data.getExtras().getString(Value);


                        if(image_name.equals("avatar_f_1")){
                            avatar.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_f_1));
                        }
                        else if (image_name.equals("avatar_f_2")){
                            avatar.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_f_2));
                        }
                        else if (image_name.equals("avatar_f_3")){
                            avatar.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_f_3));
                        }
                        else if (image_name.equals("avatar_m_1")){
                            avatar.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_m_1));
                        }
                        else if (image_name.equals("avatar_m_2")){
                            avatar.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_m_2));
                        }
                        else if (image_name.equals("avatar_m_3")){
                            avatar.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.avatar_m_3));
                        }
                    }

                }

        if (requestCode==PICK_REQUEST2) {

            if(resultCode==RESULT_OK) {
                fname.setText(" ");
                lname.setText(" ");
                s_id.setText(" ");



                Student obj=(Student) data.getExtras().getSerializable(display_profile.STUDENT_KEY1);
                fname.setText(obj.getFname().toString());
                lname.setText(obj.getLname().toString());
                s_id.setText(obj.getS_ID().toString());
                dept_name=obj.getDept();
                if(dept_name.equals("CS")){
                    dept_group.check(R.id.CS);
                }else if(dept_name.equals("BIO")){
                    dept_group.check(R.id.bio);
                }else if(dept_name.equals("SIS")){
                    dept_group.check(R.id.sis);
                }else if(dept_name.equals("Other")){
                    dept_group.check(R.id.other);
                }


            }


        }






    }
}
