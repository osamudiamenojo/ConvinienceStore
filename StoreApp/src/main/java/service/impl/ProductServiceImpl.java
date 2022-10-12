package service.impl;

import entities.Product;
import enums.Category;
import service.ProductService;
import storerepository.Store;
import utils.FileReader;

import java.math.BigInteger;
import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {
    private ArrayList<String> rowsOfFile;
    FileReader fileReader = new FileReader();


    public void createProductsFromCSV() {
        rowsOfFile = fileReader.readProductsFromCsvFile(
                "/Users/mac/Documents/Decagontask/week-two-sq012-osamudiamenojo/" +
                        "src/main/resources/Products in a Store - Sheet1.csv");
        Store store = new Store();
        for (String row:rowsOfFile
             ) {
            String[] rowArray=row.split(",");
            Product product = new Product();
            product.setNameOfProduct(rowArray[1]);
            product.setPrice(BigInteger.valueOf(Long.parseLong(rowArray[2])));
            product.setCountOfProduct(Integer.parseInt(rowArray[3]));
            product.setCategory(Category.valueOf(rowArray[4].toUpperCase()));
            store.getProductsInStore().add(product);
        }

    }
}
