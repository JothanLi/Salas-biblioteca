package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carreras")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carrera {

    @Id
    @Column(length = 100)
    private String codigo;

    @Column(length = 100)
    private String nombre;

}
