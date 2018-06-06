package com.web.dao;

import com.web.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/9/24.
 */
@Repository
public interface UserMapper {

    void save(User user);

    boolean update(User user);

    boolean delete(Integer id);

    User findById(Integer id);

    List<User> findAll();

    /**
     * 分页操作，调用findByPage limit分页方法
     *
     * @param map
     * @return
     */
    List<User> findByPage(HashMap<String, Object> map);

    /**
     * 查询用户记录总数
     *
     * @return
     */
    int selectCount();

}
