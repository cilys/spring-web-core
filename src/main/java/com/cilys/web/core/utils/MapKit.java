package com.cilys.web.core.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2023/8/16.
 */
public class MapKit<T> {
    private Map<String, T> map;

    public MapKit() {
        map = new LinkedHashMap<>();
    }

    public MapKit<T> add(String key, T value) {
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        map.put(key, value);
        return this;
    }

    public Map<String, T> build() {
        return map;
    }

    public int size() {
        return map == null ? 0 : map.size();
    }
}
