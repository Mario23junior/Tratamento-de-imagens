package imageDip.downloads;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class downloadsImage {
   
	public static void main(String[] args) {
		
		try {
			String nameFile = "hubble_ngc3318_potw2203a_0.png";
			String webSiteFont = "https://www.nasa.gov/sites/default/files/thumbnails/image/"+nameFile;
			
			System.out.println("Downloads de arquivo esta na base "+ webSiteFont);
			
			URL url = new URL(webSiteFont);
			InputStream inputStream = url.openStream();
			OutputStream saida = new FileOutputStream(nameFile);
			byte[] buffer = new byte[2048];
			
			int tamanho = 0;
			
			while((tamanho = inputStream.read(buffer)) != -1) {
				System.out.println("Comprimento de arquivo :" + tamanho);
				saida.write(buffer, 0, tamanho);
			}
			
			inputStream.close();
			saida.close();
			
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}
	
}
