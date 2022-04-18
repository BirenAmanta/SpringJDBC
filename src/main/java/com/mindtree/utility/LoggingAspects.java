package com.mindtree.utility;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspects {
	@Autowired
	Environment ev;
	public static final Logger Log=Logger.getLogger(LoggingAspects.class);
	@AfterThrowing(pointcut = "execution(* com.mindtree.service.*Impl.*(..))",throwing = "ex")
	public void setServiceLog(Exception ex)
	{
		Log.error(ev.getProperty(ex.getMessage(),ex.getMessage()));
	}
}
