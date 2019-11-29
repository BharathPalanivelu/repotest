package com.shopee.feeds.feedlibrary.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.shopee.feeds.feedlibrary.adapter.a;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.FinishPdListEntity;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.view.SearchLoadingView;
import com.shopee.feeds.feedlibrary.view.a.e;
import com.shopee.feeds.feedlibrary.view.edittext.CustomSearchEditText;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public abstract class BaseSearchActivity<T> extends a implements e {

    /* renamed from: c  reason: collision with root package name */
    com.shopee.feeds.feedlibrary.b.e f7063c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<T> f7064d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<T> f7065e = new ArrayList<>();
    @BindView
    CustomSearchEditText etSearch;

    /* renamed from: f  reason: collision with root package name */
    private a f7066f;
    @BindView
    ImageView ivSearchCancel;
    @BindView
    SearchLoadingView mSearchLoadingView;
    @BindView
    RecyclerView recyclerView;
    @BindView
    View searchEtBg;
    @BindView
    TextView tvCancel;
    @BindView
    TextView tvNoResult;

    public abstract void a(Object obj);

    public abstract void c(String str);

    public abstract String i();

    public abstract a j();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        c();
        super.onCreate(bundle);
        setContentView(c.f.feeds_activity_pd_search);
        ButterKnife.a((Activity) this);
        org.greenrobot.eventbus.c.a().c(this);
        this.f7063c = new com.shopee.feeds.feedlibrary.b.e(this.f7086a);
        this.f7063c.a(this);
    }

    public void h() {
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.f7086a));
        this.f7066f = j();
        this.recyclerView.setAdapter(this.f7066f);
        this.etSearch.setSearchType(17);
        this.etSearch.setHint(i());
        this.etSearch.a((List<?>) this.f7065e, this.f7066f);
        this.etSearch.setOnSearchListener(new CustomSearchEditText.a() {
            public void a(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void b(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void a(Editable editable) {
                if (BaseSearchActivity.this.etSearch.getCurKeywords().length() > 0) {
                    BaseSearchActivity.this.ivSearchCancel.setVisibility(0);
                    return;
                }
                BaseSearchActivity.this.ivSearchCancel.setVisibility(8);
                BaseSearchActivity.this.recyclerView.setVisibility(8);
                BaseSearchActivity.this.mSearchLoadingView.setVisibility(8);
                BaseSearchActivity.this.tvNoResult.setVisibility(8);
            }

            public void a(String str, int i) {
                BaseSearchActivity.this.d(str);
            }
        });
        this.etSearch.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                d.a(BaseSearchActivity.this.etSearch.getCurKeywords());
                return false;
            }
        });
        this.etSearch.setImeOptions(3);
        this.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i != 3 && i != 0) || d.a(BaseSearchActivity.this.etSearch.getCurKeywords())) {
                    return true;
                }
                BaseSearchActivity.this.etSearch.setSelection(BaseSearchActivity.this.etSearch.getCurKeywords().length());
                BaseSearchActivity baseSearchActivity = BaseSearchActivity.this;
                baseSearchActivity.d(baseSearchActivity.etSearch.getCurKeywords());
                return true;
            }
        });
        d.a(this, this.recyclerView, this.etSearch);
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        this.mSearchLoadingView.setVisibility(0);
        this.mSearchLoadingView.b();
        this.recyclerView.setVisibility(8);
        this.tvNoResult.setVisibility(8);
        c(str);
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.iv_search_cancel) {
            this.etSearch.setText("");
            ArrayList<T> arrayList = this.f7064d;
            if (arrayList != null && arrayList.size() > 0) {
                this.f7064d.clear();
                this.f7066f.a(this.f7064d);
            }
        } else if (id == c.e.tv_cancel) {
            finish();
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(FinishPdListEntity finishPdListEntity) {
        boolean z = finishPdListEntity instanceof FinishPdListEntity;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().b(this);
    }

    public void a(Object obj, String str) {
        this.mSearchLoadingView.a();
        this.mSearchLoadingView.setVisibility(8);
        a(obj);
    }

    public void b(String str) {
        this.mSearchLoadingView.a();
        this.mSearchLoadingView.setVisibility(8);
    }
}
