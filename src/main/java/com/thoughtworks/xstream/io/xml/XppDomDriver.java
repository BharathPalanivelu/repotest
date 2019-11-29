package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XppDomDriver extends AbstractXppDomDriver {
    private static XmlPullParserFactory factory;

    public XppDomDriver() {
        super(new XmlFriendlyNameCoder());
    }

    public XppDomDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    public XppDomDriver(XmlFriendlyReplacer xmlFriendlyReplacer) {
        super(xmlFriendlyReplacer);
    }

    /* access modifiers changed from: protected */
    public synchronized XmlPullParser createParser() throws XmlPullParserException {
        if (factory == null) {
            factory = XmlPullParserFactory.newInstance((String) null, XppDomDriver.class);
        }
        return factory.newPullParser();
    }
}
