package com.example.breakfast;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Final extends AppCompatActivity {
    String name;
    TextView n,id,time,con;
    Button home,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        n=(TextView)findViewById(R.id.textView17);
        id=(TextView)findViewById(R.id.textView14);
        time=(TextView)findViewById(R.id.textView16);
        home=(Button)findViewById(R.id.button18);
        con=(TextView)findViewById(R.id.textView18);
        cancel=(Button)findViewById(R.id.button17);
        home.setOnClickListener(btn);
        cancel.setOnClickListener(btn);
        n.setText("付款人姓名："+name);

        int j =(int)(Math.random()*(9999))+1;
        id.setText("訂單編號："+String.valueOf(j));
        int i =(int)(Math.random()*(26))+5;
        time.setText("剩餘時間："+String.valueOf(i));


    }
    private Button.OnClickListener btn=new Button.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button17:

                    new AlertDialog.Builder(Final.this)
                            .setTitle("警告視窗")
                            .setMessage("確定取消訂單?")
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    con.setText("已向店家提出取消訂單");
                                }
                            })
                            .show();
                    break;
                case R.id.button18:

                    new AlertDialog.Builder(Final.this)
                            .setTitle("警告視窗")
                            .setMessage("確定登出?")
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent();
                                    intent.setClass(Final.this, MainActivity.class);

                                    startActivity(intent);
                                }
                            })
                            .show();
                    break;
            }
        }
};
}

