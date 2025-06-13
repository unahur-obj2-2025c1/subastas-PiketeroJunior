package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class EstrategiaArriesgada implements Estrategia {

    @Override
    public Oferta crearOferta(Subastador subastador) {
        return new Oferta(subastador, subastador.getUltimaOferta().getValor() + 10);
    }
    
}
