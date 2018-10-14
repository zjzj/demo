package com.example.demo.controller;


import com.example.demo.domain.Girl;
import com.example.demo.repository.GirlRepository;
import com.example.demo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

  @Autowired
  private GirlRepository girlRepository;

  @Autowired
  private GirlService girlService;

  /**
   * 查询女生列表
   *
   * @return
   */
  @GetMapping(value = "/girls")
  public List<Girl> girlList() {
    return girlRepository.findAll();
  }

  /**
   * 添加一个女生
   * @return
   */

  @PostMapping(value = "/girls")
  public Girl girlAdd(@Valid  Girl girl, BindingResult bindingResult) {
    if(bindingResult.hasErrors()){
      System.out.println(bindingResult.getFieldError().getDefaultMessage());
      return null;
    }
    girl.setCupSize(girl.getCupSize());
    girl.setAge(girl.getAge());

    return girlRepository.save(girl);
  }

  //查询一个女生
  @GetMapping(value = "/girls/{id}")
  public Girl girlFindOne(@PathVariable("id") Integer id) {
    return girlRepository.findById(id).orElse(null);
  }

  //更新
  @PutMapping(value = "/girls/{id}")
  public Girl girlUpdate(@PathVariable("id") Integer id,
                         @RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age) {
    Girl girl = new Girl();
    girl.setId(id);
    girl.setCupSize(cupSize);
    girl.setAge(age);

    return girlRepository.save(girl);

  }

  //删除
  @DeleteMapping(value = "/girls/{id}")
  public void girlDelete(@PathVariable("id") Integer id) {
    girlRepository.deleteById(id);
  }

  //年龄查询
  @GetMapping(value = "/girls/age/{age}")
  public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
    return girlRepository.findByAge(age);
  }

  @PostMapping(value = "/girls/two")
  public void girlTwo() {
    girlService.insertTwo();
  }

}
