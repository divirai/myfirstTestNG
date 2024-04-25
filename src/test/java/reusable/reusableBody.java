package reusable;


import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
public class reusableBody {

    public String CreateUserJsonBody(String name , String SSN){

        String body = "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \"AUTOMATION TESTER\",\n" +
                "    \"Address\": \"123 Bangalore Karnataka\",\n" +
                "    \"SSN\": \"" +SSN+ "\"\n" +
                "}";

        return body;
    }

    public String celsios_to_farenrequestbosy(String Celc)

    {
       String  request_body1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CelsiusToFahrenheitResponse xmlns=\"https://www.w3schools.com/xml/\">\n" +
                "      <CelsiusToFahrenheitResult>"+Celc+"</CelsiusToFahrenheitResult>\n" +
                "    </CelsiusToFahrenheitResponse>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>" ;

        return request_body1;


    }



    public String readingXLFileAsPerTestData(String testcaseName, String colName) {

        String data = null;
        try {
            // String xlFile = System.getProperty(user.dir)
            String xlFile = "C:\\Users\\divakarab\\IdeaProjects\\TestNGNEW\\src\\data.xlsx";
            FileInputStream myxlfile1 = new FileInputStream(xlFile);
            Workbook workbook = new XSSFWorkbook(myxlfile1);
            Sheet sheet = workbook.getSheet("new");
            int lastrow = sheet.getLastRowNum();
            System.out.println("The last row number which has data is:" + lastrow);

            //loop for row iteration
            for (int i = 0; i <= lastrow; i++) {
                Row row = sheet.getRow(i);
                //get the  last column which has data
                int lastCell = row.getLastCellNum();
                Cell cell = row.getCell(0);
                String runTimeTestCaseName = cell.getStringCellValue();

                if (runTimeTestCaseName.equals(testcaseName)) {

                    //Loop for column iteration
                    Row rowNew = sheet.getRow(0);
                    for (int j = 1; j < lastCell; j++) {
                        Cell cell1 = rowNew.getCell(j);
                        String runTimeCellValue = cell1.getStringCellValue();
                        if (runTimeCellValue.equals(colName)) {
                            data = sheet.getRow(i).getCell(j).toString();
                            System.out.println("The title value is :" + data);
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return data;
    }


    public String workshopreadlexcelfile(int year, int population) {

        String data = null;
        try {
            // String xlFile = System.getProperty(user.dir)
            String xlFile = "C:\\Users\\divakarab\\IdeaProjects\\TestNGNEW\\src\\data.xlsx";
//go to File
            FileInputStream myxlfile1 = new FileInputStream(xlFile);
            //got to workbook
            Workbook workbook = new XSSFWorkbook(myxlfile1);
            Sheet sheet = workbook.getSheet("work");
            int lastrow = sheet.getLastRowNum();
            System.out.println("The last row number which has data is:" + lastrow);

            //loop for row iteration
            for (int i = 0; i <= lastrow; i++) {
                Row row = sheet.getRow(i);
                //get the  last column which has data
                int lastCell = row.getLastCellNum();
                Cell cell = row.getCell(0);
                String runTimeTestCaseName = cell.getStringCellValue();

                if (runTimeTestCaseName.equals(year)) {

                    //Loop for column iteration
                    Row rowNew = sheet.getRow(0);
                    for (int j = 1; j < lastCell; j++) {
                        Cell cell1 = rowNew.getCell(j);
                        String runTimeCellValue = cell1.getStringCellValue();
                        if (runTimeCellValue.equals(population)) {
                            data = sheet.getRow(i).getCell(j).toString();
                            System.out.println("The title value is :" + data);
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return data;
    }

    public String statuscodeconvert(String statuscode) {

        String Flag = null;

        {

            try
            {
                float f;
                int val;
                f = Float.parseFloat(statuscode);
                val =(int)f;
                Flag=String.valueOf(val);
                System.out.println("The last row number which has data is:" + Flag);



            }
            catch (Exception e) {
                e.printStackTrace();

            }


            return Flag;


        }
    }

}