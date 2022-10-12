package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {
    private ArrayList<String> arrayOfRowsInFile;

    public ArrayList<String> readProductsFromCsvFile(String path){
        String line ="";
         arrayOfRowsInFile = new ArrayList();
        try {
            BufferedReader bufferedReader =new BufferedReader(new java.io.FileReader(path));
            while ((line=bufferedReader.readLine())!=null){
                arrayOfRowsInFile.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

            return arrayOfRowsInFile;
    }


}
