package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     *插入员工数据
     * @param employee
     */
    @Insert("insert into employee (id, username, password, name, phone,sex,id_number, create_time, update_time, create_user, update_user) values (#{id}, #{username}, #{password}, #{name}, #{phone}, #{sex}, #{idNumber}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Employee employee);


    /**
     * 分页查询员工
     * @param employeeDTO
     * @return
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeeDTO);

    /*
     * 员工停用/启用
     * @param status 0：停用 1：启用
     * @param id 员工id
     * @return
     * */


    void update(Employee employee);

    /*
     * 编辑员工
     * @param id 员工id
     * @param employee 员工信息
     * @return
     * */
    @Select("select * from employee where id=#{id}")
    Employee getById(Long id);
}
