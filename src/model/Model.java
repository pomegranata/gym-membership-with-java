package model;

import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public abstract class Model{
    
    protected final Connection con;
    protected Statement st;
    protected ResultSet rs;
    
    protected abstract String select();
    protected abstract DefaultTableModel dataModel();
    
    public Model(Connection con){
        this.con = con;
    }
    
    protected static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
}