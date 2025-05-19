package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_범위가_벗어난_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 60), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_번호가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호의_숫자가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 60))
                .isInstanceOf(IllegalArgumentException.class);
    }
}