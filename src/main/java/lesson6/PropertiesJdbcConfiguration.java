package lesson6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PropertiesJdbcConfiguration implements JdbcConfiguration {
    public Configuration load() {
        Configuration configurationImpl=new Configuration();
        String confLine = null;
        String [] tokens;

        try(BufferedReader confReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/resources/properties"));) {
            while ((confLine = confReader.readLine())!=null) {
                tokens=confLine.split("=");
                if (tokens[0].equals("jdbc.database.name")) {configurationImpl.setDatabase(tokens[1]);}
                if (tokens[0].equals("jdbc.host")) {configurationImpl.setHost(tokens[1]);}
                if (tokens[0].equals("jdbc.port")) {configurationImpl.setPort(tokens[1]);}
                if (tokens[0].equals("jdbc.username")) {configurationImpl.setUsername(tokens[1]);}
                if (tokens[0].equals("jdbc.password")) {configurationImpl.setPassword(tokens[1]);}
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return configurationImpl;
    }
}
