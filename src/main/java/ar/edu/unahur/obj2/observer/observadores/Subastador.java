package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;

public class Subastador implements Observer {
    private final String nombre;
    private Oferta ultimaOferta;

    public Subastador(String nombre){
        this.nombre = nombre;
        actualizar(new Oferta(this, 0));
    }

    @Override
    public void actualizar(Oferta oferta) {
        this.ultimaOferta = oferta;
    }

    public Oferta crearOferta(){
        return new Oferta(this, ultimaOferta.getValor() + 10);
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
