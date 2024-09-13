package dci.j24e01.pokeapi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SearchTable {
    public SearchTable() throws IOException, URISyntaxException {

        String pokemons = Files.readAllBytes(Path.of(SearchTable.class.getResourceAsStream("pokemons.txt").toURI())).toString();
        System.out.println(pokemons);
        String[] pokemonsList = pokemons.split("\n");

        for (int i = 0; i < pokemonsList.length; i++) {
            if (i < 1024) {
                PokeApi.getPokemons().add(new Pokemon(i + 1, pokemonsList[i]));
            } else {
                PokeApi.getPokemons().add(new Pokemon(i + 8975, pokemonsList[i]));
            }
        }

    }
}
