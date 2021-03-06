package com.hss.aop.aspect;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.hss.aop.aspect.annotation.Speaker;

/**
 * 使用@Aspect注解的Spring AOP 切面
 * @author Shaoshi Hang
 *
 */
@Component
@Aspect
// @Order注解用于表明该切面的优先级，当不同切面里的通知要在同一个连接点中运行，使用该注解可以确保优先级，the lower the priorer
// @Order(1)
public class MyAspect {
		
	// 声明切入点 pointcut
	// 匹配名字为sayHello()的方法
	@Pointcut("execution (* com.hss.aop.aspect..*.sayHello(..))")
	private void anySayHello() {
	}
	
	@Pointcut("within (com.hss.aop.aspect.service..*)")
	private void anyService() {
	}
	
	// 匹配任意public方法
	@Pointcut("execution (public * * (..))")
	private void anyPublic() {
	}
	
	// 匹配com.hss.aop.aspect包（及其子包）下的任意连接点
	@Pointcut("within (com.hss.aop.aspect..*)")
	private void moduleMethod() {
	}
	
	// 匹配com.hss.aop.aspect包（及其子包）下的public方法
	@Pointcut("moduleMethod() && anyPublic()")
	private void modulePublic() {
	}
	
	@Pointcut("execution (* com.hss.aop.aspect.dao.*.*(..))")
	private void daoMethod() {
	}
	
	// 声明通知
	// 切点为anySayHello()
	@Before("anySayHello()")
	public void before() {
		System.out.println("Before anySayHello");
	}
	
	@Before("anyService()")
	public void beforeService() {
		System.out.println("Before anyService");
	}
	
	@AfterReturning(pointcut="com.hss.aop.aspect.MyAspect.anySayHello()"
			,returning="retVal")
	public void afterReturning(Object retVal) {
		System.out.println("After anySayHello " + retVal);
	}
	
	
	// 后置通知会被异常终止
	@AfterReturning(pointcut = "execution (* divideZero(..))")
	public void afterReturning() {
		System.out.println("After divideZero ");
	}
	
	@AfterThrowing(pointcut="execution (* divideZero(..))"
			,throwing="ex")
	public void doException(Exception ex) {
		System.out.println("AfterThrowing divideZero " + ex.getMessage());
	}
	
	// 最终通知是否有异常都执行
	@After("execution (* divideZero(..))")
	public void release() {
		System.out.println("Finally divideZero...");
	}
	
	// 环绕通知，并通过args(arg..)传递参数
	@Around(value="execution (* sayMessage(..)) && args(arg1,arg2,..)")
	public Object aroundAdvice1(ProceedingJoinPoint jp, String arg1, String arg2) throws Throwable  {
		System.out.println(arg1 + " " + arg2);
		String[] args = {arg2, arg1};
		Object retVal1 = jp.proceed(args);
		return retVal1;
	}
	
	// 环绕通知 参数列表解析的时候是倒序 因为可变参数列表的参数个数并不确定
	@Around(value="execution (* sayMessage(..)) && args(arg2,arg1) && @annotation(speaker)")
	public Object aroundAdvice2(ProceedingJoinPoint jp, Speaker speaker, String arg1, String arg2) throws Throwable  {
		// 对参数进行预处理，要保证参数绑定顺序（倒序）
		String[] args = {speaker.value() + " say "+ arg1, arg2};
		return jp.proceed(args);
	}
	
	// 声明引入(让已有的类去实现额外的接口) 目前有问题，查看spring4文档后再修改
	/*@DeclareParents(value="com.hss.aop.aspect.service.*", defaultImpl=BaseServiceImpl.class)
	public static BaseService base;
	
	@Before(value="com.hss.aop.aspect.MyAspect.anySayHello()")
	public void preLog(BaseService baseService) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(dateFormat.format(new Date()));
		baseService.log();
	}*/
}
