
package entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "khoahoc")
@XmlAccessorType(XmlAccessType.FIELD)
public class KhoaHoc implements Serializable{
    private int id;
    private String tenKhoaHoc;
    private String thoiGianKhoaHoc;
    private double giaKhoaHoc;
    private String[] taiLieu;
    private List<Student> dsStudent;
    private List<Teacher> dsTeacher;

    public KhoaHoc() {
    }

    public KhoaHoc(int id, String tenKhoaHoc, String thoiGianKhoaHoc, double giaKhoaHoc, String[] taiLieu, List<Student> dsStudent, List<Teacher> dsTeacher) {
        this.id = id;
        this.tenKhoaHoc = tenKhoaHoc;
        this.thoiGianKhoaHoc = thoiGianKhoaHoc;
        this.giaKhoaHoc = giaKhoaHoc;
        this.taiLieu = taiLieu;
        this.dsStudent = dsStudent;
        this.dsTeacher = dsTeacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getThoiGianKhoaHoc() {
        return thoiGianKhoaHoc;
    }

    public void setThoiGianKhoaHoc(String thoiGianKhoaHoc) {
        this.thoiGianKhoaHoc = thoiGianKhoaHoc;
    }

    public double getGiaKhoaHoc() {
        return giaKhoaHoc;
    }

    public void setGiaKhoaHoc(double giaKhoaHoc) {
        this.giaKhoaHoc = giaKhoaHoc;
    }

    public String[] getTaiLieu() {
        return taiLieu;
    }

    public void setTaiLieu(String[] taiLieu) {
        this.taiLieu = taiLieu;
    }

    public List<Student> getDsStudent() {
        return dsStudent;
    }

    public void setDsStudent(List<Student> dsStudent) {
        this.dsStudent = dsStudent;
    }

    public List<Teacher> getDsTeacher() {
        return dsTeacher;
    }

    public void setDsTeacher(List<Teacher> dsTeacher) {
        this.dsTeacher = dsTeacher;
    }
    
}
