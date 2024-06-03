import java.util.List;
import java.util.ArrayList;

class VariableLengthQuantity {

    List<String> encode(List<Long> numbers) {
        List<String> result = new ArrayList<>();
        for (Long number: numbers) {
            StringBuilder stringValue = new StringBuilder(Long.toBinaryString(number));
            addZeros(stringValue);
            for (int i = stringValue.length(); i >= 7; i -= 7) {
                if (i == stringValue.length()) {
                    stringValue.insert(i - 7, 0);
                } else {
                    stringValue.insert(i - 7, 1);
                }
            }
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < stringValue.length(); i += 8) {
                result.add("0x" + Long.toHexString(Long.parseLong(stringValue.substring(i, i + 8), 2)));
            }
        }
        return result;
    }

    List<String> decode(List<Long> bytes) {
        if ((bytes.getLast() & 0b10000000) == 0b10000000) {
            throw new IllegalArgumentException("Invalid variable-length quantity encoding");
        }

        List<String> decrypted = new ArrayList<>();
        for (int i = 0; i < bytes.size(); i++) {
            StringBuilder wholeNumber = new StringBuilder();

            while ((bytes.get(i) & 0b10000000) == 0b10000000) {
                wholeNumber.append(getByte(bytes.get(i++)));
            }

            wholeNumber.append(getByte(bytes.get(i)));
            long number = Long.parseLong(wholeNumber.toString(), 2);
            decrypted.add("0x" + Long.toHexString(number));
        }

        return decrypted;
    }

    private StringBuilder getByte(long number) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(number & 0b1111111));
        while (sb.length() % 7 != 0) {
            sb.insert(Math.max(sb.length() - 7, 0), 0);
        }
        return sb;
    }

    private void addZeros(StringBuilder sb) {
        while (sb.length() % 7 != 0) {
            sb.insert(0, 0);
        }
    }
}