/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leafrog.jbdcconnection.dao;

import com.leafrog.jbdcconnection.entity.Category;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sony
 */
public interface CategoryDAO {
    int insert(Category category)throws ClassNotFoundException,SQLException;
    int Update(Category category)throws ClassNotFoundException,SQLException;
    int Delete(int id)throws ClassNotFoundException,SQLException;
    Category getById(int id)throws ClassNotFoundException,SQLException;
    List<Category> getAll()throws ClassNotFoundException,SQLException;
}


