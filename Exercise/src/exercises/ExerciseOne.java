package exercises;

import exercises.models.Person;
import java.util.List;

public class ExerciseOne {

    public static void main(String args[]) {
        List<Person> roster = Person.createRoster();
        
        //Write the following enhanced "for" statement as a pipeline with lambda expressions. 
        //Hint: Use the filter intermediate operation and the forEach terminal operation.
        for (Person p : roster) {
            if (p.getGender() == Person.Sex.MALE) {
                System.out.println(p.getName());
            }
        }
    }
}
