package com.tashan.Controller;

import com.tashan.Model.PDFParser;
import com.tashan.Service.PDFParserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by TCOTASHAN on 19.6.2017.
 */
@RestController
public class PDFParserController {

    @RequestMapping(value = "/pdfparser")
    public PDFParser pdfParser(@RequestParam(value = "isParsed", defaultValue = "") int isParsed ) throws IOException {

        String[] sonuc = new PDFParserService().parserSonuc(isParsed);

        return new PDFParser(sonuc);
    }
}
