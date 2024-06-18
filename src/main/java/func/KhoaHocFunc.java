package func;

import entity.KhoaHoc;
import entity.KhoaHocXML;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KhoaHocFunc {
    private static final String KHOA_HOC_FILE_NAME = "src/khoahoc.xml";
    private List<KhoaHoc> listKhoaHoc;

    public KhoaHocFunc() {
        this.listKhoaHoc = readListKhoaHoc();
    }

    /**
     * Lưu danh sách các khóa học vào file khoahoc.xml
     *
     * @param khoaHocList Danh sách các khóa học
     */
    public void writeListKhoaHoc(List<KhoaHoc> khoaHocList) {
        KhoaHocXML khoaHocXML = new KhoaHocXML();
        khoaHocXML.setKhoaHoc(khoaHocList);
        FileUtils.writeXMLtoFile(KHOA_HOC_FILE_NAME, khoaHocXML);
    }

    /**
     * Đọc danh sách các khóa học từ file khoahoc.xml
     *
     * @return Danh sách các khóa học
     */
    public List<KhoaHoc> readListKhoaHoc() {
        List<KhoaHoc> list = new ArrayList<>();
        KhoaHocXML khoaHocXML = (KhoaHocXML) FileUtils.readXMLFile(KHOA_HOC_FILE_NAME, KhoaHocXML.class);
        if (khoaHocXML != null) {
            list = khoaHocXML.getKhoaHoc();
        }
        return list;
    }

    /**
     * Thêm một khóa học vào danh sách và lưu danh sách vào file
     *
     * @param khoaHoc Khóa học cần thêm
     */
    public void add(KhoaHoc khoaHoc) {
        int id = (listKhoaHoc.size() > 0) ? (listKhoaHoc.size() + 1) : 1;
        khoaHoc.setId(id);
        listKhoaHoc.add(khoaHoc);
        writeListKhoaHoc(listKhoaHoc);
    }

    /**
     * Cập nhật thông tin một khóa học trong danh sách và lưu danh sách vào file
     *
     * @param khoaHoc Khóa học cần cập nhật
     */
    public void edit(KhoaHoc khoaHoc) {
        for (KhoaHoc kh : listKhoaHoc) {
            if (kh.getId() == khoaHoc.getId()) {
                kh.setTenKhoaHoc(khoaHoc.getTenKhoaHoc());
                kh.setThoiGianKhoaHoc(khoaHoc.getThoiGianKhoaHoc());
                kh.setGiaKhoaHoc(khoaHoc.getGiaKhoaHoc());
                kh.setTaiLieu(khoaHoc.getTaiLieu());
                kh.setDsStudent(khoaHoc.getDsStudent());
                kh.setDsTeacher(khoaHoc.getDsTeacher());
                break;
            }
        }
        writeListKhoaHoc(listKhoaHoc);
    }

    /**
     * Xóa một khóa học từ danh sách và lưu danh sách vào file
     *
     * @param khoaHoc Khóa học cần xóa
     * @return true nếu xóa thành công, ngược lại là false
     */
    public boolean delete(KhoaHoc khoaHoc) {
        boolean isFound = false;
        int size = listKhoaHoc.size();
        for (int i = 0; i < size; i++) {
            if (listKhoaHoc.get(i).getId() == khoaHoc.getId()) {
                khoaHoc = listKhoaHoc.get(i);
                listKhoaHoc.remove(khoaHoc);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            writeListKhoaHoc(listKhoaHoc);
        }
        return isFound;
    }
 


    /**
     * Sắp xếp danh sách khóa học theo tên theo thứ tự tăng dần
     */
    public void sortKhoaHocByName() {
        Collections.sort(listKhoaHoc, new Comparator<KhoaHoc>() {
            public int compare(KhoaHoc kh1, KhoaHoc kh2) {
                return kh1.getTenKhoaHoc().compareTo(kh2.getTenKhoaHoc());
            }
        });
    }

    /**
     * Sắp xếp danh sách khóa học theo thời gian theo thứ tự tăng dần
     */
    public void sortKhoaHocByTime() {
        Collections.sort(listKhoaHoc, new Comparator<KhoaHoc>() {
            public int compare(KhoaHoc kh1, KhoaHoc kh2) {
                return kh1.getThoiGianKhoaHoc().compareTo(kh2.getThoiGianKhoaHoc());
            }
        });
    }


    public List<KhoaHoc> getListKhoaHoc() {
        return listKhoaHoc;
    }

    public void setListKhoaHoc(List<KhoaHoc> listKhoaHoc) {
        this.listKhoaHoc = listKhoaHoc;
    }
}
