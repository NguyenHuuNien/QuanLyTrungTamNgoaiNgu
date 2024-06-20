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
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private Calendar dob = Calendar.getInstance();
    private String address;
    private List<KhoaHoc> dsKhoaHoc;

    public Student() {
    }

    public Student(int id, String name, String dob, String address, List<KhoaHoc> dsKhoaHoc) throws ParseException {
        super();
        this.id = id;
        this.name = name;
        this.dob.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
        this.address = address;
        this.dsKhoaHoc = dsKhoaHoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.dob.getTime());
    }

    public void setDOB(String dob){
        try{
            this.dob.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
        }catch (ParseException e){
            System.err.println(e);
        }
        
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
