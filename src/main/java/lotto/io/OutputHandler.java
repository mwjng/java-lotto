package lotto.io;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputHandler {

    public void requestLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showListPurchasedLotto(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.getLottoCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showErrorMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
