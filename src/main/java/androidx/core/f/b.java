package androidx.core.f;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.util.c;
import java.util.concurrent.Executor;

public class b implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1708a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Executor f1709b = null;

    /* renamed from: c  reason: collision with root package name */
    private final Spannable f1710c;

    /* renamed from: d  reason: collision with root package name */
    private final a f1711d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final PrecomputedText.Params f1712a = null;

        /* renamed from: b  reason: collision with root package name */
        private final TextPaint f1713b;

        /* renamed from: c  reason: collision with root package name */
        private final TextDirectionHeuristic f1714c;

        /* renamed from: d  reason: collision with root package name */
        private final int f1715d;

        /* renamed from: e  reason: collision with root package name */
        private final int f1716e;

        /* renamed from: androidx.core.f.b$a$a  reason: collision with other inner class name */
        public static class C0032a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f1717a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f1718b;

            /* renamed from: c  reason: collision with root package name */
            private int f1719c;

            /* renamed from: d  reason: collision with root package name */
            private int f1720d;

            public C0032a(TextPaint textPaint) {
                this.f1717a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f1719c = 1;
                    this.f1720d = 1;
                } else {
                    this.f1720d = 0;
                    this.f1719c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f1718b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f1718b = null;
                }
            }

            public C0032a a(int i) {
                this.f1719c = i;
                return this;
            }

            public C0032a b(int i) {
                this.f1720d = i;
                return this;
            }

            public C0032a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f1718b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f1717a, this.f1718b, this.f1719c, this.f1720d);
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            this.f1713b = textPaint;
            this.f1714c = textDirectionHeuristic;
            this.f1715d = i;
            this.f1716e = i2;
        }

        public a(PrecomputedText.Params params) {
            this.f1713b = params.getTextPaint();
            this.f1714c = params.getTextDirection();
            this.f1715d = params.getBreakStrategy();
            this.f1716e = params.getHyphenationFrequency();
        }

        public TextPaint a() {
            return this.f1713b;
        }

        public TextDirectionHeuristic b() {
            return this.f1714c;
        }

        public int c() {
            return this.f1715d;
        }

        public int d() {
            return this.f1716e;
        }

        public boolean a(a aVar) {
            PrecomputedText.Params params = this.f1712a;
            if (params != null) {
                return params.equals(aVar.f1712a);
            }
            if ((Build.VERSION.SDK_INT >= 23 && (this.f1715d != aVar.c() || this.f1716e != aVar.d())) || this.f1713b.getTextSize() != aVar.a().getTextSize() || this.f1713b.getTextScaleX() != aVar.a().getTextScaleX() || this.f1713b.getTextSkewX() != aVar.a().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f1713b.getLetterSpacing() != aVar.a().getLetterSpacing() || !TextUtils.equals(this.f1713b.getFontFeatureSettings(), aVar.a().getFontFeatureSettings()))) || this.f1713b.getFlags() != aVar.a().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f1713b.getTextLocales().equals(aVar.a().getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.f1713b.getTextLocale().equals(aVar.a().getTextLocale())) {
                return false;
            }
            if (this.f1713b.getTypeface() == null) {
                if (aVar.a().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f1713b.getTypeface().equals(aVar.a().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f1714c == aVar.b();
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return c.a(Float.valueOf(this.f1713b.getTextSize()), Float.valueOf(this.f1713b.getTextScaleX()), Float.valueOf(this.f1713b.getTextSkewX()), Float.valueOf(this.f1713b.getLetterSpacing()), Integer.valueOf(this.f1713b.getFlags()), this.f1713b.getTextLocales(), this.f1713b.getTypeface(), Boolean.valueOf(this.f1713b.isElegantTextHeight()), this.f1714c, Integer.valueOf(this.f1715d), Integer.valueOf(this.f1716e));
            } else if (Build.VERSION.SDK_INT >= 21) {
                return c.a(Float.valueOf(this.f1713b.getTextSize()), Float.valueOf(this.f1713b.getTextScaleX()), Float.valueOf(this.f1713b.getTextSkewX()), Float.valueOf(this.f1713b.getLetterSpacing()), Integer.valueOf(this.f1713b.getFlags()), this.f1713b.getTextLocale(), this.f1713b.getTypeface(), Boolean.valueOf(this.f1713b.isElegantTextHeight()), this.f1714c, Integer.valueOf(this.f1715d), Integer.valueOf(this.f1716e));
            } else if (Build.VERSION.SDK_INT >= 18) {
                return c.a(Float.valueOf(this.f1713b.getTextSize()), Float.valueOf(this.f1713b.getTextScaleX()), Float.valueOf(this.f1713b.getTextSkewX()), Integer.valueOf(this.f1713b.getFlags()), this.f1713b.getTextLocale(), this.f1713b.getTypeface(), this.f1714c, Integer.valueOf(this.f1715d), Integer.valueOf(this.f1716e));
            } else if (Build.VERSION.SDK_INT >= 17) {
                return c.a(Float.valueOf(this.f1713b.getTextSize()), Float.valueOf(this.f1713b.getTextScaleX()), Float.valueOf(this.f1713b.getTextSkewX()), Integer.valueOf(this.f1713b.getFlags()), this.f1713b.getTextLocale(), this.f1713b.getTypeface(), this.f1714c, Integer.valueOf(this.f1715d), Integer.valueOf(this.f1716e));
            } else {
                return c.a(Float.valueOf(this.f1713b.getTextSize()), Float.valueOf(this.f1713b.getTextScaleX()), Float.valueOf(this.f1713b.getTextSkewX()), Integer.valueOf(this.f1713b.getFlags()), this.f1713b.getTypeface(), this.f1714c, Integer.valueOf(this.f1715d), Integer.valueOf(this.f1716e));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f1713b.getTextSize());
            sb.append(", textScaleX=" + this.f1713b.getTextScaleX());
            sb.append(", textSkewX=" + this.f1713b.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f1713b.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f1713b.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.f1713b.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.f1713b.getTextLocale());
            }
            sb.append(", typeface=" + this.f1713b.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f1713b.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f1714c);
            sb.append(", breakStrategy=" + this.f1715d);
            sb.append(", hyphenationFrequency=" + this.f1716e);
            sb.append("}");
            return sb.toString();
        }
    }

    public a a() {
        return this.f1711d;
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.f1710c.setSpan(obj, i, i2, i3);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.f1710c.removeSpan(obj);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return this.f1710c.getSpans(i, i2, cls);
    }

    public int getSpanStart(Object obj) {
        return this.f1710c.getSpanStart(obj);
    }

    public int getSpanEnd(Object obj) {
        return this.f1710c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f1710c.getSpanFlags(obj);
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f1710c.nextSpanTransition(i, i2, cls);
    }

    public int length() {
        return this.f1710c.length();
    }

    public char charAt(int i) {
        return this.f1710c.charAt(i);
    }

    public CharSequence subSequence(int i, int i2) {
        return this.f1710c.subSequence(i, i2);
    }

    public String toString() {
        return this.f1710c.toString();
    }
}
