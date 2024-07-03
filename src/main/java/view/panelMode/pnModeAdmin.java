package view.panelMode;

import controller.TrungTamController;
import entity.KhoaHoc;
import java.util.List;
import utils.ISelectRowTable;
import view.KhoaHocView;

public class pnModeAdmin extends javax.swing.JPanel implements ISelectRowTable{
    private KhoaHocView khView;
    private List<KhoaHoc> dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
    public pnModeAdmin(KhoaHocView khView) {
        initComponents();
        this.khView = khView;
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }
    @Override
    public void changeInfo(KhoaHoc kh) {
        cbNgonNgu.setSelectedItem(kh.getNgonNgu());
        txtID.setText(kh.getId()+"");
        txtTenKhoaHoc.setText(kh.getTenKhoaHoc());
        if(spnThang!=null){
            spnThang.setValue(kh.getThoiGianKhoaHoc());
        }
        if(spnGia!=null){
            spnGia.setValue((int)kh.getGiaKhoaHoc());
        }
        checkNghe.setSelected(kh.getSkill().contains("Nghe"));
        checkNoi.setSelected(kh.getSkill().contains("Nói"));
        checkDoc.setSelected(kh.getSkill().contains("Đọc"));
        checkViet.setSelected(kh.getSkill().contains("Viết"));
        btnThem.setEnabled(false);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
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
        spnThang = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pnKyNang = new javax.swing.JPanel();
        checkNghe = new javax.swing.JCheckBox();
        checkNoi = new javax.swing.JCheckBox();
        checkDoc = new javax.swing.JCheckBox();
        checkViet = new javax.swing.JCheckBox();
        pnGiaBig = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        spnGia = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        pnButton = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(400, 360));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 7));

        jPanel8.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel5.setText("ID");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel8.add(jLabel5);

        txtID.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtID.setEnabled(false);
        txtID.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel8.add(txtID);

        add(jPanel8);

        jPanel9.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel6.setText("Tên khóa học");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel9.add(jLabel6);

        txtTenKhoaHoc.setPreferredSize(new java.awt.Dimension(200, 25));
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
        cbNgonNgu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Lựa chọn --", "Tiếng Anh", "Tiếng Nhật", "Tiếng Hàn", "Tiếng Trung Quốc" }));
        cbNgonNgu.setPreferredSize(new java.awt.Dimension(200, 25));
        cbNgonNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNgonNguActionPerformed(evt);
            }
        });
        jPanel10.add(cbNgonNgu);

        add(jPanel10);

        pnThoiLuongBig.setMinimumSize(new java.awt.Dimension(172, 80));
        pnThoiLuongBig.setPreferredSize(new java.awt.Dimension(400, 40));
        pnThoiLuongBig.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel8.setText("Thời lượng");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 25));
        pnThoiLuongBig.add(jLabel8);

        spnThang.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        spnThang.setPreferredSize(new java.awt.Dimension(60, 25));
        pnThoiLuongBig.add(spnThang);

        jLabel17.setText("  Tháng");
        jLabel17.setPreferredSize(new java.awt.Dimension(140, 18));
        pnThoiLuongBig.add(jLabel17);

        add(pnThoiLuongBig);

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

        add(jPanel12);

        pnGiaBig.setPreferredSize(new java.awt.Dimension(400, 40));
        pnGiaBig.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel11.setText("Giá");
        jLabel11.setPreferredSize(new java.awt.Dimension(100, 25));
        pnGiaBig.add(jLabel11);

        spnGia.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 100000));
        spnGia.setPreferredSize(new java.awt.Dimension(120, 25));
        pnGiaBig.add(spnGia);

        jLabel14.setText("  VNĐ");
        jLabel14.setPreferredSize(new java.awt.Dimension(50, 18));
        pnGiaBig.add(jLabel14);

        add(pnGiaBig);

        pnButton.setPreferredSize(new java.awt.Dimension(400, 40));
        pnButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 3));

        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(90, 24));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnButton.add(btnThem);

        btnSua.setText("Sửa");
        btnSua.setPreferredSize(new java.awt.Dimension(90, 24));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnButton.add(btnSua);

        btnXoa.setText("Xóa");
        btnXoa.setPreferredSize(new java.awt.Dimension(90, 24));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnButton.add(btnXoa);

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

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int id = Integer.parseInt(txtID.getText());
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getId()==id){
                if(!cbNgonNgu.getSelectedItem().equals("Tất cả"))
                    dsKH.get(i).setNgonNgu(cbNgonNgu.getSelectedItem().toString());
                else{
                    khView.showMessage("Vui lòng chọn ngôn ngữ");
                    return;
                }
                if(txtTenKhoaHoc!=null&&txtTenKhoaHoc.getText().length()!=0)
                    dsKH.get(i).setTenKhoaHoc(txtTenKhoaHoc.getText());
                else{
                    khView.showMessage("Vui lòng nhập tên khóa học");
                    return;
                }
                if((int)spnThang.getValue()!=0)
                    dsKH.get(i).setThoiGianKhoaHoc(Integer.parseInt(spnThang.getValue().toString()));
                else{
                    khView.showMessage("Vui lòng chọn thời gian khóa học >1 tháng");
                    return;
                }
                String s = (checkNghe.isSelected() ? "Nghe " : "") +
                   (checkNoi.isSelected() ? "Nói " : "") +
                   (checkDoc.isSelected() ? "Đọc " : "") +
                   (checkViet.isSelected() ? "Viết " : "");
                if(!s.isBlank())
                    dsKH.get(i).setSkill(s);
                else{
                    khView.showMessage("Vui lòng ít nhất mục kỹ năng cho khóa học");
                    return;
                }
                if(Integer.parseInt(spnGia.getValue().toString())>0)
                    dsKH.get(i).setGiaKhoaHoc(Double.parseDouble(spnGia.getValue().toString()));
                else{
                    khView.showMessage("Vui lòng chọn giá của khóa học >0 VNĐ");
                    return;
                }
                TrungTamController.Instance().getKhoaHocFunc().edit(dsKH.get(i));
            }
        }
        khView.resetData();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int id = Integer.parseInt(txtID.getText());
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getId()==id){
                TrungTamController.Instance().getKhoaHocFunc().delete(dsKH.get(i));
                khView.resetData();
                break;
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        cbNgonNgu.setSelectedIndex(0);
        txtID.setText("");
        txtTenKhoaHoc.setText("");
        spnGia.setValue(0);
        spnThang.setValue(0);
        checkDoc.setSelected(false);
        checkNghe.setSelected(false);
        checkNoi.setSelected(false);
        checkViet.setSelected(false);
        khView.table.clearSelection();
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(true);
        khView.resetData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhoaHoc kh = new KhoaHoc();
        if(!cbNgonNgu.getSelectedItem().equals("Tất cả"))
            kh.setNgonNgu(cbNgonNgu.getSelectedItem().toString());
        else{
            khView.showMessage("Vui lòng chọn ngôn ngữ");
            return;
        }
        if(txtTenKhoaHoc!=null&&txtTenKhoaHoc.getText().length()!=0)
            kh.setTenKhoaHoc(txtTenKhoaHoc.getText());
        else{
            khView.showMessage("Vui lòng nhập tên khóa học");
            return;
        }
        if((int)spnThang.getValue()!=0)
            kh.setThoiGianKhoaHoc((int)spnThang.getValue());
        else{
            khView.showMessage("Vui lòng chọn thời gian khóa học >1 tháng");
            return;
        }
        String s = (checkNghe.isSelected() ? "Nghe " : "") +
           (checkNoi.isSelected() ? "Nói " : "") +
           (checkDoc.isSelected() ? "Đọc " : "") +
           (checkViet.isSelected() ? "Viết " : "");
        if(!s.isBlank())
            kh.setSkill(s);
        else{
            khView.showMessage("Vui lòng ít nhất mục kỹ năng cho khóa học");
            return;
        }
        if((int)spnGia.getValue()!=0)
            kh.setGiaKhoaHoc((int)spnGia.getValue());
        else{
            khView.showMessage("Vui lòng chọn giá của khóa học >0 VNĐ");
            return;
        }
        TrungTamController.Instance().getKhoaHocFunc().add(kh);
        khView.resetData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbNgonNguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNgonNguActionPerformed
        
    }//GEN-LAST:event_cbNgonNguActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbNgonNgu;
    private javax.swing.JCheckBox checkDoc;
    private javax.swing.JCheckBox checkNghe;
    private javax.swing.JCheckBox checkNoi;
    private javax.swing.JCheckBox checkViet;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pnButton;
    private javax.swing.JPanel pnGiaBig;
    private javax.swing.JPanel pnKyNang;
    private javax.swing.JPanel pnThoiLuongBig;
    private javax.swing.JSpinner spnGia;
    private javax.swing.JSpinner spnThang;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTenKhoaHoc;
    // End of variables declaration//GEN-END:variables

    
}
