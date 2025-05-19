package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createLottos(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
        }
        return new Lottos(lottoList);
    }

    public LottoResult getMatchResults(WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

        for (Lotto lotto : lottos) {
            Optional<LottoRank> matchResult = winningLotto.getMatchResult(lotto);
            matchResult.ifPresent(
                    rank -> rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1)
            );
        }
        return new LottoResult(rankCounts);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
