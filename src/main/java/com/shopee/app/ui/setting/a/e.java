package com.shopee.app.ui.setting.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.c;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.shopee.app.application.ar;
import com.shopee.app.application.at;
import com.shopee.app.camera.MakePhotoActivity;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ae;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.setting.SettingConfig;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.ui.setting.a.a.a;
import com.shopee.app.util.b;
import com.shopee.app.util.s;
import com.shopee.id.R;
import com.shopee.shopeetracker.ShopeeTracker;
import com.shopee.shopeetracker.model.Config;
import com.shopee.shopeetracker.utils.SendEventTask;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class e extends q<a> {

    /* renamed from: a  reason: collision with root package name */
    public final SettingConfigStore f25091a;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f25092c = new View.OnClickListener() {
        public void onClick(View view) {
            e.this.h.b(((com.shopee.app.ui.setting.cell.a) view).c());
            ar.a(false);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f25093d = new View.OnClickListener() {
        public void onClick(View view) {
            e.this.h.g(((com.shopee.app.ui.setting.cell.a) view).c());
            ar.a(false);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f25094e = new View.OnClickListener() {
        public void onClick(View view) {
            e.this.h.c(((com.shopee.app.ui.setting.cell.a) view).c());
            ar.a(false);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f25095f = new View.OnClickListener() {
        public void onClick(View view) {
            if (((com.shopee.app.ui.setting.cell.a) view).c()) {
                view.getContext().startService(new Intent(view.getContext(), f.class));
            } else {
                view.getContext().stopService(new Intent(view.getContext(), f.class));
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f25096g = new View.OnClickListener() {
        public void onClick(View view) {
            HashMap hashMap;
            com.shopee.app.ui.setting.cell.a aVar = (com.shopee.app.ui.setting.cell.a) view;
            try {
                String str = (String) aVar.getTag();
                if (!str.equals("isMallTabRN")) {
                    if (!str.equals("isHomeTabRN2")) {
                        hashMap = new HashMap();
                        hashMap.put("default", Boolean.valueOf(aVar.c()));
                        SettingConfig a2 = e.this.f25091a.forbiddenZoneConfig.a();
                        a2.getClass().getDeclaredField(str).set(a2, hashMap);
                        e.this.f25091a.forbiddenZoneConfig.a(a2);
                        e.this.f25091a.invalidateCache();
                    }
                }
                hashMap = new HashMap();
                hashMap.put("default", Integer.valueOf(aVar.c() ? 100 : 0));
                SettingConfig a22 = e.this.f25091a.forbiddenZoneConfig.a();
                a22.getClass().getDeclaredField(str).set(a22, hashMap);
                e.this.f25091a.forbiddenZoneConfig.a(a22);
                e.this.f25091a.invalidateCache();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };
    /* access modifiers changed from: private */
    public final al h;
    /* access modifiers changed from: private */
    public final ae i;
    private final b j;
    private final bd k;
    private final s l;
    private int m = -1;

    public void a() {
    }

    public void b() {
    }

    public e(al alVar, b bVar, SettingConfigStore settingConfigStore, ae aeVar, bd bdVar, s sVar) {
        this.h = alVar;
        this.f25091a = settingConfigStore;
        this.i = aeVar;
        this.j = bVar;
        this.k = bdVar;
        this.l = sVar;
    }

    public void e() {
        ((a) this.f19220b).a(new d());
    }

    public void f() {
        this.f25091a.fetchEditConfig();
        this.f25091a.forbiddenZoneConfig.b();
    }

    public void g() {
        this.l.a();
    }

    public void h() {
        String feaureToggleName = ((a) this.f19220b).getFeaureToggleName();
        ((a) this.f19220b).a(feaureToggleName, this.l.a(feaureToggleName));
    }

    public void i() {
        ((a) this.f19220b).a(this.h.n(), new a.C0387a() {
            public void a(int i) {
                e.this.h.a(i);
                ar.a(false);
            }
        }, "None", "Show Errors", "Show Everything");
    }

    public boolean j() {
        return this.h.p();
    }

    public boolean k() {
        return this.h.q();
    }

    public boolean l() {
        return a(((a) this.f19220b).getContext(), f.class.getName());
    }

    public static boolean a(Context context, String str) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (runningServiceInfo.service.getClassName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ((a) this.f19220b).a(-1, new a.C0387a() {
            public void a(int i) {
                ((HomeActivity_.a) HomeActivity_.a(((a) e.this.f19220b).getContext()).k(67108864)).a("sell?type=" + i).a();
            }
        }, "Camera", "Gallery", "Instagram");
    }

    public void n() {
        boolean a2 = this.i.a();
        ((a) this.f19220b).a(a2 ? 1 : 0, new a.C0387a() {
            public void a(int i) {
                ae c2 = e.this.i;
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                c2.a(z);
                ar.a(false);
            }
        }, "Hide Network Logs", "Show Network Logs");
    }

    public void o() {
        boolean b2 = this.i.b();
        ((a) this.f19220b).a(b2 ? 1 : 0, new a.C0387a() {
            public void a(int i) {
                ae c2 = e.this.i;
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                c2.b(z);
                ar.a(false);
            }
        }, "Disable network interceptor", "Enable network interceptor");
    }

    public void p() {
        ((a) this.f19220b).a(1, new a.C0387a() {
            public void a(int i) {
                if (i == 0) {
                    throw new RuntimeException("Test Exception from Forbidden Zone!");
                }
            }
        }, "Crash", "Don't Crash");
    }

    public void q() {
        this.k.b(true);
        this.k.a(true);
        this.k.e(true);
        this.k.f(true);
        this.k.c(true);
        this.k.d(true);
        ar.a(false);
    }

    public void r() {
        new com.shopee.app.util.c.a().a(((com.shopee.app.ui.a.b) ((a) this.f19220b).getContext()).x(), 1200000, 1200200, this.f25091a.coinMultiplier());
    }

    public void s() {
        this.j.a(String.format("reactNative?bundle=shopee&module=MAP_PAGE&address=%1$s", new Object[]{URLEncoder.encode("30A Holland Close")}));
    }

    public void t() {
        new SendEventTask().execute(new Boolean[]{true});
    }

    public void u() {
        Intent intent = new Intent(((a) this.f19220b).getContext(), MakePhotoActivity.class);
        intent.putExtra("camera_resource_id", -1);
        intent.putExtra("SHOW_PREVIEW", true);
        intent.putExtra("CAMERA_MODE", 0);
        intent.putExtra("maxCount", 9);
        ((a) ((a) this.f19220b).getContext()).startActivityForResult(intent, 4);
    }

    public void v() {
        Intent intent = new Intent(((a) this.f19220b).getContext(), MakePhotoActivity.class);
        intent.putExtra("camera_resource_id", -1);
        intent.putExtra("SHOW_PREVIEW", true);
        intent.putExtra("CAMERA_MODE", 1);
        intent.putExtra("maxCount", 9);
        ((a) ((a) this.f19220b).getContext()).startActivityForResult(intent, 4);
    }

    public void w() {
        Intent intent = new Intent(((a) this.f19220b).getContext(), MakePhotoActivity.class);
        intent.putExtra("camera_resource_id", -1);
        intent.putExtra("SHOW_PREVIEW", true);
        intent.putExtra("CAMERA_MODE", 2);
        intent.putExtra("maxCount", 9);
        ((a) ((a) this.f19220b).getContext()).startActivityForResult(intent, 4);
    }

    public void x() {
        Intent intent = new Intent(((a) this.f19220b).getContext(), MakePhotoActivity.class);
        intent.putExtra("camera_resource_id", -1);
        intent.putExtra("SHOW_PREVIEW", true);
        intent.putExtra("CAMERA_MODE", 3);
        intent.putExtra("maxCount", 9);
        ((a) ((a) this.f19220b).getContext()).startActivityForResult(intent, 4);
    }

    public void y() {
        Config config = ShopeeTracker.getInstance().getConfig();
        StringBuilder sb = new StringBuilder();
        if (config != null) {
            sb.append("NeedCharge:");
            sb.append(config.isNeedCharger());
            sb.append("\n");
            sb.append("BatchSize:");
            sb.append(config.getBatchSize());
            sb.append("\n");
            sb.append("Period:");
            sb.append(config.getPeriod());
            sb.append("s");
            sb.append("\n");
            sb.append("Period Below Android M:");
            sb.append(config.getPeriodBelowAndroidM());
            sb.append("s");
            sb.append("\n");
            sb.append("PeriodForeground:");
            sb.append(config.getPeriodForeground());
            sb.append("s");
        }
        ((a) this.f19220b).a(sb.toString());
    }

    public void z() {
        h.a(((a) this.f19220b).getContext()).a();
    }

    public void A() {
        this.j.a(String.format("BCAWidget?requestID=%s&type=%s&redirectTo=%s&accessToken=%s&apiKey=%s&apiSeed=%s&customerIDMerchant=%s&merchantID=%s&xcoID=%s&timeout=%s", new Object[]{"123", "456", "a_redirect_url", "some_token", "some_key", "some_seed", "789", "012", "345", "10000"}));
    }

    public void B() {
        ((a) ((a) this.f19220b).getContext()).l();
    }

    public void C() {
        new c.a(((a) this.f19220b).getContext()).a((CharSequence[]) new String[]{"Normal", "Selfie overlay", "ID card overlay"}, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ((a) ((a) e.this.f19220b).getContext()).b(i);
            }
        }).c();
    }

    public void D() {
        AlertDialog.Builder builder = new AlertDialog.Builder(((a) this.f19220b).getContext());
        Object[] array = com.shopee.app.ui.c.a.f19988a.a().keySet().toArray();
        final String[] strArr = (String[]) Arrays.copyOf(array, array.length, String[].class);
        final ArrayList arrayList = new ArrayList();
        builder.setMultiChoiceItems(strArr, new boolean[strArr.length], new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                if (z) {
                    arrayList.add(strArr[i]);
                } else {
                    arrayList.remove(strArr[i]);
                }
            }
        });
        builder.setPositiveButton(R.string.sp_label_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ((a) ((a) e.this.f19220b).getContext()).a((List<String>) arrayList);
            }
        });
        builder.create().show();
    }

    public void E() {
        AlertDialog.Builder builder = new AlertDialog.Builder(((a) this.f19220b).getContext());
        Object[] array = com.shopee.app.ui.c.a.f19988a.a().keySet().toArray();
        final String[] strArr = (String[]) Arrays.copyOf(array, array.length, String[].class);
        final ArrayList arrayList = new ArrayList();
        builder.setMultiChoiceItems(strArr, new boolean[strArr.length], new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                if (z) {
                    arrayList.add(strArr[i]);
                } else {
                    arrayList.remove(strArr[i]);
                }
            }
        });
        builder.setPositiveButton(R.string.sp_label_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ((a) ((a) e.this.f19220b).getContext()).b((List<String>) arrayList);
            }
        });
        builder.create().show();
    }

    public void F() {
        ((a) ((a) this.f19220b).getContext()).p();
    }

    public void G() {
        ((a) ((a) this.f19220b).getContext()).q();
    }

    public void H() {
        String A = this.h.A();
        r a2 = r.a();
        a2.a("current url: " + A);
        AlertDialog.Builder builder = new AlertDialog.Builder(((a) this.f19220b).getContext());
        final EditText editText = new EditText(((a) this.f19220b).getContext());
        editText.setText(A);
        builder.setView(editText);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                e.this.h.a(editText.getText().toString());
            }
        });
        builder.create().show();
    }

    public void I() {
        if (this.i.b()) {
            at.f15865a.a(((a) this.f19220b).getContext());
        } else {
            r.a().a("Have to enable network log first");
        }
    }

    public void a(Activity activity) {
        if (com.shopee.app.g.q.a()) {
            FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(activity, new OnSuccessListener<com.google.firebase.iid.a>() {
                /* renamed from: a */
                public void onSuccess(com.google.firebase.iid.a aVar) {
                    ((a) e.this.f19220b).b(aVar.a());
                }
            });
        }
    }
}
