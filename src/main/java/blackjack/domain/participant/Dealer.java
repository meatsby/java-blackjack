package blackjack.domain.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.Number;
import java.util.List;

public class Dealer extends Participant {

    public static final int MAX_RECEIVABLE_SCORE = 17;

    public Dealer(Name name) {
        super(name);
    }

    @Override
    public boolean isReceivable() {
        return calculateBestScore() < MAX_RECEIVABLE_SCORE;
    }

    @Override
    public int calculateBestScore() {
        List<Card> cards = this.cards.getCardHand();

        int sum = cards.stream()
                .map(Card::getNumber)
                .map(number -> {
                    if (number.getScore() == Number.ACE.getScore()) {
                        return number.getScore() + ACE_ADDITIONAL_NUMBER;
                    }
                    return number.getScore();
                })
                .reduce(0, Integer::sum);

        return adjustBustedScore(cards, sum);
    }

    private int adjustBustedScore(List<Card> cards, int sum) {
        if (sum > BUST_THRESHOLD) {
            for (Card card : cards) {
                sum = getLowest(sum, card);
            }
        }
        return sum;
    }

    private int getLowest(int sum, Card card) {
        if (card.isAce()) {
            sum -= ACE_ADDITIONAL_NUMBER;
        }
        return sum;
    }
}
