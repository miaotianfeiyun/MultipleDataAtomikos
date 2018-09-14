package com.oojunzi.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oojunzi.test.dao.UserDao;
import com.oojunzi.test.dao1.VipUserMapper;
import com.oojunzi.test.model.User;
import com.oojunzi.test.model1.VipUser;
import com.oojunzi.test.service.UserService;

@RestController
public class MainController {
	@Autowired
	UserService userService;
	@Autowired
	UserDao userDao;
	@Autowired
	VipUserMapper  vipUserMapper;
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String get() throws Exception{
		User u=userService.findByMobile("17600195751");
//		VipUser vu =userService.getVipUserById(10);
		VipUser vp =new VipUser();
		vp.setPhone("131111111111111");
		VipUser u1=userService.getVipUserByParas(vp);
		return "hello ---"+u.getName()+"u1:"+u1.getReal_name();
	}
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@Transactional
	public String test() throws Exception{
		User u=new User();
		u.setName("test");
		u.setMobile("11111111111");
		u.setUserType(3);
		u.setCity("test");
		u.setInviterUid(99999);
//		userService.createUser(u);
		userDao.insert(u);
		VipUser vu =new VipUser();
		vu.setPhone("11111111111111111111111111111111111111111111111111111111111111111111111111111111");
		vu.setEmail("11111111111111111111111111111111111111111111111111111111111111111111111111111111");
		vu.setNick_name("11111111111111111111111111111111111111111111111111111111111111111111111111111111");
		vu.setReal_name("11111111111111111111111111111111111111111111111111111111111111111111111111111111");
		vipUserMapper.save(vu);
		//userService.saveVipUser(vu);
		return "";
	}

}
