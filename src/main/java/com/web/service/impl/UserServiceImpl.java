package com.web.service.impl;

import com.web.dao.UserMapper;
import com.web.entity.Page;
import com.web.entity.User;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/9/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean delete(Integer id) {
        return userMapper.delete(id);
    }

    public void save(User user) {
        userMapper.save(user);
    }

    public boolean update(User user) {
        return userMapper.update(user);
    }

    public User findById(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    public List<User> findAll() {
        List<User> list = userMapper.findAll();
        return list;
    }

    public int selectCount() {
        return userMapper.selectCount();
    }

    public Page<User> findByPage(int currentPage) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Page<User> pageBean = new Page<User>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize = 2;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = userMapper.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start", (currentPage - 1) * pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<User> lists = userMapper.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

}

