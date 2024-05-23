class LuhnValidator {

    boolean isValid(String candidate) {

        candidate = candidate.replaceAll(" ", "");
        if (candidate.length() < 2) {
            return false;
        }
        int[] numbers = new int[candidate.length()];
        try {
            for (int i = 0; i < candidate.length(); i++) {
                numbers[i] = Integer.parseInt("" + candidate.charAt(i));
            }
        } catch (Exception e) {
            return false;
        }

        for (int i = numbers.length - 2; i >= 0; i -= 2) {
            numbers[i] *= 2;
            if (numbers[i] > 9) {
                numbers[i] -= 9;
            }
        }

        int sum = 0;

        for (int number: numbers) {
            sum += number;
        }

        if (sum % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }

}

