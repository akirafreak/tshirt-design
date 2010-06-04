package client;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class DesignPane extends ImagePane implements MouseListener,MouseMotionListener
{	
 private Image newImg;
 private ArrayList<Image> arts;
 private ArrayList<Rectangle> art_Recs;
 private ArrayList<Boolean> choose;
 private int dx=0;
 private int dy=0;
 public DesignPane()
 {
  images=new ArrayList<Image>();	
  arts=new ArrayList<Image>();
  art_Recs=new ArrayList<Rectangle>();
  choose=new ArrayList<Boolean>();
  this.addMouseListener(this);
  this.addMouseMotionListener(this);
 }
 public void addImages(Image img)
 {
  arts.add(img); 
  art_Recs.add(new Rectangle(20,20,30,30));
  choose.add(false);
  newImg=img;
 }
 public void paintComponent(Graphics G)
 {
  super.paintComponent(G);	
  int i=0;
  for(Rectangle rec:art_Recs)
  {
   G.drawImage(arts.get(i),(int)rec.getX(),(int)rec.getY(),(int)rec.getWidth(),(int)rec.getHeight(),this);
   i++;
  }
 }
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent arg0) 
{
	 for(int i=0;i<art_Recs.size();i++)
	  {
	   choose.set(i, false);
	  }
}
@Override
public void mousePressed(MouseEvent me) 
{ 
  int x = me.getX();  
  int y = me.getY();
  for(int i=0;i<art_Recs.size();i++)
  {
   if(!art_Recs.get(i).contains(x, y))continue;	  
   dx=(int) (x-art_Recs.get(i).getX());
   dy=(int) (y-art_Recs.get(i).getY()); 
   choose.set(i,true);
   break;
  }
}
@Override
public void mouseReleased(MouseEvent arg0) 
{
 for(int i=0;i<art_Recs.size();i++)
	  {
	   choose.set(i, false);
	  }
}
@Override
public void mouseDragged(MouseEvent me) 
{
 int x = me.getX();  
 int y = me.getY();
 for(int i=0;i<art_Recs.size();i++)	
 {
  if(choose.get(i))
  {
   art_Recs.get(i).setLocation(x-dx,y-dy); 
   repaint();
   break;
  }
 }
}
@Override
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}

