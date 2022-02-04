package studentAssignment.service;

import java.util.List;

import studentAssignment.persistant.dto.UserRequestDto;
import studentAssignment.persistant.dto.UserResponseDto;

public interface UserService {
	public int insert(UserRequestDto dto);
	public int update(UserRequestDto dto);
	public int delete(UserRequestDto dto);
	public List<UserResponseDto> select(UserRequestDto dto) ;
	public List<UserResponseDto> selectOne(UserRequestDto dto);
}
