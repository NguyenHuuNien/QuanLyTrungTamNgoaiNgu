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
    private List<Student> dsStudent = new ArrayList<>();
    public Teacher() {
    }

    public Teacher(int id, String name, String dob, String address, String trinhDo){
        super(id,name,dob,address);
        this.trinhDo = trinhDo;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public List<Student> getDsStudent() {
        return dsStudent;
    }

    public void setDsStudent(List<Student> dsStudent) {
        this.dsStudent = dsStudent;
    }
    public void addStudent(Student student){
        this.dsStudent.add(student);
    }
    public void removeStudent(Student student){
        for(Student st : dsStudent){
            if(st.getId() == student.getId()){
                dsStudent.remove(st);
                break;
            }
        }
    }
    public boolean checkContainsStudent(Person per){
        for(int i=0;i<dsStudent.size();i++){
            if(per.getId()==dsStudent.get(i).getId()){
                return true;
            }
        }
        return false;
    }
}
