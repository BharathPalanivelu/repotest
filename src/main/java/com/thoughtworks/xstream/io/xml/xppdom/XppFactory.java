package com.thoughtworks.xstream.io.xml.xppdom;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XppFactory {
    public static XmlPullParser createDefaultParser() throws XmlPullParserException {
        return XmlPullParserFactory.newInstance().newPullParser();
    }

    public static XppDom buildDom(String str) throws XmlPullParserException, IOException {
        return buildDom((Reader) new StringReader(str));
    }

    public static XppDom buildDom(Reader reader) throws XmlPullParserException, IOException {
        XmlPullParser createDefaultParser = createDefaultParser();
        createDefaultParser.setInput(reader);
        return XppDom.build(createDefaultParser);
    }

    public static XppDom buildDom(InputStream inputStream, String str) throws XmlPullParserException, IOException {
        XmlPullParser createDefaultParser = createDefaultParser();
        createDefaultParser.setInput(inputStream, str);
        return XppDom.build(createDefaultParser);
    }
}
