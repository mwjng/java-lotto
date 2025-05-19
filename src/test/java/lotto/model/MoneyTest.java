package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 금액이_음수면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_1000의_배수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}