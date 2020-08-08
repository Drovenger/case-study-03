package main.java.service.catalog;

import main.java.model.Catalog;

import java.sql.SQLException;
import java.util.List;

public interface ICatalogService {
    List<Catalog> getCatalogList() throws SQLException;
}
