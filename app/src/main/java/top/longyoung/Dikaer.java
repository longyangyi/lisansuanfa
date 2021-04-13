package top.longyoung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Dikaer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dikaer);
        final EditText input1=(EditText)findViewById(R.id.dikaerInput1);
        final EditText input2=(EditText)findViewById(R.id.dikaerInput2);
        final EditText input3=(EditText)findViewById(R.id.dikaerInput3);
        Button button=(Button)findViewById(R.id.dikaerButton);
        final EditText result=(EditText)findViewById(R.id.dijieResult);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=input1.getText().toString();
                String s2=input2.getText().toString();
                String s3=input3.getText().toString();
                String[] jihe1=s1.split(",");
                String[] jihe2=s2.split(",");
                String[] jihe3=s3.split(",");

                String re="A×B×C=\n{";
                String temp=null;
                for(int i=0;i<jihe1.length;i++) {
                    for (int j = 0; j < jihe2.length; j++) {
                        for (int k = 0; k < jihe3.length; k++) {
                            temp = "<" + jihe1[i] + "," + jihe2[j] + "," + jihe3[k] + ">,\n";
                            if (i == jihe1.length - 1 && j == jihe2.length - 1 && k == jihe3.length - 1) {
                                temp = "<" + jihe1[i] + "," + jihe2[j] + "," + jihe3[k] + ">}";
                            }
                            re += temp;
                        }
                    }
                }
                result.setText(re);
            }
        });
    }
}
