package entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public Student() {
    }

    public Student(int id, String name, String dob, String address){
        super(id,name,dob,address);
    }
    
//
//    public List<KhoaHoc> getDSKhoaHoc() {
//        return dsKhoaHoc;
//    }
//    public void setDSKhoaHoc(List<KhoaHoc> dsKH) {
//        this.dsKhoaHoc = dsKH;
//    }
//    public void addKhoaHoc(KhoaHoc kh){
//        this.dsKhoaHoc.add(kh);
//    }
//    public void removeKhoaHoc(KhoaHoc kh){
//        this.dsKhoaHoc.remove(kh);
//    }
}
