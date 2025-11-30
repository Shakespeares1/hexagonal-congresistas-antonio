package com.congreso.ports;

import com.congreso.domain.Congresista;
import java.util.List;

public interface CongresistaServicePort {

    void crear(Congresista c);
    void actualizar(Congresista c);
    void eliminar(int id);
    Congresista buscarPorId(int id);
    List<Congresista> listar();
}
