package androidx.core.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Shader f1632a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f1633b;

    /* renamed from: c  reason: collision with root package name */
    private int f1634c;

    private b(Shader shader, ColorStateList colorStateList, int i) {
        this.f1632a = shader;
        this.f1633b = colorStateList;
        this.f1634c = i;
    }

    static b a(Shader shader) {
        return new b(shader, (ColorStateList) null, 0);
    }

    static b a(ColorStateList colorStateList) {
        return new b((Shader) null, colorStateList, colorStateList.getDefaultColor());
    }

    static b a(int i) {
        return new b((Shader) null, (ColorStateList) null, i);
    }

    public Shader a() {
        return this.f1632a;
    }

    public int b() {
        return this.f1634c;
    }

    public void b(int i) {
        this.f1634c = i;
    }

    public boolean c() {
        return this.f1632a != null;
    }

    public boolean d() {
        if (this.f1632a == null) {
            ColorStateList colorStateList = this.f1633b;
            return colorStateList != null && colorStateList.isStateful();
        }
    }

    public boolean a(int[] iArr) {
        if (d()) {
            ColorStateList colorStateList = this.f1633b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f1634c) {
                this.f1634c = colorForState;
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        return c() || this.f1634c != 0;
    }

    public static b a(Resources resources, int i, Resources.Theme theme) {
        try {
            return b(resources, i, theme);
        } catch (Exception e2) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
            return null;
        }
    }

    private static b b(Resources resources, int i, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            char c2 = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c2 = 0;
                }
            } else if (name.equals("gradient")) {
                c2 = 1;
            }
            if (c2 == 0) {
                return a(a.a(resources, (XmlPullParser) xml, asAttributeSet, theme));
            }
            if (c2 == 1) {
                return a(d.a(resources, xml, asAttributeSet, theme));
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        throw new XmlPullParserException("No start tag found");
    }
}
