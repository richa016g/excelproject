import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import java.io.*;


class mainform implements MouseListener
{
JFrame fr;
JLabel lc,le,lp,lt;
Vector selectedname=null;

public mainform()throws BiffException, IOException, WriteException
{
	fr = new JFrame("DataBase Management System");
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	
	int w = dim.width;
	int h = dim.height;
	fr.setSize(w,h);
	fr.setContentPane(new JLabel(new ImageIcon("images/mainform.png")));
	fr.setLayout(null);	

	lc = new JLabel(new ImageIcon("images/quit1.png"));
	lc.setBounds(w-100,40,32,32);
	lc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lc.addMouseListener(this);
	fr.add(lc);

	le = new JLabel("Import Excel Sheet");
	le.setForeground(Color.white);
	le.setHorizontalTextPosition(JLabel.CENTER);
	le.setVerticalTextPosition(JLabel.BOTTOM);
	le.setIcon(new ImageIcon("images/excel1.png"));
	le.setBounds(60,170,115,100);
	le.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	le.addMouseListener(this);
	fr.add(le);

	lt = new JLabel("Choose Template");
	lt.setForeground(Color.white);
	lt.setHorizontalTextPosition(JLabel.CENTER);
	lt.setVerticalTextPosition(JLabel.BOTTOM);
	lt.setIcon(new ImageIcon("images/template1.png"));
	lt.setBounds(60,370,115,100);
	lt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lt.addMouseListener(this);
	fr.add(lt);

	lp = new JLabel("Print Template");
	lp.setForeground(Color.white);
	lp.setHorizontalTextPosition(JLabel.CENTER);
	lp.setVerticalTextPosition(JLabel.BOTTOM);
	lp.setIcon(new ImageIcon("images/print1.png"));
	lp.setBounds(60,570,100,100);
	lp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lp.addMouseListener(this);
	fr.add(lp);	
	
	fr.setUndecorated(true);
	fr.setVisible(true);	
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public void mouseEntered(MouseEvent me)
{
	JLabel lb = (JLabel)me.getComponent();
	if(lb==lc)
	{
		lc.setIcon(new ImageIcon("images/quit3.png"));
	}
	if(lb==le)
	{
		le.setIcon(new ImageIcon("images/excel2.png"));
	}
	if(lb==lt)
	{
		lt.setIcon(new ImageIcon("images/template2.png"));
	}
	if(lb==lp)
	{
		lp.setIcon(new ImageIcon("images/print2.png"));
	}
}

public void mouseExited(MouseEvent me)
{
	JLabel lb = (JLabel)me.getComponent();
	if(lb==lc)
	{
		lc.setIcon(new ImageIcon("images/quit1.png"));
	}
	if(lb==le)
	{
		le.setIcon(new ImageIcon("images/excel1.png"));
	}
	if(lb==lt)
	{
		lt.setIcon(new ImageIcon("images/template1.png"));
	}
	if(lb==lp)
	{
		lp.setIcon(new ImageIcon("images/print1.png"));
	}
}

public void mouseClicked(MouseEvent me)
{
	JLabel lb = (JLabel)me.getComponent();
	if(lb==lc)
	{
		System.exit(0);
	}
	if(lb==le)
	{
		FileDialog fd = new FileDialog(fr,"Choose Excel Sheet",FileDialog.LOAD);
		fd.setVisible(true);
		String fn = fd.getDirectory()+fd.getFile();
		if(!fn.equals("nullnull"))
		{
			selectedname = new Vector();
			fr.setEnabled(false);
			new ExcelToJtable(fn,selectedname,fr);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Error in opening file");
		}
	}
	if(lb==lt)
	{
		fr.setEnabled(false);
		new createtemplate(selectedname,fr);
	}
}

public void mousePressed(MouseEvent me){}
public void mouseReleased(MouseEvent me){}

public static void main(String args[])throws BiffException, IOException, WriteException
{
	new mainform();
}
 
}