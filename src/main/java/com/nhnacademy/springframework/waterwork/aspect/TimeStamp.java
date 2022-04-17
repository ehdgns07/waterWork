package com.nhnacademy.springframework.waterwork.aspect;

import com.nhnacademy.springframework.waterwork.BootStrap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimeStamp {
    static final Log log = LogFactory.getLog(TimeStamp.class);

    @Around("execution( public * read(..))")
    public Object csvFilereadTimeStamp(ProceedingJoinPoint pjp)throws Throwable{
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return pjp.proceed();
        }finally{
            stopWatch.stop();
            log.info(pjp.toShortString());
            log.info(stopWatch.prettyPrint());
        }
    }

    @Around("execution( public * dataReadAndSave(..))")
    public Object dataReadTimeStamp(ProceedingJoinPoint pjp)throws Throwable{
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return pjp.proceed();
        }finally{
            stopWatch.stop();
            log.info(pjp.toShortString());
            log.info(stopWatch.prettyPrint());
        }
    }

    @Around("execution( public * calculator(..))")
    public Object calculateTimeStamp(ProceedingJoinPoint pjp)throws Throwable{
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return pjp.proceed();
        }finally{
            stopWatch.stop();
            log.info(pjp.toShortString());
            log.info(stopWatch.prettyPrint());
        }
    }

    @Around("execution( public * printingResult(..))")
    public Object printingTimeStamp(ProceedingJoinPoint pjp)throws Throwable{
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return pjp.proceed();
        }finally{
            stopWatch.stop();
            log.info(pjp.toShortString());
            log.info(stopWatch.prettyPrint());
        }
    }
}
