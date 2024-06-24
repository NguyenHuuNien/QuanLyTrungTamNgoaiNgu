package view;

import entity.Person;

public class KhoaHocView extends javax.swing.JFrame {
    private Person person;
    public KhoaHocView() {
        initComponents();
        person = new Person(0, "admin", "1/1/0001", "Trung tâm ngoại ngữ TLing");
        
    }
    public KhoaHocView(Person person) {
        initComponents();
        this.person = person;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserInfoPanel = new javax.swing.JPanel();
        avtLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hr1 = new javax.swing.JPanel();
        centerPanel = new javax.swing.JPanel();
        InforPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        hr2 = new javax.swing.JPanel();
        TablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Liberation Mono", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("ID: 1");
        jLabel1.setPreferredSize(new java.awt.Dimension(480, 30));
        jPanel2.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Liberation Mono", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Họ và Tên: Nguyen Huu Nien");
        jLabel2.setPreferredSize(new java.awt.Dimension(480, 30));
        jPanel2.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Liberation Mono", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Ngày sinh: 07/03/2004");
        jLabel3.setPreferredSize(new java.awt.Dimension(480, 30));
        jPanel2.add(jLabel3);

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

        jLabel4.setFont(new java.awt.Font("Liberation Mono", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Thông tin");
        jLabel4.setPreferredSize(new java.awt.Dimension(400, 30));
        InforPanel.add(jLabel4);

        jPanel10.setPreferredSize(new java.awt.Dimension(400, 60));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel7.setText("Ngôn ngữ");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel10.add(jLabel7);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tiếng Anh", "Tiếng Nhật", "Tiếng Hàn", "Tiếng Trung Quốc" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel10.add(jComboBox1);

        InforPanel.add(jPanel10);

        jPanel8.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel5.setText("ID");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel8.add(jLabel5);

        jTextField1.setEnabled(false);
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel8.add(jTextField1);

        InforPanel.add(jPanel8);

        jPanel9.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel6.setText("Họ và Tên");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel9.add(jLabel6);

        jTextField2.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel9.add(jTextField2);

        InforPanel.add(jPanel9);

        jPanel11.setMinimumSize(new java.awt.Dimension(172, 80));
        jPanel11.setPreferredSize(new java.awt.Dimension(400, 80));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel8.setText("Thời lượng");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel11.add(jLabel8);

        jPanel4.setMinimumSize(new java.awt.Dimension(99, 60));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        jLabel16.setText("Từ");
        jLabel16.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel4.add(jLabel16);

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinner4.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel4.add(jSpinner4);

        jLabel17.setText("  Tháng");
        jLabel17.setPreferredSize(new java.awt.Dimension(50, 18));
        jPanel4.add(jLabel17);

        jLabel18.setText("Đến");
        jLabel18.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel4.add(jLabel18);

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinner5.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel4.add(jSpinner5);

        jLabel19.setText("  Tháng");
        jLabel19.setPreferredSize(new java.awt.Dimension(50, 18));
        jPanel4.add(jLabel19);

        jPanel11.add(jPanel4);

        InforPanel.add(jPanel11);

        jPanel12.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel9.setText("Kỹ năng");
        jLabel9.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel12.add(jLabel9);

        jPanel13.setPreferredSize(new java.awt.Dimension(220, 25));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jCheckBox1.setText("Nghe");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel13.add(jCheckBox1);

        jCheckBox2.setText("Nói");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel13.add(jCheckBox2);

        jCheckBox3.setText("Đọc");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel13.add(jCheckBox3);

        jCheckBox4.setText("Viết");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel13.add(jCheckBox4);

        jPanel12.add(jPanel13);

        InforPanel.add(jPanel12);

        jPanel14.setPreferredSize(new java.awt.Dimension(400, 80));
        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel11.setText("Giá");
        jLabel11.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel14.add(jLabel11);

        jPanel1.setMinimumSize(new java.awt.Dimension(99, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        jLabel12.setText("Từ");
        jLabel12.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel1.add(jLabel12);

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 100));
        jSpinner2.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel1.add(jSpinner2);

        jLabel14.setText(" K VNĐ");
        jLabel14.setPreferredSize(new java.awt.Dimension(50, 18));
        jPanel1.add(jLabel14);

        jLabel13.setText("Đến");
        jLabel13.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel1.add(jLabel13);

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 100));
        jSpinner3.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel1.add(jSpinner3);

        jLabel15.setText(" K VNĐ");
        jLabel15.setPreferredSize(new java.awt.Dimension(50, 18));
        jPanel1.add(jLabel15);

        jPanel14.add(jPanel1);

        InforPanel.add(jPanel14);

        jButton2.setText("Tìm kiếm");
        InforPanel.add(jButton2);

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
        TablePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(950, 600));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        TablePanel.add(jScrollPane1);

        jButton1.setText("jButton1");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 24));
        TablePanel.add(jButton1);

        centerPanel.add(TablePanel);

        getContentPane().add(centerPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InforPanel;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JPanel UserInfoPanel;
    private javax.swing.JLabel avtLabel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel hr1;
    private javax.swing.JPanel hr2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
