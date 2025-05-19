package lotto;

import java.util.List;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningLotto;

public class LottoGame {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        try {
            Money lottoPurchaseAmount = getLottoPurchaseAmount();
            Lottos lottos = purchaseLottos(lottoPurchaseAmount);
            outputHandler.showListPurchasedLotto(lottos);

            LottoResult lottoResult = lottos.getMatchResults(getWinningLotto());
            outputHandler.showWinningStatus(lottoResult, lottoPurchaseAmount.getAmount());
        } catch (IllegalArgumentException e) {
            outputHandler.showErrorMessage(e);
        }
    }

    private Money getLottoPurchaseAmount() {
        outputHandler.requestLottoPurchaseAmount();
        return inputHandler.getLottoPurchaseAmount();
    }

    private Lottos purchaseLottos(Money lottoPurchaseAmount) {
        int lottoCount = (int) (lottoPurchaseAmount.getAmount() / 1000);
        return Lottos.createLottos(lottoCount);
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        outputHandler.requestWinningNumbers();
        return inputHandler.getWinningNumbers();
    }

    private int getBonusNumber() {
        outputHandler.requestBonusNumber();
        return inputHandler.getBonusNumber();
    }
}
