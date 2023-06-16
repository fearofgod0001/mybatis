package com.kh.mybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyMapper companyMapper;
    private final CompanyService companyService;
    @PostMapping("")
    public int post(@RequestBody Company company){
        return companyMapper.insert(company);
    }
    @GetMapping("")
    public List<Company> getAll(){
        return companyService.getAll();
    }

}
