package com.shopee.app.network.c;

import com.facebook.imageutils.JfifUtil;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.bh;
import com.shopee.app.h.j;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ac;
import com.shopee.app.network.d.au;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.FeedComment;
import com.shopee.protocol.action.ResponseFeedComment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class af extends c {
    public int a() {
        return JfifUtil.MARKER_SOFn;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseFeedComment responseFeedComment = (ResponseFeedComment) f.f18486a.parseFrom(bArr, 0, i, ResponseFeedComment.class);
        c(responseFeedComment.requestid);
        c().a(responseFeedComment);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetFeedsProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17790a;

        /* renamed from: b  reason: collision with root package name */
        private bh f17791b;

        public a(n nVar, bh bhVar) {
            this.f17790a = nVar;
            this.f17791b = bhVar;
        }

        public void a(ResponseFeedComment responseFeedComment) {
            if (b(responseFeedComment)) {
                ac acVar = (ac) o.a().f(responseFeedComment.requestid);
                if (acVar != null && acVar.b()) {
                    j.a().b(acVar.c());
                    if (!com.shopee.app.util.af.a(responseFeedComment.cmt)) {
                        j.a().a(Long.valueOf(acVar.c()), responseFeedComment.cmt);
                    }
                } else if (!com.shopee.app.util.af.a(responseFeedComment.cmt)) {
                    j.a().b(responseFeedComment.cmt.get(0).feedid, responseFeedComment.cmt);
                }
                if (!com.shopee.app.util.af.a(responseFeedComment.cmt)) {
                    ArrayList arrayList = new ArrayList();
                    for (FeedComment next : responseFeedComment.cmt) {
                        if (this.f17791b.a(next.userid.intValue()) == null) {
                            arrayList.add(next.userid);
                        }
                    }
                    if (arrayList.size() > 0) {
                        new au().a((List<Integer>) arrayList);
                    }
                }
                this.f17790a.a().Y.a();
            }
        }

        private boolean b(ResponseFeedComment responseFeedComment) {
            if (responseFeedComment.errcode.intValue() == 0) {
                return true;
            }
            this.f17790a.a("FEED_COMMENT_ERROR", new com.garena.android.appkit.b.a(responseFeedComment.errcode));
            return false;
        }

        public void a() {
            this.f17790a.a("FEED_COMMENT_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
