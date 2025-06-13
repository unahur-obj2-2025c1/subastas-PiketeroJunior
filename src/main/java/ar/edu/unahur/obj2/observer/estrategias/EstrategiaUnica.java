package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class EstrategiaUnica implements Estrategia {
    private Boolean hayOferta = false;
    @Override
    public Oferta crearOferta(Subastador subastador) {
        if (hayOferta){
            return subastador.getUltimaOferta();
        }
        hayOferta = true;
        return new Oferta(subastador, subastador.getUltimaOferta().getValor() + 10);
    }
    
}
