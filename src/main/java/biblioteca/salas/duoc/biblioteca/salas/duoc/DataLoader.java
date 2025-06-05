package biblioteca.salas.duoc.biblioteca.salas.duoc;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.*;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Profile("Jonathan")
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private CarreraRepository carreraRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    @Override
    public void run(String... Args) throws Exception{
        Faker faker = new Faker();
        Random random = new Random();

        for(i=0) in (TipoSala.getIdTipo){
            TipoSala tipoSala = new TipoSala();
            tipoSala.setNombre(faker.book().genre());

        }
    }
}
