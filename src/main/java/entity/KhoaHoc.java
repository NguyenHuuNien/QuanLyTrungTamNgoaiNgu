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
    private String ngonNgu;
    private String skill;
    private int thoiGianKhoaHoc;
    private double giaKhoaHoc;
    private String[] taiLieu;
    private List<Student> dsStudent;
    private List<Teacher> dsTeacher;

    public KhoaHoc() {
    }

    public KhoaHoc(int id, String tenKhoaHoc,String ngonNgu,String skill, int thoiGianKhoaHoc, double giaKhoaHoc, String[] taiLieu, List<Student> dsStudent, List<Teacher> dsTeacher) {
        this.id = id;
        this.tenKhoaHoc = tenKhoaHoc;
        this.thoiGianKhoaHoc = thoiGianKhoaHoc;
        this.ngonNgu = ngonNgu;
        this.skill = skill;
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

    public int getThoiGianKhoaHoc() {
        return this.thoiGianKhoaHoc;
    }

    public void setThoiGianKhoaHoc(int thoiGianKhoaHoc) {
        this.thoiGianKhoaHoc = thoiGianKhoaHoc;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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
