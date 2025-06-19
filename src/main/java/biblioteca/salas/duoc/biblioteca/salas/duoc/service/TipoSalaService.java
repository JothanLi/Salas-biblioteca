package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.TipoSalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TipoSalaService {
    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    public List<TipoSala> findAll(){
        return tipoSalaRepository.findAll();
    }

    public TipoSala findByIdTipoSala(Integer idTipo){
        return tipoSalaRepository.findByIdTipoSala(idTipo);
    }

}
