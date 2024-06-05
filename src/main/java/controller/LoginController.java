package controller;

import entity.User;
import func.UserFunc;
import view.LoginView;
import view.StudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.HomeFrame;
import view.TeacherView;

public class LoginController {
    private UserFunc userDao;
    private LoginView loginView;
    private StudentView studentView;
    
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserFunc();
        view.addLoginListener(new LoginListener());
    }
    
    public void showLoginView() {
        loginView.setVisible(true);
    }
    
    /**
     * Lớp LoginListener chứa cài đặt cho sự kiện click button "Login"
     * 
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
//                studentView = new StudentView();
//                StudentController studentController = new StudentController(studentView);
//                studentController.showStudentView();
//                TeacherView teacherView = new   TeacherView();
//                TeacherController teacherController = new TeacherController(teacherView);
//                teacherController.showTeacherView();
                    HomeFrame openHomeFrame  =  new HomeFrame();
                    openHomeFrame.setVisible(true);
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }
}
