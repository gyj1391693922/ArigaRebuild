package com.example.service;

import com.example.controller.dto.LoginDTO;
import com.example.controller.request.BaseRequest;
import com.example.controller.request.LoginRequest;
import com.example.entity.User;
import com.github.pagehelper.PageInfo;

public interface IUserService {

    void add(User obj);

    PageInfo<User> page(BaseRequest baseRequest);

    LoginDTO login(LoginRequest loginRequest);
}
