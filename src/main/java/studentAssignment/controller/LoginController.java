package studentAssignment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scripting.bsh.BshScriptUtils.BshExecutionException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import studentAssignment.model.StudentBean;
import studentAssignment.model.UserBean;
import studentAssignment.persistant.dto.UserRequestDto;
import studentAssignment.persistant.dto.UserResponseDto;
import studentAssignment.service.UserServiceImpl;

@Controller

public class LoginController {
	@Autowired
	private UserServiceImpl dao;
	//login - get
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login() {
		System.out.println("asldkjf");
		return new ModelAndView("LGN001", "user", new UserBean());
	}
	//login - post
	@RequestMapping(value = "/setuplogin", method = {RequestMethod.POST,RequestMethod.GET})
	public String setuplogin(@ModelAttribute("user") @Validated UserBean bean, BindingResult rs, ModelMap map
			,HttpSession session) {

	if(rs.hasErrors()) {
		return "LGN001";
	}
 		UserRequestDto dto = new UserRequestDto();

		dto.setId(bean.getId());
		List<UserResponseDto> list = dao.selectOne(dto);
		if (list.size() == 0) {
			map.addAttribute("err", "User not found!!");
			return "LGN001";
		} else {
			if (list.get(0).getPassword().equals(bean.getPassword())) {
			session.setAttribute("id", list.get(0).getId());
			session.setAttribute("name", list.get(0).getName());
			return "M00001";
		} else {
			map.addAttribute("err", "Password is incorrect!!");
			return "LGN001";
		}
		}

	}
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public String welcome() {
		return "redirect:/setuplogin";
	}
	//logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	//usersearch - get
	@RequestMapping(value="/usersearch",method=RequestMethod.GET)

	public ModelAndView usersearch() {
		return new ModelAndView("USR001","user",new UserBean());
	}
	//user register - get
	@RequestMapping(value="useradd",method=RequestMethod.GET)
	public ModelAndView useradd() {
		return new ModelAndView("USR002","user",new UserBean());
	}
	//user register - post
	@RequestMapping(value="/setupadduser",method=RequestMethod.POST)
	public String setupuseradd(@ModelAttribute("user")@Validated UserBean bean,BindingResult bs,ModelMap map) {
		if(bs.hasErrors()) {
		
			return "USR002";
		}
		UserRequestDto dto=new UserRequestDto();
		
				if(bean.getPassword().equals(bean.getConfirm())) {
			dto.setId(bean.getId());
					List<UserResponseDto> list=dao.selectOne(dto);
			if(list.size()!=0)
				map.addAttribute("err","User Id has been already!!");
			else {
				dto.setName(bean.getName());
				dto.setPassword(bean.getPassword());
	
				int res=dao.insert(dto);
				if(res>0) {
					map.addAttribute("msg", "Insert successfully");
				}else {
					map.addAttribute("err","Insert fail");
					return "USR002";
				}
			}
			
			}else
				map.addAttribute("err","Password are not match");
		
		return "USR002";
	}
	//user register - usersearch
	@RequestMapping(value="/setupusersearch",method = RequestMethod.POST)
	public String setupusersearch(@ModelAttribute("user")UserBean bean,ModelMap map) {
		UserRequestDto dto=new UserRequestDto();
		List<UserResponseDto> list=new ArrayList<UserResponseDto>();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		if(!dto.getId().equals("")||!dto.getName().equals("")) {
			list=dao.selectOne(dto);
		}else {
			list=dao.select(dto);
		}
	//	List<UserResponseDto> list=dao.select(dto);
		if(list.size()==0) {
			map.addAttribute("msg","User not found");
		}else {
			map.addAttribute("userlist", list);
		}
	return "USR001";
	}
	//user delete - get
	@RequestMapping(value="userdelete/{id}",method = RequestMethod.GET)
	public String userdelete(@PathVariable String id ,ModelMap map,HttpSession session) {
		UserRequestDto dto=new UserRequestDto();
		dto.setId(id);
		int res=dao.delete(dto);
		if(dto.getId().equals(session.getAttribute("id"))) {
			map.addAttribute("err","Canot delete this current user ");
		}else {
		if(res>0) 
			map.addAttribute("msg","Delete successful!!");
		else
			map.addAttribute("err", "Delete fail");
		}
		return "redirect:/usersearch";
		
	}
	@RequestMapping(value="/userupdate/{id}",method = RequestMethod.GET)
	
	public ModelAndView userupdate(@PathVariable String id) {
		UserRequestDto dto=new UserRequestDto();
		dto.setId(id);
		List<UserResponseDto> list=dao.selectOne(dto);
		UserBean bean=new UserBean();
		for(UserResponseDto res:list) {
			bean.setId(res.getId());
			bean.setName(res.getName());
			bean.setPassword(res.getPassword());
			bean.setConfirm(res.getPassword());
		}
		return new ModelAndView("USR002-01","user",bean);
	}
	@RequestMapping(value="/userupdate",method=RequestMethod.POST)
	public String updateuser(@ModelAttribute("user")@Validated UserBean bean,BindingResult bs,ModelMap map) {
		if(bs.hasErrors()) {
		
			return "USR002-01";
		}
				if(bean.getPassword().equals(bean.getConfirm())) {
				UserRequestDto dto=new UserRequestDto();
				dto.setId(bean.getId());
				dto.setName(bean.getName());
				dto.setPassword(bean.getPassword());
		//	List<UserResponseDto> list=dao.select(dto);
			
				int res=dao.update(dto);
				if(res>0) 
					map.addAttribute("msg", "Update successfully");
				else
					map.addAttribute("err","Insert fail");
					return "USR002-01";
			}
					map.addAttribute("err","Password are not match");
		
		return "USR002-01";
	}
	
	@RequestMapping(value="userreset",method=RequestMethod.GET)
	public String reset() {
		return "redirect:/usersearch";
	}
}
