package com.example.controller;

import com.example.common.Result;
import com.example.controller.request.TutorialPageRequest;
import com.example.entity.tutorial;
import com.example.entity.tutorialtimes;
import com.example.mapper.TutorialTimesMapper;
import com.example.service.impl.TutorialTimesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tutorialTimes")
public class tutorialTimeController {
    @Autowired
    TutorialTimesService tutorialTimesService;

    @GetMapping("/add")
    public Result add(@RequestBody tutorialtimes obj){
        tutorialTimesService.add(obj);
        return Result.success();
    }

    @GetMapping("/page")
    public Result page(TutorialPageRequest tutorialPageRequest){
        return Result.success(tutorialTimesService.page(tutorialPageRequest));
    }

    @GetMapping("/portfoliolistId/{id}")
    public Result akaslistById(@PathVariable Integer id){
        PageInfo<tutorialtimes> portfolio =tutorialTimesService.getBysIdtutorialtimes(id);
        return Result.success( portfolio);
    }

    @GetMapping("/portfolioV/{pNum}/{id}")
    public Result vlistById(@PathVariable Integer pNum,@PathVariable Integer id){
        PageInfo<tutorialtimes> portfolio =tutorialTimesService.getBysv(pNum,id);
        return Result.success( portfolio);
    }

    //修改查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        tutorialtimes medicinal = tutorialTimesService.getById(id);
        return Result.success(medicinal);
    }
    //增加
    @PostMapping("/save")
    public Result save(@RequestBody tutorialtimes obj){

        tutorialTimesService.save(obj);
        return Result.success();
    }
    //修改
    @PostMapping("/update")
    public Result update(@RequestBody tutorialtimes obj){
        tutorialTimesService.update(obj);
        return Result.success();
    }
    //删除
    @DeleteMapping("/del/{tconst}")
    public Result del(@PathVariable String tconst){
        tutorialTimesService.deleteById(tconst);
        return Result.success();
    }
}

