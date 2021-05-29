package com.oizovita;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Config
 */
public class Config {
    private Map<String, String> env;
    private static Config instance;
    private Properties property;

    /**
     * Constructor
     *
     * @throws IOException
     */
    private Config() throws IOException {
        this.env = System.getenv();
        this.property = new Properties();
        InputStream in = ClassLoader.getSystemResourceAsStream("properties");
        this.property.load(in);
    }

    /**
     * Initialization config instance
     *
     * @return Config
     * @throws IOException
     */
    public static Config init() throws IOException {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    /**
     * Get type
     *
     * @return String
     */
    public String type() {
        return this.env.getOrDefault("TYPE", "int");
    }

    /**
     * Get max
     *
     * @return String
     */
    public String max() {
        return this.property.getProperty("max", "10");
    }

    /**
     * Get max
     *
     * @return String
     */
    public String min() {
        return this.property.getProperty("min", "0");
    }

    /**
     * Get max
     *
     * @return String
     */
    public String step() {
        return this.property.getProperty("step", "2");
    }
}
