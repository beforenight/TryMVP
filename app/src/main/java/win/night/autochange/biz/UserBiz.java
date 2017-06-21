package win.night.autochange.biz;

import win.night.autochange.bean.User;

/**
 * File Name UserBiz
 * Created by Administrator
 * Created date on 2017/6/21 17:34.
 */

public class UserBiz implements IUserBiz
{
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener)
    {

        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);

                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登陆成功

                if ("zq".equals(username)&&"111".equals(password))
                {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);

                    loginListener.loginSuccess(user);
                }
                else
                    loginListener.loginFailed();
            }
        }.start();

    }
}
