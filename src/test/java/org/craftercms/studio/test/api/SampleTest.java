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
 * Created by cortiz on 3/15/17.
 */

public class SampleTest {

    private JsonTester api;

    public SampleTest(){
        api = new JsonTester("http","localhost",8080);
    }

    @BeforeTest
    public void login(){
//        api.post("/studio/api/1/services/api/1/user/login.json")
//                .param("username","admin")
//                .param("password","admin")
//                .execute()
//                .status(200)
//                .header("Content-Language",is("en-US"))
//                .header("Content-Type",is("application/json;charset=UTF-8"))
//                .json("$",notNullValue())
//                .json("$.user.email",not(empty()))
//                .json("$.user.username",is("admin"));
    }


    @Test
    public void test(){
//       api.get("/studio/api/1/services/api/1/user/get-sites-3.json")
//               .execute().status(200).json("$", not(empty()));
    }

    @Test
    public void testExistSite(){
//        api.get("/studio/api/1/services/api/1/site/exists.json")
//                .urlParam("site", RandomStringUtils.randomAlphanumeric(10))
//                .execute()
//                .json("$.exists",is(false));

    }

    @Test
    public void testCreateSite(){
//        String siteName = RandomStringUtils.randomAlphabetic(5);
//        Map<String,Object> json=new HashMap<>();
//        json.put("blueprintName","website_editorial");
//        json.put("description",siteName);
//        json.put("siteId",siteName);
//        json.put("siteName",siteName);
//        api.post("/studio/api/1/services/api/1/site/create-site.json")
//                .json(json)
//                .execute()
//                .status(200);
//        api.get("/studio/api/1/services/api/1/site/exists.json")
//                .urlParam("site", siteName)
//                .execute()
//                .json("$.exists",is(true));
        
    }
}
