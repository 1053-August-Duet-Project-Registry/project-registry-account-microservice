package com.revature.registry.aspect;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// note: @Slf4j is not working for some unknown reasons
@Component
@Aspect
public class LoggingAspect {
    static final Logger LOG = Logger.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.revature.registry.service.*.*(..))")
    public void exec() {
        // This method is needed for named PointCut.
    }

    @AfterReturning(value = "exec()", returning = "retVal")
    public void afterReturning(JoinPoint jp, Object retVal) {
        List<Object> args = Arrays.asList(jp.getArgs());
        if (retVal == null) {
            LOG.warn(jp.getSignature() + "(" + args + ")" + " returns null");
        } else {
            try {
                Object ret = retVal instanceof Boolean && Boolean.FALSE.equals(retVal) ? "false"
                        : new ObjectMapper().writeValueAsString(retVal);
                LOG.info(jp.getSignature() + "(" + args + ")" + ": " + "returns " + ret);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterThrowing(pointcut = "exec()", throwing = "ex")
    public void logRegistryException(JoinPoint jp, Exception ex) {
        LOG.info(jp.getSignature() + " threw " + ex.getClass());
    }
}
