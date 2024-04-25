package GetUser;
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



public class webAPI {


    String testName = null;
    reusableBody rs;

    String url,statuscode,title;

    @BeforeClass
    public void setUp(){
        rs = new reusableBody();
    }

    @Test
    public void doAllWebAppTest(){
        testName = "TC001";
        url = rs.readingXLFileAsPerTestData(testName,"RequestURL");
      // statuscode = rs.readingXLFileAsPerTestData(testName,"StatusCode");

        statuscode = rs.statuscodeconvert(rs.readingXLFileAsPerTestData(testName,"StatusCode"));


        title = rs.readingXLFileAsPerTestData(testName,"Title");
        doWebApiValidation(url,statuscode,title);


        testName = "TC002";
        url = rs.readingXLFileAsPerTestData(testName,"RequestURL");
        statuscode = rs.readingXLFileAsPerTestData(testName,"StatusCode");
        title = rs.readingXLFileAsPerTestData(testName,"Title");
        doWebApiValidation(url,statuscode,title);

    }

    public static void doWebApiValidation (String url,String statuscode,String title) {

        Response response = get(url);
        String res = response.getBody().asString();

        Assert.assertEquals(String.valueOf(response.getStatusCode()),statuscode);
        Assert.assertTrue(res.contains(title));


    }
}
