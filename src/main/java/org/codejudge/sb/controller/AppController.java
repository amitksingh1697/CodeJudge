package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AppController {

    @ApiOperation("This is the hello world api")
    @GetMapping("/")
    public String hello() {
        return "Hello World!!";
    }


}
