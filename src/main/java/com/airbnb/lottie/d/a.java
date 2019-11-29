package com.airbnb.lottie.d;

import com.airbnb.lottie.c;

public enum a {
    Json(".json"),
    Zip(".zip");
    
    public final String extension;

    private a(String str) {
        this.extension = str;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    public String toString() {
        return this.extension;
    }

    public static a forFile(String str) {
        for (a aVar : values()) {
            if (str.endsWith(aVar.extension)) {
                return aVar;
            }
        }
        c.b("Unable to find correct extension for " + str);
        return Json;
    }
}
