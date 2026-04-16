package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getTestData(String filePath, String sheetName) {

		DataFormatter formatter = new DataFormatter();
		List<Object[]> dataList = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				throw new RuntimeException("Sheet not found: " + sheetName);
			}

			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getLastCellNum();

			for (int i = 1; i < rowCount; i++) {

				Row row = sheet.getRow(i);

				// Skip null row
				if (row == null)
					continue;

				//Check if row is completely empty
				boolean isEmpty = true;

				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);
					String value = formatter.formatCellValue(cell).trim();

					if (!value.isEmpty()) {
						isEmpty = false;
						break;
					}
				}

				// ✅ Skip empty row
				if (isEmpty)
					continue;

				// ✅ Read row data
				Object[] rowData = new Object[colCount];

				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);

					// ⭐ Handles ALL types safely
					rowData[j] = formatter.formatCellValue(cell);
				}

				dataList.add(rowData);
			}

		} catch (IOException e) {
			throw new RuntimeException("Error reading Excel file: " + e.getMessage());
		}

		// Convert List → Object[][]
		Object[][] data = new Object[dataList.size()][];

		for (int i = 0; i < dataList.size(); i++) {
			data[i] = dataList.get(i);
		}

		return data;
	}
}