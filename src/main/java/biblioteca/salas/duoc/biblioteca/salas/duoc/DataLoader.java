package biblioteca.salas.duoc.biblioteca.salas.duoc;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TipoSalaRepository tipoSalaRepository;
    @Autowired
    private CarreraRepository carreraRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public void run(String... args) throws Exception {

        crearTiposSalas(5);
        generarCarreras(15);
        generarEstudiantes(150);
        crearSala(30);

    }

    private boolean crearTiposSalas(int cantidadTiposSalas) {
        Faker faker = new Faker();

        for (int i = 0; i < cantidadTiposSalas; i++) {
            TipoSala tipoSala = new TipoSala();
            tipoSala.setNombre(faker.book().genre());
            tipoSalaRepository.save(tipoSala);
        }
        return true;
    }

    private boolean generarCarreras(int cantidadCarreras) {
        Faker faker = new Faker();

        for (int i = 0; i < cantidadCarreras; i++) {
            Carrera carrera = new Carrera();
            carrera.setCodigo(faker.code().asin());
            carrera.setNombre(faker.educator().course());
            carreraRepository.save(carrera);
        }
        return true;
    }

    private boolean generarEstudiantes(int cantidadEstudiantes){
        Faker faker = new Faker();
        Random random = new Random();
        List<Carrera> carreras = carreraRepository.findAll();

        for (int i = 0; i < cantidadEstudiantes; i++) {
            Estudiante estudiante = new Estudiante();
            String numeroRun = faker.idNumber().valid();
            numeroRun = numeroRun.replace("-", "");
            numeroRun = numeroRun.substring(0, 8);
            estudiante.setRun(numeroRun);
            estudiante.setNombre(faker.name().fullName());
            estudiante.setCorreo(faker.internet().emailAddress());
            estudiante.setJornada(faker.options().option("D", "V").charAt(0));
            estudiante.setTelefono(faker.number().numberBetween(100000000, 999999999));
            estudiante.setCarrera(carreras.get(random.nextInt(carreras.size())));
            estudianteRepository.save(estudiante);
        }
        return true;
    }

    private boolean crearSala(int cantidadSalas){
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < cantidadSalas; i++) {
            Sala sala = new Sala();
            sala.setNombre(faker.university().name());
            sala.setCapacidad(faker.number().numberBetween(10, 100));
            sala.setIdInstituto(faker.number().randomDigit());
            sala.setTipoSala(tipoSalaRepository.findAll().get(random.nextInt(3)));
            salaRepository.save(sala);
        }
        return true;
    }

}