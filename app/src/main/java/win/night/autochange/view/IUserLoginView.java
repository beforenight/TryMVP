package win.night.autochange.view;

import win.night.autochange.bean.User;

/**
 * File Name IUserLoginView
 * Created by Administrator
 * Created date on 2017/6/21 17:31.
 */

public interface IUserLoginView
{
    String getPassWord();

    String getUserName();

    void hideLioding();

    void showLoading();

    void toMainActivity(User user);

    void showFailError();

    void clearUserName();

    void clearPassWord();
}
