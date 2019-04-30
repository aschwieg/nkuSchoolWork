import java.util.*;

public class Game {
    private ArrayList<Card> blackCardHand;
    private ArrayList<Card> whiteCardHand;

    public Game(String[] black, String[] white) {
        blackCardHand = new ArrayList<Card>();
        whiteCardHand = new ArrayList<Card>();

        for (int i = 0; i < 5; i++) {
            blackCardHand.add(new Card(black[i]));
            whiteCardHand.add(new Card(white[i]));
        }
        Collections.sort(blackCardHand);
        Collections.sort(whiteCardHand);
    }

    public String getWinner() {
        boolean hasStraightFlushBlack = hasStraightFlush(blackCardHand),
                hasStraightFlushWhite = hasStraightFlush(whiteCardHand),
                hasFourOfAKindBlack = hasFourOfAKind(blackCardHand),
                hasFourOfAKindWhite = hasFourOfAKind(whiteCardHand),
                hasFullHouseBlack = hasFullHouse(blackCardHand),
                hasFullHouseWhite = hasFullHouse(whiteCardHand),
                hasStraightBlack = hasStraight(blackCardHand),
                hasStraightWhite = hasStraight(whiteCardHand),
                hasFlushBlack = hasFlush(blackCardHand),
                hasFlushWhite = hasFlush(whiteCardHand),
                hasThreeOfAKindBlack = hasThreeOfAKind(blackCardHand),
                hasThreeOfAKindWhite = hasThreeOfAKind(whiteCardHand),
                hasTwoPairBlack = hasTwoPair(blackCardHand),
                hasTwoPairWhite = hasTwoPair(whiteCardHand),
                hasPairBlack = hasPair(blackCardHand),
                hasPairWhite = hasPair(whiteCardHand);

        if (hasStraightFlushBlack || hasStraightFlushWhite) {
            return checkWin(hasStraightFlushBlack, hasStraightFlushWhite);
        }
        else if (hasFourOfAKindBlack || hasFourOfAKindWhite) {
            return checkMatchWin(hasFourOfAKindBlack, hasFourOfAKindWhite);
        }
        else if (hasFullHouseBlack || hasFullHouseWhite) {
            if (hasFullHouseBlack && hasFullHouseWhite) {
                int threeOfKindRankWhite = 0, threeOfKindRankBlack = 0;
                for (int i = 2; i < 5; i++) {
                    if ((blackCardHand.get(i)).rank == (blackCardHand.get(i - 1)).rank && (blackCardHand.get(i)).rank == (blackCardHand.get(i - 2)).rank) {
                        threeOfKindRankBlack = (blackCardHand.get(i)).rank;
                    }
                    if ((whiteCardHand.get(i)).rank == (whiteCardHand.get(i - 1)).rank && (whiteCardHand.get(i)).rank == (whiteCardHand.get(i - 2)).rank) {
                        threeOfKindRankWhite = (whiteCardHand.get(i)).rank;
                    }
                }

                if (threeOfKindRankBlack > threeOfKindRankWhite) {
                    return "Black";
                }
                else {
                    return "White";
                }
            }
            if (hasFullHouseWhite) {
                return "White";
            }
            else {
                return "Black";
            }
        }
        else if (hasStraightBlack || hasStraightWhite) {
            return checkWin(hasStraightBlack, hasStraightWhite);
        }
        else if (hasFlushBlack || hasFlushWhite) {
            return checkWin(hasFlushBlack, hasFlushWhite);
        }
        else if (hasThreeOfAKindBlack || hasThreeOfAKindWhite) {
            return checkMatchWin(hasThreeOfAKindBlack, hasThreeOfAKindWhite);
        }
        else if (hasTwoPairBlack || hasTwoPairWhite) {
            if (hasTwoPairBlack && hasTwoPairWhite) {
                Card firstPairRankBlack = blackCardHand.get(0), firstPairRankWhite = whiteCardHand.get(0), secondPairRankBlack = blackCardHand.get(0), secondPairRankWhite = whiteCardHand.get(0);
                int pairRankBlack = 0, pairRankWhite = 0;
                for (int i = 1; i < 5; i++) {
                    if ((blackCardHand.get(i)).rank == (blackCardHand.get(i - 1)).rank && blackCardHand.get(i).rank != pairRankBlack) {
                        if (pairRankBlack != 0) {
                            secondPairRankBlack = blackCardHand.get(i);
                        }
                        else {
                            pairRankBlack = blackCardHand.get(i).rank;
                            firstPairRankBlack = blackCardHand.get(i);
                        }
                    }
                    if ((whiteCardHand.get(i)).rank == (whiteCardHand.get(i - 1)).rank && whiteCardHand.get(i).rank != pairRankWhite) {
                        if (pairRankWhite != 0) {
                            secondPairRankWhite = whiteCardHand.get(i);
                        }
                        else {
                            pairRankWhite = whiteCardHand.get(i).rank;
                            firstPairRankWhite = whiteCardHand.get(i);
                        }
                    }
                }
                if (secondPairRankBlack.rank == secondPairRankWhite.rank) {
                    if (firstPairRankBlack.rank == firstPairRankWhite.rank) {
                        int highCardBlack = 0, highCardWhite = 0;
                        for (int i = 0; i < 5; i++) {
                            if(whiteCardHand.get(i).rank != firstPairRankWhite.rank && whiteCardHand.get(i).rank != secondPairRankWhite.rank) {
                                highCardWhite = whiteCardHand.get(i).rank;
                            }
                            if(blackCardHand.get(i).rank != firstPairRankBlack.rank && blackCardHand.get(i).rank != secondPairRankBlack.rank) {
                                highCardBlack = blackCardHand.get(i).rank;
                            }
                        }
                        if (highCardBlack == highCardWhite) {
                            return "Draw";
                        }
                        else if (highCardWhite > highCardBlack) {
                            return "White";
                        }
                        else {
                            return "Black";
                        }
                    }
                    else if (firstPairRankWhite.rank > firstPairRankBlack.rank) {
                        return "White";
                    }
                    else {
                        return "Black";
                    }
                }
                else if (secondPairRankWhite.rank > secondPairRankBlack.rank) {
                    return "White";
                }
                else {
                    return "Black";
                }

            }
            if (hasTwoPairWhite) {
                return "White";
            }
            else {
                return "Black";
            }
        }
        else if (hasPairBlack || hasPairWhite) {
            return checkMatchWin(hasPairBlack, hasPairWhite);
        }
        else {
            if (blackCardHand.get(4).rank == whiteCardHand.get(4).rank) {
                return "Draw";
            }
            else if (blackCardHand.get(4).rank > whiteCardHand.get(4).rank) {
                return "Black";
            }
            else {
                return "White";
            }
        }
    }

