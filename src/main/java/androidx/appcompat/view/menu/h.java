package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.a;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.m;

class h implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, m.a {

    /* renamed from: a  reason: collision with root package name */
    e f857a;

    /* renamed from: b  reason: collision with root package name */
    private g f858b;

    /* renamed from: c  reason: collision with root package name */
    private c f859c;

    /* renamed from: d  reason: collision with root package name */
    private m.a f860d;

    public h(g gVar) {
        this.f858b = gVar;
    }

    public void a(IBinder iBinder) {
        g gVar = this.f858b;
        c.a aVar = new c.a(gVar.f());
        this.f857a = new e(aVar.a(), a.g.abc_list_menu_item_layout);
        this.f857a.a((m.a) this);
        this.f858b.a((m) this.f857a);
        aVar.a(this.f857a.a(), (DialogInterface.OnClickListener) this);
        View p = gVar.p();
        if (p != null) {
            aVar.a(p);
        } else {
            aVar.a(gVar.o()).a(gVar.n());
        }
        aVar.a((DialogInterface.OnKeyListener) this);
        this.f859c = aVar.b();
        this.f859c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f859c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f859c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window = this.f859c.getWindow();
                if (window != null) {
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        KeyEvent.DispatcherState keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                Window window2 = this.f859c.getWindow();
                if (window2 != null) {
                    View decorView2 = window2.getDecorView();
                    if (decorView2 != null) {
                        KeyEvent.DispatcherState keyDispatcherState2 = decorView2.getKeyDispatcherState();
                        if (keyDispatcherState2 != null && keyDispatcherState2.isTracking(keyEvent)) {
                            this.f858b.a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f858b.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        c cVar = this.f859c;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f857a.a(this.f858b, true);
    }

    public void a(g gVar, boolean z) {
        if (z || gVar == this.f858b) {
            a();
        }
        m.a aVar = this.f860d;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    public boolean a(g gVar) {
        m.a aVar = this.f860d;
        if (aVar != null) {
            return aVar.a(gVar);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f858b.a((MenuItem) (i) this.f857a.a().getItem(i), 0);
    }
}
