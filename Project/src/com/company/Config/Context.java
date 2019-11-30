package com.company.Config;

import java.util.Properties;

public class Context {

  private static Properties config = Config.getProperties();

  public static Properties getConfig() {
    return config;
  }
}
