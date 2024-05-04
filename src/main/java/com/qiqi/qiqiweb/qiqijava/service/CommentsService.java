package com.qiqi.qiqiweb.qiqijava.service;

import com.github.pagehelper.PageInfo;
import com.qiqi.qiqiweb.qiqijava.entity.Comments;
import com.qiqi.qiqiweb.qiqijava.entity.NewComments;

public interface ICommentsService {
    PageInfo<Comments> pageByPostId(Integer commentsId);

    void save(NewComments obj);

    void deleteById(Integer commentsId);
}
