package lotto.io;

import java.util.Arrays;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
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

    public void requestWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showWinningStatus(LottoResult result, long purchaseAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(LottoRank.values())
                .forEach(rank -> System.out.println(rank.getMessage() + result.getRankCount(rank) + "개"));

        double yield = result.getYield(purchaseAmount);
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }

    public void showErrorMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
