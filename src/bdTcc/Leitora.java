package bdTcc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;



public class Leitora {
	public static void main(String[] args) {
		
		String line;
        String shapeId="",textoFinal = "";
        int i = 0 ;
		 try {
			 FileReader in = new FileReader("path to GFST formated file");
			 FileWriter out = new FileWriter ("path to where you want to save JSON formated file");
				BufferedReader reader = new BufferedReader(in);
				BufferedWriter writer = new BufferedWriter(out);
				//BufferedWriter writer = Files.newBufferedWriter(result, charset,StandardOpenOption.APPEND);
		 
	            while((line = reader.readLine()) != null) {
	            	textoFinal = "";
	               // System.out.println(line);
	                String[] infoRota = new String[5];
	                infoRota = line.split((","));
	                
	                if(shapeId.equals(infoRota[0])){
	                    ++i;
	                    textoFinal += System.lineSeparator() + ",\""+String.valueOf(i+1)+"\"" + ":{"+"\"lat\":"+ infoRota[1].toString()+ "," + System.lineSeparator()+ "\"long\":" + infoRota[2].toString()+"}";
	                    System.out.println(textoFinal);
	                    writer.write(textoFinal);
	                    
	                }else {
	                    i=0;
	                    shapeId = infoRota[0];
	                    textoFinal += System.lineSeparator() + "},"+ System.lineSeparator();
	                    textoFinal+= infoRota[0] +":"+ "{" + System.lineSeparator() + "\""+ String.valueOf(i+1) +"\""+ ":{" +"\"lat\":"+ infoRota[1].toString()+ "," + System.lineSeparator()+ "\"long\":" + infoRota[2].toString()+"}";
	                    writer.write(textoFinal);
	                }
	            }
	            textoFinal += System.lineSeparator()+ "}"+System.lineSeparator()+"}";
	            reader.close();
	            writer.close();
	           // System.out.print(textoFinal);
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
	}
}
