package view;

import controller.TrungTamController;
import entity.KhoaHoc;
import entity.Person;
import entity.Student;
import entity.Teacher;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ShowListView extends javax.swing.JFrame {
    private Person person;
    private KhoaHoc kh;
    private KhoaHocView khView;

    public ShowListView(String[] columnNames, Object[][] datas) {
        initComponents();
        table.setModel(new DefaultTableModel(datas,columnNames));
        this.remove(pnButton);
    }
    public ShowListView(Person person, KhoaHoc kh,KhoaHocView khView,String[] columnNames, Object[][] datas) {
        initComponents();
        table.setModel(new DefaultTableModel(datas,columnNames));
        this.person = person;
        this.kh = kh;
        this.khView = khView;
        if(kh.checkContainsStudent(person)){
            this.remove(pnButton);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        pnButton = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 650));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 500));

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

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1);

        pnButton.setPreferredSize(new java.awt.Dimension(600, 100));
        pnButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        jButton1.setText("Chọn");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnButton.add(jButton1);

        getContentPane().add(pnButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int dong = table.getSelectedRow();
        List<Student> dsStudent = TrungTamController.Instance().getStudentFunc().getListStudents();
        if(dong!=-1){
            for(Student st : dsStudent){
                if(st.getId()==person.getId()){
                    kh.addStudent(st);
                    TrungTamController.Instance().getKhoaHocFunc().edit(kh);
                    st.setNumKhoaHoc(1);
                    TrungTamController.Instance().getStudentFunc().edit(st);
                    for(Teacher teacher : kh.getDsTeacher()){
                        if(teacher.getId()==(int)table.getValueAt(dong, 0)){
                            teacher.addStudent(st);
                            TrungTamController.Instance().getTeacherFunc().edit(teacher);
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
                    khView.resetData();
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
