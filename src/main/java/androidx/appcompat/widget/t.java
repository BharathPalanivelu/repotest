package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.e;

final class t {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1245a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f1246b;

    t(TextView textView) {
        this.f1245a = (TextView) e.a(textView);
    }

    public void a(TextClassifier textClassifier) {
        this.f1246b = textClassifier;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1246b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1245a.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }
}
