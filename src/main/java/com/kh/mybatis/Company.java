package com.kh.mybatis;

import lombok.Data;

import java.util.List;

@Data // @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode
public class Company {
    private int id;
    private String name;
    private String address;
    private List<Employee> employeeList; //사원들의 목록을 가지고 오게끔 만들어야 함

}
