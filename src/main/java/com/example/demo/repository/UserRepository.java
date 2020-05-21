package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    User saveOrUpdateUser(User user);//新增或者 修改用户
    void deleteUsere(Long id); //删除用户
    User getUserById(Long id); //根据用户id获取用户
    List<User> userList(); //获取所有用户的列表

}
