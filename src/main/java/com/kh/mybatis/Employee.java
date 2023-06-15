package com.kh.mybatis;

import lombok.Data;

@Data // @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode

public class Employee {
    private int id;
    private int companyId;
    private String name;
    private String address;

}
