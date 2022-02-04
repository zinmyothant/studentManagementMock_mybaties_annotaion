package studentAssignment.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;import studentAssignment.controller.studentController;
import studentAssignment.persistant.dao.StudentInterface;
import studentAssignment.persistant.dto.StudentRequestDto;
import studentAssignment.persistant.dto.StudentResponseDto;

public class StudentServiceImpl implements StudentService {

	@Override
	public int insert(StudentRequestDto dto) {
		int result = 0;
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
		session.getConfiguration().addMapper(StudentInterface.class);
			result = session.getMapper(StudentInterface.class).insert(dto);
			session.commit();
		}
		return result;

	}

	@Override
	public int update(StudentRequestDto dto) {
		int result = 0;
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			session.getConfiguration().addMapper(StudentInterface.class);
			result = session.getMapper(StudentInterface.class).update(dto);
			session.commit();
		}
		return result;
	}

	@Override
	public int delete(StudentRequestDto dto) {
		int result = 0;
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
		session.getConfiguration().addMapper(StudentInterface.class);
			result = session.getMapper(StudentInterface.class).delete(dto);
			session.commit();
		}
		return result;
	}

	@Override
	public List<StudentResponseDto> select(StudentRequestDto dto) {
		List<StudentResponseDto> list = new ArrayList<StudentResponseDto>();

		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			session.getConfiguration().addMapper(StudentInterface.class);
			list = session.getMapper(StudentInterface.class).select(dto);
			session.commit();
		}
		return list;
	}

	@Override
	public List<StudentResponseDto> selectOne(StudentRequestDto dto) {

		List<StudentResponseDto> list = new ArrayList<StudentResponseDto>();
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			session.getConfiguration().addMapper(StudentInterface.class);
			list = session.getMapper(StudentInterface.class).selectOne(dto);
			session.commit();
		}
		return list;
	}

}
