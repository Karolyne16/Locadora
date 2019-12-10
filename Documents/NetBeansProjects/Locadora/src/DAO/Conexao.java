/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Conexao {
    
    public static Connection AbrirConecao() {
        Connection con = null;
        try {
              Class.forName("com.mysql.jdbc.Driver");
              String url = "jdbc:mysql://localhost/locadora";
              con = DriverManager.getConnection(url, "root", "");
              
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Erro na Conexão com o Banco ",
                            "Video Locadora",JOptionPane.ERROR_MESSAGE);
               e.getMessage();
        }
        return con;      
  }
         
  public static void FecharConexao (Connection con){
      try {
          con.close();
          
      }catch (Exception e) {
          System.out.print(e.getMessage());
      }
              
}

    public static Connection AbrirConexao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
