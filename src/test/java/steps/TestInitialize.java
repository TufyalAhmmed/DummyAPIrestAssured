package steps;

import io.cucumber.java.Before;
import pages.RestAssuredExtension;

public class TestInitialize {
    @Before
    public void TestSetup(){
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
}
