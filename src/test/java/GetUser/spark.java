package GetUser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import reusable.reusableBody;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.*;

public class spark {



    public int role=5;

    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;




    @BeforeClass
    public void Opeconnection()
    {
        extent =new ExtentReports();
        spark =new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/Reqres11.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("QA" , "Divakar");
        spark.config().setDocumentTitle("RecRes Website GET API Details Validation");
        spark.config().setReportName("RecRes_GET_API_DETAILS");
        spark.config().setReportName("Divakar");
        logger=extent.createTest("Validate the Reqres calss");
    }
    @Test

    public void reqres_new(){

        logger.info("Smoke test email ID");
        Response response = get("https://reqres.in/api/users?page=2");
        logger.info("The Get api URL is https://reqres.in/api/users?page=2");
        String res= response.getBody().asString();

        logger.info("The Get api URL is "+ res);
        int jsonPathCount = response.getBody().jsonPath().getList("data.first_name").size();
        System.out.println("Count is:"+jsonPathCount);
        for(int a = 0;a<jsonPathCount;a++){
            String id =response.getBody().jsonPath().getString("data.id["+a+"]");
            String email =response.getBody().jsonPath().getString("data.email["+a+"]");
            System.out.println("If id value is:"+id+" Then email value is:"+email);
        }


    }





    @AfterClass
    public void closeconnection()
    {
         extent.flush();
    }
}
