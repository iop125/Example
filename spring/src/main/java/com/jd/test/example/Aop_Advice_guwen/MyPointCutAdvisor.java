package com.jd.test.example.Aop_Advice_guwen;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

public class MyPointCutAdvisor implements PointcutAdvisor {
    private BeforeAdvice advice;
    private MyPointCut pointCut;


    @Override
    public Pointcut getPointcut() {
        return this.pointCut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice ;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    public void setAdvice(BeforeAdvice advice) {
        this.advice = advice;
    }

    public MyPointCut getPointCut() {
        return pointCut;
    }

    public void setPointCut(MyPointCut pointCut) {
        this.pointCut = pointCut;
    }
}
