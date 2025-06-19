package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.service.TipoSalaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tipo_sala")
@Tag(name = "Tipos de Sala", description = "Aquí podrás visualizar los distintos tipos de sala con los que disponemos.")
public class TipoSalaController {

    @Autowired
    private TipoSalaService tipoSalaService;

    @GetMapping("/")
    @Operation(summary = "Listar todos los tipos de Salas.")
    public ResponseEntity<?> listarTiposDeSalas(){
        return ResponseEntity.status(200).body(tipoSalaService.findAll());
    }

    @GetMapping("/{idTipo}")
    @Operation(summary = "Listar un tipo sala según su código.")
    public ResponseEntity<?> listarTipoSalaPorId(@PathVariable Integer idTipo){
        return ResponseEntity.status(200).body(tipoSalaService.findByIdTipoSala(idTipo));
    }

}
