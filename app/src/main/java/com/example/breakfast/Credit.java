package com.example.breakfast;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Credit extends AppCompatActivity {
    String account;
   private Toast t1,t2;
    int sum;
    Button pay;
    TextView t,total;
    EditText name,phone,credit,date,pass,note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        Intent intent = getIntent();
        account = intent.getStringExtra("Account");
        sum=intent.getIntExtra("Total",0);
        t=(TextView)findViewById(R.id.textView2);
        total=(TextView)findViewById(R.id.textView13);
        pay=(Button)findViewById(R.id.button16);
        name=(EditText)findViewById(R.id.editText8);
        phone=(EditText)findViewById(R.id.editText10);
        credit=(EditText)findViewById(R.id.editText11);
        date=(EditText)findViewById(R.id.editText12);
        pass=(EditText)findViewById(R.id.editText16);
        note=(EditText)findViewById(R.id.editText9);
        pay.setOnClickListener(btn);
        t.setText("請輸入付款資訊"+account);
        total.setText("總金額："+String.valueOf(sum));
       t1=Toast.makeText(this,"欄位有空",Toast.LENGTH_SHORT);
        t2=Toast.makeText(this,"付款成功",Toast.LENGTH_SHORT);
    }
    private Button.OnClickListener btn=new Button.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button16:
                    if(name.getText().toString().equals("")==true||pass.getText().toString().equals("")==true||phone.getText().toString().equals("")==true||credit.getText().toString().equals("")==true||date.getText().toString().equals("")==true){
                        t1.show();
                    }
                    else {
                        new AlertDialog.Builder(Credit.this)
                                .setTitle("警告視窗")
                                .setMessage("確定付款?")
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent();
                                        intent.setClass(Credit.this, Final.class);
                                        intent.putExtra("Name",name.getText().toString());
                                        t2.show();
                                        startActivity(intent);
                                    }
                                })
                                .show();

                    }
                    break;
            }
        }


    };
}
