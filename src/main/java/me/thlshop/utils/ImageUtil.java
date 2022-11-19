package me.thlshop.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImageUtil {
	public static HashMap<String, String> mageHandle(HttpServletRequest request, String realPath){
		HashMap<String, String> fields = new HashMap<String, String>();
		String fileName = "";
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			
			for (FileItem item : items) {
				if (item.isFormField()) {
					// Process regular form field (input type="text|radio|checkbox|etc", select,
					// etc).
					fields.put(item.getFieldName(), item.getString());
				} else {
					// Process form file field (input type="file").
					fields.put(item.getFieldName(), item.getName());
					fileName = item.getName();
					if (fileName == null || fileName.equals("")) {

					} else {
						Path path = Paths.get(fileName);
						File uploadFile = new File(realPath + "/" + path.getFileName());
						item.write(uploadFile);
					}
				}
			}
			return fields;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
