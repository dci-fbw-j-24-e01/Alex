package dci.j24e01;

public record Person(
        Long id,
        String name,
        String city,
        Long age,
        String ageDescription
) {
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                (ageDescription == null ? "" : ", " + ageDescription) +
                '}';
    }
}
