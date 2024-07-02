package model;

import java.sql.Connection;
import java.sql.SQLException;
import model.Model;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

public class ModelMember extends Model{

    private String query;
    
    public ModelMember(Connection con){
        super(con);
    }
    
    @Override
    public String select() {
        String s="";
        try { 
            String query = "select id, nama, alamat, plan, trainer, price, monthly_progress from member";
            st  = con.prepareStatement(query);
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                s += rs.getString("id")+ " ";
                s +="  "+rs.getString("nama")+ " ";
                s +="  "+rs.getString("alamat")+ " ";
                s +="  "+rs.getString("plan")+ " ";
                s +="  "+rs.getString("trainer")+ " ";
                s +="  "+rs.getString("price")+ " ";
                s +="  "+rs.getString("monthly_progress")+ " ";
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
            String query = "select id, nama, alamat, plan, trainer, price, monthly_progress from member";
            st  = con.prepareStatement(query);
            rs = st.executeQuery(query);
            r = buildTableModel(rs);
        } catch (SQLException ex) {
            System.err.println("Eksekusi Gagal");
        }
        return r;
    }
    
    public int insert(String id, String nama, String alamat, String plan, String trainer, String price, String monthly_progress){
        int i=-1;
        try{
            String query = "insert into member(id, nama, alamat, plan, trainer, price, monthly_progress) "
                    + "values('"+id+"', '"+nama+"', '"+alamat+"', '"+plan+"', '"+trainer+"', '"+price+"', '"+monthly_progress+"')";
            st  = con.prepareStatement(query);
            i = st.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error:"+ex);
        }
        return i;
    }
    
    public int update(String id, String nama, String alamat, String plan, String trainer, String price, String monthly_progress) {
        int i=-1;
        try{
            String query = "update member set id='"+id+"', nama='"+nama+"',alamat='"+alamat+"', plan = '"+plan+"', "
                    + "trainer = '"+trainer+"', price = '"+price+"', monthly_progress = '"+monthly_progress+"' where id='"+id+"'";
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
            String query = "delete from member where id='"+id+"'";
            st  = con.prepareStatement(query);
            i = st.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error:"+ex);
        }
        return i;
    }


}
