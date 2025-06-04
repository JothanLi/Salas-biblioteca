package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estudiantes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 9)
    private String run;

    @Column(nullable = false, unique = false, length = 100)
    private String nombres;

    @Column(unique = true, length = 100)
    private String correo;

    @Column(nullable = false, unique = false, length = 1)
    private Character jornada;

    @Column(nullable = true, unique = false, length = 10)
    private Integer telefono;

    @Column(nullable = false,unique = false, length = 100)
    private String codigoCarrera;
}
