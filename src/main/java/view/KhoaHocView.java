

import controller.TrungTamController;
import entity.KhoaHoc;
import entity.Person;
import entity.Student;
import entity.Teacher;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class KhoaHocView extends javax.swing.JFrame {
    private Person person;
    private List<KhoaHoc> dsKH;
    public KhoaHocView() {
        initComponents();
        setViewAdmin();
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
        setEventListener();
        setDataToTable();
    }
    
    private void setViewAdmin() {
        pnThoiLuong.removeAll();
        pnThoiLuong.setPreferredSize(new Dimension(200,25));
        ((FlowLayout)pnThoiLuong.getLayout()).setVgap(0);
        JLabel lbThang = new JLabel("  Tháng");
        lbThang.setPreferredSize(new Dimension(50,18));
        spnThang = new JSpinner(new SpinnerNumberModel(0,1,null,1));
        spnThang.setPreferredSize(new Dimension(60,25));
        pnThoiLuong.add(spnThang); 
        pnThoiLuong.add(lbThang);
        pnThoiLuongBig.setPreferredSize(new Dimension(400, 40));
        
        pnGia.removeAll();
        pnGia.setPreferredSize(new Dimension(200,25));
        ((FlowLayout)pnGia.getLayout()).setVgap(0);
        JLabel lbGia = new JLabel("  VNĐ");
        lbGia.setPreferredSize(new Dimension(50,18));
        spnGia = new JSpinner(new SpinnerNumberModel(0,0,null,100000));
        spnGia.setPreferredSize(new Dimension(120,25));
        pnGia.add(spnGia);
        pnGia.add(lbGia);
        pnGiaBig.setPreferredSize(new Dimension(400, 40));
        
        pnButton.removeAll();
        btnThem.setSize(new Dimension(90,24));
        btnSua.setSize(new Dimension(90,24));
        btnSua.setEnabled(false);
        btnXoa.setSize(new Dimension(90,24));
        btnXoa.setEnabled(false);
        btnLamMoi.setSize(new Dimension(90,24));
        pnButton.add(btnThem);
        pnButton.add(btnSua);
        pnButton.add(btnXoa);
        pnButton.add(btnLamMoi);
    }
    private void setDataToTable() {
        // định nghĩa các cột của bảng student
        String [] columnNames = new String [] {
            "ID", "Tên khóa học", "Ngôn ngữ", "Kỹ năng", "Thời lượng học","Giá"};
        dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
        Object[][] data = new Object [dsKH.size()][6];
        for(int i=0;i<dsKH.size();i++){
            data[i][0] = dsKH.get(i).getId();
            data[i][1] = dsKH.get(i).getTenKhoaHoc();
            data[i][2] = dsKH.get(i).getNgonNgu();
            data[i][3] = dsKH.get(i).getSkill();
            data[i][4] = dsKH.get(i).getThoiGianKhoaHoc();
            data[i][5] = dsKH.get(i).getGiaKhoaHoc();
        }
        table.setModel(new DefaultTableModel(data,columnNames));
    }
    private void setEventListener(){
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
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    selectKhoaHocInTableListener();
                }
            }
        });
        btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addThemBtnListener();
            }
        });
        btnLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addLamMoiBtnListener();
            }
            
        });
        btnXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addXoaBtnListener();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSuaBtnListener();
            }
        });
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTimKiemListener();
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
            
            cbNgonNgu.setSelectedItem(kh.getNgonNgu());
            txtID.setText(kh.getId()+"");
            txtTenKhoaHoc.setText(kh.getTenKhoaHoc());
            if(spnThang!=null){
                spnThang.setValue(kh.getThoiGianKhoaHoc());
            }
            if(spnGia!=null){
                spnGia.setValue(kh.getGiaKhoaHoc());
            }
            checkNghe.setSelected(kh.getSkill().contains("Nghe"));
            checkNoi.setSelected(kh.getSkill().contains("Nói"));
            checkDoc.setSelected(kh.getSkill().contains("Đọc"));
            checkViet.setSelected(kh.getSkill().contains("Viết"));
            btnThem.setEnabled(false);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }
    }
    private void addTimKiemListener(){
        
    }
    private void addThemBtnListener(){
        KhoaHoc kh = new KhoaHoc();
        if(!cbNgonNgu.getSelectedItem().equals("Tất cả"))
            kh.setNgonNgu(cbNgonNgu.getSelectedItem().toString());
        else{
            showMessage("Vui lòng chọn ngôn ngữ");
            return;
        }
        if(txtTenKhoaHoc!=null&&txtTenKhoaHoc.getText().length()!=0)
            kh.setTenKhoaHoc(txtTenKhoaHoc.getText());
        if((int)spnThang.getValue()!=0)
            kh.setThoiGianKhoaHoc((int)spnThang.getValue());
        String s = (checkNghe.isSelected() ? "Nghe " : "") +
           (checkNoi.isSelected() ? "Nói " : "") +
           (checkDoc.isSelected() ? "Đọc " : "") +
           (checkViet.isSelected() ? "Viết " : "");
        if(!s.isBlank())
            kh.setSkill(s);
        if((int)spnGia.getValue()!=0)
            kh.setGiaKhoaHoc((int)spnGia.getValue());
        TrungTamController.Instance().getKhoaHocFunc().add(kh);
        setDataToTable();
    }
    private void addSuaBtnListener(){
        int id = Integer.parseInt(txtID.getText());
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getId()==id){
                dsKH.get(i).setNgonNgu(cbNgonNgu.getSelectedItem().toString());
                dsKH.get(i).setTenKhoaHoc(txtTenKhoaHoc.getText());
                dsKH.get(i).setGiaKhoaHoc(Double.parseDouble(spnGia.getValue().toString()));
                dsKH.get(i).setThoiGianKhoaHoc(Integer.parseInt(spnThang.getValue().toString()));
                dsKH.get(i).setSkill((checkNghe.isSelected() ? "Nghe " : "") +
                                    (checkNoi.isSelected() ? "Nói " : "") +
                                    (checkDoc.isSelected() ? "Đọc " : "") +
                                    (checkViet.isSelected() ? "Viết " : ""));
                TrungTamController.Instance().getKhoaHocFunc().edit(dsKH.get(i));
                
            }
        }
        setDataToTable();
    }
    private void addXoaBtnListener(){
        int id = Integer.parseInt(txtID.getText());
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getId()==id){
                TrungTamController.Instance().getKhoaHocFunc().delete(dsKH.get(i));
                setDataToTable();
                break;
            }
        }
    }
    private void addLamMoiBtnListener(){
        cbNgonNgu.setSelectedIndex(0);
        txtID.setText("");
        txtTenKhoaHoc.setText("");
        spnGia.setValue(0);
        spnThang.setValue(0);
        checkDoc.setSelected(false);
        checkNghe.setSelected(false);
        checkNoi.setSelected(false);
        checkViet.setSelected(false);
        table.clearSelection();
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(true);
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
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbNgonNgu = new javax.swing.JComboBox<>();
        pnAllTimKiem = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTenKhoaHoc = new javax.swing.JTextField();
        pnThoiLuongBig = new javax.swing.JPanel();
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
        pnGiaBig = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnGia = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        spinFromGia = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spinToGia = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        pnButton = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        btnDangKy = new javax.swing.JButton();
        pnKhac = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 850));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 820));
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

        jPanel10.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        jLabel7.setText("Ngôn ngữ");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel10.add(jLabel7);

        cbNgonNgu.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        cbNgonNgu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tiếng Anh", "Tiếng Nhật", "Tiếng Hàn", "Tiếng Trung Quốc" }));
        cbNgonNgu.setPreferredSize(new java.awt.Dimension(200, 25));
        cbNgonNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNgonNguActionPerformed(evt);
            }
        });
        jPanel10.add(cbNgonNgu);

        InforPanel.add(jPanel10);

        pnAllTimKiem.setPreferredSize(new java.awt.Dimension(400, 50));
        pnAllTimKiem.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 50, 5));

        jToggleButton1.setBackground(new java.awt.Color(204, 204, 204));
        jToggleButton1.setForeground(new java.awt.Color(102, 102, 255));
        jToggleButton1.setText("Mode Quản lý");
        jToggleButton1.setPreferredSize(new java.awt.Dimension(120, 24));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        pnAllTimKiem.add(jToggleButton1);

        InforPanel.add(pnAllTimKiem);

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

        InforPanel.add(jPanel8);

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

        InforPanel.add(jPanel9);

        pnThoiLuongBig.setMinimumSize(new java.awt.Dimension(172, 80));
        pnThoiLuongBig.setPreferredSize(new java.awt.Dimension(400, 80));
        pnThoiLuongBig.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel8.setText("Thời lượng");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 25));
        pnThoiLuongBig.add(jLabel8);

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

        pnThoiLuongBig.add(pnThoiLuong);

        InforPanel.add(pnThoiLuongBig);

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

        pnGiaBig.setPreferredSize(new java.awt.Dimension(400, 80));
        pnGiaBig.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel11.setText("Giá");
        jLabel11.setPreferredSize(new java.awt.Dimension(80, 25));
        pnGiaBig.add(jLabel11);

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

        pnGiaBig.add(pnGia);

        InforPanel.add(pnGiaBig);

        pnButton.setPreferredSize(new java.awt.Dimension(400, 40));
        pnButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 3));

        btnTimKiem.setText("Tìm kiếm");
        pnButton.add(btnTimKiem);

        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        pnButton.add(btnDangKy);

        InforPanel.add(pnButton);

        pnKhac.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Liberation Mono", 1, 18), new java.awt.Color(0, 51, 255))); // NOI18N
        pnKhac.setPreferredSize(new java.awt.Dimension(400, 150));
        pnKhac.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel10.setText("Tài liệu");
        jLabel10.setPreferredSize(new java.awt.Dimension(150, 18));
        pnKhac.add(jLabel10);

        btnShowTaiLieu.setText("Xem tài liệu");
        btnShowTaiLieu.setPreferredSize(new java.awt.Dimension(180, 24));
        pnKhac.add(btnShowTaiLieu);

        jLabel20.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel20.setText("Danh sách sinh viên");
        jLabel20.setPreferredSize(new java.awt.Dimension(150, 18));
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
        jLabel21.setPreferredSize(new java.awt.Dimension(150, 18));
        pnKhac.add(jLabel21);

        jButton5.setText("Xem DS Giảng viên");
        jButton5.setPreferredSize(new java.awt.Dimension(180, 24));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        pnKhac.add(jButton5);

        InforPanel.add(pnKhac);

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

    private void txtTenKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhoaHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhoaHocActionPerformed

    private void cbNgonNguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNgonNguActionPerformed
        if(dsKH==null) return;
        if(cbNgonNgu.getSelectedItem().equals("Tất cả")){
            dsKH = TrungTamController.Instance().getKhoaHocFunc().getListKhoaHoc();
        }else{
            for(int i=0;i<dsKH.size();i++){
                if(!dsKH.get(i).getNgonNgu().equals(cbNgonNgu.getSelectedItem())){
                    dsKH.remove(dsKH.get(i));
                }
            }
        }
        if(txtID.getText().isBlank()){
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            btnThem.setEnabled(true);
        }else{
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
            btnThem.setEnabled(false);
        }
    }//GEN-LAST:event_cbNgonNguActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        KhoaHoc kh = new KhoaHoc();
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getId()==Integer.parseInt(txtID.getText())){
                kh = dsKH.get(i);
                break;
            }
        }
        if(person.getRole().startsWith("S")){
            List<Student> dsSV = TrungTamController.Instance().getStudentFunc().getListStudents();
            for(int i=0;i<dsSV.size();i++){
                if(person.getId()==dsSV.get(i).getId()){
                    dsSV.get(i).addKhoaHoc(kh);
                    TrungTamController.Instance().getStudentFunc().edit(dsSV.get(i));
                    showMessage("Đăng ký thành công!");
                    break;
                }
            }
        }else{
            List<Teacher> dsGV = TrungTamController.Instance().getTeacherFunc().getListTeachers();
            for(int i=0;i<dsGV.size();i++){
                if(person.getId()==dsGV.get(i).getId()){
                    dsGV.get(i).addKhoaHoc(kh);
                    TrungTamController.Instance().getTeacherFunc().edit(dsGV.get(i));
                    showMessage("Đăng ký thành công!");
                    break;
                }
            }
        }
        setDataToTable();
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        System.out.print("WTF");
    }//GEN-LAST:event_jToggleButton1ActionPerformed


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
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel pnAllTimKiem;
    private javax.swing.JPanel pnButton;
    private javax.swing.JPanel pnGia;
    private javax.swing.JPanel pnGiaBig;
    private javax.swing.JPanel pnKhac;
    private javax.swing.JPanel pnKyNang;
    private javax.swing.JPanel pnThoiLuong;
    private javax.swing.JPanel pnThoiLuongBig;
    private javax.swing.ButtonGroup rdoGroupLoc;
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
    private JSpinner spnThang;
    private JSpinner spnGia;
    private JButton btnThem = new JButton("Thêm");;
    private JButton btnSua = new JButton("Sửa");;
    private JButton btnXoa = new JButton("Xóa");;
    private JButton btnLamMoi = new JButton("Làm mới");;
}
