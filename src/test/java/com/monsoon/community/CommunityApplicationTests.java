package com.monsoon.community;


import com.monsoon.community.dao.AlphaDao;
import com.monsoon.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);

		AlphaDao ad = applicationContext.getBean(AlphaDao.class);

		System.out.println(ad.select());

		ad = applicationContext.getBean("AlphaHibernate", AlphaDao.class);
		System.out.println(ad.select());
	}

	@Test
	public void	testBeanManagement(){
		AlphaService as = applicationContext.getBean(AlphaService.class);
		System.out.println(as);
		AlphaService as2 = applicationContext.getBean(AlphaService.class);
		System.out.println(as2);
	}

	@Test
	public void testBeanConfig(){
		SimpleDateFormat sdf = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(sdf.format(new Date()));
	}

	@Autowired
	@Qualifier("AlphaHibernate")
	private AlphaDao alphaDao;
	@Test
	public void testDI(){
		System.out.println(alphaDao);
	}

}
