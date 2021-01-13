import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelToJtable implements ListSelectionListener,ActionListener
{
static int cols;
JTable table;
DefaultTableModel model;
Vector headers,data,names;
File file;
int sheetno=0,z=0;
Workbook workbook;
Sheet sheet;
JList ls;
JLabel l1=null,l2=null,l3=null;
JScrollPane scroll=null;
JFrame f,fr;
JButton button1,button2,button3;

public String[] showworkbook(String fn)
{
	String sheetnames[]=null;
	try
	{
		file = new File(fn);
		workbook = Workbook.getWorkbook(file);
		int ns = workbook.getNumberOfSheets();
		sheetnames = workbook.getSheetNames();
		l1 = new JLabel("");
		l1.setText("Total Sheets = " + ns);
		return sheetnames;
	}
	catch(IOException e)
	{
		
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	
	return sheetnames;
}

public void showsheet(int shno,JFrame ff)
{
	headers = new Vector();
	data = new Vector();
	try
	{
		headers.clear();
		sheet = workbook.getSheet(shno);
		cols = sheet.getColumns();
		for (int i = 0; i < sheet.getColumns(); i++) 	
		{
			Cell cell1 = sheet.getCell(i, 0);
			headers.add(cell1.getContents());
		}
		headers.add("SELECT");

		data.clear();
		for (int j = 1; j < sheet.getRows(); j++)
		{
			Vector d = new Vector();
			for (int i = 0; i < sheet.getColumns(); i++)
			{
				Cell cell = sheet.getCell(i, j);
				d.add(cell.getContents());
			}
		d.add(new Boolean(false));
		d.add("\n");
		data.add(d);
		}

	model = new DefaultTableModel(data,headers);
	table = new JTable(model)
		{
            	private static final long serialVersionUID = 1L;

            	@Override
            	public Class getColumnClass(int column)
		{
			if(column==cols)
			{
                	return Boolean.class;
                	}
			else
			{
			return String.class;
			}
	       	}
		};
		
	TableColumn column = null;
    	for (int i = 0; i <= cols; i++) 
	{
        column = table.getColumnModel().getColumn(i);
        if (i == 0) 
	{
            column.setPreferredWidth(4); //sport column is bigger
        } 
	else if(i==cols)
	{
            column.setPreferredWidth(4);
        }
	else
	{
		column.setPreferredWidth(200);
	}
    	}    

	table.setRowHeight(table.getRowHeight() + 5);
	table.setFont(new Font("verdana",Font.BOLD,13));
	table.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 16));
	table.setAutoCreateRowSorter(true);
	scroll = new JScrollPane(table);
	scroll.setBounds(30,51,975,550);
	ff.add(scroll);
	l2.setText("WORKBOOK :- "+file.getPath()+"                  SHEETNAME :- "+sheet.getName());
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}	
}

public ExcelToJtable(String fn,Vector selectedname,JFrame frm)
{
	names = selectedname;
	fr = frm;
	String sheetnames[] = showworkbook(fn);
	if(sheetnames!=null)
	{
	f = new JFrame();
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	f.setLayout(null);
	f.setBounds(40,dim.height-657,dim.width-90,621);
	f.setContentPane(new JLabel(new ImageIcon("/excelproject/images/back.jpg")));
	
	l1.setBounds(1120,5,250,30);
	l1.setFont(new Font("verdana",Font.BOLD,15));
	l1.setForeground(Color.gray);
	f.add(l1);

	l2 = new JLabel("WORKBOOK :- "+fn+"                  SHEETNAME :- "+sheetnames[0]);
	l2.setBounds(30,15,700,30);
	l2.setFont(new Font("verdana",Font.BOLD,16));
	l2.setForeground(Color.gray);
	f.add(l2);

	f.setResizable(false);
	
	showsheet(z,f);		

	ls = new JList(sheetnames);
	JScrollPane scroll2 = new JScrollPane(ls);
	scroll2.setBounds(1120,40,150,55);
	ls.setBackground(Color.pink);
	ls.setFont(new Font("verdana",Font.BOLD,12));
	ls.addListSelectionListener(this);
	f.add(scroll2);

	button1 = new JButton("Select All");
	button1.setBounds(1120,200,100,30);
	f.add(button1);
	button1.addActionListener(this);

	button2 = new JButton("OK");
	button2.setBounds(1120,250,100,30);
	f.add(button2);
	button2.addActionListener(this);

	button3 = new JButton("Cancel");
	button3.setBounds(1120,300,100,30);
	f.add(button3);
	button3.addActionListener(this);

	f.setUndecorated(true);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	else
	{
	}
}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==button1)
		{
		       	for (int i = 0; i < model.getRowCount(); i++) 
			{
            			model.setValueAt(true,i, cols);// check state
        		}
		}

		if(ae.getSource()==button2)
		{
			for (int i = 0; i < model.getRowCount(); i++) 
			{
            		Boolean value = (Boolean) model.getValueAt(i, cols);// check state
            		if (value)
			{
	               		names.addElement((String)model.getValueAt(i,0)+","+(String)model.getValueAt(i,1)+":"+(String)model.getValueAt(i,2));
            		}
			}
			fr.setEnabled(true);
			f.dispose();
		}

		if(ae.getSource()==button3)
		{
			fr.setEnabled(true);
			f.dispose();
		}
	}

	public void valueChanged(ListSelectionEvent lse)
	{
		z = ls.getSelectedIndex();
		f.remove(scroll);
		showsheet(z,f);
	}

}

