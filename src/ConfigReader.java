import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties labels = new Properties();
    private static final Properties config = new Properties();

    static{
        loadProperties(labels, "Resources/labels.properties");
        loadProperties(config, "Resources/config.properties");
    }

    private static void loadProperties(Properties properties, String filePath){
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                System.out.println("Sorry, unable to find labels.properties");
            }
            // Load properties from file
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get properties by key
    public String getLabel(String key) {
        return labels.getProperty(key);
    }

    public String getConfig(String key) {
        return config.getProperty(key);
    }

}