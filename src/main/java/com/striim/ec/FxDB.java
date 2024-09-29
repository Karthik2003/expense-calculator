package com.striim.ec;

import lombok.Getter;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;

public class FxDB {
    @Getter
    private static final FxDB instance = new FxDB();

    private static final String YAML_FILE = "src/main/resources/currency_value.yaml";
    private static HashMap currencyMap;

    @SneakyThrows
    private FxDB() {
        Yaml yaml = new Yaml();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(YAML_FILE);
            currencyMap = yaml.loadAs(inputStream, HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Objects.requireNonNull(inputStream).close();
        }
    }

    public static HashMap<Object, Object> getCurrencyRateDB() {
        return currencyMap;
    }

}
