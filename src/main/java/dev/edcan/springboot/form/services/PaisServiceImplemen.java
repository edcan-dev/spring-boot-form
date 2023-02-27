package dev.edcan.springboot.form.services;

import dev.edcan.springboot.form.models.domain.Pais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServiceImplemen implements PaisService {

    private final List<Pais> lista;

    public PaisServiceImplemen() {
        this.lista =Arrays.asList(
                new Pais(1,"MX","México"),
                new Pais(2,"AR","Argentina"),
                new Pais(3,"CL","Chile"),
                new Pais(4,"ES","España"),
                new Pais(5,"RS","Rusia"));
    }

    @Override
    public List<Pais> listar() {
        return lista;
    }

    @Override
    public Pais obtenerPais(Integer id) {
        Pais resultado = null;
        for(Pais pais : this.lista) {
            if(id.equals(pais.getId())) { resultado = pais;
            break;
            }
        }
        return resultado;
    }
}
