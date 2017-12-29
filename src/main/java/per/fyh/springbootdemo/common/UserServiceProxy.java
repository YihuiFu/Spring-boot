package per.fyh.springbootdemo.common;

import org.springframework.aop.AfterReturningAdvice;
import per.fyh.springbootdemo.service.UserService;
import per.fyh.springbootdemo.service.UserServiveImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author：Foyerry
 * @Date：Created in  2017/12/28 15:28
 */
public class UserServiceProxy implements InvocationHandler {
	// 这个就是我们要代理的真实对象,即 UserServiceImpl
	private Object target;

	public UserServiceProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Long begin = System.nanoTime();
		System.out.println("代理真实对象前 before ...");
		Object obj = method.invoke(target, args);
		System.out.println("代理真实对象后 after ...");
		Long end = System.nanoTime();
		System.out.println("此用户" + args[0] + " 登录共耗时："
				+ TimeUnit.MILLISECONDS.convert(end - begin, TimeUnit.NANOSECONDS));
		return obj;
	}
}




