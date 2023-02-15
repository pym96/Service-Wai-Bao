package com.springMVCLearn.controller;

import com.springMVCLearn.pojo.User;
import com.springMVCLearn.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author DJS
 * Date create 0:05 2023/2/7
 * Modified By DJS
 **/
@Controller
public class QuickController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    // 返回Json格式字符串，用户信息
    /*
    *      Controller
    *           |
    *        Service
    *           |
    *          Dao
    *           |
    *    通过Mapper操作数据库
    * */
    @ResponseBody
    @GetMapping("/select")
    public List<User> select(String username) {
        System.out.println(username);
        return userService.selectUserByUserName(username);
    }

    @GetMapping("/request1")
    public String request1(HttpServletRequest request) {
        request.setAttribute("name", "djs");
        return "request2";
    }

    @GetMapping("/request2")
    public String request2(@RequestAttribute("name") String name) {
        System.out.println(name);
        return "/index.jsp";
    }

    @ResponseBody
    @PostMapping("/sendFile")
    public List<User> recvFile(@RequestBody MultipartFile myFile) throws IOException {
        // 保存文件
        final InputStream is = myFile.getInputStream();
        OutputStream os = new FileOutputStream("C:\\Users\\d'j's\\Desktop\\copy.txt");
        IOUtils.copy(is, os);
        is.close();
        os.close();
        User user = new User();
        user.setUsername("zhangsan");
        user.setPsd("123");
        List<User> list = new LinkedList<>();
        list.add(user);
        return list;
    }

    @GetMapping("/restful/{id}")
    public String testRestful(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "/index.jsp";
    }

    @RequestMapping(value = "/show")
    public String show() {
        System.out.println("show");
        System.out.println(userService);
        return "/index.jsp";
    }

    // Json格式参数自动封装成实体类对象
    @PostMapping(value = "/testJson")
    public String testJson(@RequestBody User user) {
        System.out.println(user);
        return "/index.jsp";
    }
}
