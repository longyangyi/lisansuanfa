package top.longyoung;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ErYuanXingZhi extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_er_yuan_xing_zhi);


        TextView text=(TextView)findViewById(R.id.text);
        text.setText("二元关系的性质判断\n");

        final EditText input1=(EditText)findViewById(R.id.xingzhiInput1);
        final EditText input3=(EditText)findViewById(R.id.xingzhiInput3);
        final EditText result=(EditText)findViewById(R.id.xingzhiResult);

        final EditText juzhen=(EditText)findViewById(R.id.xingzhiResultJuzhen);

        Button button=(Button)findViewById(R.id.xingzhiButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] A=input1.getText().toString().split(",");
                String[] Rtemp=input3.getText().toString().split(" ");
                String[][] Rr=new String[Rtemp.length][2];
                for(int i=0;i<Rr.length;i++){
                    Rr[i]=Rtemp[i].split(",");
                }
                String re="R={";
                for(int i=0;i<Rr.length;i++){
                    if(i==Rr.length-1){
                        re+="<"+Rr[i][0]+","+Rr[i][1]+">}";
                        break;
                    }
                    re+="<"+Rr[i][0]+","+Rr[i][1]+">,";
                }
                String res=re;
                result.setText(res);

                int[][] juzhenNum=new int[A.length][A.length];
                for(int i=0;i<A.length;i++){
                    for(int j=0;j<A.length;j++){
                        juzhenNum[i][j]=0;
                        for(int k=0;k<Rr.length;k++){
                            if(Rr[k][0].equals(A[i])&&Rr[k][1].equals(A[j])){
                                juzhenNum[i][j]=1;
                            }
                        }
                    }
                }
                re="";
                for(int i=0;i<A.length;i++){
                    for(int j=0;j<A.length;j++){
                        re+=juzhenNum[i][j];
                    }
                    if(i!=A.length-1){
                        re+="\n";
                    }

                }
                juzhen.setText(re);
                boolean zifan=true,fanzifan=true,duicheng=true,fanduicheng=true,chuandi=true;
                for(int i=0;i<A.length;i++){
                    if(juzhenNum[i][i]==0){
                        zifan=false;
                    }
                    if(juzhenNum[i][i]==1){
                        fanzifan=false;
                    }
                    for(int j=0;j<=i;j++){
                        if(juzhenNum[i][j]!=juzhenNum[j][i]){
                            duicheng=false;
                        }
                        if(juzhenNum[i][j]!=juzhenNum[A.length-1-j][A.length-1-i]){
                            fanduicheng=false;
                        }
                    }
                    for(int j=0;j<A.length;j++){
                        if(juzhenNum[i][j]==1)
                        {
                            for(int k=0;k<A.length; k++)
                            {
                                if(juzhenNum[j][k]==1&&juzhenNum[i][k]!=1)
                                {
                                    chuandi=false;
                                    break;
                                }
                            }
                        }
                    }
                }
                juzhen.append("\n性质:");
                if(zifan){
                    juzhen.append("自反 ");
                }
                if(fanzifan){
                    juzhen.append("反自反 ");
                }
                if(duicheng){
                    juzhen.append("对称 ");
                }
                if(fanduicheng){
                    juzhen.append("反对称 ");
                }
                if(chuandi){
                    juzhen.append("传递 ");
                }

            }
        });




    }
}
