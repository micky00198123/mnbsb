package com.qklt.mnbsb.service.Impl;

import com.qklt.mnbsb.dao.impl.UserDAOImpl;
import com.qklt.mnbsb.domain.LoginData;
import com.qklt.mnbsb.domain.User;
import com.qklt.mnbsb.service.LoginService;
import com.qklt.mnbsb.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private UserDAOImpl ud;

    @Autowired
    public LoginServiceImpl(UserDAOImpl ud) {
        this.ud = ud;
    }

    @Override
    public User checkAccount(LoginData ld) {
        ld.setPassword(ServiceUtils.getMD5String(ld.getPassword()));
        return ud.checkAccount(ld) ?
                ud.getUserByName(ld.getUsername()) : null;
    }
}
