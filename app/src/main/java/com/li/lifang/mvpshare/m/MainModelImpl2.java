package com.li.lifang.mvpshare.m;

import android.os.Handler;
import android.os.Looper;

/**
 * Create on 2018/7/17 on 16:03
 * Description:
 * Coder by lilee
 */
public class MainModelImpl2 implements MainModel{

    public MainModelImpl2() {

    }

    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void doLogin(String username, String password) {

    }

    @Override
    public void doLogin(final String username, final String password,final MainModelListener listener) {
        if (listener == null) {
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if ("username".equals(username) && "password".equals(password)) {
                            listener.loginResult("登录成功了，service 2");
                        } else {
                            listener.loginResult("账号或者密码错误，请重新输入。");
                        }
                    }
                },1000);

            }
        }).start();
    }
}
