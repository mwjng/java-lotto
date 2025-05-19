package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Money;

public class InputHandler {

    public Money getLottoPurchaseAmount() {
        String input = Console.readLine();
        long amount = Long.parseLong(input);
        return new Money(amount);
    }
}
