package com.pingan.web.project;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @PostMapping(value = "/create")
    public String create(){
        return  "create  {} project sucess";
    }
}
