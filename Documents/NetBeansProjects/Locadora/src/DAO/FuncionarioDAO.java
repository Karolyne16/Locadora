/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO extends ExecuteSQL {
    
    public FuncionarioDAO(Connection con){
        super(con);
    }
    public boolean Logar (String login, String senha){
       boolean finalResult = false;
       try {
          String consulta = "select login, senha from funcionario"
        + "where login = '"+ login + "' and senha = '" + senha + "'";
          PreparedStatement ps = getCon().preparedStatement (consulta);
          ResultSEt rs = ps.executeQuery();
          
          if (rs != null){
              while (rs.next()){
                  Funcionaio a = new Funcionario();
                  a.setLogin(rs.getString(1));
                  a.serSenha(rs.getString(2));
                  finalResult = true;
              }
          }
     } catch (SQLException ex) {
      ex.getMessage();
     }
     return finalResult;
             
    }}
