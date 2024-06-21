
package entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Serializable{
    private int id;
    private String name;
    private Calendar dob = Calendar.getInstance();
    private String address;
    public Person() {
    }

    public Person(int id, String name, String dob,String address) throws ParseException {
        this.id = id;
        this.name = name;
        this.dob.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
