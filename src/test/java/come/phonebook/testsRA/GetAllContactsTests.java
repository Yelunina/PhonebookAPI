package come.phonebook.testsRA;

import come.phonebook.dto.AllContactDto;
import come.phonebook.dto.ContactDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllContactsTests extends TestBase {

    @Test
    public void getAllContactsTest() {
        AllContactDto contactsDto = given()
                .header(AUTH, TOKEN)
                .when()
                .get("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllContactDto.class);
        for (ContactDto contact: contactsDto.getContacts()){
            System.out.println(contact.getId()+"***"+contact.getName());
            System.out.println("==================================");
        }

    }

}
