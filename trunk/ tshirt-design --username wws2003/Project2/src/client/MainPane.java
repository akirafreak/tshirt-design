package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MainPane extends JPanel
{

	/**
	 * @param args
	 */
	public MainPane()
	{
	 super();
	 this.setLayout(new GridLayout(1,2));
	 JTabbedPane pane1=new JTabbedPane();
	 DesignPane designPane=new DesignPane();
	 ArtPane artPane=new ArtPane(3,50,50,30,30,new ImageProvider1(),designPane);
	 artPane.setBackground(Color.white);
	 pane1.addTab("Add Art",new JScrollPane(artPane));
	 pane1.addTab("Add Text",new JPanel());
	 designPane.setBorder(new TitledBorder (new LineBorder (Color.red, 2),"Design Pane"));
	 this.add(pane1);
	 this.add(designPane);
	 pane1.setBackground(Color.white);
	 designPane.setBackground(Color.white);
	}
	public static void main(String[] args) 
	{
		MainPane m=new MainPane();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setSize(700,600);
	    window.setContentPane(m);
	    window.setVisible(true);
	}

}
