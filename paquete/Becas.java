package paquete;

public class Becas{

    private String nombreBeca;
    public Becas(String nombreBeca){
        this.nombreBeca = nombreBeca;
    }

    public String getNombreBeca() {
        return nombreBeca;
    }
    
    //CREAR MÁS ATRIBUTOS PARA CREAR UN OBJETO BECA
    //CREAR UN CONSTRUCTOR PARA CADA BECA
   
    //HACER VARIABLE QUE SE LLAME MOSTRARBECA-NOMBRE = TRUE/FALSE
    
    public boolean BECA_JuanGomezMillas(float rangoSE, int PtsPAES){
        if(rangoSE >= 0.7 && PtsPAES >= 510)
        return true;
        else
        return false;
    }

    public boolean BECA_JuanGomezMillas(float rangoSE, boolean nacionalidadChilena ){
        if(rangoSE >= 0.7 && nacionalidadChilena == false)
        return true;
        else
        return false;
    }

    public boolean BECA_Profesor_licenciado_profesional(String carrera, boolean terminada){
        if(carrera.equals("Pedagogia") && terminada == true)
        return true;
        else
        return false;
    }

    public boolean BECA_ExcelenciaAcadémica(float rangoSE, float notasMedia){
        if(rangoSE >= 0.8 && notasMedia >= 6.5)
        return true;
        else
        return false;
    }

}
