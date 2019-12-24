
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ardakaynar
 */
public class Results extends javax.swing.JFrame {

    DefaultTableModel model;
    static Connection con;

    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    /**
     * Creates new form Results
     */
    public void user_delete(String username) {
        Connection con = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        String sorgu = "DELETE FROM admin where username = ? ";
        try {

            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ardakaynar", "root", "1234");
            preparedStatement = con.prepareCall(sorgu);
            preparedStatement.setString(1, username);

            preparedStatement.executeUpdate();
            model = (DefaultTableModel) jTable.getModel();

            model.setRowCount(0);

            ArrayList<admin> show_me = new ArrayList<admin>();

            show_me = adminGetir();

            if (show_me != null) {

                for (admin baglanti : show_me) {

                    Object[] eklenecek = {baglanti.getName(), baglanti.getGender(), baglanti.getFname(), baglanti.getPassword()};
                    model.addRow(eklenecek);
                }

            }

        } catch (SQLException ex) {

            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void user_update(String username,String n_username, String n_password, String n_fullname, String n_gender) {
        
        Connection con = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        String sorgu = "UPDATE admin SET username = ?,password = ?,fullname = ? ,gender = ? where username = ? ";
        try {

            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ardakaynar", "root", "1234");
            preparedStatement = con.prepareCall(sorgu);
            preparedStatement.setString(1, n_username);
           
            preparedStatement.setString(2, n_password);
            preparedStatement.setString(3, n_fullname);
            preparedStatement.setString(4, n_gender);

            preparedStatement.setString(5, username);

            preparedStatement.executeUpdate();
            preparedStatement.close();

            
            

        } catch (SQLException ex) {

            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ArrayList<Kan> kanGetir() {
        ArrayList<Kan> cikti = new ArrayList<Kan>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ardakaynar", "root", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from kan");
            while (rs.next()) {
                String hemogram = rs.getString("hemogram");
                String name = rs.getString("name");
                String rbc = rs.getString("rbc");
                String hgb = rs.getString("hgb");

                cikti.add(new Kan(name, rbc, hemogram, hgb));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return cikti;
    }

    public ArrayList<idrar> idrarGetir() {
        ArrayList<idrar> cikti = new ArrayList<idrar>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ardakaynar", "root", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from idrar");
            while (rs.next()) {
                String pro = rs.getString("pro");
                String name = rs.getString("name");
                String glu = rs.getString("glu");
                String ph = rs.getString("ph");

                cikti.add(new idrar(name, glu, pro, ph));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return cikti;
    }

    public ArrayList<admin> adminGetir() {
        ArrayList<admin> cikti = new ArrayList<admin>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ardakaynar", "root", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin");
            while (rs.next()) {
                String gender = rs.getString("gender");
                String name = rs.getString("username");
                String password = rs.getString("password");
                String fname = rs.getString("fullname");

                cikti.add(new admin(name, gender, password, fname));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return cikti;
    }

    public void kan() {

        model = (DefaultTableModel) jTable.getModel();

        model.setRowCount(0);

        ArrayList<Kan> show_me = new ArrayList<Kan>();

        show_me = kanGetir();

        if (show_me != null) {

            for (Kan baglanti : show_me) {

                Object[] eklenecek = {baglanti.getName(), baglanti.getHemogram(), baglanti.getRbc(), baglanti.getHgb()};
                model.addRow(eklenecek);
            }

        }

    }

    public void idrar() {

        model = (DefaultTableModel) jTable.getModel();

        model.setRowCount(0);

        ArrayList<idrar> show_me = new ArrayList<idrar>();

        show_me = idrarGetir();

        if (show_me != null) {

            for (idrar baglanti : show_me) {

                Object[] eklenecek = {baglanti.getName(), baglanti.getPro(), baglanti.getGlu(), baglanti.getPh()};
                model.addRow(eklenecek);
            }

        }

    }

    public void admin() {

        model = (DefaultTableModel) jTable.getModel();

        model.setRowCount(0);

        ArrayList<admin> show_me = new ArrayList<admin>();

        show_me = adminGetir();

        if (show_me != null) {

            for (admin baglanti : show_me) {

                Object[] eklenecek = {baglanti.getName(), baglanti.getGender(), baglanti.getFname(), baglanti.getPassword()};
                model.addRow(eklenecek);
            }

        }

    }

    public Results() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jComboBox = new javax.swing.JComboBox();
        jButton_Update = new javax.swing.JButton();
        jButton_Deleted = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField_First = new javax.swing.JTextField();
        jTextField_Second = new javax.swing.JTextField();
        jTextField_Third = new javax.swing.JTextField();
        jTextField_Fourth = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        mesaj_yazisi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "test", "test", "test"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(0).setHeaderValue("NAME");
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(1).setHeaderValue("test");
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(2).setHeaderValue("test");
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(3).setHeaderValue("test");
        }

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Kan Sonuçları", "İdrar Sonuçları" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        jButton_Update.setText("Kullanici Güncelle");
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });

        jButton_Deleted.setText("Kullanici Sil");
        jButton_Deleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeletedActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField4.setText("User Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        mesaj_yazisi.setBackground(new java.awt.Color(255, 0, 0));
        mesaj_yazisi.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        mesaj_yazisi.setForeground(new java.awt.Color(255, 0, 51));
        mesaj_yazisi.setText("HOŞGELDİNİZ.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesaj_yazisi, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesaj_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_First)
                            .addComponent(jTextField_Second)
                            .addComponent(jTextField_Third)
                            .addComponent(jTextField_Fourth, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Update, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jButton_Deleted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField_First)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Second, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_Third))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_Fourth)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_Deleted, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)))))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        if (jComboBox.getSelectedItem() == "Kan Sonuçları") {
            jTextField1.setText("Hemogram");
            jTextField2.setText("Rbc");
            jTextField3.setText("Hgb");

            JTableHeader th = jTable.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            TableColumn tc = tcm.getColumn(1);
            tc.setHeaderValue("HEMOGRAM");
            tc = tcm.getColumn(2);
            tc.setHeaderValue("RBC");
            tc = tcm.getColumn(3);
            tc.setHeaderValue("HGB");
            kan();
        } else if (jComboBox.getSelectedItem() == "İdrar Sonuçları") {
            jTextField1.setText("Pro");
            jTextField2.setText("Glu");
            jTextField3.setText("pH");

            JTableHeader th = jTable.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            TableColumn tc = tcm.getColumn(1);
            tc.setHeaderValue("PRO");
            tc = tcm.getColumn(2);
            tc.setHeaderValue("GLU");
            tc = tcm.getColumn(3);
            tc.setHeaderValue("PH");
            idrar();
        } else if (jComboBox.getSelectedItem() == "Admin") {
            jTextField1.setText("Password");
            jTextField2.setText("Full Name");
            jTextField3.setText("Gender");

            JTableHeader th = jTable.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            TableColumn tc = tcm.getColumn(1);
            tc.setHeaderValue("PASSWORD");
            tc = tcm.getColumn(2);
            tc.setHeaderValue("FULL NAME");
            tc = tcm.getColumn(3);
            tc.setHeaderValue("GENDER");
            admin();
        }

    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int selectedRow = jTable.getSelectedRow();
        jTextField_First.setText(model.getValueAt(selectedRow, 0).toString());
        jTextField_Second.setText(model.getValueAt(selectedRow, 1).toString());
        jTextField_Third.setText(model.getValueAt(selectedRow, 2).toString());
        jTextField_Fourth.setText(model.getValueAt(selectedRow, 3).toString());
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton_DeletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeletedActionPerformed
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow == -1) {
            if (model.getRowCount() == 0) {
                mesaj_yazisi.setText("Tablo Şu Anda Boş..");
            } else {
                mesaj_yazisi.setText("Lütfen Silinecek Kullanıcı Seçiniz");
            }
        } else {
            String username = (String) model.getValueAt(selectedRow, 0);

            user_delete(username);
            mesaj_yazisi.setText("Başarıyla Silindi...");
        }

    }//GEN-LAST:event_jButton_DeletedActionPerformed

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
        int selectedRow = jTable.getSelectedRow();
        String n_username = jTextField_First.getText();
        String n_password= jTextField_Second.getText();
        String n_fullname = jTextField_Third.getText();
        String n_gender = jTextField_Fourth.getText();
        if (selectedRow == -1) {
            if (model.getRowCount() == 0) {
                mesaj_yazisi.setText("Tablo Şu Anda Boş..");
            } else {
                mesaj_yazisi.setText("Lütfen Güncellenecek Kullanıcı Seçiniz");
            }
        } else {
            String username = (String) model.getValueAt(selectedRow, 0);

            user_update(username,n_username,n_password, n_fullname,n_gender);
            mesaj_yazisi.setText("Başarıyla Güncellendi...");
        }
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Results().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Deleted;
    private javax.swing.JButton jButton_Update;
    private javax.swing.JComboBox jComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField_First;
    private javax.swing.JTextField jTextField_Fourth;
    private javax.swing.JTextField jTextField_Second;
    private javax.swing.JTextField jTextField_Third;
    private javax.swing.JLabel mesaj_yazisi;
    // End of variables declaration//GEN-END:variables
}
