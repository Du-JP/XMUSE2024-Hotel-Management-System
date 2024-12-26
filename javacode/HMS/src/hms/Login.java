package hms;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login { // 登录类
    JLabel lb_tips = new JLabel(); // 显示登录结果提示

    public void employeeLogin(String account, String password) {
        boolean flag = false; // 是否找到对应账户标志

        // 检查是否是员工或经理登录
        try {
            String sql = "SELECT HSid, HSpermission FROM HotelStaff WHERE HSid = ? AND HSpassword = ?";
            PreparedStatement ps = Home.connection.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String Hsid = rs.getString("HSid");
                boolean isManager = rs.getBoolean("HSpermission");
                if (isManager) { // 经理登录
                    lb_tips.setText("管理员登录成功");
                    loginTips();
                    new ManagerFunction(Hsid);
                    Home.mainJFrame.dispose();
                } else { // 员工登录
                    lb_tips.setText("员工登录成功");
                    loginTips();
                    new EmployeeFunction(Hsid);
                    Home.mainJFrame.dispose();
                }
                flag = true;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!flag) { // 登录失败，显示提示信息
            lb_tips.setText("账号或密码错误");
            loginTips();
            try {
                Home.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void customerLogin(String account, String password) {
        boolean flag = false; // 是否找到对应账户标志

        // 检查是否是顾客登录
        try {
            String sql = "SELECT * FROM Customer WHERE Cid = ? AND Cpassword = ?";
            PreparedStatement ps = Home.connection.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lb_tips.setText("顾客登录成功");
                loginTips();
                new CustomerFunction(account);
                Home.mainJFrame.dispose();
                flag = true;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!flag) { // 登录失败，显示提示信息
            lb_tips.setText("账号或密码错误");
            loginTips();
            try {
                Home.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void loginTips() {
        JDialog tips = new JDialog(Home.mainJFrame, "提示", true);
        JPanel pn_tips = new JPanel();
        JButton bt_tips = new JButton("确定");
        tips.setSize(450, 200);
        tips.setLocationRelativeTo(null);
        tips.setResizable(false);
        tips.setLayout(null);
        pn_tips.setBounds(0, 30, 450, 70);
        lb_tips.setFont(new Font("宋体", 0, 25));
        bt_tips.setFont(new Font("宋体", 0, 20));
        bt_tips.setBounds(175, 100, 100, 50);
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
}
