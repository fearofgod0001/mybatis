package com.kh.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //jpa에 레파지토리와 대비 되는 영역
public interface CompanyMapper {
    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("company") Company company);

    @Select("SELECT * FROM company")
    @Results(id="CompanyMap", value={
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address")
    })
    List<Company> getAll();

    @Select("SELECT * FROM company WHERE id=#{id}")
    @ResultMap("CompanyMap")
    Company getById(@Param("id") int id);
}



