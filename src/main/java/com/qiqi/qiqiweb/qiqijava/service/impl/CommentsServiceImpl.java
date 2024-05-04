package com.qiqi.qiqiweb.qiqijava.service.impl;

import com.example.Entity.Comments;
import com.example.Entity.NewComments;
import com.example.Mapper.CommentMapper;
import com.example.Service.ICommentsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService implements ICommentsService {

    @Autowired
    CommentMapper commentMapper;

    List<Comments> commentsEnd;

    @Override
    public PageInfo<Comments> pageByPostId(Integer commentsId) {
        commentsEnd = commentMapper.pageByPostId(commentsId);
        return new PageInfo<>(commentsEnd);
    }

    @Override
    public void save(NewComments obj) {
        commentMapper.save(obj);
    }

    @Override
    public void deleteById(Integer commentsId) {
        commentMapper.del(commentsId);
    }
}
