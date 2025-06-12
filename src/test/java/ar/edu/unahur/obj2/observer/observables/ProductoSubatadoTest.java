package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

class ProductoSubatadoTest {
    Subastador s1 = new Subastador("gonzager");
    Subastador s2 = new Subastador("diazdan");
    Subastador s3 = new Subastador("martomau");

    ProductoSubatado productoSubatado = new ProductoSubatado();

    @BeforeEach
    void setUp() {

        productoSubatado.reiniciarSubasta();
        s1.reiniciarSubastador();
        s2.reiniciarSubastador();
        s3.reiniciarSubastador();

        productoSubatado.agregarObservador(s1);
        productoSubatado.agregarObservador(s3);

    }

    void escenario1(){
        productoSubatado.agregarOferta(s3.crearOferta());
        productoSubatado.agregarOferta(s1.crearOferta());
        productoSubatado.agregarOferta(s3.crearOferta());
    }

    @Test
    void dadoElEscenario1_seVerifiqueLaCorrectaNotificacionDeLaUltimaOfertaDeLosSubastadores(){
        escenario1();
        assertEquals(s3, s1.getUltimaOferta().getSubastador());
        assertEquals(s3, s3.getUltimaOferta().getSubastador());
    }

    @Test
    void dadoElEscenario1_seVverificarQueLaUltimaOfertaRegistradaPerteneceAlSubastadorCorrecto(){
        escenario1();
        assertTrue(productoSubatado.getUltimaOferta().equals(s3.getUltimaOferta()));
    }

    @Test
    void dadoElEscenario1_seVerificarQueElValorDeLaUltimaOfertaRegistradaSeaElCorrecto(){
        escenario1();
        assertEquals(30, productoSubatado.getUltimaOferta().getValor());
    }

    @Test
    void dadoElEscenario1_seVerificarQueLaCantidadDeOfertasRegistradasSea3(){
        escenario1();
        assertEquals(3, productoSubatado.getOfertas().size());
    }

    @Test
    void dadoElEscenario1_alAgregarUnOfertaDeUnUsuarioQueNoParticipaEnLaSubsta_seProduceUnaExcepcion(){
        escenario1();
        assertThrowsExactly(OfertaSubastadorException.class,
                () -> {
                    productoSubatado.agregarOferta(s2.crearOferta());
                }, "El subastador diazdan no participa en la subasta");
    }
    
}
