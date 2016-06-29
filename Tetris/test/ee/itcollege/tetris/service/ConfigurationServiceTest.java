package ee.itcollege.tetris.service;

import main.java.ee.itcollege.tetris.service.ConfigurationService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eriks on 28.06.2016.
 */
public class ConfigurationServiceTest {

    @Test
    public void test() throws Exception {



        ConfigurationService service = new ConfigurationService();
        try {
            service.loadFile("test/test.properties");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("value", service.getStringValue("key"));
        assertEquals(123, service.getIntValue("numeric"));
        assertEquals("ajee", service.getStringValue("test.with.dots"));
        assertEquals("testing whitespace", service.getStringValue("whitespace"));
        assertEquals(null, service.getStringValue("notpresent"));
    }
}