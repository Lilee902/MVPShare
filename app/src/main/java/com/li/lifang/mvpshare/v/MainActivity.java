package com.li.lifang.mvpshare.v;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.li.lifang.mvpshare.R;
import com.li.lifang.mvpshare.p.MainPresenter;
import com.li.lifang.mvpshare.p.MainPresenterImpl;
import com.li.lifang.mvpshare.p.MainPresenterImpl2;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_login_result)
    TextView tvLoginResult;
    @BindView(R.id.pb)
    ProgressBar pb;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setPresenter();
    }

    private void setPresenter() {
        int i = new Random().nextInt(10);
        if (i / 2 == 0) {
            mainPresenter = new MainPresenterImpl(this);
        } else {
            mainPresenter = new MainPresenterImpl2(this);
        }
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked(View v) {
        mainPresenter.doLogin(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setLoginResultText(String result) {
        tvLoginResult.setText(result);
    }

    @Override
    public void showPb() {
        if (pb.getVisibility() != View.VISIBLE) {
            pb.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hidePb() {
        if (pb.getVisibility() != View.GONE) {
            pb.setVisibility(View.GONE);
        }
    }
}
