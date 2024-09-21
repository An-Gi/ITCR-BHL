package com.example.demo.Common_Name;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonNameRepository extends JpaRepository<CommonName, Integer> {
}