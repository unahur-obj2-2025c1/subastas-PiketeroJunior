package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public interface Estrategia {
    Oferta crearOferta(Subastador subastador);
}
