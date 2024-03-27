package lms.utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ExcelReader {

    public List<Map<String, String>> readTestDataFromExcel(String filePath, String sheetName) throws IOException {
        List<Map<String, String>> testData = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        // Assuming first row contains header names
        Row headerRow = sheet.getRow(0);
        int numColumns = headerRow.getLastCellNum();

        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row dataRow = sheet.getRow(rowIndex);
            Map<String, String> rowData = new HashMap<>();

            for (int columnIndex = 0; columnIndex < numColumns; columnIndex++) {
                Cell headerCell = headerRow.getCell(columnIndex);
                Cell dataCell = dataRow.getCell(columnIndex);

                String header = headerCell.getStringCellValue();
                String value = "";

                if (dataCell != null) {
                    switch (dataCell.getCellType()) {
                        case STRING:
                            value = dataCell.getStringCellValue();
                            break;
                        case NUMERIC:
                            value = String.valueOf(dataCell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            value = String.valueOf(dataCell.getBooleanCellValue());
                            break;
                        default:
                            value = dataCell.toString();
                    }
                }

                rowData.put(header, value);
            }
            testData.add(rowData);
        }

        workbook.close();
        fis.close();
        return testData;
    }
}