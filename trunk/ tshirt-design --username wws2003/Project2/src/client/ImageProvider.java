package client;

import java.awt.Image;
import java.util.ArrayList;

public interface ImageProvider 
{
 public ArrayList<Image>pushImages();
 public void pullImages(ArrayList<Image>imgs);
}
