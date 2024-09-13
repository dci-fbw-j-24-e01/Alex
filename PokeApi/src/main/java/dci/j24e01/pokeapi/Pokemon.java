package dci.j24e01.pokeapi;

public record Pokemon(int id, String name) {
    public String toString() {
        System.out.println(id + " " + name);
        return id + " " + Character.toUpperCase(name.charAt(0)) + name.substring(1);

    }
}
