package controller;

import entity.User;
import func.UserFunc;
import view.LoginView;
import view.StudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private UserFunc userDao;
    private LoginView loginView;
    
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = TrungTamController.Instance().getUserFunc();
        view.addLoginListener(new LoginListener());
    }
    
    public void showLoginView() {
        loginView.setVisible(true);
    }
    
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                    loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }
}
