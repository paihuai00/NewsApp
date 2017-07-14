package com.csx.newsapp.ui.login;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.csx.newsapp.R;
import com.fifedu.rxfiflibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by cuishuxiang on 2017/7/12.
 * 登录 activity
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.user_account)
    EditText userAccount;
    @BindView(R.id.account_layout)
    TextInputLayout accountLayout;
    @BindView(R.id.user_pwd)
    EditText userPwd;
    @BindView(R.id.pwd_layout)
    TextInputLayout pwdLayout;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_layout;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void initView() {
        accountLayout.setHint("请输入账号");
        pwdLayout.setHint("请输入密码");
    }

    @OnClick({R.id.register, R.id.login_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                break;
            case R.id.login_btn:
                break;
        }
    }
}
