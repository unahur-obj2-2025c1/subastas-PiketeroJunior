package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class EstrategiaConLimite implements Estrategia {
    private Integer limite;

    public EstrategiaConLimite(Integer limite) {
        this.limite = limite;
    }

    @Override
    public Oferta crearOferta(Subastador subastador) {
        Integer nuevaOferta = subastador.getUltimaOferta().getValor() + 10;
        if (nuevaOferta > limite){
            return subastador.getUltimaOferta();
        }
        return new Oferta(subastador, nuevaOferta);
    }
    
}
