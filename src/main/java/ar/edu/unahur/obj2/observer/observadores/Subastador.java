package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.estrategias.Estrategia;

public class Subastador implements Observer {
    private final String nombre;
    private Oferta ultimaOferta;
    private Estrategia estrategia;

    public Subastador(String nombre){
        this(nombre, null);
    }

    public Subastador(String nombre, Estrategia estrategia){
        this.nombre = nombre;
        this.estrategia = estrategia;
        actualizar(new Oferta(this, 0));
    }

    @Override
    public void actualizar(Oferta oferta) {
        this.ultimaOferta = oferta;
    }

    public Oferta crearOferta(){
        if (estrategia == null){
            return new Oferta(this, ultimaOferta.getValor() + 10);
        } else{
            return estrategia.crearOferta(this);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Oferta getUltimaOferta() {
        return ultimaOferta;
    }

    public void reiniciarSubastador(){
        actualizar(new Oferta(this, 0));
    }
}
