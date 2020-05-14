package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="user")
public class UserController {
    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id")Long id){
        return new User(id,"lalal",12);
    }

    @Autowired
    private UserRepository userRepository;

    //查询所有用户
    @GetMapping(value = "userlist")
    public ModelAndView userList(Model model){
        model.addAttribute("userList",userRepository.userList());
        model.addAttribute("title","用户管理");
        return  new ModelAndView("user/list","userModel",model);
    }

    //根据id查询用户
    @GetMapping(value = "{id}")
    public ModelAndView view(@RequestParam(value = "id")Long id ,Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return  new ModelAndView("user/view","usereModel",model);
    }

    //获取创建表单界面
    @GetMapping(value = "form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return  new ModelAndView("user/form","userModel",model);
    }

    //保存用户
    @PostMapping()
    public ModelAndView delete(User user){
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/user/userlist");
    }

    //根据id删除用户
    @GetMapping(value ="delete/{id}")
    public ModelAndView delete(@RequestParam(value = "id")Long id){
        userRepository.deleteUsere(id);
        return new ModelAndView("redirect:/user/userlist");
    }

    //修改用户界面
    @GetMapping(value = "edit/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id,Model model){
        User user =userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","编辑用户");
        return new ModelAndView("user/form" ,"userModel",model);
    }
}
