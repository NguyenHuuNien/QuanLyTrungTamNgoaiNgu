package view;

import entity.Person;

public class KhoaHocView extends javax.swing.JFrame {
    private Person person;
    public KhoaHocView() {
        initComponents();
        setDuLieu();
    }
    public KhoaHocView(Person person) {
        initComponents();
        this.person = person;
        setDuLieu();
    }
    
    private void setDuLieu(){
        setupInfoUserView();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbNgonNgu = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTenKhoaHoc = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pnThoiLuong = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        spinFromThang = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        spinToThang = new javax.swing.JSpinner();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pnKyNang = new javax.swing.JPanel();
        checkNghe = new javax.swing.JCheckBox();
        checkNoi = new javax.swing.JCheckBox();
        checkDoc = new javax.swing.JCheckBox();
        checkViet = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnGia = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        spinFromGia = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spinToGia = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        btnDangKy = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnShowTaiLieu = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        btnShowDSSinhVien = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        hr2 = new javax.swing.JPanel();
        TablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnSapXepID = new javax.swing.JButton();
        btnSapXepGia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 810));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        UserInfoPanel.setPreferredSize(new java.awt.Dimension(1500, 100));
        UserInfoPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        avtLabel.setBackground(new java.awt.Color(255, 0, 255));
        avtLabel.setFont(new java.awt.Font("Liberation Serif", 1, 48)); // NOI18N
        avtLabel.setForeground(new java.awt.Color(0, 0, 255));
        avtLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avtLabel.setText("N");
        avtLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        avtLabel.setPreferredSize(new java.awt.Dimension(100, 100));
        UserInfoPanel.add(avtLabel);

        jPanel2.setPreferredSize(new java.awt.Dimension(500, 100));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 1));

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
        centerPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        InforPanel.setPreferredSize(new java.awt.Dimension(400, 700));

        jLabel4.setFont(new java.awt.Font("Liberation Mono", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Thông tin");
        jLabel4.setPreferredSize(new java.awt.Dimension(400, 30));
        InforPanel.add(jLabel4);

        jPanel10.setPreferredSize(new java.awt.Dimension(400, 60));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        jLabel7.setText("Ngôn ngữ");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel10.add(jLabel7);

        cbNgonNgu.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        cbNgonNgu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tiếng Anh", "Tiếng Nhật", "Tiếng Hàn", "Tiếng Trung Quốc" }));
        cbNgonNgu.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel10.add(cbNgonNgu);

        InforPanel.add(jPanel10);

        jPanel8.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel5.setText("ID");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel8.add(jLabel5);

        txtID.setEnabled(false);
        txtID.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel8.add(txtID);

        InforPanel.add(jPanel8);

        jPanel9.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel6.setText("Tên khóa học");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel9.add(jLabel6);

        txtTenKhoaHoc.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel9.add(txtTenKhoaHoc);

        InforPanel.add(jPanel9);

        jPanel11.setMinimumSize(new java.awt.Dimension(172, 80));
        jPanel11.setPreferredSize(new java.awt.Dimension(400, 80));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel8.setText("Thời lượng");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel11.add(jLabel8);

        pnThoiLuong.setMinimumSize(new java.awt.Dimension(99, 60));
        pnThoiLuong.setPreferredSize(new java.awt.Dimension(200, 60));
        pnThoiLuong.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        jPanel5.setPreferredSize(new java.awt.Dimension(200, 25));
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

        pnThoiLuong.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(200, 25));
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

        pnThoiLuong.add(jPanel6);

        jPanel11.add(pnThoiLuong);

        InforPanel.add(jPanel11);

        jPanel12.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel9.setText("Kỹ năng");
        jLabel9.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel12.add(jLabel9);

        pnKyNang.setPreferredSize(new java.awt.Dimension(220, 25));
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

        InforPanel.add(jPanel12);

        jPanel14.setPreferredSize(new java.awt.Dimension(400, 80));
        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel11.setText("Giá");
        jLabel11.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel14.add(jLabel11);

        pnGia.setMinimumSize(new java.awt.Dimension(99, 60));
        pnGia.setPreferredSize(new java.awt.Dimension(220, 60));
        pnGia.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        jLabel12.setText("Từ");
        jLabel12.setPreferredSize(new java.awt.Dimension(40, 25));
        pnGia.add(jLabel12);

        spinFromGia.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 100000));
        spinFromGia.setPreferredSize(new java.awt.Dimension(120, 25));
        pnGia.add(spinFromGia);

        jLabel14.setText("  VNĐ");
        jLabel14.setPreferredSize(new java.awt.Dimension(50, 18));
        pnGia.add(jLabel14);

        jLabel13.setText("Đến");
        jLabel13.setPreferredSize(new java.awt.Dimension(40, 25));
        pnGia.add(jLabel13);

        spinToGia.setModel(new javax.swing.SpinnerNumberModel(100000, 100000, null, 100000));
        spinToGia.setPreferredSize(new java.awt.Dimension(120, 25));
        pnGia.add(spinToGia);

        jLabel15.setText("  VNĐ");
        jLabel15.setPreferredSize(new java.awt.Dimension(50, 18));
        pnGia.add(jLabel15);

        jPanel14.add(pnGia);

        InforPanel.add(jPanel14);

        jPanel15.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 3));

        btnTimKiem.setText("Tìm kiếm");
        jPanel15.add(btnTimKiem);

        btnDangKy.setText("Đăng ký");
        jPanel15.add(btnDangKy);

        InforPanel.add(jPanel15);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Liberation Mono", 1, 18), new java.awt.Color(0, 51, 255))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 170));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel10.setText("Tài liệu");
        jLabel10.setPreferredSize(new java.awt.Dimension(150, 18));
        jPanel3.add(jLabel10);

        btnShowTaiLieu.setText("Xem tài liệu");
        btnShowTaiLieu.setPreferredSize(new java.awt.Dimension(180, 24));
        jPanel3.add(btnShowTaiLieu);

        jLabel20.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel20.setText("Danh sách sinh viên");
        jLabel20.setPreferredSize(new java.awt.Dimension(150, 18));
        jPanel3.add(jLabel20);

        btnShowDSSinhVien.setText("Xem DS Sinh viên");
        btnShowDSSinhVien.setPreferredSize(new java.awt.Dimension(180, 24));
        btnShowDSSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDSSinhVienActionPerformed(evt);
            }
        });
        jPanel3.add(btnShowDSSinhVien);

        jLabel21.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel21.setText("Danh sách giảng viên");
        jLabel21.setPreferredSize(new java.awt.Dimension(150, 18));
        jPanel3.add(jLabel21);

        jButton5.setText("Xem DS Giảng viên");
        jButton5.setPreferredSize(new java.awt.Dimension(180, 24));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);

        InforPanel.add(jPanel3);

        centerPanel.add(InforPanel);

        hr2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        TablePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(950, 600));

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

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        btnSapXepID.setText("Sắp xếp theo ID");
        btnSapXepID.setPreferredSize(new java.awt.Dimension(150, 24));
        jPanel7.add(btnSapXepID);

        btnSapXepGia.setText("Sắp xếp theo Giá");
        btnSapXepGia.setPreferredSize(new java.awt.Dimension(150, 24));
        btnSapXepGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepGiaActionPerformed(evt);
            }
        });
        jPanel7.add(btnSapXepGia);

        TablePanel.add(jPanel7);

        centerPanel.add(TablePanel);

        getContentPane().add(centerPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnShowDSSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDSSinhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowDSSinhVienActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSapXepGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSapXepGiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InforPanel;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JPanel UserInfoPanel;
    private javax.swing.JLabel avtLabel;
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnSapXepGia;
    private javax.swing.JButton btnSapXepID;
    private javax.swing.JButton btnShowDSSinhVien;
    private javax.swing.JButton btnShowTaiLieu;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbNgonNgu;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JCheckBox checkDoc;
    private javax.swing.JCheckBox checkNghe;
    private javax.swing.JCheckBox checkNoi;
    private javax.swing.JCheckBox checkViet;
    private javax.swing.JPanel hr1;
    private javax.swing.JPanel hr2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnGia;
    private javax.swing.JPanel pnKyNang;
    private javax.swing.JPanel pnThoiLuong;
    private javax.swing.JSpinner spinFromGia;
    private javax.swing.JSpinner spinFromThang;
    private javax.swing.JSpinner spinToGia;
    private javax.swing.JSpinner spinToThang;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTenKhoaHoc;
    private javax.swing.JLabel userHoTen;
    private javax.swing.JLabel userID;
    private javax.swing.JLabel userNgaySinh;
    // End of variables declaration//GEN-END:variables
}
