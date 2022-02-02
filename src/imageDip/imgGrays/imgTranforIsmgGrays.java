package imageDip.imgGrays;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imgTranforIsmgGrays {
	
	public void GrayTransformer() {
		
		try {

		File file = new File("img/hubble.png");
		BufferedImage image = ImageIO.read(file);
		int altura = image.getWidth();
		int largura = image.getHeight();
		
		for(int i = 0; i < largura; i++) {
			
			for(int j = 0; j < altura; j++) {
				
				Color c = new Color(image.getRGB(j, i));
				int red = (int) (c.getRed() * 0.299);
				int green = (int) (c.getGreen() * 0.587);
				int blue = (int) (c.getBlue() * 0.114);
				
				Color novaCor = new Color(red + green + blue,
				red + green + blue , red + green + blue);
				
				image.setRGB(j, i, novaCor.getRGB());
			}
		}
		
		File saida = new File("img/hubble-img-final.png");
		ImageIO.write(image, "png", saida);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) {
    	imgTranforIsmgGrays newImage = new imgTranforIsmgGrays();
    	newImage.GrayTransformer();
	}

}

