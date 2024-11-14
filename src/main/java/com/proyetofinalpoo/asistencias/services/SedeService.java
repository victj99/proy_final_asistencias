package com.proyetofinalpoo.asistencias.services;

import com.proyetofinalpoo.asistencias.entities.Sede;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyetofinalpoo.asistencias.models.ListItem;
import com.proyetofinalpoo.asistencias.repository.SedeRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class SedeService implements CrudBase<Sede> {

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public List<Sede> listarTodosDatos() {
        return sedeRepository.findAll();
    }

    @Override
    public void registrarDatos(Sede entity) {
    }

    @Override
    public void actualizarDatos(Sede entity) {
    }

    @Override
    public Sede obtenerPorId(Long id) {
        return null;
    }

    public List<ListItem> listarListItemSede(String filtro) {
        List<Sede> Sedes = sedeRepository.listarSedesPorNombre(filtro);

        List<ListItem> datosRespuesta = new ArrayList<>();

        for (Sede item : Sedes) {
            String textoAMostrar = item.getNombre();
            datosRespuesta.add(new ListItem(item.getIdSede(), textoAMostrar));
        }
        return datosRespuesta;
        
        // Si quieres hacerlo mas corto puedes usar streams como la siguiente linea
        // return Sedes.stream().map(item -> new ListItem(item.getIdSede(), item.getNombre() + " - " + item.getRuc())).toList();
    }
}
