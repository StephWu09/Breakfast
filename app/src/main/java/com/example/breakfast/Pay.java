package com.example.breakfast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pay extends AppCompatActivity {
    Button back,pay;
    TextView t1,t2,t3,t4,m;
    String a1,a2,a3,a4,c1,c2,c3,c4,account;
    String fin="";
    String toa="";
    String tal="";
    int sum=0;
    ArrayList<String> name = new ArrayList();
    ArrayList<String> count = new ArrayList();
    ArrayList<String> total=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Intent intent = getIntent();
        account=intent.getStringExtra("Account");
        if(intent.hasExtra("a1") && intent.getExtras().getString("c1").equals("0")==false) {
            a1 = intent.getExtras().getString("a1");
            name.add(a1);
         c1 = intent.getExtras().getString("c1");
         count.add(c1);
         int i=Integer.parseInt(c1)*35;
         sum=sum+i;
         total.add(String.valueOf(i));
                                }
        if(intent.hasExtra("a2") && intent.getExtras().getString("c2").equals("0")==false) {
            a2 = intent.getExtras().getString("a2");
            name.add(a2);
            c2 = intent.getExtras().getString("c2");
            count.add(c2);
            int i=Integer.parseInt(c2)*35;
            sum=sum+i;
            total.add(String.valueOf(i));
        }
        if(intent.hasExtra("a3") && intent.getExtras().getString("c3").equals("0")==false) {
            a3 = intent.getExtras().getString("a3");
            name.add(a3);
            c3 = intent.getExtras().getString("c3");
            count.add(c3);
            int i=Integer.parseInt(c3)*30;
            sum=sum+i;
            total.add(String.valueOf(i));
        }
        if(intent.hasExtra("a4") && intent.getExtras().getString("c4").equals("0")==false) {
            a4 = intent.getExtras().getString("a4");
            name.add(a4);
            c4 = intent.getExtras().getString("c4");
            count.add(c4);
            int i=Integer.parseInt(c4)*25;
            sum=sum+i;
            total.add(String.valueOf(i));
        }
t1=(TextView)findViewById(R.id.textView8);

        t1.setText(account+"，您的訂單：");
        back=(Button)findViewById(R.id.button14);
        pay=(Button)findViewById(R.id.button15);
        back.setOnClickListener(btn);
        pay.setOnClickListener(btn);
        t2=(TextView)findViewById(R.id.textView9);
        t3=(TextView)findViewById(R.id.textView11);
        t4=(TextView)findViewById(R.id.textView12);
        m=(TextView)findViewById(R.id.textView13);
        String[] n = name.toArray(new String[name.size()]);
        String[] c = count.toArray(new String[count.size()]);
        String[] t = total.toArray(new String[total.size()]);
        for(String a:n){
            fin=a+"\n"+fin;
        }
        for(String a:c){
            toa="x"+a+"\n"+toa;
        }
        for(String a:t){
            tal=a+"\n"+tal;
        }
        t2.setText(fin);
        t3.setText(toa);
        t4.setText(tal);
        m.setText("總金額："+String.valueOf(sum));

    }
    private Button.OnClickListener btn=new Button.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button14:

                    Intent intent1 = new Intent();
                    intent1.setClass(Pay.this, Order.class);
                    intent1.putExtra("Account", account);
                    startActivity(intent1);
                    break;
                case R.id.button15:

                    Intent intent2 = new Intent();
                    intent2.setClass(Pay.this, Credit.class);
                    intent2.putExtra("Account", account);
                    intent2.putExtra("Total",sum);
                    startActivity(intent2);
            }
        }
    };
}