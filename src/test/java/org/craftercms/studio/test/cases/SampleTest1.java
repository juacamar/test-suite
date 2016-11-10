package org.craftercms.studio.test.cases;

import java.io.File;

import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;

/**
 * Created by cortiz on 11/7/16.
 */

public class SampleTest1 {
    @Test
    public void nothing(){
        assertTrue(true);
        String binary = System.getProperty("phantomjs.binary");
        assertNotNull(binary);
        assertTrue(new File(binary).exists());

    }
}
