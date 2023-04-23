package com.codewithdurgesh.blog.services.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codewithdurgesh.blog.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		// this will return original filw name
		String name = file.getOriginalFilename();

		// to assign randomId name to the file
		String randomId = UUID.randomUUID().toString();
		System.out.println("random ID name generated for the file");

		// it will assign last extention to file name eg. png , jpg
		String fileName1 = randomId.concat(name.substring(name.lastIndexOf('.')));
		System.out.println("file name generated after random id : " + fileName1);

		// this will generate the file path to .png or .jpg
		String filePath = path + File.separator + fileName1;

		// this file object will point to the file from the file system
		File f = new File(path);

		// we are creating folder if we dont have one
		if (!f.exists()) {
			f.mkdir();
		}

		// here we will copy the file
		// file.getInputStream() -> it will provide the data (It will throw an
		// exception)
		// Paths.get(filePath) -> this is where i need to copy the data
		Files.copy(file.getInputStream(), Paths.get(filePath));

		// returning file name
		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {

		String fullPath = path + File.separator + fileName;

		InputStream is = new FileInputStream(fullPath);

		return is;
	}

}
