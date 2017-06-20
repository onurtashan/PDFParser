package com.tashan.Service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import java.net.URL;
import java.io.IOException;

/**
 * Created by TCOTASHAN on 19.6.2017.
 */
public class PDFParserService {

    public String[] parserSonuc(int isParsed) throws IOException {

            URL url = new URL("http://www.millipiyango.gov.tr/node/themes/bluemasters/documents/Bahisler/Kampanya%20%C4%B0zinleri.pdf");
            PDDocument doc = PDDocument.load(url.openStream());
            PDFTextStripper stripper = new PDFTextStripper();

            if(isParsed == 1){
                    stripper.setStartPage(1);
                    stripper.setEndPage(1);
                    String sonuc = stripper.getText(doc);
                    String[] parsed = sonuc.split("Ticari");
                    System.out.println("PDF başarılı bir şekilde okundu.");
                    doc.close();
                    return parsed;
            }else{
                    System.out.println("PDF başarılı bir şekilde okundu ama parse edilmedi.");
            }
            doc.close();

            String[] fails = {"Parse edilmek isteniyor ise 1 değeri ile webservis çağırılmalıdır."};

            return fails;
    }
}
