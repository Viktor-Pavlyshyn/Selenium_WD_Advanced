package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataPropLoader {

    public static String loadProperties(final String resource, final String key) {
        Properties props = new Properties();
        try (InputStream inputStream = DataPropLoader.class.getClassLoader().getResourceAsStream(resource)) {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(key);
    }

    public static String getBrowserProperty(String keyProp) {
        return loadProperties("browser.properties", keyProp);
    }

    public static String getNodeCapabilityProperty(String keyProp) {
        return loadProperties("nodeCapability.properties", keyProp);
    }
}
