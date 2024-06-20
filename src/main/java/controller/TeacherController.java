package controller;

import entity.Teacher;
import func.TeacherFunc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        view.addSortTeacherGPAListener(new SortTeacherGPAListener());
        view.addSortTeacherNameListener(new SortTeacherNameListener());
        view.addListTeacherSelectionListener(new ListTeacherSelectionListener());
    }

    public void showTeacherView() {
        List<Teacher> teacherList = teacherDao.getListTeachers();
        teacherView.setVisible(true);
        teacherView.showListTeachers(teacherList);
    }

    /**get
     * Lớp AddTeacherListener 
     * chứa cài đặt cho sự kiện click button "Add"
     * 
     * @author viettuts.vn
     */
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

    /**
     * Lớp EditTeacherListener 
     * chứa cài đặt cho sự kiện click button "Edit"
     * 
     * @author viettuts.vn
     */
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

    /**
     * Lớp DeleteTeacherListener 
     * chứa cài đặt cho sự kiện click button "Delete"
     * 
     * @author viettuts.vn
     */
    class DeleteTeacherListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Teacher teacher = teacherView.getTeacherInfo();
            if ( teacher != null) {
                teacherDao.delete(teacher);
                teacherView.clearTeacherInfo();
                teacherView.showListTeachers(teacherDao.getListTeachers());
                teacherView.showMessage("Xóa thành công!");
            }
        }
    }

    /**
     * Lớp ClearTeacherListener 
     * chứa cài đặt cho sự kiện click button "Clear"
     * 
     * @author viettuts.vn
     */
    class ClearTeacherListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            teacherView.clearTeacherInfo();
        }
    }

    /**
     * Lớp SortTeacherGPAListener 
     * chứa cài đặt cho sự kiện click button "Sort By GPA"
     * 
     * @author viettuts.vn
     */
    class SortTeacherGPAListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            teacherDao.sortTeacherByID();
            teacherView.showListTeachers(teacherDao.getListTeachers());
        }
    }

    /**
     * Lớp SortTeacherGPAListener 
     * chứa cài đặt cho sự kiện click button "Sort By Name"
     * 
     * @author viettuts.vn
     */
    class SortTeacherNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            teacherDao.sortTeacherByName();
            teacherView.showListTeachers(teacherDao.getListTeachers());
        }
    }

    /**
     * Lớp ListTeacherSelectionListener 
     * chứa cài đặt cho sự kiện chọn teacher trong bảng Teacher
     * 
     * @author viettuts.vn
     */
    class ListTeacherSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            teacherView.fillTeacherFromSelectedRow();
        }
    }
}