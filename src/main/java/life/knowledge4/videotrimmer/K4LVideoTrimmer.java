package life.knowledge4.videotrimmer;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.w;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import life.knowledge4.videotrimmer.a;
import life.knowledge4.videotrimmer.a.e;
import life.knowledge4.videotrimmer.b.a;
import life.knowledge4.videotrimmer.c.a;
import life.knowledge4.videotrimmer.view.PlayerView;
import life.knowledge4.videotrimmer.view.ProgressBarView;
import life.knowledge4.videotrimmer.view.RangeSeekBarView;

public class K4LVideoTrimmer extends FrameLayout implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, SeekBar.OnSeekBarChangeListener, life.knowledge4.videotrimmer.a.a, life.knowledge4.videotrimmer.a.b, PlayerView.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33728a = "K4LVideoTrimmer";
    private e A;
    /* access modifiers changed from: private */
    public d B;
    /* access modifiers changed from: private */
    public LinearLayoutManager C;
    private final GestureDetector.SimpleOnGestureListener D;
    private final View.OnTouchListener E;
    private final a.C0530a F;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f33729b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public RangeSeekBarView f33730c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBarView f33731d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f33732e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public PlayerView f33733f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public w f33734g;
    /* access modifiers changed from: private */
    public ImageView h;
    /* access modifiers changed from: private */
    public RecyclerView i;
    private TextView j;
    /* access modifiers changed from: private */
    public life.knowledge4.videotrimmer.a.d k;
    private VideoView l;
    private Uri m;
    private String n;
    private List<life.knowledge4.videotrimmer.a.a> o;
    private life.knowledge4.videotrimmer.a.c p;
    private long q;
    private long r;
    /* access modifiers changed from: private */
    public long s;
    private long t;
    private long u;
    private long v;
    private int w;
    /* access modifiers changed from: private */
    public boolean x;
    private boolean y;
    /* access modifiers changed from: private */
    public GestureDetector z;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f33742a;

        /* renamed from: b  reason: collision with root package name */
        public int f33743b;

        /* renamed from: c  reason: collision with root package name */
        public int f33744c;
    }

    private void a(String str, Object... objArr) {
    }

    private void e() {
    }

    public void a(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return false;
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public K4LVideoTrimmer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public K4LVideoTrimmer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33729b = new a(this);
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 60000;
        this.x = true;
        this.D = new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (K4LVideoTrimmer.this.f33734g.b()) {
                    K4LVideoTrimmer.this.i();
                    return true;
                }
                K4LVideoTrimmer.this.h.setVisibility(8);
                if (K4LVideoTrimmer.this.x) {
                    boolean unused = K4LVideoTrimmer.this.x = false;
                    K4LVideoTrimmer.this.f33734g.a(K4LVideoTrimmer.this.s);
                }
                K4LVideoTrimmer.this.f33729b.sendEmptyMessage(2);
                K4LVideoTrimmer.this.h();
                return true;
            }
        };
        this.E = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                K4LVideoTrimmer.this.z.onTouchEvent(motionEvent);
                return true;
            }
        };
        this.F = new a.C0530a() {
            public void a(final List<b> list) {
                life.knowledge4.videotrimmer.c.b.a("id", new Runnable() {
                    public void run() {
                        K4LVideoTrimmer.this.B.a(list);
                        K4LVideoTrimmer.this.f33730c.setThumbnailContainerWidth(K4LVideoTrimmer.this.i.getWidth());
                    }
                }, 0);
            }
        };
        a(context);
    }

    private void a(String str) {
        life.knowledge4.videotrimmer.c.a.a((a.C0531a) new life.knowledge4.videotrimmer.b.a(str, ((((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth() - this.i.getPaddingRight()) - this.i.getPaddingLeft()) - (getContext().getResources().getDimensionPixelOffset(a.b.dp10) * 2), getResources().getDimensionPixelOffset(a.b.frames_video_height), this.u, this.F));
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(a.e.view_time_line, this, true);
        f();
        e();
        d();
        g();
        this.f33734g = this.f33733f.getPlayer();
    }

    private void d() {
        this.o = new ArrayList();
        this.o.add(this);
        this.o.add(this.f33731d);
        this.i.a((RecyclerView.n) new RecyclerView.n() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                a();
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    a();
                }
            }

            private void a() {
                int n = K4LVideoTrimmer.this.C.n();
                if (n != -1) {
                    View childAt = K4LVideoTrimmer.this.i.getChildAt(0);
                    K4LVideoTrimmer.this.a(1, 0, (n * childAt.getWidth()) - childAt.getLeft());
                }
            }
        });
        this.f33733f.setInitListener(this);
        this.f33730c.a((life.knowledge4.videotrimmer.a.b) this);
        this.f33730c.a((life.knowledge4.videotrimmer.a.b) this.f33731d);
        this.z = new GestureDetector(getContext(), this.D);
        this.f33733f.setOnTouchListener(this.E);
    }

    public void setTrimmer(e eVar) {
        this.A = eVar;
    }

    public void a() {
        this.h.setVisibility(0);
        this.f33734g.a(false);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.m.getPath());
        long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        File file = new File(this.m.getPath());
        long j2 = this.r;
        if (j2 < 1000) {
            long j3 = this.t;
            if (parseLong - j3 > 1000 - j2) {
                this.t = j3 + (1000 - j2);
            } else {
                long j4 = this.s;
                if (j4 > 1000 - j2) {
                    this.s = j4 - (1000 - j2);
                }
            }
        }
        a(file, this.n, this.s, this.r, this.p);
    }

    private void f() {
        this.f33730c = (RangeSeekBarView) findViewById(a.d.timeLineBar);
        this.f33732e = (RelativeLayout) findViewById(a.d.layout_surface_view);
        this.f33733f = (PlayerView) findViewById(a.d.video_loader);
        this.h = (ImageView) findViewById(a.d.icon_video_play);
        this.f33731d = (ProgressBarView) findViewById(a.d.timeVideoView);
        this.i = (RecyclerView) findViewById(a.d.thumbnails);
        this.l = (VideoView) findViewById(a.d.video_loader_dummy);
        this.j = (TextView) findViewById(a.d.textSize);
        this.C = new LinearLayoutManager(getContext(), 0, false);
        this.i.setLayoutManager(this.C);
        this.B = new d();
        this.i.setAdapter(this.B);
    }

    public void setVideoURI(Uri uri) {
        this.m = uri;
        this.l.setVideoURI(uri);
        this.f33733f.a(uri.toString(), -1, false, -1);
        this.f33734g = this.f33733f.getPlayer();
        this.q = this.f33734g.e();
    }

    public void setDestinationPath(String str) {
        this.n = str;
    }

    private void g() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        this.n = externalStorageDirectory.getPath() + File.separator;
    }

    /* access modifiers changed from: private */
    public void h() {
        this.f33731d.a(this.s, this.t);
        this.y = true;
        this.f33734g.a(true);
    }

    /* access modifiers changed from: private */
    public void i() {
        this.f33729b.removeMessages(2);
        this.f33734g.a(false);
        this.h.setVisibility(0);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        int width = this.f33732e.getWidth();
        int height = this.f33732e.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f33733f.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.f33733f.setLayoutParams(layoutParams);
        this.h.setVisibility(0);
        this.f33730c.setDuration(this.q);
        this.f33730c.b();
        this.f33730c.a();
        this.s = 0;
        long j2 = this.s;
        long j3 = this.u;
        this.t = j2 + j3;
        this.r = j3;
        this.f33734g.a(j2);
    }

    private void a(File file, String str, long j2, long j3, life.knowledge4.videotrimmer.a.c cVar) {
        e eVar = this.A;
        if (eVar != null) {
            life.knowledge4.videotrimmer.c.a.a((a.C0531a) new life.knowledge4.videotrimmer.b.b(eVar, file, str, j2, j3, cVar));
            return;
        }
        throw new IllegalStateException("Trimmer not set");
    }

    public void b(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        a(2, i2, 0);
    }

    public void c(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        i();
    }

    public void d(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        i();
        this.x = true;
    }

    private void j() {
        this.f33731d.a(0, 0, (float) BitmapDescriptorFactory.HUE_RED);
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, int i4) {
        int a2 = a(this.f33730c.getThumbs().get(i3).b());
        a("Moved thumb of index " + i3 + " to position " + a2, new Object[0]);
        if (i2 == 1) {
            if (this.f33734g.b()) {
                i();
            }
            this.w = i4;
            this.s = (long) a2;
            long j2 = this.s;
            this.t = this.r + j2;
            this.f33734g.a(j2);
            this.x = true;
            j();
        } else if (i2 == 2) {
            if (i3 == 0) {
                this.s = (long) a2;
                this.f33734g.a(this.s);
            } else if (i3 == 1) {
                this.t = (long) a2;
                this.f33734g.a(this.t);
            }
            this.r = this.t - this.s;
        }
        a(this.s + SQLBuilder.BLANK + this.t, new Object[0]);
        this.f33731d.a(this.s, this.t);
    }

    public void setOnTrimVideoListener(life.knowledge4.videotrimmer.a.c cVar) {
        this.p = cVar;
    }

    public void setMaxDuration(int i2) {
        this.v = (long) (i2 * 1000);
    }

    public void setThumbLoader(life.knowledge4.videotrimmer.a.d dVar) {
        this.k = dVar;
    }

    public void setHint(CharSequence charSequence) {
        this.j.setText(charSequence);
    }

    public void setHintColor(int i2) {
        this.j.setTextColor(i2);
    }

    public void setPlayProgressColor(int i2) {
        this.f33731d.setProgressColor(i2);
    }

    public void b() {
        this.h.setVisibility(0);
        this.f33730c.setDuration(this.q);
        this.f33730c.b();
        this.f33730c.a();
        this.s = 0;
        long j2 = this.s;
        long j3 = this.u;
        this.t = j2 + j3;
        this.r = j3;
        this.f33734g.a(j2);
    }

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<K4LVideoTrimmer> f33741a;

        a(K4LVideoTrimmer k4LVideoTrimmer) {
            this.f33741a = new WeakReference<>(k4LVideoTrimmer);
        }

        public void handleMessage(Message message) {
            K4LVideoTrimmer k4LVideoTrimmer = (K4LVideoTrimmer) this.f33741a.get();
            if (k4LVideoTrimmer != null && k4LVideoTrimmer.f33733f != null) {
                k4LVideoTrimmer.a(true);
                if (k4LVideoTrimmer.f33734g != null && k4LVideoTrimmer.f33734g.b()) {
                    sendEmptyMessageDelayed(0, 10);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        w wVar = this.f33734g;
        if (wVar != null) {
            if (this.q == -9223372036854775807L) {
                this.q = wVar.e();
                if (this.q == -9223372036854775807L) {
                    return;
                }
            }
            long f2 = this.f33734g.f();
            long j2 = this.s;
            if (f2 <= j2) {
                f2 = j2;
            }
            if (z2) {
                for (life.knowledge4.videotrimmer.a.a a2 : this.o) {
                    long j3 = this.q;
                    a2.a(f2, j3, (float) ((f2 * 100) / j3));
                }
                return;
            }
            long j4 = this.q;
            this.o.get(1).a(f2, j4, (float) ((100 * f2) / j4));
        }
    }

    public void a(long j2, long j3, float f2) {
        if (this.f33733f != null && j2 >= this.t) {
            i();
            this.x = true;
        }
    }

    public void c() {
        life.knowledge4.videotrimmer.c.a.a("", true);
        life.knowledge4.videotrimmer.c.b.a("");
        i();
        w wVar = this.f33734g;
        if (wVar != null) {
            wVar.c();
            this.f33734g = null;
            System.gc();
        }
    }

    private int a(float f2) {
        if (this.q == 0) {
            this.q = this.f33734g.e();
        }
        float f3 = (f2 * ((float) this.u)) / 100.0f;
        View childAt = this.i.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        int width = childAt.getWidth();
        int itemCount = (this.B.getItemCount() * width) - this.i.getWidth();
        long j2 = this.q;
        float f4 = (((float) this.w) * ((float) (j2 - this.u))) / ((float) itemCount);
        int i2 = (int) (f3 + f4);
        a(String.format("du=%d fdu=%d num=%d w=%d tw=%d scrolled=%d ofs=%.1f seekto=%d", new Object[]{Long.valueOf(j2), Long.valueOf(this.q / ((long) this.B.getItemCount())), Integer.valueOf(this.B.getItemCount()), Integer.valueOf(width), Integer.valueOf(itemCount), Integer.valueOf(this.w), Float.valueOf(f4), Integer.valueOf(i2)}), new Object[0]);
        return i2;
    }

    public void setVisibleDurationAndGenerateBitmaps(int i2) {
        this.u = (long) i2;
        this.f33731d.setVisibleDuration(i2);
        this.f33730c.setVisibleDuration(i2);
        a(this.m.getPath());
    }

    private class d extends RecyclerView.a<c> {

        /* renamed from: b  reason: collision with root package name */
        private final List<b> f33747b;

        private d() {
            this.f33747b = new ArrayList();
        }

        /* access modifiers changed from: package-private */
        public void a(List<b> list) {
            this.f33747b.clear();
            if (list != null) {
                this.f33747b.addAll(list);
            }
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public c onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new c(new ImageView(K4LVideoTrimmer.this.getContext()));
        }

        /* renamed from: a */
        public void onBindViewHolder(c cVar, int i) {
            cVar.a(this.f33747b.get(i));
        }

        public int getItemCount() {
            return this.f33747b.size();
        }
    }

    private class c extends RecyclerView.w {
        c(ImageView imageView) {
            super(imageView);
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            RecyclerView.j jVar = (RecyclerView.j) this.itemView.getLayoutParams();
            if (jVar == null) {
                this.itemView.setLayoutParams(new RecyclerView.j(bVar.f33743b, bVar.f33744c));
            } else if (!(jVar.width == bVar.f33743b && jVar.height == bVar.f33744c)) {
                jVar.width = bVar.f33743b;
                jVar.height = bVar.f33744c;
                this.itemView.setLayoutParams(jVar);
            }
            if (K4LVideoTrimmer.this.k != null) {
                K4LVideoTrimmer.this.k.a((ImageView) this.itemView, bVar);
            }
        }
    }
}
