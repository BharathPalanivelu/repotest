package com.airbnb.android.react.maps;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.g.c;
import androidx.core.g.i;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.IndoorLevel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.a.b.b;
import com.google.maps.android.a.b.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.xmlpull.v1.XmlPullParserException;

public class j extends MapView implements GoogleMap.InfoWindowAdapter, GoogleMap.OnIndoorStateChangeListener, GoogleMap.OnMarkerDragListener, GoogleMap.OnPoiClickListener, OnMapReadyCallback {
    private static final String[] r = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    /* access modifiers changed from: private */
    public boolean A = false;
    /* access modifiers changed from: private */
    public final ThemedReactContext B;
    /* access modifiers changed from: private */
    public final EventDispatcher C;
    private r D;

    /* renamed from: a  reason: collision with root package name */
    public GoogleMap f3306a;

    /* renamed from: b  reason: collision with root package name */
    private f f3307b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f3308c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f3309d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f3310e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Boolean f3311f = false;

    /* renamed from: g  reason: collision with root package name */
    private Integer f3312g = null;
    private Integer h = null;
    private final int i = 50;
    private LatLngBounds j;
    /* access modifiers changed from: private */
    public boolean k = false;
    /* access modifiers changed from: private */
    public boolean l = false;
    /* access modifiers changed from: private */
    public boolean m = true;
    private boolean n = false;
    private boolean o = false;
    /* access modifiers changed from: private */
    public LatLngBounds p;
    /* access modifiers changed from: private */
    public int q = 0;
    private final List<c> s = new ArrayList();
    private final Map<Marker, e> t = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Polyline, h> u = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Polygon, g> v = new HashMap();
    private final c w;
    /* access modifiers changed from: private */
    public final AirMapManager x;
    private LifecycleEventListener y;
    /* access modifiers changed from: private */
    public boolean z = false;

    private static boolean a(Context context) {
        return context == null || context.getResources() == null || context.getResources().getConfiguration() == null;
    }

    private static Context a(ThemedReactContext themedReactContext, ReactApplicationContext reactApplicationContext) {
        if (!a((Context) reactApplicationContext.getCurrentActivity())) {
            return reactApplicationContext.getCurrentActivity();
        }
        if (!a((Context) themedReactContext)) {
            return themedReactContext;
        }
        if (!a((Context) themedReactContext.getCurrentActivity())) {
            return themedReactContext.getCurrentActivity();
        }
        return !a(themedReactContext.getApplicationContext()) ? themedReactContext.getApplicationContext() : themedReactContext;
    }

