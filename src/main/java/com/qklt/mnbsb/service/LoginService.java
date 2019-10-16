package com.qklt.mnbsb.service;


import com.qklt.mnbsb.domain.LoginData;
import com.qklt.mnbsb.domain.User;

public interface LoginService {

    /**
     * 检查是否登录成功
     * @param ld
     * @return
     */
    public User checkAccount(LoginData ld);

}
