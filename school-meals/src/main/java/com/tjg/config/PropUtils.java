package com.tjg.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtils {
    /**
     * read properties in classpath
     *
     * @param filename file name
     * @return properties
     * @throws IOException e
     */
    public static Properties load(String filename) throws IOException {
        InputStream inputStream = PropUtils.class.getClassLoader().getResourceAsStream(filename);
        Properties prop = new Properties();
        prop.load(inputStream);
        return prop;
    }
}

