package lotto.model;

public class Money {

    private final long amount;

    public Money(long amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public long getAmount() {
        return this.amount;
    }

    private void validateAmount(long amount) {
        validateAmountPositive(amount);
        validateAmountUnit(amount);
    }

    private void validateAmountPositive(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 양수여야 합니다.");
        }
    }

    private void validateAmountUnit(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }
}
