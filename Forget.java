import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border; 
import java.sql.*;

class Forget implements MouseListener
{
JFrame fr;
JLabel l1,l2,l3,ls,lc;
JTextField t1,t3;
int w,h;
Connection con;
PreparedStatement ps;
ResultSet rs;

	public Forget()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		w = dim.width;
		h = dim.height;
		fr = new JFrame("Signup Form");
		fr.setBounds((w-450)/2,(h-300)/2,450,300);
		fr.setContentPane(new JLabel(new ImageIcon("images/forget.png")));
		
		l1 = new JLabel("Enter UserName");
		l1.setBounds(50,80,150,30);
		l1.setFont(new Font("verdana",Font.BOLD,15));
		l1.setForeground(Color.pink);	
		fr.add(l1);
	
		Border border = BorderFactory.createLineBorder(Color.red);
		
		t1 = new JTextField();
		t1.setBounds(200,80,200,25);
		t1.setOpaque(false);
		t1.setForeground(Color.green);
		t1.setFont(new Font("verdana",Font.BOLD,15));
		t1.setCaretColor(Color.green);
		t1.setHorizontalAlignment(JTextField.CENTER);
		t1.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		fr.add(t1);

		l3 = new JLabel("Enter Email");
		l3.setBounds(50,120,150,30);
		l3.setFont(new Font("verdana",Font.BOLD,15));
		l3.setForeground(Color.pink);	
		fr.add(l3);
		
		t3 = new JTextField();
		t3.setBounds(200,120,200,25);
		t3.setOpaque(false);
		t3.setForeground(Color.green);
		t3.setFont(new Font("verdana",Font.BOLD,15));
		t3.setCaretColor(Color.green);
		t3.setHorizontalAlignment(JTextField.CENTER);
		t3.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1,1,1,1)));	
		fr.add(t3);

		ls = new JLabel(new ImageIcon("images/submit1.png"));
		ls.setBounds(210,200,80,25);
		ls.addMouseListener(this);
		ls.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fr.add(ls);

		lc = new JLabel(new ImageIcon("images/cancel11.png"));
		lc.setBounds(300,200,80,25);
		lc.addMouseListener(this);
		lc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fr.add(lc);		

		fr.setUndecorated(true);
		fr.setOpacity(0.95f);
		fr.setVisible(true);
	}

	public void mouseEntered(MouseEvent me)
	{
		JLabel lb = (JLabel)me.getComponent();
		if(lb==ls)
		{
			ls.setIcon(new ImageIcon("images/submit2.png"));
		}
		if(lb==lc)
		{
			lc.setIcon(new ImageIcon("images/cancel22.png"));
		}
	}

	public void mouseExited(MouseEvent me)
	{
		JLabel lb = (JLabel)me.getComponent();
		if(lb==ls)
		{
			ls.setIcon(new ImageIcon("images/submit1.png"));
		}
		if(lb==lc)
		{
			lc.setIcon(new ImageIcon("images/cancel11.png"));
		}
	}
	public void mouseClicked(MouseEvent me)
	{
		JLabel lb = (JLabel)me.getComponent();
		if(lb==ls)
		{
			try
			{
				con = Dao.makeConnection();
				ps = con.prepareStatement("select * from evening_login where login_name='"+t1.getText()+"' and email='"+t3.getText()+"'");
				rs = ps.executeQuery();
				if(rs.next())
				{
					JOptionPane.showMessageDialog(fr,"UserName = "+ rs.getString("login_name")+" Password = "+rs.getString("login_pass"));
				}
				else
				{	
					JOptionPane.showMessageDialog(fr,"oop's invalid username or email");
				}
				con.close();
			}
			catch(Exception e)
			{
			}	
		}
		if(lb==lc)
		{
			fr.dispose();
		}
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}

	public static void main(String args[])
	{
		new Forget();
	}
}