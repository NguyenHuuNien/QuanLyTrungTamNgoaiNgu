package entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<KhoaHoc> dsKhoaHoc;

    public Student() {
    }

    public Student(int id, String name, String dob, String address, List<KhoaHoc> dsKhoaHoc){
        super(id,name,dob,address,"SV");
        this.dsKhoaHoc = dsKhoaHoc;
    }

    public List<KhoaHoc> getDSKhoaHoc() {
        return dsKhoaHoc;
    }
    public String getStringDSKhoaHoc(){
        String s = "";
        if(dsKhoaHoc!=null){
            for (KhoaHoc o : dsKhoaHoc){
                s += o.getTenKhoaHoc();
                s+="\n";
            }
        }
        return s;
    }
    public void setDSKhoaHoc(List<KhoaHoc> dsKH) {
        this.dsKhoaHoc = dsKH;
    }
    public void addKhoaHoc(KhoaHoc kh){
        this.dsKhoaHoc.add(kh);
    }
    public void removeKhoaHoc(KhoaHoc kh){
        this.dsKhoaHoc.remove(kh);
    }
}
