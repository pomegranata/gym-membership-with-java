package model;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Imelda Maretta Putri
 * F11.2022.00053
 */

public class ModelSchedule extends Model {
   
    public ModelSchedule(Connection con){
        super(con);
    }
    
    @Override
    public String select() {
        String s="";
        try { 
            String query = "select id, memID, trID, sesi, plan, progress from schedule";
            st  = con.prepareStatement(query);
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                s += rs.getString("id")+ " ";
                s +="  "+rs.getString("memID")+ " ";
                s +="  "+rs.getString("trID")+ " ";
                s +="  "+rs.getString("sesi")+ " ";
                s +="  "+rs.getString("plan")+ " ";
                s +="  "+rs.getString("progress")+ " ";
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
            String query = "select id, memID, trID, sesi, plan, progress from schedule";
            st  = con.prepareStatement(query);
            rs = st.executeQuery(query);
            r = buildTableModel(rs);
        } catch (SQLException ex) {
            System.err.println("Eksekusi Gagal");
        }
        return r;
    }
    
    public int insert(String id, String memID, String trID, String sesi, String plan, String progress){
        int i=-1;
        try{
            String query = "insert into schedule(id, memID, trID, sesi, plan, progress) "
                    + "values('"+id+"','"+memID+"','"+trID+"','"+sesi+"','"+plan+"','"+progress+"')";
            st  = con.prepareStatement(query);
            i = st.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error:"+ex);
        }
        return i;
    }
    
    public int update(String id, String memID, String trID, String sesi, String plan, String progress) {
        int i=-1;
        try{
            String query = "update schedule set id='"+id+"', memID = '"+memID+"', trID = '"+trID+"', sesi = '"+sesi+"', "
                    + "plan = '"+plan+"', progress = '"+progress+"' where id='"+id+"'";
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
            String query = "delete from schedule where id='"+id+"'";
            st  = con.prepareStatement(query);
            i = st.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error:"+ex);
        }
        return i;
    }
}
