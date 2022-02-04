package studentAssignment.service;

import java.util.List;

import studentAssignment.persistant.dto.ClassRequestDto;
import studentAssignment.persistant.dto.ClassResponseDto;

public interface ClassService {
	public int insert(ClassRequestDto dto);
	public List<ClassResponseDto> select(ClassRequestDto dto);
	public List<ClassResponseDto> selectOne(ClassRequestDto dto);
}
