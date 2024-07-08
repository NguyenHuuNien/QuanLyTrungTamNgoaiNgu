package func;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import controller.TrungTamController;
import entity.KhoaHoc;
import entity.Student;
import entity.StudentXML;
import entity.Teacher;
import utils.FileUtils;

/**
 * StudentFunc class
 * 
 * @author viettuts.vn
 */
public class StudentFunc {
    private static final String STUDENT_FILE_NAME = "student.xml";
    private List<Student> listStudents;

    public StudentFunc() {
        this.listStudents = readListStudents();
    }

    /**
     * Lưu các đối tượng student vào file student.xml
     * 
     * @param students
     */
    public void writeListStudents(List<Student> students) {
        StudentXML studentXML = new StudentXML();
        studentXML.setStudent(students);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, studentXML);
    }

    /**
     * Đọc các đối tượng student từ file student.xml
     * 
     * @return list student
     */
    public List<Student> readListStudents() {
        List<Student> list = new ArrayList<Student>();
        StudentXML studentXML = (StudentXML) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, StudentXML.class);
        if (studentXML != null) {
            list = studentXML.getStudent();
        }
        return list;
    }
    

    /**
     * thêm student vào listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    private int pullID(){
        for(int i=0;i<listStudents.size()-1;i++){
            if(listStudents.get(i).getId()+1!=listStudents.get(i+1).getId()){
                return listStudents.get(i).getId()+1;
            }
        }
        return listStudents.isEmpty()?1:listStudents.get(listStudents.size()-1).getId()+1;
    }
    public void add(Student student) {
        int id = pullID();
        student.setId(id);
        listStudents.add(student);
        listStudents.sort(Comparator.comparingInt(Student::getId));
        writeListStudents(listStudents);
    }

    /**
     * cập nhật student vào listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    public void edit(Student student) {
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                listStudents.get(i).setName(student.getName());
                listStudents.get(i).setDOB(student.getDOB());
                listStudents.get(i).setAddress(student.getAddress());
                writeListStudents(listStudents);
                for(KhoaHoc kh : TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc()){
                    if(kh.checkContainsStudent(listStudents.get(i))){
                        kh.removeStudent(listStudents.get(i));
                        kh.addStudent(listStudents.get(i));
                        TrungTamController.Instance().getKhoaHocFunc().edit(kh);
                    }
                }
                for(Teacher tc : TrungTamController.Instance().getTeacherFunc().getListTeachers()){
                    if(tc.checkContainsStudent(listStudents.get(i))){
                        tc.removeStudent(listStudents.get(i));
                        tc.addStudent(listStudents.get(i));
                        TrungTamController.Instance().getTeacherFunc().edit(tc);
                    }
                }
                break;
            }
        }
    }

    /**
     * xóa student từ listStudents và lưu listStudents vào file
     * 
     * @param student
     */
        public boolean delete(Student student) {
            boolean isFound = false;
            int size = listStudents.size();
            for (int i = 0; i < size; i++) {
                if (listStudents.get(i).getId() == student.getId()) {
                    student = listStudents.get(i);
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                listStudents.remove(student);
                writeListStudents(listStudents);
                for(KhoaHoc kh : TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc()){
                    if(kh.checkContainsStudent(student)){
                        kh.removeStudent(student);
                        TrungTamController.Instance().getKhoaHocFunc().edit(kh);
                    }
                }
                for(Teacher tc : TrungTamController.Instance().getTeacherFunc().getListTeachers()){
                    if(tc.checkContainsStudent(student)){
                        tc.removeStudent(student);
                        TrungTamController.Instance().getTeacherFunc().edit(tc);
                    }
                }
                return true;
            }
            return false;
        }

    /**
     * sắp xếp danh sách student theo name theo tứ tự tăng dần
     */
    public void sortStudentByName() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });
    }

    /**
     * sắp xếp danh sách student theo GPA theo tứ tự tăng dần
     */
    public void sortStudentByID() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                if(student1.getId()>student2.getId()){
                    return 1;
                }
                return -1;
            }
        });
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }
}