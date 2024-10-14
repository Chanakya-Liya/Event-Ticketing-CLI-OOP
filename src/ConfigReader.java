import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputOne = ConfigReader.class.getClassLoader().getResourceAsStream("Resources/config.properties")) {
            if (inputOne == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            // Load properties from file
            properties.load(inputOne);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get properties by key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}