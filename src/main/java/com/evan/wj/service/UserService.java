package com.evan.wj.service;

import com.evan.wj.dao.UserDAO;
import com.evan.wj.pojo.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.sql.Struct;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isEXist(String username){
        User user = userDAO.findByUsername(username);
        return null != user;
    }
    public User getByName(String username){
        return userDAO.findByUsername(username);
    }
    public User get(String username,String password){
        return userDAO.getByUsernameAndPassword(username,password);
    }
    public void add(User user){
        userDAO.save(user);
    }

    public int register(User user){
        String username = user.getUsername();
        String name = user.getName();
        String phone = user.getPhone();
        String email = user.getEmail();
        String password = user.getPassword();

        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        phone = HtmlUtils.htmlEscape(phone);
        user.setPhone(phone);
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);
        user.setEnabled(true);

        if("".equals(username) || "".equals(password)){
            return 0;
        }

        boolean exist = isEXist(username);
        if (exist){
            return 2;
        }
        // 生成16未盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5",password,salt,times).toString();

        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userDAO.save(user);
        return 1;
    }
}
