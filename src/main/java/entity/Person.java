
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
    private Calendar dob= Calendar.getInstance();
    private String address;
    private int numKhoaHoc;
    public Person() {
    }

    public Person(int id, String name, String dob,String address){
        this.id = id;
        this.name = name;
        try{
            this.dob.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dob));    
        }catch(Exception e){
            System.err.println(e);
        }
        this.address = address;
        this.numKhoaHoc = 0;
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
        if(dob==null)
            return null;
        return new SimpleDateFormat("dd/MM/yyyy").format(this.dob.getTime());
    }

    public void setDOB(String dob){
        if(dob==null){
            return;
        }
        try{
            this.dob.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
        }catch (ParseException e){
            System.err.println(e);
        }
    }
    public int getNumKhoaHoc() {
        return numKhoaHoc;
    }

    public void setNumKhoaHoc(int x) {
        this.numKhoaHoc += x;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", numKhoaHoc=" + numKhoaHoc + '}';
    }
    
}
