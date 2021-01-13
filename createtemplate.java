import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border; 
import java.sql.*;

public class createtemplate implements ActionListener,ItemListener
{
JFrame fr,frm;
JRadioButton r1,r2,r3,r4;
JCheckBox c1;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
JButton b1,b2;
JTextField t1,t2,t3,t4,t5,t6,t7,t8;
JTextArea ta;
Vector data;
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
ButtonGroup bg;
JScrollPane jsp;

	public createtemplate(Vector selectedname,JFrame f)
	{
		fr = new JFrame();
		frm = f;
		data = selectedname;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr.setLayout(null);
		fr.setBounds(40,dim.height-657,dim.width-90,621);
		fr.setContentPane(new JLabel(new ImageIcon("/excelproject/images/back.jpg")));
		fr.setResizable(false);

		l1 = new JLabel("Choose Template");
		l1.setFont(new Font("verdana",Font.BOLD,20));
		l1.setForeground(Color.green);
		l1.setBounds(10,5,220,30);
		fr.add(l1);

		bg = new ButtonGroup();
		r1 = new JRadioButton("Short Attendence");
		r2 = new JRadioButton("Sessional Report");
		r3 = new JRadioButton("Detention Letter");
		r4 = new JRadioButton("Misbehaviour Letter");
		r1.setBounds(10,40,180,30);
		r2.setBounds(10,80,180,30);
		r3.setBounds(10,120,180,30);
		r4.setBounds(10,160,180,30);
		r1.setFont(new Font("verdana",Font.BOLD,14));
		r2.setFont(new Font("verdana",Font.BOLD,14));
		r3.setFont(new Font("verdana",Font.BOLD,14));
		r4.setFont(new Font("verdana",Font.BOLD,14));
		r1.setForeground(Color.pink);
		r2.setForeground(Color.pink);
		r3.setForeground(Color.pink);
		r4.setForeground(Color.pink);
		r1.addItemListener(this);
		r2.addItemListener(this);
		r3.addItemListener(this);
		r4.addItemListener(this);
		r1.setOpaque(false);
		r2.setOpaque(false);
		r3.setOpaque(false);
		r4.setOpaque(false);
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		fr.add(r1);
		fr.add(r2);
		fr.add(r3);
		fr.add(r4);

		b1 = new JButton("Create");
		b1.setFont(new Font("verdana",Font.BOLD,13));
		b1.setForeground(Color.white);
		b1.setBackground(Color.blue);
		b1.setBounds(10,210,90,25);
		b1.addActionListener(this);
		fr.add(b1);
		
		b2 = new JButton("Cancel");
		b2.setFont(new Font("verdana",Font.BOLD,13));
		b2.setForeground(Color.white);
		b2.setBackground(Color.blue);
		b2.setBounds(10,245,90,25);
		b2.addActionListener(this);
		fr.add(b2);

		c1 = new JCheckBox("Insert Date & Time");
		c1.setBounds(10,320,200,30);
		c1.setFont(new Font("verdana",Font.BOLD,14));
		c1.setOpaque(false);
		fr.add(c1);

		l2 = new JLabel("College Name");
		l3 = new JLabel("College Address");
		l4 = new JLabel("College Phone & Website");
		l5 = new JLabel("Subject");
		l6 = new JLabel("Student Name");
		l7 = new JLabel("Student Class");
		l8 = new JLabel("Student Roll");
		l9 = new JLabel("Letter Body");
		l10 = new JLabel("Faculty Name");


		l2.setBounds(400,10,150,30);
		l3.setBounds(400,70,150,30);
		l4.setBounds(400,130,400,30);
		l5.setBounds(400,190,150,30);
		l6.setBounds(400,250,150,30);
		l7.setBounds(700,250,150,30);
		l8.setBounds(1000,250,150,30);
		l9.setBounds(400,310,150,30);
		l10.setBounds(400,540,150,30);

		l2.setFont(new Font("verdana",Font.BOLD,16));
		l3.setFont(new Font("verdana",Font.BOLD,16));
		l4.setFont(new Font("verdana",Font.BOLD,16));
		l5.setFont(new Font("verdana",Font.BOLD,16));
		l6.setFont(new Font("verdana",Font.BOLD,16));
		l7.setFont(new Font("verdana",Font.BOLD,16));
		l8.setFont(new Font("verdana",Font.BOLD,16));
		l9.setFont(new Font("verdana",Font.BOLD,16));
		l10.setFont(new Font("verdana",Font.BOLD,16));

		l2.setForeground(Color.gray);
		l3.setForeground(Color.gray);
		l4.setForeground(Color.gray);
		l5.setForeground(Color.gray);
		l6.setForeground(Color.gray);
		l7.setForeground(Color.gray);
		l8.setForeground(Color.gray);
		l9.setForeground(Color.gray);
		l10.setForeground(Color.gray);

		fr.add(l2);
		fr.add(l3);
		fr.add(l4);
		fr.add(l5);
		fr.add(l6);
		fr.add(l7);
		fr.add(l8);
		fr.add(l9);
		fr.add(l10);

		t1 = new JTextField("MEERUT INSTITUTE OF ENGINEERING AND TECHNOLOGY");
		t2 = new JTextField("NH-58, Bagpath Crossing, By Pass Road, Meerut-250005");
		t3 = new JTextField("Phone No.: 0121-2439019, 2439057, Fax: 2439058, Website: www.miet.ac.in");
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();
		t8 = new JTextField();
		
		ta = new JTextArea("");
		ta.setFont(new Font("verdana",Font.BOLD,15));
		ta.setOpaque(false);
		ta.setForeground(Color.green);
		jsp = new JScrollPane(ta);
		jsp.setBounds(400,340,800,200);
		jsp.getViewport().setBackground(Color.black);

		t1.setBounds(400,40,800,30);
		t2.setBounds(400,100,800,30);
		t3.setBounds(400,160,800,30);
		t4.setBounds(400,220,800,30);
		t5.setBounds(400,280,200,30);
		t6.setBounds(700,280,200,30);
		t7.setBounds(1000,280,200,30);
		t8.setBounds(400,570,800,30);
		
		t1.setFont(new Font("verdana",Font.BOLD,15));
		t2.setFont(new Font("verdana",Font.BOLD,15));
		t3.setFont(new Font("verdana",Font.BOLD,15));
		t4.setFont(new Font("verdana",Font.BOLD,15));
		t5.setFont(new Font("verdana",Font.BOLD,15));
		t6.setFont(new Font("verdana",Font.BOLD,15));
		t7.setFont(new Font("verdana",Font.BOLD,15));
		t8.setFont(new Font("verdana",Font.BOLD,15));
		
		t1.setForeground(Color.green);
		t2.setForeground(Color.green);
		t3.setForeground(Color.green);
		t4.setForeground(Color.green);
		t5.setForeground(Color.green);
		t6.setForeground(Color.green);
		t7.setForeground(Color.green);
		t8.setForeground(Color.green);
		
		t1.setOpaque(false);
		t2.setOpaque(false);
		t3.setOpaque(false);
		t4.setOpaque(false);
		t5.setOpaque(false);
		t6.setOpaque(false);
		t7.setOpaque(false);
		t8.setOpaque(false);
		
		Border border = BorderFactory.createLineBorder(Color.gray);
		ta.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		t1.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		t2.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		t3.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		t4.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		t5.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		t6.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		t7.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		t8.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		fr.add(t1);
		fr.add(t2);
		fr.add(t3);
		fr.add(t4);
		fr.add(t5);
		fr.add(t6);
		fr.add(t7);
		fr.add(t8);
		fr.add(jsp);

		fr.setUndecorated(true);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void itemStateChanged(ItemEvent ie)
	{
		if(r1.isSelected())
		{
			t4.setText(r1.getLabel());
			new shortletter(ta);
		}

		if(r2.isSelected())
		{
			t4.setText(r2.getLabel());
			new sessionletter(ta);
		}

		if(r3.isSelected())
		{
			t4.setText(r3.getLabel());
			new detainletter(ta);
		}

		if(r4.isSelected())
		{
			t4.setText(r4.getLabel());
			new misbehaviourletter(ta);
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			new createletter(t1,t2,t3,t4,t5,t6,t7,t8,ta);			

			/*try
			{
				con = Dao.makeConnection();
				ps = con.prepareStatement("insert into datatable values(?,?,?,?,?)");
				for(Object ob : data)
				{
					String str = (String)ob;
					ps.setString(1,str.substring(0,str.indexOf(",")));
					ps.setString(2,str.substring(str.indexOf(",")+1,str.indexOf(":")));
					ps.setString(3,str.substring(str.indexOf(":")+1,str.length()));
					ps.setString(4,t4.getText());
					ps.setString(5,ta.getText());
					ps.executeUpdate();
				}
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}*/
		}
		
		if(ae.getSource()==b2)
		{
			frm.setEnabled(true);
			fr.dispose();
		}
	}

	public void short_attendence()
	{
	}

	public void sessional_report()
	{
	}

	public void misbehave_report()
	{
	}

	public void other_activities()
	{
	}

}

