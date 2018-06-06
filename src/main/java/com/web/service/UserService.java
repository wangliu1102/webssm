package com.web.service;

import com.web.entity.Page;
import com.web.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/9/24.
 */
public interface UserService {

    boolean delete(Integer id);

    void save(User user);

    boolean update(User user);

    User findById(Integer id);

    List<User> findAll();

    int selectCount();

    Page<User> findByPage(int currentPage);
}
