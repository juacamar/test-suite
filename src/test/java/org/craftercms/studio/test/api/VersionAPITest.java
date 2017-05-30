package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.JsonTester;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;



/**
 * Created by gustavo ortiz
 */

public class VersionAPITest {

    private JsonTester api;

    public VersionAPITest(){
        api = new JsonTester("http","localhost",8080);
    }

    @Test
    public void version(){
    	Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/monitor/version.json").json(json).execute().status(200);
		//.json("$.message", is("OK")).debug();
    }


 
}
