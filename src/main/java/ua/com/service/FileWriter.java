package ua.com.service;

import org.springframework.web.multipart.MultipartFile;


public interface FileWriter {

	enum Folder{
		Models , TYPES
	}
	
	boolean write(Folder folder, MultipartFile file, int id);
	
}
