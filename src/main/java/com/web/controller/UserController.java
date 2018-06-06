package com.web.controller;

import com.web.entity.User;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wl on 2017/4/7.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获取所有用户列表
     *
     * @param request
     * @return
     */
    @RequestMapping("/getAllUser")
    public String getAllUser(HttpServletRequest request) {
        List<User> users = userService.findAll();
        request.setAttribute("userList", users);
        return "/allUser";
    }

    /**
     * 跳转到添加用户界面
     *
     * @return
     */
    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "/addUser";
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser")
    public String addUser(User user) {
        userService.save(user);
//        return "redirect:/user/getAllUser";//响应重定向到所有用户界面
        return "redirect:/user/getPageUser";//响应重定向到所有用户界面(分页)
    }

    /**
     * form表单提交 Date类型数据绑定
     * <功能详细描述>
     *
     * @param binder
     * @see [类、类#方法、类#成员]
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 编辑用户
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user, HttpServletRequest request) {
        if (userService.update(user)) {
            user = userService.findById(user.getId());
            request.setAttribute("user", user);
//            return "redirect:/user/getAllUser";
            return "redirect:/user/getPageUser";//响应重定向到所有用户界面(分页)
        } else {
            return "/error";//更新失败
        }
    }

    /**
     * 根据id查询单个用户
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/getUser")
    public String getUser(Integer id, HttpServletRequest request) {
        request.setAttribute("user", userService.findById(id));
        return "/editUser";
    }

    /**
     * 删除用户
     *
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id, HttpServletRequest request, HttpServletResponse response) {
        if (userService.delete(id)) {
//            return "redirect:/user/getAllUser";
            return "redirect:/user/getPageUser";//响应重定向到所有用户界面(分页)
        } else {
            return "/error";
        }
    }

    @RequestMapping("/getPageUser")
    public String main(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, Model model) {
        model.addAttribute("pagemsg", userService.findByPage(currentPage));//回显分页数据
        return "pageUser";
    }
}
