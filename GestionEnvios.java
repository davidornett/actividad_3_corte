// Clase abstracta Envio
abstract class Envio {
    protected double peso;
    protected double largo;
    protected double ancho;
    protected double altura;
    protected String direccionDestino;
    
    public Envio(double peso, double largo, double ancho, double altura, String direccionDestino) {
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        this.direccionDestino = direccionDestino;
    }
    
    public abstract double calcularCosto();
 }
 
 // Clase PaqueteEstandar
 class PaqueteEstandar extends Envio {
    private static final double TARIFA_BASE = 5.0;
    private static final double COSTO_POR_PESO = 0.5;
    
    public PaqueteEstandar(double peso, double largo, double ancho, double altura, String direccionDestino) {
        super(peso, largo, ancho, altura, direccionDestino);
    }
    
    @Override
    public double calcularCosto() {
        double volumen = largo * ancho * altura;
        double costoPeso = peso * COSTO_POR_PESO;
        return TARIFA_BASE + costoPeso + volumen * 0.01;
    }
 }
 
 // Clase DocumentoUrgente
 class DocumentoUrgente extends Envio {
    private static final double TARIFA_BASE = 10.0;
    private static final double COSTO_POR_PESO = 1.0;
    
    public DocumentoUrgente(double peso, double largo, double ancho, double altura, String direccionDestino) {
        super(peso, largo, ancho, altura, direccionDestino);
    }
    
    @Override
    public double calcularCosto() {
        double costoPeso = peso * COSTO_POR_PESO;
        return TARIFA_BASE + costoPeso;
    }
 }
 
 // Clase ArticuloFragil
 class ArticuloFragil extends Envio {
    private static final double TARIFA_BASE = 8.0;
    private static final double COSTO_POR_PESO = 0.8;
    private static final double CARGO_FRAGIL = 2.5;
    
    public ArticuloFragil(double peso, double largo, double ancho, double altura, String direccionDestino) {
        super(peso, largo, ancho, altura, direccionDestino);
    }
    
    @Override
    public double calcularCosto() {
        double volumen = largo * ancho * altura;
        double costoPeso = peso * COSTO_POR_PESO;
        return TARIFA_BASE + costoPeso + volumen * 0.02 + CARGO_FRAGIL;
    }
 }
 
 // Ejemplo de uso
 public class GestionEnvios {
    public static void main(String[] args) {
        Envio paquete = new PaqueteEstandar(2.5, 30, 20, 10, "Calle Principal 123");
        Envio documento = new DocumentoUrgente(0.5, 15, 10, 2, "Avenida Central 456");
        Envio articulo = new ArticuloFragil(1.2, 25, 18, 12, "Plaza Mayor 789");
        
        System.out.println("Costo de envío del paquete estándar: $" + paquete.calcularCosto());
        System.out.println("Costo de envío del documento urgente: $" + documento.calcularCosto());
        System.out.println("Costo de envío del artículo frágil: $" + articulo.calcularCosto());
    }
 }