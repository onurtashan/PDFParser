package com.tashan.Service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by TCOTASHAN on 19.6.2017.
 */
public class PDFParserService {

    public String[] parserSonuc(int isParsed) throws IOException {

            URL url = new URL("http://www.millipiyango.gov.tr/node/themes/bluemasters/documents/Bahisler/Kampanya%20%C4%B0zinleri.pdf");
            //PDDocument doc = PDDocument.load(url.openStream());
            PDFTextStripper stripper = new PDFTextStripper();

            PDFParser parser = new PDFParser(url.openStream());

            parser.parse();
            COSDocument cosDoc = parser.getDocument();
            PDDocument doc = new PDDocument(cosDoc);
            stripper.setStartPage(1);
            stripper.setEndPage(1);
            String sonuc = stripper.getText(doc);
            String[] sonuclar = sonuc.split("Ticari");

            System.out.println(sonuclar.length);

            doc.close();
            System.out.println("PDF başarılı bir şekilde okundu.");

            return sonuclar;
    }
}
