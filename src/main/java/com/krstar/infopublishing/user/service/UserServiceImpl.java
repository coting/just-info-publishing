package com.krstar.infopublishing.user.service;

import com.krstar.infopublishing.user.dao.UserMapper;
import com.krstar.infopublishing.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.krstar.infopublishing.user.service
 * @Description: TODO
 * @date 2018/4/24 14:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;
    @Override
    public User getUser(String id) {
        return mapper.selectByPrimaryKey(id);
    }
}
