package com.thoughtworks.xstream.annotations;

import com.thoughtworks.xstream.XStream;

@Deprecated
public class Annotations {
    private Annotations() {
    }

    @Deprecated
    public static synchronized void configureAliases(XStream xStream, Class<?>... clsArr) {
        synchronized (Annotations.class) {
            xStream.processAnnotations((Class[]) clsArr);
        }
    }
}
