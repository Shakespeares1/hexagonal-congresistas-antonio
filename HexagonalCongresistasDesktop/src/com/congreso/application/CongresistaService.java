package com.congreso.application;

import com.congreso.domain.Congresista;
import com.congreso.ports.CongresistaRepository;
import com.congreso.ports.CongresistaServicePort;
import java.util.List;

public class CongresistaService implements CongresistaServicePort {

    private final CongresistaRepository repository;

    public CongresistaService(CongresistaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void crear(Congresista c) {
        // Aquí podríamos agregar validaciones antes de guardar
        repository.crear(c);
    }

    @Override
    public void actualizar(Congresista c) {
        repository.actualizar(c);
    }

    @Override
    public void eliminar(int id) {
        repository.eliminar(id);
    }

    @Override
    public Congresista buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    @Override
    public List<Congresista> listar() {
        return repository.listar();
    }
}
