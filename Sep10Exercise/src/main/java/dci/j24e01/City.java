package dci.j24e01;

public record City(
        Long id,
        String name,
        String countryCode,
        String district,
        Integer population
) {
    @Override
    public String toString() {
        return "id: " + id +
                "\nname: " + name +
                "\ncountryCode: " + countryCode +
                "\ndistrict: " + district +
                "\npopulation: " + population;
    }
}
