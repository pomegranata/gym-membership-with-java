package model;

import java.sql.Connection;
import java.sql.SQLException;

public class ModelMember extends Model{

   private final Connection con;
    
    public ModelMember(Connection con){
        this.con = con;
    }
    
    @Override
    public String Select() {
        String s="";
        try { 
            query = "select id, nama, alamat, plan, trainer, price from member";
            st  = con.prepareStatement(query);
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                s += rs.getString("id");
                s +="  "+rs.getString("nama");
                s +="  "+rs.getString("alamat");
                s +="  "+rs.getString("plan");
                s +="  "+rs.getString("trainer");
                s +="  "+rs.getString("price");
                s+="\n";
            }
            
        } catch (SQLException ex) {
            System.out.println("Gagal Tampil");
        }
        return s;
    }

    @Override
    public int Insert(String[] Params) {
        String id=Params[0];
        String nama=Params[1];
        String alamat=Params[2];
        String plan=Params[3];
        String trainer=Params[4];
        String price=Params[5];
        
        int i=-1;
        try{
            query = "insert into member(id, nama, alamat, plan, trainer, price) values('"+id+"','"+nama+"','"+alamat+"',"
                    + "'"+plan+"','"+trainer+"','"+price+"')";
            st  = con.prepareStatement(query);
            i = st.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error:"+ex);
        }
        return i;
    }

    @Override
    public int Update(String[] Params) {
        String id=Params[0];
        String nama=Params[1];
        String alamat=Params[2];
        String plan=Params[3];
        String trainer=Params[4];
        String price=Params[5];
        int i=-1;
        try{
            query = "update member set id='"+id+"', nama='"+nama+"',alamat='"+alamat+"', plan = '"+plan+"', "
                    + "trainer = '"+trainer+"', price = '"+price+"' where id='"+id+"'";
            st  = con.prepareStatement(query);
            i = st.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error:"+ex);
        }
        return i;
    }

    @Override
    public int Delete(String[] Params) {
        String id=Params[0];
        int i=-1;
        try{
            query = "delete from member where id='"+id+"'";
            st  = con.prepareStatement(query);
            i = st.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error:"+ex);
        }
        return i;
    }

}
