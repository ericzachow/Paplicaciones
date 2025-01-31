package org.pap.Clases;

import java.time.LocalDateTime;
import org.pap.dtClasses.DTDonacion;
import org.pap.dtClasses.DTAlimento;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("AL")
public class Alimento extends Donacion {


    private String descProducto;
    private int cantElemntos;

    public Alimento(){};

    // Getter para descProducto
    public String getDescProducto() {
        return this.descProducto;
    }

    // Setter para descProducto
    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    // Getter para cantElemntos
    public int getCantElemntos() {
        return cantElemntos;
    }

    // Setter para cantElemntos
    public void setCantElemntos(int cantElemntos) {
        this.cantElemntos = cantElemntos;
    }

    public Alimento(int id, LocalDateTime fechaIngresada, String descProducto, int cantElemntos) {
        super(id, fechaIngresada);
        this.descProducto = descProducto;
        this.cantElemntos = cantElemntos;
    }

    @Override
    public DTDonacion transformarADtDonacion(){
        return new DTAlimento(this.getId(),this.getFechaIngresada(), this.getDescProducto(), this.getCantElemntos());

    }

    @Override
    public void actualizarDesdeDTO(DTDonacion dtoDonacion) {
        if (dtoDonacion instanceof DTAlimento) {
            DTAlimento alimentoDTO = (DTAlimento) dtoDonacion;
            this.descProducto = alimentoDTO.getDescProducto();
            this.cantElemntos = alimentoDTO.getCantElemntos();
        }
    }
}
