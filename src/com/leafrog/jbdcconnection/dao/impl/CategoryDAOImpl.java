/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leafrog.jbdcconnection.dao.impl;

import com.leafrog.jbdcconnection.dao.CategoryDAO;
import com.leafrog.jbdcconnection.dbutil.DbConnection;
import com.leafrog.jbdcconnection.entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sony
 */
public class CategoryDAOImpl implements CategoryDAO{
   private DbConnection conn= new DbConnection();
    @Override
    public int insert(Category category) throws ClassNotFoundException, SQLException {
       String sql = "INSERT into  tbl_categories(category_name,Status)VALUES(?,?)";            
           
            conn.Open();
            PreparedStatement stmt= conn.initStatement(sql);
            stmt.setString(1,category.getName());
            stmt.setBoolean(2, category.isStatus());
            int Result=conn.executeUpdate();
            
            conn.close(); 
            return Result;
    }
    @Override
    public int Update(Category category) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_categories SET category_name=? Status=? modified_date=CURRENT_TIMESTAMP WHERE id=?";            
           PreparedStatement stmt= conn.initStatement(sql);
            stmt.setString(1,category.getName());
            stmt.setBoolean(2, category.isStatus());
            stmt.setString(3, category.getName());
            int Result=conn.executeUpdate();
            
            conn.close(); 
            return Result;
    }

    @Override
    public int Delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM tbl_categories  WHERE id=?";            
           PreparedStatement stmt= conn.initStatement(sql);
            
            stmt.setInt(3, 11);
           
            
            conn.close(); 
            return 0;
    }

    @Override
    public Category getById(int id) throws ClassNotFoundException, SQLException {
       Category category=null;
        String sql = "Select * FROM tbl_categories WHERE id=?";            
           
            conn.Open();
            PreparedStatement stmt= conn.initStatement(sql);
            stmt.setInt(1, id);
             ResultSet rs = conn.excuteQuery();
            while (rs.next()) {
                 category=new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("category_name"));
                category.setAddeddate(rs.getDate("added_date"));
                if(rs.getDate("modified_date")!=null){
                category.setModifieddate(rs.getDate("modified_date"));
                }
               category.setStatus(rs.getBoolean("status"));
            }
            conn.close();
            return category;
    }

    @Override
    public List<Category> getAll() throws ClassNotFoundException, SQLException {
       List<Category> categoryList=new ArrayList<>();
        String sql = "Select * FROM tbl_categories";            
           
            conn.Open();
            PreparedStatement stmt= conn.initStatement(sql);
           
             ResultSet rs = conn.excuteQuery();
            while (rs.next()) {
                 Category category=new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("category_name"));
                category.setAddeddate(rs.getDate("added_date"));
                if(rs.getDate("modified_date")!=null){
                category.setModifieddate(rs.getDate("modified_date"));
                }
               category.setStatus(rs.getBoolean("status"));
               categoryList.add(category);
            }
            conn.close();
            return categoryList;
    }
    
}
