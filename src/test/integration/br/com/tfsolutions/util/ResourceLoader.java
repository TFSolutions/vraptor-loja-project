package br.com.tfsolutions.util;

public class ResourceLoader {
  
  public static String filePath(String path) {
    return ResourceLoader.class.getResource(path).getFile();
  }
  
}
