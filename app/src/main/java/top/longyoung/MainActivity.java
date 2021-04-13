package top.longyoung;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dikaer=(Button)findViewById(R.id.dikaer);
        dikaer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, Dikaer.class);
                startActivity(i);
            }
        });
        Button xingzhi=(Button)findViewById(R.id.xingzhi);
        xingzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, ErYuanXingZhi.class);
                startActivity(i);
            }
        });
        Button bibao=(Button)findViewById(R.id.bibao);
        bibao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, bibao.class);;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                startActivity(i);
            }
        });
    }
}
