import java.util.List;
import java.util.ArrayList;

class Allergies {
    List<Allergen> list;
    Allergies(int score) {
        list = new ArrayList<>();
        for (int i = 0; i < Allergen.values().length; i++) {
            if ((score & (1 << i)) == 1 << i) {
                list.add(Allergen.values()[i]);
            }
        }
    }

    boolean isAllergicTo(Allergen allergen) {
        return list.contains(allergen);
    }

    List<Allergen> getList() {
        return list;
    }
}