    private String checkWin(boolean blackWinCondition, boolean whiteWinCondition) {
        if (blackWinCondition && whiteWinCondition) {
            if(blackCardHand.get(4).rank == whiteCardHand.get(4).rank) {
                return "Draw";
            }
            else if (blackCardHand.get(4).rank > whiteCardHand.get(4).rank) {
                return "Black";
            }
            else {
                return "White";
            }
        }

        if (whiteWinCondition) {
            return "White";
        }
        else {
            return "Black";
        }
    }

    private String checkMatchWin(boolean blackWinCondition, boolean whiteWinCondition) {
        Card firstMatchBlack = blackCardHand.get(0),
                secondMatchBlack = blackCardHand.get(0),
                firstMatchWhite = whiteCardHand.get(0),
                secondMatchWhite = whiteCardHand.get(0);

        if (blackWinCondition && whiteWinCondition) {
            for (int i = 1; i < 5; i++) {
                if ((blackCardHand.get(i)).rank == (blackCardHand.get(i - 1)).rank) {
                    firstMatchBlack = blackCardHand.get(i);
                    secondMatchBlack = blackCardHand.get(i-1);
                }
                if ((whiteCardHand.get(i)).rank == (whiteCardHand.get(i - 1)).rank) {
                    firstMatchWhite = whiteCardHand.get(i);
                    secondMatchWhite = whiteCardHand.get(i-1);
                }
            }
            if(firstMatchBlack.rank == firstMatchWhite.rank) {
                blackCardHand.remove(firstMatchBlack);
                blackCardHand.remove(secondMatchBlack);
                whiteCardHand.remove(firstMatchWhite);
                whiteCardHand.remove(secondMatchWhite);

                System.out.println(this.print());

                Collections.sort(blackCardHand);
                Collections.sort(whiteCardHand);
                if (blackCardHand.get(2).rank == whiteCardHand.get(2).rank) {
                    return "Draw";
                }
                else if (blackCardHand.get(2).rank > whiteCardHand.get(2).rank) {
                    return "Black";
                }
                else {
                    return "White";
                }
            }
            else if (firstMatchBlack.rank > firstMatchWhite.rank) {
                return "Black";
            }
            else {
                return "White";
            }
        }
        if (whiteWinCondition) {
            return "White";
        }
        else {
            return "Black";
        }
    }

