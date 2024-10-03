package com.mycompany.sistema_gestion_becas;

public class Solicitud {
    private Postulante postulante;
    private boolean aprobada;

    public Solicitud(Postulante postulante, int idBeca) {
        this.postulante = postulante;
        this.aprobada = false;
    }
    
    public Postulante getPostulante() {
        return postulante;
    }
    
    public void setAprobada(boolean valor) {
        if(valor == true){
            this.aprobada = true;
        }
    }
    
    public boolean isAprobada(){
        return aprobada;
    }
    //METODO PARA POSTULANTE
    public void aprobar() {
        this.aprobada = true;
    }
}
