package hadoop;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

public class lector {
	
	  public static void main(String[] args) {
	        // Aquí la carpeta donde queremos buscar
	        String path = "C:/Users/JOHNCARDOZO/Desktop/";
	        
	        archivo[] encont;

	        String files;
	        File folder = new File(path);
	        File[] listOfFiles = folder.listFiles();
	        File archivo = null;
	        FileReader fr = null;
	        BufferedReader br = null;
	        
	        String textXT = "";

	        encont = new archivo[listOfFiles.length];

	        for (int i = 0; i < listOfFiles.length; i++) {
	            encont[i] = new archivo();
	            if (listOfFiles[i].isFile()) {
	                files = listOfFiles[i].getName();

	                textXT = "";
	                
	                try {
	                    archivo = new File("" + listOfFiles[i]);
	                    fr = new FileReader(archivo);
	                    br = new BufferedReader(fr);
	                    String linea = "";
	                    System.out.println("");
	                    System.out.println("");
	                    System.out.println("---------------------------------------------------------------------");
	                    System.out.println("document nombre: " + listOfFiles[i].getName());
	                    if (files.endsWith(".docx") || files.endsWith(".DOCX")) {
	                        FileInputStream fis = new FileInputStream(archivo);

	                        encont[i].setNombre(listOfFiles[i].getName());
	                        encont[i].setRuta(listOfFiles[i].getPath());
	                    } else {
	                        while ((linea = br.readLine()) != null) {
	                            System.out.println(linea);
	                            textXT += linea;
	                        }

	                        encont[i].setNombre(listOfFiles[i].getName());
	                        encont[i].setRuta(listOfFiles[i].getPath());

	                    }
	                    System.out.println("---------------------------------------------------------------------");
	                    System.out.println("");
	                    System.out.println("");

	                } catch (Exception e) {
	                    System.err.println("error al leer: " + e);
	                }

	            }
	        }

	         for (int i = 0; i < encont.length-1; i++) {
	            archivo encont1 = encont[i];

	             System.out.println(i+1+". nombre: "+encont1.getNombre());
	             System.out.println("   similitud "+encont1.getValor()*100+"%");	             
	             System.out.println("   rut: "+encont1.getRuta());
	             System.out.println("--------------------------------------------------------------");
	        }
	    }

	//  


}