    private boolean hasPair(ArrayList<Card> cardHand) {
        for (int i = 1; i < 5; i++) {
            if ((cardHand.get(i)).rank == (cardHand.get(i - 1)).rank) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTwoPair(ArrayList<Card> cardHand) {
        int firstPairRanks = 0;
        boolean foundTwoPair = false;
        for (int i = 1; i < 5; i++) {
            if ((cardHand.get(i)).rank == (cardHand.get(i - 1)).rank && cardHand.get(i).rank != firstPairRanks) {
                if(firstPairRanks != 0) {
                    foundTwoPair = true;
                }
                else {
                    firstPairRanks = cardHand.get(i).rank;
                }
            }
        }
        return foundTwoPair;
    }

    private boolean hasThreeOfAKind(ArrayList<Card> cardHand) {
        for (int i = 2; i < 5; i++) {
            if ((cardHand.get(i)).rank == (cardHand.get(i - 1)).rank && (cardHand.get(i)).rank == (cardHand.get(i - 2)).rank) {
                return true;
            }
        }
        return false;
    }

    private boolean hasFullHouse(ArrayList<Card> cardHand) {
        int threeOfKindRank = 0;
        boolean foundPair = false, foundThreeOfKind = false;
        for (int i = 2; i < 5; i++) {
            if ((cardHand.get(i)).rank == (cardHand.get(i - 1)).rank && (cardHand.get(i)).rank == (cardHand.get(i - 2)).rank) {
                foundThreeOfKind = true;
                threeOfKindRank = (cardHand.get(i)).rank;
            }
        }
        for (int i = 1; i < 5; i++) {
            if ((cardHand.get(i)).rank == (cardHand.get(i - 1)).rank && (cardHand.get(i)).rank != threeOfKindRank) {
                foundPair = true;
            }
        }

        if (foundPair && foundThreeOfKind) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean hasFourOfAKind(ArrayList<Card> cardHand) {
        for (int i = 3; i < 5; i++) {
            if ((cardHand.get(i)).rank == (cardHand.get(i - 1)).rank && (cardHand.get(i)).rank == (cardHand.get(i - 2)).rank && (cardHand.get(i)).rank == (cardHand.get(i - 3)).rank) {
                return true;
            }
        }
        return false;
    }

    private boolean hasStraightFlush(ArrayList<Card> cardHand) {
        if (hasStraight(cardHand) && hasFlush(cardHand)) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean hasFlush(ArrayList<Card> cardHand) {
        for (int i = 1; i < 5; i++) {
            if ((cardHand.get(i).suit) != (cardHand.get(i - 1).suit)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasStraight(ArrayList<Card> cardHand) {
        for (int i = 1; i < 5; i++) {
            if ((cardHand.get(i)).rank != (cardHand.get(i - 1)).rank + 1) {
                return false;
            }
        }
        return true;
    }

    public String print() {
        String returnString = "Black: ";
        for (int i = 0; i < blackCardHand.size(); i++) {
            returnString = returnString.concat((blackCardHand.get(i)).rank + "" + (blackCardHand.get(i)).suit + " ");
        }
        returnString = returnString.concat("\nWhite: ");
        for (int i = 0; i < whiteCardHand.size(); i++) {
            returnString = returnString.concat((whiteCardHand.get(i)).rank + "" + (whiteCardHand.get(i)).suit + " ");
        }

        return returnString;
    }
}
