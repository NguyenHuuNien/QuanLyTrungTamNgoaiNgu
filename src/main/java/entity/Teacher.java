package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "teacher")
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    /* trình độ giáo viên */
    private String trinhDo;
    private List<KhoaHoc> dsKH = new ArrayList<>();
    public Teacher() {
    }

    public Teacher(int id, String name, String dob, String address, String trinhDo){
        super(id,name,dob,address,"GV");
        this.trinhDo = trinhDo;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }
    public void addKhoaHoc(KhoaHoc kh){
        dsKH.add(kh);
    }
}
