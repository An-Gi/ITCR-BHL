package com.example.demo.Common_Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CommonName")
public class CommonNameController {

    @Autowired
    private CommonNameService commonNameService;

    @GetMapping
    public List<CommonName> getAllCommonNames() {
        return commonNameService.getAllCommonNames();
    }
}