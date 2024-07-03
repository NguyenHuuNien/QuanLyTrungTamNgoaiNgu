package func;


import controller.TrungTamController;
import entity.Student;
import entity.Teacher;
import entity.User;
import java.util.List;
import javax.swing.JFrame;
import view.HomeFrame;
import view.KhoaHocView;

public class UserFunc {
    public boolean checkUser(User user) {
        if (user != null) {
            if ("admin".equals(user.getUserName()) 
                    && "admin".equals(user.getPassword())) {
                new HomeFrame().setVisible(true);
                return true;
            }else{
                List<Student> dsStudent = TrungTamController.Instance().getStudentFunc().getListStudents();
                for(Student st : dsStudent){
                    String tk = st.getId()+"";
                    String mk = st.getDOB().substring(0, 2) + st.getDOB().substring(3,5) + st.getDOB().substring(6);
                    if(tk.equals(user.getUserName())&&mk.equals(user.getPassword())){
                        KhoaHocView khView = new KhoaHocView(st);
                        khView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        khView.setVisible(true);
                        return true;
                    }
                }
                List<Teacher> dsTeacher = TrungTamController.Instance().getTeacherFunc().getListTeachers();
                for(Teacher tc : dsTeacher){
                    String tk = tc.getId()+"";
                    String mk = tc.getDOB().substring(0, 2) + tc.getDOB().substring(3,5) + tc.getDOB().substring(6);
                    if(tk.equals(user.getUserName())&&mk.equals(user.getPassword())){
                        KhoaHocView khView = new KhoaHocView(tc);
                        khView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        khView.setVisible(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
