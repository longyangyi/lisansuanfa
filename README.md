【实验名称】		离散数学（上）三个算法编程		

【实验内容】

1、集合的笛卡尔乘积 算法编程要求

一、算法尽量作为软件来开发，即最后提交的是可视化的软件，软件实现的功能最少包括：

1、图形显示（应能让用户自主输入 集合元素）

2、图形显示笛卡尔乘积的结果

三、程序代码请给予详细解释。

四、最后将全部文件打包交给学习委员，由学习委员统一交给我,包括实验结果示例（Word），软件说明。

五、开发软件可选用 Java,.Net（VC，C#）等等。

六、文档命名格式：17 网络工程---某某。

七、最终提交时间：纸质版、电子版 2018 年 1 月 7 日晚 24：00 前。

2、二元关系的性质判断和闭包运算法编程要求

一、算法作为软件来开发，即最后提交的是可视化的软件，软件实现的功能最少包括：

1、图形初始化（应能让用户自主输入 集合和关系）

2、图形显示关系的集合,关系矩阵,关系图

3、算法执行的过程（给出最后的判定结果）

三、程序代码请给予详细解释。

四、最后将全部文件打包交给学习委员，由学习委员统一交给我,包括实验结果示例（Word），软件说明。

五、开发软件可选用 Java,.Net（VC，C#）等等。

六、文档命名格式：17 网络工程---某某。

七、最终提交时间：纸质版、电子版 2018 年 1 月 7 日晚 24：00 前。

3、二元关系的闭包运算法编程要求

一、算法作为软件来开发，即最后提交的是可视化的软件，软件实现的功能最少包括：

1、图形初始化（ 应能让用户自主输入集合和关系）

2、图形显示关系的集合, 关系矩阵, 关系图

3、算法执行的过程（给出最后的自反闭包, 对称闭包和传递闭包关系图及同时具有三种性质的关系图）

三、程序代码请给予详细解释。

四、最后将全部文件打包交给学习委员，由学习委员统一交给我,包括实验结果示例（Word），软件说明。

五、开发软件可选用 Java,.Net（VC，C#）等等。

六、文档命名格式：17 网络工程---某某。

七、最终提交时间：纸质版、电子版 2018 年 1 月 7 日晚 24：00 前。

 

【软件展示】



      

图片一：app图标                图片二：app主界面

 



    

图片三：集合的笛卡尔乘积         图片四：二元关系的性质判断

 



      

图片五、图片六：二元关系的闭包运算（运算结果过长，分两次截图）



附软件下载地址：www.longyoung.top/file/lisansuanfa.apk

注：自建服务器，偶尔开放

 

【核心算法展示】

注：安卓app开发过程代码量过多，仅展示核心算法


1.	集合的笛卡尔乘积

String s1=input1.getText().toString();

String s2=input2.getText().toString();

String s3=input3.getText().toString();//提取输入框字符串

String[] jihe1=s1.split(",");

String[] jihe2=s2.split(",");

String[] jihe3=s3.split(",");//将字符串按格式分隔成不同元素



String re="A×B×C=\n{";

String temp=null;

for(int i=0;i<jihe1.length;i++) {//遍历集合元素，进行笛卡尔乘积

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

result.setText(re); //输出结果到文本框

2.二元关系的性质判断

String[] A=input1.getText().toString().split(",");

String[] Rtemp=input3.getText().toString().split(" ");

String[][] Rr=new String[Rtemp.length][2]; //提取输入框字符串

for(int i=0;i<Rr.length;i++){//将字符串按格式分隔成不同元素

    Rr[i]=Rtemp[i].split(",");

}

String re="R={";

for(int i=0;i<Rr.length;i++){//将关系集合元素组合成字符串

    if(i==Rr.length-1){

        re+="<"+Rr[i][0]+","+Rr[i][1]+">}";

        break;

    }

    re+="<"+Rr[i][0]+","+Rr[i][1]+">,";

}

String res=re;

result.setText(res); //输出关系集合字符串输出到文本框



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

}//初始化关系矩阵juzhenNum

re="";

for(int i=0;i<A.length;i++){

    for(int j=0;j<A.length;j++){

        re+=juzhenNum[i][j];

    }

    if(i!=A.length-1){

        re+="\n";

    }



}

juzhen.setText(re); //输出关系矩阵到文本框

boolean zifan=true,fanzifan=true,duicheng=true,fanduicheng=true,chuandi=true;

for(int i=0;i<A.length;i++){

    if(juzhenNum[i][i]==0){

        zifan=false; //判断自反性

    }

    if(juzhenNum[i][i]==1){

        fanzifan=false; //判断反自反性

    }

    for(int j=0;j<=i;j++){

        if(juzhenNum[i][j]!=juzhenNum[j][i]){

            duicheng=false; //判断对称性

        }

        if(juzhenNum[i][j]!=juzhenNum[A.length-1-j][A.length-1-i]){

            fanduicheng=false; //判断反对称性

        }

    }

    for(int j=0;j<A.length;j++){

        if(juzhenNum[i][j]==1)

        {

            for(int k=0;k<A.length; k++)

            {

if(juzhenNum[j][k]==1&&juzhenNum[i][k]!=1)

{

    chuandi=false; //判断传递性

    break;

}

            }

        }

    }

}

juzhen.append("\n性质:"); //输出性质到文本框

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



3.二元关系的闭包运算

String[] A = input1.getText().toString().split(",");

String[] Rtemp = input3.getText().toString().split(" ");

String[][] Rr = new String[Rtemp.length][2];

for (int i = 0; i < Rr.length; i++) {

    Rr[i] = Rtemp[i].split(",");

} //提取输入框字符串，并整合

String re = "R={";//将关系集合元素组合成字符串

for (int i = 0; i < Rr.length; i++) {

    if (i == Rr.length - 1) {

        re += "<" + Rr[i][0] + "," + Rr[i][1] + ">}";

        break;

    }

    re += "<" + Rr[i][0] + "," + Rr[i][1] + ">,";

}

String res = re;

result.setText(res); //输出关系集合字符串输出到文本框



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

}//初始化关系矩阵juzhenNum

re = "";

for (int i = 0; i < A.length; i++) {

    for (int j = 0; j < A.length; j++) {

        re += juzhenNum[i][j];

    }

    re += "\n";



}

juzhen.setText(re); //输出关系矩阵到文本框



int l=juzhenNum.length;

int[][] t=juzhenNum;

for(int i=0;i<l;i++){

    t[i][i]=1;//进行自反闭包运算

}

re = "自反闭包:\n";

for (int i = 0; i < A.length; i++) {

    for (int j = 0; j < A.length; j++) {

        re += t[i][j];

    }

    re += "\n";

}

juzhen.append(re); //输出自反闭包运算结果到文本框





t=juzhenNum; //进行对称闭包运算

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

juzhen.append(re); //输出对称闭包运算结果到文本框





t=juzhenNum; //进行传递闭包运算

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

juzhen.append(re); //输出传递闭包运算结果到文本框


