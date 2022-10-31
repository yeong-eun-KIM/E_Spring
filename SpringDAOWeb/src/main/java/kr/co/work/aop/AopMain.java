package kr.co.work.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.transaction.annotation.Transactional;

public class AopMain {

	public static void main(String[] args) throws Exception {
		MyAdvice myAdvice = new MyAdvice();
		Class myClass=  Class.forName("kr.co.work.aop.MyClass");
		
		Object obj = myClass.newInstance();
		for(Method m : myClass.getDeclaredMethods()) {
			myAdvice.invoke(m, obj, null);
		}
	}
}


class MyClass{
	@Transactional
	void ezen() {
		System.out.println("ezen1() is called");
	}
	
	void ezen2() {
		System.out.println("ezen2() is called");
	}
	
	void itezen1() {
		System.out.println("itezen1() is called");
	}
}

//보조기능
class MyAdvice {
	Pattern p = Pattern.compile("e.*");
	
	boolean matches(Method m) {
		Matcher matcher =  p.matcher(m.getName());
		return matcher.matches();
	}
			
	void invoke(Method m, Object obj, Object...args) throws Exception {
		//if(matches(m))
		//핵심 기능에 Transactional 어노테이션이 설정되어 있는 경우에만 before를 출력
		if(m.getAnnotation(Transactional.class) != null)
			System.out.println("[이전 before] {");
		m.invoke(obj, args);	//ezen1(), ezen2, itezen1()을 호출가능
		//if(matches(m))
		if(m.getAnnotation(Transactional.class) != null)
			System.out.println("} [이후 after] ");		
	}
}