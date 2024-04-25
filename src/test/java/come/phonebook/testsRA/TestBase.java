package come.phonebook.testsRA;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {
public static final  String TOKEN="eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoieWVsdW5pbmFAdWtyLm5ldCIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNzE0NjM5NjExLCJpYXQiOjE3MTQwMzk2MTF9.IVrz-SEGoO2W1Z9ysjySJBlN4IAmFuNi2NxpTWjVsNc";
public static final String AUTH="Authorization";
    @BeforeMethod
    public void init(){
        RestAssured.baseURI="https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath="v1";
    }
}