    public j(ThemedReactContext themedReactContext, ReactApplicationContext reactApplicationContext, AirMapManager airMapManager, GoogleMapOptions googleMapOptions) {
        super(a(themedReactContext, reactApplicationContext), googleMapOptions);
        this.x = airMapManager;
        this.B = themedReactContext;
        super.onCreate((Bundle) null);
        super.onResume();
        super.getMapAsync(this);
        this.w = new c(themedReactContext, new GestureDetector.SimpleOnGestureListener() {
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (!j.this.l) {
                    return false;
                }
                j.this.a(motionEvent2);
                return false;
            }
        });
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (!j.this.z) {
                    j.this.f();
                }
            }
        });
        this.C = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.D = new r(this.B);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        layoutParams.width = 0;
        layoutParams.height = 0;
        layoutParams.leftMargin = 99999999;
        layoutParams.topMargin = 99999999;
        this.D.setLayoutParams(layoutParams);
        addView(this.D);
    }

    public void onMapReady(final GoogleMap googleMap) {
        if (!this.A) {
            this.f3306a = googleMap;
            this.f3306a.setInfoWindowAdapter(this);
            this.f3306a.setOnMarkerDragListener(this);
            this.f3306a.setOnPoiClickListener(this);
            this.f3306a.setOnIndoorStateChangeListener(this);
            this.x.pushEvent(this.B, this, "onMapReady", new WritableNativeMap());
            googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                public void onMyLocationChange(Location location) {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    writableNativeMap2.putDouble("latitude", location.getLatitude());
                    writableNativeMap2.putDouble("longitude", location.getLongitude());
                    writableNativeMap2.putDouble("altitude", location.getAltitude());
                    writableNativeMap2.putDouble("timestamp", (double) location.getTime());
                    writableNativeMap2.putDouble("accuracy", (double) location.getAccuracy());
                    writableNativeMap2.putDouble("speed", (double) location.getSpeed());
                    if (Build.VERSION.SDK_INT >= 18) {
                        writableNativeMap2.putBoolean("isFromMockProvider", location.isFromMockProvider());
                    }
                    writableNativeMap.putMap("coordinate", writableNativeMap2);
                    j.this.x.pushEvent(j.this.B, this, "onUserLocationChange", writableNativeMap);
                }
            });
            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                public boolean onMarkerClick(Marker marker) {
                    e a2 = j.this.a(marker);
                    WritableMap a3 = j.this.a(marker.getPosition());
                    a3.putString("action", "marker-press");
                    a3.putString("id", a2.getIdentifier());
                    j.this.x.pushEvent(j.this.B, this, "onMarkerPress", a3);
                    WritableMap a4 = j.this.a(marker.getPosition());
                    a4.putString("action", "marker-press");
                    a4.putString("id", a2.getIdentifier());
                    j.this.x.pushEvent(j.this.B, a2, "onPress", a4);
                    if (this.m) {
                        return false;
                    }
                    marker.showInfoWindow();
                    return true;
                }
            });
            googleMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
                public void onPolygonClick(Polygon polygon) {
                    WritableMap a2 = j.this.a(polygon.getPoints().get(0));
                    a2.putString("action", "polygon-press");
                    j.this.x.pushEvent(j.this.B, (View) j.this.v.get(polygon), "onPress", a2);
                }
            });
            googleMap.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
                public void onPolylineClick(Polyline polyline) {
                    WritableMap a2 = j.this.a(polyline.getPoints().get(0));
                    a2.putString("action", "polyline-press");
                    j.this.x.pushEvent(j.this.B, (View) j.this.u.get(polyline), "onPress", a2);
                }
            });
            googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                public void onInfoWindowClick(Marker marker) {
                    WritableMap a2 = j.this.a(marker.getPosition());
                    a2.putString("action", "callout-press");
                    j.this.x.pushEvent(j.this.B, this, "onCalloutPress", a2);
                    WritableMap a3 = j.this.a(marker.getPosition());
                    a3.putString("action", "callout-press");
                    e a4 = j.this.a(marker);
                    j.this.x.pushEvent(j.this.B, a4, "onCalloutPress", a3);
                    WritableMap a5 = j.this.a(marker.getPosition());
                    a5.putString("action", "callout-press");
                    a calloutView = a4.getCalloutView();
                    if (calloutView != null) {
                        j.this.x.pushEvent(j.this.B, calloutView, "onPress", a5);
                    }
                }
            });
            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                public void onMapClick(LatLng latLng) {
                    WritableMap a2 = j.this.a(latLng);
                    a2.putString("action", "press");
                    j.this.x.pushEvent(j.this.B, this, "onPress", a2);
                }
            });
            googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                public void onMapLongClick(LatLng latLng) {
                    j.this.a(latLng).putString("action", "long-press");
                    j.this.x.pushEvent(j.this.B, this, "onLongPress", j.this.a(latLng));
                }
            });
            googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {
                public void onCameraMoveStarted(int i) {
                    int unused = j.this.q = i;
                }
            });
            googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
                public void onCameraMove() {
                    LatLngBounds latLngBounds = googleMap.getProjection().getVisibleRegion().latLngBounds;
                    LatLngBounds unused = j.this.p = null;
                    j.this.C.dispatchEvent(new p(j.this.getId(), latLngBounds, true));
                }
            });
            googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
                public void onCameraIdle() {
                    LatLngBounds latLngBounds = googleMap.getProjection().getVisibleRegion().latLngBounds;
                    if (j.this.q == 0) {
                        return;
                    }
                    if (j.this.p == null || n.a(latLngBounds, j.this.p)) {
                        LatLngBounds unused = j.this.p = latLngBounds;
                        j.this.C.dispatchEvent(new p(j.this.getId(), latLngBounds, false));
                    }
                }
            });
            googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                public void onMapLoaded() {
                    Boolean unused = j.this.f3311f = true;
                    j.this.f();
                }
            });
            this.y = new LifecycleEventListener() {
                public void onHostResume() {
                    if (j.this.b()) {
                        googleMap.setMyLocationEnabled(j.this.k);
                    }
                    synchronized (j.this) {
                        if (!j.this.A) {
                            j.this.onResume();
                        }
                        boolean unused = j.this.z = false;
                    }
                }

                public void onHostPause() {
                    if (j.this.b()) {
                        googleMap.setMyLocationEnabled(false);
                    }
                    synchronized (j.this) {
                        if (!j.this.A) {
                            j.this.onPause();
                        }
                        boolean unused = j.this.z = true;
                    }
                }

                public void onHostDestroy() {
                    j.this.a();
                }
            };
            this.B.addLifecycleEventListener(this.y);
        }
    }

    /* access modifiers changed from: private */
    public boolean b() {
        if (androidx.core.content.c.a(getContext(), r[0]) == 0 || androidx.core.content.c.a(getContext(), r[1]) == 0) {
            return true;
        }
        return false;
    }

    public synchronized void a() {
        if (!this.A) {
            this.A = true;
            if (!(this.y == null || this.B == null)) {
                this.B.removeLifecycleEventListener(this.y);
                this.y = null;
            }
            if (!this.z) {
                onPause();
                this.z = true;
            }
            onDestroy();
        }
    }

    public void setInitialRegion(ReadableMap readableMap) {
        if (!this.o && readableMap != null) {
            setRegion(readableMap);
            this.o = true;
        }
    }

    public void setRegion(ReadableMap readableMap) {
        ReadableMap readableMap2 = readableMap;
        if (readableMap2 != null) {
            Double valueOf = Double.valueOf(readableMap2.getDouble("longitude"));
            Double valueOf2 = Double.valueOf(readableMap2.getDouble("latitude"));
            Double valueOf3 = Double.valueOf(readableMap2.getDouble("longitudeDelta"));
            Double valueOf4 = Double.valueOf(readableMap2.getDouble("latitudeDelta"));
            LatLngBounds latLngBounds = new LatLngBounds(new LatLng(valueOf2.doubleValue() - (valueOf4.doubleValue() / 2.0d), valueOf.doubleValue() - (valueOf3.doubleValue() / 2.0d)), new LatLng(valueOf2.doubleValue() + (valueOf4.doubleValue() / 2.0d), valueOf.doubleValue() + (valueOf3.doubleValue() / 2.0d)));
            if (super.getHeight() <= 0 || super.getWidth() <= 0) {
                this.f3306a.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(valueOf2.doubleValue(), valueOf.doubleValue()), 10.0f));
                this.j = latLngBounds;
                return;
            }
            this.f3306a.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0));
            this.j = null;
        }
    }

    public void setShowsUserLocation(boolean z2) {
        this.k = z2;
        if (b()) {
            this.f3306a.setMyLocationEnabled(z2);
        }
    }

    public void setShowsMyLocationButton(boolean z2) {
        if (b() || !z2) {
            this.f3306a.getUiSettings().setMyLocationButtonEnabled(z2);
        }
    }

    public void setToolbarEnabled(boolean z2) {
        if (b() || !z2) {
            this.f3306a.getUiSettings().setMapToolbarEnabled(z2);
        }
    }

    public void setCacheEnabled(boolean z2) {
        this.n = z2;
        f();
    }

    public void a(boolean z2) {
        if (z2 && !this.f3311f.booleanValue()) {
            getMapLoadingLayoutView().setVisibility(0);
        }
    }

    public void setMoveOnMarkerPress(boolean z2) {
        this.m = z2;
    }

    public void setLoadingBackgroundColor(Integer num) {
        this.f3312g = num;
        RelativeLayout relativeLayout = this.f3309d;
        if (relativeLayout == null) {
            return;
        }
        if (num == null) {
            relativeLayout.setBackgroundColor(-1);
        } else {
            relativeLayout.setBackgroundColor(this.f3312g.intValue());
        }
    }

    public void setLoadingIndicatorColor(Integer num) {
        this.h = num;
        if (this.f3308c != null) {
            Integer valueOf = num == null ? Integer.valueOf(Color.parseColor("#606060")) : num;
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList valueOf2 = ColorStateList.valueOf(num.intValue());
                ColorStateList valueOf3 = ColorStateList.valueOf(num.intValue());
                ColorStateList valueOf4 = ColorStateList.valueOf(num.intValue());
                this.f3308c.setProgressTintList(valueOf2);
                this.f3308c.setSecondaryProgressTintList(valueOf3);
                this.f3308c.setIndeterminateTintList(valueOf4);
                return;
            }
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            if (Build.VERSION.SDK_INT <= 10) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (this.f3308c.getIndeterminateDrawable() != null) {
                this.f3308c.getIndeterminateDrawable().setColorFilter(valueOf.intValue(), mode);
            }
            if (this.f3308c.getProgressDrawable() != null) {
                this.f3308c.getProgressDrawable().setColorFilter(valueOf.intValue(), mode);
            }
        }
    }

    public void setHandlePanDrag(boolean z2) {
        this.l = z2;
    }

    public void a(View view, int i2) {
        if (view instanceof e) {
            e eVar = (e) view;
            eVar.a(this.f3306a);
            this.s.add(i2, eVar);
            int visibility = eVar.getVisibility();
            eVar.setVisibility(4);
            ViewGroup viewGroup = (ViewGroup) eVar.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(eVar);
            }
            this.D.addView(eVar);
            eVar.setVisibility(visibility);
            this.t.put((Marker) eVar.getFeature(), eVar);
        } else if (view instanceof h) {
            h hVar = (h) view;
            hVar.a(this.f3306a);
            this.s.add(i2, hVar);
            this.u.put((Polyline) hVar.getFeature(), hVar);
        } else if (view instanceof g) {
            g gVar = (g) view;
            gVar.a(this.f3306a);
            this.s.add(i2, gVar);
            this.v.put((Polygon) gVar.getFeature(), gVar);
        } else if (view instanceof b) {
            b bVar = (b) view;
            bVar.a(this.f3306a);
            this.s.add(i2, bVar);
        } else if (view instanceof i) {
            i iVar = (i) view;
            iVar.a(this.f3306a);
            this.s.add(i2, iVar);
        } else if (view instanceof d) {
            d dVar = (d) view;
            dVar.a(this.f3306a);
            this.s.add(i2, dVar);
        } else if (view instanceof f) {
            f fVar = (f) view;
            fVar.a(this.f3306a);
            this.s.add(i2, fVar);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup2.getChildCount(); i3++) {
                a(viewGroup2.getChildAt(i3), i2);
            }
        } else {
            addView(view, i2);
        }
    }

    public int getFeatureCount() {
        return this.s.size();
    }

    public View a(int i2) {
        return this.s.get(i2);
    }

    public void b(int i2) {
        c remove = this.s.remove(i2);
        if (remove instanceof e) {
            this.t.remove(remove.getFeature());
        }
        remove.b(this.f3306a);
    }

    public WritableMap a(LatLng latLng) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putDouble("latitude", latLng.latitude);
        writableNativeMap2.putDouble("longitude", latLng.longitude);
        writableNativeMap.putMap("coordinate", writableNativeMap2);
        Point screenLocation = this.f3306a.getProjection().toScreenLocation(latLng);
        WritableNativeMap writableNativeMap3 = new WritableNativeMap();
        writableNativeMap3.putDouble("x", (double) screenLocation.x);
        writableNativeMap3.putDouble("y", (double) screenLocation.y);
        writableNativeMap.putMap(ViewProps.POSITION, writableNativeMap3);
        return writableNativeMap;
    }

    public void a(Object obj) {
        if (this.j != null) {
            HashMap hashMap = (HashMap) obj;
            int intValue = hashMap.get("width") == null ? 0 : ((Float) hashMap.get("width")).intValue();
            int intValue2 = hashMap.get("height") == null ? 0 : ((Float) hashMap.get("height")).intValue();
            if (intValue <= 0 || intValue2 <= 0) {
                this.f3306a.moveCamera(CameraUpdateFactory.newLatLngBounds(this.j, 0));
            } else {
                this.f3306a.moveCamera(CameraUpdateFactory.newLatLngBounds(this.j, intValue, intValue2, 0));
            }
            this.j = null;
        }
    }

    public void a(LatLng latLng, float f2, float f3, int i2) {
        GoogleMap googleMap = this.f3306a;
        if (googleMap != null) {
            this.f3306a.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(googleMap.getCameraPosition()).bearing(f2).tilt(f3).target(latLng).build()), i2, (GoogleMap.CancelableCallback) null);
        }
    }

    public void a(LatLngBounds latLngBounds, int i2) {
        GoogleMap googleMap = this.f3306a;
        if (googleMap != null) {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0), i2, (GoogleMap.CancelableCallback) null);
        }
    }

    public void a(float f2, int i2) {
        GoogleMap googleMap = this.f3306a;
        if (googleMap != null) {
            this.f3306a.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(googleMap.getCameraPosition()).tilt(f2).build()), i2, (GoogleMap.CancelableCallback) null);
        }
    }

    public void b(float f2, int i2) {
        GoogleMap googleMap = this.f3306a;
        if (googleMap != null) {
            this.f3306a.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(googleMap.getCameraPosition()).bearing(f2).build()), i2, (GoogleMap.CancelableCallback) null);
        }
    }

    public void a(LatLng latLng, int i2) {
        GoogleMap googleMap = this.f3306a;
        if (googleMap != null) {
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng), i2, (GoogleMap.CancelableCallback) null);
        }
    }

    public void b(boolean z2) {
        if (this.f3306a != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            boolean z3 = false;
            for (c next : this.s) {
                if (next instanceof e) {
                    builder.include(((Marker) next.getFeature()).getPosition());
                    z3 = true;
                }
            }
            if (z3) {
                CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 50);
                if (z2) {
                    this.f3306a.animateCamera(newLatLngBounds);
                } else {
                    this.f3306a.moveCamera(newLatLngBounds);
                }
            }
        }
    }

    public void a(ReadableArray readableArray, ReadableMap readableMap, boolean z2) {
        if (this.f3306a != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            String[] strArr = new String[readableArray.size()];
            boolean z3 = false;
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                strArr[i2] = readableArray.getString(i2);
            }
            List asList = Arrays.asList(strArr);
            for (c next : this.s) {
                if (next instanceof e) {
                    String identifier = ((e) next).getIdentifier();
                    Marker marker = (Marker) next.getFeature();
                    if (asList.contains(identifier)) {
                        builder.include(marker.getPosition());
                        z3 = true;
                    }
                }
            }
            if (z3) {
                CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 50);
                if (readableMap != null) {
                    this.f3306a.setPadding(readableMap.getInt(ViewProps.LEFT), readableMap.getInt(ViewProps.TOP), readableMap.getInt(ViewProps.RIGHT), readableMap.getInt(ViewProps.BOTTOM));
                }
                if (z2) {
                    this.f3306a.animateCamera(newLatLngBounds);
                } else {
                    this.f3306a.moveCamera(newLatLngBounds);
                }
            }
        }
    }

    public void b(ReadableArray readableArray, ReadableMap readableMap, boolean z2) {
        if (this.f3306a != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                ReadableMap map = readableArray.getMap(i2);
                builder.include(new LatLng(Double.valueOf(map.getDouble("latitude")).doubleValue(), Double.valueOf(map.getDouble("longitude")).doubleValue()));
            }
            CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 50);
            if (readableMap != null) {
                this.f3306a.setPadding(readableMap.getInt(ViewProps.LEFT), readableMap.getInt(ViewProps.TOP), readableMap.getInt(ViewProps.RIGHT), readableMap.getInt(ViewProps.BOTTOM));
            }
            if (z2) {
                this.f3306a.animateCamera(newLatLngBounds);
            } else {
                this.f3306a.moveCamera(newLatLngBounds);
            }
            this.f3306a.setPadding(0, 0, 0, 0);
        }
    }

    public void a(ReadableMap readableMap, ReadableMap readableMap2) {
        if (this.f3306a != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(new LatLng(Double.valueOf(readableMap.getDouble("latitude")).doubleValue(), Double.valueOf(readableMap.getDouble("longitude")).doubleValue()));
            builder.include(new LatLng(Double.valueOf(readableMap2.getDouble("latitude")).doubleValue(), Double.valueOf(readableMap2.getDouble("longitude")).doubleValue()));
            this.f3306a.setLatLngBoundsForCameraTarget(builder.build());
        }
    }

    public View getInfoWindow(Marker marker) {
        return a(marker).getCallout();
    }

    public View getInfoContents(Marker marker) {
        return a(marker).getInfoContents();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.w.a(motionEvent);
        int a2 = i.a(motionEvent);
        boolean z2 = false;
        if (a2 == 0) {
            ViewParent parent = getParent();
            GoogleMap googleMap = this.f3306a;
            if (googleMap != null && googleMap.getUiSettings().isScrollGesturesEnabled()) {
                z2 = true;
            }
            parent.requestDisallowInterceptTouchEvent(z2);
        } else if (a2 == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void onMarkerDragStart(Marker marker) {
        this.x.pushEvent(this.B, this, "onMarkerDragStart", a(marker.getPosition()));
        this.x.pushEvent(this.B, a(marker), "onDragStart", a(marker.getPosition()));
    }

    public void onMarkerDrag(Marker marker) {
        this.x.pushEvent(this.B, this, "onMarkerDrag", a(marker.getPosition()));
        this.x.pushEvent(this.B, a(marker), "onDrag", a(marker.getPosition()));
    }

    public void onMarkerDragEnd(Marker marker) {
        this.x.pushEvent(this.B, this, "onMarkerDragEnd", a(marker.getPosition()));
        this.x.pushEvent(this.B, a(marker), "onDragEnd", a(marker.getPosition()));
    }

    public void onPoiClick(PointOfInterest pointOfInterest) {
        WritableMap a2 = a(pointOfInterest.latLng);
        a2.putString("placeId", pointOfInterest.placeId);
        a2.putString("name", pointOfInterest.name);
        this.x.pushEvent(this.B, this, "onPoiClick", a2);
    }

    private ProgressBar getMapLoadingProgressBar() {
        if (this.f3308c == null) {
            this.f3308c = new ProgressBar(getContext());
            this.f3308c.setIndeterminate(true);
        }
        Integer num = this.h;
        if (num != null) {
            setLoadingIndicatorColor(num);
        }
        return this.f3308c;
    }

    private RelativeLayout getMapLoadingLayoutView() {
        if (this.f3309d == null) {
            this.f3309d = new RelativeLayout(getContext());
            this.f3309d.setBackgroundColor(-3355444);
            addView(this.f3309d, new ViewGroup.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f3309d.addView(getMapLoadingProgressBar(), layoutParams);
            this.f3309d.setVisibility(4);
        }
        setLoadingBackgroundColor(this.f3312g);
        return this.f3309d;
    }

    private ImageView getCacheImageView() {
        if (this.f3310e == null) {
            this.f3310e = new ImageView(getContext());
            addView(this.f3310e, new ViewGroup.LayoutParams(-1, -1));
            this.f3310e.setVisibility(4);
        }
        return this.f3310e;
    }

    private void c() {
        ImageView imageView = this.f3310e;
        if (imageView != null) {
            ((ViewGroup) imageView.getParent()).removeView(this.f3310e);
            this.f3310e = null;
        }
    }

    private void d() {
        ProgressBar progressBar = this.f3308c;
        if (progressBar != null) {
            ((ViewGroup) progressBar.getParent()).removeView(this.f3308c);
            this.f3308c = null;
        }
    }

    private void e() {
        d();
        RelativeLayout relativeLayout = this.f3309d;
        if (relativeLayout != null) {
            ((ViewGroup) relativeLayout.getParent()).removeView(this.f3309d);
            this.f3309d = null;
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.n) {
            final ImageView cacheImageView = getCacheImageView();
            final RelativeLayout mapLoadingLayoutView = getMapLoadingLayoutView();
            cacheImageView.setVisibility(4);
            mapLoadingLayoutView.setVisibility(0);
            if (this.f3311f.booleanValue()) {
                this.f3306a.snapshot(new GoogleMap.SnapshotReadyCallback() {
                    public void onSnapshotReady(Bitmap bitmap) {
                        cacheImageView.setImageBitmap(bitmap);
                        cacheImageView.setVisibility(0);
                        mapLoadingLayoutView.setVisibility(4);
                    }
                });
                return;
            }
            return;
        }
        c();
        if (this.f3311f.booleanValue()) {
            e();
        }
    }

    public void a(MotionEvent motionEvent) {
        this.x.pushEvent(this.B, this, "onPanDrag", a(this.f3306a.getProjection().fromScreenLocation(new Point((int) motionEvent.getX(), (int) motionEvent.getY()))));
    }

    public void setKmlSrc(String str) {
        try {
            InputStream inputStream = (InputStream) new k(this.B).execute(new String[]{str}).get();
            if (inputStream != null) {
                this.f3307b = new f(this.f3306a, inputStream, this.B);
                this.f3307b.c();
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                if (this.f3307b.b() == null) {
                    this.x.pushEvent(this.B, this, "onKmlReady", writableNativeMap);
                    return;
                }
                b next = this.f3307b.b().iterator().next();
                if (next != null) {
                    if (next.f() != null) {
                        if (next.f().iterator().hasNext()) {
                            next = next.f().iterator().next();
                        }
                        Integer num = 0;
                        for (com.google.maps.android.a.b.j next2 : next.g()) {
                            MarkerOptions markerOptions = new MarkerOptions();
                            if (next2.f() != null) {
                                markerOptions = next2.h();
                            } else {
                                markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
                            }
                            LatLng latLng = (LatLng) next2.c().d();
                            String str2 = "";
                            String a2 = next2.b("name") ? next2.a("name") : str2;
                            if (next2.b("description")) {
                                str2 = next2.a("description");
                            }
                            markerOptions.position(latLng);
                            markerOptions.title(a2);
                            markerOptions.snippet(str2);
                            e eVar = new e(this.B, markerOptions);
                            if (next2.f() != null && next2.f().g() != null) {
                                eVar.setImage(next2.f().g());
                            } else if (next.a(next2.e()) != null) {
                                eVar.setImage(next.a(next2.e()).g());
                            }
                            String str3 = a2 + " - " + num;
                            eVar.setIdentifier(str3);
                            Integer valueOf = Integer.valueOf(num.intValue() + 1);
                            a((View) eVar, num.intValue());
                            WritableMap a3 = a(latLng);
                            a3.putString("id", str3);
                            a3.putString("title", a2);
                            a3.putString("description", str2);
                            writableNativeArray.pushMap(a3);
                            num = valueOf;
                        }
                        writableNativeMap.putArray("markers", writableNativeArray);
                        this.x.pushEvent(this.B, this, "onKmlReady", writableNativeMap);
                        return;
                    }
                }
                this.x.pushEvent(this.B, this, "onKmlReady", writableNativeMap);
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        } catch (ExecutionException e5) {
            e5.printStackTrace();
        }
    }

    public void onIndoorBuildingFocused() {
        IndoorBuilding focusedBuilding = this.f3306a.getFocusedBuilding();
        int i2 = 0;
        if (focusedBuilding != null) {
            List<IndoorLevel> levels = focusedBuilding.getLevels();
            WritableArray createArray = Arguments.createArray();
            for (IndoorLevel next : levels) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("index", i2);
                createMap.putString("name", next.getName());
                createMap.putString("shortName", next.getShortName());
                createArray.pushMap(createMap);
                i2++;
            }
            WritableMap createMap2 = Arguments.createMap();
            WritableMap createMap3 = Arguments.createMap();
            createMap3.putArray("levels", createArray);
            createMap3.putInt("activeLevelIndex", focusedBuilding.getActiveLevelIndex());
            createMap3.putBoolean("underground", focusedBuilding.isUnderground());
            createMap2.putMap("IndoorBuilding", createMap3);
            this.x.pushEvent(this.B, this, "onIndoorBuildingFocused", createMap2);
            return;
        }
        WritableMap createMap4 = Arguments.createMap();
        WritableArray createArray2 = Arguments.createArray();
        WritableMap createMap5 = Arguments.createMap();
        createMap5.putArray("levels", createArray2);
        createMap5.putInt("activeLevelIndex", 0);
        createMap5.putBoolean("underground", false);
        createMap4.putMap("IndoorBuilding", createMap5);
        this.x.pushEvent(this.B, this, "onIndoorBuildingFocused", createMap4);
    }

    public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
        int activeLevelIndex = indoorBuilding.getActiveLevelIndex();
        IndoorLevel indoorLevel = indoorBuilding.getLevels().get(activeLevelIndex);
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt("activeLevelIndex", activeLevelIndex);
        createMap2.putString("name", indoorLevel.getName());
        createMap2.putString("shortName", indoorLevel.getShortName());
        createMap.putMap("IndoorLevel", createMap2);
        this.x.pushEvent(this.B, this, "onIndoorLevelActivated", createMap);
    }

    public void setIndoorActiveLevelIndex(int i2) {
        IndoorBuilding focusedBuilding = this.f3306a.getFocusedBuilding();
        if (focusedBuilding != null && i2 >= 0 && i2 < focusedBuilding.getLevels().size()) {
            IndoorLevel indoorLevel = focusedBuilding.getLevels().get(i2);
            if (indoorLevel != null) {
                indoorLevel.activate();
            }
        }
    }

    /* access modifiers changed from: private */
    public e a(Marker marker) {
        e eVar = this.t.get(marker);
        if (eVar != null) {
            return eVar;
        }
        for (Map.Entry next : this.t.entrySet()) {
            if (((Marker) next.getKey()).getPosition().equals(marker.getPosition()) && ((Marker) next.getKey()).getTitle().equals(marker.getTitle())) {
                return (e) next.getValue();
            }
        }
        return eVar;
    }
}
