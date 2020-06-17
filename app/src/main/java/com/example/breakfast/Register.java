package com.example.breakfast;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends AppCompatActivity {


    EditText edit3;
    private MySqlist mys;
    EditText edit4;
    EditText name1;
    EditText phone1;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.activity_zhu)
    RelativeLayout activityZhu;
    private SQLiteDatabase sdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edit3=(EditText)findViewById(R.id.editText3);
        edit4=(EditText)findViewById(R.id.editText4);
        name1=(EditText)findViewById(R.id.editText6);
        phone1=(EditText)findViewById(R.id.editText7);
        ButterKnife.bind(this);
        mys = new MySqlist(this, "zhu_c", null, 1);//使用halper建立資料庫
        sdb=mys.getWritableDatabase();
    }
    @OnClick(R.id.button3)
    public void onViewClicked1(View view) {
//獲得賬號密碼

        String account = edit3.getText().toString();
        String pass = edit4.getText().toString();
        String name=name1.getText().toString();
        String phone=phone1.getText().toString();

        if (account == null || "".equals(account) || pass == null || "".equals(pass)||name == null || "".equals(name) || phone == null || "".equals(phone)) {
            Toast.makeText(this, "賬號與密碼不能為空", Toast.LENGTH_SHORT).show();
        }
        else if(isMobile(phone)==false) Toast.makeText(this, "手機格式有錯", Toast.LENGTH_SHORT).show();
        else if(isPassword(pass)==false)Toast.makeText(this, "密碼太短", Toast.LENGTH_SHORT).show();
        else if(isExist(account)==false)Toast.makeText(this, "帳號已被使用", Toast.LENGTH_SHORT).show();
        else {
                Toast.makeText(this, "註冊成功", Toast.LENGTH_SHORT).show();
                sdb.execSQL("insert into user(account,pass,name,phone)values('"+account+"','"+pass+"','"+name+"','"+phone+"')");
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);//啟動跳轉
            }
        }

    /**
     * 校驗密碼
     * @param password
     * @return 校驗通過返回true，否則返回false
     */
    public static boolean isPassword(String password) {
        if(password.length()<8) return false;
        else return true;

    }
    public boolean isExist(String account1) {
         MySqlist mys;

        SQLiteDatabase r;
        mys = new MySqlist(this, "zhu_c", null, 1);//使用halper建立資料庫
        r=mys.getReadableDatabase();


        Cursor query = r.rawQuery("select * from user", null);
        int index1 = query.getColumnIndex("account");
        while (query.moveToNext()) {

            String name = query.getString(index1);
           if (account1.equals(name)) return false;
        }

        return true;

    }
    /**
     * 驗證手機格式
     */
    public static boolean isMobile(String number) {
        if (number.length()==10 && number.substring(0,2).equals("09")) return true;
        else return false;


    }
}
