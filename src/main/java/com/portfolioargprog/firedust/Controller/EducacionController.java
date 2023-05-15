package com.portfolioargprog.firedust.Controller;

import com.portfolioargprog.firedust.Dto.dtoEducacion;
import com.portfolioargprog.firedust.Entity.Educacion;
import com.portfolioargprog.firedust.Security.Controller.Mensaje;
import com.portfolioargprog.firedust.Service.EducacionService;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = ".")
public class EducacionController {
    @Autowired
    EducacionService educacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada con éxito"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo de nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(educacionService.existsByNombreE(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre proporcionado ya existe en la base de datos."), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE(), dtoeducacion.getAniosE1(), dtoeducacion.getAniosE2());
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educación creada con éxito"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        if(educacionService.existsByNombreE(dtoeducacion.getNombreE()) && educacionService.getByNombreE(dtoeducacion.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("El nombre ya existe en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = educacionService.getOne(id).get();
        
        educacion.setNombreE(dtoeducacion.getNombreE());
        educacion.setDescripcionE(dtoeducacion.getDescripcionE());
        educacion.setAniosE1(dtoeducacion.getAniosE1());
        educacion.setAniosE2(dtoeducacion.getAniosE2());
        
        educacionService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educación actualizada con éxito"), HttpStatus.OK);
    }
}
