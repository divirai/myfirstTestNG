package reaXL;

import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import static io.restassured.RestAssured.get;

public class readSimpleXLfile
{

    // Workbook - Interface to instantiate different XL file.[xls/xlsx]
// Sheet - Interface to read the sheet inside the Workbook
// Row - Interface used to identify the row inside the sheet.
// Cell - Interface to identify the corresponding Cell of a given Row.


// CLASSES INSIDE APACHE POI


// XSSFWorkbook - Class which will implement Workbook interface for the XL file.
// HSSFWorkbook - Class which will implement Workbook interface for the XL file
// XSSFSheet - Class representing a Sheet interface.
// HSSFSheet - Class representing a Sheet interface.
// XSSFRow - Class representing a Row interface.
// HSSFRow - Class representing a Row interface.
// XSSFCell - Class representing a Cell interface.
// HSSFCell - Class representing a Cell interface.



    public static void read_and_print_xl_as_per_test_data(String Test_case_name, String columnName)
    {

        try
        {
            String XLFilePath = "C:\\Users\\divakarab\\IdeaProjects\\TestNGNEW\\src\\data.xlsx";
            FileInputStream myxlfile = new FileInputStream(XLFilePath);
            Workbook workbook = new XSSFWorkbook(myxlfile);
            Sheet sheet = workbook.getSheet("users");
            int last_row = sheet.getLastRowNum();
            System.out.println("The last row which has data ==> " + last_row);

            //Loop for Row Iteration
            for (int i = 0; i <= last_row; i++) {
                Row row = sheet.getRow(i);

                //Get Last column which has data
                int last_cell = row.getLastCellNum();
                Cell cell = row.getCell(0);
                String runtimeTCName = cell.getStringCellValue();
                // System.out.println("The First Column Value is:" + runtimeTCName);
                if (runtimeTCName.equals(Test_case_name))
                {
                    Row row_new = sheet.getRow(0);
                    for (int j = 0; j < last_cell; j++)
                    {
                        Cell cell_new = row_new.getCell(j);
                        String runtime_cell_value = cell_new.getStringCellValue();
                        if (runtime_cell_value.equals(columnName))
                        {
                            String value = sheet.getRow(i).getCell(j).toString();
                            System.out.println("The XL Value is:" + value);
                        }

                    }
                }
            }


        }

        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    public static void main(String[] args)
    {
        read_and_print_xl_as_per_test_data("TC107" , "Email");

    }

}

