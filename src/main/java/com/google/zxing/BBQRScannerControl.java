package com.google.zxing;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.google.zxing.a.a;
import com.google.zxing.b.c;
import com.google.zxing.f.o;
import com.google.zxing.f.p;
import com.google.zxing.s;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class BBQRScannerControl extends FrameLayout implements SurfaceHolder.Callback {
    public static final int CODE_TYPE_BARCODE = 1;
    public static final int CODE_TYPE_QR = 0;
    public static final int MODE_BITMAP = 1;
    public static final int MODE_CAMERA = 0;
    public c cameraManager;
    public f handler;
    private boolean hasSurface = false;
    private boolean isOnShow = false;
    private int mBorderBottomLeft = -1;
    private int mBorderBottomRight = -1;
    private int mBorderTopLeft = -1;
    private int mBorderTopRight = -1;
    private int mCodeType = 0;
    private int mFramingRectMarginBottom = -1;
    private int mOrientation = 0;
    private int mViewFinderHardHeight = -1;
    private int mViewFinderHardWidth = -1;
    private ScheduledExecutorService m_executor = Executors.newSingleThreadScheduledExecutor();
    private w savedResultToShow;
    private a scannerListener;
    private b scannerProvider;
    public SurfaceView surfaceView;
    public ViewfinderView viewfinderView;

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public BBQRScannerControl(Context context) {
        super(context);
        initView(context);
    }

    public BBQRScannerControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet);
    }

    public BBQRScannerControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.e.BBQRScannerControl);
        this.mBorderTopLeft = obtainStyledAttributes.getResourceId(s.e.BBQRScannerControl_border_img_top_left, -1);
        this.mBorderTopRight = obtainStyledAttributes.getResourceId(s.e.BBQRScannerControl_border_img_top_right, -1);
        this.mBorderBottomLeft = obtainStyledAttributes.getResourceId(s.e.BBQRScannerControl_border_img_bottom_left, -1);
        this.mBorderBottomRight = obtainStyledAttributes.getResourceId(s.e.BBQRScannerControl_border_img_bottom_right, -1);
        this.mViewFinderHardWidth = obtainStyledAttributes.getDimensionPixelSize(s.e.BBQRScannerControl_view_finder_hard_width, -1);
        this.mViewFinderHardHeight = obtainStyledAttributes.getDimensionPixelOffset(s.e.BBQRScannerControl_view_finder_hard_height, -1);
        this.mFramingRectMarginBottom = obtainStyledAttributes.getDimensionPixelSize(s.e.BBQRScannerControl_framing_rect_margin_bottom, -1);
        obtainStyledAttributes.recycle();
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, s.c.capture, this);
        this.viewfinderView = (ViewfinderView) findViewById(s.b.viewfinder_view);
        this.viewfinderView.a(this.mBorderTopLeft, this.mBorderTopRight, this.mBorderBottomLeft, this.mBorderBottomRight);
        this.surfaceView = (SurfaceView) findViewById(s.b.preview_view);
        SurfaceHolder holder = this.surfaceView.getHolder();
        holder.addCallback(this);
        if (Build.VERSION.SDK_INT <= 10) {
            holder.setType(3);
        }
    }

    public void setBorderDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.viewfinderView = (ViewfinderView) findViewById(s.b.viewfinder_view);
        this.viewfinderView.a(drawable, drawable2, drawable3, drawable4);
    }

    public void setScannerAnimation(a aVar) {
        this.viewfinderView.setScannerAnimation(aVar);
    }

    public void initCamera(final SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        } else if (!this.cameraManager.a()) {
            this.m_executor.execute(new Runnable() {
                public void run() {
                    try {
                        BBQRScannerControl.this.cameraManager.a(surfaceHolder, (c.a) new c.a() {
                            public void a(Point point, Point point2) {
                                BBQRScannerControl.this.updateSurfaceViewSize(point, point2);
                                if (BBQRScannerControl.this.handler == null) {
                                    BBQRScannerControl.this.handler = new f(BBQRScannerControl.this, (Collection<c>) null, (Map<j, ?>) null, (String) null, BBQRScannerControl.this.cameraManager);
                                }
                                BBQRScannerControl.this.decodeOrStoreSavedBitmap((Bitmap) null, (w) null);
                            }
                        });
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void updateSurfaceViewSize(Point point, Point point2) {
        int i;
        int i2;
        int i3 = point.y > point.x ? point.y : point.x;
        int i4 = point.y > point.x ? point.x : point.y;
        int i5 = this.mOrientation;
        if (i5 == 0 || i5 == 2) {
            i = (point2.x * i3) / i4;
            i2 = (point2.y * i4) / i3;
        } else {
            i2 = (point2.y * i3) / i4;
            i = (point2.x * i4) / i3;
        }
        if (i > point2.y) {
            i2 = point2.x;
        } else {
            i = point2.y;
        }
        this.surfaceView.setLayoutParams(new FrameLayout.LayoutParams(i2, i));
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
        c cVar = this.cameraManager;
        if (cVar != null) {
            cVar.a(this.mOrientation);
        }
        ViewfinderView viewfinderView2 = this.viewfinderView;
        if (viewfinderView2 != null) {
            viewfinderView2.setOrientation(this.mOrientation);
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setCodeType(int i) {
        this.mCodeType = i;
        c cVar = this.cameraManager;
        if (cVar != null) {
            cVar.b(this.mCodeType);
        }
        ViewfinderView viewfinderView2 = this.viewfinderView;
        if (viewfinderView2 != null) {
            viewfinderView2.setCodeType(this.mCodeType);
        }
    }

    public int getCodeType() {
        return this.mCodeType;
    }

    public void onShow(int i) {
        if (this.cameraManager == null) {
            this.cameraManager = new c(((Activity) getContext()).getApplication(), this.mOrientation, this.mCodeType);
            this.cameraManager.b(this.mViewFinderHardWidth, this.mViewFinderHardHeight);
            this.cameraManager.c(this.mFramingRectMarginBottom);
        }
        this.viewfinderView.setCameraManager(this.cameraManager);
        this.viewfinderView.setVisibility(0);
        this.viewfinderView.setOrientation(this.mOrientation);
        this.viewfinderView.setCodeType(this.mCodeType);
        this.handler = null;
        this.isOnShow = true;
        openCameraIfReady(this.surfaceView.getHolder());
        if (i == 1) {
            b bVar = this.scannerProvider;
            if (bVar != null) {
                this.cameraManager.a(bVar.a());
            } else {
                return;
            }
        }
        this.cameraManager.d(i);
    }

    private void openCameraIfReady(SurfaceHolder surfaceHolder) {
        if (this.isOnShow && this.hasSurface) {
            initCamera(surfaceHolder);
        }
    }

    public void onHide() {
        this.isOnShow = false;
        f fVar = this.handler;
        if (fVar != null) {
            fVar.b();
            this.handler = null;
        }
        c cVar = this.cameraManager;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void onDestroy() {
        this.surfaceView.getHolder().removeCallback(this);
    }

    public void scanAnother() {
        f fVar = this.handler;
        if (fVar != null) {
            fVar.a();
            getCameraManager().d(0);
            this.handler.sendMessage(Message.obtain(this.handler, 0));
        }
    }

    public void setScannerListener(a aVar) {
        this.scannerListener = aVar;
    }

    /* access modifiers changed from: private */
    public void decodeOrStoreSavedBitmap(Bitmap bitmap, w wVar) {
        if (this.handler == null) {
            this.savedResultToShow = wVar;
            return;
        }
        if (wVar != null) {
            this.savedResultToShow = wVar;
        }
        w wVar2 = this.savedResultToShow;
        if (wVar2 != null) {
            this.handler.sendMessage(Message.obtain(this.handler, 1, wVar2));
        }
        this.savedResultToShow = null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            this.cameraManager.a(true);
            return true;
        } else if (i == 25) {
            this.cameraManager.a(false);
            return true;
        } else if (i == 27 || i == 80) {
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public void handleDecode(w wVar, Bitmap bitmap, float f2) {
        o a2 = p.a(wVar);
        if (bitmap != null) {
            drawResultPoints(bitmap, f2, wVar);
        }
        handleDecodeInternally(wVar, a2, bitmap);
    }

    private void drawResultPoints(Bitmap bitmap, float f2, w wVar) {
        y[] c2 = wVar.c();
        if (c2 != null && c2.length > 0) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(s.a.result_points));
            if (c2.length == 2) {
                paint.setStrokeWidth(4.0f);
                drawLine(canvas, paint, c2[0], c2[1], f2);
            } else if (c2.length == 4 && (wVar.d() == c.UPC_A || wVar.d() == c.EAN_13)) {
                drawLine(canvas, paint, c2[0], c2[1], f2);
                drawLine(canvas, paint, c2[2], c2[3], f2);
            } else {
                paint.setStrokeWidth(10.0f);
                for (y yVar : c2) {
                    if (yVar != null) {
                        canvas.drawPoint(yVar.a() * f2, yVar.b() * f2, paint);
                    }
                }
            }
        }
    }

    private static void drawLine(Canvas canvas, Paint paint, y yVar, y yVar2, float f2) {
        if (yVar != null && yVar2 != null) {
            canvas.drawLine(f2 * yVar.a(), f2 * yVar.b(), f2 * yVar2.a(), f2 * yVar2.b(), paint);
        }
    }

    private void handleDecodeInternally(w wVar, o oVar, Bitmap bitmap) {
        CharSequence a2 = oVar.a();
        a aVar = this.scannerListener;
        if (aVar != null) {
            aVar.a(wVar, a2.toString());
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.hasSurface) {
            this.hasSurface = true;
            openCameraIfReady(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.hasSurface = false;
    }

    public ViewfinderView getViewfinderView() {
        return this.viewfinderView;
    }

    public c getCameraManager() {
        return this.cameraManager;
    }

    public void drawViewfinder() {
        this.viewfinderView.a();
    }

    public Handler getDecodeHandler() {
        return this.handler;
    }

    public void setScannerProvider(b bVar) {
        this.scannerProvider = bVar;
    }

    public void setTorch(boolean z) {
        c cVar = this.cameraManager;
        if (cVar != null) {
            cVar.a(z);
        }
    }
}
