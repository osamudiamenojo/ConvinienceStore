package service.impl;

import entities.Product;
import enums.Category;
import fileutil.FileReadingClass;
import lombok.Getter;
import service.ProductService;
import storerepository.Store;

import java.util.ArrayList;
@Getter

public class ProductServiceImpl implements ProductService {
    private ArrayList<String> rowsOfFile;

    FileReadingClass fileReader = new FileReadingClass();

    public String createProductsFromCSV() {
        rowsOfFile = fileReader.readProductsFromCsvFile(
                "/Users/mac/Documents/Decagontask/week-two-sq012-osamudiamenojo/" +
                        "src/main/resources/Products in a Store - Sheet1.csv");
        Store store = new Store();
        for (String row : rowsOfFile
        ) {
            String[] rowArray = row.split(",");
            Product product = new Product();
            product.setProductID(rowArray[0]);
            product.setNameOfProduct(rowArray[1]);
            product.setUnitPrice(Double.parseDouble(rowArray[2]));
            product.setQuantityOfProductAvailable(Integer.parseInt(rowArray[3]));
            product.setCategory(Category.valueOf(rowArray[4].toUpperCase()));
            store.getProductsInStore().add(product);

        }
          return  "csv Products are available";
    }

}
