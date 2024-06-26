package controller;

import entity.KhoaHoc;
import func.KhoaHocFunc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.KhoaHocView;

public class KhoaHocController {
    private KhoaHocFunc khoaHocDao;
    private KhoaHocView khoaHocView;

    public KhoaHocController(KhoaHocView view) {
        this.khoaHocView = view;
        khoaHocDao = TrungTamController.Instance().getKhoaHocFunc();

        view.addAddKhoaHocListener(new AddKhoaHocListener());
        view.addEditKhoaHocListener(new EditKhoaHocListener());
        view.addDeleteKhoaHocListener(new DeleteKhoaHocListener());
        view.addClearListener(new ClearKhoaHocListener());
        view.addSortKhoaHocGPAListener(new SortKhoaHocGPAListener());
        view.addSortKhoaHocNameListener(new SortKhoaHocNameListener());
        view.addListKhoaHocSelectionListener(new ListKhoaHocSelectionListener());
    }

    public void showKhoaHocView() {
        List<KhoaHoc> khoaHocList = khoaHocDao.getListKhoaHocs();
        khoaHocView.setVisible(true);
        khoaHocView.showListKhoaHocs(khoaHocList);
    }

    class AddKhoaHocListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            KhoaHoc khoaHoc = khoaHocView.getKhoaHocInfo();
            if (khoaHoc != null) {
                khoaHocDao.add(khoaHoc);
                khoaHocView.showKhoaHoc(khoaHoc);
                khoaHocView.showListKhoaHocs(khoaHocDao.getListKhoaHocs());
                khoaHocView.showMessage("Thêm thành công!");
            }
        }
    }

    class EditKhoaHocListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            KhoaHoc khoaHoc = khoaHocView.getKhoaHocInfo();
            if (khoaHoc != null) {
                khoaHocDao.edit(khoaHoc);
                khoaHocView.showKhoaHoc(khoaHoc);
                khoaHocView.showListKhoaHocs(khoaHocDao.getListKhoaHocs());
                khoaHocView.showMessage("Cập nhật thành công!");
            }
        }
    }

    class DeleteKhoaHocListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            KhoaHoc khoaHoc = khoaHocView.getKhoaHocInfo();
            if (khoaHoc != null) {
                khoaHocDao.delete(khoaHoc);
                khoaHocView.clearKhoaHocInfo();
                khoaHocView.showListKhoaHocs(khoaHocDao.getListKhoaHocs());
                khoaHocView.showMessage("Xóa thành công!");
            }
        }
    }

    class ClearKhoaHocListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            khoaHocView.clearKhoaHocInfo();
        }
    }

    class SortKhoaHocGPAListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            khoaHocDao.sortKhoaHocByID();
            khoaHocView.showListKhoaHocs(khoaHocDao.getListKhoaHocs());
        }
    }

    class SortKhoaHocNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            khoaHocDao.sortKhoaHocByName();
            khoaHocView.showListKhoaHocs(khoaHocDao.getListKhoaHocs());
        }
    }

    class ListKhoaHocSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            khoaHocView.fillKhoaHocFromSelectedRow();
        }
    }
}
