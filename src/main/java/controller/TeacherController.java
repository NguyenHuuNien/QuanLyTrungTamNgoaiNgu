package controller;

import entity.KhoaHoc;
import entity.Teacher;
import func.TeacherFunc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.TeacherView;

public class TeacherController {
    private TeacherFunc teacherDao;
    private TeacherView teacherView;

    public TeacherController(TeacherView view) {
        this.teacherView = view;
        teacherDao = TrungTamController.Instance().getTeacherFunc();

        view.addAddTeacherListener(new AddTeacherListener());
        view.addEditTeacherListener(new EditTeacherListener());
        view.addDeleteTeacherListener(new DeleteTeacherListener());
        view.addClearListener(new ClearTeacherListener());
        view.addQuanLyKhoaHoc(new QuanLyKhoaHoc());
        view.addSortTeacherGPAListener(new SortTeacherGPAListener());
        view.addSortTeacherNameListener(new SortTeacherNameListener());
        view.addListTeacherSelectionListener(new ListTeacherSelectionListener());
        view.addSearchListener(new SearchListener());
    }

    public void showTeacherView() {
        List<Teacher> teacherList = teacherDao.getListTeachers();
        teacherView.setVisible(true);
        teacherView.showListTeachers(teacherList);
    }

    class AddTeacherListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Teacher teacher = teacherView.getTeacherInfo();
            if (teacher != null) {
                teacherDao.add(teacher);
                teacherView.showTeacher(teacher);
                teacherView.showListTeachers(teacherDao.getListTeachers());
                teacherView.showMessage("Thêm thành công!");
            }
        }
    }

    class EditTeacherListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Teacher teacher = teacherView.getTeacherInfo();
            if ( teacher != null) {
                teacherDao.edit(teacher);
                teacherView.showTeacher(teacher);
                teacherView.showListTeachers(teacherDao.getListTeachers());
                teacherView.showMessage("Cập nhật thành công!");
            }
        }
    }

    class DeleteTeacherListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Teacher teacher = teacherView.getTeacherInfo();
            if ( teacher != null) {
                teacherDao.delete(teacher);
                teacherView.clearTeacherInfo();
                teacherView.showListTeachers(teacherDao.getListTeachers());
                teacherView.showMessage("Xóa thành công!");
            }
            // Xoa Student trong cac khoa hoc
            List<KhoaHoc> dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
            for(KhoaHoc kh : dsKH){
                if(kh.checkContainsTeacher(teacher)){
                    kh.removeTeacher(teacher);
                    TrungTamController.Instance().getKhoaHocFunc().edit(kh);
                }
            }
        }
    }
    
    class SearchListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            List<Teacher> dsTeacher = new ArrayList<>();
            Teacher teacher = teacherView.getInfoSearch();
            if(teacher.getName()==null&&teacher.getAddress()==null&&teacher.getDOB()==null){
                return;
            }
            for(Teacher st : teacherDao.getListTeachers()){
                if(teacher.getName()!=null && st.getName().contains(teacher.getName())){
                    dsTeacher.add(st);
                    continue;
                }
                if(teacher.getDOB()!=null&&st.getDOB().contains(teacher.getDOB())){
                    dsTeacher.add(st);
                    continue;
                }
                if(teacher.getAddress()!=null&&st.getAddress().contains(teacher.getAddress())){
                    dsTeacher.add(st);
                }
            }
            teacherView.showListTeachers(dsTeacher);
        }
    }
    
    class ClearTeacherListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            teacherView.showListTeachers(teacherDao.getListTeachers());
            teacherView.clearTeacherInfo();
        }
    }
    class QuanLyKhoaHoc implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            teacherView.OpenQuanLyKhoaHoc();
        }
    }
    class SortTeacherGPAListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            teacherDao.sortTeacherByID();
            teacherView.showListTeachers(teacherDao.getListTeachers());
        }
    }

    class SortTeacherNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            teacherDao.sortTeacherByName();
            teacherView.showListTeachers(teacherDao.getListTeachers());
        }
    }

    class ListTeacherSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            teacherView.fillTeacherFromSelectedRow();
        }
    }
}