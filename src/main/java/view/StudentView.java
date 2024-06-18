package view;

import controller.TrungTamController;
import entity.KhoaHoc;
import entity.Student;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class StudentView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addStudentBtn;
    private JButton editStudentBtn;
    private JButton deleteStudentBtn;
    private JButton clearBtn;
    private JButton sortStudentGPABtn;
    private JButton sortStudentNameBtn;
    private JScrollPane jScrollPaneStudentTable;
    private JScrollPane jScrollPaneAddress;
    private JTable studentTable;
    
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel dobLabel;
    private JLabel addressLabel;
    private JLabel dsKhoaHocLabel;
    
    private JTextField idField;
    private JTextField nameField;
    private JTextField dobField;
    private JTextArea addressTA;
    private JList<String> dsKhoaHocField;
    private JScrollPane scrollPaneDSKhoaHoc = new JScrollPane();
    
    // định nghĩa các cột của bảng student
    private String [] columnNames = new String [] {
            "ID", "Name", "Age", "Address", "Courses"};
    // định nghĩa dữ liệu mặc định của bẳng student là rỗng
    private Object data = new Object [][] {};
    
    public StudentView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // khởi tạo các phím chức năng
        addStudentBtn = new JButton("Add");
        editStudentBtn = new JButton("Edit");
        deleteStudentBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        sortStudentGPABtn = new JButton("Sort By Age");
        sortStudentNameBtn = new JButton("Sort By Name");
        // khởi tạo bảng student
        jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();
        
        // khởi tạo các label
        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Name");
        dobLabel = new JLabel("DOB");
        addressLabel = new JLabel("Address");
        dsKhoaHocLabel = new JLabel("Courses");
        
        // khởi tạo các trường nhập dữ liệu cho student
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        dobField = new JTextField(6);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        dsKhoaHocField = new JList<>();
        scrollPaneDSKhoaHoc.setViewportView(dsKhoaHocField);
        scrollPaneDSKhoaHoc.setPreferredSize(new Dimension(170,115));
        // cài đặt các cột và data cho bảng student
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension (480, 300));
        
         // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneStudentTable);
        
        panel.add(addStudentBtn);
        panel.add(editStudentBtn);
        panel.add(deleteStudentBtn);
        panel.add(clearBtn);
        panel.add(sortStudentGPABtn);
        panel.add(sortStudentNameBtn);
        
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(dobLabel);
        panel.add(addressLabel);
        panel.add(dsKhoaHocLabel);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(dobField);
        panel.add(jScrollPaneAddress);
        panel.add(scrollPaneDSKhoaHoc);
        
        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dobLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dobLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dsKhoaHocLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dsKhoaHocLabel, 200, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dobField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dobField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, scrollPaneDSKhoaHoc, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, scrollPaneDSKhoaHoc, 200, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addStudentBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addStudentBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editStudentBtn, 60, SpringLayout.WEST, addStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, editStudentBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteStudentBtn, 60, SpringLayout.WEST, editStudentBtn);
        
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteStudentBtn);
        
        layout.putConstraint(SpringLayout.NORTH, deleteStudentBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortStudentGPABtn, 500, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortStudentGPABtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortStudentNameBtn, 115, SpringLayout.WEST, sortStudentGPABtn);
        layout.putConstraint(SpringLayout.NORTH, sortStudentNameBtn, 330, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        this.setTitle("Student Information");
        this.setSize(800, 420);
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    /**
     * hiển thị list student vào bảng studentTable
     * 
     * @param list
     */
    public void showListStudents(List<Student> list) {
        int size = list.size();
        // với bảng studentTable có 5 cột, 
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student 
        // số cột: là 5
        Object [][] students = new Object[size][5];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getId();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getAge();
            students[i][3] = list.get(i).getAddress();
            students[i][4] = list.get(i).getStringDSKhoaHoc();
        }
        studentTable.setModel(new DefaultTableModel(students, columnNames));
    }
    
    /**
     * điền thông tin của hàng được chọn từ bảng student 
     * vào các trường tương ứng của student.
     */
    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = studentTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(studentTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(studentTable.getModel().getValueAt(row, 1).toString());
            dobField.setText(TrungTamController.Instance().getStudentFunc().getListStudents().get(Integer.parseInt(idField.getText())-1).getDOB());
            addressTA.setText(studentTable.getModel().getValueAt(row, 3).toString());
            // Create array string - add data to dsKhoaHocField
            String ss = studentTable.getModel().getValueAt(row, 4).toString();
            String[] arrS = ss.split("\n");
            dsKhoaHocField = new JList<String>(arrS);
            // enable Edit and Delete buttons
            editStudentBtn.setEnabled(true);
            deleteStudentBtn.setEnabled(true);
            // disable Add button
            addStudentBtn.setEnabled(false);
        }
    }

    /**
     * xóa thông tin student
     */
    public void clearStudentInfo() {
        idField.setText("");
        nameField.setText("");
        dobField.setText("");
        addressTA.setText("");
        dsKhoaHocField.clearSelection();
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }
    
    /**
     * hiện thị thông tin student
     * 
     * @param student
     */
    public void showStudent(Student student) {
        idField.setText("" + student.getId());
        nameField.setText(student.getName());
        dobField.setText("" + student.getDOB());
        addressTA.setText(student.getAddress());
        dsKhoaHocField = new JList<String>(student.getDSKhoaHoc().toArray(new String[0]));
        // enable Edit and Delete buttons
        editStudentBtn.setEnabled(true);
        deleteStudentBtn.setEnabled(true);
        // disable Add button
        addStudentBtn.setEnabled(false);
    }
    
    /**
     * lấy thông tin student
     * 
     * @return
     */
    public Student getStudentInfo() {
        // validate student
        if (!validateName() || !validateDOB() || !validateAddress() || !validateDSKhoaHoc()) {
            return null;
        }
        try {
            Student student = new Student();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                student.setId(Integer.parseInt(idField.getText()));
            }
            student.setName(nameField.getText().trim());
            student.setDOB(formatterDate(dobField.getText()));
            student.setAddress(addressTA.getText().trim());
            // set danh sach khoa hoc cho hoc sinh
            List<KhoaHoc> dsKH_this_Student = new ArrayList<>();
            // Sử dụng singleton để lấy danh sách khóa học
            List<KhoaHoc> dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
            for(int i = 0;i<dsKhoaHocField.getModel().getSize();i++){
                KhoaHoc flag = null;
                for(int j = 0;j<dsKH.size();j++){
                    if(dsKhoaHocField.getModel().getElementAt(i).equals(dsKH.get(i).getTenKhoaHoc())){
                        flag = dsKH.get(i);
                        break;
                    }
                }
                if(flag!=null)
                    dsKH_this_Student.add(flag);
            }
            student.setDSKhoaHoc(dsKH_this_Student);
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    private String formatterDate(String inputDate) {
        List<String> dateFormats = Arrays.asList("d/M/yyyy", "dd/M/yyyy", "d/MM/yyyy", "dd/MM/yyyy");
        LocalDate date = null;
        for (String format : dateFormats) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                date = LocalDate.parse(inputDate, formatter);
                if (date != null) {
                    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    return date.format(outputFormatter);
                }
            } catch (Exception exception) {
            }
        }
        return null;
    }

        
    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Name không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateAddress() {
        String address = addressTA.getText();
        if (address == null || "".equals(address.trim())) {
            addressTA.requestFocus();
            showMessage("Address không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateDOB() {
        try {
            String txtDOB = dobField.getText();
            List<String> dateFormats = Arrays.asList("d/M/yyyy", "dd/M/yyyy", "d/MM/yyyy", "dd/MM/yyyy");
            boolean validate = false;
            for(String o : dateFormats){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(o);
                try {
                    LocalDate.parse(txtDOB, formatter);
                    validate = true;
                    break;
                } catch (Exception exception) {
                }
            }
            if(!validate){
                dobField.requestFocus();
                showMessage("Ngày/Tháng/Năm sinh không hợp lệ!");
                return false;
            }
        } catch (Exception e) {
            dobField.requestFocus();
            showMessage("Ngày/Tháng/Năm sinh không hợp lệ!");
            return false;
        }
        return true;
    }
    
    private boolean validateDSKhoaHoc() {
        try {
            
        } catch (Exception e) {
            showMessage("GPA không hợp lệ!");
            return false;
        }
        return true;
    }
    
    public void actionPerformed(ActionEvent e) {
    }
    
    public void valueChanged(ListSelectionEvent e) {
    }
    
    public void addAddStudentListener(ActionListener listener) {
        addStudentBtn.addActionListener(listener);
    }
    
    public void addEdiStudentListener(ActionListener listener) {
        editStudentBtn.addActionListener(listener);
    }
    
    public void addDeleteStudentListener(ActionListener listener) {
        deleteStudentBtn.addActionListener(listener);
    }
    
    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
    
    public void addSortStudentAgeListener(ActionListener listener) {
        sortStudentGPABtn.addActionListener(listener);
    }
    
    public void addSortStudentNameListener(ActionListener listener) {
        sortStudentNameBtn.addActionListener(listener);
    }
    
    public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }
}
