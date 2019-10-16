package com.qklt.mnbsb.service.Impl;

import com.qklt.mnbsb.dao.impl.UserDAOImpl;
import com.qklt.mnbsb.domain.User;
import com.qklt.mnbsb.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class HomeServiceImpl implements HomeService {

    private UserDAOImpl ud;

    @Autowired
    public HomeServiceImpl(UserDAOImpl ud) {
        this.ud = ud;
    }

    @Override
    public boolean updateInformation(User user) {
        return ud.updateUserInformation(user);
    }

    @Override
    public User uploadPortrait(User user, String portraitName) {
        if(portraitName == null) {
            return user;
        }
        user.setPortrait(portraitName);
        ud.updateUserInformation(user);
        return user;
    }

    @Override
    public boolean delOldPortrait(String portraitPath, String portraitName) {
        if(portraitName == null || portraitPath == null) {
            return false;
        }
        // 默认头像不删除
        if("1.png".equals(portraitName)) {
            return true;
        }
        File delFile = new File(portraitPath);
        return delFile.delete();
    }

}
