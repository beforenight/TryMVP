package win.night.autochange.presenter;

import android.os.Handler;

import win.night.autochange.bean.User;
import win.night.autochange.biz.IUserBiz;
import win.night.autochange.biz.OnLoginListener;
import win.night.autochange.biz.UserBiz;
import win.night.autochange.view.IUserLoginView;

/**
 * File Name UserLoginPresenter
 * Created by Administrator
 * Created date on 2017/6/21 17:42.
 */

public class UserLoginPresenter
{
    private IUserBiz mUserBiz;
    private IUserLoginView mUserLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(final IUserLoginView userLoginView)
    {
        mUserLoginView = userLoginView;
        mUserBiz = new UserBiz();
    }

    public void clear()
    {
        mUserLoginView.clearUserName();
        mUserLoginView.clearPassWord();
    }

    public void login()
    {
        mUserLoginView.showLoading();

        mUserBiz.login(mUserLoginView.getUserName(), mUserLoginView.getPassWord(), new OnLoginListener()
        {
            @Override
            public void loginFailed()
            {
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        mUserLoginView.hideLioding();
                        mUserLoginView.showFailError();
                    }
                });
            }

            @Override
            public void loginSuccess(final User user)
            {

                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        mUserLoginView.toMainActivity(user);
                        mUserLoginView.hideLioding();
                    }
                });
            }
        });
    }
}
