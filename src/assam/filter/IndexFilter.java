package assam.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "indexFilter", urlPatterns = {"/index.jsp"})
public class IndexFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//server初始化
	}
	
	public static void main(String[] args) throws IOException {
		
		//---------------------------------------------------------
		//列出資料夾目錄
		//---------------------------------------------------------
		String path = "C:\\test";
		
		File file = new File(path);
		
		String[] filenames;
		String fullpath = file.getAbsolutePath();
		
		if(file.isDirectory()){
	        filenames=file.list();
	        for (int i = 0 ; i < filenames.length ; i++){         
	          File tempFile = new File(fullpath + "\\" + filenames[i]);
	          if(tempFile.isDirectory()){
	            System.out.println("目錄:" + filenames[i]);
	          }
	          else
	            System.out.println("檔案:" + filenames[i]);
	        }
	      }
	      else{
	    	  System.out.println("[" + file + "]不是目錄");
	      }
		//---------------------------------------------------------
		
		
		
		//---------------------------------------------------------
		//複製檔案
		//---------------------------------------------------------
		FileInputStream fileInputStream = new FileInputStream("C:\\test\\BigShort_01.mp4");
		FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\test\\BigShort_01_bk.mp4")); 
		
		byte[] buffer = new byte[1024];
		
		int idx = 0; 
        while ((idx = fileInputStream.read(buffer)) != -1) { 
                fileOutputStream.write(buffer, 0, idx); 
        } 
		
        fileInputStream.close();
        fileOutputStream.close();
        
        //----------------------------------------------------------
        
        //---------------------------------------------------------
	    //寫出檔案
	    //---------------------------------------------------------
        
        FileInputStream fileInputStream2=null;
        
        File file2 = new File("C:\\test\\BigShort_01.mp4");
        
        byte[] bFile = new byte[(int) file2.length()];
        
        try {
            //convert file into array of bytes
    	fileInputStream2 = new FileInputStream(file);
    	fileInputStream2.read(bFile);
    	fileInputStream2.close();
	       
	    for (int i = 0; i < bFile.length; i++) {
	       	System.out.print((char)bFile[i]);
            }
			
	    System.out.println("Done");
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
}
