package com.shopee.livequiz.data.b;

import android.content.SharedPreferences;
import com.shopee.livequiz.data.bean.GameModel;
import com.shopee.sdk.e.a.d;
import com.shopee.sdk.e.b;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private d<GameModel> f29827a;

    public a(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f29827a = new d<>(sharedPreferences, "game_model", com.shopee.sdk.f.a.f30358b, GameModel.class);
    }

    public GameModel a() {
        return this.f29827a.c();
    }

    public void a(GameModel gameModel) {
        this.f29827a.b(gameModel);
    }
}
