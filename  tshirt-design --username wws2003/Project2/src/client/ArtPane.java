package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class ArtPane extends ImagePane implements MouseListener,MouseMotionListener
{
 private int col;
 private int f_width;
 private int f_height;
 private int width;
 private int height;
 private Rectangle[] image_Recs;
 private boolean[] isMouseOver;
 private DesignPane designPane;
 public ArtPane(int c,int fw,int fh,int w,int h,ImageProvider ivp,DesignPane dpane)
 {
  f_width=fw;
  f_height=fh;
  col=c;
  width=w;
  height=h;
  designPane=dpane;
  super.setImages(ivp);
  image_Recs=new Rectangle[images.size()];
  isMouseOver=new boolean[image_Recs.length];
  for(int i=0;i<isMouseOver.length;i++)
   isMouseOver[i]=false;	  
  this.addMouseListener(this);
  this.addMouseMotionListener(this);
  this.setFocusable(true);
 }
 public void paintComponent(Graphics G)
 {
  int l=0,c=0,i=0,d=(f_width-width)/2;
  int off_x=20;
  int off_y=20;
  super.paintComponent(G);
  for(Image img:images)
  {
   c=i%col;
   l=i/col;	  
   G.drawImage(img,off_x+c*f_width+d,off_y+l*f_height+d,width,height,this);
   image_Recs[i]=new Rectangle(off_x+c*f_width,off_y+l*f_height,f_width,f_height);
   if(isMouseOver[i])
   {
	G.setColor(Color.blue);
	G.drawRect(off_x+c*f_width,off_y+l*f_height,f_width,f_height);
	isMouseOver[i]=false;
   }
   i++;
  }
 }
@Override
public void mouseClicked(MouseEvent me) 
{
 int x=me.getX();
 int y=me.getY();	
 for(int i=0;i<image_Recs.length;i++)
 {
  if(image_Recs[i].contains(x, y))
  {
   designPane.addImages(images.get(i));
   designPane.repaint();
  }
 }
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseDragged(MouseEvent me) 
{

}
@Override
public void mouseMoved(MouseEvent me) 
{
	 int x=me.getX();
	 int y=me.getY();
	 for(int i=0;i<image_Recs.length;i++)
	 {
	  if(image_Recs[i].contains(x, y))
	  {isMouseOver[i]=true;
	   repaint();
	  }
	 }
	
}
}
