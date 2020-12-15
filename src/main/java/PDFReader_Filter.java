import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFReader_Filter {
    static String Term;
    static String CourseCode;
    static String ClassSection;
    static String ClassType;
    static String Day;
    static String StartTime;
    static String EndTime;
    static String Venue;
    static String RoomNo;

    public static void filter(String text){
        String textarr[] = text.split("\\n");

        for(String str : textarr){
            if(str.contains("2017 Autumn")) {
                String strarr[] = str.split(" ");
                if(!(strarr.length < 10)) {
                    for (int i = 0; i < 10; i++) {
                        Term = strarr[0]+" "+strarr[1];
                        CourseCode = strarr[2];
                        ClassSection = strarr[3];
                        ClassType = strarr[4];
                        Day = strarr[5];
                        StartTime = strarr[6];
                        EndTime = strarr[7];
                        Venue = strarr[8];
                        RoomNo = strarr[9];

                        //System.out.println(strarr[i]);
                    }

                    if(RoomNo.contains("School"))
                        RoomNo = strarr[11];

                    System.out.println(" "+Term+" "+CourseCode+" "+ClassSection+" "+ClassType+" "+Day+" "+StartTime+" "+EndTime+" "+Venue+" "+RoomNo);
                }
                //System.out.println(text);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PDDocument document = PDDocument.load(new File("C:\\Users\\User\\Downloads\\course_timetable\\Course_Timetable_2017.pdf"));
        if (!document.isEncrypted()) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            //filter action
            filter(text);

            //System.out.println("Text:" + text);
        }
        document.close();
    }
}
