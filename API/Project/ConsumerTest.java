package Projects;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)

public class ConsumerTest {
    Map<String, String> headers = new HashMap<>();

    //Create the contract
    @Pact(consumer = "UserConsumer", provider = "UserProvider")

    public RequestResponsePact createPact(PactDslWithProvider builder){
        //Required headers
        headers.put("Content-Type","application/json");

        //Request and Response body

        DslPart requestandResponseBody= new PactDslJsonBody()
                .numberType("id",8679)
                .stringType("firstName","Poulami")
                .stringType("lastName","Das")
                .stringType("email","pdas54@gmail.com");

        //Interaction

        return builder.given("create a user")
                .uponReceiving("a request to create a user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(requestandResponseBody)
                .willRespondWith()
                .status(201).body(requestandResponseBody)
                .toPact();

    }

    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void postRequestTest(){
        Map<String, Object> reqBody= new HashMap<>();
        reqBody.put("id",8679);
        reqBody.put("firstName","Poulami");
        reqBody.put("lastName","Das");
        reqBody.put("email","pdas54@gmail.com");

        //Send request ,get response and assert response
        given().baseUri("http://localhost:8282").headers(headers).body(reqBody).log().all().
                when().post("/api/users")
                .then().statusCode(201).body("firstName",equalTo("Poulami")).log().all();
    }
}
