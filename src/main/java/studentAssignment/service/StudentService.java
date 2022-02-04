package studentAssignment.service;

import java.util.List;

import studentAssignment.persistant.dto.StudentRequestDto;
import studentAssignment.persistant.dto.StudentResponseDto;

public interface StudentService {
	public int insert(StudentRequestDto dto);
	public int update(StudentRequestDto dto);
	public int delete(StudentRequestDto dto);
	public List<StudentResponseDto> select(StudentRequestDto dto) ;
	public List<StudentResponseDto> selectOne(StudentRequestDto dto);
}
