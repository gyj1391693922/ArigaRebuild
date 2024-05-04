package com.example.qiqijava.qiqiweb.service;


import com.example.qiqijava.qiqiweb.controller.request.MovRequest;
import com.example.qiqijava.qiqiweb.entity.Mov;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMovService {

    List<Mov> list();

    PageInfo<Mov> page(MovRequest baseRequest);

    void save(Mov obj);

    Mov getById(Integer id);

    void update(Mov obj);

    void deleteById(Integer id);

    PageInfo<Mov> getByIdMov(Integer id);

    Mov getBysIdMov(Integer id);
}
