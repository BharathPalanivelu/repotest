package com.shopee.livequiz.f;

import com.shopee.livequiz.b;
import com.shopee.livequiz.c.c;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.data.bean.GameModel;

public class a extends com.shopee.livequiz.c.a<Void, C0457a> {

    /* renamed from: com.shopee.livequiz.f.a$a  reason: collision with other inner class name */
    public interface C0457a {
        void a(GameModel gameModel);
    }

    public a(c cVar) {
        super(cVar);
    }

    /* access modifiers changed from: protected */
    public void a(Void voidR, final C0457a aVar) {
        final GameModel a2 = b.a().a().a();
        a(new e() {
            public void a() {
                GameModel gameModel = a2;
                if (gameModel != null) {
                    C0457a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(gameModel);
                    }
                }
            }
        });
    }
}
