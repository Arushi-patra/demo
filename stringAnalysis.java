//Design a GUI application as shown below which consists of two 	text fields and various buttons for String operations. On clicking 	any of the button, the corresponding operation will be performed 	on the entered string in the first text field and the resultant 	string will be displayed in the second text field.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class stringAnalysis
{
	JPanel p1;
	JFrame f1;
	JTextField tinput,toutput;
	JButton bupper,blower,binvert,bwords,bletters,brev,bvfreq,blfreq,binitcap;
	JButton res;
	JLabel lin,lout;
	JComboBox cb1;
	String m="abcdefghijklmnopqrstuvwxyz";

	public stringAnalysis()
	{
		f1=new JFrame("My first Frame");
		f1.setVisible(true);
		f1.setSize(500,500);

		tinput=new JTextField(120);
		toutput=new JTextField(120);
		lin=new JLabel("Enter the string:");
		bupper=new JButton("IN CAPS");
		blower=new JButton("IN SMALL");
		binvert=new JButton("CONVERT CASE");
		bwords=new JButton("WORDS");
		bletters=new JButton("LETTERS");
		brev=new JButton("REVERSE");
		bvfreq=new JButton("VOWELS");
		blfreq=new JButton("FREQUENCY");
		binitcap=new JButton("BEGIN CAPS");
		cb1=new JComboBox();

		res=new JButton("RESET");
		lout=new JLabel("  ");

		p1=new JPanel();
		f1.getContentPane().add(p1);
		p1.setLayout(null);
		p1.setBackground(Color.pink);

		lin.setBounds(50,100,200,20);           p1.add(lin);
		tinput.setBounds(250,100,300,20);       p1.add(tinput);

		lout.setBounds(50,150,200,20);          p1.add(lout);
		toutput.setBounds(250,150,300,20);      p1.add(toutput);
		lout.setVisible(false);
		toutput.setVisible(false);

		bupper.setBounds(20,350,80,20);   		p1.add(bupper);
		blower.setBounds(175,350,90,20);  		p1.add(blower);
		binvert.setBounds(340,350,130,20);      p1.add(binvert);
		bwords.setBounds(545,350,90,20);        p1.add(bwords);
		bletters.setBounds(710,350,100,20);     p1.add(bletters);
		brev.setBounds(90,370,95,20);           p1.add(brev);
		bvfreq.setBounds(255,370,95,20);        p1.add(bvfreq);
		blfreq.setBounds(450,370,115,20);   	p1.add(blfreq);
		binitcap.setBounds(615,370,115,20);   	p1.add(binitcap);
		cb1.setVisible(false);
		cb1.setBounds(250,150,70,20);			p1.add(cb1);
		res.setBounds(370,420,100,20);
		res.setBackground(Color.blue);
		res.setForeground(Color.white);
		p1.add(res);

		inner obj1=new inner();
		bupper.addActionListener(obj1);
		blower.addActionListener(obj1);
		binvert.addActionListener(obj1);
		bwords.addActionListener(obj1);
		bletters.addActionListener(obj1);
		brev.addActionListener(obj1);
		bvfreq.addActionListener(obj1);
		blfreq.addActionListener(obj1);
		binitcap.addActionListener(obj1);
		res.addActionListener(obj1);
	}
	class inner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj=e.getSource();
			String s=tinput.getText();
			String m3;
			int i=s.length();
			char t[];
			char t1[];
			t1=new char[26];
			t=new char[i];
			int arr[];

			lout.setVisible(true);
			toutput.setVisible(true);
			arr=new int[26];
			for(int h=0;h<26;h++)
			{
				arr[h]=0;
			}
			if(obj==bupper)
			{
				cb1.setVisible(false);
				toutput.setVisible(true);
				lout.setText("String in upper case: ");
				toutput.setText(s.toUpperCase());
			}
			if(obj==blower)
			{
				cb1.setVisible(false);
				toutput.setVisible(true);
				lout.setText("String in lower case: ");
				toutput.setText(s.toLowerCase());
			}
			if(obj==binvert)
			{
				cb1.setVisible(false);
				toutput.setVisible(true);
				lout.setText("String in reverse case: ");
				for(int j=0;j<i;j++)
				{
					t[j]=s.charAt(j);
				   	if((int)t[j]>=97 && (int)t[j]<=122)
						t[j]=(char)((int)(t[j])-32);
				   	else if((int)t[j]>=65 && (int)t[j]<=97)
						t[j]=(char)((int)(t[j])+32);
				   	else
					    t[j]=t[j];
				}
				toutput.setText(String.copyValueOf(t,0,i));
		 	}
			if(obj==bwords)
			{
				cb1.setVisible(false);
				toutput.setVisible(true);
				lout.setText("String is having total words: ");
				int k=0;
				for(int j=0;j<i-1;j++)
				{
					t[j]=s.charAt(j);
					t[j+1]=s.charAt(j+1);
				   	if((int)t[j]==32 && (int)t[j+1]!=32)
					{
						k++;
					}
				}
				toutput.setText(String.valueOf(k+1));
		 	}
			if(obj==bletters)
			{
				cb1.setVisible(false);
				toutput.setVisible(true);
				lout.setText("String is having total letters: ");
				int k=0;
				for(int j=0;j<i;j++)
				{
					t[j]=s.charAt(j);
					if((int)t[j]!=32)
					{
						k++;
					}
				}
				toutput.setText(String.valueOf(k));
		 	}
		 	if(obj==brev)
		 	{
				cb1.setVisible(false);
				toutput.setVisible(true);
				String g;
				lout.setText("String in reverse order is:");


				StringBuffer str=new StringBuffer(s);
				g=String.valueOf(str.reverse());
				toutput.setText(g);
			}
			if(obj==bvfreq)
			{
				cb1.setVisible(false);
				toutput.setVisible(true);
				int k1=0;int k2=0;int k3=0;int k4=0;int k5=0;
				lout.setText("String has vowels occuring:");
				for(int j=0;j<i;j++)
				{
					t[j]=s.charAt(j);
					if(t[j]=='a'||t[j]=='A')
					{
						k1++;
					}
					if(t[j]=='e'||t[j]=='E')
					{
						k2++;
					}if(t[j]=='i'||t[j]=='I')
					{
						k3++;
					}
					if(t[j]=='o'||t[j]=='U')
					{
						k4++;
					}
					if(t[j]=='u'||t[j]=='U')
					{
						k5++;
					}
				}
				toutput.setText("a or A="+k1+", e or E="+k2+", i or I="+k3+", o or O="+k4+", u or U="+k5);
			}

			if(obj==blfreq)
			{
				cb1.setVisible(true);
				toutput.setVisible(false);
				lout.setText("String has letters occuring:");

				for(int j=0;j<i;j++)
				{
					char t5=s.charAt(j);
					int j1=m.indexOf(String.valueOf(t5));
					//System.out.println(j1);
					if(j1!=-1)
					{
						arr[j1]=arr[j1]+1;
					}
				}

				for(int j=0;j<26;j++)
				{
					char t6=m.charAt(j);
					cb1.addItem(String.valueOf(t6)+"="+String.valueOf(arr[j]));
				}
			}
			if(obj==binitcap)
			{
				cb1.setVisible(false);
				toutput.setVisible(true);
				lout.setText("String beginning with caps: ");
				t=s.toCharArray();
				if((int)t[0]<65 || (int)t[0]>90)
				{
					t[0]=(char)(((int)t[0])-32);
				}
				for(int j=1;j<i;j++)
				{
					if((int)t[j]==32 && (int)t[j+1]!=32)
					{
						if((int)t[j+1]>=97 && (int)t[j+1]<=122)
						{
							t[j+1]=(char)(((int)t[j+1])-32);
						}
					}
				}
				m3=String.copyValueOf(t,0,i);
				toutput.setText(m3);
			}
			if(obj==res)
			{
				tinput.setText("");

				lout.setVisible(false);
				toutput.setVisible(false);
				cb1.setVisible(false);
			}
		}

	}
	public static void main(String[] args)
			{
				stringAnalysis kk =new stringAnalysis();
		}
}