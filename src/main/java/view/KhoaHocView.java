package view;

import controller.TrungTamController;
import entity.KhoaHoc;
import entity.Person;
import entity.Student;
import entity.Teacher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import utils.ISelectRowTable;
import view.panelMode.pnModeAdmin;
import view.panelMode.pnModeSearch;

public class KhoaHocView extends javax.swing.JFrame {
    private Person person;
    private List<KhoaHoc> dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
    private List<KhoaHoc> dsKHDisplayed = new ArrayList<>();
    private ISelectRowTable IpanelMode;
    public KhoaHocView() {
        initComponents();
        setDuLieu();
    }
    public KhoaHocView(Person person) {
        initComponents();
        this.person = person;
        InforPanel.remove(pnAllTimKiem);
        setDuLieu();
    }
    
    private void setDuLieu(){
        setupInfoUserView();
        togActionListener();
        setEventListener();
        setDataToTable(dsKH);
    }
    public void resetData(){
        dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
        setDataToTable(dsKH);
    }
    public void setDataToTable(List<KhoaHoc> dsKhoaHoc) {
        String [] columnNames;
        Object[][] data;
        if(person==null){
            columnNames = new String [] {"ID", "Tên khóa học", "Ngôn ngữ", "Kỹ năng", "Thời lượng học","Giá"};
            data = new Object [dsKhoaHoc.size()][6];
            for(int i=0;i<dsKhoaHoc.size();i++){
                data[i][0] = dsKhoaHoc.get(i).getId();
                data[i][1] = dsKhoaHoc.get(i).getTenKhoaHoc();
                data[i][2] = dsKhoaHoc.get(i).getNgonNgu();
                data[i][3] = dsKhoaHoc.get(i).getSkill();
                data[i][4] = dsKhoaHoc.get(i).getThoiGianKhoaHoc();
                data[i][5] = dsKhoaHoc.get(i).getGiaKhoaHoc();
            }
            table.setModel(new DefaultTableModel(data,columnNames));
        }else{
            columnNames = new String [] {"ID", "Tên khóa học", "Ngôn ngữ", "Kỹ năng", "Thời lượng học","Giá","Tình trạng"};
            data = new Object [dsKhoaHoc.size()][7];
            for(int i=0;i<dsKhoaHoc.size();i++){
                data[i][0] = dsKhoaHoc.get(i).getId();
                data[i][1] = dsKhoaHoc.get(i).getTenKhoaHoc();
                data[i][2] = dsKhoaHoc.get(i).getNgonNgu();
                data[i][3] = dsKhoaHoc.get(i).getSkill();
                data[i][4] = dsKhoaHoc.get(i).getThoiGianKhoaHoc();
                data[i][5] = dsKhoaHoc.get(i).getGiaKhoaHoc();
                if(person instanceof Student){
                    data[i][6] = dsKhoaHoc.get(i).checkContainsStudent(person)?"Đã đăng ký":"Chưa đăng ký";
                }else if(person instanceof Teacher){
                    data[i][6] = dsKhoaHoc.get(i).checkContainsTeacher(person)?"Đã đăng ký":"Chưa đăng ký";
                }
            }
        }
        dsKHDisplayed = dsKhoaHoc;
        table.setModel(new DefaultTableModel(data,columnNames));
    }
    private void setEventListener(){
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    selectKhoaHocInTableListener();
                }
            }
        });
    }
    private void selectKhoaHocInTableListener(){
        int dong = table.getSelectedRow();
        if(dong!=-1){
            KhoaHoc kh = null;
            int id = (int)table.getValueAt(dong, 0);
            for(int i=0;i<dsKH.size();i++){
                if(id==dsKH.get(i).getId()){
                    kh = dsKH.get(i);
                    break;
                }
            }
            IpanelMode.changeInfo(kh);
        }
    }
    
    private void setupInfoUserView(){
        if(person == null){
            avtLabel.setText("@");
            userID.setText("admin");
            userHoTen.setText("Trung tâm ngoại ngữ TLing");
            userNgaySinh.setText("");
        }else{
            avtLabel.setText(person.getName().substring(0, 1));
            userID.setText("ID: " + person.getId());
            userHoTen.setText("Họ và Tên: " + person.getName());
            userNgaySinh.setText("Ngày sinh: " + person.getDOB());
        }
    }
    private void togActionListener(){
        pnMode.removeAll();
        if(togModeQuanLy.isSelected()){
            togModeQuanLy.setText("Mode quản lý");
            pnModeAdmin pnAdmin = new pnModeAdmin(this);
            pnMode.add(pnAdmin);
            IpanelMode = pnAdmin;
            selectKhoaHocInTableListener();
        }else{
            togModeQuanLy.setText("Mode tìm kiếm");
            pnModeSearch pnSearch = new pnModeSearch(this, person);
            pnMode.add(pnSearch);
            IpanelMode = pnSearch;
        }
        pnMode.revalidate();
        pnMode.repaint();
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoGroupLoc = new javax.swing.ButtonGroup();
        UserInfoPanel = new javax.swing.JPanel();
        avtLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        userID = new javax.swing.JLabel();
        userHoTen = new javax.swing.JLabel();
        userNgaySinh = new javax.swing.JLabel();
        hr1 = new javax.swing.JPanel();
        centerPanel = new javax.swing.JPanel();
        InforPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnAllTimKiem = new javax.swing.JPanel();
        togModeQuanLy = new javax.swing.JToggleButton();
        pnMode = new javax.swing.JPanel();
        pnKhac = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        btnShowDSSinhVien = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        btnShowDSGiangVien = new javax.swing.JButton();
        hr2 = new javax.swing.JPanel();
        TablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnSapXepID = new javax.swing.JButton();
        btnSapXepGia = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1510, 875));
        setResizable(false);
        setSize(new java.awt.Dimension(1500, 875));
        getContentPane().setLayout(new java.awt.FlowLayout(1, 5, 10));

        UserInfoPanel.setPreferredSize(new java.awt.Dimension(1500, 100));
        UserInfoPanel.setLayout(new java.awt.FlowLayout(0, 10, 0));

        avtLabel.setBackground(new java.awt.Color(255, 0, 255));
        avtLabel.setFont(new java.awt.Font("Liberation Serif", 1, 48)); // NOI18N
        avtLabel.setForeground(new java.awt.Color(0, 0, 255));
        avtLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avtLabel.setText("N");
        avtLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        avtLabel.setPreferredSize(new java.awt.Dimension(100, 100));
        UserInfoPanel.add(avtLabel);

        jPanel2.setPreferredSize(new java.awt.Dimension(500, 100));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new java.awt.FlowLayout(1, 5, 1));

        userID.setFont(new java.awt.Font("Liberation Mono", 0, 18)); // NOI18N
        userID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userID.setText("ID: 1");
        userID.setPreferredSize(new java.awt.Dimension(480, 30));
        jPanel2.add(userID);

        userHoTen.setFont(new java.awt.Font("Liberation Mono", 0, 18)); // NOI18N
        userHoTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userHoTen.setText("Họ và Tên: Nguyen Thi A");
        userHoTen.setPreferredSize(new java.awt.Dimension(480, 30));
        jPanel2.add(userHoTen);

        userNgaySinh.setFont(new java.awt.Font("Liberation Mono", 0, 18)); // NOI18N
        userNgaySinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userNgaySinh.setText("Ngày sinh: 01/01/2004");
        userNgaySinh.setPreferredSize(new java.awt.Dimension(480, 30));
        jPanel2.add(userNgaySinh);

        UserInfoPanel.add(jPanel2);

        getContentPane().add(UserInfoPanel);

        hr1.setBackground(new java.awt.Color(0, 0, 0));
        hr1.setPreferredSize(new java.awt.Dimension(1500, 2));

        javax.swing.GroupLayout hr1Layout = new javax.swing.GroupLayout(hr1);
        hr1.setLayout(hr1Layout);
        hr1Layout.setHorizontalGroup(
            hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1500, Short.MAX_VALUE)
        );
        hr1Layout.setVerticalGroup(
            hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        getContentPane().add(hr1);

        centerPanel.setPreferredSize(new java.awt.Dimension(1500, 700));
        centerPanel.setLayout(new java.awt.FlowLayout(0, 5, 0));

        InforPanel.setPreferredSize(new java.awt.Dimension(400, 700));

        jLabel4.setFont(new java.awt.Font("Liberation Mono", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Thông tin");
        jLabel4.setPreferredSize(new java.awt.Dimension(400, 30));
        InforPanel.add(jLabel4);

        pnAllTimKiem.setPreferredSize(new java.awt.Dimension(400, 50));
        pnAllTimKiem.setLayout(new java.awt.FlowLayout(2, 50, 5));

        togModeQuanLy.setBackground(new java.awt.Color(255, 153, 153));
        togModeQuanLy.setForeground(new java.awt.Color(51, 51, 255));
        togModeQuanLy.setText("Mode Quản lý");
        togModeQuanLy.setPreferredSize(new java.awt.Dimension(130, 26));
        togModeQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togModeQuanLyActionPerformed(evt);
            }
        });
        pnAllTimKiem.add(togModeQuanLy);

        InforPanel.add(pnAllTimKiem);

        pnMode.setOpaque(false);
        pnMode.setPreferredSize(new java.awt.Dimension(400, 410));
        InforPanel.add(pnMode);

        pnKhac.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        pnKhac.setPreferredSize(new java.awt.Dimension(390, 120));
        pnKhac.setLayout(new java.awt.FlowLayout(1, 5, 20));

        jLabel20.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel20.setText("Danh sách sinh viên");
        jLabel20.setPreferredSize(new java.awt.Dimension(150, 20));
        pnKhac.add(jLabel20);

        btnShowDSSinhVien.setText("Xem DS Sinh viên");
        btnShowDSSinhVien.setPreferredSize(new java.awt.Dimension(180, 24));
        btnShowDSSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDSSinhVienActionPerformed(evt);
            }
        });
        pnKhac.add(btnShowDSSinhVien);

        jLabel21.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel21.setText("Danh sách giảng viên");
        jLabel21.setPreferredSize(new java.awt.Dimension(150, 20));
        pnKhac.add(jLabel21);

        btnShowDSGiangVien.setText("Xem DS Giảng viên");
        btnShowDSGiangVien.setPreferredSize(new java.awt.Dimension(180, 24));
        btnShowDSGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDSGiangVienActionPerformed(evt);
            }
        });
        pnKhac.add(btnShowDSGiangVien);

        InforPanel.add(pnKhac);

        centerPanel.add(InforPanel);

        hr2.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        hr2.setPreferredSize(new java.awt.Dimension(2, 700));

        javax.swing.GroupLayout hr2Layout = new javax.swing.GroupLayout(hr2);
        hr2.setLayout(hr2Layout);
        hr2Layout.setHorizontalGroup(
            hr2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        hr2Layout.setVerticalGroup(
            hr2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );

        centerPanel.add(hr2);

        TablePanel.setPreferredSize(new java.awt.Dimension(1000, 700));
        TablePanel.setLayout(new java.awt.FlowLayout(1, 0, 5));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(950, 650));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        TablePanel.add(jScrollPane1);

        jPanel7.setPreferredSize(new java.awt.Dimension(600, 44));
        jPanel7.setLayout(new java.awt.FlowLayout(1, 20, 10));

        btnSapXepID.setText("Sắp xếp theo ID");
        btnSapXepID.setPreferredSize(new java.awt.Dimension(150, 24));
        btnSapXepID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepIDActionPerformed(evt);
            }
        });
        jPanel7.add(btnSapXepID);

        btnSapXepGia.setText("Sắp xếp theo Giá");
        btnSapXepGia.setPreferredSize(new java.awt.Dimension(150, 24));
        btnSapXepGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepGiaActionPerformed(evt);
            }
        });
        jPanel7.add(btnSapXepGia);

        jButton1.setText("Sắp xếp theo Thời lượng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1);

        TablePanel.add(jPanel7);

        centerPanel.add(TablePanel);

        getContentPane().add(centerPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowDSSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDSSinhVienActionPerformed
        if(table.getSelectedRow()!=-1){
            String [] columnNames = new String [] {"ID", "Họ tên", "Ngày sinh", "Địa chỉ"};
            List<Student> dsStudents = new ArrayList<Student>();
            for(KhoaHoc kh : dsKH){
                if(kh.getId()==(int)table.getValueAt(table.getSelectedRow(), 0)){
                    dsStudents = kh.getDsStudent();
                    break;
                }
            }
            Object [][] datas = new Object[dsStudents.size()][4];
            for (int i = 0; i < dsStudents.size(); i++) {
                datas[i][0] = dsStudents.get(i).getId();
                datas[i][1] = dsStudents.get(i).getName();
                datas[i][2] = dsStudents.get(i).getDOB();
                datas[i][3] = dsStudents.get(i).getAddress();
            }
            new ShowListView(columnNames, datas).setVisible(true);
        }else{
            showMessage("Vui lòng chọn một khóa học");
        }
    }//GEN-LAST:event_btnShowDSSinhVienActionPerformed

    private void btnShowDSGiangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDSGiangVienActionPerformed
        if(table.getSelectedRow()!=-1){
            String [] columnNames = new String [] {
                "ID", "Họ tên", "Ngày sinh", "Địa chỉ", "Trình độ"};
            List<Teacher> dsTeachers = new ArrayList<Teacher>();
            for(KhoaHoc kh : dsKH){
                if(kh.getId()==(int)table.getValueAt(table.getSelectedRow(), 0)){
                    dsTeachers = kh.getDsTeacher();
                    break;
                }
            }
            Object [][] datas = new Object[dsTeachers.size()][5];
            for (int i = 0; i < dsTeachers.size(); i++) {
                datas[i][0] = dsTeachers.get(i).getId();
                datas[i][1] = dsTeachers.get(i).getName();
                datas[i][2] = dsTeachers.get(i).getDOB();
                datas[i][3] = dsTeachers.get(i).getAddress();
                datas[i][4] = dsTeachers.get(i).getTrinhDo();
            }
            new ShowListView(columnNames, datas).setVisible(true);
        }else{
            showMessage("Vui lòng chọn một khóa học");
        }
    }//GEN-LAST:event_btnShowDSGiangVienActionPerformed

    private void btnSapXepGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepGiaActionPerformed
        Collections.sort(dsKHDisplayed, new Comparator<KhoaHoc>() {
            public int compare(KhoaHoc kh1, KhoaHoc kh2) {
                return kh1.getGiaKhoaHoc()>kh2.getGiaKhoaHoc()?1:-1;
            }
        });
        setDataToTable(dsKHDisplayed);
    }//GEN-LAST:event_btnSapXepGiaActionPerformed

    private void togModeQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togModeQuanLyActionPerformed
        togActionListener();
    }//GEN-LAST:event_togModeQuanLyActionPerformed

    private void btnSapXepIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepIDActionPerformed
        Collections.sort(dsKHDisplayed, new Comparator<KhoaHoc>() {
            public int compare(KhoaHoc kh1, KhoaHoc kh2) {
                return kh1.getId()>kh2.getId()?1:-1;
            }
        });
        setDataToTable(dsKHDisplayed);
    }//GEN-LAST:event_btnSapXepIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Collections.sort(dsKHDisplayed, new Comparator<KhoaHoc>() {
            public int compare(KhoaHoc kh1, KhoaHoc kh2) {
                return kh1.getThoiGianKhoaHoc()>kh2.getThoiGianKhoaHoc()?1:-1;
            }
        });
        setDataToTable(dsKHDisplayed);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InforPanel;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JPanel UserInfoPanel;
    private javax.swing.JLabel avtLabel;
    private javax.swing.JButton btnSapXepGia;
    private javax.swing.JButton btnSapXepID;
    private javax.swing.JButton btnShowDSGiangVien;
    private javax.swing.JButton btnShowDSSinhVien;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel hr1;
    private javax.swing.JPanel hr2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnAllTimKiem;
    private javax.swing.JPanel pnKhac;
    private javax.swing.JPanel pnMode;
    private javax.swing.ButtonGroup rdoGroupLoc;
    public javax.swing.JTable table;
    private javax.swing.JToggleButton togModeQuanLy;
    private javax.swing.JLabel userHoTen;
    private javax.swing.JLabel userID;
    private javax.swing.JLabel userNgaySinh;
    // End of variables declaration//GEN-END:variables

}
