package imageDip.contrast;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class CompresionImg {

	public static void main(String[] args) {

		try {

			File entrada = new File("img/hubble.png");
			BufferedImage image = ImageIO.read(entrada);

			File imgCompressada = new File("img/compres.png");
			OutputStream compre = new FileOutputStream(imgCompressada);
			
			Iterator<ImageWriter> writes = ImageIO.getImageWritersByFormatName("png");
			ImageWriter writer = (ImageWriter) writes.next();
			
			ImageOutputStream render = ImageIO.createImageOutputStream(compre);
			writer.setOutput(render);
			
			ImageWriteParam param = writer.getDefaultWriteParam();
			
			param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			param.setCompressionQuality(0.06f);
			writer.write(null, new IIOImage(image, null, null),param);
			
			render.close();
			compre.close();
			writer.dispose();

		} catch (Exception e) {
		}
	}
}
