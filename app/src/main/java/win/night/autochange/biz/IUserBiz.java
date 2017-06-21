package win.night.autochange.biz;

/**
 * File Name IUserBiz
 * Created by Administrator
 * Created date on 2017/6/21 17:32.
 */

public interface IUserBiz
{
    void login(String username, String password, OnLoginListener loginListener);
}
