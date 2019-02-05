/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
/**
 *
 * @author STUDENT
 */

public class Sample {

    /**
     * @param args the command line arguments
     */
     final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
   final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    //  Database credentials
   final String USER = "system";
   final String PASS = "student";
    Connection conn = null;
    Statement stmt = null;
    int rows;
    ResultSet rs=null;
    CallableStatement cs=null;
    String temp="";
        public void connect(String str) {
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
                
               stmt.executeUpdate(str);
               stmt.executeUpdate(cm);
               System.out.println("Executed query");
               rows=stmt.executeUpdate(str);
               System.out.println(rows);
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
        }
    public void query(String query,String u,String p,String m,String e,String n,String x){
        
        try{
               
               //STEP 2: Register JDBC driver
               Class.forName("oracle.jdbc.OracleDriver");

               //STEP 3: Open a connection
               System.out.println("Connecting to a selected database...");
               conn = DriverManager.getConnection(DB_URL, USER, PASS);
               System.out.println("Connected database successfully...");

               //STEP 4: Execute a query
               
               try {
                   System.out.println("Entering try");
                   stmt = conn.createStatement();
                   cs=conn.prepareCall(query);
                    cs.setString(1,u);
                   cs.setString(2,p);
                   cs.setString(3,m);
                   cs.setString(4,e);
                   cs.setString(5,n);
                   cs.registerOutParameter(6,Types.VARCHAR);
                   cs.setString(6,x);
                   cs.execute();
                   temp=cs.getString(6);
                   String cm="commit";
                   stmt.executeUpdate(cm);
                   System.out.println("Executed query");
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
    }
    public void cm(){
        
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
                
               stmt.executeUpdate(cm);
               System.out.println("Commit Complete");
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
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Sample samp=new Sample();
        HomePage hp=new HomePage();
        hp.setVisible(true);
    }
    
}
