package space.whm.demo.consumer.aspect;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.naming.Context;

/**
 * https://blog.csdn.net/wangwo1991/article/details/85954126
 *
 */
@Component
@AllArgsConstructor
@Aspect
@Async
@Slf4j
public class CheckNetAspect {

    @Pointcut("@annotation(space.whm.demo.consumer.aspect.CheckNet)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public boolean checkNet() throws Throwable {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        if (signature != null) {
//            CheckNet checkNet = signature.getMethod().getAnnotation(CheckNet.class);
//            if (checkNet != null) {
//                //判断是否有网络
//                //当前类的上下文 有可能是activity  fragment view
//                Object object = joinPoint.getThis();//getThis() 当前切点方法所在的类
//                if (object != null) {
//                    NetworkManagement n = new NetworkManagement();
//                    n.isSpontaneousNotice(true);
//                    if (!NetworkManagement.IsNetWordLinking()) {
//                        log.info("请检测网络");
//                        return null;
//                    }
//                }
//            }
//        }
//        return joinPoint.proceed();
        return false;
    }
}
