package lotto;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.model.Money;

public class LottoGame {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        try {
            Money lottoPurchaseAmount = getLottoPurchaseAmount();
        } catch (IllegalArgumentException e) {
            outputHandler.showErrorMessage(e);
        }
    }

    private Money getLottoPurchaseAmount() {
        outputHandler.requestLottoPurchaseAmount();
        return inputHandler.getLottoPurchaseAmount();
    }
}
