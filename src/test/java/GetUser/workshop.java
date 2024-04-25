package GetUser;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.testng.Assert;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import reusable.reusableBody;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.*;


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
    public void workshop(){
        year = "2021";
       // population = rs.workshopreadlexcelfile(year,"population");

        year = rs.statuscodeconvert(rs.readingXLFileAsPerTestData(year,"population"));


    }
    @Test
    public void getpopulation()
    {
        Response response = get("https://datausa.io/api/data?drilldowns=Nation&measures=Population");
        String res= response.getBody().asString();
        int jsonPathCount = response.getBody().jsonPath().getList("data.Year").size();
        System.out.println("Count is:"+jsonPathCount);
        for(int a = 0;a<jsonPathCount;a++){
            String yearfromAPI =response.getBody().jsonPath().getString("data.Year["+a+"]");
            String API_Population =response.getBody().jsonPath().getString("data.Population["+a+"]");
            System.out.println("Year API :"+yearfromAPI+"= Population API  :"+API_Population);
        }
    }



}
