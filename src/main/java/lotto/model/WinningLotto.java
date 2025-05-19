package lotto.model;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winNumbers, int bonusNumber) {
        validateWinNumbers(winNumbers);
        this.winNumbers = winNumbers;

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateWinNumbers(List<Integer> winNumbers) {
        validateWinNumbersLength(winNumbers);
        validateWinNumbersInRange(winNumbers);
        validateWinNumbersNoDuplicate(winNumbers);
    }

    private void validateWinNumbersLength(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateWinNumbersInRange(List<Integer> winNumbers) {
        for (int winNumber : winNumbers) {
            if (winNumber < 1 || winNumber > 45) {
                throw new IllegalArgumentException("로또 번호의 숫자 범위는 1부터 45까지 입니다.");
            }
        }
    }

    private void validateWinNumbersNoDuplicate(List<Integer> winNumbers) {
        long distinctCount = winNumbers.stream().distinct().count();
        if (distinctCount != winNumbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복된 번호가 있으면 안됩니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumberInRange(bonusNumber);
        validateNoDuplicateWithBonus(bonusNumber);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호의 숫자 범위는 1부터 45까지 입니다.");
        }
    }

    private void validateNoDuplicateWithBonus(int bonusNumber) {
        if (this.winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 로또 번호와 중복되면 안됩니다.");
        }
    }

    private int getMatchCount(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(this.winNumbers::contains)
                .count();
    }
}
