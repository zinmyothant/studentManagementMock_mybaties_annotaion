package studentAssignment.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import studentAssignment.persistant.dao.UserInterface;
import studentAssignment.persistant.dto.UserRequestDto;
import studentAssignment.persistant.dto.UserResponseDto;

public class UserServiceImpl implements UserService {

	@Override
	public int insert(UserRequestDto dto) {
		int result = 0;
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			session.getConfiguration().addMapper(UserInterface.class);
			result = session.getMapper(UserInterface.class).insert(dto);
			session.commit();
		}
		return result;
	}

	@Override
	public int update(UserRequestDto dto) {
		int result = 0;
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			session.getConfiguration().addMapper(UserInterface.class);
			result = session.getMapper(UserInterface.class).update(dto);
			session.commit();
		}
		return result;
	}

	@Override
	public int delete(UserRequestDto dto) {
		int result = 0;
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			session.getConfiguration().addMapper(UserInterface.class);
			result = session.getMapper(UserInterface.class).delete(dto);
			session.commit();
		}
		return result;

	}

	@Override
	public List<UserResponseDto> select(UserRequestDto dto) {
		List<UserResponseDto> list = new ArrayList<UserResponseDto>();
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			session.getConfiguration().addMapper(UserInterface.class);
			list = session.getMapper(UserInterface.class).select(dto);
			session.commit();
		}
		return list;
	}

	@Override
	public List<UserResponseDto> selectOne(UserRequestDto dto) {
		List<UserResponseDto> list = new ArrayList<UserResponseDto>();
		
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			session.getConfiguration().addMapper(UserInterface.class);
			list = session.getMapper(UserInterface.class).selectOne(dto);
			session.commit();
		}
		return list;
	}

}
