package com.krit.services;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author hanza
 * Класс для поиска по директории файлов с расширением .xls и .xlsx
 * 
 */
public class FileService {
	private List<Path> pathXlsFilesList;
	private List<Path> pathXlsxFilesList;
	private String strPath = "To_load";
	private static Logger logger = Logger.getLogger(FileService.class.getName());
	
	public void findFiles() {
		pathXlsFilesList = new ArrayList<>();
		pathXlsxFilesList = new ArrayList<>();
		try(DirectoryStream<Path> files = Files.newDirectoryStream(Path.of(strPath))){
			files.forEach(path -> {
				try {
					if(Files.isRegularFile(path) && Files.size(path) > 0){
						if(getFileExtension(path).equals("xls")) {
							logger.info("Add file " + path.getFileName() + " to the list of files");
							pathXlsFilesList.add(path);
						} else if(getFileExtension(path).equals("xlsx")) {
							logger.info("Add file " + path.getFileName() + " to the list of files");
							pathXlsxFilesList.add(path);
						}
					}
				} catch (IOException e) {
					logger.log(Level.SEVERE, e.getMessage());
				}
			});
			if(!pathXlsFilesList.isEmpty()) {
				logger.info("List excell files with extension '.xls': " + pathXlsFilesList.toString());
			}
			if(!pathXlsxFilesList.isEmpty()) {
				logger.info("List excell files with extension '.xlsx': " + pathXlsxFilesList.toString());
			}
		}catch(Exception e){
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
	
	public String getFileExtension(Path path) {
		String fileName = path.toFile().getName();
		int dotIndex = fileName.lastIndexOf('.');
		return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
	}
	
	public List<Path> getPathXlsFilesList(){
		return pathXlsFilesList;
	}
	
	public List<Path> getPathXlsxFilesList(){
		return pathXlsxFilesList;
	}
}
