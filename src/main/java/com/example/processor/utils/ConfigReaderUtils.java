package com.example.processor.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ConfigReaderUtils {

    public static <K> K yamlReader(Class<K> configObject, String configFile) {
       try{
           ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
           File file = new File(classLoader.getResource(configFile).getFile());
           ObjectMapper om = new ObjectMapper(new YAMLFactory());
           return om.readValue(file, configObject);
       }catch (Exception e){
           throw new RuntimeException(e);
       }
    }
}
