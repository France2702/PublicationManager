/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Phap Chau
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import dao.UserDao;
//import entity.User;
//import view.LoginView;
//import view.StudentView;

import dao.UserDao;
import entity.User;
import view.LoginView;
import view.PubView;

public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
    private PubView pubView;
    
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserDao();
        view.addLoginListener(new LoginListener());
    }
    
    public void showLoginView() {
        loginView.setVisible(true);
    }
    
    /**
     * Lớp LoginListener 
     * chứa cài đặt cho sự kiện click button "Login"
     * 
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                pubView = new PubView();
                PubController pubController = new PubController(pubView);
                pubController.showPublicationView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("I can not indentify thís account. You may entered wrong user name or password. Please try again.");
            }
        }
    }
}

