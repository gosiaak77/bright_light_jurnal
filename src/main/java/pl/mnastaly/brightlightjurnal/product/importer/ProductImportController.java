package pl.mnastaly.brightlightjurnal.product.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ProductImportController {

    @Autowired
    ProductImportService productImportService;

    @PostMapping(value = "/import/upload")
    public HttpStatus handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return HttpStatus.BAD_REQUEST;
        }
        productImportService.processImportCsvFile(file);
        return HttpStatus.OK;
    }

}