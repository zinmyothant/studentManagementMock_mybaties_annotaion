package studentAssignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import studentAssignment.model.StudentBean;
import studentAssignment.persistant.dto.ClassRequestDto;
import studentAssignment.persistant.dto.ClassResponseDto;
import studentAssignment.persistant.dto.StudentRequestDto;
import studentAssignment.persistant.dto.StudentResponseDto;
import studentAssignment.persistant.dto.UserRequestDto;
import studentAssignment.service.ClassServiceImpl;
import studentAssignment.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class studentController {
	@Autowired
	private StudentServiceImpl dao;
	@Autowired
	private ClassServiceImpl cdao;

	@RequestMapping(value = "/addstudent", method = RequestMethod.GET)
	public ModelAndView addstudent(ModelMap map, HttpSession session) {
		ClassRequestDto dto = new ClassRequestDto();
		dto.setId("");
		dto.setName("");
		List<ClassResponseDto> list = cdao.select(dto);

		session.setAttribute("clist", list);

		return new ModelAndView("BUD002", "student", new StudentBean());
	}

	@RequestMapping(value = "/setupaddstudent", method = RequestMethod.POST)
	public String setupaddstudent(@ModelAttribute("student") @Validated StudentBean bean, BindingResult bs,
			ModelMap map) {
		if (bs.hasErrors()) {
			return "BUD002";
		}
		StudentRequestDto dto = new StudentRequestDto();
		dto.setStudentId(bean.getStudentId());
				List<StudentResponseDto> list = dao.selectOne(dto);
		
		
		if (list.size() == 0)
			map.addAttribute("err", "StudentId has been already");
		else {
			dto.setStudentName(bean.getStudentName());
			dto.setClassName(bean.getClassName());
			dto.setRegister(bean.getRegister());
			dto.setStatus(bean.getStatus());

			int res = dao.insert(dto);
			if (res > 0)
				map.addAttribute("msg", "Insert successfully!!");
			else
				map.addAttribute("err", "Insert fail");
		}
		return "BUD002";
	}

	@RequestMapping(value = "searchstudent", method = RequestMethod.GET)
	public ModelAndView searchstudent() {
		return new ModelAndView("BUD001", "student", new StudentBean());
	}

	@RequestMapping(value = "setupsearchstudent", method = RequestMethod.POST)
	public String setupsearchstudent(@ModelAttribute("student") StudentBean bean, ModelMap map, HttpSession session) {
		StudentRequestDto dto = new StudentRequestDto();
		dto.setStudentId(bean.getStudentId());
		dto.setStudentName(bean.getStudentName());
		dto.setClassName(bean.getClassName());
		dto.setRegister(bean.getRegister());

		List<StudentResponseDto> list = new ArrayList<StudentResponseDto>();
		if(!dto.getStudentId().equals("")||!dto.getStudentName().equals("")||!dto.getClassName().equals("")) {
			list=dao.selectOne(dto);
		}else {
			list=dao.select(dto);
		}		if (list.size() == 0) {
			map.addAttribute("msg", "Student not found!!");
		}else {
		map.addAttribute("stulist", list);
		}	return "BUD001";
	}

	@RequestMapping(value = "/studentupdate/{studentId}", method = RequestMethod.GET)
	public ModelAndView updatestudent(@PathVariable String studentId, HttpSession session) {
		StudentRequestDto dto = new StudentRequestDto();
		dto.setStudentId(studentId);
		ClassRequestDto cdto = new ClassRequestDto();
		cdto.setId("");
		cdto.setName("");
		List<ClassResponseDto> list = cdao.select(cdto);
		
		session.setAttribute("clist", list);
		List<StudentResponseDto> slist=dao.selectOne(dto);
		StudentBean bean=new StudentBean();
		for(StudentResponseDto res:slist) {
			bean.setStudentId(res.getStudentId());
			bean.setStudentName(res.getStudentName());
			bean.setClassName(res.getClassName());
			bean.setRegister(res.getRegister());
			bean.setStatus(res.getStatus());
		}
		return new ModelAndView("BUD002-01", "student", bean);
	}

	@RequestMapping(value = "/setupupdatestudent", method = RequestMethod.POST)
	public String setupupdatestudent(@ModelAttribute("student") @Validated StudentBean bean, BindingResult bs,
			ModelMap map) {

		StudentRequestDto dto = new StudentRequestDto();
		dto.setStudentId(bean.getStudentId());
		dto.setStudentName(bean.getStudentName());
		dto.setClassName(bean.getClassName());
		dto.setRegister(bean.getRegister());
		dto.setStatus(bean.getStatus());
		// List<StudentResponseDto> list=dao.select(dto);

		int res = dao.update(dto);
		if (res > 0)
			map.addAttribute("msg", "Update successfully!!");
		else
			map.addAttribute("err", "Update fail");

		return "BUD001";
	}

	@RequestMapping(value = "studentupdate/deletestudent/{studentId}", method = RequestMethod.GET)
	public String deletestudent(@PathVariable String studentId, ModelMap map) {
		StudentRequestDto dto = new StudentRequestDto();
		dto.setStudentId(studentId);
		int res = dao.delete(dto);
		if (res > 0)
			map.addAttribute("msg", "Delete successful!!");
		else
			map.addAttribute("err", "Delete fail");

		return "redirect:/searchstudent";
	}

	@RequestMapping(value = "studentreset", method = RequestMethod.GET)
	public String reset() {
		return "redirect:/searchstudent";
	}

}
