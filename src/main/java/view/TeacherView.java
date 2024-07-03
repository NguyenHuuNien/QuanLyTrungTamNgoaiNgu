package view;

import controller.TrungTamController;
import entity.Student;
import entity.Teacher;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TeacherView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addTeacherBtn;
    private JButton editTeacherBtn;
    private JButton deleteTeacherBtn;
    private JButton clearBtn;
    private JButton sortTeacherAgeBtn;
    private JButton sortTeacherNameBtn;
    private JButton courseBtn;
    private JButton searchBtn;
    private JScrollPane jScrollPaneTeacherTable;
    private JScrollPane jScrollPaneAddress;
    private JTable teacherTable;
    
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel dobLabel;
    private JLabel addressLabel;
    private JLabel academicLabel;
    private JLabel courseLabel;
    
    private JTextField idField;
    private JTextField nameField;
    private JTextField dobField;
    private JTextArea addressTA;
    private JComboBox<String> capBacField;
    
    // định nghĩa các cột của bảng teacher
    private String [] columnNames = new String [] {
            "ID", "Họ tên", "Ngày sinh", "Địa chỉ", "Trình độ","Khóa học"};
    // định nghĩa dữ liệu mặc định của bẳng teacher là rỗng
    private Object data = new Object [][] {};
    
    public TeacherView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // khởi tạo các phím chức năng
        addTeacherBtn = new JButton("Thêm");
        editTeacherBtn = new JButton("Sửa");
        deleteTeacherBtn = new JButton("Xóa");
        clearBtn = new JButton("Làm mới");
        sortTeacherAgeBtn = new JButton("Sắp xếp theo ID");
        sortTeacherNameBtn = new JButton("Sắp xếp theo Tên");
        courseBtn = new JButton("Quản lý các khóa học");
        searchBtn = new JButton("Tìm kiếm");
        // khởi tạo bảng teacher
        jScrollPaneTeacherTable = new JScrollPane();
        teacherTable = new JTable();
        
        // khởi tạo các label
        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Tên");
        dobLabel = new JLabel("Ngày sinh");
        addressLabel = new JLabel("Địa chỉ");
        academicLabel = new JLabel("Trình độ");
        courseLabel = new JLabel("Khóa học");
        // khởi tạo các trường nhập dữ liệu cho teacher
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        dobField = new JTextField(8);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(3);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        
        String[] arrCapBac = new String[]{"Khác","Trợ giảng", "Giảng viên", "Thạc sĩ", "Phó giáo sư", "Giáo sư", "Tiến sĩ"};

        capBacField  = new JComboBox<>(arrCapBac);
        capBacField.setBounds(150, 50, 200, 20);
        capBacField.setSelectedIndex(0);
        // cài đặt các cột và data cho bảng teacher
        teacherTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneTeacherTable.setViewportView(teacherTable);
        jScrollPaneTeacherTable.setPreferredSize(new Dimension (480, 300));
        
         // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Teacher
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneTeacherTable);
        
        panel.add(addTeacherBtn);
        panel.add(editTeacherBtn);
        panel.add(deleteTeacherBtn);
        panel.add(clearBtn);
        panel.add(sortTeacherAgeBtn);
        panel.add(sortTeacherNameBtn);
        panel.add(courseBtn);
        panel.add(searchBtn);
        
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(dobLabel);
        panel.add(addressLabel);
        panel.add(academicLabel);
        panel.add(courseLabel);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(dobField);
        panel.add(jScrollPaneAddress);
        panel.add(capBacField);
        
        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dobLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dobLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, academicLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, academicLabel, 170, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, courseLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, courseLabel, 210, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dobField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dobField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, capBacField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, capBacField, 170, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, courseBtn, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, courseBtn, 210, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, jScrollPaneTeacherTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneTeacherTable, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addTeacherBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addTeacherBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editTeacherBtn, 80, SpringLayout.WEST, addTeacherBtn);
        layout.putConstraint(SpringLayout.NORTH, editTeacherBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteTeacherBtn, 70, SpringLayout.WEST, editTeacherBtn);
        
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 70, SpringLayout.WEST, deleteTeacherBtn);
        layout.putConstraint(SpringLayout.NORTH, searchBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchBtn, 100, SpringLayout.WEST, clearBtn);
        
        layout.putConstraint(SpringLayout.NORTH, deleteTeacherBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortTeacherAgeBtn, 500, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortTeacherAgeBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortTeacherNameBtn, 140, SpringLayout.WEST, sortTeacherAgeBtn);
        layout.putConstraint(SpringLayout.NORTH, sortTeacherNameBtn, 330, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        this.setTitle("Teacher Information");
        this.setSize(800, 420);
        // disable Edit and Delete buttons
        editTeacherBtn.setEnabled(false);
        deleteTeacherBtn.setEnabled(false);
        courseBtn.setEnabled(false);
        // enable Add button
        addTeacherBtn.setEnabled(true);
        searchBtn.setEnabled(true);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public void showListTeachers(List<Teacher> list) {
        int size = list.size();
        Object [][] teachers = new Object[size][6];
        for (int i = 0; i < size; i++) {
            teachers[i][0] = list.get(i).getId();
            teachers[i][1] = list.get(i).getName();
            teachers[i][2] = list.get(i).getDOB();
            teachers[i][3] = list.get(i).getAddress();
            teachers[i][4] = list.get(i).getTrinhDo();
            teachers[i][5] = "+"+list.get(i).getNumKhoaHoc();
        }
        teacherTable.setModel(new DefaultTableModel(teachers, columnNames));
    }
    
    public void fillTeacherFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = teacherTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(teacherTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(teacherTable.getModel().getValueAt(row, 1).toString());
            dobField.setText(teacherTable.getModel().getValueAt(row, 2).toString());
            addressTA.setText(teacherTable.getModel().getValueAt(row, 3).toString());
            capBacField.setSelectedItem(teacherTable.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            editTeacherBtn.setEnabled(true);
            deleteTeacherBtn.setEnabled(true);
            courseBtn.setEnabled(true);
            // disable Add button
            addTeacherBtn.setEnabled(false);
            searchBtn.setEnabled(false);
        }
    }

    /**
     * xóa thông tin teacher
     */
    public void clearTeacherInfo() {
        idField.setText("");
        nameField.setText("");
        dobField.setText("");
        addressTA.setText("");
        capBacField.setSelectedIndex(0);
        // disable Edit and Delete buttons
        editTeacherBtn.setEnabled(false);
        deleteTeacherBtn.setEnabled(false);
        courseBtn.setEnabled(false);
        // enable Add button
        addTeacherBtn.setEnabled(true);
        searchBtn.setEnabled(true);
    }
    public void OpenQuanLyKhoaHoc(){
        int id = Integer.parseInt(idField.getText());
        List<Teacher> dsTeacher = TrungTamController.Instance().getTeacherFunc().getListTeachers();
        for(int i=0;i<dsTeacher.size();i++){
            if(dsTeacher.get(i).getId()==id){
                new KhoaHocView(dsTeacher.get(i)).setVisible(true);
                break;
            }
        }
    }
    /**
     * hiện thị thông tin teacher
     * 
     * @param teacher
     */
    public void showTeacher(Teacher teacher) {
        idField.setText("" + teacher.getId());
        nameField.setText(teacher.getName());
        dobField.setText("" + teacher.getDOB());
        addressTA.setText(teacher.getAddress());
        capBacField.setSelectedItem("" + teacher.getTrinhDo());
        // enable Edit and Delete buttons
        editTeacherBtn.setEnabled(true);
        deleteTeacherBtn.setEnabled(true);
        courseBtn.setEnabled(true);
        // disable Add button
        addTeacherBtn.setEnabled(false);
        searchBtn.setEnabled(false);
    }
    
    /**
     * lấy thông tin teacher
     * 
     * @return
     */
    public Teacher getInfoSearch(){
        Teacher teacher = new Teacher();
        if(!nameField.getText().isBlank()){
            teacher.setName(nameField.getText());
        }
        if(!dobField.getText().isBlank()){
            teacher.setDOB(formatterDate(dobField.getText()));
        }
        if(!addressTA.getText().isBlank()){
            teacher.setAddress(addressTA.getText().trim());
        }
        return teacher;
    }
    public Teacher getTeacherInfo() {
        // validate teacher
        if (!validateName() || !validateDOB() || !validateAddress() || !validateTrinhDo()) {
            return null;
        }
        try {
            Teacher teacher = new Teacher();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                teacher.setId(Integer.parseInt(idField.getText()));
            }
            teacher.setName(nameField.getText().trim());
            teacher.setDOB(formatterDate(dobField.getText()));
            teacher.setAddress(addressTA.getText().trim());
            teacher.setTrinhDo(capBacField.getSelectedItem().toString());
            return teacher;
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
                showMessage("Ngày sinh sai định dạng");
                return null;
            }
        }
        return null;
    }
    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Họ tên không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateAddress() {
        String address = addressTA.getText();
        if (address == null || "".equals(address.trim())) {
            addressTA.requestFocus();
            showMessage("Địa chỉ không được trống.");
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
    
    private boolean validateTrinhDo() {
        return true;
    }
    
    public void actionPerformed(ActionEvent e) {
    }
    
    public void valueChanged(ListSelectionEvent e) {
    }
    
    public void addAddTeacherListener(ActionListener listener) {
        addTeacherBtn.addActionListener(listener);
    }
    
    public void addEditTeacherListener(ActionListener listener) {
        editTeacherBtn.addActionListener(listener);
    }
    
    public void addDeleteTeacherListener(ActionListener listener) {
        deleteTeacherBtn.addActionListener(listener);
    }
    
    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
    
    public void addSortTeacherGPAListener(ActionListener listener) {
        sortTeacherAgeBtn.addActionListener(listener);
    }
    
    public void addSortTeacherNameListener(ActionListener listener) {
        sortTeacherNameBtn.addActionListener(listener);
    }
    
    public void addListTeacherSelectionListener(ListSelectionListener listener) {
        teacherTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void addQuanLyKhoaHoc(ActionListener listener){
        courseBtn.addActionListener(listener);
    }
    public void addSearchListener(ActionListener listener){
        searchBtn.addActionListener(listener);
    }
}
