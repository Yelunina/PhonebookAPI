package come.phonebook.testsRA;

import come.phonebook.dto.AuthRequestDto;
import come.phonebook.dto.AuthResponseDto;
import come.phonebook.dto.ErrorDto;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends TestBase {

    AuthRequestDto auth = AuthRequestDto.builder()
            .username("yelunina@ukr.net")
            .password("Yelunina1234$")
            .build();


    @Test
    public void loginSuccessTest() {
        AuthResponseDto dto = given()
                .body(auth)
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);
        System.out.println(dto.getToken());
    }

    @Test
    public void loginSuccessTest2() {

        String responseToken = given()
                .body(auth)
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .body(containsString("token"))
                .extract().path("token");
        System.out.println(responseToken);
    }

    @Test
    public void loginWithWrongEmail() {
        given().body(AuthRequestDto.builder()
                        .username("yeluninaukr.net")
                        .password("Yelunina1234$")
                        .build())
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401)
                .assertThat().body("message",equalTo("Login or Password incorrect"));
 //               .extract().response().as(ErrorDto.class);
//        System.out.println(errorDto.getMessage());
//        System.out.println(errorDto.getError());


    }


}




