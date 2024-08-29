package paquete;

public class Becas{

    boolean becaBicentenario = false;
    boolean becaJGM = false;
    boolean becaVLP = false;
    boolean becaEA = false;
    
    //HACER VARIABLE QUE SE LLAME MOSTRARBECA-NOMBRE = TRUE/FALSE
    public boolean BECA_Bicentenario(float rangoSE, int PtsPAES){
        if(rangoSE >= 0.7 && PtsPAES >= 510)
        return true;
        else
        return false;
    }
    
    public boolean BECA_JuanGomezMillas(float rangoSE, int PtsPAES){
        if(rangoSE >= 0.7 && PtsPAES >= 510)
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