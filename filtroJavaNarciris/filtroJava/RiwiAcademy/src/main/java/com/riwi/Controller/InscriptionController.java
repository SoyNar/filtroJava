package com.riwi.Controller;

import com.riwi.Entity.Inscription;
import com.riwi.Model.InscriptionModel;
import com.riwi.Persistence.IModel.IInscription;

import javax.swing.*;
import java.util.List;

public class InscriptionController {

    IInscription inscription = new InscriptionModel();
    public Inscription create(Inscription inscription){
        return this.inscription.create(inscription);
    }

    public void read(){
        List<Inscription> listInscription = this.inscription.read();
        listInscription.forEach(System.out::println);
    }

    public boolean delete(Integer id){
        boolean idDelete =  this.inscription.delete(id);
        if(idDelete){
            JOptionPane.showMessageDialog(null,"deleted");
        }
        return false;
    }

    public void update(Inscription inscription){
        this.inscription.update( inscription);
    }


}
