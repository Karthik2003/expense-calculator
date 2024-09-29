package com.striim.ec;

import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class FxDB {
    private static final FxDB instance = new FxDB();
    private static final String YAML_FILE = "src/main/resources/currency_value.yaml";
    private static HashMap<Object, Object> currencyMap;

    @SneakyThrows
    private FxDB() {
        Yaml yaml = new Yaml();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(YAML_FILE);
            this.currencyMap = yaml.loadAs(inputStream, HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            inputStream.close();
        }
    }

    public static HashMap<Object, Object> getCurrencyRateDB() {
        return currencyMap;
    }

    public static FxDB getInstance() {
        return instance;
    }
}
