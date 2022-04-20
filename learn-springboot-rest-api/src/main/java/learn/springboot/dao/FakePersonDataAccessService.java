package learn.springboot.dao;

import learn.springboot.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isPresent()){
            DB.remove(personMaybe.get());
            return 1;
        }else {
           return 0;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person personToUpdate) {
        return selectPersonById(id).map(person -> {
            int indexOfPersonToUpdate = DB.indexOf(person);
            System.out.println(indexOfPersonToUpdate);
            if(indexOfPersonToUpdate >=0){
                DB.set(indexOfPersonToUpdate,personToUpdate);
                return 1;
            } else {
                return 0;
            }
        }).orElse(0);

    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id))
                .findFirst();
    }

}
