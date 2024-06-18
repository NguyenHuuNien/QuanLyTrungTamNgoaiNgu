
package controller;

import func.*;
// Sử dụng toàn ứng dụng. Cho các Controller sử dụng,ngoài ra để có thể lấy danh sách của từng entity
public class TrungTamController {
    private static TrungTamController instance;
    private TrungTamController(){
    }
    public static TrungTamController Instance(){
        if(instance==null){
            instance = new TrungTamController();
        }
        return instance;
    }
    // các Func
    private UserFunc userFunc = new UserFunc();
    private TeacherFunc teacherFunc = new TeacherFunc();
    private StudentFunc studentFunc = new StudentFunc();
    private KhoaHocFunc khoaHocFunc = new KhoaHocFunc();

    public UserFunc getUserFunc() {
        return userFunc;
    }

    public TeacherFunc getTeacherFunc() {
        return teacherFunc;
    }

    public StudentFunc getStudentFunc() {
        return studentFunc;
    }

    public KhoaHocFunc getKhoaHocFunc() {
        return khoaHocFunc;
    }
    
}
