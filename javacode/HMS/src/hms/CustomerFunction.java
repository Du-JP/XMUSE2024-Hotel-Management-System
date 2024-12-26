package hms;

import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerFunction { //顾客功能类
    String c_num;
    JFrame CustomerJFrame=new JFrame("酒店管理系统-----[顾客模式]");
    Container CustomerCon=CustomerJFrame.getContentPane();
    JPanel pn_function=new JPanel(); //放置各种功能页面的容器
    JLabel lb_tips=new JLabel(); //提示窗口的内容

    public CustomerFunction(String Customer_num) { // 整体界面
        this.c_num = Customer_num;

        CustomerJFrame.setSize(1300, 800);
        CustomerJFrame.setLocationRelativeTo(null);
        CustomerJFrame.setResizable(false);
        CustomerJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CustomerCon.setLayout(null);
        pn_function.setLayout(null);
        pn_function.setBorder(BorderFactory.createEtchedBorder());
        pn_function.setBounds(250, 30, 1045, 735);

        JPanel pn1 = new JPanel(); // 顶部信息栏，操作者
        pn1.setBackground(Color.white);
        pn1.setBounds(0, 0, 250, 30);
        JLabel lb1 = new JLabel("顾客：" + Customer_num);
        lb1.setFont(new Font("黑体", 0, 18));
        lb1.setForeground(Color.blue);
        pn1.add(lb1);

        JPanel pn2 = new JPanel(); // 顶部信息栏，当前功能
        pn2.setBackground(Color.white);
        pn2.setBounds(250, 0, 1045, 30);
        JLabel lb2 = new JLabel("");
        lb2.setFont(new Font("黑体", 0, 20));
        lb2.setForeground(Color.black);
        pn2.add(lb2);

        JPanel pn_menu = new JPanel(); // 菜单，进行功能选择
        pn_menu.setBackground(new Color(249, 250, 252));
        pn_menu.setBorder(BorderFactory.createEtchedBorder());
        pn_menu.setLayout(null);
        pn_menu.setBounds(0, 30, 250, 735);

        JButton bt1 = new JButton("个人信息"); // [个人信息]
        bt1.setFont(new Font("黑体", 0, 20));
        bt1.setContentAreaFilled(false);
        bt1.setBounds(0, 50, 249, 50);

        JButton bt2 = new JButton("客房服务"); // [客房服务]
        bt2.setFont(new Font("黑体", 0, 20));
        bt2.setContentAreaFilled(false);
        bt2.setBounds(0, 105, 249, 50);

        JButton bt6 = new JButton("娱乐项目预约"); // [娱乐项目预约]
        bt6.setFont(new Font("黑体", 0, 20));
        bt6.setContentAreaFilled(false);
        bt6.setBounds(0, 160, 249, 50);

        JButton bt7 = new JButton("账单支付（到前台）"); // [支付]
        bt7.setFont(new Font("黑体", 0, 20));
        bt7.setContentAreaFilled(false);
        bt7.setBounds(0, 215, 249, 50);

        JButton bt3 = new JButton("建议与反馈"); // [建议与反馈]
        bt3.setFont(new Font("黑体", 0, 20));
        bt3.setContentAreaFilled(false);
        bt3.setBounds(0, 270, 249, 50);

        JButton bt4 = new JButton("修改密码"); // [修改密码]
        bt4.setFont(new Font("黑体", 0, 20));
        bt4.setContentAreaFilled(false);
        bt4.setBounds(0, 325, 249, 50);

        JButton bt5 = new JButton("退出"); // [退出]
        bt5.setFont(new Font("黑体", 0, 20));
        bt5.setContentAreaFilled(false);
        bt5.setBounds(0, 380, 249, 50);

        pn_menu.add(bt1);
        pn_menu.add(bt2);
        pn_menu.add(bt6);
        pn_menu.add(bt7);
        pn_menu.add(bt3);
        pn_menu.add(bt4);
        pn_menu.add(bt5);

        JPanel pn_welcome = new JPanel(); // 欢迎页
        pn_welcome.setBorder(BorderFactory.createEtchedBorder());
        pn_welcome.setLayout(new BorderLayout());
        pn_welcome.setBounds(0, 0, 1045, 735);
        JLabel lb_welcome = new JLabel("欢迎使用");
        lb_welcome.setFont(new Font("黑体", 0, 100));
        lb_welcome.setHorizontalAlignment(SwingConstants.CENTER);
        pn_welcome.add(lb_welcome, BorderLayout.CENTER);

        CustomerCon.add(pn1);
        CustomerCon.add(pn2);
        CustomerCon.add(pn_menu);
        CustomerCon.add(pn_function);
        pn_function.add(pn_welcome);

        CustomerJFrame.setVisible(true);

        // 功能按钮事件监听器
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // 查看个人信息
                lb2.setText("[个人信息]");
                pn_function.removeAll();
                pn_function.add(info(Customer_num));
                CustomerJFrame.repaint();
                CustomerJFrame.validate();
            }
        });

        bt2.addActionListener(new ActionListener() { // 客房服务
            public void actionPerformed(ActionEvent e) {
                lb2.setText("[客房服务]");
                pn_function.removeAll();
                pn_function.add(service());
                CustomerJFrame.repaint();
                CustomerJFrame.validate();
            }
        });

        bt6.addActionListener(new ActionListener() { //
            public void actionPerformed(ActionEvent e) {
                lb2.setText("[娱乐项目预约]");
                pn_function.removeAll();
                pn_function.add(preserve());
                CustomerJFrame.repaint();
                CustomerJFrame.validate();
            }
        });

        /*bt7.addActionListener(new ActionListener() { //
            public void actionPerformed(ActionEvent e) {
                lb2.setText("[账单支付]");
                pn_function.removeAll();
                pn_function.add(pay());
                CustomerJFrame.repaint();
                CustomerJFrame.validate();
            }
        });*/

        bt3.addActionListener(new ActionListener() { // 进行建议与反馈
            public void actionPerformed(ActionEvent e) {
                lb2.setText("[建议与反馈]");
                pn_function.removeAll();
                pn_function.add(suggest());
                CustomerJFrame.repaint();
                CustomerJFrame.validate();
            }
        });

        bt4.addActionListener(new ActionListener() { // 修改密码
            public void actionPerformed(ActionEvent e) {
                lb2.setText("[修改密码]");
                pn_function.removeAll();
                pn_function.add(changePassword());
                CustomerJFrame.repaint();
                CustomerJFrame.validate();
            }
        });

        bt5.addActionListener(new ActionListener() { // 退出顾客模式
            public void actionPerformed(ActionEvent e) {
                lb_tips.setText("是否退出顾客模式？");
                choiceTips();
            }
        });
    }


    public JPanel info(String Customer_num) {
        String[] customerInfo = new String[9]; // 信息
        String[] stayInfo = {"无", "无", "无", "无"}; // 住宿信息
        String c_num = Customer_num; // 当前顾客的身份证号

        // 获取顾客信息
        try {
            String sql = "SELECT * FROM Customer WHERE Cid = ?"; // SQL语句
            PreparedStatement ps = Home.connection.prepareStatement(sql); // 创建PreparedStatement类对象ps，用来执行SQL语句
            ps.setString(1, c_num); // 设置SQL查询参数
            ResultSet rs = ps.executeQuery(); // ResultSet类，用来存放获取的结果集

            if (rs.next()) {
                customerInfo[0] = rs.getString("Cid");
                customerInfo[1] = rs.getString("Name");
                customerInfo[2] = rs.getString("Cphonenumber");
                customerInfo[3] = rs.getBoolean("vip") ? "是" : "否";
                customerInfo[4] = rs.getString("Rid");
                customerInfo[5] = rs.getString("Intime").toString();
                customerInfo[6] = rs.getString("Outtime") != null ? rs.getString("Outtime").toString() : "无";
                customerInfo[7] = rs.getString("Indeedin") != null ? rs.getString("Indeedin").toString() : "无";
                customerInfo[8] = rs.getString("Indeedout") != null ? rs.getString("Indeedout").toString() : "无";
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 获取住宿信息（若有住宿）
        if (!"无".equals(customerInfo[4])) {
            try {
                String sql = "SELECT * FROM Room WHERE Rid = ?"; // SQL语句
                PreparedStatement ps = Home.connection.prepareStatement(sql); // 创建PreparedStatement类对象ps，用来执行SQL语句
                ps.setString(1, customerInfo[4]); // 设置SQL查询参数
                ResultSet rs = ps.executeQuery(); // ResultSet类，用来存放获取的结果集

                if (rs.next()) {
                    stayInfo[0] = String.valueOf(rs.getInt("BLid"));
                    stayInfo[1] = rs.getString("Rtype");
                    stayInfo[2] = rs.getString("Rid");
                    stayInfo[3] = rs.getString("Rstate");
                }

                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 设置顾客信息界面
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setSize(1045, 735);
        infoPanel.setBorder(BorderFactory.createEtchedBorder());


        JLabel[] labels = new JLabel[9]; // 顾客信息
        for (int i = 0; i < 9; i++) {
            labels[i] = new JLabel();
            labels[i].setFont(new Font("黑体", Font.PLAIN, 30));
            labels[i].setBounds(100, 82 + i * 60, 600, 50); // 调整位置和大小以适应更多信息
            infoPanel.add(labels[i]);
        }

        labels[0].setText("身份证号： " + customerInfo[0]);
        labels[1].setText("姓名： " + customerInfo[1]);
        labels[2].setText("联系方式： " + customerInfo[2]);
        labels[3].setText("会员： " + customerInfo[3]);
        labels[4].setText("房间号： " + customerInfo[4]);
        labels[5].setText("预计入住时间： " + customerInfo[5]);
        labels[6].setText("预计离开时间： " + customerInfo[6]);
        labels[7].setText("实际入住时间： " + customerInfo[7]);
        labels[8].setText("实际离开时间： " + customerInfo[8]);

        // 设置住宿信息界面
        JLabel[] stayLabels = new JLabel[4]; // 住宿信息
        for (int i = 0; i < 4; i++) {
            stayLabels[i] = new JLabel();
            stayLabels[i].setFont(new Font("黑体", Font.PLAIN, 30));
            stayLabels[i].setBounds(690, 382 + i * 60, 400, 50); // 调整位置和大小以适应更多信息
            infoPanel.add(stayLabels[i]);
        }

        stayLabels[0].setText("楼栋号： " + stayInfo[0]);
        stayLabels[1].setText("房型： " + stayInfo[1]);
        stayLabels[2].setText("房间号： " + stayInfo[2]);
        stayLabels[3].setText("房间状态： " + stayInfo[3]);

        return infoPanel;
    }




    public JPanel service() { //[客房服务]功能
        JPanel pn_service = new JPanel();
        pn_service.setLayout(null);
        pn_service.setSize(1045, 735);
        pn_service.setBorder(BorderFactory.createEtchedBorder());

        JLabel lb_building = new JLabel("楼栋号："), lb_room = new JLabel("房间号："), lb_info = new JLabel("服务内容：");
        JTextField tf_building = new JTextField(), tf_room = new JTextField();
        JTextArea ta_info = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(); // 滚动条
        JButton bt_submit = new JButton("提交");

        lb_building.setFont(new Font("黑体", Font.PLAIN, 25));
        lb_building.setBounds(197, 190, 125, 50);
        lb_room.setFont(new Font("黑体", Font.PLAIN, 25));
        lb_room.setBounds(172, 250, 125, 50);
        lb_info.setFont(new Font("黑体", Font.PLAIN, 25));
        lb_info.setBounds(147, 310, 125, 50);

        tf_building.setFont(new Font(null, Font.PLAIN, 25));
        tf_building.setBounds(272, 195, 250, 40);
        tf_room.setFont(new Font(null, Font.PLAIN, 25));
        tf_room.setBounds(272, 255, 250, 40);
        tf_room.setDocument(new NumLimit()); // 限制文本框只能输入数字

        ta_info.setFont(new Font(null, Font.PLAIN, 25));
        ta_info.setBounds(272, 315, 500, 160);
        ta_info.setLineWrap(true);
        ta_info.setWrapStyleWord(true);
        scrollPane.setBounds(272, 315, 500, 160);
        scrollPane.setViewportView(ta_info);

        bt_submit.setFont(new Font("黑体", Font.PLAIN, 20));
        bt_submit.setBounds(472, 490, 100, 50);
        bt_submit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pn_service.add(lb_building);
        pn_service.add(lb_room);
        pn_service.add(lb_info);
        pn_service.add(tf_building);
        pn_service.add(tf_room);
        pn_service.add(scrollPane);
        pn_service.add(bt_submit);

        bt_submit.addActionListener(new ActionListener() { // 提交客房服务申请
            public void actionPerformed(ActionEvent e) {
                String building = tf_building.getText();
                String room = tf_room.getText();
                String info = ta_info.getText();

                if (building.equals("") || room.equals("") || info.equals("")) { // 若未填写完整，则进行提示
                    lb_tips.setText("请填写完整！");
                    functionTips();
                    return; // 提前返回
                }

                try {
                    // 查询房间是否存在
                    String sql = "SELECT Rid FROM Room WHERE BLid = ? AND Rid = ?";
                    PreparedStatement ps = Home.connection.prepareStatement(sql); // 创建PreparedStatement类对象ps，用来执行SQL语句
                    ps.setInt(1, Integer.parseInt(building));
                    ps.setString(2, room);
                    ResultSet rs = ps.executeQuery(); // ResultSet类，用来存放获取的结果集

                    if (!rs.next()) { // 若房间不存在，则进行提示
                        lb_tips.setText("房间不存在！");
                        functionTips();
                        rs.close();
                        ps.close();
                        return; // 提前返回
                    }

                    rs.close();
                    ps.close();

                    // 获取当前最大服务号并生成新的服务号
                    String getMaxSid = "SELECT MAX(RSid) AS maxRSid FROM RoomService";
                    PreparedStatement psGetMaxSid = Home.connection.prepareStatement(getMaxSid);
                    ResultSet rsMaxSid = psGetMaxSid.executeQuery();
                    int newSid = 1;
                    if (rsMaxSid.next()) {
                        newSid = rsMaxSid.getInt("maxRSid") + 1;
                    }
                    rsMaxSid.close();
                    psGetMaxSid.close();

                    // 提交客房服务申请
                    sql = "INSERT INTO RoomService (RSid, Rid, RScontent, RStime) VALUES (?, ?, ?, ?)";
                    ps = Home.connection.prepareStatement(sql); // 把操作数据库返回的结果保存到ps中
                    ps.setInt(1, newSid); // SQL语句第一个?值
                    ps.setString(2, room); // SQL语句第二个?值
                    ps.setString(3, info); // SQL语句第三个?值
                    ps.setTimestamp(4, new Timestamp(System.currentTimeMillis())); // SQL语句第四个?值，当前时间戳
                    ps.executeUpdate(); // 更新，执行插入操作

                    tf_building.setText("");
                    tf_room.setText("");
                    ta_info.setText("");
                    lb_tips.setText("提交成功，请等待工作人员处理！");
                    functionTips();
                    ps.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        });

        return pn_service;
    }



    public JPanel suggest() { //[建议与反馈]功能
        JPanel pn_suggest = new JPanel();
        pn_suggest.setLayout(null);
        pn_suggest.setSize(1045, 735);
        pn_suggest.setBorder(BorderFactory.createEtchedBorder());

        JLabel lb_info = new JLabel("建议与反馈：");
        JTextArea ta_info = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(); // 滚动条
        JButton bt_submit = new JButton("提交");
        JLabel lb_tips = new JLabel(""); // 提示标签

        lb_info.setFont(new Font("黑体", Font.PLAIN, 25));
        lb_info.setBounds(172, 217, 150, 50);

        ta_info.setFont(new Font(null, Font.PLAIN, 25));
        ta_info.setBounds(172, 267, 700, 250);
        ta_info.setLineWrap(true);
        ta_info.setWrapStyleWord(true);

        scrollPane.setBounds(172, 267, 700, 250);
        scrollPane.setViewportView(ta_info);

        bt_submit.setFont(new Font("黑体", Font.PLAIN, 20));
        bt_submit.setBounds(472, 555, 100, 50);
        bt_submit.setCursor(new Cursor(Cursor.HAND_CURSOR));


        pn_suggest.add(lb_info);
        pn_suggest.add(scrollPane);
        pn_suggest.add(bt_submit);
        pn_suggest.add(lb_tips);

        bt_submit.addActionListener(new ActionListener() { // 提交建议与反馈
            public void actionPerformed(ActionEvent e) {
                String content = ta_info.getText();
                if (content.equals("")) { // 若未填写内容，则进行提示
                    lb_tips.setText("请填写建议与反馈内容！");
                    functionTips();
                    return; // 提前返回
                }

                try {
                    // 获取当前最大服务号并生成新的服务号
                    String getMaxSUid = "SELECT MAX(Sid) AS maxSid FROM Suggestions";
                    PreparedStatement psGetMaxSUid = Home.connection.prepareStatement(getMaxSUid);
                    ResultSet rsMaxSUid = psGetMaxSUid.executeQuery();
                    int newSUid = 1;
                    if (rsMaxSUid.next()) {
                        newSUid = rsMaxSUid.getInt("maxSid") + 1;
                    }
                    rsMaxSUid.close();
                    psGetMaxSUid.close();

                    // 插入建议与反馈
                    String sql = "INSERT INTO Suggestions (Sid, Cid, Scontent, Stime) VALUES (?, ?, ?, ?)";
                    PreparedStatement ps = Home.connection.prepareStatement(sql);
                    ps.setInt(1, newSUid); // 设置新的服务号
                    ps.setString(2, c_num); // 设置当前用户编号
                    ps.setString(3, content); // 设置反馈内容
                    ps.setTimestamp(4, new Timestamp(System.currentTimeMillis())); // 设置当前时间戳

                    ps.executeUpdate(); // 执行插入操作
                    ta_info.setText(""); // 清空文本区域
                    lb_tips.setText("提交成功，感谢您的建议与反馈！");
                    functionTips(); // 提示提交成功
                    ps.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        });

        return pn_suggest;
    }

    public JPanel preserve() {
        JPanel pn_preserve = new JPanel();
        pn_preserve.setLayout(null);
        pn_preserve.setSize(1045, 735);
        pn_preserve.setBorder(BorderFactory.createEtchedBorder());

        JLabel lb_select = new JLabel("选择娱乐项目：");
        lb_select.setFont(new Font("黑体", 0, 25));
        lb_select.setBounds(300, 200, 200, 50);
        pn_preserve.add(lb_select);

        String[] entertainments = {"健身房", "游泳池", "桌球", "电影院", "KTV包间", "SPA按摩", "网球场", "儿童乐园",
                "酒吧", "篮球场", "足球场", "健身操房", "游乐园", "图书馆", "美容美发",
                "自行车租赁", "水上乐园", "钓鱼塘", "户外烧烤", "VR体验馆", "体育赛事观看",
                "电子游戏室", "剧院演出", "绘画工作室", "瑜伽室", "摄影棚", "音乐会", "高尔夫球场",
                "潜水中心", "滑雪场", "室内攀岩", "真人CS", "博物馆", "高空跳伞", "滑板公园",
                "极限运动", "卡丁车", "沙滩排球"};

        JComboBox<String> cb_entertainments = new JComboBox<>(entertainments);
        cb_entertainments.setFont(new Font("黑体", 0, 20));
        cb_entertainments.setBounds(500, 205, 250, 40);
        pn_preserve.add(cb_entertainments);

        JButton bt_confirm = new JButton("确认预约");
        bt_confirm.setFont(new Font("黑体", 0, 20));
        bt_confirm.setBounds(450, 300, 150, 50);
        bt_confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pn_preserve.add(bt_confirm);

        bt_confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedEntertainment = (String) cb_entertainments.getSelectedItem();
                String Eid = null;

                // 根据娱乐项目名称查找对应的Eid
                try {
                    String sql = "SELECT Eid FROM Entertainments WHERE Ename = ?";
                    PreparedStatement ps = Home.connection.prepareStatement(sql);
                    ps.setString(1, selectedEntertainment);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        Eid = rs.getString("Eid");
                    }
                    rs.close();
                    ps.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }

                if (Eid != null) {
                    // 检查Esum是否大于Ebook
                    try {
                        String sql = "SELECT Esum, Ebook FROM Entertainments WHERE Eid = ?";
                        PreparedStatement ps = Home.connection.prepareStatement(sql);
                        ps.setString(1, Eid);
                        ResultSet rs = ps.executeQuery();
                        int Esum = 0;
                        int Ebook = 0;
                        if (rs.next()) {
                            Esum = rs.getInt("Esum");
                            Ebook = rs.getInt("Ebook");
                        }
                        rs.close();
                        ps.close();

                        if (Esum > Ebook) {
                            // 获取当前最大Pid
                            int newPid = 1; // 默认值，如果表中没有记录
                            try {
                                String sqlMaxPid = "SELECT MAX(Pid) as maxPid FROM Preservation";
                                ps = Home.connection.prepareStatement(sqlMaxPid);
                                rs = ps.executeQuery();
                                if (rs.next()) {
                                    newPid = rs.getInt("maxPid") + 1;
                                }
                                rs.close();
                                ps.close();
                            } catch (SQLException se) {
                                se.printStackTrace();
                            }

                            // Debugging: Print newPid to check its value
                            System.out.println("Generated newPid: " + newPid);

                            // 插入预约信息到Preservation表
                            try {
                                String sqlInsert = "INSERT INTO Preservation (Pid, Eid, Cid, ptime) VALUES (?, ?, ?, ?)";
                                ps = Home.connection.prepareStatement(sqlInsert);
                                ps.setInt(1, newPid);
                                ps.setString(2, Eid);
                                ps.setString(3, c_num);
                                ps.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
                                ps.executeUpdate();
                                ps.close();
                                lb_tips.setText("预约成功！");
                                functionTips();
                            } catch (SQLException se) {
                                se.printStackTrace();
                                lb_tips.setText("数据库插入错误：" + se.getMessage());
                                functionTips();
                            }
                        } else {
                            lb_tips.setText("预约已满，请预约其他项目！");
                            functionTips();
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                } else {
                    lb_tips.setText("选择的娱乐项目不存在！");
                    functionTips();
                }
            }
        });

        return pn_preserve;
    }




    public JPanel changePassword() { // [修改密码]功能
        JPanel pn_changePassword = new JPanel();
        pn_changePassword.setLayout(null);
        pn_changePassword.setSize(1045, 735);
        pn_changePassword.setBorder(BorderFactory.createEtchedBorder());

        JLabel lb_old = new JLabel("旧密码："), lb_new1 = new JLabel("新密码："), lb_new2 = new JLabel("确认密码："), lb = new JLabel("（密码不超过20位）");
        JPasswordField pf_old = new JPasswordField(), pf_new1 = new JPasswordField(), pf_new2 = new JPasswordField();

        lb_old.setFont(new Font("黑体", 0, 25));
        lb_old.setBounds(300, 200, 100, 50);
        lb_new1.setFont(new Font("黑体", 0, 25));
        lb_new1.setBounds(300, 260, 100, 50);
        lb_new2.setFont(new Font("黑体", 0, 25));
        lb_new2.setBounds(275, 320, 125, 50);
        lb.setFont(new Font("黑体", 0, 18));
        lb.setBounds(650, 260, 200, 50);

        pf_old.setFont(new Font(null, 0, 30));
        pf_old.setBounds(400, 205, 250, 40);
        pf_new1.setFont(new Font(null, 0, 30));
        pf_new1.setBounds(400, 265, 250, 40);
        pf_new2.setFont(new Font(null, 0, 30));
        pf_new2.setBounds(400, 325, 250, 40);


        pn_changePassword.add(lb_old);
        pn_changePassword.add(lb_new1);
        pn_changePassword.add(lb_new2);
        pn_changePassword.add(lb);
        pn_changePassword.add(pf_old);
        pn_changePassword.add(pf_new1);
        pn_changePassword.add(pf_new2);

        JButton bt_confirm = new JButton("确认"), bt_reset = new JButton("重置");
        bt_confirm.setFont(new Font("黑体", 0, 20));
        bt_confirm.setBounds(405, 410, 100, 50);
        bt_confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bt_reset.setFont(new Font("黑体", 0, 20));
        bt_reset.setBounds(540, 410, 100, 50);
        bt_reset.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pn_changePassword.add(bt_confirm);
        pn_changePassword.add(bt_reset);

        bt_reset.addActionListener(new ActionListener() { // 重置，将密码框内容清空
            public void actionPerformed(ActionEvent e) {
                pf_old.setText("");
                pf_new1.setText("");
                pf_new2.setText("");
            }
        });

        bt_confirm.addActionListener(new ActionListener() { // 确认
            public void actionPerformed(ActionEvent e) {
                String currentPassword = null;
                if ((String.valueOf(pf_old.getPassword()).isEmpty() || String.valueOf(pf_new1.getPassword()).isEmpty() || String.valueOf(pf_new2.getPassword()).isEmpty())) {
                    lb_tips.setText("请填写完整！");
                    functionTips();
                } else {
                    try { // 获取原密码
                        String sql = "SELECT Cpassword FROM Customer WHERE Cid = ?";
                        PreparedStatement ps = Home.connection.prepareStatement(sql);
                        ps.setString(1, c_num);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            currentPassword = rs.getString("Cpassword");
                        }
                        rs.close();
                        ps.close();
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }

                    if (!String.valueOf(pf_old.getPassword()).equals(currentPassword)) {
                        lb_tips.setText("旧密码错误！");
                        functionTips();
                    } else if (!String.valueOf(pf_new1.getPassword()).equals(String.valueOf(pf_new2.getPassword()))) {
                        lb_tips.setText("两次新密码不同！");
                        functionTips();
                    } else if (String.valueOf(pf_new1.getPassword()).length() > 20) {
                        lb_tips.setText("密码超过20位！");
                        functionTips();
                    } else { // 符合改密条件，进行改密
                        try {
                            String sql = "UPDATE Customer SET Cpassword = ? WHERE Cid = ?";
                            PreparedStatement ps = Home.connection.prepareStatement(sql);
                            ps.setString(1, String.valueOf(pf_new1.getPassword()));
                            ps.setString(2, c_num);
                            ps.executeUpdate();
                            ps.close();
                        } catch (SQLException se) {
                            se.printStackTrace();
                        }
                        pf_old.setText("");
                        pf_new1.setText("");
                        pf_new2.setText("");
                        lb_tips.setText("密码修改成功！");
                        functionTips();
                    }
                }
            }
        });

        return pn_changePassword;
    }


    public void functionTips() { // 操作时弹出的提示信息窗口
        JDialog tips = new JDialog(CustomerJFrame, " 提示", true);
        JPanel pn_tips = new JPanel();
        JButton bt_tips = new JButton("确定");
        tips.setSize(500, 200);
        tips.setLocationRelativeTo(null);
        tips.setResizable(false);
        tips.setLayout(null);
        pn_tips.setBounds(0, 30, 500, 70);
        lb_tips.setFont(new Font("黑体", 0, 25));
        bt_tips.setFont(new Font("黑体", 0, 20));
        bt_tips.setBounds(200, 100, 100, 50);
        bt_tips.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pn_tips.add(lb_tips);
        tips.add(pn_tips);
        tips.add(bt_tips);
        bt_tips.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tips.dispose();
            }
        });
        tips.setVisible(true);
    }

    public void choiceTips() { // 操作时弹出的提示选择窗口
        JDialog choiceTips = new JDialog(CustomerJFrame, " 提示", true);
        JPanel pn_tips = new JPanel();
        JButton bt_yes = new JButton("是(Y)");
        JButton bt_no = new JButton("否(N)");
        choiceTips.setSize(500, 200);
        choiceTips.setLocationRelativeTo(null);
        choiceTips.setResizable(false);
        choiceTips.setLayout(null);
        pn_tips.setBounds(0, 30, 500, 70);
        lb_tips.setFont(new Font("黑体", 0, 25));
        bt_yes.setFont(new Font("黑体", 0, 20));
        bt_yes.setBounds(135, 100, 100, 50);
        bt_yes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bt_no.setFont(new Font("黑体", 0, 20));
        bt_no.setBounds(260, 100, 100, 50);
        bt_no.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pn_tips.add(lb_tips);
        choiceTips.add(pn_tips);
        choiceTips.add(bt_yes);
        choiceTips.add(bt_no);
        bt_yes.addActionListener(new ActionListener() { // 选择“是”，进行相应操作
            public void actionPerformed(ActionEvent e) {
                choiceTips.dispose();
                yesOperation();
            }
        });
        bt_no.addActionListener(new ActionListener() { // 选择“否”，关闭提示选择窗口
            public void actionPerformed(ActionEvent e) {
                choiceTips.dispose();
            }
        });
        bt_yes.addKeyListener(new KeyListener() { // “是”按钮的快捷键“Y”，“否”按钮的快捷键“N”
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_Y) {
                    choiceTips.dispose();
                    yesOperation();
                }
                if (e.getKeyCode() == KeyEvent.VK_N) {
                    choiceTips.dispose();
                }
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
        bt_no.addKeyListener(new KeyListener() { // “是”按钮的快捷键“Y”，“否”按钮的快捷键“N”
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_Y) {
                    choiceTips.dispose();
                    yesOperation();
                }
                if (e.getKeyCode() == KeyEvent.VK_N) {
                    choiceTips.dispose();
                }
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
        choiceTips.setVisible(true);
    }

    public void yesOperation() { // 选择“是”之后，根据提示内容，选择要进行的操作
        if (lb_tips.getText().equals("是否退出顾客模式？")) { // 退出顾客模式，返回到欢迎界面
            try {
                Home.connection.close(); // 关闭数据库连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
            CustomerJFrame.dispose();
            Home.con.removeAll();
            Home.mainJFrame.repaint();
            Home.welcomePage();
            Home.mainJFrame.validate();
        }
    }

}