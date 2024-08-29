package paquete;
import java.util.ArrayList;

public class Postulante {
    private String nombre;
    private String apellido;
    private int edad;
    private String rut;
    private int sexo; // 1 = MASCULINO, 2 = FEMENINO
    private float notasMedia;
    private boolean nacionalidadChilena;
    private float rangoSE;
    private boolean esIndigena;
    private int puntajePaes;
    private String carreraEnCurso;
    private boolean titulado;

    private ArrayList<Becas> becas;

    public Postulante(String nombre, String apellido, int edad, String rut, int sexo, float notasMedia, boolean nacionalidadChilena, float rangoSE, boolean esIndigena, int puntajePaes, String carreraEnCurso, boolean titulado) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.sexo = sexo;
        this.notasMedia = notasMedia;
        this.nacionalidadChilena = nacionalidadChilena;
        this.rangoSE = rangoSE;
        this.esIndigena = esIndigena;
        this.puntajePaes = puntajePaes;
        this.carreraEnCurso = carreraEnCurso;
        this.titulado = titulado;
        this.becas = new ArrayList<>();
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public void setRut(String rut){
        this.rut = rut;
    }

    public int getEdad(){
        return edad;
    }

    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }

    public String getRut(){
        return rut;
    }
    
    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public float getNotasMedia() {
        return notasMedia;
    }

    public void setNotasMedia(float notasMedia) {
        this.notasMedia = notasMedia;
    }

    public boolean isNacionalidadChilena() {
        return nacionalidadChilena;
    }

    public void setNacionalidadChilena(boolean nacionalidadChilena) {
        this.nacionalidadChilena = nacionalidadChilena;
    }

    public float getRangoSE() {
        return rangoSE;
    }

    public void setRangoSE(float rangoSE) {
        this.rangoSE = rangoSE;
    }

    public boolean isEsIndigena() {
        return esIndigena;
    }

    public void setEsIndigena(boolean esIndigena) {
        this.esIndigena = esIndigena;
    }

    public int getPuntajePaes() {
        return puntajePaes;
    }

    public void setPuntajePaes(int puntajePaes) {
        this.puntajePaes = puntajePaes;
    }

    public String getCarreraEnCurso() {
        return carreraEnCurso;
    }

    public void setCarreraEnCurso(String carreraEnCurso) {
        this.carreraEnCurso = carreraEnCurso;
    }

    public boolean getTitulado() {
        return titulado;
    }

    public void setTitulado(boolean titulado) {
        this.titulado = titulado;
    }

    public ArrayList<Becas> getBecas(){
        return becas;
    }

    public void agregarBeca(Becas beca){
        becas.add(beca);
    }

}

