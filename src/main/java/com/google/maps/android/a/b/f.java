package com.google.maps.android.a.b;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.a.d;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class f extends d {
    public f(GoogleMap googleMap, InputStream inputStream, Context context) throws XmlPullParserException, IOException {
        if (inputStream != null) {
            m mVar = new m(googleMap, context);
            i iVar = new i(a(inputStream));
            iVar.a();
            inputStream.close();
            mVar.b(iVar.b(), iVar.d(), iVar.c(), iVar.e(), iVar.f());
            a(mVar);
            return;
        }
        throw new IllegalArgumentException("KML InputStream cannot be null");
    }

    private static XmlPullParser a(InputStream inputStream) throws XmlPullParserException {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(inputStream, (String) null);
        return newPullParser;
    }

    public void c() throws IOException, XmlPullParserException {
        super.a();
    }

    public Iterable<b> b() {
        return super.b();
    }
}
