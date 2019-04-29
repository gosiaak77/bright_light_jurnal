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
public class CsvToProductImportEntry {

    public List<ProductImportEntry> convertCsvFileToIngredientImportEntries(MultipartFile file) {
        List<ProductImportEntry> ingrediendtsEntries = new ArrayList<>();
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

    private ProductImportEntry convertRowToImportEntry(String[] row, boolean isRowValid) {
        if (isRowValid) {
            return ProductImportEntry.builder()
                    .name(row[0])
                    .ingredientType(row[1])
                    .build();
        } else throw new IllegalArgumentException("Wrong number of cells in .csv row");
    }

    private boolean validateNumberOfCellsInTheRow(String[] row){
        return row.length == 2;
    }

}
