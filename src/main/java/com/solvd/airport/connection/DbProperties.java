package com.solvd.airport.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DbProperties {

        private static String host;
        private static String name;
        private static String password;

        private static Properties properties = new Properties();

        public DbProperties(){

        }

        public DbProperties(String host, String name, String password) {
            DbProperties.host = host;
            DbProperties.name = name;
            DbProperties.password = password;
        }
    public static void loadProperties() {
        try (FileInputStream fileInputStream =
                     new FileInputStream("src/main/resources/db.properties")) {
            properties.load(fileInputStream);
            host = properties.getProperty("db.url");
            name = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
        } catch (IOException e) {

        }
    }

        public static String getHost() {
            return host;
        }
        public static String getName() {
            return name;
        }
        public static String getPassword() {
            return password;
        }

}
