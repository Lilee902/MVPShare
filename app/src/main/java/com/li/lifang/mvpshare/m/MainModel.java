package com.li.lifang.mvpshare.m;

/**
 * Create on 2018/7/17 on 15:29
 * Description:
 * Coder by lilee
 */
public interface MainModel {
    void doLogin(String username, String password);
    void doLogin(String username, String password,MainModelListener modelListener);
}
