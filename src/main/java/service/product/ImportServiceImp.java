package main.java.service.product;

import main.java.model.dao.DAOProductImp;
import main.java.model.dao.IDAOProduct;
import main.java.model.product.Import;
import java.util.List;

public class ImportServiceImp implements IImportService {
    private IDAOProduct idaoProduct;

    public ImportServiceImp() {
        idaoProduct = new DAOProductImp();
    }

    public List<Import> getImportList() {
        return idaoProduct.getImportList();
    }
}