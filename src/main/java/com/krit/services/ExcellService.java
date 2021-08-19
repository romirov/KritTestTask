package com.krit.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import com.krit.entities.Nalog;

/**
 * 
 * @author hanza
 * Класс для работы с файлами формата .xls и .xlsx
 * 
 */
public class ExcellService {
	private List<Nalog> nalogList;
	private static Logger logger = Logger.getLogger(ExcellService.class.getName());
	private int tresholdCells = 28;
	
	public List<Nalog> parseXls(Path path) {
		logger.info("Parse the file " + path);
		InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        nalogList = new ArrayList<>();
        try {
            inputStream = new FileInputStream(path.toString());
            workBook = new HSSFWorkbook(inputStream);
            workBook.forEach(sheet -> {
            	logger.info("Parse the sheet " + sheet.getSheetName());
            	for(Row row : sheet) {
            		List<String> dataCells = new ArrayList<>();
            		for(Cell cell : row) {
            			switch(cell.getCellType()) {
            				case STRING:
            					dataCells.add(cell.getRichStringCellValue().getString());
            					break;
            				case NUMERIC:
	                        	dataCells.add(Double.toString(cell.getNumericCellValue()));
	                        	break;
            				case BLANK:
            					dataCells.add("0");
            					break;
            				default:
            					logger.info(cell.toString());
            			}
            		}
            		if(!dataCells.isEmpty() && dataCells.size() == tresholdCells) {
            			if(!dataCells.get(0).equals("0") && !dataCells.get(2).equals("0")) {
            				logger.info("Add tax to the list of taxes " + dataCells);
            				String ter = path.toFile().getName().substring(0, path.toFile().getName().indexOf("_"));
            				String dat = path.toFile().getName().substring(path.toFile().getName().indexOf("_") + 1, path.toFile().getName().lastIndexOf("."));
            				addNalogToNalogList(dataCells, ter, dat);
            			}
            		}
            	}
            });
        } catch (IOException e) {
        	logger.log(Level.SEVERE, e.getMessage());
        }
        return nalogList;
	}
	
	public List<Nalog> parseXlsx(Path path) {
		InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        nalogList = new ArrayList<>();
        try {
            inputStream = new FileInputStream(path.toString());
            workBook = new XSSFWorkbook(inputStream);
            workBook.forEach(sheet -> {
            	logger.info("Parse the sheet " + sheet.getSheetName());
            	for(Row row : sheet) {
            		List<String> dataCells = new ArrayList<>();
            		for(Cell cell : row) {
            			switch(cell.getCellType()) {
            			case STRING:
            					dataCells.add(cell.getRichStringCellValue().getString());
            					break;
            				case NUMERIC:
            					dataCells.add(Double.toString(cell.getNumericCellValue()));
            					break;
            				case BLANK:
            					dataCells.add("0");
            					break;
            				default:
            					logger.info(cell.toString());
            			}
            		}
            		if(!dataCells.isEmpty() && dataCells.size() == tresholdCells) {
            			if(!dataCells.get(0).equals("0") && !dataCells.get(2).equals("0")) {
            				logger.info("Add tax to the list of taxes " + dataCells);
            				String ter = path.toFile().getName().substring(0, path.toFile().getName().lastIndexOf("_"));
            				String dat = path.toFile().getName().substring(path.toFile().getName().indexOf("_") + 1, path.toFile().getName().lastIndexOf("."));
            				addNalogToNalogList(dataCells, ter, dat);
            			}
            		}
            	}
            });
        } catch (IOException e) {
        	logger.log(Level.SEVERE, e.getMessage());
        }
        return nalogList;
	}

	public void addNalogToNalogList(List<String> dataCells, String ter, String dat) {
		Nalog nalog = new Nalog();
		nalog.setFielda(dataCells.get(0));
		nalog.setFieldb(dataCells.get(1));
		nalog.setFieldv(dataCells.get(2));
		nalog.setField1(dataCells.get(3));
		nalog.setField2(dataCells.get(4));
		nalog.setField3(dataCells.get(5));
		nalog.setField4(dataCells.get(6));
		nalog.setField5(dataCells.get(7));
		nalog.setField6(dataCells.get(8));
		nalog.setField7(dataCells.get(9));
		nalog.setField8(dataCells.get(10));
		nalog.setField9(dataCells.get(11));
		nalog.setField10(dataCells.get(12));
		nalog.setField11(dataCells.get(13));
		nalog.setField12(dataCells.get(14));
		nalog.setField13(dataCells.get(15));
		nalog.setField14(dataCells.get(16));
		nalog.setField15(dataCells.get(17));
		nalog.setField16(dataCells.get(18));
		nalog.setField17(dataCells.get(19));
		nalog.setField18(dataCells.get(20));
		nalog.setField19(dataCells.get(21));
		nalog.setField20(dataCells.get(22));
		nalog.setField21(dataCells.get(23));
		nalog.setField22(dataCells.get(24));
		nalog.setField23(dataCells.get(25));
		nalog.setField24(dataCells.get(26));
		nalog.setField25(dataCells.get(27));
		nalog.setTer(ter);
		nalog.setDat(dat);
		logger.info("Tax added to the list of taxes " + nalog.toString());
		nalogList.add(nalog);
	}
	
	public List<Nalog> getNalog() {
		return nalogList;
	}
}
