package hms;

import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class EmployeeFunction { //系统管理员功能类
    JFrame EmployeeJFrame =new JFrame("酒店管理系统-----[普通员工模式]");
    Container EmployeeCon = EmployeeJFrame.getContentPane();
    JPanel pn_function=new JPanel(); //放置各种功能页面的容器
    JLabel lb_topFunction=new JLabel(); //顶部信息栏，当前功能
    JLabel lb_tips=new JLabel(); //提示窗口的内容
    String Hsid;

    public EmployeeFunction(String admin_num) {
        Hsid = admin_num;
        EmployeeJFrame.setSize(1300, 800);
        EmployeeJFrame.setLocationRelativeTo(null);
        EmployeeJFrame.setResizable(false);
        EmployeeJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EmployeeJFrame.setLayout(null);

        // 初始化面板和布局
        EmployeeCon.setLayout(null);
        EmployeeJFrame.setContentPane(EmployeeCon);

        pn_function.setLayout(null);
        pn_function.setBorder(BorderFactory.createEtchedBorder());
        pn_function.setBounds(250, 30, 1045, 735);

        JPanel pn_topUser = new JPanel();
        pn_topUser.setBackground(Color.white);
        pn_topUser.setBounds(0, 0, 250, 30);
        JLabel lb_topUser = new JLabel("系统管理员：" + admin_num);
        lb_topUser.setFont(new Font("黑体", 0, 18));
        lb_topUser.setForeground(Color.blue);
        pn_topUser.add(lb_topUser);

        JPanel pn_topFunction = new JPanel();
        pn_topFunction.setBackground(Color.white);
        pn_topFunction.setBounds(250, 0, 1045, 30);
        JLabel lb_topFunction = new JLabel("欢迎使用");
        lb_topFunction.setFont(new Font("黑体", 0, 20));
        lb_topFunction.setForeground(Color.black);
        pn_topFunction.add(lb_topFunction);

        JPanel pn_menu = new JPanel();
        pn_menu.setBackground(new Color(249, 250, 252));
        pn_menu.setBorder(BorderFactory.createEtchedBorder());
        pn_menu.setLayout(null);
        pn_menu.setBounds(0, 30, 250, 735);

        JButton bt_customerQuery = new JButton("顾客查询");
        bt_customerQuery.setFont(new Font("黑体", 0, 20));
        bt_customerQuery.setContentAreaFilled(false);
        bt_customerQuery.setBounds(0, 50, 249, 50);
        bt_customerQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lb_topFunction.setText("[顾客查询]");
                pn_function.removeAll();
                pn_function.add(customerQuery());
                pn_function.repaint();
                pn_function.validate();
            }
        });

        JButton bt_roomQuery = new JButton("房间查询");
        bt_roomQuery.setFont(new Font("黑体", 0, 20));
        bt_roomQuery.setContentAreaFilled(false);
        bt_roomQuery.setBounds(0, 105, 249, 50);
        bt_roomQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lb_topFunction.setText("[房间查询]");
                pn_function.removeAll();
                pn_function.add(roomQuery());
                pn_function.repaint();
                pn_function.validate();
            }
        });

        JButton bt_checkIn = new JButton("办理入住");
        bt_checkIn.setFont(new Font("黑体", 0, 20));
        bt_checkIn.setContentAreaFilled(false);
        bt_checkIn.setBounds(0, 160, 249, 50);
        bt_checkIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lb_topFunction.setText("[办理入住]");
                pn_function.removeAll();
                pn_function.add(checkIn());
                pn_function.repaint();
                pn_function.validate();
            }
        });

        JButton bt_checkOut = new JButton("结账");
        bt_checkOut.setFont(new Font("黑体", 0, 20));
        bt_checkOut.setContentAreaFilled(false);
        bt_checkOut.setBounds(0, 215, 249, 50);
        bt_checkOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lb_topFunction.setText("[结账]");
                pn_function.removeAll();
                pn_function.add(checkOut(Hsid));
                pn_function.repaint();
                pn_function.validate();
            }
        });

        JButton bt_leave = new JButton("办理离开");
        bt_leave.setFont(new Font("黑体", 0, 20));
        bt_leave.setContentAreaFilled(false);
        bt_leave.setBounds(0, 270, 249, 50);
        bt_leave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lb_topFunction.setText("[办理离开]");
                pn_function.removeAll();
                pn_function.add(leave());
                pn_function.repaint();
                pn_function.validate();
            }
        });

        JButton bt_serviceRecord = new JButton("客房服务记录");
        bt_serviceRecord.setFont(new Font("黑体", 0, 20));
        bt_serviceRecord.setContentAreaFilled(false);
        bt_serviceRecord.setBounds(0, 325, 249, 50);
        bt_serviceRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lb_topFunction.setText("[客房服务记录]");
                pn_function.removeAll();
                pn_function.add(serviceRecord());
                pn_function.repaint();
                pn_function.validate();
            }
        });

        JButton bt_reservationRecord = new JButton("预约记录");
        bt_reservationRecord.setFont(new Font("黑体", 0, 20));
        bt_reservationRecord.setContentAreaFilled(false);
        bt_reservationRecord.setBounds(0, 380, 249, 50);
        bt_reservationRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lb_topFunction.setText("[预约记录]");
                pn_function.removeAll();
                pn_function.add(reservationRecord());
                pn_function.repaint();
                pn_function.validate();
            }
        });

        JButton bt_feedbackRecord = new JButton("反馈记录");
        bt_feedbackRecord.setFont(new Font("黑体", 0, 20));
        bt_feedbackRecord.setContentAreaFilled(false);
        bt_feedbackRecord.setBounds(0, 435, 249, 50);
        bt_feedbackRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lb_topFunction.setText("[反馈记录]");
                pn_function.removeAll();
                pn_function.add(feedbackRecord());
                pn_function.repaint();
                pn_function.validate();
            }
        });

        JButton bt_exit = new JButton("退出");
        bt_exit.setFont(new Font("黑体", 0, 20));
        bt_exit.setContentAreaFilled(false);
        bt_exit.setBounds(0, 490, 249, 50);
        bt_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lb_tips.setText("是否退出系统管理模式？");
                choiceTips("");
            }
        });

        pn_menu.add(bt_customerQuery);
        pn_menu.add(bt_roomQuery);
        pn_menu.add(bt_checkIn);
        pn_menu.add(bt_checkOut);
        pn_menu.add(bt_leave);
        pn_menu.add(bt_serviceRecord);
        pn_menu.add(bt_reservationRecord);
        pn_menu.add(bt_feedbackRecord);
        pn_menu.add(bt_exit);

        JPanel pn_welcome = new JPanel();
        pn_welcome.setBorder(BorderFactory.createEtchedBorder());
        pn_welcome.setLayout(new BorderLayout());
        pn_welcome.setBounds(0, 0, 1045, 735);
        JLabel lb_welcome = new JLabel("欢迎使用");
        lb_welcome.setFont(new Font("黑体", 0, 100));
        lb_welcome.setHorizontalAlignment(SwingConstants.CENTER);
        pn_welcome.add(lb_welcome, BorderLayout.CENTER);

        // 添加所有面板到容器
        EmployeeCon.add(pn_topUser);
        EmployeeCon.add(pn_topFunction);
        EmployeeCon.add(pn_menu);
        EmployeeCon.add(pn_function);
        pn_function.add(pn_welcome);

        // 设置可见
        EmployeeJFrame.setVisible(true);
    }




    public JPanel leave() {
        JPanel leavePanel = new JPanel(null); // 使用 null 布局
        leavePanel.setLayout(null);
        leavePanel.setSize(1040, 735);
        leavePanel.setBorder(BorderFactory.createEtchedBorder());

        // 选项卡面板
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(10, 10, 780, 580); // 设置选项卡面板的大小和位置

        // 支付账单选项卡
        JPanel payBillPanel = new JPanel(null);
        payBillPanel.setBounds(10, 10, 760, 530); // 设置支付账单面板的大小和位置

        JLabel lblCidPay = new JLabel("顾客身份证号（Cid）：");
        lblCidPay.setBounds(20, 20, 150, 30);
        JTextField tfCidPay = new JTextField();
        tfCidPay.setBounds(180, 20, 200, 30);

        JLabel lblBprice = new JLabel("账单金额（Bprice）：");
        lblBprice.setBounds(20, 70, 150, 30);
        JTextField tfBprice = new JTextField();
        tfBprice.setBounds(180, 70, 200, 30);

        JLabel lblHSid = new JLabel("员工号（HSid）：");
        lblHSid.setBounds(20, 120, 150, 30);
        JLabel lbHSid = new JLabel(Hsid); // Assuming `hotelStaff` is the logged-in manager
        lbHSid.setBounds(180, 120, 200, 30);

        JLabel lblBtime = new JLabel("账单时间（Btime）：");
        lblBtime.setBounds(20, 170, 150, 30);
        JLabel lbBtime = new JLabel(new Timestamp(System.currentTimeMillis()).toString());
        lbBtime.setBounds(180, 170, 200, 30);

        JButton btnPay = new JButton("支付");
        btnPay.setBounds(180, 220, 100, 30);

        payBillPanel.add(lblCidPay);
        payBillPanel.add(tfCidPay);
        payBillPanel.add(lblBprice);
        payBillPanel.add(tfBprice);
        payBillPanel.add(lblHSid);
        payBillPanel.add(lbHSid);
        payBillPanel.add(lblBtime);
        payBillPanel.add(lbBtime);
        payBillPanel.add(btnPay);

        btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cid = tfCidPay.getText();
                String bpriceStr = tfBprice.getText();
                if (cid.isEmpty() || bpriceStr.isEmpty()) {
                    lb_tips.setText("请输入所有信息！");
                    functionTips();
                    return;
                }

                try {
                    double bprice = Double.parseDouble(bpriceStr);
                    Connection conn = Home.connection;
                    String maxBidQuery = "SELECT MAX(Bid) AS maxBid FROM Bill";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(maxBidQuery);
                    int newBid = 1;
                    if (rs.next()) {
                        newBid = rs.getInt("maxBid") + 1;
                    }
                    String insertBillQuery = "INSERT INTO Bill (Bid, Cid, HSid, Bprice, Btime) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(insertBillQuery);
                    pstmt.setInt(1, newBid);
                    pstmt.setString(2, cid);
                    pstmt.setString(3, Hsid);
                    pstmt.setDouble(4, bprice);
                    pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
                    pstmt.executeUpdate();
                    lb_tips.setText("支付成功！");
                    functionTips();
                    tabbedPane.setSelectedIndex(1); // 跳转到退房界面
                } catch (SQLException | NumberFormatException ex) {
                    ex.printStackTrace();
                    lb_tips.setText("输入错误或数据库错误：" + ex.getMessage());
                    functionTips();
                }
            }
        });

        tabbedPane.addTab("支付账单", payBillPanel);

        // 退房选项卡
        JPanel checkOutPanel = new JPanel(null);
        checkOutPanel.setBounds(10, 10, 760, 530); // 设置退房面板的大小和位置

        JLabel lblCidCheckOut = new JLabel("顾客身份证号（Cid）：");
        lblCidCheckOut.setBounds(20, 20, 150, 30);
        JTextField tfCidCheckOut = new JTextField();
        tfCidCheckOut.setBounds(180, 20, 200, 30);

        JButton btnCheckOut = new JButton("退房");
        btnCheckOut.setBounds(180, 70, 100, 30);

        checkOutPanel.add(lblCidCheckOut);
        checkOutPanel.add(tfCidCheckOut);
        checkOutPanel.add(btnCheckOut);

        btnCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cid = tfCidCheckOut.getText();
                if (cid.isEmpty()) {
                    lb_tips.setText("请输入身份证号！");
                    functionTips();
                    return;
                }

                try {
                    Connection conn = Home.connection;
                    String updateCustomerQuery = "UPDATE Customer SET IndeedOut = ? WHERE Cid = ?";
                    PreparedStatement pstmt = conn.prepareStatement(updateCustomerQuery);
                    pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    pstmt.setString(2, cid);
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        lb_tips.setText("退房成功！");
                    } else {
                        lb_tips.setText("未找到此身份证号的顾客！");
                    }
                    functionTips();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    lb_tips.setText("数据库错误：" + ex.getMessage());
                    functionTips();
                }
            }
        });

        tabbedPane.addTab("退房", checkOutPanel);

        leavePanel.add(tabbedPane);

        return leavePanel;
    }



    public JPanel checkIn() {
        JPanel checkInPanel = new JPanel(null); // 使用 null 布局
        checkInPanel.setLayout(null);
        checkInPanel.setSize(1040, 735);
        checkInPanel.setBorder(BorderFactory.createEtchedBorder());

        // 选项卡面板
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(10, 10, 1020, 400); // 设置选项卡面板的大小和位置

        // 已约定选项卡
        JPanel reservedPanel = new JPanel(null);
        reservedPanel.setBounds(10, 10, 1000, 385); // 设置已约定面板的大小和位置

        JLabel lblReservedCid = new JLabel("身份证号：");
        lblReservedCid.setBounds(20, 20, 100, 30);
        JTextField tfReservedCid = new JTextField();
        tfReservedCid.setBounds(120, 20, 200, 30);
        JButton btnCheckInReserved = new JButton("登记");
        btnCheckInReserved.setBounds(330, 20, 80, 30);

        reservedPanel.add(lblReservedCid);
        reservedPanel.add(tfReservedCid);
        reservedPanel.add(btnCheckInReserved);

        // 添加显示顾客详细信息的标签
        JTextArea taCustomerDetails = new JTextArea();
        taCustomerDetails.setBounds(20, 60, 800, 300);
        taCustomerDetails.setEditable(false);
        taCustomerDetails.setFont(new Font("微软雅黑", Font.PLAIN, 30)); // 设置字体大小
        reservedPanel.add(taCustomerDetails);

        btnCheckInReserved.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cid = tfReservedCid.getText();
                if (cid.isEmpty()) {
                    lb_tips.setText("请输入身份证号！");
                    functionTips();
                    return;
                }

                try {
                    Connection conn = Home.connection;
                    String query = "SELECT * FROM Customer WHERE Cid = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, cid);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        String updateQuery = "UPDATE Customer SET IndeedIn = ? WHERE Cid = ?";
                        PreparedStatement updatePstmt = conn.prepareStatement(updateQuery);
                        Timestamp now = new Timestamp(System.currentTimeMillis());
                        updatePstmt.setTimestamp(1, now);
                        updatePstmt.setString(2, cid);
                        updatePstmt.executeUpdate();
                        lb_tips.setText("登记成功！");
                        functionTips();

                        // 显示顾客详细信息
                        String name = rs.getString("Name");
                        String rid = rs.getString("Rid");
                        String vip = rs.getString("VIP");
                        Timestamp intime = rs.getTimestamp("Intime");
                        Timestamp outtime = rs.getTimestamp("Outtime");
                        Timestamp indeedIn = rs.getTimestamp("IndeedIn");

                        taCustomerDetails.setText(String.format(
                                "姓名: %s\n身份证号: %s\n房间号: %s\nVIP: %s\n入住时间: %s\n退房时间: %s\n实际入住时间: %s",
                                name, cid, rid, vip, intime, outtime, indeedIn
                        ));
                    } else {
                        lb_tips.setText("未找到此身份证号的预定记录！");
                        functionTips();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    lb_tips.setText("数据库错误：" + ex.getMessage());
                    functionTips();
                }
            }
        });

        tabbedPane.addTab("已约定", reservedPanel);

        // 未预定选项卡
        JPanel unreservedPanel = new JPanel(null);
        unreservedPanel.setBounds(10, 10, 1000, 385); // 设置未预定面板的大小和位置

        // 第一部分：房型输入与检测
        JPanel roomTypePanel = new JPanel(null);
        roomTypePanel.setBounds(20, 20, 1000, 100); // 设置房型输入与检测部分的大小和位置
        JLabel lblRoomType = new JLabel("房型：");
        lblRoomType.setBounds(10, 10, 100, 30);
        JTextField tfRoomType = new JTextField();
        tfRoomType.setBounds(120, 10, 140, 30);
        JButton btnCheckRoomType = new JButton("检查房型");
        btnCheckRoomType.setBounds(270, 10, 100, 30);

        roomTypePanel.add(lblRoomType);
        roomTypePanel.add(tfRoomType);
        roomTypePanel.add(btnCheckRoomType);

        // 第二部分：顾客信息输入
        JPanel customerInfoPanel = new JPanel(null);
        customerInfoPanel.setBounds(20, 100, 1000, 550); // 设置顾客信息输入部分的大小和位置
        JLabel lblName = new JLabel("姓名：");
        lblName.setBounds(10, 10, 100, 30);
        JTextField tfName = new JTextField();
        tfName.setBounds(120, 10, 140, 30);

        JLabel lblCid = new JLabel("身份证号：");
        lblCid.setBounds(10, 50, 100, 30);
        JTextField tfCid = new JTextField();
        tfCid.setBounds(120, 50, 140, 30);

        JLabel lblPhoneNumber = new JLabel("电话号码：");
        lblPhoneNumber.setBounds(10, 90, 100, 30);
        JTextField tfPhoneNumber = new JTextField();
        tfPhoneNumber.setBounds(120, 90, 140, 30);

        JLabel lblVIP = new JLabel("VIP：");
        lblVIP.setBounds(10, 130, 100, 30);
        JTextField tfVIP = new JTextField();
        tfVIP.setBounds(120, 130, 140, 30);

        JLabel lblPassword = new JLabel("密码：");
        lblPassword.setBounds(10, 170, 100, 30);
        JTextField tfPassword = new JTextField();
        tfPassword.setBounds(120, 170, 140, 30);

        JLabel lblDays = new JLabel("入住天数：");
        lblDays.setBounds(10, 210, 100, 30);
        JTextField tfDays = new JTextField();
        tfDays.setBounds(120, 210, 140, 30);

        JButton btnCheckInUnreserved = new JButton("登记");
        btnCheckInUnreserved.setBounds(270, 210, 100, 30);

        customerInfoPanel.add(lblName);
        customerInfoPanel.add(tfName);
        customerInfoPanel.add(lblCid);
        customerInfoPanel.add(tfCid);
        customerInfoPanel.add(lblPhoneNumber);
        customerInfoPanel.add(tfPhoneNumber);
        customerInfoPanel.add(lblVIP);
        customerInfoPanel.add(tfVIP);
        customerInfoPanel.add(lblPassword);
        customerInfoPanel.add(tfPassword);
        customerInfoPanel.add(lblDays);
        customerInfoPanel.add(tfDays);
        customerInfoPanel.add(btnCheckInUnreserved);

        // 初始时隐藏顾客信息输入部分
        customerInfoPanel.setVisible(false);

        btnCheckRoomType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String roomType = tfRoomType.getText();
                if (roomType.isEmpty()) {
                    lb_tips.setText("请输入房型！");
                    functionTips();
                    return;
                }

                try {
                    Connection conn = Home.connection;
                    String query = "SELECT MIN(Rid) AS Rid FROM Room WHERE Rtype = ? AND Rstate = '空闲'";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, roomType);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next() && rs.getString("Rid") != null) {
                        lb_tips.setText("有空闲房间！");
                        functionTips();
                        customerInfoPanel.setVisible(true);
                    } else {
                        lb_tips.setText("没有空闲房间！");
                        functionTips();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    lb_tips.setText("数据库错误：" + ex.getMessage());
                    functionTips();
                }
            }
        });

        btnCheckInUnreserved.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                String cid = tfCid.getText();
                String phoneNumber = tfPhoneNumber.getText();
                String vip = tfVIP.getText();
                String password = tfPassword.getText();
                String daysStr = tfDays.getText();

                if (name.isEmpty() || cid.isEmpty() || phoneNumber.isEmpty() || vip.isEmpty() || password.isEmpty() || daysStr.isEmpty()) {
                    lb_tips.setText("请输入所有信息！");
                    functionTips();
                    return;
                }

                try {
                    int days = Integer.parseInt(daysStr);
                    Connection conn = Home.connection;

                    // 查询最小的空闲房间号
                    String roomType = tfRoomType.getText();
                    String query = "SELECT MIN(Rid) AS Rid FROM Room WHERE Rtype = ? AND Rstate = '空闲'";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, roomType);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next() && rs.getString("Rid") != null) {
                        String rid = rs.getString("Rid");

                        // 插入顾客信息
                        String insertQuery = "INSERT INTO Customer (name, Cid, Cphonenumber, VIP, Cpassword, Intime, IndeedIn, Outtime, IndeedOut, Rid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement insertPstmt = conn.prepareStatement(insertQuery);
                        Timestamp now = new Timestamp(System.currentTimeMillis());
                        Timestamp outTime = new Timestamp(now.getTime() + (long) days * 24 * 60 * 60 * 1000);
                        insertPstmt.setString(1, name);
                        insertPstmt.setString(2, cid);
                        insertPstmt.setString(3, phoneNumber);
                        insertPstmt.setString(4, vip);
                        insertPstmt.setString(5, password);
                        insertPstmt.setTimestamp(6, now);
                        insertPstmt.setTimestamp(7, now);
                        insertPstmt.setTimestamp(8, outTime);
                        insertPstmt.setTimestamp(9, null);
                        insertPstmt.setString(10, rid);
                        insertPstmt.executeUpdate();

                        // 更新房间状态
                        String updateRoomQuery = "UPDATE Room SET Rstate = '已入住' WHERE Rid = ?";
                        PreparedStatement updateRoomPstmt = conn.prepareStatement(updateRoomQuery);
                        updateRoomPstmt.setString(1, rid);
                        updateRoomPstmt.executeUpdate();

                        lb_tips.setText("登记成功！");
                        functionTips();
                    } else {
                        lb_tips.setText("没有空闲房间！");
                        functionTips();
                    }
                } catch (SQLException | NumberFormatException ex) {
                    ex.printStackTrace();
                    lb_tips.setText("输入错误或数据库错误：" + ex.getMessage());
                    functionTips();
                }
            }
        });

        unreservedPanel.add(roomTypePanel);
        unreservedPanel.add(customerInfoPanel);

        tabbedPane.addTab("未预定", unreservedPanel);

        checkInPanel.add(tabbedPane);

        return checkInPanel;
    }




    public JPanel customerQuery() {
        // 创建主面板并设置布局为空（null），以便使用 setBounds 手动设置位置和大小
        JPanel panel = new JPanel(null);
        panel.setLayout(null);
        panel.setSize(1040, 735);
        panel.setBorder(BorderFactory.createEtchedBorder());

        // 查询顾客面板
        JPanel searchCustomerPanel = new JPanel(null);
        searchCustomerPanel.setBounds(10, 10, 1020, 700); // 设置面板的大小和位置

        JPanel searchPanel = new JPanel(null);
        searchPanel.setBounds(10, 10, 760, 50); // 设置查询面板的大小和位置

        JLabel cidLabel = new JLabel("身份证号:");
        cidLabel.setFont(new Font("黑体", Font.PLAIN, 18)); // 设置标签字体
        cidLabel.setBounds(10, 10, 100, 30); // 设置标签的大小和位置

        JTextField cidField = new JTextField(15);
        cidField.setFont(new Font("黑体", Font.PLAIN, 18)); // 设置文本框字体
        cidField.setBounds(120, 10, 200, 30); // 设置文本框的大小和位置

        JButton searchButton = new JButton("查询");
        searchButton.setFont(new Font("黑体", Font.PLAIN, 18)); // 设置按钮字体
        searchButton.setBounds(330, 10, 100, 30); // 设置按钮的大小和位置

        searchPanel.add(cidLabel);
        searchPanel.add(cidField);
        searchPanel.add(searchButton);

        JTable customerTable = new JTable();
        JScrollPane customerScrollPane = new JScrollPane(customerTable);
        customerScrollPane.setBounds(10, 70, 1000, 620); // 设置滚动面板的大小和位置
        searchCustomerPanel.add(searchPanel);
        searchCustomerPanel.add(customerScrollPane);

        // 查询按钮事件
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cid = cidField.getText().trim();
                if (cid.isEmpty()) {
                    lb_tips.setText("请输入身份证号！");
                    functionTips();
                    return;
                }
                try {
                    Connection conn = Home.connection;
                    String query = "SELECT * FROM Customer WHERE Cid = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, cid);
                    ResultSet rs = pstmt.executeQuery();
                    customerTable.setModel(buildTableModel(rs));
                    customerTable.setFont(new Font("黑体", Font.PLAIN, 18)); // 设置表格字体
                    customerTable.setRowHeight(25); // 设置表格行高
                    JTableHeader header = customerTable.getTableHeader();
                    header.setFont(new Font("黑体", Font.BOLD, 20)); // 设置表头字体
                    header.setPreferredSize(new Dimension(1, 30)); // 设置表头高度
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    lb_tips.setText("数据库错误：" + ex.getMessage());
                    functionTips();
                }
            }
        });

        // 添加查询顾客面板到主面板
        panel.add(searchCustomerPanel);
        return panel;
    }


    // 辅助方法：将 ResultSet 转换为 TableModel
    private static TableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }





    public JPanel roomQuery() {
        // 创建主面板并设置布局为空（null），以便使用 setBounds 手动设置位置和大小
        JPanel panel = new JPanel(null);
        panel.setLayout(null);
        panel.setSize(1040, 735);
        panel.setBorder(BorderFactory.createEtchedBorder());

        // 查询空闲房间面板
        JPanel freeRoomsPanel = new JPanel(null);
        freeRoomsPanel.setBounds(10, 10, 1020, 700); // 设置面板的大小和位置

        JTable freeRoomsTable = new JTable(); // 创建用于显示空闲房间信息的表格
        JScrollPane freeRoomsScrollPane = new JScrollPane(freeRoomsTable);
        freeRoomsScrollPane.setBounds(10, 10, 1000, 620); // 设置滚动面板的大小和位置
        freeRoomsPanel.add(freeRoomsScrollPane);

        // 查询空闲房间信息
        try {
            Connection conn = Home.connection;
            String query = "SELECT * FROM Room WHERE Rstate = '空闲'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            freeRoomsTable.setModel(buildTableModel(rs));
            freeRoomsTable.setFont(new Font("黑体", Font.PLAIN, 18)); // 设置表格字体
            freeRoomsTable.setRowHeight(25); // 设置表格行高
            JTableHeader header = freeRoomsTable.getTableHeader();
            header.setFont(new Font("黑体", Font.BOLD, 20)); // 设置表头字体
            header.setPreferredSize(new Dimension(1, 30)); // 设置表头高度
        } catch (SQLException ex) {
            ex.printStackTrace();
            lb_tips.setText("数据库错误：" + ex.getMessage());
            functionTips();
        }

        // 添加查询空闲房间面板到主面板
        panel.add(freeRoomsPanel);
        return panel;
    }



    public JPanel checkOut(String hsid) {
        // 创建面板和组件
        JPanel panel = new JPanel(null); // 使用 null 布局
        panel.setLayout(null);
        panel.setSize(1040, 735);
        panel.setBorder(BorderFactory.createEtchedBorder());

        // 组件的大小和位置
        int labelWidth = 200;
        int labelHeight = 60;
        int fieldWidth = 400;
        int fieldHeight = 60;
        int buttonWidth = 200;
        int buttonHeight = 60;

        // 组件的间距
        int verticalGap = 20;

        // 面板中心点
        int centerX = panel.getWidth() / 2;
        int centerY = panel.getHeight() / 2;

        // 顾客身份证号标签和文本框
        JLabel cidLabel = new JLabel("顾客身份证号:");
        cidLabel.setFont(cidLabel.getFont().deriveFont(24.0f));
        cidLabel.setBounds(centerX - labelWidth - fieldWidth / 2, centerY - 2 * (labelHeight + verticalGap) - fieldHeight / 2, labelWidth, labelHeight);
        JTextField cidField = new JTextField();
        cidField.setBounds(centerX - fieldWidth / 2, centerY - 2 * (labelHeight + verticalGap) - fieldHeight / 2, fieldWidth, fieldHeight);

        // 支付金额标签和文本框
        JLabel bpriceLabel = new JLabel("支付金额:");
        bpriceLabel.setFont(bpriceLabel.getFont().deriveFont(24.0f));
        bpriceLabel.setBounds(centerX - labelWidth - fieldWidth / 2, centerY - (labelHeight + verticalGap) - fieldHeight / 2, labelWidth, labelHeight);
        JTextField bpriceField = new JTextField();
        bpriceField.setBounds(centerX - fieldWidth / 2, centerY - (labelHeight + verticalGap) - fieldHeight / 2, fieldWidth, fieldHeight);

        // 结账按钮
        JButton submitButton = new JButton("结账");
        submitButton.setFont(submitButton.getFont().deriveFont(24.0f));
        submitButton.setBounds(centerX - buttonWidth / 2, centerY, buttonWidth, buttonHeight);

        // 将组件添加到面板
        panel.add(cidLabel);
        panel.add(cidField);
        panel.add(bpriceLabel);
        panel.add(bpriceField);
        panel.add(submitButton);

        // 提交按钮事件
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cid = cidField.getText().trim();
                String bpriceStr = bpriceField.getText().trim();

                // 验证输入
                if (cid.isEmpty() || bpriceStr.isEmpty()) {
                    lb_tips.setText("请输入所有字段！");
                    functionTips();
                    return;
                }

                double bprice;
                try {
                    bprice = Double.parseDouble(bpriceStr);
                } catch (NumberFormatException ex) {
                    lb_tips.setText("支付金额必须是数字！");
                    functionTips();
                    return;
                }

                try {
                    Connection conn = Home.connection;
                    // 获取最大Bid
                    String maxBidQuery = "SELECT MAX(Bid) FROM Bill";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(maxBidQuery);
                    int maxBid = 0;
                    if (rs.next()) {
                        maxBid = rs.getInt(1);
                    }
                    int newBid = maxBid + 1;

                    // 获取当前时间戳
                    Timestamp currentTime = new Timestamp(System.currentTimeMillis());

                    // 插入到Bill表中
                    String insertBillQuery = "INSERT INTO Bill (Bid, Cid, HSid, Btime, Bprice) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(insertBillQuery);
                    pstmt.setInt(1, newBid);
                    pstmt.setString(2, cid);
                    pstmt.setString(3, hsid);
                    pstmt.setTimestamp(4, currentTime);
                    pstmt.setDouble(5, bprice);

                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        lb_tips.setText("结账成功！");
                    } else {
                        lb_tips.setText("结账失败！");
                    }
                    functionTips();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    lb_tips.setText("数据库错误：" + ex.getMessage());
                    functionTips();
                }
            }
        });

        return panel;
    }

    public JPanel serviceRecord() {
        // 创建主面板和布局
        JPanel panel = new JPanel(null); // 使用 null 布局
        panel.setLayout(null);
        panel.setSize(1040, 735);
        panel.setBorder(BorderFactory.createEtchedBorder());

        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("服务ID");
        tableModel.addColumn("房间号");
        tableModel.addColumn("服务类型");
        tableModel.addColumn("服务描述");
        tableModel.addColumn("服务时间");

        // 创建表格
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 1000, 600); // 设置表格位置和大小

        // 创建完成服务按钮
        JButton completeButton = new JButton("完成服务");
        completeButton.setBounds(20, 640, 200, 60); // 设置按钮位置和大小

        // 完成服务按钮事件
        completeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                if (selectedRows.length == 0) {
                    lb_tips.setText("请选择要完成的服务！");
                    functionTips();
                    return;
                }
                try {
                    Connection conn = Home.connection;
                    for (int row : selectedRows) {
                        String serviceId = tableModel.getValueAt(row, 0).toString();
                        String query = "DELETE FROM RoomService WHERE RSid = ?";
                        PreparedStatement pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, serviceId);
                        pstmt.executeUpdate();
                    }
                    lb_tips.setText("服务完成！");
                    functionTips();

                    // 刷新表格
                    loadServiceRecords(tableModel);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    lb_tips.setText("数据库错误：" + ex.getMessage());
                    functionTips();
                }
            }
        });

        // 加载客房服务记录
        loadServiceRecords(tableModel);

        // 将组件添加到面板
        panel.add(scrollPane);
        panel.add(completeButton);

        return panel;
    }


    // 加载客房服务记录到表格模型
    private void loadServiceRecords(DefaultTableModel tableModel) {
        tableModel.setRowCount(0); // 清空现有数据
        try {
            Connection conn = Home.connection;
            String query = "SELECT RSid, Rid, RScontent, RStime FROM RoomService";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String rsid = rs.getString("RSid");
                String rid = rs.getString("Rid");
                String scontent = rs.getString("RScontent");
                Timestamp rsTime = rs.getTimestamp("RStime");
                tableModel.addRow(new Object[]{rsid, rid, scontent, rsTime});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            lb_tips.setText("数据库错误：" + ex.getMessage());
            functionTips();
        }
    }

    public JPanel reservationRecord() {
        JPanel panel = new JPanel(null);
        panel.setLayout(null);
        panel.setSize(1040, 735);
        panel.setBorder(BorderFactory.createEtchedBorder());

        JTabbedPane tabbedPane = new JTabbedPane();

        // 管理预约选项卡
        JPanel manageReservationPanel = new JPanel(null); // 使用 null 布局
        manageReservationPanel.setBounds(10, 10, 1020, 500); // 设置面板大小

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("预约ID");
        tableModel.addColumn("客户ID");
        tableModel.addColumn("项目ID");
        tableModel.addColumn("预约时间");
        JTable reservationTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(reservationTable);
        scrollPane.setBounds(20, 20, 1000, 570); // 设置表格位置和大小
        manageReservationPanel.add(scrollPane);

        // 自动删除超过一天的预约记录
        removeExpiredReservations(tableModel);
        loadReservations(tableModel);

        // 预约选项卡
        JPanel makeReservationPanel = new JPanel(null); // 使用 null 布局
        makeReservationPanel.setBounds(10, 10, 1020, 500); // 设置面板大小

        JLabel lblCid = new JLabel("客户ID:");
        lblCid.setBounds(20, 20, 100, 30); // 设置标签位置和大小
        JTextField txtCid = new JTextField();
        txtCid.setBounds(130, 20, 200, 30); // 设置文本框位置和大小

        JLabel lblEid = new JLabel("项目:");
        lblEid.setBounds(20, 60, 100, 30); // 设置标签位置和大小
        String[] entertainments = {"健身房", "游泳池", "桌球", "电影院", "KTV包间", "SPA按摩", "网球场", "儿童乐园", "酒吧", "篮球场", "足球场", "健身操房", "游乐园", "图书馆", "美容美发", "自行车租赁", "水上乐园", "钓鱼塘", "户外烧烤", "VR体验馆", "体育赛事观看", "电子游戏室", "剧院演出", "绘画工作室", "瑜伽室", "摄影棚", "音乐会", "高尔夫球场", "潜水中心", "滑雪场", "室内攀岩", "真人CS", "博物馆", "高空跳伞", "滑板公园", "极限运动", "卡丁车", "沙滩排球"};
        JComboBox<String> cmbEntertainment = new JComboBox<>(entertainments);
        cmbEntertainment.setBounds(130, 60, 200, 30); // 设置下拉框位置和大小

        JButton btnReserve = new JButton("预约");
        btnReserve.setBounds(20, 100, 100, 30); // 设置按钮位置和大小

        makeReservationPanel.add(lblCid);
        makeReservationPanel.add(txtCid);
        makeReservationPanel.add(lblEid);
        makeReservationPanel.add(cmbEntertainment);
        makeReservationPanel.add(btnReserve);

        // 预约按钮事件
        btnReserve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cid = txtCid.getText().trim();
                String selectedEntertainment = (String) cmbEntertainment.getSelectedItem();
                Timestamp ptime = new Timestamp(System.currentTimeMillis());

                if (cid.isEmpty()) {
                    lb_tips.setText("客户ID不能为空！");
                    functionTips();
                    return;
                }

                // 根据下拉选项决定Eid
                String eid = getEidByEntertainment(selectedEntertainment);

                try {
                    Connection conn = Home.connection;

                    // 获取当前最大 pid 并生成新 pid
                    String maxPidQuery = "SELECT MAX(Pid) FROM Preservation";
                    PreparedStatement maxPidStmt = conn.prepareStatement(maxPidQuery);
                    ResultSet rs = maxPidStmt.executeQuery();
                    int newPid = 1;
                    if (rs.next()) {
                        newPid = rs.getInt(1) + 1;
                    }

                    // 插入预约信息
                    String query = "INSERT INTO Preservation (Pid, Cid, Eid, Ptime) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, newPid);
                    pstmt.setString(2, cid);
                    pstmt.setString(3, eid);
                    pstmt.setTimestamp(4, ptime);
                    pstmt.executeUpdate();

                    lb_tips.setText("预约成功！");
                    functionTips();
                    loadReservations(tableModel); // 刷新表格
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    lb_tips.setText("数据库错误：" + ex.getMessage());
                    functionTips();
                }
            }
        });

        tabbedPane.addTab("管理预约", manageReservationPanel);
        tabbedPane.addTab("预约选项卡", makeReservationPanel);
        tabbedPane.setBounds(0, 0, 1040, 590);

        panel.add(tabbedPane, BorderLayout.CENTER);
        return panel;
    }



    // 自动删除超过一天的预约记录
    private void removeExpiredReservations(DefaultTableModel tableModel) {
        try {
            Connection conn = Home.connection;
            String deleteQuery = "DELETE FROM Preservation WHERE DATEDIFF(day, Ptime, GETDATE()) > 1";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(deleteQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
            lb_tips.setText("数据库错误：" + ex.getMessage());
            functionTips();
        }
    }

    // 加载所有预约记录到表格模型
    private void loadReservations(DefaultTableModel tableModel) {
        tableModel.setRowCount(0); // 清空现有数据
        try {
            Connection conn = Home.connection;
            String query = "SELECT Pid, Cid, Eid, Ptime FROM Preservation";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int pid = rs.getInt("Pid");
                String cid = rs.getString("Cid");
                int eid = rs.getInt("Eid");
                Timestamp ptime = rs.getTimestamp("Ptime");
                tableModel.addRow(new Object[]{pid, cid, eid, ptime});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            lb_tips.setText("数据库错误：" + ex.getMessage());
            functionTips();
        }
    }

    // 根据娱乐项目名称返回对应的Eid
    private String getEidByEntertainment(String entertainment) {
        String eid = "1111";
        try {
            Connection conn = Home.connection;
            String query = "SELECT Eid FROM Entertainments WHERE Ename = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entertainment);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                eid = rs.getString("Eid");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            lb_tips.setText("数据库错误：" + ex.getMessage());
            functionTips();
        }
        return eid;
    }

    public JPanel feedbackRecord() {
        JPanel feedbackPanel = new JPanel(null); // 使用null布局管理器
        feedbackPanel.setLayout(null);
        feedbackPanel.setSize(1040, 735);
        feedbackPanel.setBorder(BorderFactory.createEtchedBorder());
        // 创建表格模型并设置表格列
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("反馈ID");
        tableModel.addColumn("客户ID");
        tableModel.addColumn("反馈内容");
        tableModel.addColumn("反馈时间");

        // 创建表格
        JTable feedbackTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(feedbackTable);
        scrollPane.setBounds(20, 20, 1000, 600); // 设置滚动面板位置和大小
        feedbackPanel.add(scrollPane);

        // 加载所有反馈记录到表格模型
        loadFeedbacks(tableModel);

        // 创建删除按钮
        JButton btnResolve = new JButton("已解决");
        btnResolve.setBounds(820, 620, 200, 50); // 设置按钮位置和大小
        btnResolve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = feedbackTable.getSelectedRows();
                if (selectedRows.length == 0) {
                    lb_tips.setText("请选择要删除的记录！");
                    functionTips();
                    return;
                }

                try {
                    Connection conn = Home.connection;
                    String deleteQuery = "DELETE FROM Suggestions WHERE Sid = ?";
                    PreparedStatement pstmt = conn.prepareStatement(deleteQuery);

                    for (int row : selectedRows) {
                        int sid = (int) tableModel.getValueAt(row, 0);
                        pstmt.setInt(1, sid);
                        pstmt.executeUpdate();
                    }

                    lb_tips.setText("记录已删除！");
                    functionTips();
                    loadFeedbacks(tableModel); // 刷新表格
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    lb_tips.setText("数据库错误：" + ex.getMessage());
                    functionTips();
                }
            }
        });

        feedbackPanel.add(btnResolve);

        return feedbackPanel;
    }


    // 加载所有反馈记录到表格模型
    private void loadFeedbacks(DefaultTableModel tableModel) {
        tableModel.setRowCount(0); // 清空现有数据
        try {
            Connection conn = Home.connection;
            String query = "SELECT Sid, Cid, Scontent, Stime FROM Suggestions";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int sid = rs.getInt("Sid");
                String cid = rs.getString("Cid");
                String scontent = rs.getString("Scontent");
                Timestamp stime = rs.getTimestamp("Stime");
                tableModel.addRow(new Object[]{sid, cid, scontent, stime});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            lb_tips.setText("数据库错误：" + ex.getMessage());
            functionTips();
        }
    }

    public void functionTips() { //操作时弹出的提示信息窗口
        JDialog tips=new JDialog(EmployeeJFrame,"  提示",true);
        JPanel pn_tips=new JPanel();
        JButton bt_tips=new JButton("确定");
        tips.setSize(500,200);
        tips.setLocationRelativeTo(null);
        tips.setResizable(false);
        tips.setLayout(null);
        pn_tips.setBounds(0,30,500,70);
        lb_tips.setFont(new Font("黑体",0,25));
        bt_tips.setFont(new Font("黑体",0,20));
        bt_tips.setBounds(200,100,100,50);
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

    public void choiceTips(String str) { //操作时弹出的提示选择窗口
        JDialog choiceTips=new JDialog(EmployeeJFrame,"  提示",true);
        JPanel pn_tips=new JPanel();
        JButton bt_yes=new JButton("是(Y)");
        JButton bt_no=new JButton("否(N)");
        choiceTips.setSize(500,200);
        choiceTips.setLocationRelativeTo(null);
        choiceTips.setResizable(false);
        choiceTips.setLayout(null);
        pn_tips.setBounds(0,30,500,70);
        lb_tips.setFont(new Font("黑体",0,25));
        bt_yes.setFont(new Font("黑体",0,20));
        bt_yes.setBounds(135,100,100,50);
        bt_yes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bt_no.setFont(new Font("黑体",0,20));
        bt_no.setBounds(260,100,100,50);
        bt_no.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pn_tips.add(lb_tips);
        choiceTips.add(pn_tips);
        choiceTips.add(bt_yes);
        choiceTips.add(bt_no);
        bt_yes.addActionListener(new ActionListener() { //选择“是”，进行相应操作
            public void actionPerformed(ActionEvent e) {
                choiceTips.dispose();
                yesOperation(str);
            }
        });
        bt_no.addActionListener(new ActionListener() { //选择“否”，关闭提示选择窗口
            public void actionPerformed(ActionEvent e) {
                choiceTips.dispose();
            }
        });
        bt_yes.addKeyListener(new KeyListener() { //“是”按钮的快捷键“Y”，“否”按钮的快捷键“N”
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_Y) {
                    choiceTips.dispose();
                    yesOperation(str);
                }
                if(e.getKeyCode()==KeyEvent.VK_N) {
                    choiceTips.dispose();
                }
            }
            public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        });
        bt_no.addKeyListener(new KeyListener() { //“是”按钮的快捷键“Y”，“否”按钮的快捷键“N”
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_Y) {
                    choiceTips.dispose();
                    yesOperation(str);
                }
                if(e.getKeyCode()==KeyEvent.VK_N) {
                    choiceTips.dispose();
                }
            }
            public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        });
        choiceTips.setVisible(true);
    }

    public void yesOperation(String str) { //选择“是”之后，根据提示内容，选择要进行的操作
        if(lb_tips.getText().equals("是否退出系统管理模式？")) { //确定退出系统管理模式，返回到欢迎界面
            try {
                Home.connection.close(); //关闭数据库连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
            EmployeeJFrame.dispose();
            Home.con.removeAll();
            Home.mainJFrame.repaint();
            Home.welcomePage();
            Home.mainJFrame.validate();
        }
    }
}