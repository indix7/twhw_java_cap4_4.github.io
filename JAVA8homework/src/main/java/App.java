import entity.MasterNumber;
import entity.Person;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        //TODO: print Person data that masterNumber is 1 and 2
        // print Person data that masterNumber is 3

        printPersonByMasterNumbers(personService, new String[]{"1", "2"});
        printPersonByMasterNumbers(personService, new String[]{"3"});
    }

    public static void printPersonByMasterNumbers(PersonService personService, String[] arrays) {
        List<MasterNumber> collect = Arrays.stream(arrays).map(MasterNumber::new).collect(Collectors.toList());
        List<Person> personByMasterNumbers = personService.getPersonByMasterNumbers(collect).collect(Collectors.toList());
        if (personByMasterNumbers.isEmpty()) {
            System.out.println(collect + "不存在");
            return;
        }
        for (Person person : personByMasterNumbers) {
            System.out.println(person);
        }
    }
}
