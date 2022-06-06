package space.whm.demo.consumer.aspect;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//作用在哪里  ElementType.METHOD作用在方法上
@Retention(RetentionPolicy.RUNTIME)//什么时候编译 RetentionPolicy.RUNTIME运行时编译
public @interface CheckNet {

}
