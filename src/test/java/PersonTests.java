import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PersonTests {
    Person person;

    @BeforeEach
    public void setPerson() {
        person = new Person("John", "Smith", 42, Sex.MAN, Education.HIGHER);
    }

    @Test
    public void getNameTest() {
        String expected = "John";
        String result = person.getName();

        Assertions.assertEquals(expected, result);

        assertThat(expected, is(person.getName())); //hamcrest

    }

    @Test
    public void getFamilyTest() {
        String expected = "Smith";
        String result = person.getFamily();

        Assertions.assertEquals(expected, result);

        assertThat(expected, is(person.getFamily())); //hamcrest

    }

    @Test
    public void getAgeTest() {
        int expected = 42;
        int result = person.getAge();


        Assertions.assertEquals(expected, result);

        assertThat("get age test", person.getAge(), equalTo(expected)); //hamcrest


    }

    @Test
    public void getSexTest() {
        Sex expected = Sex.MAN;
        Sex result = person.getSex();

        Assertions.assertEquals(expected, result);

        assertThat("get age sex", person.getSex(), equalTo(expected)); //hamcrest

    }

    @Test
    public void getEducationTest() {
        Education expected = Education.HIGHER;
        Education result = person.getEducation();

        Assertions.assertEquals(expected, result);

        assertThat("get age sex", person.getEducation(), equalTo(expected)); //hamcrest


    }
}
