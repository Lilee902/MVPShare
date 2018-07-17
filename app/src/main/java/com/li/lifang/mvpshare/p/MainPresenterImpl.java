package com.li.lifang.mvpshare.p;

import android.text.TextUtils;

import com.li.lifang.mvpshare.m.MainModel;
import com.li.lifang.mvpshare.m.MainModelImpl;
import com.li.lifang.mvpshare.m.MainModelListener;
import com.li.lifang.mvpshare.v.MainView;

import java.lang.ref.WeakReference;

/**
 * Create on 2018/7/17 on 15:11
 * Description:
 * Coder by lilee
 */
public class MainPresenterImpl implements MainPresenter,MainModelListener{

    WeakReference<MainView> viewRef;
    private final MainModel mainModel;

    public MainPresenterImpl(MainView mainView) {
        viewRef = new WeakReference<MainView>(mainView);
        mainModel = new MainModelImpl(this);
    }

    private boolean canCall(){
        return viewRef != null && viewRef.get()!= null;
    }

    public void doLogin(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            if (canCall()){
                viewRef.get().showToast("username or password is empty !");
            }
            return;
        }
        if (canCall()){viewRef.get().showPb();}
        mainModel.doLogin(username,password);
    }

    @Override
    public void loginResult(String result) {
        if (canCall()){
            viewRef.get().setLoginResultText(result);
            viewRef.get().hidePb();
        }
    }
}
