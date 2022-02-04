package studentAssignment.service;

import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.session.SqlSession;

import studentAssignment.persistant.dao.ClassInterface;
import studentAssignment.persistant.dto.ClassRequestDto;
import studentAssignment.persistant.dto.ClassResponseDto;

public class ClassServiceImpl implements ClassService{

	@Override
	public int insert(ClassRequestDto dto) {
		int result=0;
		try(SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession()){
			session.getConfiguration().addMapper(ClassInterface.class);
			result=session.getMapper(ClassInterface.class).insert(dto);
			session.commit();
		}
		return result;
		
	}

	@Override
	public List<ClassResponseDto> select(ClassRequestDto dto) {
		List<ClassResponseDto> list=new ArrayList<ClassResponseDto>();
		try(SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession()){
			session.getConfiguration().addMapper(ClassInterface.class);
			list=session.getMapper(ClassInterface.class).select(dto);
		}
		return list;
	}

	@Override
	public List<ClassResponseDto> selectOne(ClassRequestDto dto) {
		List<ClassResponseDto> list=new ArrayList<ClassResponseDto>();
		try(SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession()){
			session.getConfiguration().addMapper(ClassInterface.class);
			list=session.getMapper(ClassInterface.class).select(dto);
		}
		return list;
	}

}
