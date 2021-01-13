import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class test {
 public static void readDocxFile(String fileName) {
try {
File file = new File(fileName);
FileInputStream fis = new FileInputStream(file.getAbsolutePath());
XWPFDocument document = new XWPFDocument(fis);
for(int i=0;i<paragraphs.size();i++){
    System.out.println(paragraphs.get(i).getParagraphText());
}
fis.close();
} catch (Exception e) {
e.printStackTrace();
}
}
public static void main(String[] args) {
 readDocxFile("d:\\createparagraph.docx");
 }
} 