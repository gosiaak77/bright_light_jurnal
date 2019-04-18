package pl.mnastaly.brightlightjurnal.ingredient.importer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class IngredientImportController {

    IngredientImportService ingredientImportService;

    @PostMapping(value = "/import/upload")
    public HttpStatus handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String result = null;
        if (file.isEmpty()) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

}
