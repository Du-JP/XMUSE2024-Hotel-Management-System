# XMUSE2024-Hotel-Management-System
22920212204074   杜俊鹏<br>
22920212204332   朱卉祥<br>
22920212204100   黄杰<br>
22920212204095   胡康<br>
22920212204248   熊凯
# 安装方法（要在数据库配置好的情况下才能访问数据库）
## 数据库安装方法
### 1、导入
将目录为SQL里面的HotelMange数据库里的两个文件导入SQLserver-2019中。
### 2、数据库设置
final String DB_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=HotelMange"; // 数据库URL

final String USER = "sa"; // 数据库用户名

final String PASS = "djp123123"; // 数据库密码

这是数据库的设置，导入后要设置正确。
### 3、连接设置
键盘上按下win+r，打开SQLServerManager16.msc，如下图

![image](https://github.com/user-attachments/assets/9f949617-a851-4e64-9a1f-2515a8d07408)

进行如下设置：

![image](https://github.com/user-attachments/assets/5b3106e7-cd63-457f-9b47-4be265f2f10b)

![image](https://github.com/user-attachments/assets/2873de49-7d1d-466e-ad44-7217560e345a)


## java代码使用方法
方法1：首先要把驱动（sqljdbc41.jar）安装好，驱动也已经上传到github上了。

运行Home.java即可运行程序。

方法2：点击hms.exe即可运行
