package model;

/**
 *
 * @author ACER NITRO
 */

import java.sql.ResultSet;
import java.sql.Statement;

public abstract class Model {
    
    protected String query;
    protected Statement st;
    protected ResultSet rs;
    
    public abstract String Select();
    public abstract int Insert(String[] Params);
    public abstract int Update(String[] Params);
    public abstract int Delete(String[] Params);
}