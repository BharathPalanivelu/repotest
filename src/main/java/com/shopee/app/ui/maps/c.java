package com.shopee.app.ui.maps;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.facebook.places.model.PlaceFields;
import com.garena.android.appkit.f.f;
import com.garena.c.a.d;
import com.garena.c.a.h;
import com.garena.c.a.i;
import com.garena.c.a.j;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.shopee.app.h.r;
import com.shopee.id.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class c extends a {

    /* renamed from: f  reason: collision with root package name */
    j f23203f = new j() {
        public void a(Location location) {
            if (c.this.m != null) {
                c.this.m.onLocationChanged(location);
                if (!c.this.f23189e) {
                    c.this.b((float) location.getLongitude(), (float) location.getLatitude());
                }
            }
        }

        public void a(int i) {
            com.garena.android.appkit.d.a.a("error code %d", Integer.valueOf(i));
            if (i != 4102) {
                switch (i) {
                }
            }
            r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_location_internal_error));
            c.this.q.setVisibility(8);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ListView f23204g;
    /* access modifiers changed from: private */
    public a h;
    /* access modifiers changed from: private */
    public List<String> i = new ArrayList();
    /* access modifiers changed from: private */
    public MarkerOptions j;
    /* access modifiers changed from: private */
    public GoogleMap k;
    /* access modifiers changed from: private */
    public C0362c l = new C0362c();
    /* access modifiers changed from: private */
    public LocationSource.OnLocationChangedListener m;
    /* access modifiers changed from: private */
    public TextView n;
    private SupportMapFragment o;
    /* access modifiers changed from: private */
    public com.garena.c.a.a p;
    /* access modifiers changed from: private */
    public ProgressBar q;
    private int r;

    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.location_selection_view;
    }

    public void c() {
    }

    private class a extends BaseAdapter {
        public long getItemId(int i) {
            return 0;
        }

        public int getItemViewType(int i) {
            return (i == 0 || i == 2) ? 0 : 1;
        }

        public int getViewTypeCount() {
            return 2;
        }

        private a() {
        }

        public int getCount() {
            if (c.this.i == null) {
                return 0;
            }
            return c.this.i.size();
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView;
            if (view == null) {
                checkedTextView = new CheckedTextView(c.this.getContext());
                checkedTextView.setGravity(16);
                checkedTextView.setCheckMarkDrawable((Drawable) null);
                checkedTextView.setPadding(20, 0, 10, 0);
                if (i == 0 || i == 2) {
                    checkedTextView.setMinHeight(com.garena.android.appkit.tools.c.a().a(40));
                    checkedTextView.setTextAppearance(c.this.getContext(), R.style.location_special_text);
                    checkedTextView.setBackgroundResource(R.drawable.popmenu_item_bg_default);
                } else {
                    checkedTextView.setMinHeight(com.garena.android.appkit.tools.c.a().a(50));
                    checkedTextView.setTextAppearance(c.this.getContext(), R.style.whisper_text_light);
                    checkedTextView.setBackgroundResource(R.drawable.address_item_bg_style);
                }
            } else {
                checkedTextView = (CheckedTextView) view;
            }
            checkedTextView.setText((CharSequence) c.this.i.get(i));
            return checkedTextView;
        }
    }

    /* renamed from: com.shopee.app.ui.maps.c$c  reason: collision with other inner class name */
    private class C0362c implements LocationSource {
        private C0362c() {
        }

        public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
            LocationSource.OnLocationChangedListener unused = c.this.m = onLocationChangedListener;
        }

        public void deactivate() {
            LocationSource.OnLocationChangedListener unused = c.this.m = null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3) {
        super.a(f2, f3);
        b(f3, f2);
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3, String str, String str2) {
        this.j = new MarkerOptions();
        this.j.position(new LatLng((double) f2, (double) f3));
        if (TextUtils.isEmpty(str2)) {
            this.j.title(com.garena.android.appkit.tools.b.e(R.string.sp_shop_location));
        } else {
            this.j.title(str2);
        }
        this.j.snippet(str);
        this.j.icon(BitmapDescriptorFactory.fromResource(R.drawable.com_garena_shopee_ic_map_location));
        GoogleMap googleMap = this.k;
        if (googleMap != null) {
            googleMap.addMarker(this.j).showInfoWindow();
            this.k.getUiSettings().setMapToolbarEnabled(true);
            findViewById(R.id.center_panel).setVisibility(8);
        }
    }

    public c(Context context, int i2) {
        super(context);
        this.r = i2;
        f();
    }

    private void f() {
        this.q = (ProgressBar) findViewById(R.id.progress);
        findViewById(R.id.location_close_window).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.e();
            }
        });
        findViewById(R.id.send_location).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.h();
            }
        });
        this.n = (TextView) findViewById(R.id.address_label);
        this.f23204g = (ListView) findViewById(R.id.list_address_result);
        this.o = (SupportMapFragment) getActivity().getSupportFragmentManager().a((int) R.id.mapView);
        this.q.setVisibility(0);
        this.f23204g.setChoiceMode(1);
        this.h = new a();
        this.f23204g.setAdapter(this.h);
        this.f23204g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i != 0 && i != 2) {
                    ((CheckedTextView) view).setChecked(true);
                    if (c.this.p != null) {
                        c.this.p.f7802d = (String) c.this.i.get(i);
                        c.this.n.setText((CharSequence) c.this.i.get(i));
                    }
                }
            }
        });
        this.o.getMapAsync(new OnMapReadyCallback() {
            public void onMapReady(GoogleMap googleMap) {
                GoogleMap unused = c.this.k = googleMap;
                if (c.this.k != null) {
                    c.this.k.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
                        public void onCameraChange(CameraPosition cameraPosition) {
                            if (c.this.p != null) {
                                c.this.p.f7799a = (float) cameraPosition.target.latitude;
                                c.this.p.f7800b = (float) cameraPosition.target.longitude;
                                if (c.this.n != null) {
                                    c.this.n.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_loading));
                                    com.garena.android.appkit.f.b.a().a(new b(c.this.p));
                                }
                            }
                        }
                    });
                    c.this.k.setMyLocationEnabled(true);
                    c.this.k.setLocationSource(c.this.l);
                    if (c.this.p != null) {
                        c.this.k.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng((double) c.this.p.f7799a, (double) c.this.p.f7800b), 16.0f));
                    }
                    f.a().a(new Runnable() {
                        public void run() {
                            c.this.g();
                            if (c.this.j != null && c.this.k != null) {
                                c.this.k.addMarker(c.this.j).showInfoWindow();
                                c.this.k.getUiSettings().setMapToolbarEnabled(true);
                                c.this.findViewById(R.id.center_panel).setVisibility(8);
                            }
                        }
                    });
                    return;
                }
                com.garena.android.appkit.d.a.a("Google Map is null.", new Object[0]);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final List<d.a> list) {
        if (this.i != null) {
            f.a().a(new Runnable() {
                public void run() {
                    if (list != null && c.this.f23204g != null) {
                        c.this.i.clear();
                        int i = 0;
                        for (d.a aVar : list) {
                            if (i == 0) {
                                c.this.i.add(com.garena.android.appkit.tools.b.e(R.string.sp_label_current_location));
                            }
                            if (i == 1) {
                                c.this.i.add(com.garena.android.appkit.tools.b.e(R.string.sp_label_nearby_places));
                            }
                            i++;
                            c.this.i.add(aVar.f7813a);
                        }
                        c.this.h.notifyDataSetChanged();
                        c.this.f23204g.setSelection(0);
                    }
                }
            });
        }
    }

    private void b(final List<Address> list) {
        if (this.i != null) {
            f.a().a(new Runnable() {
                public void run() {
                    if (list != null && c.this.f23204g != null) {
                        c.this.i.clear();
                        int i = 0;
                        for (Address address : list) {
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i2 = 0; address.getAddressLine(i2) != null; i2++) {
                                stringBuffer.append(address.getAddressLine(i2));
                                stringBuffer.append(com.garena.android.appkit.tools.b.e(R.string.location_separator));
                            }
                            String stringBuffer2 = stringBuffer.toString();
                            if (i == 0) {
                                c.this.i.add(com.garena.android.appkit.tools.b.e(R.string.sp_label_current_location));
                            }
                            if (i == 1) {
                                c.this.i.add(com.garena.android.appkit.tools.b.e(R.string.sp_label_nearby_places));
                            }
                            i++;
                            c.this.i.add(stringBuffer2.substring(0, stringBuffer2.length() - 1));
                        }
                        c.this.h.notifyDataSetChanged();
                        c.this.f23204g.setSelection(0);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public String getLocationFromGeoCoder() {
        if (Geocoder.isPresent()) {
            try {
                List<Address> fromLocation = new Geocoder(getContext(), Locale.getDefault()).getFromLocation((double) this.p.f7799a, (double) this.p.f7800b, 10);
                StringBuffer stringBuffer = new StringBuffer();
                if (fromLocation != null && fromLocation.size() > 0) {
                    b(fromLocation);
                    Address address = fromLocation.get(0);
                    for (int i2 = 0; address.getAddressLine(i2) != null; i2++) {
                        stringBuffer.append(address.getAddressLine(i2));
                        stringBuffer.append(com.garena.android.appkit.tools.b.e(R.string.location_separator));
                    }
                }
                return stringBuffer.toString();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public void d() {
        super.d();
        i.a().b(this.f23203f);
        this.k = null;
        this.l = null;
        this.o = null;
        this.m = null;
        this.n = null;
        this.p = null;
    }

    /* access modifiers changed from: private */
    public void g() {
        i.a().a(false);
        i.a().b(false);
        i.a().a(this.f23203f);
    }

    /* access modifiers changed from: private */
    public void b(float f2, float f3) {
        this.p = new com.garena.c.a.a();
        com.garena.c.a.a aVar = this.p;
        aVar.f7800b = f2;
        aVar.f7799a = f3;
        this.q.setVisibility(0);
        com.garena.android.appkit.d.a.e("location %f %f", Float.valueOf(this.p.f7799a), Float.valueOf(this.p.f7800b));
        com.garena.android.appkit.f.b.a().a(new b(this.p));
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private com.garena.c.a.a f23218b;

        b(com.garena.c.a.a aVar) {
            this.f23218b = aVar;
        }

        public void run() {
            if (c.this.p != null) {
                c.this.p.f7802d = c.this.getLocationFromGeoCoder();
                if (TextUtils.isEmpty(c.this.p.f7802d)) {
                    List<d.a> a2 = h.a(this.f23218b);
                    c.this.a(a2.size() > 10 ? a2.subList(0, 9) : a2);
                    String str = a2 != null ? a2.get(0).f7813a : "";
                    if (!TextUtils.isEmpty(str)) {
                        c.this.p.f7802d = str;
                    }
                }
                f.a().a(new Runnable() {
                    public void run() {
                        c.this.q.setVisibility(8);
                        if (c.this.p != null) {
                            c.this.a(c.this.p);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(com.garena.c.a.a aVar) {
        this.n.setText(aVar.f7802d);
    }

    /* access modifiers changed from: private */
    public void h() {
        com.garena.c.a.a aVar = this.p;
        if (aVar != null && !TextUtils.isEmpty(aVar.f7802d)) {
            Intent intent = new Intent();
            intent.putExtra(PlaceFields.LOCATION, this.p.b());
            getActivity().setResult(-1, intent);
            androidx.fragment.app.h supportFragmentManager = getActivity().getSupportFragmentManager();
            if (supportFragmentManager.a((int) R.id.mapView) != null) {
                supportFragmentManager.a().a((Fragment) this.o).b();
            }
            e();
        }
    }

    public void b() {
        if (!com.shopee.app.network.a.a()) {
            r.a().a("Please check the network connection.");
        }
    }
}
