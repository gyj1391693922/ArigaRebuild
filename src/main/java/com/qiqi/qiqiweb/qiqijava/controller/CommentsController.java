package com.example.Contorller;

import com.example.Common.Result;
import com.example.Entity.NewComments;
import com.example.Service.Impl.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @GetMapping("/page/{commentsId}")
    public Result pageByPostId(@PathVariable Integer commentsId){

        return Result.success(commentsService.pageByPostId(commentsId));
    }

    @PostMapping("/save")
    public Result save(@RequestBody NewComments obj){
        commentsService.save(obj);
        return Result.success();
    }

    @DeleteMapping("/del/{commentsId}")
    public Result del(@PathVariable Integer commentsId){
        commentsService.deleteById(commentsId);
        return Result.success();
    }

}
