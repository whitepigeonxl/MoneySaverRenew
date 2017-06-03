
package moneysaverrenew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ShowProfile extends javax.swing.JFrame {

  
    public ShowProfile() {
        initComponents();
        show_profile();
    }
    
    public ArrayList<ProfileSaving> profileList(){
        ArrayList<ProfileSaving> profilesList = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moneysaver?zeroDateTimeBehavior=convertToNull", "root", "");
            String query1 ="SELECT * FROM  DATAPROFILE";
            PreparedStatement ps = con.prepareStatement(query1);
            ResultSet rs = ps.executeQuery();
            ProfileSaving pfs;
            while(rs.next()){
                pfs = new ProfileSaving(rs.getInt("iddataprofile"),rs.getString("name"),rs.getString("lname"),rs.getFloat("income"),rs.getFloat("outcome"),rs.getString("date"),rs.getDouble("saving"));
                profilesList.add(pfs);
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return profilesList;
        
    }
    public void show_profile(){
        ArrayList<ProfileSaving> list = profileList();
        DefaultTableModel model = (DefaultTableModel)Table_Profile.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).getIddataprofile();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getLname();
            row[3] = list.get(i).getIncome();
            row[4] = list.get(i).getOutcome();
            row[5] = list.get(i).getDate();
            row[6] = list.get(i).getSaving();
            model.addRow(row);
            
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Profile = new javax.swing.JTable();

        setTitle("Profile Table");
        setMaximumSize(new java.awt.Dimension(641, 457));
        setResizable(false);

        Table_Profile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "iddataprofile", "name", "lname", "income", "outcome", "date"
            }
        ));
        Table_Profile.setMaximumSize(new java.awt.Dimension(641, 457));
        Table_Profile.setMinimumSize(new java.awt.Dimension(641, 457));
        jScrollPane1.setViewportView(Table_Profile);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_Profile;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
