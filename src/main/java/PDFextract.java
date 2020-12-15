import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PDFextract {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Test
    public void verifyPDFContent() throws Exception {
        String url = "http://www.geocities.ws/benwyw/course_timetable/Course_Timetable_2017.pdf";
        driver.get(url);
        String pdfContent = readPDFContent(driver.getCurrentUrl());

        Assert.assertTrue(pdfContent.contains("This is a small demonstration .pdf file"));
        driver.quit();
    }

    public String readPDFContent(String appUrl) throws Exception {

        URL url = new URL(appUrl);
        InputStream input = url.openStream();
        BufferedInputStream fileToParse = new BufferedInputStream(input);
        PDDocument document = null;
        String output = null;

        try {
            document = PDDocument.load(fileToParse);
            output = new PDFTextStripper().getText(document);
            System.out.println(output);

        } finally {
            if (document != null) {
                document.close();
            }
            fileToParse.close();
            input.close();
        }
        return output;
    }
}