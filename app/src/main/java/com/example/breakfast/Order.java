package com.example.breakfast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class Order extends AppCompatActivity {
    private Toast t,t1,tc;
    Button logout;
    TextView name;
    Button add;
    Button next;
    Button plus1,minus1,plus2,minus2,plus3,minus3,plus4,minus4;
    EditText b1,b2,b3,b4;
    Intent intent = new Intent();
    //Intent intent2 = new Intent(this, Pay.class);
    Bundle bag = new Bundle();
    String Account;
    int check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent1=getIntent();
        Account = intent1.getStringExtra("Account");
        logout=(Button)findViewById(R.id.button12);
        next=(Button)findViewById(R.id.button9);
        name=(TextView)findViewById(R.id.name);
        add=(Button)findViewById(R.id.button13);
        b1=(EditText)findViewById(R.id.editText2);
        b2=(EditText)findViewById(R.id.editText3);
        b3=(EditText)findViewById(R.id.editText4);
        b4=(EditText)findViewById(R.id.editText5);
        plus1=(Button)findViewById(R.id.button3);
        plus2=(Button)findViewById(R.id.button5);
        plus3=(Button)findViewById(R.id.button7);
        plus4=(Button)findViewById(R.id.button10);
        minus1=(Button)findViewById(R.id.button4);
        minus2=(Button)findViewById(R.id.button6);
        minus3=(Button)findViewById(R.id.button8);
        minus4=(Button)findViewById(R.id.button11);
        plus1.setOnClickListener(btn);
        plus2.setOnClickListener(btn);
        plus3.setOnClickListener(btn);
        plus4.setOnClickListener(btn);
        minus4.setOnClickListener(btn);
        minus3.setOnClickListener(btn);
        minus2.setOnClickListener(btn);
        minus1.setOnClickListener(btn);

intent.setClass(this,Pay.class);



        tc=makeText(this,"購物車不能為空", LENGTH_SHORT);

       name.setText(Account);
       t= makeText(this, "登出成功", LENGTH_LONG);
        t1= makeText(this,"加入成功", LENGTH_SHORT);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.show();
                Intent intent1 = new Intent();
                intent1.setClass(Order.this,MainActivity.class);
                startActivity(intent1);



            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(check==0) {
                    tc.show();
                }
                else {
                    intent.putExtra("Account", Account);
                    startActivity(intent);

                }

            }
        });
        //加入購物車
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup1);

                //依選取項目顯示不同訊息
                switch(rg.getCheckedRadioButtonId()){
                    case R.id.radioButton3:

                        String e1=b1.getText().toString();
                        if(e1.equals("0")==false) check++;
                        bag.putString("a1", "培根蛋餅");
                        bag.putString("c1", e1);
                        intent.putExtras(bag);
                         //顯示結果
                        break;
                    case R.id.radioButton4:
                        String e2=b2.getText().toString();
                        if(e2.equals("0")==false) check++;
                        bag.putString("a2", "鮪魚蛋餅");
                        bag.putString("c2", e2);
                        intent.putExtras(bag);
                        break;
                    case R.id.radioButton5:
                        String e3=b3.getText().toString();
                        if(e3.equals("0")==false) check++;
                        bag.putString("a3", "起士蛋餅");
                        bag.putString("c3", e3);
                        intent.putExtras(bag);
                        break;
                    case R.id.radioButton6:
                        String e4=b4.getText().toString();
                        if(e4.equals("0")==false) check++;
                        bag.putString("a4", "火腿蛋餅");
                        bag.putString("c4", e4);
                        intent.putExtras(bag);
                        break;
                }

                t1.show();



            }
        });
    }
    private Button.OnClickListener btn=new Button.OnClickListener(){
        public void onClick(View view) {
            String e1=b1.getText().toString();
            int s1=Integer.parseInt(e1);
            String e2=b2.getText().toString();
            int s2=Integer.parseInt(e2);
            String e3=b3.getText().toString();
            int s3=Integer.parseInt(e3);
            String e4=b4.getText().toString();
            int s4=Integer.parseInt(e4);
            // TODO Auto-generated method stub
            switch (view.getId()) {
                case R.id.button4:
                    s1++;
                    b1.setText(String.valueOf(s1));
                    break;
                case R.id.button3:
                    if(s1==0) break;
                    else {
                        s1--;
                        b1.setText(String.valueOf(s1));
                        break;
                    }
                case R.id.button6:
                    s2++;
                    b2.setText(String.valueOf(s2));
                    break;
                case R.id.button5:
                    if(s2==0) break;
                    else {
                        s2--;
                        b2.setText(String.valueOf(s2));
                        break;
                    }
                case R.id.button8:
                    s3++;
                    b3.setText(String.valueOf(s3));
                    break;
                case R.id.button7:
                    if(s3==0) break;
                    else {
                        s3--;
                        b3.setText(String.valueOf(s3));
                        break;
                    }
                case R.id.button11:
                    s4++;
                    b4.setText(String.valueOf(s4));
                    break;
                case R.id.button10:
                    if(s4==0) break;
                    else {
                        s4--;
                        b4.setText(String.valueOf(s4));
                        break;
                    }
            }

        }


        };


}