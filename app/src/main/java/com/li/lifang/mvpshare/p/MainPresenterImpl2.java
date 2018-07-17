package com.li.lifang.mvpshare.p;


import android.text.TextUtils;

import com.li.lifang.mvpshare.m.MainModel;
import com.li.lifang.mvpshare.m.MainModelImpl;
import com.li.lifang.mvpshare.m.MainModelImpl2;
import com.li.lifang.mvpshare.m.MainModelListener;
import com.li.lifang.mvpshare.v.MainActivity;
import com.li.lifang.mvpshare.v.MainView;

import java.lang.ref.WeakReference;

/**
 * Create on 2018/7/17 on 16:02
 * Description:
 * Coder by lilee
 */
public class MainPresenterImpl2 implements MainPresenter {

    WeakReference<MainView> viewRef;
    private final MainModel mainModel;

    public MainPresenterImpl2(MainView mainView) {
        viewRef = new WeakReference<MainView>(mainView);
        mainModel = new MainModelImpl2();
    }

    private boolean canCall() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override
    public void doLogin(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            if (canCall()) {
                viewRef.get().setLoginResultText("username or password is empty !");
            }
            return;
        }
        if (canCall()) {
            viewRef.get().showPb();
        }
        mainModel.doLogin(username, password, new MainModelListener() {
            @Override
            public void loginResult(String result) {
                if (canCall()) {
                    viewRef.get().showToast(result);
                    viewRef.get().hidePb();
                }
            }
        });
    }


}
