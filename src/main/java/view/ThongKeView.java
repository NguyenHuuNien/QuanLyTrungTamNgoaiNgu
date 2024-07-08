package view;

import controller.TrungTamController;
import entity.KhoaHoc;
import entity.Teacher;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThongKeView extends javax.swing.JFrame {

    public ThongKeView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 50));

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        jPanel2.setPreferredSize(new java.awt.Dimension(900, 100));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Thống kê từng khóa học");
        jLabel2.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel2.add(jLabel2);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Xem");
        jButton1.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jPanel1.add(jPanel2);

        jPanel3.setPreferredSize(new java.awt.Dimension(900, 100));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Thống kê trình độ giảng viên");
        jLabel3.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel3.add(jLabel3);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Xem");
        jButton2.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jPanel1.add(jPanel3);

        jPanel4.setPreferredSize(new java.awt.Dimension(900, 100));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Thống kê doanh thu");
        jLabel4.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel4.add(jLabel4);

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Xem");
        jButton3.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jPanel1.add(jPanel4);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] nameCol = {"ID","Tên khóa học","Giá","Số lượng giảng viên","Số lượng sinh viên","Tổng thu khóa học"};
        List<KhoaHoc> dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
        Object[][] data = new Object[dsKH.size()][6];
        for(int i=0;i<dsKH.size();i++){
            data[i][0] = dsKH.get(i).getId();
            data[i][1] = dsKH.get(i).getTenKhoaHoc();
            data[i][2] = dsKH.get(i).getGiaKhoaHoc();
            data[i][3] = dsKH.get(i).getDsTeacher().size();
            data[i][4] = dsKH.get(i).getDsStudent().size();
            data[i][5] = dsKH.get(i).getDsStudent().size() * dsKH.get(i).getGiaKhoaHoc();
        }
        new ShowListView(nameCol, data).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private int demSoLuongGiangVienTheoTrinhDo(List<Teacher> dsTeacher, String trinhDo){
        int dem = 0;
        for(Teacher tc : dsTeacher){
            if(tc.getTrinhDo().equals(trinhDo))
                dem++;
        }
        return dem;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String[] nameCol = {"Trình độ","Mức lương","Số lượng","Tỷ lệ"};
        List<Teacher> dsTeacher = TrungTamController.Instance().getTeacherFunc().getListTeachers();
        String[] luongGV = {"25.000.000 VNĐ","21.500.000 VNĐ","18.000.000 VNĐ", "13.500.000 VNĐ","8.000.000 VNĐ","5.000.000 VNĐ","Đang cập nhật"};
        int totalTeacher = dsTeacher.size();
        String[] arrCapBac = new String[]{"Tiến sĩ", "Giáo sư", "Phó giáo sư", "Thạc sĩ", "Giảng viên", "Trợ giảng", "Khác"};
        Object[][] data = new Object[arrCapBac.length+1][nameCol.length];
        
        data[0][0] = "Tất cả";
        data[0][1] = "";
        data[0][2] = totalTeacher;
        data[0][3] = "100%";
        for(int i=1;i<arrCapBac.length;i++){
            data[i][0] = arrCapBac[i];
            data[i][1] = luongGV[i];
            data[i][2] = demSoLuongGiangVienTheoTrinhDo(dsTeacher, arrCapBac[i]);
            DecimalFormat df = new DecimalFormat("#.##");
            data[i][3] = df.format(((demSoLuongGiangVienTheoTrinhDo(dsTeacher, arrCapBac[i])*1.0 / totalTeacher) * 100)) + "%";
        }
        new ShowListView(nameCol, data).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String[] nameCol = {"ID","Tên khóa học","Doanh thu ban đầu","Tổng lương giảng viên","Thực thu"};
        List<KhoaHoc> dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
        
        Map<String, Double> salaryMap = new HashMap<>();
        salaryMap.put("Tiến sĩ", 25000000.0);
        salaryMap.put("Giáo sư", 21500000.0);
        salaryMap.put("Phó giáo sư", 18000000.0);
        salaryMap.put("Thạc sĩ", 13500000.0);
        salaryMap.put("Giảng viên", 8000000.0);
        salaryMap.put("Trợ giảng", 5000000.0);
        salaryMap.put("Khác", null);
        
        Object[][] data = new Object[dsKH.size()][nameCol.length];
        for(int i=0;i<dsKH.size();i++){
            data[i][0] = dsKH.get(i).getId();
            data[i][1] = dsKH.get(i).getTenKhoaHoc();
            DecimalFormat df = new DecimalFormat("#.#");
            double doanhThuBanDau = dsKH.get(i).getGiaKhoaHoc() * dsKH.get(i).getDsStudent().size();
            data[i][2] = df.format(doanhThuBanDau) + " VNĐ";
            
            double sumSalary = 0;
            for(Teacher gv : dsKH.get(i).getDsTeacher()){
                sumSalary += salaryMap.get(gv.getTrinhDo());
            }
            data[i][3] = df.format(sumSalary) + " VNĐ";
            data[i][4] = df.format(doanhThuBanDau - sumSalary) + " VNĐ";
        }
        new ShowListView(nameCol, data).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
