package com.portfolioargprog.firedust.Controller;

import com.portfolioargprog.firedust.Dto.dtoExperiencia;
import com.portfolioargprog.firedust.Entity.Experiencia;
import com.portfolioargprog.firedust.Security.Controller.Mensaje;
import com.portfolioargprog.firedust.Service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explab")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontend-portfolioargprog.web.app")
public class ExperienciaController {
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es un campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(experienciaService.existsByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("La experiencia indicada ya existe en la base de datos."), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE(), dtoexp.getAniosE1(), dtoexp.getAniosE2());
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("La experiencia se ha agregado con éxito."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        if(!experienciaService.existsById(id))
                return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        if(experienciaService.existsByNombreE(dtoexp.getNombreE()) && experienciaService.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La experiencia indicada ya existe en la base de datos"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es un campo obligatorio."), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        experiencia.setAniosE1(dtoexp.getAniosE1());
        experiencia.setAniosE2(dtoexp.getAniosE2());
        
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("La experiencia se ha actualizado con éxito"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
                return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        
        experienciaService.delete(id);
        
        return new ResponseEntity(new Mensaje("La experiencia se ha eliminado con éxito."), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id")int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("Inexistente"), HttpStatus.NOT_FOUND);
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
