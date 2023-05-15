package com.portfolioargprog.firedust.Service;

import com.portfolioargprog.firedust.Entity.Experiencia;
import com.portfolioargprog.firedust.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository experienciaRepository;
    
    public List<Experiencia> list(){
        return experienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return experienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE){
        return experienciaRepository.findByNombreE(nombreE);
    }
    
    public void save(Experiencia exp){
        experienciaRepository.save(exp);
    }
    
    public void delete(int id){
        experienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return experienciaRepository.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return experienciaRepository.existsByNombreE(nombreE);
    }
}
