package app.project.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FileDownloadController {
	
	private static final String INTERNAL_FILE="..//static//MyFile.pdf";
	
	@GetMapping("/download/{type}")
	public void downloadFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException{
		
		File file = null;
		
		if(type.equalsIgnoreCase("internal")) {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			file = new File(classloader.getResource(INTERNAL_FILE).getFile());
		} else {
			System.out.println("File path not found !!!");
		}
		
		if(!file.exists()){
			String errorMessage = "File does not exist";
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}
		
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if(mimeType == null ){
			System.out.println("mimetype is not detectable,will take default");
			mimeType = "application/octet-stream";
		}
		
		System.out.println("mimeType" +mimeType);
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		response.setContentLength((int)file.length());
		
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
	
}
