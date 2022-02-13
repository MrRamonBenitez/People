import java.util.Optional;
import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private Optional<String> address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
            if (age < 0) {
                throw new IllegalArgumentException("Значение возраста не должны быть меньше нуля!");
            }
            this.age = OptionalInt.of(age);
            return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = Optional.of(address);
        return this;
    }

    Person build() {
        if (name == null || surname == null || !age.isPresent() || !address.isPresent()) {
            throw new IllegalStateException("Не указаны необходимые параметры!");
        }
        return new Person(name, surname, age, address);
    }
}
