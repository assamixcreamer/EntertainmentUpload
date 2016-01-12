package assam.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VideoServlet", urlPatterns = {"/video.mp4"})
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileInputStream fileInputStream=null;
		
		File file = new File("C:\\test\\BigShort_01.mp4");
        
		int fileSize = (int)file.length();
		
        //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
        
        OutputStream os = response.getOutputStream();
        
        //write to out output stream
        while(true){
        	 int bytedata = fileInputStream.read();

             if (bytedata == -1)
             {
                  break;
             }

             os.write(bytedata);
        }

        // flush and close streams.....
        fileInputStream.close();
        os.flush();
        os.close();
        
        response.setIntHeader("Content-Length", fileSize);
        response.setContentType("video/mp4");
        response.flushBuffer();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
}
