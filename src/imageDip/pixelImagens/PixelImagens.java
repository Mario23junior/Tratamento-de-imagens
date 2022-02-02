package imageDip.pixelImagens;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class PixelImagens {
  
	BufferedImage image;
	int width;
	int height;
	
	public PixelImagens() {
		
		try {
			
			File file = new File("img/hubble.png");
			
			image = ImageIO.read(file);
			width = image.getWidth();
			height = image.getHeight();
			
		 	int cout = 0;
			
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					cout++;
					
					Color cor = new Color(image.getRGB(i, j));
					System.out.println("s.NO : "+ +cout +
				     " Red   : " +cor.getRed()
					+" Green : " +cor.getGreen()
					+" Blue  : " +cor.getBlue());
				}
			}
			
		} catch (Exception e) {}
 	}
	
	public static void main(String[] args) {
		PixelImagens pixel = new PixelImagens();
        pixel.toString();
	}
}
