package viewtrainer;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ModelTrainer;

/**
 *
 * @author Imelda Maretta Putri
 * F11.2022.00053
 */
public class ReadTrainer extends javax.swing.JFrame {
    
    private Connection con;
    
    /**
     * Creates new form ReadTrainer
     */
    public ReadTrainer() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTersimpan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Trainer Data");

        tTersimpan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tTersimpan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(223, 223, 223))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(455, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(68, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/membership","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InsertTrainer.class.getName()).log(Level.SEVERE, null, ex);
        }
        ModelTrainer tr = new ModelTrainer(con);
        
        tTersimpan.setModel(tr.dataModel());
        
// Warna Tabel
        
        tTersimpan.getColumnModel().getColumn(1).setCellRenderer(
                new DefaultTableCellRenderer(){
                    @Override
                    public Component getTableCellRendererComponent(JTable table,
                            Object value, boolean isSelected, boolean hasFocus, int row, int column){
                        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        
                        if (value.equals("Hermann")){
                            cell.setBackground(Color.RED);
                            cell.setForeground(Color.WHITE);
                        } else if (value.equals("Ivan")){
                            cell.setBackground(Color.YELLOW);
                            cell.setForeground(Color.BLACK);
                        } else if (value.equals("Dmitry")){
                            cell.setBackground(Color.ORANGE);
                            cell.setForeground(Color.BLACK);
                        } else if (value.equals("Demian")){
                            cell.setBackground(Color.BLUE);
                            cell.setForeground(Color.WHITE);
                        }  else if (value.equals("Natasha")){
                            cell.setBackground(Color.GREEN);
                            cell.setForeground(Color.BLACK);
                        } else {
                            cell.setBackground(Color.WHITE);
                            cell.setForeground(Color.BLACK);
                        }
                        return cell;
                    }
                });

        tTersimpan.getColumnModel().getColumn(2).setCellRenderer(
                new DefaultTableCellRenderer(){
                    @Override
                    public Component getTableCellRendererComponent(JTable table,
                            Object value, boolean isSelected, boolean hasFocus, int row, int column){
                        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        
                        if (value.equals("Power")){
                            cell.setBackground(Color.RED);
                            cell.setForeground(Color.WHITE);
                        } else if (value.equals("Cardio")){
                            cell.setBackground(Color.YELLOW);
                            cell.setForeground(Color.BLACK);
                        } else if (value.equals("Body Building")){
                            cell.setBackground(Color.ORANGE);
                            cell.setForeground(Color.BLACK);
                        } else if (value.equals("Endurance")){
                            cell.setBackground(Color.BLUE);
                            cell.setForeground(Color.WHITE);
                        } else if (value.equals("Yoga")){
                            cell.setBackground(Color.GREEN);
                            cell.setForeground(Color.BLACK);
                        } else {
                            cell.setBackground(Color.WHITE);
                            cell.setForeground(Color.BLACK);
                        }
                        return cell;
                    }
                });

//Progress Bar
        
        tTersimpan.getColumnModel().getColumn(3).setCellRenderer(
                new DefaultTableCellRenderer(){
                    @Override
                    public Component getTableCellRendererComponent(JTable table,
                            Object value, boolean isSelected, boolean hasFocus, int row, int column){
                        Component cell;
                        
                        JProgressBar p = new JProgressBar();
                        p.setMaximum(22);
                        p.setValue((int) value);

                        cell = p;
                        
                        return cell;
                    }
                });
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(ReadTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReadTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReadTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReadTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReadTrainer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tTersimpan;
    // End of variables declaration//GEN-END:variables
}
