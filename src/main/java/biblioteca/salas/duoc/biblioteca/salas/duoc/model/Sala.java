package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionIdMutability;

@Entity
@Table(name = "Sala")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer codigo;

    @Column(nullable = false, length = 50)
    public String nombre;

    @Column()
    private Integer capacidad;

    @Column(nullable = false)
    private Integer idInsituto;

    @Column(nullable = false)
    private Integer idTipo;

}
