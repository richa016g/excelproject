import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.*;
import org.apache.poi.hwpf.extractor.WordExtractor;


public class TextAreaInDocument extends JFrame
{
JTextArea area;
JScrollPane pane;
JButton b1;
File file = new File("d:/New.doc");

private static void writeDoc(String FileName,String content)
{
try
{
POIFSFileSystem fs = new POIFSFileSystem();
DirectoryEntry directory = fs.getRoot();
directory.createDocument("WordDocument", new ByteArrayInputStream(content.getBytes()));
FileOutputStream out = new FileOutputStream(FileName);

fs.writeFilesystem(out);
out.close();
}
catch(Exception ex)
{
System.out.println(ex.getMessage());
}
}

public TextAreaInDocument()
{
area=new JTextArea(10,50);
area.setFont(new Font("lucida console",Font.BOLD,12));
pane=new JScrollPane(area);
b1=new JButton("Create");
b1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
String text=area.getText();
String f=file.getPath();
writeDoc(f,text);
area.setText("");
}
});

JPanel p=new JPanel();
p.add(pane);
p.add(b1);
add(p);
setVisible(true);
pack();
}
public static void main(String[]args)
{
	TextAreaInDocument doc=new TextAreaInDocument();
}
}
