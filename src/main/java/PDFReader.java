import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFReader {

    public static void main(String[] args) throws IOException {
        PDDocument document = PDDocument.load(new File("C:\\Users\\User\\Downloads\\course_timetable\\Course_Timetable_2017.pdf"));
        if (!document.isEncrypted()) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            System.out.println("Text:" + text);
        }
        document.close();
    }
}
