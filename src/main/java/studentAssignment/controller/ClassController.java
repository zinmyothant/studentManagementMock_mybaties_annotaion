package studentAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import studentAssignment.model.ClassBean;

import studentAssignment.persistant.dto.ClassRequestDto;
import studentAssignment.persistant.dto.ClassResponseDto;
import studentAssignment.service.ClassServiceImpl;

@Controller
public class ClassController {
	@Autowired
	private ClassServiceImpl dao;
	@RequestMapping(value = "/classform", method = RequestMethod.GET)
	public ModelAndView addclass() {
		return new ModelAndView("BUD003", "classes", new ClassBean());
	}
	@RequestMapping(value="/setupaddclass",method=RequestMethod.POST)
	public String setupaddclass(@ModelAttribute("classes")@Validated ClassBean bean,BindingResult bs,ModelMap map) {
		if(bs.hasErrors()) {
			return "BUD003";
		}
		ClassRequestDto dto=new ClassRequestDto();
		dto.setId(bean.getId());
		List<ClassResponseDto> list=dao.selectOne(dto);
		if(list.size()!=0)
			map.addAttribute("err", "Class has been already exist!!");
		else {
			dto.setName(bean.getName());
			int res=dao.insert(dto);
			if(res>0) {
				map.addAttribute("msg","Insert successful");
			}else {
				map.addAttribute("err","Insert fail");
		}}
			return "BUD003";
	}
}
