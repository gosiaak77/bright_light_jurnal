package pl.mnastaly.brightlightjurnal.ingredient.importer;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CsvToIngredientImportEntry {

    public List<IngredientImportEntry> readCsvFile(MultipartFile file) {
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

    public IngredientImportEntry convertRowToImportEntry(String row) {
        List<String> cells = Arrays.asList(row.split(";"));
        return IngredientImportEntry.builder()
                .name(cells.get(0))
                .ingredientType(cells.get(1))
                .build();
    }

    public boolean validateNumberOfCellsInTheRow(String row){
        return row.split(";").length == 3;
    }

}
