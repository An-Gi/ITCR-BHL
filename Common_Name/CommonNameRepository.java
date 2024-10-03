package com.example.demo.Common_Name;

import com.example.demo.Species.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommonNameRepository extends JpaRepository<CommonName, Integer> {

    CommonName findCommonNameBySpecies(Species species);
}
