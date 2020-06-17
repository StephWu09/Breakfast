package com.example.breakfast;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    EditText edit;

    EditText edit2;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";//驗證密碼是否有特殊符號或長度不滿6位
    private SQLiteDatabase w;
    private SQLiteDatabase r;
    private MySqlist mys;
    private List<st> mdata;
    private String account;
    private String pass;
    Cursor query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit=(EditText)findViewById(R.id.editText);
        edit2=(EditText)findViewById(R.id.editText2);
        ButterKnife.bind(this);
        mys = new MySqlist(this, "zhu_c", null, 1);//使用halper建立資料庫
        r=mys.getReadableDatabase();
        w=mys.getWritableDatabase();


        /*while(query.moveToNext()){
            int index1 = query.getColumnIndex("account");
            int index2 = query.getColumnIndex("pass");
            account = query.getString(index1);
            pass = query.getString(index2);
            mdata.add(new st(0, account, pass));
        }*/
    }
    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                query = r.rawQuery("select * from user", null);
                String account1 = edit.getText().toString();
                String pass1 = edit2.getText().toString();
                while(query.moveToNext()) {
                    int index1 = query.getColumnIndex("account");
                    int index2 = query.getColumnIndex("pass");
                    account = query.getString(index1);
                    pass = query.getString(index2);
                    if (account1.equals(account) && pass1.equals(pass)) {
                        Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, Order.class);
                        intent.putExtra("Account", account1);
                        startActivity(intent);
                    return;
                    }
                }

                    Toast.makeText(this,"賬號與密碼輸入不正確",Toast.LENGTH_SHORT).show();

                break;
            case R.id.button2:
                Intent intent1 = new Intent(this, Register.class);
                startActivity(intent1);
                break;
        }
    }
}
