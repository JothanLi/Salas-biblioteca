package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="TipoSalas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;

    @Column(nullable = false, length = 30)
    private String nombre;

    @OneToMany(mappedBy = "tipoSala", cascade = CascadeType.ALL)
    private List<Sala> salas;

}
