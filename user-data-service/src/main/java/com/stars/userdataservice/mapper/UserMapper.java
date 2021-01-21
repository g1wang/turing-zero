package com.stars.userdataservice.mapper;


import com.stars.userdataservice.dao.UserProvider;
import com.stars.userdataservice.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    @Insert("insert into user_info(user_id,username,mail,phone) values (#{userID},#{username},#{mail},#{phone})")
    int insert(@Param("userID") Integer userID,@Param("username") String username, @Param("mail") String mail, @Param("phone") String phone);

    @Insert("insert into user_info(user_id,username,mail,phone) values (#{userID},#{username},#{mail},#{phone})")
    int insertUser(User user);


    @InsertProvider(type = UserProvider.class, method = "insertUsers")
    int intsertAll(@Param("list") List<User> list);

    @Select("select user_id,username from user_info where username like concat('%',#{username},'%')")
    @Results({
            @Result(column = "username",property = "username"),
    })
    List<User> selectUsers(@Param("username") String username);


}
