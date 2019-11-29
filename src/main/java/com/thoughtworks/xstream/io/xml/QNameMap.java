package com.thoughtworks.xstream.io.xml;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;

public class QNameMap {
    private String defaultNamespace = "";
    private String defaultPrefix = "";
    private Map javaToQName;
    private Map qnameToJava;

    public String getJavaClassName(QName qName) {
        Map map = this.qnameToJava;
        if (map != null) {
            String str = (String) map.get(qName);
            if (str != null) {
                return str;
            }
        }
        return qName.getLocalPart();
    }

    public QName getQName(String str) {
        Map map = this.javaToQName;
        if (map != null) {
            QName qName = (QName) map.get(str);
            if (qName != null) {
                return qName;
            }
        }
        return new QName(this.defaultNamespace, str, this.defaultPrefix);
    }

    public synchronized void registerMapping(QName qName, String str) {
        if (this.javaToQName == null) {
            this.javaToQName = Collections.synchronizedMap(new HashMap());
        }
        if (this.qnameToJava == null) {
            this.qnameToJava = Collections.synchronizedMap(new HashMap());
        }
        this.javaToQName.put(str, qName);
        this.qnameToJava.put(qName, str);
    }

    public synchronized void registerMapping(QName qName, Class cls) {
        registerMapping(qName, cls.getName());
    }

    public String getDefaultNamespace() {
        return this.defaultNamespace;
    }

    public void setDefaultNamespace(String str) {
        this.defaultNamespace = str;
    }

    public String getDefaultPrefix() {
        return this.defaultPrefix;
    }

    public void setDefaultPrefix(String str) {
        this.defaultPrefix = str;
    }
}
