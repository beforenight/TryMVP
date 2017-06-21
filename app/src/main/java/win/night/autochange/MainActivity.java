package win.night.autochange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import win.night.autochange.bean.User;
import win.night.autochange.presenter.UserLoginPresenter;
import win.night.autochange.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView
{
    private static final String TAG = "MainActivity";
    private EditText txvUsername;
    private EditText txvPassword;

    private Button btnLogin;
    private Button btnClear;


    private UserLoginPresenter mLoginPresenter = new UserLoginPresenter(this);

    @Override
    public void clearPassWord()
    {
        txvPassword.setText(null);
    }

    @Override
    public void clearUserName()
    {
        txvUsername.setText(null);
    }


    @Override
    public String getPassWord()
    {
        final String password = txvPassword.getText().toString();
        if (TextUtils.isEmpty(password))
            return "";
        else
            return password;
    }

    @Override
    public String getUserName()
    {
        final String username = txvUsername.getText().toString();
        if (TextUtils.isEmpty(username))
            return "";
        else
            return username;
    }

    @Override
    public void hideLioding()
    {
        Log.d(TAG, "hideLioding: ");
    }

    private void initView()
    {
        txvUsername = (EditText) findViewById(R.id.txvUsername);
        txvPassword = (EditText) findViewById(R.id.txvPassword);


        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnClear = (Button) findViewById(R.id.btnClear);


        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                mLoginPresenter.login();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                mLoginPresenter.clear();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    public void showFailError()
    {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading()
    {
        Log.d(TAG, "showLoading: ");
    }

    @Override
    public void toMainActivity(final User user)
    {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "toMainActivity: ");
    }
}
