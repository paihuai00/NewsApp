package com.csx.newsapp.bmob;

/**
 * Created by cuishuxiang on 2017/7/12.
 * <p>
 * bmob
 */

public class User {
    private String account;
    private String passward;
    private String user_name;
    private boolean isLogin;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
