package com.shopee.app.util.youtube;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.garena.android.appkit.f.f;

public class OpenYouTubePlayerActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressBar f26537a;

    /* renamed from: b  reason: collision with root package name */
    protected TextView f26538b;

    /* renamed from: c  reason: collision with root package name */
    protected VideoView f26539c;

    /* renamed from: d  reason: collision with root package name */
    protected String f26540d = "Initializing";

    /* renamed from: e  reason: collision with root package name */
    protected String f26541e = "Detecting Bandwidth";

    /* renamed from: f  reason: collision with root package name */
    protected String f26542f = "Determining Latest Video in YouTube Playlist";

    /* renamed from: g  reason: collision with root package name */
    protected String f26543g = "Retrieving YouTube Video Token";
    protected String h = "Buffering Low-bandwidth Video";
    protected String i = "Buffering High-bandwidth Video";
    protected String j = "Communications Error";
    protected String k = "An error occurred during the retrieval of the video.  This could be due to network issues or YouTube protocols.  Please try again later.";
    protected b l;
    protected String m = null;
    private int n = 0;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        e eVar;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        b();
        a();
        getWindow().setFlags(128, 128);
        this.f26537a.bringToFront();
        this.f26537a.setVisibility(0);
        this.f26538b.setText(this.f26540d);
        Uri data = getIntent().getData();
        if (data == null) {
            Log.i(getClass().getSimpleName(), "No video ID was specified in the intent.  Closing video activity.");
            finish();
        }
        String scheme = data.getScheme();
        String encodedSchemeSpecificPart = data.getEncodedSchemeSpecificPart();
        if (encodedSchemeSpecificPart == null) {
            Log.i(getClass().getSimpleName(), "No video ID was specified in the intent.  Closing video activity.");
            finish();
        }
        if (encodedSchemeSpecificPart.startsWith("//")) {
            if (encodedSchemeSpecificPart.length() > 2) {
                encodedSchemeSpecificPart = encodedSchemeSpecificPart.substring(2);
            } else {
                Log.i(getClass().getSimpleName(), "No video ID was specified in the intent.  Closing video activity.");
                finish();
            }
        }
        if (scheme == null || !scheme.equalsIgnoreCase("ytpl")) {
            eVar = (scheme == null || !scheme.equalsIgnoreCase("ytv")) ? null : new c(encodedSchemeSpecificPart);
        } else {
            eVar = new b(encodedSchemeSpecificPart);
        }
        if (eVar == null) {
            Log.i(getClass().getSimpleName(), "Unable to extract video ID from the intent.  Closing video activity.");
            finish();
        }
        this.l = (b) new b().execute(new e[]{eVar});
    }

    private void a() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("com.keyes.video.msg.init");
        if (stringExtra != null) {
            this.f26540d = stringExtra;
        }
        String stringExtra2 = intent.getStringExtra("com.keyes.video.msg.detect");
        if (stringExtra2 != null) {
            this.f26541e = stringExtra2;
        }
        String stringExtra3 = intent.getStringExtra("com.keyes.video.msg.playlist");
        if (stringExtra3 != null) {
            this.f26542f = stringExtra3;
        }
        String stringExtra4 = intent.getStringExtra("com.keyes.video.msg.token");
        if (stringExtra4 != null) {
            this.f26543g = stringExtra4;
        }
        String stringExtra5 = intent.getStringExtra("com.keyes.video.msg.loband");
        if (stringExtra5 != null) {
            this.h = stringExtra5;
        }
        String stringExtra6 = intent.getStringExtra("com.keyes.video.msg.hiband");
        if (stringExtra6 != null) {
            this.i = stringExtra6;
        }
        String stringExtra7 = intent.getStringExtra("com.keyes.video.msg.error.title");
        if (stringExtra7 != null) {
            this.j = stringExtra7;
        }
        String stringExtra8 = intent.getStringExtra("com.keyes.video.msg.error.msg");
        if (stringExtra8 != null) {
            this.k = stringExtra8;
        }
    }

    private void b() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(1);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(-16777216);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setContentView(linearLayout);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(2);
        relativeLayout.setGravity(17);
        relativeLayout.setBackgroundColor(-16777216);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        linearLayout.addView(relativeLayout);
        this.f26539c = new VideoView(this);
        this.f26539c.setId(3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        layoutParams.addRule(10, -1);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(11, -1);
        this.f26539c.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f26539c);
        this.f26537a = new ProgressBar(this);
        this.f26537a.setIndeterminate(true);
        this.f26537a.setVisibility(0);
        this.f26537a.setEnabled(true);
        this.f26537a.setId(4);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f26537a.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f26537a);
        this.f26538b = new TextView(this);
        this.f26538b.setId(5);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, 4);
        this.f26538b.setLayoutParams(layoutParams3);
        this.f26538b.setTextColor(-3355444);
        this.f26538b.setTextSize(2, 12.0f);
        this.f26538b.setText("...");
        relativeLayout.addView(this.f26538b);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        f.a(this, this.m);
        b bVar = this.l;
        if (bVar != null) {
            bVar.cancel(true);
        }
        VideoView videoView = this.f26539c;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        getWindow().clearFlags(128);
        this.l = null;
        this.f26539c = null;
    }

    public void a(String str) {
        try {
            this.f26538b.setText(str);
        } catch (Exception e2) {
            Log.e(getClass().getSimpleName(), "Error updating video status!", e2);
        }
    }

    private class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26544a;

        public a(String str) {
            this.f26544a = str;
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + this.m)));
        com.garena.android.appkit.d.a.b(getClass().getSimpleName() + " play error", new Object[0]);
        finish();
    }

    private class b extends AsyncTask<e, a, Uri> {

        /* renamed from: b  reason: collision with root package name */
        private boolean f26547b;

        private b() {
            this.f26547b = false;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
            if (r2.getConnectionInfo().getIpAddress() != 0) goto L_0x007c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0086 A[Catch:{ Exception -> 0x0108 }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a1 A[Catch:{ Exception -> 0x0108 }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb A[Catch:{ Exception -> 0x0108 }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc A[Catch:{ Exception -> 0x0108 }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x011a  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x011f A[RETURN] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.net.Uri doInBackground(com.shopee.app.util.youtube.e... r11) {
            /*
                r10 = this;
                boolean r0 = r10.isCancelled()
                r1 = 0
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                r0 = 1
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a[] r2 = new com.shopee.app.util.youtube.OpenYouTubePlayerActivity.a[r0]     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a r3 = new com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r4 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r5 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0108 }
                java.lang.String r5 = r5.f26541e     // Catch:{ Exception -> 0x0108 }
                r3.<init>(r5)     // Catch:{ Exception -> 0x0108 }
                r4 = 0
                r2[r4] = r3     // Catch:{ Exception -> 0x0108 }
                r10.publishProgress(r2)     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r2 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0108 }
                java.lang.String r3 = "wifi"
                java.lang.Object r2 = r2.getSystemService(r3)     // Catch:{ Exception -> 0x0108 }
                android.net.wifi.WifiManager r2 = (android.net.wifi.WifiManager) r2     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r3 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0108 }
                java.lang.String r5 = "phone"
                java.lang.Object r3 = r3.getSystemService(r5)     // Catch:{ Exception -> 0x0108 }
                android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch:{ Exception -> 0x0108 }
                boolean r5 = r2.isWifiEnabled()     // Catch:{ Exception -> 0x0108 }
                java.lang.String r6 = "17"
                if (r5 == 0) goto L_0x0048
                android.net.wifi.WifiInfo r5 = r2.getConnectionInfo()     // Catch:{ Exception -> 0x0108 }
                if (r5 == 0) goto L_0x0048
                android.net.wifi.WifiInfo r2 = r2.getConnectionInfo()     // Catch:{ Exception -> 0x0108 }
                int r2 = r2.getIpAddress()     // Catch:{ Exception -> 0x0108 }
                if (r2 != 0) goto L_0x007c
            L_0x0048:
                int r2 = r3.getNetworkType()     // Catch:{ Exception -> 0x0108 }
                r5 = 3
                if (r2 == r5) goto L_0x0075
                int r2 = r3.getNetworkType()     // Catch:{ Exception -> 0x0108 }
                r5 = 9
                if (r2 == r5) goto L_0x0075
                int r2 = r3.getNetworkType()     // Catch:{ Exception -> 0x0108 }
                r5 = 10
                if (r2 == r5) goto L_0x0075
                int r2 = r3.getNetworkType()     // Catch:{ Exception -> 0x0108 }
                r5 = 8
                if (r2 == r5) goto L_0x0075
                int r2 = r3.getNetworkType()     // Catch:{ Exception -> 0x0108 }
                r5 = 5
                if (r2 == r5) goto L_0x0075
                int r2 = r3.getNetworkType()     // Catch:{ Exception -> 0x0108 }
                r5 = 6
                if (r2 != r5) goto L_0x007f
            L_0x0075:
                int r2 = r3.getDataState()     // Catch:{ Exception -> 0x0108 }
                r3 = 2
                if (r2 != r3) goto L_0x007f
            L_0x007c:
                java.lang.String r2 = "37"
                goto L_0x0080
            L_0x007f:
                r2 = r6
            L_0x0080:
                r3 = r11[r4]     // Catch:{ Exception -> 0x0108 }
                boolean r3 = r3 instanceof com.shopee.app.util.youtube.b     // Catch:{ Exception -> 0x0108 }
                if (r3 == 0) goto L_0x00a1
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a[] r3 = new com.shopee.app.util.youtube.OpenYouTubePlayerActivity.a[r0]     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a r5 = new com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r7 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r8 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0108 }
                java.lang.String r8 = r8.f26542f     // Catch:{ Exception -> 0x0108 }
                r5.<init>(r8)     // Catch:{ Exception -> 0x0108 }
                r3[r4] = r5     // Catch:{ Exception -> 0x0108 }
                r10.publishProgress(r3)     // Catch:{ Exception -> 0x0108 }
                r11 = r11[r4]     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.b r11 = (com.shopee.app.util.youtube.b) r11     // Catch:{ Exception -> 0x0108 }
                java.lang.String r11 = com.shopee.app.util.youtube.f.a((com.shopee.app.util.youtube.b) r11)     // Catch:{ Exception -> 0x0108 }
                goto L_0x00af
            L_0x00a1:
                r3 = r11[r4]     // Catch:{ Exception -> 0x0108 }
                boolean r3 = r3 instanceof com.shopee.app.util.youtube.c     // Catch:{ Exception -> 0x0108 }
                if (r3 == 0) goto L_0x00ae
                r11 = r11[r4]     // Catch:{ Exception -> 0x0108 }
                java.lang.String r11 = r11.a()     // Catch:{ Exception -> 0x0108 }
                goto L_0x00af
            L_0x00ae:
                r11 = r1
            L_0x00af:
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r3 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0108 }
                r3.m = r11     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a[] r3 = new com.shopee.app.util.youtube.OpenYouTubePlayerActivity.a[r0]     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a r5 = new com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r7 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0108 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r8 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0108 }
                java.lang.String r8 = r8.f26543g     // Catch:{ Exception -> 0x0108 }
                r5.<init>(r8)     // Catch:{ Exception -> 0x0108 }
                r3[r4] = r5     // Catch:{ Exception -> 0x0108 }
                r10.publishProgress(r3)     // Catch:{ Exception -> 0x0108 }
                boolean r3 = r10.isCancelled()     // Catch:{ Exception -> 0x0108 }
                if (r3 == 0) goto L_0x00cc
                return r1
            L_0x00cc:
                java.lang.String r11 = com.shopee.app.util.youtube.f.a(r2, r0, r11)     // Catch:{ Exception -> 0x0108 }
                boolean r3 = r10.isCancelled()     // Catch:{ Exception -> 0x0103 }
                if (r3 == 0) goto L_0x00d7
                return r1
            L_0x00d7:
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x0103 }
                if (r2 == 0) goto L_0x00f0
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a[] r0 = new com.shopee.app.util.youtube.OpenYouTubePlayerActivity.a[r0]     // Catch:{ Exception -> 0x0103 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a r2 = new com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a     // Catch:{ Exception -> 0x0103 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r3 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0103 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r5 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0103 }
                java.lang.String r5 = r5.h     // Catch:{ Exception -> 0x0103 }
                r2.<init>(r5)     // Catch:{ Exception -> 0x0103 }
                r0[r4] = r2     // Catch:{ Exception -> 0x0103 }
                r10.publishProgress(r0)     // Catch:{ Exception -> 0x0103 }
                goto L_0x0118
            L_0x00f0:
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a[] r0 = new com.shopee.app.util.youtube.OpenYouTubePlayerActivity.a[r0]     // Catch:{ Exception -> 0x0103 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a r2 = new com.shopee.app.util.youtube.OpenYouTubePlayerActivity$a     // Catch:{ Exception -> 0x0103 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r3 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0103 }
                com.shopee.app.util.youtube.OpenYouTubePlayerActivity r5 = com.shopee.app.util.youtube.OpenYouTubePlayerActivity.this     // Catch:{ Exception -> 0x0103 }
                java.lang.String r5 = r5.i     // Catch:{ Exception -> 0x0103 }
                r2.<init>(r5)     // Catch:{ Exception -> 0x0103 }
                r0[r4] = r2     // Catch:{ Exception -> 0x0103 }
                r10.publishProgress(r0)     // Catch:{ Exception -> 0x0103 }
                goto L_0x0118
            L_0x0103:
                r0 = move-exception
                r9 = r0
                r0 = r11
                r11 = r9
                goto L_0x010a
            L_0x0108:
                r11 = move-exception
                r0 = r1
            L_0x010a:
                java.lang.Class r2 = r10.getClass()
                java.lang.String r2 = r2.getSimpleName()
                java.lang.String r3 = "Error occurred while retrieving information from YouTube."
                android.util.Log.e(r2, r3, r11)
                r11 = r0
            L_0x0118:
                if (r11 == 0) goto L_0x011f
                android.net.Uri r11 = android.net.Uri.parse(r11)
                return r11
            L_0x011f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.util.youtube.OpenYouTubePlayerActivity.b.doInBackground(com.shopee.app.util.youtube.e[]):android.net.Uri");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Uri uri) {
            super.onPostExecute(uri);
            try {
                if (!isCancelled()) {
                    if (uri != null) {
                        com.garena.android.appkit.d.a.b(getClass().getSimpleName() + " pResult", new Object[0]);
                        OpenYouTubePlayerActivity.this.f26539c.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                OpenYouTubePlayerActivity.this.c();
                                return true;
                            }
                        });
                        OpenYouTubePlayerActivity.this.f26539c.setVideoURI(uri);
                        if (!isCancelled()) {
                            OpenYouTubePlayerActivity.this.f26539c.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    if (!b.this.isCancelled()) {
                                        OpenYouTubePlayerActivity.this.finish();
                                    }
                                }
                            });
                            if (!isCancelled()) {
                                final MediaController mediaController = new MediaController(OpenYouTubePlayerActivity.this);
                                OpenYouTubePlayerActivity.this.f26539c.setMediaController(mediaController);
                                OpenYouTubePlayerActivity.this.f26539c.setKeepScreenOn(true);
                                OpenYouTubePlayerActivity.this.f26539c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    public void onPrepared(MediaPlayer mediaPlayer) {
                                        if (!b.this.isCancelled()) {
                                            OpenYouTubePlayerActivity.this.f26537a.setVisibility(8);
                                            OpenYouTubePlayerActivity.this.f26538b.setVisibility(8);
                                            f.a().a(new Runnable() {
                                                public void run() {
                                                    mediaController.show(0);
                                                }
                                            }, 100);
                                        }
                                    }
                                });
                                if (!isCancelled()) {
                                    OpenYouTubePlayerActivity.this.f26539c.requestFocus();
                                    OpenYouTubePlayerActivity.this.f26539c.start();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new RuntimeException("Invalid NULL Url.");
                }
            } catch (Exception e2) {
                Log.e(getClass().getSimpleName(), "Error playing video!", e2);
                OpenYouTubePlayerActivity.this.c();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            super.onProgressUpdate(aVarArr);
            OpenYouTubePlayerActivity.this.a(aVarArr[0].f26544a);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.n = this.f26539c.getCurrentPosition();
        this.f26539c.pause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f26539c.seekTo(this.n);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("stopPosition", this.n);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        this.n = bundle.getInt("stopPosition");
        super.onRestoreInstanceState(bundle);
    }
}
