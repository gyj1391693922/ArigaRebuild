package com.example.controller;


import com.example.common.Result;
import com.example.controller.request.TutorialPageRequest;
import com.example.entity.tutorial;
import com.example.service.impl.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tutorial")
public class tutorialController {

    @Autowired
    TutorialService tutorialService;

    @GetMapping("/add")
    public Result add(@RequestBody tutorial obj){
        tutorialService.add(obj);
        return Result.success();
    }

    @GetMapping("/page")
    public Result page(TutorialPageRequest usersPageRequest){
        return Result.success(tutorialService.page(usersPageRequest
        ));
    }

    @GetMapping("/tutoriallistId/{id}")
    public Result akaslistById(@PathVariable Integer id){
        tutorial tutorial =tutorialService.getBysIdMov(id);
        return Result.success(tutorial);
    }



}
