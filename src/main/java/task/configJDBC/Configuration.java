package task.configJDBC;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Configuration {

    private static final String DEFAULT_PROPERTIES = "database.properties";

    private static Configuration instance;

    private final Properties props;

    private Configuration(String propertyFile) {
        String properties = propertyFile == null ? DEFAULT_PROPERTIES : propertyFile;
        try (InputStream stream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(properties)) {
            props = new Properties();
            props.load(stream);
        } catch (IOException e) {
            throw new IllegalStateException("Could not load database properties");
        }
    }

    public static Configuration getInstance() {
        return getInstance(null);
    }

    private static Configuration getInstance(String fileName) {
        if (instance == null) {
            instance = new Configuration(fileName);
        }
        return instance;
    }

    public String driver() {
        return props.getProperty(Props.DRIVER.getKey());
    }

    public String url() {
        return props.getProperty(Props.URL.getKey());
    }

    public String user() {
        return props.getProperty(Props.USER.getKey());
    }

    public String password() {
        return props.getProperty(Props.PASSWORD.getKey());
    }
}
