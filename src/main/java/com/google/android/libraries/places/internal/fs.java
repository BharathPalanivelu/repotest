package com.google.android.libraries.places.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.eu;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.salesforce.android.service.common.liveagentlogging.event.ErrorEvent;

public class fs implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final d f12575a;

    /* renamed from: b  reason: collision with root package name */
    public final Intent f12576b;

    /* renamed from: c  reason: collision with root package name */
    public final ge f12577c;

    /* renamed from: d  reason: collision with root package name */
    public final fj f12578d;

    /* renamed from: e  reason: collision with root package name */
    public final gc f12579e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f12580f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f12581g;
    public RecyclerView h;
    public View i;
    public View j;
    public TextView k;
    public ImageButton l;
    public Button m;
    public final boolean n;
    public final eu o;
    public boolean p;
    public boolean q;
    public TextWatcher r = new er(this);

    public final /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public void c() {
    }

    public void g() {
    }

    public void a() {
        ComponentName callingActivity = this.f12575a.getCallingActivity();
        if (!((callingActivity == null || callingActivity.getPackageName() == null) ? false : true)) {
            if (Log.isLoggable("Places", 6)) {
                Log.e("Places", "Cannot find caller. Did you forget to use startActivityForResult?");
            }
            this.f12575a.finish();
        } else if (this.f12578d.b() == fe.f12545f) {
            a(2, fe.f12545f.f12551e, fe.f12545f.f12548b);
        } else {
            AutocompleteActivityMode autocompleteActivityMode = this.f12579e.f12610b;
            int ordinal = autocompleteActivityMode.ordinal();
            if (ordinal == 0) {
                this.f12575a.setContentView(R.layout.places_autocomplete_main_fullscreen);
                Toolbar toolbar = (Toolbar) this.f12575a.findViewById(R.id.places_autocomplete_action_bar);
                this.f12575a.findViewById(R.id.places_autocomplete_back_button).setVisibility(8);
                toolbar.setNavigationIcon(R.drawable.quantum_ic_arrow_back_grey600_24);
                this.f12575a.setSupportActionBar(toolbar);
                toolbar.setNavigationOnClickListener(new el(this));
                this.f12575a.getWindow().setSoftInputMode(16);
            } else if (ordinal == 1) {
                this.f12575a.setContentView(R.layout.places_autocomplete_main_overlay);
                this.f12575a.findViewById(R.id.places_autocomplete_back_button).setOnClickListener(new ei(this));
                View findViewById = this.f12575a.findViewById(R.id.places_autocomplete_overlay_root);
                this.f12575a.findViewById(R.id.places_autocomplete_overlay_content).setOnTouchListener(ej.f12507a);
                findViewById.setOnTouchListener(new ek(this));
            }
            this.f12581g = (EditText) this.f12575a.findViewById(R.id.places_autocomplete_edit_text);
            this.h = (RecyclerView) this.f12575a.findViewById(R.id.places_autocomplete_list);
            this.i = this.f12575a.findViewById(R.id.places_autocomplete_error);
            this.j = this.f12575a.findViewById(R.id.places_autocomplete_error_progress);
            this.k = (TextView) this.f12575a.findViewById(R.id.places_autocomplete_error_message);
            this.l = (ImageButton) this.f12575a.findViewById(R.id.places_autocomplete_clear_button);
            this.m = (Button) this.f12575a.findViewById(R.id.places_autocomplete_try_again);
            this.f12578d.f12555a.h = this.f12579e.f12611c;
            this.f12578d.f12555a.f12534g = new fy(this);
            this.f12578d.f12555a.f12533f = new es(this);
            this.h.setLayoutManager(new LinearLayoutManager(this.f12575a, 1, false));
            if (Build.VERSION.SDK_INT >= 16) {
                this.h.setItemAnimator(new fn(this.f12575a.getResources()));
            }
            this.h.a((RecyclerView.n) new et(this));
            if (!this.n) {
                this.o.a(this.f12579e.k);
            }
            this.f12581g.setSaveEnabled(false);
            this.f12581g.requestFocus();
            this.f12581g.addTextChangedListener(this.r);
            this.f12581g.setOnEditorActionListener(new em(this));
            this.l.setOnClickListener(new en(this));
            this.i.setOnClickListener(new eo(this));
            this.m.setOnClickListener(new ep(this));
            this.h.setAdapter(this.f12578d);
            int ordinal2 = autocompleteActivityMode.ordinal();
            if (ordinal2 == 0) {
                int intExtra = this.f12576b.getIntExtra("primary_color", 0);
                int intExtra2 = this.f12576b.getIntExtra("primary_color_dark", 0);
                if (Color.alpha(intExtra) < 255) {
                    intExtra = 0;
                }
                if (!(intExtra == 0 || intExtra2 == 0)) {
                    int a2 = fv.a(intExtra, this.f12575a.getResources().getColor(R.color.places_text_white_alpha_87), this.f12575a.getResources().getColor(R.color.places_text_black_alpha_87));
                    int a3 = fv.a(intExtra, this.f12575a.getResources().getColor(R.color.places_text_white_alpha_26), this.f12575a.getResources().getColor(R.color.places_text_black_alpha_26));
                    d dVar = this.f12575a;
                    Toolbar a4 = fu.a((Activity) dVar);
                    if (a4 != null) {
                        if (Build.VERSION.SDK_INT >= 11) {
                            a4.setBackgroundColor(intExtra);
                            a4.setTitleTextColor(a2);
                            Drawable navigationIcon = a4.getNavigationIcon();
                            if (navigationIcon != null) {
                                fu.a(navigationIcon, a2);
                                a4.setNavigationIcon(navigationIcon);
                            }
                        }
                        if (Build.VERSION.SDK_INT >= 21) {
                            dVar.getWindow().setStatusBarColor(intExtra2);
                        }
                    }
                    this.f12581g.setTextColor(a2);
                    this.f12581g.setHintTextColor(a3);
                    Drawable drawable = this.l.getDrawable();
                    fu.a(drawable, a2);
                    this.l.setImageDrawable(drawable);
                }
            } else if (ordinal2 == 1) {
                j();
            }
            if (this.n) {
                a(this.f12578d.b(), this.o);
                return;
            }
            c(this.f12578d.b(), this.o);
            k();
        }
    }

    public void d() {
        gc gcVar = this.f12579e;
        if (gcVar.a()) {
            Log.e("Places", "Already active!");
        } else {
            gcVar.p = gcVar.q.a();
        }
    }

    public void e() {
        m();
    }

    public void f() {
        gc gcVar = this.f12579e;
        if (!gcVar.a()) {
            Log.e("Places", "Already inactive!");
            return;
        }
        gcVar.o += (int) (gcVar.q.a() - gcVar.p);
        gcVar.p = -1;
    }

    public void a(Bundle bundle) {
        bundle.putParcelable(ErrorEvent.OPENTOK_DOMAIN_SESSION, this.f12579e);
        bundle.putParcelable("adapterState", this.f12578d.b());
        bundle.putParcelable("activityState", this.o);
        Parcel obtain = Parcel.obtain();
        obtain.writeValue(bundle);
        int length = obtain.marshall().length;
        if (length > 409600) {
            Log.e("Places", String.format("onSaveInstanceState: skipping saving state, it's too large (%d bytes, max is %dKB).", new Object[]{Integer.valueOf(length), 400}));
            bundle.clear();
        }
    }

    public void h() {
        if (this.f12575a.isFinishing()) {
            if (!this.p && !this.q) {
                this.f12579e.f12614f = true;
            }
            this.f12577c.a(this.f12579e);
        }
        ex exVar = this.f12578d.f12555a;
        exVar.f12531d = true;
        exVar.a();
    }

    public fs(d dVar, Bundle bundle, fj fjVar, ge geVar, a aVar) {
        try {
            this.f12575a = dVar;
            this.f12576b = dVar.getIntent();
            this.f12578d = fjVar;
            this.f12577c = geVar;
            if (bundle == null || !bundle.containsKey("activityState") || !bundle.containsKey("adapterState") || !bundle.containsKey(ErrorEvent.OPENTOK_DOMAIN_SESSION)) {
                this.n = false;
                this.o = new eu(eu.a.NO_ERROR, (String) null, (String) null, false);
                AutocompleteActivityMode autocompleteActivityMode = (AutocompleteActivityMode) this.f12576b.getSerializableExtra("mode");
                ee eeVar = (ee) this.f12576b.getSerializableExtra(AppMeasurementSdk.ConditionalUserProperty.ORIGIN);
                String stringExtra = this.f12576b.getStringExtra("initial_query");
                go.a(autocompleteActivityMode, (Object) "Activity Mode must be present in the launch intent.");
                go.a(eeVar, (Object) "Origin must be present in the launch intent.");
                this.f12579e = new gc(eeVar, autocompleteActivityMode, stringExtra, aVar);
            } else {
                this.n = true;
                this.o = (eu) bundle.getParcelable("activityState");
                fjVar.f12555a.a((fe) bundle.getParcelable("adapterState"));
                this.f12579e = (gc) bundle.getParcelable(ErrorEvent.OPENTOK_DOMAIN_SESSION);
            }
            this.f12580f = new Handler(Looper.getMainLooper());
            int ordinal = this.f12579e.f12610b.ordinal();
            if (ordinal == 0) {
                dVar.setTheme(R.style.PlacesAutocompleteThemeFullscreen);
            } else if (ordinal == 1) {
            }
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public void a(fe feVar, eu euVar) {
        euVar.f12522d = true;
        c(feVar, euVar);
        int i2 = feVar.f12547a;
        if (i2 == 2) {
            k();
        } else if (i2 == 5) {
            ex exVar = this.f12578d.f12555a;
            if (exVar.f12532e.a() && exVar.f12532e.f12550d >= 0 && exVar.f12532e.f12550d < exVar.f12532e.f12549c.size()) {
                exVar.a(exVar.f12532e.f12550d, exVar.f12532e.f12549c.get(exVar.f12532e.f12550d));
            }
        } else if (Log.isLoggable("Places", 6)) {
            Log.e("Places", "Unknown AutocompleteAdapter state change.");
        }
    }

    public void b(fe feVar, eu euVar) {
        AutocompletePrediction autocompletePrediction;
        switch (feVar.f12547a) {
            case 1:
            case 7:
                euVar.f12521c = null;
                euVar.f12519a = eu.a.NO_ERROR;
                break;
            case 2:
                if (euVar.f12519a != eu.a.SHOW_ERROR_CAN_RETRY_NOT_LOADING) {
                    euVar.f12519a = eu.a.NO_ERROR;
                    break;
                } else {
                    euVar.f12519a = eu.a.SHOW_ERROR_WHILE_LOADING;
                    break;
                }
            case 3:
                this.f12579e.i++;
                euVar.f12521c = this.f12575a.getString(R.string.places_search_error);
                euVar.f12519a = eu.a.SHOW_ERROR_CAN_RETRY_NOT_LOADING;
                break;
            case 4:
                this.f12579e.h++;
                if (!feVar.f12549c.isEmpty()) {
                    euVar.f12521c = null;
                    euVar.f12519a = eu.a.NO_ERROR;
                    break;
                } else {
                    euVar.f12521c = this.f12575a.getString(R.string.places_autocomplete_no_results_for_query, new Object[]{euVar.f12520b});
                    euVar.f12519a = eu.a.SHOW_ERROR_CANNOT_RETRY_NOT_LOADING;
                    break;
                }
            case 5:
                fe b2 = this.f12578d.b();
                if (!b2.a()) {
                    autocompletePrediction = null;
                } else {
                    autocompletePrediction = b2.f12549c.get(b2.f12550d);
                }
                if (autocompletePrediction != null) {
                    if (euVar.a()) {
                        euVar.f12519a = eu.a.SHOW_ERROR_WHILE_LOADING;
                    }
                    euVar.a(autocompletePrediction.getPrimaryText((CharacterStyle) null));
                    gc gcVar = this.f12579e;
                    int i2 = feVar.f12550d;
                    gcVar.f12612d = true;
                    gcVar.f12615g = i2;
                    break;
                }
                break;
            case 6:
                this.f12579e.j++;
                euVar.f12521c = this.f12575a.getString(R.string.places_search_error);
                euVar.f12519a = eu.a.SHOW_ERROR_CAN_RETRY_NOT_LOADING;
                break;
            default:
                if (Log.isLoggable("Places", 6)) {
                    Log.e("Places", "Unknown AutocompleteAdapter state change.");
                    break;
                }
                break;
        }
        c(feVar, euVar);
    }

    public void c(fe feVar, eu euVar) {
        String obj = this.f12581g.getText().toString();
        String str = euVar.f12520b;
        if (!obj.equals(str)) {
            this.f12581g.removeTextChangedListener(this.r);
            this.f12581g.setText(str);
            EditText editText = this.f12581g;
            editText.setSelection(editText.getText().length());
            this.f12581g.addTextChangedListener(this.r);
            l();
        }
        a(euVar);
        if (feVar.f12547a == 5) {
            fw.a((Context) this.f12575a, (View) this.f12581g);
        }
    }

    public void i() {
        this.f12579e.n = true;
        fw.a((Context) this.f12575a, (View) this.f12581g);
    }

    @TargetApi(19)
    public void j() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f12575a.getWindow().addFlags(67108864);
            View findViewById = this.f12575a.findViewById(R.id.places_autocomplete_overlay_root);
            int paddingLeft = findViewById.getPaddingLeft();
            int paddingTop = findViewById.getPaddingTop();
            Resources resources = this.f12575a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            findViewById.setPadding(paddingLeft, paddingTop + (identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        }
    }

    public void k() {
        fa faVar = (fa) this.f12578d.getFilter();
        String obj = this.f12581g.getText().toString();
        faVar.publishResults(obj, faVar.performFiltering(obj));
    }

    public void l() {
        if (this.f12581g.getText().toString().isEmpty()) {
            this.l.setVisibility(4);
        } else {
            this.l.setVisibility(0);
        }
    }

    public void a(eu euVar) {
        this.f12580f.removeCallbacksAndMessages((Object) null);
        if (euVar.a()) {
            if (euVar.f12519a == eu.a.SHOW_ERROR_WHILE_LOADING) {
                c(euVar);
            }
            if (euVar.f12522d) {
                d(euVar);
            } else {
                this.f12580f.postDelayed(new eq(this, euVar), 2000);
            }
        } else {
            this.j.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
            this.k.setText((CharSequence) null);
            this.h.setVisibility(0);
        }
        euVar.f12522d = false;
    }

    /* renamed from: b */
    public void d(eu euVar) {
        c(euVar);
        this.i.setVisibility(0);
        this.k.setText(euVar.f12521c);
        this.h.setVisibility(8);
    }

    public void c(eu euVar) {
        eu.a aVar = euVar.f12519a;
        int i2 = 0;
        this.j.setVisibility(aVar == eu.a.SHOW_ERROR_WHILE_LOADING ? 0 : 8);
        Button button = this.m;
        if (aVar != eu.a.SHOW_ERROR_CAN_RETRY_NOT_LOADING) {
            i2 = 8;
        }
        button.setVisibility(i2);
    }

    public void a(Place place) {
        a(-1, place, new Status(0));
        this.q = true;
    }

    public void m() {
        this.p = true;
        this.f12579e.f12613e = true;
        a(0, (Place) null, new Status(16));
    }

    public void a(int i2, Place place, Status status) {
        Intent intent = new Intent();
        if (place != null) {
            intent.putExtra("selected_place", place);
        }
        intent.putExtra("status", status);
        this.f12575a.setResult(i2, intent);
        this.f12575a.supportFinishAfterTransition();
    }

    public /* synthetic */ void n() {
        try {
            k();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public /* synthetic */ void o() {
        try {
            fw.a((Context) this.f12575a, (View) this.f12581g);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public /* synthetic */ void p() {
        try {
            this.f12579e.m++;
            this.f12581g.setText("");
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public /* synthetic */ boolean a(int i2) {
        if (i2 != 3) {
            return false;
        }
        try {
            fw.a((Context) this.f12575a, (View) this.f12581g);
            return true;
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public /* synthetic */ void a(fe feVar) {
        try {
            b(feVar, this.o);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public /* synthetic */ void q() {
        try {
            m();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public /* synthetic */ boolean r() {
        try {
            m();
            return true;
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public /* synthetic */ void s() {
        try {
            m();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
