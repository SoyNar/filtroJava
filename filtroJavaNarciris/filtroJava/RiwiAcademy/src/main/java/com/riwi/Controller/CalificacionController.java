package com.riwi.Controller;

import com.riwi.Entity.Calificacion;
import com.riwi.Entity.Course;
import com.riwi.Entity.Inscription;
import com.riwi.Model.CalificacionModel;
import com.riwi.Persistence.IModel.ICalificacion;

import java.util.List;

public class CalificacionController {

    ICalificacion iCalificacion = new CalificacionModel();
    public Calificacion create(Calificacion calificacion){
        return this.iCalificacion.create(calificacion);
    }


    public void read(){
        List<Calificacion> lisCalificacion = this.iCalificacion.read();
        lisCalificacion.forEach(System.out::println);
    }

    public boolean delete(Integer id){
        boolean deleted = this.iCalificacion.delete(id);
        if(deleted){
            System.out.println(" deleted");
        }
        return false;
    }
    public void update(Calificacion calificacion){
        this.iCalificacion.update( calificacion);
    }
}
