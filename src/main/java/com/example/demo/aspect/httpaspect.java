package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class httpaspect {

  @Before("execution(public * com.example.demo.controller.GirlController.*(..))")
  public void login(){
    System.out.println("成功");
  }
}
