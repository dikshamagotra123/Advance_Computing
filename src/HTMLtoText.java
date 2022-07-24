import java.io.*;  
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

import org.jsoup.Jsoup;

import java.net.*;

public class HTMLtoText extends HTMLEditorKit.ParserCallback {
 StringBuffer s;

 public HTMLtoText() {}

 public void parse(Reader in) throws IOException {
   s = new StringBuffer();
   ParserDelegator delegator = new ParserDelegator();
   // the third parameter is TRUE to ignore charset directive
   delegator.parse(in, this, Boolean.TRUE);
 }

 public void handleText(char[] text, int pos) {
   s.append(text);
 }

 public String getText() {
   return s.toString();
 }

 public static void main(String[] args) throws IOException,FileNotFoundException,NullPointerException {

	 

	 int m = 1;

	 try {

	 File directoryPth = new File("/Users/dikshamagotra/Downloads/ACC search engine/Search-Engine-master/W3C Web Pages");

	 File[] FilesArrayA1 = directoryPth.listFiles();
	 System.out.println(FilesArrayA1.length);

	 File[] FilesArrayA2 = new File[103];

	 int totalCount=0;

	 for(int i=0;i<FilesArrayA1.length;i++)

	 {

		 if(FilesArrayA1[i].isFile())

	 {

	 FilesArrayA2[totalCount] = FilesArrayA1[i];

	 totalCount++;

	 }

	 }

	 for(int i=0;i<104;i++)

	 {

	 conversion(FilesArrayA2[i],m);

	 m = m + 1;

	 }

	 }

	  catch (Exception e) {

	 System.out.println("Exception:"+e);

	 }

	 finally

	 {

	 }

	  

	 }

	  

	 public static void conversion(File destinationfile,int m) throws IOException,FileNotFoundException,NullPointerException

	 {

	 try {

	 org.jsoup.nodes.Document _doc = Jsoup.parse(destinationfile, "UTF-8");

	 BufferedWriter bufferedWriterBW = new BufferedWriter(new FileWriter("/Users/dikshamagotra/Downloads/ACC search engine/Search-Engine-master/W3C Web Pages"+destinationfile.getName()+".txt"));

	 bufferedWriterBW.write(_doc.text());

	 bufferedWriterBW.close();

	 System.out.println("File "+destinationfile.getName()+" to  "+destinationfile.getName()+".txt");

	 } catch (Exception e) {

	 }

}
}