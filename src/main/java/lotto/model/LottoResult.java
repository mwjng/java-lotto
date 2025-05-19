package lotto.model;

import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> rankCounts;

    public LottoResult(Map<LottoRank, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public double getYield(long purchaseAmount) {
        return (double) getTotalPrize() / purchaseAmount * 100;
    }

    public int getRankCount(LottoRank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    private long getTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
