package GetUser;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class assignment1 {

    @Test
    public void assignemnt()
    {


        //Added some code
        String address1=null;
        Response response = get("https://dummyjson.com/products/1");
        String res= response.getBody().asString();
        int jsonPathCount = response.getBody().jsonPath().getList("id").size();
        System.out.println("Count is:"+jsonPathCount);
        for(int a = 0;a<jsonPathCount;a++){
            String tittle =response.getBody().jsonPath().getString("title["+a+"]");
            String price =response.getBody().jsonPath().getString("price["+a+"]");
            System.out.println("Titttle :"+tittle+" Popolation :"+price);
        }
    }



    @Test
    public void APIput()
    {


        //Added some code
        String address1=null;
        Response response = get("https://dummyjson.com/products/1");
        String res= response.getBody().asString();
        int jsonPathCount = response.getBody().jsonPath().getList("id").size();
        System.out.println("Count is:"+jsonPathCount);
        for(int a = 0;a<jsonPathCount;a++){
            String tittle =response.getBody().jsonPath().getString("title["+a+"]");
            String price =response.getBody().jsonPath().getString("price["+a+"]");
            System.out.println("Titttle :"+tittle+" Popolation :"+price);
        }
    }

}
