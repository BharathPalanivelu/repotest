package com.shopee.app.util.c;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.data.viewmodel.CoinInfo;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class b extends FrameLayout implements View.OnClickListener {
    private static final int[][] l = {new int[]{0, 0}, new int[]{-b.a.f7695f, 0}, new int[]{b.a.m, 0}, new int[]{0, b.a.n}, new int[]{b.a.k, b.a.k}, new int[]{0, b.a.m}};
    private static final int[] m = {0, 100, 200, 300, 300, 400};

    /* renamed from: a  reason: collision with root package name */
    Button f26276a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f26277b;

    /* renamed from: c  reason: collision with root package name */
    TextView f26278c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f26279d;

    /* renamed from: e  reason: collision with root package name */
    View f26280e;

    /* renamed from: f  reason: collision with root package name */
    View f26281f;

    /* renamed from: g  reason: collision with root package name */
    TextView f26282g;
    Animation h;
    Animation i;
    Animation j;
    Animation k;
    private List<ImageView> n = new ArrayList();
    private long o;
    private long p;
    /* access modifiers changed from: private */
    public a q;
    private CoinInfo r;

    public interface a {
        void a();
    }

    public void onClick(View view) {
    }

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        setClickable(true);
        setFocusable(true);
        setOnClickListener(this);
        for (int i2 = 0; i2 < 6; i2++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(R.drawable.ic_coins_nav);
            imageView.setVisibility(4);
            this.n.add(imageView);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f26281f.post(new Runnable() {
            public void run() {
                b.this.b();
                b.this.f26281f.startAnimation(b.this.h);
                b.this.h.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationEnd(Animation animation) {
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                        b.this.f26281f.setVisibility(0);
                    }
                });
            }
        });
    }

    public void a(long j2, long j3, CoinInfo coinInfo) {
        this.o = j2;
        this.p = j3;
        this.r = coinInfo;
        this.f26278c.setText(com.garena.android.appkit.tools.b.a(R.string.sp_add_x_shopee_coins, coinInfo.value(j3 - j2)));
        this.f26282g.setText(coinInfo.value(j2));
    }

    public void setOnCollectListener(View.OnClickListener onClickListener) {
        this.f26276a.setOnClickListener(onClickListener);
    }

    public void b() {
        this.f26280e.startAnimation(this.j);
        this.j.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                b.this.f26280e.setVisibility(0);
            }
        });
    }

    public void c() {
        setBackgroundColor(0);
        this.f26280e.startAnimation(this.k);
        this.k.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                b.this.f26280e.setVisibility(4);
            }
        });
    }

    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r6v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v7 */
    public void d() {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        this.f26277b.getDrawingRect(rect);
        this.f26277b.getLocationInWindow(iArr);
        char c2 = 0;
        int centerX = (iArr[0] + rect.centerX()) - b.a.h;
        ? r6 = 1;
        int i2 = iArr[1] - b.a.h;
        int[] iArr2 = new int[2];
        this.f26279d.getDrawingRect(rect);
        this.f26279d.getLocationInWindow(iArr2);
        int centerX2 = ((iArr2[0] + rect.centerX()) - b.a.f7696g) - b.a.f7691b;
        int i3 = (iArr2[1] - b.a.k) - b.a.f7693d;
        int i4 = 0;
        while (i4 < this.n.size()) {
            final ImageView imageView = this.n.get(i4);
            imageView.setTag(Integer.valueOf(i4));
            addView(imageView, new FrameLayout.LayoutParams(b.a.m, b.a.m));
            final AnimationSet animationSet = new AnimationSet(r6);
            int[][] iArr3 = l;
            TranslateAnimation translateAnimation = r10;
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0, (float) (iArr3[i4][c2] + centerX), 0, (float) centerX2, 0, (float) (iArr3[i4][r6] + i2), 0, (float) i3);
            translateAnimation.setDuration(1000);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
            alphaAnimation.setDuration(1000);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            postDelayed(new Runnable() {
                public void run() {
                    animationSet.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            imageView.setVisibility(0);
                        }

                        public void onAnimationEnd(Animation animation) {
                            imageView.setVisibility(4);
                        }
                    });
                    imageView.startAnimation(animationSet);
                }
            }, (long) m[i4]);
            i4++;
            c2 = 0;
            r6 = 1;
        }
        postDelayed(new Runnable() {
            public void run() {
                b.this.c();
            }
        }, 100);
        postDelayed(new Runnable() {
            public void run() {
                b.this.f();
            }
        }, 900);
    }

    /* access modifiers changed from: private */
    public void f() {
        b(getSamples(), 0);
    }

    /* access modifiers changed from: private */
    public void b(final List<Integer> list, int i2) {
        this.f26282g.setText(this.r.value(this.o + ((long) list.get(i2).intValue())));
        final int i3 = i2 + 1;
        if (i3 < list.size()) {
            postDelayed(new Runnable() {
                public void run() {
                    b.this.b(list, i3);
                }
            }, 40);
            return;
        }
        this.f26282g.setText(this.r.value(this.p));
        postDelayed(new Runnable() {
            public void run() {
                b.this.e();
            }
        }, 300);
    }

    private List<Integer> getSamples() {
        ArrayList arrayList = new ArrayList();
        long j2 = this.p - this.o;
        for (int i2 = 0; ((long) i2) < j2; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (j2 < 36) {
            return arrayList;
        }
        return a(arrayList, 36);
    }

    public void e() {
        this.f26281f.startAnimation(this.i);
        this.i.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                b.this.f26281f.setVisibility(4);
            }

            public void onAnimationEnd(Animation animation) {
                if (b.this.q != null) {
                    b.this.q.a();
                }
            }
        });
    }

    public static List<Integer> a(List<Integer> list, int i2, Random random) {
        int size = list.size();
        if (size < i2) {
            return null;
        }
        int i3 = size - 1;
        while (true) {
            int i4 = size - i2;
            if (i3 >= i4) {
                Collections.swap(list, i3, random.nextInt(i3 + 1));
                i3--;
            } else {
                ArrayList arrayList = new ArrayList(list.subList(i4, size));
                Collections.sort(arrayList);
                return arrayList;
            }
        }
    }

    public static List<Integer> a(List<Integer> list, int i2) {
        return a(list, i2, new Random());
    }

    public void setOnAnimationFinishListener(a aVar) {
        this.q = aVar;
    }
}
