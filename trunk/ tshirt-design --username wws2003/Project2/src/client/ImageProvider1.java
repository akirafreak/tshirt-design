package client;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ImageProvider1 implements ImageProvider
{

	private ArrayList<Image> images;
	public ImageProvider1()
	{
	 ImageIcon []ics=new ImageIcon[8];
	 images=new ArrayList<Image>();
	 for(int i=1;i<9;i++)
	  {ics[i-1]=new ImageIcon("images/A"+i+".GIF");
	   images.add(i-1,ics[i-1].getImage());
	  }  
	}
	public void pullImages(ArrayList<Image>imgs) 
	{
		// TODO Auto-generated method stub
		images=imgs;
	}

	@Override
	public ArrayList<Image> pushImages() 
	{
		// TODO Auto-generated method stub
		return images;
	}

}
