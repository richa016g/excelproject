import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login implements MouseListener
{
public JFrame fr;
public JLabel l1,l2,l3,l4,lg,lc;
public JTextField t1;
public JPasswordField t2;

Connection con;
PreparedStatement ps;
ResultSet rs;

int w,h;
	public Login()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		w = dim.width;
		h = dim.height;
		fr = new JFrame("Login Form");
		fr.setBounds((w-450)/2,(h-300)/2,450,300);
		fr.setContentPane(new JLabel(new ImageIcon("images/login.png")));
		
		l1 = new JLabel("UserName");
		l2 = new JLabel("Password");
		l3 = new JLabel("<html><u>Sign Up</u></html>");
		l4 = new JLabel("<html><u>Forget Password</u></html>");

		l1.setBounds(65,120,150,30);
		l1.setFont(new Font("verdana",Font.BOLD,16));
		l1.setForeground(Color.pink);
		
		l2.setBounds(65,160,150,30);
		l2.setFont(new Font("verdana",Font.BOLD,16));
		l2.setForeground(Color.pink);

		l3.setBounds(65,230,50,20); 
		l3.setFont(new Font("verdana",Font.BOLD,11));
		l3.setForeground(Color.red);

		l4.setBounds(65,260,120,20); 
		l4.setFont(new Font("verdana",Font.BOLD,11));
		l4.setForeground(Color.red);

		l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		l3.addMouseListener(this);
		l4.addMouseListener(this);

		fr.add(l1);
		fr.add(l2);
		fr.add(l3);
		fr.add(l4);

		t1 = new JTextField();
		t2 = new JPasswordField();
		t1.setBounds(180,120,200,25);
		t2.setBounds(180,160,200,25);
		t1.setFont(new Font("verdana",Font.BOLD,16));
		t2.setFont(new Font("verdana",Font.BOLD,16));
		t1.setForeground(Color.green);
		t2.setForeground(Color.green);
		t1.setOpaque(false);
		t2.setOpaque(false);
		
		fr.add(t1);
		fr.add(t2);

		lg = new JLabel(new ImageIcon("images/log1.png"));
		lg.setBounds(187,200,90,30);
		lg.addMouseListener(this);
		lg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fr.add(lg);

		lc = new JLabel(new ImageIcon("images/cancel1.png"));
		lc.setBounds(283,200,90,30);
		lc.addMouseListener(this);
		lc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fr.add(lc);

		fr.setUndecorated(true);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void mouseEntered(MouseEvent me)	
	{
		JLabel lb = (JLabel)me.getComponent();
		if(lb==l3)
		{
		l3.setForeground(Color.green);
		}
		if(lb==l4)
		{
		l4.setForeground(Color.green);
		}
		if(lb==lg)
		{
		lg.setIcon(new ImageIcon("images/log2.png"));
		}
		if(lb==lc)
		{
		lc.setIcon(new ImageIcon("images/cancel2.png"));
		}
	}
	public void mouseExited(MouseEvent me)
	{
		JLabel lb = (JLabel)me.getComponent();
		if(lb==l3)
		{
		l3.setForeground(Color.red);
		}
		if(lb==l4)
		{
		l4.setForeground(Color.red);
		}
		if(lb==lg)
		{
		lg.setIcon(new ImageIcon("images/log1.png"));
		}
		if(lb==lc)
		{
		lc.setIcon(new ImageIcon("images/cancel1.png"));
		}
	}
	public void mouseClicked(MouseEvent me)
	{
		JLabel lb = (JLabel)me.getComponent();
		if(lb==lc)
		{
			fr.dispose();
		}
		if(lb==l3)
		{
			new Signup();
		}
		if(lb==l4)	
		{
			new Forget();
		}
		if(lb==lg)
		{
			try
			{
				/*con = Dao.makeConnection();
				ps = con.prepareStatement("select * from excel_login where username='"+t1.getText()+"' and password='"+t2.getText()+"'");
				rs = ps.executeQuery();
				if(rs.next())
				{
					JOptionPane.showMessageDialog(fr,"welcome, "+t1.getText());
				*/
					new mainform();
				/*}
				else
				{	
					JOptionPane.showMessageDialog(fr,"oop's invalid username or password");
				}
				con.close();*/
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(fr,""+e);
			}	
		}
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}


	public static void main(String args[])
	{
		new Login();	
	}
}