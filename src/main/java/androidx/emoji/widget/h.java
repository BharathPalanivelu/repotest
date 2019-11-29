package androidx.emoji.widget;

import android.os.Build;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.core.util.e;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final a f2101a;

    public h(TextView textView) {
        e.a(textView, (Object) "textView cannot be null");
        this.f2101a = Build.VERSION.SDK_INT >= 19 ? new b(textView) : new a();
    }

    public void a() {
        this.f2101a.a();
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f2101a.a(inputFilterArr);
    }

    public void a(boolean z) {
        this.f2101a.a(z);
    }

    static class a {
        /* access modifiers changed from: package-private */
        public TransformationMethod a(TransformationMethod transformationMethod) {
            return transformationMethod;
        }

        /* access modifiers changed from: package-private */
        public void a() {
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
        }

        /* access modifiers changed from: package-private */
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        a() {
        }
    }

    private static class b extends a {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f2102a;

        /* renamed from: b  reason: collision with root package name */
        private final e f2103b;

        b(TextView textView) {
            this.f2102a = textView;
            this.f2103b = new e(textView);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            TransformationMethod transformationMethod = this.f2102a.getTransformationMethod();
            if (transformationMethod != null && !(transformationMethod instanceof PasswordTransformationMethod)) {
                this.f2102a.setTransformationMethod(a(transformationMethod));
            }
        }

        /* access modifiers changed from: package-private */
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter instanceof e) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, r0);
            inputFilterArr2[r0] = this.f2103b;
            return inputFilterArr2;
        }

        /* access modifiers changed from: package-private */
        public TransformationMethod a(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof j) {
                return transformationMethod;
            }
            return new j(transformationMethod);
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            if (z) {
                a();
            }
        }
    }
}
