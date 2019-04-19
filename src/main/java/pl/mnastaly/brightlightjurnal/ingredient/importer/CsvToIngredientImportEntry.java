package pl.mnastaly.brightlightjurnal.ingredient.importer;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvToIngredientImportEntry {

    public List<IngredientImportEntry> convertCsvFileToIngredientImportEntries(MultipartFile file) {
        List<IngredientImportEntry> ingrediendtsEntries = new ArrayList<>();
        try {
            String[] row;
            InputStream is = file.getInputStream();
            CSVReader csvReader = new CSVReader(new InputStreamReader(is));
            while ((row = csvReader.readNext()) != null) {
                boolean isRowValid = validateNumberOfCellsInTheRow(row);
                ingrediendtsEntries.add(convertRowToImportEntry(row, isRowValid));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return ingrediendtsEntries;
    }

    private IngredientImportEntry convertRowToImportEntry(String[] row, boolean isRowValid) {
        if (isRowValid) {
            return IngredientImportEntry.builder()
                    .name(row[0])
                    .ingredientType(row[1])
                    .build();
        } else throw new IllegalArgumentException("Wrong number of cells in .csv row");
    }

    private boolean validateNumberOfCellsInTheRow(String[] row){
        return row.length == 2;
    }

}
