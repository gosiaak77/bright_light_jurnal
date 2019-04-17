package pl.mnastaly.brightlightjurnal.ingredient.importer;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvToIngredientImportEntry {

    public List<IngredientImportEntry> processCsvFile(MultipartFile file){
        List<IngredientImportEntry> ingrediendtsEntries = new ArrayList<>();
        try {
            String row;
            InputStream is = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((row = br.readLine()) != null) {
                ingrediendtsEntries.add(convertRowToImportEntry(row));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return ingrediendtsEntries;
    }

    public IngredientImportEntry convertRowToImportEntry(String row){
       return null;
    }

}
