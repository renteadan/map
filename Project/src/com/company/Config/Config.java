package com.company.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class Config {
  private static InputStream configPath = Config.class.getClassLoader().getResourceAsStream("resources/config.properties");

  static Properties getProperties() {
    Properties properties = new Properties();
    try {
      properties.load(configPath);
      return properties;
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Can't load config file");
    }
  }
}
