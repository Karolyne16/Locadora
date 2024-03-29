/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import modelo.Filme;


/**
 *
 * @author Karol
 */
public class FilmeDAO extends ExecuteSQL{

    public FilmeDAO(Connection con) {
        super(con);
    }
    
     public List<Filme> Pesquisar_Cod_Filme(int cod){
    String sql = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao,"
            +"capa from filme whhere idfilme = '" + cod + "'";
        List<Filme> lista = new ArrayList<>();
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           if(rs != null){
            while (rs.next()){
                Filme a = new Filme();
                a.setCodigo(rs.getInt(1));
                a.setTitulo(rs.getString(2));
                a.setAno(rs.getInt(3));
                a.setDuracao(rs.getString(4));
                a.setCod_categoria(rs.getInt(5));
                a.setCod_classificao(rs.getInt(6));
                a.setCapa(rs.getString(7));
                lista.add(a);
                }
            return lista;
            }else{
               return null;
                  }
        } catch (SQLException e){
            return null;
        }
        }
       public String Inserir_Filme(Filme a) throws SQLException{
       String sql = "insert into filme values(0,?,?,?,?,?,?)";
       try{
           PreparedStatement ps = getCon().prepareStatement(sql);
           
           ps.setInt(1, a.getCodigo());
           ps.setString(2, a.getTitulo());
           ps.setInt(3,a.getAno());
           ps.setString(4,a.getDuracao());
           ps.setInt(5,a.getCod_categoria());
           ps.setInt(6,a.getCod_classificao());
           ps.setString(7,a.getCapa());
           
           
           if (ps.executeUpdate() > 0){
               return "inserido com sucesso";
           } else {
               return "Erro ao inserir";
           }
       } catch (SQLException e){
           return e.getMessage();
       }
   } 
 
 public List<Filme> ListarFilme(){
        String sql = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao,capa from filme";
        List<Filme> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null) {
                while (rs.next()){
                   Filme a= new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificao(rs.getInt(6));
                    a.setCapa(rs.getString(7));
                    lista.add(a);
                  }
                return lista;
            }else{
                return null;
                
            }
        } catch (SQLException e) {
            return null;
        }
    }
 
  
  public boolean Testar_Filme(int cod){
      boolean Resultado = false;
      try{
      
      String sql = "select * from filme where idfilme ="+cod+"";
      PreparedStatement ps = getCon().prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      
      if(rs != null){
          while(rs.next()){
              Resultado = true;
          }
          
      }
      
      }catch(SQLException ex){
          ex.getMessage();
      }
      
        return Resultado;
      
  }
  
  public List<Filme> CapturarFilme(int cod){
      String sql = "select * from filme where idfilme ="+ cod +"";
      List<Filme> lista = new ArrayList();
      try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          if(rs != null){
              while(rs.next()){
                  Filme a = new Filme();
                  a.setCodigo(rs.getInt(1));
                  
                  lista.add(a);
              }
              return lista;
          }else{
              return null;
          }
      }catch(SQLException e){
          return null;
          
      }
  }
  public String Alterar_Filme(Filme a){
      String sql = "update filme set titulo = ? ,ano = ? ,duracao = ? "
                    + ",idcategoria = ? ,classificacao = ? , capa = ?  where idcliente = ?";
      try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setInt(1, a.getCodigo());
 
          if (ps.executeUpdate() > 0){
              return "Atualizado com sucesso.";
          }else{
              return "Erro ao atualizar";
          }
      }catch (SQLException e){
          return e.getMessage();
      }
  }
  

  public List<Filme> ListarComboFilme(){
      
      
      String sql = "select titulo from filme order by titulo";
      List<Filme> lista = new ArrayList<>();
      try{
          PreparedStatement ps =  getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while (rs.next()){
                  
                  Filme a = new Filme();
                  a.setCodigo(rs.getInt(1));
                  lista.add(a);
              }
              return lista;
          }else{
              return null;
          }
      }catch(Exception e){
          return null;
      }
  }
  
  
  public List<Filme> ConsultaCodigoFilme(String titulo){
      
      String sql = "select idfilme from filme where titulo = '" + titulo + "'";
      List<Filme> lista = new ArrayList<>();
      try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while(rs.next()){
              
                  Filme a = new Filme();
                  a.setCodigo(rs.getInt(1));
                  lista.add(a);
              }
              return lista;
          }else{
              return null;
          }
      } catch(Exception e){
          return null;
  
      }
  }
  
  public String Excluir_Filme(Filme a){
      String sql = "delete from filme where idfilme = ?" ;
      
      try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setInt(1, a.getCodigo());
          ps.setString(2, a.getTitulo());
          if (ps.executeUpdate() > 0){
              return "Excluido com Sucesso.";
          }else{
              return "Erro ao excluir.";
          }
      }catch (SQLException e){
          return e.getMessage();
      }
  }
   
}