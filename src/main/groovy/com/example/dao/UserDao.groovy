package com.example.dao

import com.example.model.User
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
public interface UserDao {

    // an example of a multi-line sql using groovy triple -quote
    @Select(""" SELECT ID, 
                       FIRST_NAME   as firstName, 
                       LAST_NAME    as lastName, 
                       USER_NAME    as userName, 
                       ACTIVE_SINCE as activeOn 
                FROM USERS
                ORDER BY FIRST_NAME ASC, LAST_NAME ASC """)
    List<User> findOrderedUsers();

    @Select("SELECT * FROM USERS")
    List<User> findAll();

    @Select(""" SELECT ID, 
                       FIRST_NAME   as firstName, 
                       LAST_NAME    as lastName, 
                       USER_NAME    as userName, 
                       ACTIVE_SINCE as activeOn 
                FROM USERS
                WHERE ID = #{id} """)
    User findOne(int id);

    /*@Insert("INSERT into village(name,district) VALUES(#{villageName}, #{district})")
	void insertVillage(Village village);

	@Update("UPDATE village SET name=#{villageName}, district =#{district} WHERE id =#{vid}")
	void updateVillage(Village village);

	@Delete("DELETE FROM village WHERE id =#{id}")
	void deleteVillage(int id);*/

    @Insert(""" INSERT INTO USERS
                    (USER_NAME, FIRST_NAME, LAST_NAME, ACTIVE_SINCE )        
                    VALUES(#{userName}, #{firstName}, #{lastName}, #{activeOn}) """)
    void save(User user);

    @Delete("DELETE FROM USERS WHERE ID=#{id}")
    void delete(int id);
}