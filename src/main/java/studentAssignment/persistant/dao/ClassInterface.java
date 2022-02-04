package studentAssignment.persistant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import studentAssignment.persistant.dto.ClassRequestDto;
import studentAssignment.persistant.dto.ClassResponseDto;

public interface ClassInterface {
String insert="insert into class (id,name) values(#{id},#{name})";
String select="select * from class";
String selectOne="select * from class where where id=#{id}";
@Insert(insert)
public int insert(ClassRequestDto dto);
@Select(select)
@Results(value= {
		@Result(property = "id",column = "id"),
		@Result(property = "name",column = "name")
})
public List<ClassResponseDto> select(ClassRequestDto dto);
@Select(selectOne)
@Results(value= {
		@Result(property = "id",column = "id"),
		@Result(property = "name",column = "id")
})
public List<ClassResponseDto> selectOne(ClassRequestDto dto);
}
