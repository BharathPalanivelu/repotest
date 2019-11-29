package com.garena.reactpush.data;

import java.util.HashMap;

public class ReactPack extends HashMap<String, String> {
    public String getPackURL(String str) {
        return (String) get(str);
    }
}
