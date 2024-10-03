package com.example.demo.Common_Name;

import com.example.demo.Species.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommonNameService {
    @Autowired
    CommonNameRepository commonNameRepository;

    public CommonName getCommonNameBySpecies(Species species){
        return commonNameRepository.findCommonNameBySpecies(species);
    }
}
