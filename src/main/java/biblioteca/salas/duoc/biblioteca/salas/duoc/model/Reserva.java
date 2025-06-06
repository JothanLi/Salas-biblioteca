package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="Reserva")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public Integer idEstudiante;

    @Column(nullable = false)
    public Integer codigoSala;

    @Column(nullable = false)
    private Date fechaSolicitada;

    @Column(nullable = false)
    private Date horaReserva;

    @Column()
    private Date horaCierre;

    @Column(nullable = false)
    private Integer estado;

}
