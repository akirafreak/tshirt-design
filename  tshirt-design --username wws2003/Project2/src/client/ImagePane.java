package client;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public abstract class ImagePane extends GriddedPanel
{
 protected ArrayList<Image> images;
 public void setImages(ImageProvider ip)
 {
  images=ip.pushImages();	 
 }
 public ArrayList<Image> getImages()
 {
  return images;	 
 }
}
