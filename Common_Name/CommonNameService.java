package com.example.demo.Common_Name;

import com.example.demo.Species.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommonNameService {

    @Autowired
    private CommonNameRepository commonNameRepository;

    public List<CommonName> getAllCommonNames() {
        return commonNameRepository.findAll();
    }

}