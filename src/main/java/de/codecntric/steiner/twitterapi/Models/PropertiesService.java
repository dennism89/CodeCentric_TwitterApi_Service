package de.codecntric.steiner.twitterapi.Models;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dennisMsteiner on 29.08.16.
 */
@Service
public class PropertiesService {
    public Map<String, String> getEnvAndSystemProperties() {
        Properties properties = getProperties();

        Set<Map.Entry<Object, Object>> entries = getEntries(properties);
        Map<String, String> propMap = entries.stream().collect(Collectors.toMap(p -> (String) p.getKey(), p -> (String) p.getValue()));
        propMap.putAll(getEnv());

        Map<String, String> treeMap = new LinkedHashMap<>();

        propMap.entrySet().stream().sorted((p1, p2) -> p1.getKey().compareToIgnoreCase(p2.getKey()))
                .forEachOrdered(p -> treeMap.put(p.getKey(), p.getValue()));
        return treeMap;
    }

    private Set<Map.Entry<Object, Object>> getEntries(Properties properties) {
        return properties.entrySet();
    }

    private Properties getProperties() {
        return System.getProperties();
    }

    private Map<String, String> getEnv() {
        return System.getenv();
    }
}
