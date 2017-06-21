package win.night.autochange.biz;

import win.night.autochange.bean.User;

/**
 * File Name OnLoginListener
 * Created by Administrator
 * Created date on 2017/6/21 17:33.
 */

public interface OnLoginListener
{
    void loginSuccess(User user);

    void loginFailed();
}
