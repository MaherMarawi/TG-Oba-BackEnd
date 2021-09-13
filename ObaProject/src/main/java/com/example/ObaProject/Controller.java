package com.example.ObaProject;

import com.example.ObaProject.api.ApiService;
import com.example.ObaProject.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/oba/techgrounds")
public class Controller {

    @Autowired
    ApiService service;

    @GetMapping("/search/{search_value}")
    public Response search(@PathVariable String search_value) {
        return service.search(search_value);
    }
}
