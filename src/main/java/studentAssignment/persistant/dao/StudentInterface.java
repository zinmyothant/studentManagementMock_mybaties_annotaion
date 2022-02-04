package studentAssignment.persistant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import studentAssignment.persistant.dto.StudentRequestDto;
import studentAssignment.persistant.dto.StudentResponseDto;

public interface StudentInterface {
String insert="insert into student\r\n"
		+ "		(student_id,student_name,class_name,register_date,status)\r\n"
		+ "		values(#{studentId},#{studentName},#{className},#{register},#{status})\r\n"
		+ "";
String update="update student set\r\n"
		+ "		student_name=#{studentName},class_name=#{className},register_date=#{register},status=#{status}\r\n"
		+ "		where student_id=#{studentId}\r\n"
		+ "";
String delete="		delete from student where student_id=#{studentId}\r\n"
		+ "";
String select="select * from student";
String selectOne="select * from student where student_id=#{studentId}\r\n"
		+ "";
@Insert(insert)
public int insert(StudentRequestDto dto);
@Update(update)
public int update(StudentRequestDto dto);
@Delete(delete)
public int delete(StudentRequestDto dto);
@Select(select)
@Results(value= {
		@Result(property = "studentId",column = "student_id"),
		@Result(property = "studentName",column = "student_name"),
		@Result(property = "className",column = "class_name"),
		@Result(property = "register",column = "register_date"),
		@Result(property = "status",column = "status"),
})
public List<StudentResponseDto> select(StudentRequestDto dto) ;
@Select(selectOne)
@Results(value= {
		@Result(property = "studentId",column = "student_id"),
		@Result(property = "studentName",column = "student_name"),
		@Result(property = "className",column = "class_name"),
		@Result(property = "register",column = "register_date"),
		@Result(property = "status",column = "status"),

})
public List<StudentResponseDto> selectOne(StudentRequestDto dto);

}
