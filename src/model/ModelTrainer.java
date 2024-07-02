package model;

import model.Model;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Imelda Maretta Putri
 * F11.2022.00053
 */
public class ModelTrainer extends Model{
     
    public ModelTrainer(Connection con){
        super(con);
    }
    
    @Override
    public String select() {
        String s="";
        try { 
            String query = "select id, nama, spesialisasi, payment_progress from trainer";
            st  = con.prepareStatement(query);
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                s += rs.getString("id")+ " ";
                s +="  "+rs.getString("nama")+ " ";
                s +="  "+rs.getString("spesialisasi")+ " ";
                s +="  "+rs.getString("payment_progress")+ " ";
            }
        } catch (SQLException ex) {
            System.out.println("Gagal Eksekusi");
        }
        return s;
    }
    
    @Override
    public DefaultTableModel dataModel(){
        DefaultTableModel r=null;
        try {
            String query = "select id, nama, spesialisasi, payment_progress from trainer";
            st  = con.prepareStatement(query);
            rs = st.executeQuery(query);
            r = buildTableModel(rs);
        } catch (SQLException ex) {
            System.err.println("Eksekusi Gagal");
        }
        return r;
    }
    
    public int insert(String id, String nama, String spesialisasi, String payment_progress){
        int i=-1;
        try{
            String query = "insert into trainer(id, nama, spesialisasi, payment_progress) "
                    + "values('"+id+"','"+nama+"','"+spesialisasi+"', '"+payment_progress+"')";
            st  = con.prepareStatement(query);
            i = st.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error:"+ex);
        }
        return i;
    }
    
    public int update(String id, String nama, String spesialisasi, String payment_progress) {
        int i=-1;
        try{
            String query = "update trainer set id='"+id+"', nama='"+nama+"',spesialisasi='"+spesialisasi+"', payment_progress='"+payment_progress+"'"
                    + "where id='"+id+"'";
            st  = con.prepareStatement(query);
            i = st.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error:"+ex);
        }
        return i;
    }
    
    public int delete(String id) {
        int i=-1;
        try{
            String query = "delete from trainer where id='"+id+"'";
            st  = con.prepareStatement(query);
            i = st.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error:"+ex);
        }
        return i;
    }
}
