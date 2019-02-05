/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import static java.awt.Color.orange;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Mahe
 */
public class Table extends javax.swing.JFrame {

    /**
     * Creates new form Table
     * @param temp
     */
    
    Sample samp=new Sample();
    final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
   final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    //  Database credentials
   final String USER = "system";
   final String PASS = "student";
    Connection conn = null;
    Statement stmt = null;
    int rows;
    String sql="";
    DefaultTableModel model;
    public Table(String temp) {
        initComponents();
        getContentPane().setBackground(orange);
        if (temp.equals("Student")){
         sql="select * from student";
         model = new DefaultTableModel(new String[]{"Reg No.", "Username", "Password","Branch","Gender","Package","Address","Mobile","Email","College","Year","Semester","Name"}, 0);
        
        }
        if (temp.equals("Teaching_Staff")){
         sql="select * from Teaching_staff";
         model = new DefaultTableModel(new String[]{"Email", "Password", "Dob","Gender","Address","Mobile","Department","Name","Username","Package"}, 0);
        }
        if (temp.equals("Non_Teaching_Staff")){
         sql="select * from non_teaching_staff";
         model = new DefaultTableModel(new String[]{"Employee_id", "Password", "Dob","Gender","Package","Address","Mobile","Employee_dept","Name","Email","Username"}, 0);
        }
        if (temp.equals("Payment")){
         sql="select * from payment";
         model=new DefaultTableModel(new String[]{"Amount","Method_of_pay","Name","Username","Package"},0);
        }
        if (temp.equals("Package")){
         sql="select * from package";
         model=new DefaultTableModel(new String[]{"Package","Name","Mobile","Email","Type of login","Username"},0);
        }
        if (temp.equals("Sports")){
         sql="select * from sports";
         model=new DefaultTableModel(new String[]{"Name","Level","Requirements"},0);
        }
        if (temp.equals("Delusers")){
         sql="select * from delusers";
         model=new DefaultTableModel(new String[]{"Username","Name","Package"},0);
        }
        try{
               //STEP 2: Register JDBC driver
               Class.forName("oracle.jdbc.OracleDriver");

               //STEP 3: Open a connection
               System.out.println("Connecting to a selected database...");
               conn = DriverManager.getConnection(DB_URL, USER, PASS);
               System.out.println("Connected database successfully...");

               //STEP 4: Execute a query
               
               try {
                   
                   stmt = conn.createStatement();
                   System.out.println("Entering try");
                String cm="commit";
                
               ResultSet rs=stmt.executeQuery(sql);
               if (temp.equals("Student")){
               while (rs.next()){
                   String d = rs.getString("Reg_no");
                   String e = rs.getString("Username_s");
                   String f = rs.getString("Password_s");
                   String g = rs.getString("Branch");
                   String h = rs.getString("Gender_s");
                   String i = rs.getString("Package_s");
                   String j = rs.getString("Address_s");
                   String k = rs.getString("Mobile_s");
                   String l = rs.getString("Stud_Email");
                   String m = rs.getString("College");
                   String n = rs.getString("Year");
                   String o = rs.getString("Semester");
                   String p = rs.getString("Name_s");
                   model.addRow(new Object[]{d, e, f,g,h,i,j,k,l,m,n,o,p});
               }
               }
               else if(temp.equals("Teaching_Staff")){
                    while (rs.next()){
                   String d = rs.getString("Email_Id");
                   String e = rs.getString("Password_Ts");
                   String f = rs.getString("Dob_TS");
                   String g = rs.getString("Gender_TS");
                   String h = rs.getString("Address_ts");
                   String i = rs.getString("Mobile_ts");
                   String j = rs.getString("Department");
                   String k = rs.getString("Name_ts");
                   String l = rs.getString("Username_ts");
                   String m = rs.getString("Package_ts");
                   model.addRow(new Object[]{d, e, f,g,h,i,j,k,l,m});
               }
                       
              }
               else if(temp.equals("Non_Teaching_Staff")){
                    while (rs.next()){
                   String d = rs.getString("Employee_Id");
                   String e = rs.getString("Password_NTs");
                   String f = rs.getString("Dob_nTS");
                   String g = rs.getString("Gender_nTS");
                   String h = rs.getString("Package_nts");
                   String i = rs.getString("Address_nts");
                   String j = rs.getString("mobile_nts");
                   String k = rs.getString("employee_dept");
                   String l = rs.getString("name_nts");
                   String m = rs.getString("email_id_nts");
                   String n = rs.getString("username_nts");
                   model.addRow(new Object[]{d, e, f,g,h,i,j,k,l,m,n});
               }
                       
              }
               else if(temp.equals("Payment")){
                    while (rs.next()){
                   String d = rs.getString("amount");
                   String e = rs.getString("Method_of_pay");
                   String f = rs.getString("name_p");
                   String g = rs.getString("username_p");
                   String h = rs.getString("package_pay");
                   model.addRow(new Object[]{d, e, f,g,h});
               }
                       
              }
               else if(temp.equals("Package")){
                    while (rs.next()){
                   String d = rs.getString("Package_id");
                   String e = rs.getString("name_pa");
                   String f = rs.getString("mobile");
                   String g = rs.getString("email");
                   String h = rs.getString("type_of_login");
                   String i = rs.getString("username_pa");
                   model.addRow(new Object[]{d, e, f,g,h,i});
               }
                       
              }
               else if(temp.equals("Sports")){
                    while (rs.next()){
                   String d = rs.getString("sport_name");
                   String e = rs.getString("floor");
                   String f = rs.getString("requirements");
                   model.addRow(new Object[]{d, e, f});
               }
                       
              }
               else if(temp.equals("Delusers")){
                   while (rs.next()){
                   String d=rs.getString("Username");
                   String e=rs.getString("Name");
                   String f=rs.getString("Package");
                   model.addRow(new Object[]{d,e,f});
                   }
                   
               }
            
               stmt.executeUpdate(cm);
               
               }catch(SQLException se) {
                   System.out.println(se);
               }
               

            }catch(SQLException | ClassNotFoundException se){
                //Handle errors for JDBC
                        System.out.println(se);
            }
            //Handle errors for Class.forName
            finally{
               //finally block used to close resources
               try{
                  if(stmt!=null)
                     conn.close();
               }catch(SQLException se){
               }// do nothing
               try{
                  if(conn!=null)
                     conn.close();
               }catch(SQLException se){
               }//end finally try
            }//end try
          this.jTable1.setModel(model);
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
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1800, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
