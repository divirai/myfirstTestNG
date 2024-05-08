package GetUser;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.Assert;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static java.sql.Types.NUMERIC;
import static org.codehaus.groovy.syntax.Types.STRING;

import reusable.reusableBody;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class workshop

{
    String year = null;
    reusableBody rs;

    //Added some code
    String address=null;

    @BeforeClass
    public void setUp()
    {

        rs = new reusableBody();
    }
    String population;


    @Test
    public void readfrom_excelpratice()
    {


        try {

            //String ops=new FileOutputStream("C:/Users/divakarab/test1.txt");


            String filepath="C:/Users/divakarab/IdeaProjects/TestNGNEW/src/data.xlsx";
            //open the file
            FileInputStream inputsteam =new FileInputStream(filepath);
            //get the work book
            Workbook workbook = new XSSFWorkbook(inputsteam);
//get Sheet
            Sheet sheet =workbook.getSheet("users");
          int rocount=sheet.getLastRowNum();
            int colsms=sheet.getRow(1).getLastCellNum();
            System.out.println("Number of rows : :"+ rocount);
          //  String celldata=sheet.getRow(5).getCell(2).getStringCellValue();


            System.out.println("Value in Cell is : :"+ colsms);


            for (int r=0;r<=rocount;r++)

            {
                Row row = sheet.getRow(r);


                for (int c=0;c<=colsms;c++)

                {
                    Cell cell = row.getCell(c);

           switch (cell.getCellType())

           {

               case STRING: System.out.println(cell.getStringCellValue());
           }
                }



                }


//USing for loop



        }

        catch (Throwable e)
        {
            System.out.println("No file Found");
        }

    }


}
