package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class Response {

    public Map<String, Object> error(String msg) {
        Map<String, Object> json = new HashMap<>();
        json.put("error", msg);
        return json;
    }

    public Map<String, Object> success(String msg) {
        Map<String, Object> json = new HashMap<>();
        json.put("success", msg);
        return json;
    }

}
