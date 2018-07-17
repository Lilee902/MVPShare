package com.li.lifang.mvpshare.m;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

import com.li.lifang.mvpshare.p.MainPresenterImpl;

import java.lang.ref.WeakReference;

/**
 * Create on 2018/7/17 on 15:11
 * Description:
 * Coder by lilee
 */
public class MainModelImpl implements MainModel {
    private MainModelListener modelListener;

    public MainModelImpl(MainModelListener modelListener) {
        this.modelListener = modelListener;
    }

    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void doLogin(final String username, final String password) {
        if (modelListener == null) {
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if ("username".equals(username) && "password".equals(password)) {
                            modelListener.loginResult("登录成功");
                        } else {
                            modelListener.loginResult("账号或者密码错误");
                        }
                    }
                },2000);

            }
        }).start();
    }

    @Override
    public void doLogin(String username, String password, MainModelListener modelListener) {

    }
}
