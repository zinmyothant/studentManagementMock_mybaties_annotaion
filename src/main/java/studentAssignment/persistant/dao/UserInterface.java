package studentAssignment.persistant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import studentAssignment.persistant.dto.UserRequestDto;
import studentAssignment.persistant.dto.UserResponseDto;

public interface UserInterface {
	String insert = "insert into user (id,name,password) values(#{id},#{name},#{password})";

	String update = "update user set name=#{name},password=#{password} where id=#{id}";

	String delete = "delete from user where id=#{id}";
	String select = "select * from user";
	String selectOne = "select * from user where id=#{id}";

	@Insert(insert)
	public int insert(UserRequestDto dto);

	@Update(update)
	public int update(UserRequestDto dto);

	@Delete(delete)
	public int delete(UserRequestDto dto);

	@Select(select)
	@Results(value= {
			@Result(property = "id",column = "id"),
			@Result(property = "name",column = "name"),
			@Result(property = "password",column = "password")
	})
	public List<UserResponseDto> select(UserRequestDto dto);

	@Select(selectOne)
	@Results(value= {
			@Result(property = "id",column = "id"),
			@Result(property = "name",column = "name"),
			@Result(property = "password",column = "password")
	})
	public List<UserResponseDto> selectOne(UserRequestDto dto);

}
