package com.alejandro.delvalle.valles.pracaticaexamen.core.service;

import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.InstitutoRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.InstitutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutoServiceImp implements InstitutoService {

    private final InstitutoRepository institutoRepository;

    @Autowired
    public InstitutoServiceImp(InstitutoRepository institutoRepository) {
        this.institutoRepository = institutoRepository;
    }
}
