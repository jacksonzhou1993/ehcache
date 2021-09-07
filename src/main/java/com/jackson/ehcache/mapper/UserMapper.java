package com.jackson.ehcache.mapper;

import com.jackson.ehcache.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhoujunhui
 * @description: TODO
 * @date 2021/9/7 14:39
 */
public interface UserMapper extends JpaRepository<User,Long> {
}
