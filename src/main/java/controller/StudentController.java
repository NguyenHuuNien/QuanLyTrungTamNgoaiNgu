package controller;

import entity.KhoaHoc;
import entity.Student;
import func.StudentFunc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.StudentView;

public class StudentController {
    private StudentFunc studentDao;
    private StudentView studentView;

    public StudentController(StudentView view) {
        this.studentView = view;
        studentDao = TrungTamController.Instance().getStudentFunc();
        
        view.addAddStudentListener(new AddStudentListener());
        view.addEdiStudentListener(new EditStudentListener());
        view.addDeleteStudentListener(new DeleteStudentListener());
        view.addClearListener(new ClearStudentListener());
        view.addSortStudentAgeListener(new SortStudentAgeListener());
        view.addSortStudentNameListener(new SortStudentNameListener());
        view.addListStudentSelectionListener(new ListStudentSelectionListener());
        view.addQuanLyKhoaHoc(new QuanLyKhoaHoc());
        view.addSearchListener(new SearchListener());
    }

    public void showStudentView() {
        studentView.setVisible(true);
        studentView.showListStudents(studentDao.getListStudents());
    }
    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                TrungTamController.Instance().getStudentFunc().add(student);
                studentView.showStudent(student);
                studentView.showListStudents(studentDao.getListStudents());
                studentView.showMessage("Thêm thành công!");
            }
        }
    }
    class EditStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                TrungTamController.Instance().getStudentFunc().edit(student);
                studentView.showStudent(student);
                studentView.showListStudents(studentDao.getListStudents());
                studentView.showMessage("Cập nhật thành công!");
            }
        }
    }

    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                TrungTamController.Instance().getStudentFunc().delete(student);
                studentView.clearStudentInfo();
                studentView.showListStudents(studentDao.getListStudents());
                studentView.showMessage("Xóa thành công!");
                
                // Xoa Student trong cac khoa hoc
                List<KhoaHoc> dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
                for(KhoaHoc kh : dsKH){
                    if(kh.checkContainsStudent(student)){
                        kh.removeStudent(student);
                        TrungTamController.Instance().getKhoaHocFunc().edit(kh);
                    }
                }
            }
        }
    }
    class SearchListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            List<Student> dsStudent = new ArrayList<>();
            Student student = studentView.getInfoSearch();
            if(student.getName()==null&&student.getAddress()==null&&student.getDOB()==null){
                return;
            }
            System.out.println(student.toString());
            for(Student st : studentDao.getListStudents()){
                if(student.getName()!=null && st.getName().contains(student.getName())){
                    dsStudent.add(st);
                    continue;
                }
                if(student.getDOB()!=null&&st.getDOB().contains(student.getDOB())){
                    dsStudent.add(st);
                    continue;
                }
                if(student.getAddress()!=null&&st.getAddress().contains(student.getAddress())){
                    dsStudent.add(st);
                }
            }
            studentView.showListStudents(dsStudent);
        }
    }
    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentView.clearStudentInfo();
            studentView.showListStudents(studentDao.getListStudents());
        }
    }
    class QuanLyKhoaHoc implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            studentView.OpenQuanLyKhoaHoc();
        }
    }
    class SortStudentAgeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TrungTamController.Instance().getStudentFunc().sortStudentByID();
            studentView.showListStudents(studentDao.getListStudents());
        }
    }

    class SortStudentNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TrungTamController.Instance().getStudentFunc().sortStudentByName();
            studentView.showListStudents(studentDao.getListStudents());
        }
    }

    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            studentView.fillStudentFromSelectedRow();
        }
    }
}