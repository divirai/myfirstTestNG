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

public class NewUSer {

    reusableBody RJB;

    public int role=5;

    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;



    Response response;
    @BeforeClass
    public void Opeconnection()
    {
        System.out.println("Open connection");

        RJB=new reusableBody();
    }


    @Parameters({"requrl","name","SSN"})
    @Test(groups= {"smoke"})
    public void adduser(String requrl, String name, String SSN)
    {

        Opeconnection();
        Response rest = given()
                .contentType(ContentType.JSON)
                .body(RJB.CreateUserJsonBody(name, SSN))
                .when()
                .post(requrl);

        int statuccode =rest.statusCode();
        String responsebody =rest.getBody().asString();

        System.out.println("Ststus Code : " + statuccode);
        System.out.println("Response body: "+ responsebody);


        String userID =rest.getBody().jsonPath().getString("id");
        String job =rest.getBody().jsonPath().getString("job");

        System.out.println("Response body: "+ userID);
        System.out.println("Response body: "+ job);

    }


    @Parameters({"requrldelete"})
    @Test(groups= {"smoke"})
    public void deleteuser(String requrldelete)
    {

         when()
                .post(requrldelete).
                then().statusCode(415).log().all();

        System.out.println("User DSeletes ");

    }


    @Parameters({"celsURL","celsios","excpectefanse"})
    @Test(groups= {"reggresion"})
    public void clecusoistofanern(String celsURL, String celsious, String expcted)
    {

        Opeconnection();
        Response rest = given()
                .contentType(ContentType.XML)
                .body(RJB.celsios_to_farenrequestbosy(celsious))
                .when()
                .post(celsURL);

        int statuccode =rest.statusCode();
        String responsebody =rest.getBody().asString();

        System.out.println("Ststus Code : " + statuccode);
        System.out.println("Response body: "+ responsebody);


    }
    @Parameters({"bookurl"})
    @Test(groups= {"final"}, priority = 1)

    public void book_xml(String bookurl)
    {
        String baseurl=null;
        System.out.println( "Book XML URL is : "+bookurl);

    }



    @Test

    public void valiadateWithContains()
    {
        Response response = get("https://reqres.in/api/users?page=2");
        String res= response.getBody().asString();
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
        System.out.println("Close connection");
    }
}
