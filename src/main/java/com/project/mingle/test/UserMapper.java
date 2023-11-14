package com.project.mingle.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	 public int userInsert(UserVO vo);
	 
	 //@Select("select email from muser where username = #{username}")
	 //                 select email from muser where username = #{username} ;
	 public String  nameCheck(@Param("username") String username);
}
//