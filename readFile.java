package read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class readFile {
	public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // ��������ÿ�ж�ȡ������
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // ��ȡ��һ��
        while (line != null) { // ��� line Ϊ��˵��������
            buffer.append(line); // ��������������ӵ� buffer ��
            buffer.append("\n"); // ��ӻ��з�
            line = reader.readLine(); // ��ȡ��һ��
        }
        reader.close();
        is.close();
	}
	  public static String readFile(String filePath) throws IOException {
	        StringBuffer sb = new StringBuffer();
	        readFile.readToBuffer(sb, filePath);
	        return sb.toString();
	    }
	  
	  public static void main(String args[])
	  {
		  try {
			String temp = readFile.readFile("E:\\EclipseForEEWorkspace\\hibernate-tutorial\\Events.json");
			temp = temp.replaceAll("##", "/");
			
			PrintWriter fout;
			try {
				fout = new PrintWriter(new FileOutputStream("E:\\EclipseForEEWorkspace\\hibernate-tutorial\\Events.json"));
				
				fout.println(temp.toString()); 
				fout.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  

		  
	  }
}
