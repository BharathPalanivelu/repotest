package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

class w {

    /* renamed from: e  reason: collision with root package name */
    private static final String f32626e = "com.threatmetrix.TrustDefenderMobile.w";

    /* renamed from: a  reason: collision with root package name */
    public int f32627a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f32628b = "";

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<String> f32629c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<URI> f32630d = new ArrayList<>();

    w() {
    }

    private boolean a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next = xmlPullParser.next();
        String str = "";
        while (next != 1) {
            if (next == 0) {
                Log.d(f32626e, "Found start document tag unexpectedly");
            } else if (next == 2) {
                str = xmlPullParser.getName();
            } else if (next != 3) {
                if (next != 4) {
                    String str2 = f32626e;
                    Log.d(str2, "Found unexpected event type: " + next);
                } else if (str != null) {
                    if (str.equals("P")) {
                        this.f32629c.add(xmlPullParser.getText());
                    } else {
                        String str3 = f32626e;
                        Log.d(str3, "Found tag content unexpectedly: " + str);
                    }
                }
            } else if (xmlPullParser.getName().equals("PS")) {
                return true;
            }
            next = xmlPullParser.next();
        }
        return false;
    }

    private boolean b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next = xmlPullParser.next();
        String str = "";
        while (next != 1) {
            if (next == 0) {
                Log.d(f32626e, "Found start document tag unexpectedly");
            } else if (next == 2) {
                str = xmlPullParser.getName();
            } else if (next != 3) {
                if (next != 4) {
                    String str2 = f32626e;
                    Log.d(str2, "Found unexpected event type: " + next);
                } else if (str != null) {
                    if (str.equals("E")) {
                        try {
                            this.f32630d.add(new URI(xmlPullParser.getText()));
                        } catch (URISyntaxException e2) {
                            Log.e(f32626e, "Failed to parse E into URI", e2);
                        }
                    } else {
                        String str3 = f32626e;
                        Log.d(str3, "Found tag content unexpectedly: " + str);
                    }
                }
            } else if (xmlPullParser.getName().equals("EX")) {
                return true;
            }
            next = xmlPullParser.next();
        }
        return false;
    }

    public boolean a() {
        String str = this.f32628b;
        return str != null && !str.isEmpty();
    }

    public boolean a(InputStream inputStream) {
        boolean z = false;
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new InputStreamReader(inputStream));
            String str = null;
            boolean z2 = false;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        if (eventType == 3) {
                            str = null;
                        } else if (eventType == 4) {
                            if (str != null) {
                                if (str.equals("w")) {
                                    this.f32628b = newPullParser.getText();
                                } else if (str.equals("O")) {
                                    this.f32627a = Integer.valueOf(newPullParser.getText()).intValue();
                                }
                            }
                        }
                    } else if (newPullParser.getName().equals("PS")) {
                        if (a(newPullParser)) {
                        }
                    } else if (!newPullParser.getName().equals("EX")) {
                        str = newPullParser.getName();
                    } else if (!b(newPullParser)) {
                    }
                    z2 = true;
                }
            }
            z = z2;
        } catch (IOException e2) {
            Log.e(f32626e, "IO Error", e2);
        } catch (XmlPullParserException e3) {
            Log.e(f32626e, "XML Parse Error", e3);
        }
        return !z;
    }
}
