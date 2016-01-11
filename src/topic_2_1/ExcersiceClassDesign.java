package topic_2_1;

/**
 *
 * @author jjsanche
 */
public class ExcersiceClassDesign {

}

abstract class Vehicle {
    private String marca;
    private String modelo;
    private int year;
    private double kilometraje;
    private double precio;
    private String color;
    private int existencia;
    
    public int getExistencia() {
        return existencia;
    }
    
    public abstract Object getPromociones();
}

class Automovil extends Vehicle {
    private String transmision;
    private int cilindros;
    
    public Object getPromociones() {
        return null;
    }
}

class Motocicleta extends Vehicle {
    private double cilindraje;
    
    public Object getPromociones() {
        return null;
    }
}