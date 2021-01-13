import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import javax.swing.*;

public class createletter
{
   	public createletter(JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5,JTextField t6,JTextField t7,JTextField t8,JTextArea ta)
   	{
	try
	{
   	//Blank Document
   	XWPFDocument document= new XWPFDocument(); 
   	//Write the Document in file system
   	FileOutputStream out = new FileOutputStream(new File("createdletters/detain.docx"));
        
   	//create Paragraph
   	
	XWPFParagraph paragraph1 = document.createParagraph();
   	paragraph1.setAlignment(ParagraphAlignment.CENTER);
   	XWPFRun run1 = paragraph1.createRun();
	run1.setFontSize(14);
	run1.setText(t1.getText());
	run1.setBold(true);

	XWPFParagraph paragraph2 = document.createParagraph();
   	paragraph2.setAlignment(ParagraphAlignment.CENTER);
   	XWPFRun run2 = paragraph2.createRun();
   	run2.setText(t2.getText());
	run2.setFontSize(12);
		
	XWPFParagraph paragraph3 = document.createParagraph();
   	paragraph3.setAlignment(ParagraphAlignment.CENTER);
   	XWPFRun run3 = paragraph3.createRun();
	run3.setFontSize(12);
	run3.setText(t3.getText());
	run3.addBreak();

	XWPFParagraph paragraph4 = document.createParagraph();
   	XWPFRun run4 = paragraph4.createRun();
   	run4.setText("Subject :- "+t4.getText());
	run4.setBold(true);

	XWPFParagraph paragraph5 = document.createParagraph();
   	XWPFRun run5 = paragraph5.createRun();
   	run5.setText("Student Name :- "+t5.getText());
	
	XWPFParagraph paragraph6 = document.createParagraph();
   	XWPFRun run6 = paragraph6.createRun();
   	run6.setText("Class :- "+t6.getText());
	
	XWPFParagraph paragraph7 = document.createParagraph();
   	XWPFRun run7 = paragraph7.createRun();
   	run7.setText("Roll :- "+t7.getText());
	run7.addBreak();

	XWPFParagraph paragraph8 = document.createParagraph();
   	XWPFRun run8 = paragraph8.createRun();
   	run8.setText("Dear Sir/Madam,");
	
	XWPFParagraph paragraph9 = document.createParagraph();
   	paragraph9.setAlignment(ParagraphAlignment.BOTH);
	XWPFRun run9 = paragraph9.createRun();
   	run9.setText(ta.getText());
	
	XWPFParagraph paragraph = document.createParagraph();
   	XWPFRun run = paragraph.createRun();
   	run.setText("");
	
	XWPFParagraph paragraph10 = document.createParagraph();
   	XWPFRun run10 = paragraph10.createRun();
   	run10.setText("Thanking you,");
	run10.addBreak();
	run10.addBreak();
	run10.addBreak();

	XWPFParagraph paragraph11 = document.createParagraph();
   	XWPFRun run11 = paragraph11.createRun();
   	run11.setText("Class Counselor Signature");

	XWPFParagraph paragraph12 = document.createParagraph();
   	XWPFRun run12 = paragraph12.createRun();
   	run12.setText(t8.getText());

   	document.write(out);
   	out.close();
   	JOptionPane.showMessageDialog(null,"detainletter.docx written successfully");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}