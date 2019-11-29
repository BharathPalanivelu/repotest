package androidx.c.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.c.a.b;
import com.j256.ormlite.field.FieldType;

public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f1327a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f1328b;

    /* renamed from: c  reason: collision with root package name */
    protected Cursor f1329c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f1330d;

    /* renamed from: e  reason: collision with root package name */
    protected int f1331e;

    /* renamed from: f  reason: collision with root package name */
    protected C0024a f1332f;

    /* renamed from: g  reason: collision with root package name */
    protected DataSetObserver f1333g;
    protected b h;
    protected FilterQueryProvider i;

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void a(View view, Context context, Cursor cursor);

    public boolean hasStableIds() {
        return true;
    }

    public a(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, Cursor cursor, int i2) {
        boolean z = false;
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f1328b = true;
        } else {
            this.f1328b = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.f1329c = cursor;
        this.f1327a = z;
        this.f1330d = context;
        this.f1331e = z ? cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX) : -1;
        if ((i2 & 2) == 2) {
            this.f1332f = new C0024a();
            this.f1333g = new b();
        } else {
            this.f1332f = null;
            this.f1333g = null;
        }
        if (z) {
            C0024a aVar = this.f1332f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1333g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public Cursor a() {
        return this.f1329c;
    }

    public int getCount() {
        if (!this.f1327a) {
            return 0;
        }
        Cursor cursor = this.f1329c;
        if (cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    public Object getItem(int i2) {
        if (!this.f1327a) {
            return null;
        }
        Cursor cursor = this.f1329c;
        if (cursor == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f1329c;
    }

    public long getItemId(int i2) {
        if (this.f1327a) {
            Cursor cursor = this.f1329c;
            if (cursor != null && cursor.moveToPosition(i2)) {
                return this.f1329c.getLong(this.f1331e);
            }
        }
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f1327a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1329c.moveToPosition(i2)) {
            if (view == null) {
                view = a(this.f1330d, this.f1329c, viewGroup);
            }
            a(view, this.f1330d, this.f1329c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i2);
        }
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f1327a) {
            return null;
        }
        this.f1329c.moveToPosition(i2);
        if (view == null) {
            view = b(this.f1330d, this.f1329c, viewGroup);
        }
        a(view, this.f1330d, this.f1329c);
        return view;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public void a(Cursor cursor) {
        Cursor c2 = c(cursor);
        if (c2 != null) {
            c2.close();
        }
    }

    public Cursor c(Cursor cursor) {
        Cursor cursor2 = this.f1329c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0024a aVar = this.f1332f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1333g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1329c = cursor;
        if (cursor != null) {
            C0024a aVar2 = this.f1332f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f1333g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f1331e = cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX);
            this.f1327a = true;
            notifyDataSetChanged();
        } else {
            this.f1331e = -1;
            this.f1327a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CharSequence b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor a(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.i;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.f1329c;
    }

    public Filter getFilter() {
        if (this.h == null) {
            this.h = new b(this);
        }
        return this.h;
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (this.f1328b) {
            Cursor cursor = this.f1329c;
            if (cursor != null && !cursor.isClosed()) {
                this.f1327a = this.f1329c.requery();
            }
        }
    }

    /* renamed from: androidx.c.a.a$a  reason: collision with other inner class name */
    private class C0024a extends ContentObserver {
        public boolean deliverSelfNotifications() {
            return true;
        }

        C0024a() {
            super(new Handler());
        }

        public void onChange(boolean z) {
            a.this.b();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f1327a = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f1327a = false;
            aVar.notifyDataSetInvalidated();
        }
    }
}
