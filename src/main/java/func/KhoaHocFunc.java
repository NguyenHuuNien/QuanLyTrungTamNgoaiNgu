package func;

import entity.KhoaHoc;
import entity.KhoaHocXML;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KhoaHocFunc {
    private static final String KHOA_HOC_FILE_NAME = "khoahoc.xml";
    private List<KhoaHoc> listKhoaHoc;

    public KhoaHocFunc() {
        this.listKhoaHoc = readListKhoaHoc();
    }

    public void writeListKhoaHoc(List<KhoaHoc> khoaHocList) {
        KhoaHocXML khoaHocXML = new KhoaHocXML();
        khoaHocXML.setKhoaHoc(khoaHocList);
        FileUtils.writeXMLtoFile(KHOA_HOC_FILE_NAME, khoaHocXML);
    }

    public List<KhoaHoc> readListKhoaHoc() {
        KhoaHocXML khoaHocXML = (KhoaHocXML) FileUtils.readXMLFile(KHOA_HOC_FILE_NAME, KhoaHocXML.class);
        if (khoaHocXML != null && khoaHocXML.getKhoaHoc() != null) {
            return khoaHocXML.getKhoaHoc();
        }
        return new ArrayList<>();
    }

    private int pullID(){
        for(int i=0;i<listKhoaHoc.size()-1;i++){
            if(listKhoaHoc.get(i).getId()+1!=listKhoaHoc.get(i+1).getId()){
                return listKhoaHoc.get(i).getId()+1;
            }
        }
        return listKhoaHoc.isEmpty()?1:listKhoaHoc.get(listKhoaHoc.size()-1).getId()+1;
    }
    public void add(KhoaHoc khoaHoc) {
        int id = pullID();
        khoaHoc.setId(id);
        listKhoaHoc.add(khoaHoc);
        listKhoaHoc.sort(Comparator.comparingInt(KhoaHoc::getId));
        writeListKhoaHoc(listKhoaHoc);
    }

    public void edit(KhoaHoc khoaHoc) {
        for (KhoaHoc kh : listKhoaHoc) {
            if (kh.getId() == khoaHoc.getId()) {
                kh.setTenKhoaHoc(khoaHoc.getTenKhoaHoc());
                kh.setThoiGianKhoaHoc(khoaHoc.getThoiGianKhoaHoc());
                kh.setGiaKhoaHoc(khoaHoc.getGiaKhoaHoc());
                kh.setDsStudent(khoaHoc.getDsStudent());
                kh.setDsTeacher(khoaHoc.getDsTeacher());
                break;
            }
        }
        writeListKhoaHoc(listKhoaHoc);
    }

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

    public void sortKhoaHocByID() {
        Collections.sort(listKhoaHoc, new Comparator<KhoaHoc>() {
            public int compare(KhoaHoc kh1, KhoaHoc kh2) {
                if(kh1.getId() > kh2.getId()){
                    return 1;
                }
                return -1;
            }
        });
    }

    public void sortKhoaHocByGia() {
        Collections.sort(listKhoaHoc, new Comparator<KhoaHoc>() {
            public int compare(KhoaHoc kh1, KhoaHoc kh2) {
                if(kh1.getGiaKhoaHoc()>kh2.getGiaKhoaHoc()){
                    return 1;
                }
                return -1;
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
