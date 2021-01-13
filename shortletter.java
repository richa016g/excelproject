import java.io.FileInputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import javax.swing.*;

public class shortletter
{
public shortletter(JTextArea ta)
{
      	try
	{
        	FileInputStream fis = new FileInputStream("letter/short.docx");
		XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
		XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
		ta.setText("");
		ta.setText(ta.getText()+extractor.getText());
      	} 
	catch(Exception ex)
	{
		ex.printStackTrace();
      	} 
   }
} 