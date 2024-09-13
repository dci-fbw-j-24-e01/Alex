package dci.j24e01;

public record Country(
        String code,
        String name,
        String continent,
        String region,
        Double surfaceArea,
        Short indepYear,
        Long population,
        Float lifeExpectancy,
        Double gnp,
        Double oldGnp,
        String localName,
        String governmentForm,
        String headOfState,
        City capital,
        String code2
) {
    @Override
    public String toString() {
        return "code: " + code +
                "\nname: " + name +
                "\ncontinent: " + continent +
                "\nregion: " + region +
                "\nsurface area: " + surfaceArea +
                "\nindependence year: " + indepYear +
                "\npopulation: " + population +
                "\nlife expectancy: " + lifeExpectancy +
                "\ngnp: " + gnp +
                "\nold gnp: " + oldGnp +
                "\nlocalName: " + localName +
                "\ngovernment form: " + governmentForm +
                "\nhead of state: " + headOfState +
                "\ncapital: " + capital.name() +
                "\ncode2: " + code2;
    }
}
