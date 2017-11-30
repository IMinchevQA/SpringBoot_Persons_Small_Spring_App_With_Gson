package app.terminal;

import app.domain.dto.PersonDto;
import app.domain.model.Person;
import app.io.JSONParser;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.stream.Stream;


@Component
public class Terminal implements CommandLineRunner {

    /**
     * Path personsInput.json must be defined starting, and resources is considered as a base directory.
     * Wrong - "src/main/resources/personsInput.json"
     * CORRECT = "/personsInput.json"
     * Why ? - Because getClass().getResourceAsStream() used in FileIOUtil.java considers resources folder as a base folder.
     */
    private static final String PERSONS_RESOURCE_PATH = "/personsInput.json";

    @Autowired
    private PersonService personService;

    @Autowired
    private JSONParser jsonParser;

// Next row is for test purposes.
//    private Gson gson;


    public Terminal(){
    }

    @Override
    public void run(String... strings) throws Exception {
        /** //Code for reading from Json file.
        PersonDto[] personDto = this.jsonParser.importJson(PersonDto[].class, PERSONS_RESOURCE_PATH);
        Stream.of(personDto).forEach(pDto -> this.personService.create(pDto));
         */

        /**
         * Code bellow is for writing in json file.
         */
        PersonDto dto = this.personService.findById(1);
        this.jsonParser.outputJson(dto, "src/main/resources/personsOutput.json");
    }
}


// Code for test purposes
//        gson = new GsonBuilder().create();
//        InputStream pathToFile = new FileInputStream("src/main/resources/users.json");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(pathToFile));
//
//        User[] users = gson.fromJson(reader, User[].class);
//        Stream.of(users).forEach(u -> System.out.println(u));
