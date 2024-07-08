package view.panelMode;

import controller.TrungTamController;
import entity.KhoaHoc;
import entity.Person;
import entity.Student;
import entity.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import utils.ISelectRowTable;
import view.KhoaHocView;
import view.ShowListView;

public class pnModeSearch extends javax.swing.JPanel implements ISelectRowTable{
    private KhoaHocView khView;
    private Person person;
    private KhoaHoc khoaHocSelected;
    private List<KhoaHoc> dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
    public pnModeSearch(KhoaHocView khView, Person person) {
        initComponents();
        this.khView = khView;
        this.person = person;
        if(person==null){
            pnButton.remove(btnDangKy);
        }
        btnDangKy.setEnabled(false);
        setInitCheckTimeAndGia();
        setActionListenerSpinner();
    }
    private void setInitCheckTimeAndGia(){
        checkGiaMin.setSelected(true); checkGiaMax.setSelected(true);
        checkTimeMin.setSelected(true); checkTimeMax.setSelected(true);
        setMinTime(); setMaxTime(); setMinGia(); setMaxGia();
    }
    private void addTimKiemListener(){
        List<KhoaHoc> dsKhoaHoc = new ArrayList<>();
        for(int i=0;i<dsKH.size();i++){
            if(checkSearch(dsKH.get(i))){
                dsKhoaHoc.add(dsKH.get(i));
            }
        }
        khView.setDataToTable(dsKhoaHoc);
    }
    private boolean checkSearch(KhoaHoc kh){
        if(!txtID.getText().isBlank()&&kh.getId()!=Integer.parseInt(txtID.getText())){
            return false;
        }
        if(!txtTenKhoaHoc.getText().isBlank()&&!kh.getTenKhoaHoc().toLowerCase().contains(txtTenKhoaHoc.getText().toLowerCase())){
            return false;
        }
        if(cbNgonNgu.getSelectedIndex()!=0&&!kh.getNgonNgu().equals(cbNgonNgu.getSelectedItem().toString())){
            return false;
        }
        if(!(kh.getGiaKhoaHoc()>=(int)spinFromGia.getValue() && kh.getGiaKhoaHoc()<=(int)spinToGia.getValue())){
            return false;
        }
        if(!(kh.getThoiGianKhoaHoc()>=(int)spinFromThang.getValue() && kh.getThoiGianKhoaHoc()<=(int)spinToThang.getValue())){
            return false;
        }
        if(checkNghe.isSelected() && !kh.getSkill().contains("Nghe")){
            return false;
        }
        if(checkNoi.isSelected() && !kh.getSkill().contains("Nói")){
            return false;
        }
        if(checkDoc.isSelected() && !kh.getSkill().contains("Đọc")){
            return false;
        }
        if(checkViet.isSelected() && !kh.getSkill().contains("Viết")){
            return false;
        }
        return true;
    }
    @Override
    public void changeInfo(KhoaHoc kh) {
        khoaHocSelected = kh;
        if(person==null) return;
        btnDangKy.setEnabled(true);
        if(person instanceof Student?!kh.checkContainsStudent(person):!kh.checkContainsTeacher(person)){
            btnDangKy.setText("Đăng ký");
        }else{
            btnDangKy.setText("Hủy đăng ký");
        }
    }
    private void setActionListenerSpinner() {
        spinFromThang.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                if((int)spinFromThang.getValue() > (int)spinToThang.getValue()){
                    spinToThang.setValue(spinToThang.getNextValue());
                }
            }
        });
        spinFromGia.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                if((int)spinFromGia.getValue() > (int)spinToGia.getValue()){
                    spinToGia.setValue(spinToGia.getNextValue());
                }
            }
        });
    }
    private void setMinTime(){
        spinFromThang.setValue(1);
        spinFromThang.setEnabled(!checkTimeMin.isSelected());
    }
    private void setMaxTime(){
        int max = 0;
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getThoiGianKhoaHoc()>max){
                max = dsKH.get(i).getThoiGianKhoaHoc();
            }
        }
        spinToThang.setValue(max);
        spinToThang.setEnabled(!checkTimeMax.isSelected());
    }
    private void setMinGia(){
        spinFromGia.setValue(0);
        spinFromGia.setEnabled(!checkGiaMin.isSelected());
    }
    private void setMaxGia(){
        int max = 0;
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getGiaKhoaHoc()>max){
                max = (int)dsKH.get(i).getGiaKhoaHoc();
            }
        }
        spinToGia.setValue(max);
        spinToGia.setEnabled(!checkGiaMax.isSelected());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTenKhoaHoc = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbNgonNgu = new javax.swing.JComboBox<>();
        pnThoiLuongBig = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pnThoiLuong = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        spinFromThang = new javax.swing.JSpinner();
        checkTimeMin = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        spinToThang = new javax.swing.JSpinner();
        checkTimeMax = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pnKyNang = new javax.swing.JPanel();
        checkNghe = new javax.swing.JCheckBox();
        checkNoi = new javax.swing.JCheckBox();
        checkDoc = new javax.swing.JCheckBox();
        checkViet = new javax.swing.JCheckBox();
        pnGiaBig = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnGia = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        spinFromGia = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        checkGiaMin = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        spinToGia = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        checkGiaMax = new javax.swing.JCheckBox();
        pnButton = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        btnDangKy = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(400, 400));

        jPanel8.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel5.setText("ID");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel8.add(jLabel5);

        txtID.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtID.setPreferredSize(new java.awt.Dimension(220, 25));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel8.add(txtID);

        add(jPanel8);

        jPanel9.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel6.setText("Tên khóa học");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel9.add(jLabel6);

        txtTenKhoaHoc.setPreferredSize(new java.awt.Dimension(220, 25));
        txtTenKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhoaHocActionPerformed(evt);
            }
        });
        jPanel9.add(txtTenKhoaHoc);

        add(jPanel9);

        jPanel10.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel7.setText("Ngôn ngữ");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel10.add(jLabel7);

        cbNgonNgu.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        cbNgonNgu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tiếng Anh", "Tiếng Nhật", "Tiếng Hàn", "Tiếng Trung Quốc" }));
        cbNgonNgu.setPreferredSize(new java.awt.Dimension(220, 25));
        cbNgonNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNgonNguActionPerformed(evt);
            }
        });
        jPanel10.add(cbNgonNgu);

        add(jPanel10);

        pnThoiLuongBig.setMinimumSize(new java.awt.Dimension(172, 80));
        pnThoiLuongBig.setPreferredSize(new java.awt.Dimension(400, 80));
        pnThoiLuongBig.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel8.setText("Thời lượng");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 25));
        pnThoiLuongBig.add(jLabel8);

        pnThoiLuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnThoiLuong.setForeground(new java.awt.Color(153, 153, 153));
        pnThoiLuong.setMinimumSize(new java.awt.Dimension(99, 60));
        pnThoiLuong.setPreferredSize(new java.awt.Dimension(220, 60));
        pnThoiLuong.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 3));

        jPanel5.setPreferredSize(new java.awt.Dimension(210, 25));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Từ");
        jLabel16.setPreferredSize(new java.awt.Dimension(40, 25));
        jPanel5.add(jLabel16);

        jLabel17.setText("Tháng");
        jLabel17.setPreferredSize(new java.awt.Dimension(50, 18));
        jPanel5.add(jLabel17);

        spinFromThang.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinFromThang.setPreferredSize(new java.awt.Dimension(60, 25));
        jPanel5.add(spinFromThang);

        checkTimeMin.setText("Min");
        checkTimeMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTimeMinActionPerformed(evt);
            }
        });
        jPanel5.add(checkTimeMin);

        pnThoiLuong.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(210, 25));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Đến");
        jLabel22.setPreferredSize(new java.awt.Dimension(40, 25));
        jPanel6.add(jLabel22);

        jLabel23.setText("Tháng");
        jLabel23.setPreferredSize(new java.awt.Dimension(50, 18));
        jPanel6.add(jLabel23);

        spinToThang.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinToThang.setPreferredSize(new java.awt.Dimension(60, 25));
        jPanel6.add(spinToThang);

        checkTimeMax.setText("Max");
        checkTimeMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTimeMaxActionPerformed(evt);
            }
        });
        jPanel6.add(checkTimeMax);

        pnThoiLuong.add(jPanel6);

        pnThoiLuongBig.add(pnThoiLuong);

        add(pnThoiLuongBig);

        jPanel12.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel9.setText("Kỹ năng");
        jLabel9.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel12.add(jLabel9);

        pnKyNang.setPreferredSize(new java.awt.Dimension(240, 25));
        pnKyNang.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        checkNghe.setText("Nghe");
        checkNghe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNgheActionPerformed(evt);
            }
        });
        pnKyNang.add(checkNghe);

        checkNoi.setText("Nói");
        checkNoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNoiActionPerformed(evt);
            }
        });
        pnKyNang.add(checkNoi);

        checkDoc.setText("Đọc");
        checkDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDocActionPerformed(evt);
            }
        });
        pnKyNang.add(checkDoc);

        checkViet.setText("Viết");
        checkViet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVietActionPerformed(evt);
            }
        });
        pnKyNang.add(checkViet);

        jPanel12.add(pnKyNang);

        add(jPanel12);

        pnGiaBig.setPreferredSize(new java.awt.Dimension(400, 80));
        pnGiaBig.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel11.setText("Giá");
        jLabel11.setPreferredSize(new java.awt.Dimension(65, 25));
        pnGiaBig.add(jLabel11);

        pnGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnGia.setMinimumSize(new java.awt.Dimension(99, 60));
        pnGia.setPreferredSize(new java.awt.Dimension(255, 65));
        pnGia.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 1, 4));

        jLabel12.setText("Từ");
        jLabel12.setPreferredSize(new java.awt.Dimension(35, 25));
        pnGia.add(jLabel12);

        spinFromGia.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 100000));
        spinFromGia.setPreferredSize(new java.awt.Dimension(120, 25));
        pnGia.add(spinFromGia);

        jLabel14.setText(" VNĐ");
        jLabel14.setPreferredSize(new java.awt.Dimension(35, 18));
        pnGia.add(jLabel14);

        checkGiaMin.setText("Min");
        checkGiaMin.setPreferredSize(new java.awt.Dimension(50, 22));
        checkGiaMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGiaMinActionPerformed(evt);
            }
        });
        pnGia.add(checkGiaMin);

        jLabel13.setText("Đến");
        jLabel13.setPreferredSize(new java.awt.Dimension(35, 25));
        pnGia.add(jLabel13);

        spinToGia.setModel(new javax.swing.SpinnerNumberModel(100000, 100000, null, 100000));
        spinToGia.setPreferredSize(new java.awt.Dimension(120, 25));
        pnGia.add(spinToGia);

        jLabel15.setText(" VNĐ");
        jLabel15.setPreferredSize(new java.awt.Dimension(35, 18));
        pnGia.add(jLabel15);

        checkGiaMax.setText("Max");
        checkGiaMax.setPreferredSize(new java.awt.Dimension(50, 22));
        checkGiaMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGiaMaxActionPerformed(evt);
            }
        });
        pnGia.add(checkGiaMax);

        pnGiaBig.add(pnGia);

        add(pnGiaBig);

        pnButton.setPreferredSize(new java.awt.Dimension(400, 40));
        pnButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 3));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        pnButton.add(btnTimKiem);

        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        pnButton.add(btnDangKy);

        btnLamMoi.setText("Làm mới");
        btnLamMoi.setPreferredSize(new java.awt.Dimension(90, 24));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        pnButton.add(btnLamMoi);

        add(pnButton);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhoaHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhoaHocActionPerformed

    private void checkNgheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNgheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkNgheActionPerformed

    private void checkNoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkNoiActionPerformed

    private void checkDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDocActionPerformed

    private void checkVietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkVietActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        if(btnDangKy.getText().equals("Đăng ký")){
            if(person instanceof Student){
                String [] columnNames = new String [] {"ID", "Họ tên", "Ngày sinh", "Địa chỉ", "Trình độ"};
                List<Teacher> dsTeacher = khoaHocSelected.getDsTeacher();
                Object [][] datas = new Object[dsTeacher.size()][5];
                for (int i = 0; i < dsTeacher.size(); i++) {
                    datas[i][0] = dsTeacher.get(i).getId();
                    datas[i][1] = dsTeacher.get(i).getName();
                    datas[i][2] = dsTeacher.get(i).getDOB();
                    datas[i][3] = dsTeacher.get(i).getAddress();
                    datas[i][4] = dsTeacher.get(i).getTrinhDo();
                }
                new ShowListView(person,khoaHocSelected,khView,columnNames,datas).setVisible(true);
            }else{
                List<Teacher> dsGV = TrungTamController.Instance().getTeacherFunc().getListTeachers();
                for(int i=0;i<dsGV.size();i++){
                    if(person.getId()==dsGV.get(i).getId()){
                        dsGV.get(i).setNumKhoaHoc(1);
                        khoaHocSelected.addTeacher(dsGV.get(i));
                        TrungTamController.Instance().getKhoaHocFunc().edit(khoaHocSelected);
                        TrungTamController.Instance().getTeacherFunc().edit(dsGV.get(i));
                        khView.showMessage("Đăng ký thành công!");
                        break;
                    }
                }
            }
        }else{
            if(person instanceof Student){
                List<Student> dsSV = TrungTamController.Instance().getStudentFunc().getListStudents();
                for(int i=0;i<dsSV.size();i++){
                    if(person.getId()==dsSV.get(i).getId()){
                        dsSV.get(i).setNumKhoaHoc(-1);
                        khoaHocSelected.removeStudent(dsSV.get(i));
                        TrungTamController.Instance().getKhoaHocFunc().edit(khoaHocSelected);
                        TrungTamController.Instance().getStudentFunc().edit(dsSV.get(i));
                        khView.showMessage("Hủy đăng ký thành công!");
                        break;
                    }
                }
            }else{
                List<Teacher> dsGV = TrungTamController.Instance().getTeacherFunc().getListTeachers();
                for(int i=0;i<dsGV.size();i++){
                    if(person.getId()==dsGV.get(i).getId()){
                        dsGV.get(i).setNumKhoaHoc(-1);
                        khoaHocSelected.removeTeacher(dsGV.get(i));
                        TrungTamController.Instance().getKhoaHocFunc().edit(khoaHocSelected);
                        TrungTamController.Instance().getTeacherFunc().edit(dsGV.get(i));
                        khView.showMessage("Hủy đăng ký thành công!");
                        break;
                    }
                }
            }
        }
        btnDangKy.setEnabled(false);
        khView.resetData();
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        addTimKiemListener();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cbNgonNguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNgonNguActionPerformed
        
    }//GEN-LAST:event_cbNgonNguActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        cbNgonNgu.setSelectedIndex(0);
        txtID.setText("");
        txtTenKhoaHoc.setText("");
        checkDoc.setSelected(false);
        checkNghe.setSelected(false);
        checkNoi.setSelected(false);
        checkViet.setSelected(false);
        setInitCheckTimeAndGia();
        khView.table.clearSelection();
        khView.resetData();
        
        btnDangKy.setEnabled(false);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void checkTimeMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTimeMinActionPerformed
        setMinTime();
    }//GEN-LAST:event_checkTimeMinActionPerformed

    private void checkTimeMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTimeMaxActionPerformed
        setMaxTime();
    }//GEN-LAST:event_checkTimeMaxActionPerformed

    private void checkGiaMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGiaMinActionPerformed
        setMinGia();
    }//GEN-LAST:event_checkGiaMinActionPerformed

    private void checkGiaMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGiaMaxActionPerformed
        setMaxGia();
    }//GEN-LAST:event_checkGiaMaxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbNgonNgu;
    private javax.swing.JCheckBox checkDoc;
    private javax.swing.JCheckBox checkGiaMax;
    private javax.swing.JCheckBox checkGiaMin;
    private javax.swing.JCheckBox checkNghe;
    private javax.swing.JCheckBox checkNoi;
    private javax.swing.JCheckBox checkTimeMax;
    private javax.swing.JCheckBox checkTimeMin;
    private javax.swing.JCheckBox checkViet;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pnButton;
    private javax.swing.JPanel pnGia;
    private javax.swing.JPanel pnGiaBig;
    private javax.swing.JPanel pnKyNang;
    private javax.swing.JPanel pnThoiLuong;
    private javax.swing.JPanel pnThoiLuongBig;
    private javax.swing.JSpinner spinFromGia;
    private javax.swing.JSpinner spinFromThang;
    private javax.swing.JSpinner spinToGia;
    private javax.swing.JSpinner spinToThang;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTenKhoaHoc;
    // End of variables declaration//GEN-END:variables

    

}
