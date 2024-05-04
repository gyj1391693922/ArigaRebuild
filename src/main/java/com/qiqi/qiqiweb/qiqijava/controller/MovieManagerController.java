package com.qiqi.qiqiweb.qiqijava.movieManager.controller;

import com.github.pagehelper.PageInfo;
import com.qiqi.qiqiweb.qiqijava.Common.Result;
import com.qiqi.qiqiweb.qiqijava.movieManager.controller.request.MovieManagerPageRequest;
import com.qiqi.qiqiweb.qiqijava.movieManager.entity.MovieManager;
import com.qiqi.qiqiweb.qiqijava.movieManager.service.MovieManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/por")
public class MovieManagerController {

    @Autowired
    MovieManagerService movieManagerService;

    //总查询
    @GetMapping("/page")
    public Result page(MovieManagerPageRequest movieManagerPageRequest){
        return Result.success(movieManagerService.page(movieManagerPageRequest));
    }

    @GetMapping("/MovieManagerlistId/{id}")
    public Result akaslistById(@PathVariable Integer id){
        PageInfo<MovieManager> MovieManager =movieManagerService.getBysIdMovieManager(id);
        return Result.success( MovieManager);
    }

    @GetMapping("/MovieManagerV/{pNum}/{id}")
    public Result vlistById(@PathVariable Integer pNum,@PathVariable Integer id){
        PageInfo<MovieManager> MovieManager =movieManagerService.getBysv(pNum,id);
        return Result.success( MovieManager);
    }

    //修改查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        MovieManager medicinal = movieManagerService.getById(id);
        return Result.success(medicinal);
    }
    //增加
    @PostMapping("/save")
    public Result save(@RequestBody MovieManager obj){

        movieManagerService.save(obj);
        return Result.success();
    }
    //修改
    @PostMapping("/update")
    public Result update(@RequestBody MovieManager obj){
        movieManagerService.update(obj);
        return Result.success();
    }
    //删除
    @DeleteMapping("/del/{tconst}")
    public Result del(@PathVariable String tconst){
        movieManagerService.deleteById(tconst);
        return Result.success();
    }
}
