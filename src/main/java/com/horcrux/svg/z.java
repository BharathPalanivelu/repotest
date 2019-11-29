package com.horcrux.svg;

import com.facebook.react.uimanager.ViewProps;
import com.tencent.cos.xml.BuildConfig;
import java.util.HashMap;
import java.util.Map;

class z {

    enum b {
        normal,
        italic,
        oblique
    }

    enum c {
        normal,
        none
    }

    enum e {
        start,
        middle,
        end
    }

    enum g {
        spacing,
        spacingAndGlyphs
    }

    enum h {
        align,
        stretch
    }

    enum i {
        sharp,
        smooth
    }

    enum j {
        left,
        right
    }

    enum k {
        auto,
        exact
    }

    enum a {
        baseline("baseline"),
        textBottom("text-bottom"),
        alphabetic("alphabetic"),
        ideographic("ideographic"),
        middle("middle"),
        central("central"),
        mathematical("mathematical"),
        textTop("text-top"),
        bottom(ViewProps.BOTTOM),
        center("center"),
        top(ViewProps.TOP),
        textBeforeEdge("text-before-edge"),
        textAfterEdge("text-after-edge"),
        beforeEdge("before-edge"),
        afterEdge("after-edge"),
        hanging("hanging");
        

        /* renamed from: a  reason: collision with root package name */
        private static final Map<String, a> f14931a = null;
        private final String alignment;

        static {
            int i;
            f14931a = new HashMap();
            for (a aVar : values()) {
                f14931a.put(aVar.alignment, aVar);
            }
        }

        private a(String str) {
            this.alignment = str;
        }

        static a a(String str) {
            if (f14931a.containsKey(str)) {
                return f14931a.get(str);
            }
            throw new IllegalArgumentException("Unknown String Value: " + str);
        }

        public String toString() {
            return this.alignment;
        }
    }

    enum d {
        Normal(BuildConfig.FLAVOR),
        Bold("bold"),
        Bolder("bolder"),
        Lighter("lighter"),
        w100("100"),
        w200("200"),
        w300("300"),
        w400("400"),
        w500("500"),
        w600("600"),
        w700("700"),
        w800("800"),
        w900("900");
        

        /* renamed from: a  reason: collision with root package name */
        private static final Map<String, d> f14932a = null;
        private final String weight;

        static {
            int i;
            f14932a = new HashMap();
            for (d dVar : values()) {
                f14932a.put(dVar.weight, dVar);
            }
        }

        private d(String str) {
            this.weight = str;
        }

        static d a(String str) {
            if (f14932a.containsKey(str)) {
                return f14932a.get(str);
            }
            throw new IllegalArgumentException("Unknown String Value: " + str);
        }

        public String toString() {
            return this.weight;
        }
    }

    enum f {
        None(ViewProps.NONE),
        Underline("underline"),
        Overline("overline"),
        LineThrough("line-through"),
        Blink("blink");
        

        /* renamed from: a  reason: collision with root package name */
        private static final Map<String, f> f14933a = null;
        private final String decoration;

        static {
            int i;
            f14933a = new HashMap();
            for (f fVar : values()) {
                f14933a.put(fVar.decoration, fVar);
            }
        }

        private f(String str) {
            this.decoration = str;
        }

        static f a(String str) {
            if (f14933a.containsKey(str)) {
                return f14933a.get(str);
            }
            throw new IllegalArgumentException("Unknown String Value: " + str);
        }

        public String toString() {
            return this.decoration;
        }
    }
}
