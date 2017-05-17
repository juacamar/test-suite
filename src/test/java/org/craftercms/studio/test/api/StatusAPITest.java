package org.craftercms.studio.test.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.craftercms.studio.test.utils.JsonTester;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;


/**
 * Created by gustavo ortiz
 */

public class StatusAPITest {

    private JsonTester api;

    public StatusAPITest(){
        api = new JsonTester("http","localhost",8080);
    }

    @Test
    public void testStatus(){
    	Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/monitor/status.json").json(json).execute().status(200);
		//.json("$.message", is("OK")).debug();
    }


 
}
