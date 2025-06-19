package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.CarreraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carrera")
@Tag(name = "Servicios de carreras", description = "Servicios para poder consultar información de las carreras disponibles en la plataforma")
public class CarreraController {

    @Autowired
    CarreraService carreraService;

    @GetMapping("/")
    @Operation(summary = "Obtener todas las carreras", description = "Obtiene una lista de todas las carreras con sus respectivos códigos.")
    public ResponseEntity<?> listarCarreras(){
        return ResponseEntity.status(200).body(carreraService.findAll());
    }

    @GetMapping("{codigo}")
    @Operation(summary = "Obtener una carrera por su código", description = "Utilizando el código de la carrera puedes obtener su información.")
    public ResponseEntity<?> buscarCarrera(@PathVariable String codigo){
        return ResponseEntity.status(200).body(carreraService.findByCodigo(codigo));
    }

}
