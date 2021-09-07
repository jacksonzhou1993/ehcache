package com.jackson.ehcache.web;

import com.jackson.ehcache.bean.User;
import com.jackson.ehcache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author zhoujunhui
 * @description: web层
 * @date 2021/9/7 14:43
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserWeb {

    @Autowired
    private UserService userService;

    @GetMapping("getById/{id}")
    @ResponseBody
    public User getById(@PathVariable("id") Long id){
        log.info("getById={}",id);
        return userService.selectById(id);
    }
    @GetMapping("initData/{name}")
    @ResponseBody
    public String initData(@PathVariable("name")String name){
        StopWatch watch = new StopWatch();
        watch.start("t-1");
        User user = new User();
        user.setName(name);
        user.setDate(new Date());
        watch.stop();
        watch.start("t-2");
        userService.save(user);
        watch.stop();
        System.out.println(watch.prettyPrint());
        return "ok";
    }



}
