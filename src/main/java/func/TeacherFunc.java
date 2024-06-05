package func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.Teacher;
import entity.TeacherXML;
import utils.FileUtils;

/**
 * TeacherFunc class
 * 
 * @author viettuts.vn
 */
public class TeacherFunc {
    private static final String TEACHER_FILE_NAME = "src/teacher.xml";
    private List<Teacher> listTeachers;

    public TeacherFunc() {
        this.listTeachers = readListTeachers();
    }

    /**
     * Lưu các đối tượng teacher vào file teacher.xml
     * 
     * @param teachers
     */
    public void writeListTeachers(List<Teacher> teachers) {
        TeacherXML teacherXML = new TeacherXML();
        teacherXML.setTeacher(teachers);
        FileUtils.writeXMLtoFile(TEACHER_FILE_NAME, teacherXML);
    }

    /**
     * Đọc các đối tượng teacher từ file teacher.xml
     * 
     * @return list teacher
     */
    public List<Teacher> readListTeachers() {
        List<Teacher> list = new ArrayList<Teacher>();

        TeacherXML teacherXML = (TeacherXML) FileUtils.readXMLFile(
                TEACHER_FILE_NAME, TeacherXML.class);
        if (teacherXML != null) {
            list = teacherXML.getTeacher();
        }
        return list;
    }
    

    /**
     * thêm teacher vào listTeachers và lưu listTeachers vào file
     * 
     * @param teacher
     */
    public void add(Teacher teacher) {
        int id = (listTeachers.size() > 0) ? (listTeachers.size() + 1) : 1;
        teacher.setId(id);
        listTeachers.add(teacher);
        writeListTeachers(listTeachers);
    }

    /**
     * cập nhật teacher vào listTeachers và lưu listTeachers vào file
     * 
     * @param teacher
     */
    public void edit(Teacher teacher) {
        int size = listTeachers.size();
        for (int i = 0; i < size; i++) {
            if (listTeachers.get(i).getId() == teacher.getId()) {
                listTeachers.get(i).setName(teacher.getName());
                listTeachers.get(i).setAge(teacher.getAge());
                listTeachers.get(i).setAddress(teacher.getAddress());
                listTeachers.get(i).setTrinhDo(teacher.getTrinhDo());
                writeListTeachers(listTeachers);
                break;
            }
        }
    }

    /**
     * xóa teacher từ listTeachers và lưu listTeachers vào file
     * 
     * @param teacher
     */
    public boolean delete(Teacher teacher) {
        boolean isFound = false;
        int size = listTeachers.size();
        for (int i = 0; i < size; i++) {
            if (listTeachers.get(i).getId() == teacher.getId()) {
                teacher = listTeachers.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listTeachers.remove(teacher);
            writeListTeachers(listTeachers);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách teacher theo name theo tứ tự tăng dần
     */
    public void sortTeacherByName() {
        Collections.sort(listTeachers, new Comparator<Teacher>() {
            public int compare(Teacher teacher1, Teacher teacher2) {
                return teacher1.getName().compareTo(teacher2.getName());
            }
        });
    }

    /**
     * sắp xếp danh sách teacher theo GPA theo tứ tự tăng dần
     */
    public void sortTeacherByAge() {
        Collections.sort(listTeachers, new Comparator<Teacher>() {
            public int compare(Teacher teacher1, Teacher teacher2) {
                if (teacher1.getAge()> teacher2.getAge()) {
                    return 1;
                }
                return -1;
            }
        });
    }

    public List<Teacher> getListTeachers() {
        return listTeachers;
    }

    public void setListTeachers(List<Teacher> listTeachers) {
        this.listTeachers = listTeachers;
    }
}
