package com.evan.wj.service;

import com.evan.wj.dao.UserDAO;
import com.evan.wj.pojo.AdminMenu;
import com.evan.wj.pojo.AdminRoleMenu;
import com.evan.wj.pojo.AdminUserRole;
import com.evan.wj.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMenuService {
    @Autowired
    UserService userService;
    @Autowired
    UserDAO userDAO;
    @Autowired AdminUserRoleService adminUserRoleService;

    @Autowired AdminRoleMenuService adminRoleMenuService;
    public List<AdminMenu> getMenuByCurrentUser(){
        // 从数据库获取当前用户
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userDAO.findByUsername(username);

        List<Integer> rids = adminUserRoleService.listAllByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());

        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rids)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());

        //List<AdminMenu> menus = admin
        return null;
    }
}
