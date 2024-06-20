package entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "teacher")
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private Calendar dob = Calendar.getInstance();
    private String address;
    /* trình độ giáo viên */
    private String trinhDo;

    public Teacher() {
    }

    public Teacher(int id, String name, String dob, String address, String trinhDo) throws ParseException {
        super();
        this.id = id;
        this.name = name;
        this.dob.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
        this.address = address;
        this.trinhDo = trinhDo;
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

    public void setDOB(String DOB) {
        try{
            this.dob.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(DOB));
        }catch(ParseException e){
            System.err.println(e);
        }
        
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

}
