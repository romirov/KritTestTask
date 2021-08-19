package com.krit;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import com.krit.entities.Nalog;
import com.krit.services.DBService;
import com.krit.services.ExcellService;
import com.krit.services.FileService;
import java.util.logging.Logger;

/**
 * 
 * @author hanza
 * Класс Krit запускает остальные классы
 *
 */
public class Krit {
	private static Logger logger = Logger.getLogger(Krit.class.getName());

	public static void main(String[] args) {
		logger.info("Application started");
		FileService fileService = new FileService();

		logger.info("Searching files with extensions '.xls' and '.xlsx' in directory 'To_load'");
		fileService.findFiles();

		logger.info("Put the necessary files in the list");
		List<Path> pathXlsFilesList = fileService.getPathXlsFilesList();
		List<Path> pathXlsxFilesList = fileService.getPathXlsxFilesList();
		ExcellService excellService = new ExcellService();
		List<Nalog> nalogListXls = new ArrayList<>();

		if(!pathXlsFilesList.isEmpty()) {
			logger.info("Parse file with extension '.xls'");
			pathXlsFilesList.forEach(path -> {
				nalogListXls.addAll(excellService.parseXls(path));
			});
		}

		logger.info("If the list of files is not empty, then we parse files for the list of taxes");
		if(!nalogListXls.isEmpty()) {
			nalogsFromExcelltoDB(nalogListXls);
		}

		List<Nalog> nalogListXlsx = new ArrayList<>();
		if(!pathXlsxFilesList.isEmpty()) {
			logger.info("Parse file with extension '.xlsx'");
			logger.info("Parse file with extension '.xlsx'");
			pathXlsxFilesList.forEach(path -> {
				nalogListXlsx.addAll(excellService.parseXlsx(path));
			});
		}

		if(!nalogListXlsx.isEmpty()) {
			nalogsFromExcelltoDB(nalogListXlsx);
		}

		logger.info("Application finished");
	}
	
	public static void nalogsFromExcelltoDB(List<Nalog> nalogList) {
		DBService dbService = new DBService();
		nalogList.forEach(nalog -> {
			dbService.insert(nalog);
		});
		dbService.closeConnection();
	}
}
