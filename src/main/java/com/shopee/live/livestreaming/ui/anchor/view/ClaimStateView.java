package com.shopee.live.livestreaming.ui.anchor.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.data.entity.require.VoucherCodeEntity;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.ClaimVoucherTask;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.y;
import com.shopee.live.livestreaming.util.z;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class ClaimStateView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    RobotoTextView f7138a;

    /* renamed from: b  reason: collision with root package name */
    RobotoTextView f7139b;

    /* renamed from: c  reason: collision with root package name */
    ProgressBar f7140c;

    /* renamed from: d  reason: collision with root package name */
    LinearLayout f7141d;

    /* renamed from: e  reason: collision with root package name */
    ClaimVoucherTask f7142e;

    /* renamed from: f  reason: collision with root package name */
    VoucherEntity f7143f;

    /* renamed from: g  reason: collision with root package name */
    b f7144g;
    a h;
    private ArrayList<VoucherEntity> i;
    private ArrayList<VoucherEntity> j;
    private View k;
    /* access modifiers changed from: private */
    public int l;
    private int m;
    /* access modifiers changed from: private */
    public long n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public int p;

    public interface a {
        void a();

        void a(int i, String str);

        void b();

        void c();
    }

    static /* synthetic */ int c(ClaimStateView claimStateView) {
        int i2 = claimStateView.p;
        claimStateView.p = i2 + 1;
        return i2;
    }

    public ClaimStateView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ClaimStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClaimStateView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.m = 30;
        j();
    }

    public void onClick(View view) {
        b();
    }

    class b extends Handler {
        b() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                ClaimStateView.this.k();
            } else if (i != 2) {
                if (i != 3) {
                    if (i == 4 && ClaimStateView.this.h != null) {
                        ClaimStateView.this.h.a();
                    }
                } else if (ClaimStateView.this.h != null) {
                    ClaimStateView.this.h.b();
                }
            } else if (ClaimStateView.this.p < 5) {
                ClaimStateView.c(ClaimStateView.this);
                sendEmptyMessageDelayed(2, 1000);
            } else if (ClaimStateView.this.l == 19) {
                z.a(ClaimStateView.this.getContext(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_tips_for_many_claiming));
                ClaimStateView.this.e();
                sendEmptyMessageDelayed(3, 1000);
            }
        }
    }

    private void j() {
        this.k = LayoutInflater.from(getContext()).inflate(c.f.live_streaming_layout_claim_state, this, true);
        this.f7138a = (RobotoTextView) this.k.findViewById(c.e.tv_claim_title);
        this.f7139b = (RobotoTextView) this.k.findViewById(c.e.tv_time);
        this.f7140c = (ProgressBar) this.k.findViewById(c.e.loading_progress);
        this.f7141d = (LinearLayout) this.k.findViewById(c.e.ll_claim_txt);
        this.f7138a.setOnClickListener(this);
        org.greenrobot.eventbus.c.a().a((Object) this);
        this.f7142e = InjectorUtils.provideClaimVoucherTask();
        this.f7144g = new b();
    }

    public void a() {
        this.f7143f = null;
        this.m = 0;
        this.p = 0;
        this.o = 0;
    }

    public void setmVoucherEntity(VoucherEntity voucherEntity) {
        this.f7143f = voucherEntity;
        c(voucherEntity);
    }

    public void b() {
        VoucherEntity voucherEntity = this.f7143f;
        if (voucherEntity != null) {
            com.shopee.live.livestreaming.ui.audience.c.b(this.f7143f.getPromotion_id(), this.f7143f.getVoucher_code(), voucherEntity.getShop_id() == 0 ? 0 : 1);
        }
        y.a((Activity) getContext(), new y.a() {
            public void a() {
                if (ClaimStateView.this.l == 17 && ClaimStateView.this.h != null) {
                    ClaimStateView.this.d();
                    ClaimStateView claimStateView = ClaimStateView.this;
                    claimStateView.a(claimStateView.f7143f);
                    ClaimStateView.this.l();
                    ClaimStateView.this.f7144g.sendEmptyMessageDelayed(2, 1000);
                }
            }

            public void b() {
                if (ClaimStateView.this.f7143f != null) {
                    com.shopee.live.livestreaming.ui.audience.c.a(ClaimStateView.this.f7143f.getPromotion_id(), ClaimStateView.this.f7143f.getVoucher_code(), ClaimStateView.this.f7143f.getShop_id() == 0 ? 0 : 1, 3);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void k() {
        int i2 = this.l;
        if (i2 == 357 || i2 == 17) {
            int i3 = this.m;
            if (i3 <= 0 || i3 > this.o) {
                if (this.l == 357) {
                    f.a().b(false);
                }
                if (this.f7142e != null) {
                    this.h.c();
                    return;
                }
                return;
            }
            this.m = i3 - 1;
            RobotoTextView robotoTextView = this.f7139b;
            robotoTextView.setText(this.m + "s");
            a aVar = this.h;
            if (aVar != null) {
                aVar.a(this.m, this.f7139b.getText().toString());
            }
            this.f7144g.removeMessages(1);
            this.f7144g.sendEmptyMessageDelayed(1, 1000);
        }
    }

    public void setAudienceUnClaimState(int i2) {
        this.l = 17;
        this.f7141d.setVisibility(0);
        this.f7138a.setVisibility(0);
        this.f7139b.setVisibility(0);
        this.f7140c.setVisibility(8);
        this.f7138a.setBackground(getContext().getResources().getDrawable(c.d.live_streaming_bg_claim_normal));
        this.f7138a.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_claim));
        this.f7138a.setTextColor(getContext().getResources().getColor(c.b.white));
        this.f7138a.setTextSize(2, 11.0f);
        this.f7138a.setEnabled(true);
        this.m = i2;
        RobotoTextView robotoTextView = this.f7139b;
        robotoTextView.setText(this.m + "s");
        b bVar = this.f7144g;
        if (bVar != null && this.m > 0) {
            bVar.removeMessages(1);
            this.f7144g.sendEmptyMessageDelayed(1, 1000);
        }
    }

    public void c() {
        this.l = 18;
        this.f7141d.setVisibility(0);
        this.f7138a.setVisibility(0);
        this.f7139b.setVisibility(8);
        this.f7140c.setVisibility(8);
        this.f7138a.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_claimed));
        this.f7138a.setTextColor(getContext().getResources().getColor(c.b.main_color));
        this.f7138a.setBackground((Drawable) null);
        this.f7138a.setBackgroundColor(getContext().getResources().getColor(c.b.white));
        this.f7138a.setTextSize(2, 12.0f);
        this.f7138a.setEnabled(false);
    }

    public void d() {
        this.l = 19;
        this.f7141d.setVisibility(8);
        this.f7138a.setVisibility(8);
        this.f7139b.setVisibility(8);
        this.f7140c.setVisibility(0);
    }

    public void e() {
        this.l = 20;
        this.f7141d.setVisibility(0);
        this.f7138a.setVisibility(0);
        this.f7139b.setVisibility(8);
        this.f7140c.setVisibility(8);
        this.f7138a.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_claim));
        this.f7138a.setBackground(getContext().getResources().getDrawable(c.d.live_streaming_bg_voucher_unclaim));
        this.f7138a.setTextColor(getContext().getResources().getColor(c.b.white));
        this.f7138a.setTextSize(2, 11.0f);
    }

    public void f() {
        b bVar = this.f7144g;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages((Object) null);
        }
        org.greenrobot.eventbus.c.a().b(this);
    }

    public void g() {
        this.l = 357;
        this.f7138a.setVisibility(8);
        this.f7139b.setVisibility(0);
        this.f7140c.setVisibility(8);
        this.o = f.a().m();
        this.m = this.o;
        RobotoTextView robotoTextView = this.f7139b;
        robotoTextView.setText(this.m + "s");
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(this.m, this.f7139b.getText().toString());
        }
        if (this.f7144g != null) {
            f.a().b(true);
            this.f7144g.removeMessages(1);
            this.f7144g.sendEmptyMessageDelayed(1, 1000);
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        VoucherEntity voucherEntity = this.f7143f;
        if (voucherEntity != null) {
            this.f7142e.execute(new ClaimVoucherTask.Data(voucherEntity), new ClaimVoucherTask.Callback() {
                public void claimSuccess() {
                }

                public void onError(int i, String str) {
                    if (i == 10020) {
                        ClaimStateView.this.e();
                        z.a(ClaimStateView.this.getContext(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_voucher_misschance));
                        if (ClaimStateView.this.f7144g != null) {
                            ClaimStateView.this.f7144g.sendEmptyMessageDelayed(3, 1000);
                        }
                    } else if (ClaimStateView.this.n > 0) {
                        int currentTimeMillis = (int) ((System.currentTimeMillis() - ClaimStateView.this.n) / 1000);
                        if (currentTimeMillis <= 0 || currentTimeMillis > ClaimStateView.this.o) {
                            ClaimStateView.this.e();
                        } else {
                            ClaimStateView.this.setAudienceUnClaimState(currentTimeMillis);
                        }
                    } else {
                        ClaimStateView.this.e();
                    }
                }
            });
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onClaimResult(VoucherCodeEntity voucherCodeEntity) {
        if (this.l == 19) {
            if (voucherCodeEntity.getErr_code() == 0) {
                m();
            } else {
                e();
                if (!voucherCodeEntity.handleVoucherCodeTips()) {
                    z.a(getContext(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_msg_voucher_wallet_unknow_error));
                }
                this.f7144g.sendEmptyMessageDelayed(3, 1000);
            }
        } else if (voucherCodeEntity.getErr_code() == 0) {
            z.a(getContext(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_claimed_tips));
        } else if (!voucherCodeEntity.handleVoucherCodeTips()) {
            z.a(getContext(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_msg_voucher_wallet_unknow_error));
        }
        a(voucherCodeEntity);
    }

    private void a(VoucherCodeEntity voucherCodeEntity) {
        VoucherEntity a2 = a(voucherCodeEntity.getPromotion_id(), voucherCodeEntity.getVoucher_code());
        if (a2 != null) {
            int i2 = a2.getShop_id() == 0 ? 0 : 1;
            int err_code = voucherCodeEntity.getErr_code();
            if (err_code != -1) {
                if (err_code == 0) {
                    com.shopee.live.livestreaming.ui.audience.c.a(a2.getPromotion_id(), a2.getVoucher_code(), i2, 0);
                    return;
                } else if (!(err_code == 4 || err_code == 5)) {
                    if (err_code != 14) {
                        com.shopee.live.livestreaming.ui.audience.c.a(a2.getPromotion_id(), a2.getVoucher_code(), i2, 4);
                        return;
                    }
                    switch (voucherCodeEntity.getInvalid_message_code()) {
                        case 1:
                        case 2:
                        case 3:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 16:
                        case 18:
                            com.shopee.live.livestreaming.ui.audience.c.a(a2.getPromotion_id(), a2.getVoucher_code(), i2, 1);
                            return;
                        case 4:
                            com.shopee.live.livestreaming.ui.audience.c.a(a2.getPromotion_id(), a2.getVoucher_code(), i2, 2);
                            return;
                        default:
                            com.shopee.live.livestreaming.ui.audience.c.a(a2.getPromotion_id(), a2.getVoucher_code(), i2, 4);
                            return;
                    }
                }
            }
            com.shopee.live.livestreaming.ui.audience.c.a(a2.getPromotion_id(), a2.getVoucher_code(), i2, 1);
        }
    }

    private void m() {
        z.a(getContext(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_claimed_tips));
        c();
        this.f7144g.sendEmptyMessageDelayed(4, 1000);
    }

    public void setmCreateTime(long j2) {
        this.n = j2;
    }

    public void h() {
        this.o = f.a().m();
    }

    public void setClaimCallback(a aVar) {
        this.h = aVar;
    }

    public void a(VoucherEntity voucherEntity) {
        if (voucherEntity != null && !b(voucherEntity)) {
            this.i.add(voucherEntity);
        }
    }

    public boolean b(VoucherEntity voucherEntity) {
        if (voucherEntity == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            VoucherEntity voucherEntity2 = this.i.get(i2);
            if (voucherEntity2.getPromotion_id() == voucherEntity.getPromotion_id() && voucherEntity2.getVoucher_code().equals(voucherEntity.getVoucher_code())) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        ArrayList<VoucherEntity> arrayList = this.i;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    private void c(VoucherEntity voucherEntity) {
        if (voucherEntity != null) {
            ArrayList<VoucherEntity> arrayList = this.j;
            if (arrayList != null && !arrayList.contains(voucherEntity)) {
                this.j.add(voucherEntity);
            }
        }
    }

    public VoucherEntity a(long j2, String str) {
        VoucherEntity voucherEntity = null;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            VoucherEntity voucherEntity2 = this.j.get(i2);
            if (voucherEntity2.getPromotion_id() == j2 && voucherEntity2.getVoucher_code().equals(str)) {
                voucherEntity = voucherEntity2;
            }
        }
        return voucherEntity;
    }
}
