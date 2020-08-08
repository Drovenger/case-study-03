package main.java.model.dao;

import main.java.model.product.Import;

import java.util.List;

public interface IDAOProduct {
    List<Import> getImportList();
}