package service.category;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {

    public List<Category> findAll();

    public void insert(Category category) throws SQLException;

    public boolean update(Category category) throws SQLException;

    public boolean remove(int id) throws SQLException;

    public List<Category> findByStatus(String status) throws SQLException;


}

