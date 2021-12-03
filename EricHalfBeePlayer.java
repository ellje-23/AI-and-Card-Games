package nothanks.player;

import sortedlist.SortedList;
import java.util.List;

public class EricHalfBeePlayer implements Player {
    // The number of rounds that have gone by
    private int numRounds;

    public EricHalfBeePlayer() {
        numRounds = 0;
    }

    public boolean offeredCard(int cardNumber, int chipsOnCard, List<SortedList<Integer>> playersHands, int myPlayerNum, int myChips) {

        // Get a sorted list of my cards.
        SortedList<Integer> myCards = playersHands.get(myPlayerNum);

        // I must take the card if I have no chips.
        if (myChips == 0) {
            return true;
        }
        // If there are more chips on the card than the number of the card itself, take the card
        if (chipsOnCard >= cardNumber) {
            return true;
        }
        // If there are about half the number of chips on the card than the number of the card itself, take the card
        if (chipsOnCard >= (cardNumber / 2)) {
            return true;
        }
        // If there are more than 12 chips on the card, take the card
        if (chipsOnCard > 12) {
            return true;
        }

        // Running though my opponent's hands
        for (int i = 0; i < playersHands.size(); i++) {
            if (i == myPlayerNum) {
                continue;
            }
            // If the card on offer will extend my sequence and no one elses, pass it around once to get more chips
            if ((!(playersHands.get(i).contains(cardNumber - 1)) && !(playersHands.get(i).contains(cardNumber + 1))) && ((myCards.contains(cardNumber - 1)) || (myCards.contains(cardNumber + 1)))) {
                if (numRounds < 1) {
                    numRounds += 1;
                    return false;
                }
                if (numRounds == 1) {
                    numRounds = 0;
                    return true;
                }
            }
        }
        // Running through my hand to see if I would get a sequence if I took the card
        for (int i = 0; i < myCards.size(); i++) {
            if ((myCards.contains(cardNumber - 1)) || (myCards.contains(cardNumber + 1))) {
                // If the card is a big number and would give me a sequence send it around twice to get more chips
                if ((cardNumber >= 25) && (numRounds < 2)) {
                    numRounds += 1;
                    return false;
                }
                // The card has been around twice, take the card
                if ((cardNumber >= 25) && (numRounds == 2)) {
                    numRounds = 0;
                    return true;
                }
                return true;
            }
        }
        // If none of the above, don't take the card
        return false;
    }
}
