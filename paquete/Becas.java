package paquete;

public class Becas{

    private boolean becaBicentenario = false;
    private boolean becaJGM = false;
    private boolean becaVLP = false;
    private boolean becaEA = false;
    
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
//Esta se utilizo sobre carga de metodos, simplemente cambie los valores de entrada, esta es para los extranjedor por si acaso
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