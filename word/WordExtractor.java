import java.io.*;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordExtractor 
{
   public static void main(String[] args)throws Exception 
   {
XWPFDocument doc = XWPFTestDataSamples.openSampleDocument("d:\\createparagraph.docx");
XWPFWordExtractor wx = new XWPFWordExtractor(docx);
String text = wx.getText();
System.out.println("text = "+text);
   }
}