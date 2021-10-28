package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties prop;

    public ReadConfig() {
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("Exception is: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getApplicationURL() {
        String url = prop.getProperty("baseUrl");
        return url;
    }

    public String getUserName() {
        String user = prop.getProperty("username");
        return user;
    }

    public String getPassword() {
        String pass = prop.getProperty("password");
        return pass;
    }

    public String getBrowser() {
        String browser = prop.getProperty("browser");
        return browser;
    }

    public String getChromePath() {
        String cpath = prop.getProperty("chromepath");
        return cpath;
    }

    public String getFirefoxPath() {
        String fpath = prop.getProperty("firefoxpath");
        return fpath;
    }

    public String getIEPath() {
        String iepath = prop.getProperty("iepath");
        return iepath;
    }
}