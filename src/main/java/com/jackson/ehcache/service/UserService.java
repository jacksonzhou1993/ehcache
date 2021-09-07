package com.jackson.ehcache.service;

import com.jackson.ehcache.bean.User;
import com.jackson.ehcache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhoujunhui
 * @description: TODO
 * @date 2021/9/7 14:40
 */
@Service
public class UserService {
    private static final String CACHE_STRATEGY = "userCache";

    @Autowired
    private UserMapper userMapper;

    public void save(User user){
       userMapper.save(user);
    }

    @Cacheable(value=CACHE_STRATEGY,key="'key_'+#id")
    public User selectById(Long id){
        Optional<User> optionalUser = userMapper.findById(id);
        return optionalUser.get();
    }
}
