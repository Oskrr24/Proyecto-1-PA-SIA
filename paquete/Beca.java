package paquete;

public class Beca{

    public boolean BECA_Bicentenario(float rangoSE, int PtsPAES){
        if(rangoSE >= 0.7 && PtsPAES >= 510)
        return true;
        else
        return false;
    }
    public boolean BECA_JuanGomezMilla(float rangoSE, int PtsPAES){
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