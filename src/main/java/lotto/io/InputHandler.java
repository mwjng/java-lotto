package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.Money;

public class InputHandler {

    public Money getLottoPurchaseAmount() {
        String input = Console.readLine();
        long amount = Long.parseLong(input);
        return new Money(amount);
    }

    public List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        String[] splits = input.split(",");

        return Arrays.stream(splits)
                .map(Integer::parseInt)
                .toList();
    }
}
