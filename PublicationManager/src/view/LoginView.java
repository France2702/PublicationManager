package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

import entity.User;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.HashSet;
import javax.swing.ImageIcon;

public class LoginView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel userNameLabel;
    private JLabel passwordlabel;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginBtn;
    private JLabel iconLabel;
    private JLabel welcomeLabel;
    private JLabel letloginLabel;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userNameLabel = new JLabel("UserName");
        userNameLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        passwordlabel = new JLabel("Password");
        passwordlabel.setFont(new Font("Serif", Font.PLAIN, 14));
        userNameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginBtn = new JButton();
        loginBtn.setText("Login");
        loginBtn.addActionListener(this);
        welcomeLabel = new JLabel("Hello! I am Publication Manager.");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        letloginLabel = new JLabel("Please login to let me identify you.");
        letloginLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        
        //ImageIcon icon = new ImageIcon("src\\main\\java\\picture\\book-stack.png");
        //String imagePath = getClass().getResource("/book-stack.png").getPath();
        // Tạo một đối tượng ImageIcon với đường dẫn của file hình ảnh
        //ImageIcon icon = new ImageIcon(getClass().getResource("/book-stack.png"));
        // Đặt Icon cho label iconLabel
        //iconLabel.setIcon(icon);
        //ImageIcon icon = new ImageIcon(getClass().getResource("\\view\\bookstack.png"));
        iconLabel = new JLabel();
        iconLabel.setLayout(new BorderLayout());
        iconLabel.setIcon(new ImageIcon(getClass().getResource("/picture/book-stack.png")));
        
        // tạo đối tượng panel để chứa các thành phần của màn hình login
        panel.setSize(600, 320);
        panel.setLayout(layout);
        panel.add(userNameLabel);
        panel.add(passwordlabel);
        panel.add(userNameField);
        panel.add(passwordField);
        panel.add(loginBtn);
        panel.add(iconLabel);
        panel.add(welcomeLabel);
        panel.add(letloginLabel);
        
        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, iconLabel, 270, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, iconLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, welcomeLabel, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, welcomeLabel, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, letloginLabel, 190, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, letloginLabel, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameLabel, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 140, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordlabel, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordlabel, 175, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameField, 80, SpringLayout.WEST, userNameLabel);
        layout.putConstraint(SpringLayout.NORTH, userNameField, 140, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 80, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 175, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginBtn, 120, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, loginBtn, 220, SpringLayout.NORTH, panel);

        
        // add panel tới JFrame
        this.add(panel);
        this.pack();
        // cài đặt các thuộc tính cho JFrame
        this.setTitle("Login");
        this.setSize(600, 320);
        this.setResizable(false);
        setLocationRelativeTo(null);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public User getUser() {
        return new User(userNameField.getText(), 
                String.copyValueOf(passwordField.getPassword()));
    }

    public void actionPerformed(ActionEvent e) {
    }
    
    public void addLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }

}