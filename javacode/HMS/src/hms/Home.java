package hms;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home { // 主页类
    static JFrame mainJFrame = new JFrame("酒店管理系统"); // 主窗口
    static Container con = mainJFrame.getContentPane(); // 内容面板
    static boolean flag; // 是否为管理员模式
    static Connection connection = null; // 数据库连接

    public static void main(String[] args) {
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作
        mainJFrame.setResizable(false); // 禁止窗口调整大小
        con.setLayout(null); // 使用空布局
        welcomePage(); // 显示欢迎页面
    }

    public static void welcomePage() { // 欢迎页面
        mainJFrame.setSize(600, 450); // 设置窗口大小
        mainJFrame.setLocationRelativeTo(null); // 窗口居中显示
        JPanel pn = new JPanel(); // 面板
        pn.setSize(600, 450);
        pn.setLayout(null);
        JLabel lb1 = new JLabel("欢迎使用"), lb2 = new JLabel("酒店管理系统");
        JButton bt1 = new JButton("顾客登录"), bt2 = new JButton("员工登录");
        lb1.setFont(new Font("微软雅黑", Font.BOLD, 40));
        lb1.setBounds(220, 40, 180, 80);
        lb2.setFont(new Font("微软雅黑", Font.BOLD, 40));
        lb2.setBounds(180, 120, 300, 80);
        bt1.setFont(new Font("微软雅黑", Font.PLAIN, 22));
        bt1.setBounds(90, 240, 180, 60);
        bt1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bt2.setFont(new Font("微软雅黑", Font.PLAIN, 22));
        bt2.setBounds(330, 240, 180, 60);
        bt2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pn.add(lb1);
        pn.add(lb2);
        pn.add(bt1);
        pn.add(bt2);
        con.add(pn);
        mainJFrame.setVisible(true);

        bt1.addActionListener(new ActionListener() { // 顾客登录按钮事件
            public void actionPerformed(ActionEvent e) {
                flag = false;
                con.remove(pn);
                mainJFrame.repaint();
                loginPage();
                mainJFrame.validate();
            }
        });

        bt2.addActionListener(new ActionListener() { // 员工登录按钮事件
            public void actionPerformed(ActionEvent e) {
                flag = true;
                con.remove(pn);
                mainJFrame.repaint();
                loginPage();
                mainJFrame.validate();
            }
        });
    }

    public static void loginPage() { // 登录页面
        mainJFrame.setSize(600, 450); // 设置窗口大小
        mainJFrame.setLocationRelativeTo(null); // 窗口居中显示
        JPanel pn = new JPanel(); // 面板
        pn.setSize(600, 450);
        pn.setLayout(null);
        JButton bt1 = new JButton("返回", new ImageIcon("image/返回.png")), bt2 = new JButton("登录");
        JTextField tf = new JTextField();
        JPasswordField pf = new JPasswordField();
        JLabel lb1, lb2 = new JLabel("账号："), lb3 = new JLabel("密码：");
        if (flag) {
            lb1 = new JLabel("员工登录");
            lb1.setFont(new Font("微软雅黑", Font.BOLD, 40));
            lb1.setBounds(200, 40, 200, 80);
        } else {
            lb1 = new JLabel("顾客登录");
            lb1.setFont(new Font("微软雅黑", Font.BOLD, 40));
            lb1.setBounds(220, 40, 180, 80);
        }
        lb2.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        lb2.setBounds(100, 140, 100, 40);
        lb3.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        lb3.setBounds(100, 200, 100, 40);
        tf.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        tf.setBounds(210, 140, 250, 40);
        pf.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        pf.setBounds(210, 200, 250, 40);
        bt2.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        bt2.setBounds(220, 280, 160, 60);
        bt2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bt1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        bt1.setBounds(20, 20, 92, 25);
        bt1.setContentAreaFilled(false);
        bt1.setBorderPainted(false);
        bt1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pn.add(lb1);
        pn.add(lb2);
        pn.add(lb3);
        pn.add(tf);
        pn.add(pf);
        pn.add(bt1);
        pn.add(bt2);
        con.add(pn);

        bt1.addMouseListener(new MouseListener() { // 返回欢迎页面按钮事件
            public void mouseEntered(MouseEvent arg0) {
                bt1.setForeground(Color.blue);
            }

            public void mouseExited(MouseEvent arg0) {
                bt1.setForeground(null);
            }

            public void mouseClicked(MouseEvent arg0) {
                con.remove(pn);
                mainJFrame.repaint();
                welcomePage();
                mainJFrame.validate();
            }

            public void mousePressed(MouseEvent arg0) {
            }

            public void mouseReleased(MouseEvent arg0) {
            }
        });

        bt2.addActionListener(new ActionListener() { // 登录按钮事件，根据flag判断调用不同的登录方法
            public void actionPerformed(ActionEvent e) {
                databaseConnection(); // 连接数据库
                if (flag) // 员工登录
                    new Login().employeeLogin(tf.getText(), String.valueOf(pf.getPassword()));
                else // 顾客登录
                    new Login().customerLogin(tf.getText(), String.valueOf(pf.getPassword()));
            }
        });
    }

    public static void databaseConnection() { // 连接SQL Server数据库
        final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // JDBC驱动名
        final String DB_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=HotelMange"; // 数据库URL
        final String USER = "sa"; // 数据库用户名
        final String PASS = "djp123123"; // 数据库密码
        try {
            Class.forName(JDBC_DRIVER); // 注册JDBC驱动
            connection = DriverManager.getConnection(DB_URL, USER, PASS); // 连接数据库
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
