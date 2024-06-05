package view;

import entity.Teacher;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
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
    private JButton sortTeacherGPABtn;
    private JButton sortTeacherNameBtn;
    private JScrollPane jScrollPaneTeacherTable;
    private JScrollPane jScrollPaneAddress;
    private JTable teacherTable;
    
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel addressLabel;
    private JLabel gpaLabel;
    
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea addressTA;
    private JTextField gpaField;
    
    // định nghĩa các cột của bảng teacher
    private String [] columnNames = new String [] {
            "ID", "Name", "Age", "Address", "GPA"};
    // định nghĩa dữ liệu mặc định của bẳng teacher là rỗng
    private Object data = new Object [][] {};
    
    public TeacherView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addTeacherBtn = new JButton("Add");
        editTeacherBtn = new JButton("Edit");
        deleteTeacherBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        sortTeacherGPABtn = new JButton("Sort By GPA");
        sortTeacherNameBtn = new JButton("Sort By Name");
        // khởi tạo bảng teacher
        jScrollPaneTeacherTable = new JScrollPane();
        teacherTable = new JTable();
        
        // khởi tạo các label
        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Name");
        ageLabel = new JLabel("Age");
        addressLabel = new JLabel("Address");
        gpaLabel = new JLabel("GPA");
        
        // khởi tạo các trường nhập dữ liệu cho teacher
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        ageField = new JTextField(6);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        gpaField = new JTextField(6);
        
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
        panel.add(sortTeacherGPABtn);
        panel.add(sortTeacherNameBtn);
        
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(addressLabel);
        panel.add(gpaLabel);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(jScrollPaneAddress);
        panel.add(gpaField);
        
        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gpaLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaLabel, 200, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gpaField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaField, 200, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, jScrollPaneTeacherTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneTeacherTable, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addTeacherBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addTeacherBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editTeacherBtn, 60, SpringLayout.WEST, addTeacherBtn);
        layout.putConstraint(SpringLayout.NORTH, editTeacherBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteTeacherBtn, 60, SpringLayout.WEST, editTeacherBtn);
        
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteTeacherBtn);
        
        layout.putConstraint(SpringLayout.NORTH, deleteTeacherBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortTeacherGPABtn, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortTeacherGPABtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortTeacherNameBtn, 115, SpringLayout.WEST, sortTeacherGPABtn);
        layout.putConstraint(SpringLayout.NORTH, sortTeacherNameBtn, 330, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        this.setTitle("Teacher Information");
        this.setSize(800, 420);
        // disable Edit and Delete buttons
        editTeacherBtn.setEnabled(false);
        deleteTeacherBtn.setEnabled(false);
        // enable Add button
        addTeacherBtn.setEnabled(true);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    /**
     * hiển thị list teacher vào bảng teacherTable
     * 
     * @param list
     */
    public void showListTeachers(List<Teacher> list) {
        int size = list.size();
        // với bảng teacherTable có 5 cột, 
        // khởi tạo mảng 2 chiều teachers, trong đó:
        // số hàng: là kích thước của list teacher 
        // số cột: là 5
        Object [][] teachers = new Object[size][5];
        for (int i = 0; i < size; i++) {
            teachers[i][0] = list.get(i).getId();
            teachers[i][1] = list.get(i).getName();
            teachers[i][2] = list.get(i).getAge();
            teachers[i][3] = list.get(i).getAddress();
            teachers[i][4] = list.get(i).getTrinhDo();
        }
        teacherTable.setModel(new DefaultTableModel(teachers, columnNames));
    }
    
    /**
     * điền thông tin của hàng được chọn từ bảng teacher 
     * vào các trường tương ứng của teacher.
     */
    public void fillTeacherFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = teacherTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(teacherTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(teacherTable.getModel().getValueAt(row, 1).toString());
            ageField.setText(teacherTable.getModel().getValueAt(row, 2).toString());
            addressTA.setText(teacherTable.getModel().getValueAt(row, 3).toString());
            gpaField.setText(teacherTable.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            editTeacherBtn.setEnabled(true);
            deleteTeacherBtn.setEnabled(true);
            // disable Add button
            addTeacherBtn.setEnabled(false);
        }
    }

    /**
     * xóa thông tin teacher
     */
    public void clearTeacherInfo() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        addressTA.setText("");
        gpaField.setText("");
        // disable Edit and Delete buttons
        editTeacherBtn.setEnabled(false);
        deleteTeacherBtn.setEnabled(false);
        // enable Add button
        addTeacherBtn.setEnabled(true);
    }
    
    /**
     * hiện thị thông tin teacher
     * 
     * @param teacher
     */
    public void showTeacher(Teacher teacher) {
        idField.setText("" + teacher.getId());
        nameField.setText(teacher.getName());
        ageField.setText("" + teacher.getAge());
        addressTA.setText(teacher.getAddress());
        gpaField.setText("" + teacher.getTrinhDo());
        // enable Edit and Delete buttons
        editTeacherBtn.setEnabled(true);
        deleteTeacherBtn.setEnabled(true);
        // disable Add button
        addTeacherBtn.setEnabled(false);
    }
    
    /**
     * lấy thông tin teacher
     * 
     * @return
     */
    public Teacher getTeacherInfo() {
        // validate teacher
        if (!validateName() || !validateAge() || !validateAddress() || !validateGPA()) {
            return null;
        }
        try {
            Teacher teacher = new Teacher();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                teacher.setId(Integer.parseInt(idField.getText()));
            }
            teacher.setName(nameField.getText().trim());
            teacher.setAge(Byte.parseByte(ageField.getText().trim()));
            teacher.setAddress(addressTA.getText().trim());
            teacher.setTrinhDo((gpaField.getText().trim()));
            return teacher;
        } catch (Exception e) {
            showMessage(e.getMessage());
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
    
    private boolean validateAge() {
        try {
            Byte age = Byte.parseByte(ageField.getText().trim());
            if (age < 0 || age > 100) {
                ageField.requestFocus();
                showMessage("Age không hợp lệ, age nên trong khoảng 0 đến 100.");
                return false;
            }
        } catch (Exception e) {
            ageField.requestFocus();
            showMessage("Age không hợp lệ!");
            return false;
        }
        return true;
    }
    
    private boolean validateGPA() {
        try {
            Float gpa = Float.parseFloat(gpaField.getText().trim());
            if (gpa < 0 || gpa > 10) {
                gpaField.requestFocus();
                showMessage("GPA không hợp lệ, gpa nên trong khoảng 0 đến 10.");
                return false;
            }
        } catch (Exception e) {
            gpaField.requestFocus();
            showMessage("GPA không hợp lệ!");
            return false;
        }
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
        sortTeacherGPABtn.addActionListener(listener);
    }
    
    public void addSortTeacherNameListener(ActionListener listener) {
        sortTeacherNameBtn.addActionListener(listener);
    }
    
    public void addListTeacherSelectionListener(ListSelectionListener listener) {
        teacherTable.getSelectionModel().addListSelectionListener(listener);
    }
}
