package stepDefinitions;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.ConfigLoader;

public class Hooks {
    public static RequestSpecification requestSpec;

    @Before
    public void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(ConfigLoader.getBaseUri())
                .setContentType("application/json")
                .build();
    }
}