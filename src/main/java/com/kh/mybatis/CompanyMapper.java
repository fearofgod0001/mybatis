package com.kh.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //jpa에 레파지토리와 대비 되는 영역
public interface CompanyMapper {
    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("company") Company company);

    @Select("SELECT * FROM company")
//    @Results(id="CompanyMap", value={
//            @Result(property = "name", column = "company_name"),
//            @Result(property = "address", column = "company_address")
//    })
    @Results(id="CompanyMap",value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address"),
            @Result(property = "employeeList", column = "id", many=@Many(
                    select = "com.kh.mybatis.EmployeeMapper.getByCompanyId"
            ))//many 다대일 관계 매핑 id에 해당하는 사원의 리스트ㅡㄹ 가져옴
    })
    List<Company> getAll();

    @Select("SELECT * FROM company WHERE id=#{id}")
    @ResultMap("CompanyMap")
    Company getById(@Param("id") int id);
}



