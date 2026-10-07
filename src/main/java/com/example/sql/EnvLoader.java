package com.example.sql;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {
    public static final String dirPath = "C:/Users/User/IdeaProjects/sql";

    public static Dotenv dotenv = Dotenv.configure()
            .directory(dirPath)
            .load();

    public static String get(String key){
        return dotenv.get(key);
    }

    public static String get(String key, String defaultValue){
        return dotenv.get(key, defaultValue);
    }


}
