package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateNumbersInRange(numbers);
        validateNumbersNoDuplicate(numbers);
    }

    private static void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호의 숫자 범위는 1부터 45까지 입니다.");
            }
        }
    }

    private void validateNumbersNoDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복된 번호가 있으면 안됩니다.");
        }
    }
}
