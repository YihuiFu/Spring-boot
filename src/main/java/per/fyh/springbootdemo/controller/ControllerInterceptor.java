package per.fyh.springbootdemo.controller;

import com.mysql.jdbc.log.LogFactory;

import org.aopalliance.intercept.Joinpoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.omg.CORBA.Environment;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @Description:Controller的拦截器
 * @Author：Foyerry
 * @Date：Created in  2017/12/26 11:37
 */
@Aspect
public class ControllerInterceptor {
	private static final Logger logger = LogManager.getLogger(ControllerInterceptor.class);

	/**
	 * 拦截controller 中有@RequestMapping注解的方法（记录请求日志和异常处理）
	 */
	@Pointcut("execution(* per.fyh.springbootdemo.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void controllerMethodPointcutBase() {
	}
	@Around("controllerMethodPointcutBase()")
	public Object baseInterceptor(ProceedingJoinPoint pjp) {
		Object result = null;

		long beginTime = System.currentTimeMillis();
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		String methodName = method.getName();
		logger.warn("####方法执行：" + methodName + new SimpleDateFormat().format(new java.util.Date()) + System.lineSeparator(), signature.getParameterNames());

		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			if (arg instanceof Map<?, ?>) {
				Map<String, Object> map = (Map<String, Object>) arg;
			}
		}
		try {
			result = pjp.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return result;
	}
}


@Aspect
class CarAdvice{
	@Before("execution(* ..*)")
	public void beforeAttack(Joinpoint joinpoint){
		System.out.println("");
	}
}
