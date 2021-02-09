package com.copasso.cocobill.presenter.contract;

import com.copasso.cocobill.base.BaseContract;
import com.copasso.cocobill.model.bean.remote.MyUser;

/**
 * Created by Zhouas666 on 2019-01-08
 * Github: https://github.com/zas023
 * @author 123
 */
public interface LandContract extends BaseContract {

    interface View extends BaseContract.BaseView {

        /**
         * 加载成功
         * @param user
         */
        void landSuccess(MyUser user);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        /**
         * 用户登陆
         * @param username 账号名
         * @param password 密码
         */
        void login(String username, String password);

        /**
         * 用户注册
         * @param username 账号名
         * @param password 密码
         * @param mail  邮箱
         */
        void signUp(String username, String password, String mail);
    }
}
