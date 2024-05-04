package com.example.mapper;

import com.example.controller.request.BaseRequest;
import com.example.controller.request.LoginRequest;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    User getByUsernameAndPassword(LoginRequest loginRequest);

    void add(User obj);

    List<User> listByCondition(BaseRequest baseRequest);
}
