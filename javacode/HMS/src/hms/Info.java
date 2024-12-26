package hms;
import java.sql.Date;
import java.util.*;
import java.text.*;

public class Info {

}

class Customer{//顾客
    String Name;//姓名
    String Cid;//身份证号码
    String Rid;//房间号码
    String Phonenum;//联系方式
    Boolean vip;//会员
    String Cpassword;//密码
    Date Intime;//入住时间
    Date Outtime;//离开时间
    Date Indeedin;//实际入住时间
    Date Indeedout;//实际离开时间
    public Customer(String name, String cid, String rid, String phonenum, Boolean vip, String Cpassword,Date intime, Date outtime, Date indeedin, Date indeedout) {
        this.Name = name;
        this.Cid = cid;
        this.Rid = rid;
        this.Phonenum = phonenum;
        this.vip = vip;
        this.Intime = intime;
        this.Outtime = outtime;
        this.Indeedin = indeedin;
        this.Indeedout = indeedout;
        this.Cpassword=Cpassword;
    }

}

class Suggestions{//反馈建议
    String SUid;//建议号
    String Cid;//身份证号
    String SUcontent;//建议内容
    Date SUtime;//建议发布时间
    public Suggestions(String suid, String cid, String sucontent, String sutime) {
        SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.SUid = suid;
        this.Cid = cid;
        this.SUcontent = sucontent;
        try {
            this.SUtime = (Date) timeFormat.parse(sutime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

class Entertainments{//娱乐项目
    String Eid;//项目号
    String Ename;//项目名
    int Esum;//容纳人数
    int Ebook;//已预约数
    public Entertainments(String eid, String ename, int esum, int ebook) {
        this.Eid = eid;
        this.Ename = ename;
        this.Esum = esum;
        this.Ebook = ebook;
    }
}

class Preservation{//项目预约
    String Eid;//项目号
    String Cid;//身份证号
    Date Ptime;//预约时间
    public Preservation(String eid, String cid, String ptime)  {
        SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.Eid = eid;
        this.Cid = cid;
        try {
            this.Ptime = (Date)timeFormat.parse(ptime);
        }catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

class Bill{//账单
    String Bid;//账单号
    String Cid;//身份证号
    String HSid;//工号
    Float Bprice;//收款金额
    Date Btime;//收款时间
    public Bill(String bid, String cid, String hsid, Float bprice, String btime){
        SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.Bid = bid;
        this.Cid = cid;
        this.HSid = hsid;
        this.Bprice = bprice;
        try {
            this.Btime = (Date) timeFormat.parse(btime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

class Buildings { //楼栋
    int BLid; //楼号
    String BLname; //楼栋名
    String BLmangerid; //楼栋经理工号

    public Buildings(int BLid, String BLname,String BLmangerid){
        this.BLid=BLid;
        this.BLname=BLname;
        this.BLmangerid=BLmangerid;
    }
}

class Room{//房间
    String Rid;//房间号
    int BLid;//楼栋号
    String Rtype;//房型
    Float Rprice;//价格
    String Rstate;//状态
    public Room(String Rid,int BLid,String Rtype,Float Rprice,String Rstate){
        this.Rid=Rid;
        this.BLid=BLid;
        this.Rtype=Rtype;
        this.Rprice=Rprice;
        this.Rstate=Rstate;
    }
}

class RoomService{//客房服务
    String Sid;//服务号
    String Rid;//房间号
    String Scontent;//服务内容
    Date Stime;//服务时间
    public RoomService(String sid, String rid, String scontent, String stime){
        SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.Sid = sid;
        this.Rid = rid;
        this.Scontent = scontent;
        try {
            this.Stime = (Date) timeFormat.parse(stime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

class HotelStaff{//酒店员工
    String HSid;//工号
    String HSname;//姓名
    int HSage;//年龄
    String HSposition;//职位
    Boolean HSpermission;//管理权限
    String HSpassword;//密码
    String HSphone;//联系方式
    public HotelStaff(String HSid,String HSname,int HSage,String HSposition,Boolean HSpermission,String HSpassword,String HSphone){
        this.HSage=HSage;
        this.HSphone=HSphone;
        this.HSid=HSid;
        this.HSname=HSname;
        this.HSposition=HSposition;
        this.HSpermission=HSpermission;
        this.HSpassword=HSpassword;
    }

}


