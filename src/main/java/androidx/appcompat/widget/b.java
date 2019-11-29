package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f1183a;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public b(ActionBarContainer actionBarContainer) {
        this.f1183a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f1183a.f905d) {
            if (this.f1183a.f902a != null) {
                this.f1183a.f902a.draw(canvas);
            }
            if (this.f1183a.f903b != null && this.f1183a.f906e) {
                this.f1183a.f903b.draw(canvas);
            }
        } else if (this.f1183a.f904c != null) {
            this.f1183a.f904c.draw(canvas);
        }
    }

    public void getOutline(Outline outline) {
        if (this.f1183a.f905d) {
            if (this.f1183a.f904c != null) {
                this.f1183a.f904c.getOutline(outline);
            }
        } else if (this.f1183a.f902a != null) {
            this.f1183a.f902a.getOutline(outline);
        }
    }
}
