package com.example.demo.repository;

import com.example.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //年龄查询
    public List<Girl> findByAge(Integer age);
}
