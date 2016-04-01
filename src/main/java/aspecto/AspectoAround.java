package aspecto;

import excecao.AplicacaoException;
import org.apache.log4j.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//Para utilizar este aspecto é preciso:
// 1. Sempre que for definida uma nova constraint no CREATE TABLE será necessário acrescentar 
//    esta nova constraint nesta classe.
// 2. Criar uma classe de exceção nova para esta constraint acrescentada ao CREATE TABLE.
// 3. Acrescentar código referente a esta nova constraint nos métodos afetados do managedbean.
@Aspect
public class AspectoAround {

    Logger logger;
    
    @Pointcut("call(* service.*.*(..))")
    public void traduzExcecaoAround() {
    }

    @Around("traduzExcecaoAround()")
    public Object traduzExcecaoAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Throwable t) {

            if (!(t instanceof AplicacaoException)) {
                logger = new Logger();
            }
            throw t;
        }
    }
}
