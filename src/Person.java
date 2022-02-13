import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private OptionalInt age;
    private Optional<String> address;

     Person(String name, String surname, OptionalInt age, Optional<String> address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

     public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address.isPresent();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (age.isPresent()) { return age.getAsInt(); }
        throw new NoSuchElementException("Возраст неизвестен!");
    }

    public String getAddress() {
        if (address.isPresent()) { return address.get();}
        throw new NoSuchElementException("Адрес неизвестен!");
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public PersonBuilder newChildBuilder(int age) {
        return new PersonBuilder()
                .setSurname(getSurname())
                .setAge(age)
                .setAddress(getAddress());
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + getAge() + ", " + getAddress();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; };
        if (!(o instanceof Person person)) { return false; }
        return Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(),
               person.getSurname()) && Objects.equals(getAge(),
               person.getAge()) && Objects.equals(getAddress(),
               person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAddress());
    }

}
