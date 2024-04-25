package come.phonebook.testsRA;

import come.phonebook.dto.ContactDto;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteContactByIdTests extends TestBase {
    String id;

    @BeforeMethod
    public void precondition() {
        ContactDto contactDto = ContactDto.builder()
                .name("Iryna")
                .lastName("Yelunina")
                .email("ira@gmail.com")
                .phone("1234567890")
                .address("Kyiv")
                .description("student")
                .build();

        String message = given()
                .header(AUTH, TOKEN)
                .body(contactDto)
                .contentType(ContentType.JSON)
                .post("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().path("message");
//        System.out.println(message);Contact was added! ID: 13876b0e-5b7a-4347-b80e-bc347364e8e4

        String[] split = message.split(": ");
        id = split[1];
    }

    @Test
    public void deleteContactByIdSuccsessTest() {
        given()
                .header(AUTH, TOKEN)
                .delete("contacts/" + id)
                .then()
                .assertThat().statusCode(200)
//                .extract().path("message");
//        System.out.println(message);
                .assertThat().body("message", equalTo("Contact was deleted!"));


    }
}
