package top.longyoung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bibao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_er_yuan_xing_zhi);

        TextView text=(TextView)findViewById(R.id.text);
        text.setText("二元关系的闭包运算\n");
        final EditText input1 = (EditText) findViewById(R.id.xingzhiInput1);
        final EditText input3 = (EditText) findViewById(R.id.xingzhiInput3);
        final EditText result = (EditText) findViewById(R.id.xingzhiResult);

        final EditText juzhen = (EditText) findViewById(R.id.xingzhiResultJuzhen);

        Button button = (Button) findViewById(R.id.xingzhiButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] A = input1.getText().toString().split(",");
                String[] Rtemp = input3.getText().toString().split(" ");
                String[][] Rr = new String[Rtemp.length][2];
                for (int i = 0; i < Rr.length; i++) {
                    Rr[i] = Rtemp[i].split(",");
                }
                String re = "R={";
                for (int i = 0; i < Rr.length; i++) {
                    if (i == Rr.length - 1) {
                        re += "<" + Rr[i][0] + "," + Rr[i][1] + ">}";
                        break;
                    }
                    re += "<" + Rr[i][0] + "," + Rr[i][1] + ">,";
                }
                String res = re;
                result.setText(res);

                int[][] juzhenNum = new int[A.length][A.length];
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A.length; j++) {
                        juzhenNum[i][j] = 0;
                        for (int k = 0; k < Rr.length; k++) {
                            if (Rr[k][0].equals(A[i]) && Rr[k][1].equals(A[j])) {
                                juzhenNum[i][j] = 1;
                            }
                        }
                    }
                }
                re = "";
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A.length; j++) {
                        re += juzhenNum[i][j];
                    }
                    re += "\n";

                }
                juzhen.setText(re);

                int l=juzhenNum.length;
                int[][] t=juzhenNum;
                for(int i=0;i<l;i++){
                    t[i][i]=1;
                }
                re = "自反闭包:\n";
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A.length; j++) {
                        re += t[i][j];
                    }
                    re += "\n";
                }
                juzhen.append(re);


                t=juzhenNum;
                for(int i=0;i<l;i++){
                    for(int j=0;j<l;j++){
                        if(t[i][j]==1){
                            t[j][i]=1;
                        }
                    }
                }
                re = "对称闭包:\n";
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A.length; j++) {
                        re += t[i][j];
                    }
                    re += "\n";
                }
                juzhen.append(re);


                t=juzhenNum;
                for(int i = 0;i<l;i++) {
                    for(int j = 0;j<l;j++) {
                        if(t[j][i]==1) {
                            for(int k = 0;k<l;k++) {
                                t[j][k] = t[j][k]+t[i][k];
                                if(t[j][k]>=1)
                                    t[j][k] = 1;
                            }
                        }
                    }
                }
                re = "传递闭包:\n";
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A.length; j++) {
                        re += t[i][j];
                    }
                    re += "\n";
                }
                juzhen.append(re);

            }
        });
    }
}