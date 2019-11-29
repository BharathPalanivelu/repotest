package com.google.maps.android.a.b;

import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import com.tencent.cos.xml.BuildConfig;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class o {
    static n a(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        n nVar = new n();
        a(xmlPullParser.getAttributeValue((String) null, "id"), nVar);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("Style")) {
                return nVar;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("IconStyle")) {
                    a(xmlPullParser, nVar);
                } else if (xmlPullParser.getName().equals("LineStyle")) {
                    e(xmlPullParser, nVar);
                } else if (xmlPullParser.getName().equals("PolyStyle")) {
                    f(xmlPullParser, nVar);
                } else if (xmlPullParser.getName().equals("BalloonStyle")) {
                    b(xmlPullParser, nVar);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    private static void a(String str, n nVar) {
        if (str != null) {
            nVar.b("#" + str);
        }
    }

    private static void a(XmlPullParser xmlPullParser, n nVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("IconStyle")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("heading")) {
                        nVar.d(Float.parseFloat(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals("Icon")) {
                        c(xmlPullParser, nVar);
                    } else if (xmlPullParser.getName().equals("hotSpot")) {
                        d(xmlPullParser, nVar);
                    } else if (xmlPullParser.getName().equals("scale")) {
                        nVar.a(Double.parseDouble(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals(ViewProps.COLOR)) {
                        nVar.f(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("colorMode")) {
                        nVar.g(xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    static HashMap<String, String> b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = "#" + xmlPullParser.getAttributeValue((String) null, "id");
        int eventType = xmlPullParser.getEventType();
        Boolean bool = false;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("StyleMap")) {
                return hashMap;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("key") && xmlPullParser.nextText().equals(BuildConfig.FLAVOR)) {
                    bool = true;
                } else if (xmlPullParser.getName().equals("styleUrl") && bool.booleanValue()) {
                    hashMap.put(str, xmlPullParser.nextText());
                    bool = false;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    private static void b(XmlPullParser xmlPullParser, n nVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("BalloonStyle")) {
                if (eventType == 2 && xmlPullParser.getName().equals("text")) {
                    nVar.a(xmlPullParser.nextText());
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    private static void c(XmlPullParser xmlPullParser, n nVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("Icon")) {
                if (eventType == 2 && xmlPullParser.getName().equals(ShareConstants.WEB_DIALOG_PARAM_HREF)) {
                    nVar.d(xmlPullParser.nextText());
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    private static void d(XmlPullParser xmlPullParser, n nVar) {
        Float valueOf = Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue((String) null, "x")));
        Float valueOf2 = Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue((String) null, "y")));
        nVar.b(valueOf.floatValue(), valueOf2.floatValue(), xmlPullParser.getAttributeValue((String) null, "xunits"), xmlPullParser.getAttributeValue((String) null, "yunits"));
    }

    private static void e(XmlPullParser xmlPullParser, n nVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("LineStyle")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals(ViewProps.COLOR)) {
                        nVar.j(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("width")) {
                        nVar.a(Float.valueOf(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals("colorMode")) {
                        nVar.h(xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    private static void f(XmlPullParser xmlPullParser, n nVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("PolyStyle")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals(ViewProps.COLOR)) {
                        nVar.e(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("outline")) {
                        nVar.b(a.a(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals("fill")) {
                        nVar.a(a.a(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals("colorMode")) {
                        nVar.i(xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }
}
