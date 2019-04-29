import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerGameTest {

    @Test
    public void givenTwoHands_whenCreateGameWithTwoHands_thenGameCreated() {
        String[] black = {"2H","6D","5S","9C","AD"};
        String[] white = {"2H","6D","5S","9C","KD"};
        Game sut = new Game(black, white);
    }

    @Test
    public void givenStringJackOfHearts_whenCreateCard_thenCardReturnsElevenAndH() {
        Card sut = new Card("JH");

        assertEquals('H', sut.suit);
        assertEquals(11, sut.rank);
    }

    @Test
    public void givenTwoCards_whenCompareCards_thenHigherCardWins() {
        Card card1 = new Card("JH");
        Card card2 = new Card("TD");

        assertEquals(1, card1.compareTo(card2));
    }

    @Test
    public void givenTwoHands_whenPrintGame_thenReturnsSortedHands() {
        String[] black = {"AH","KH","QH","JH","TH"};
        String[] white = {"2H","6D","5S","9C","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black: 10H 11H 12H 13H 14H \nWhite: 2H 5S 6D 9C 13D ", sut.print());
    }

    @Test
    public void givenHandWithStraightFlush_whenScoreHands_thenHandWithStraightFlushWins() {
        String[] black = {"AH","KH","QH","JH","TH"};
        String[] white = {"2H","6D","5S","9C","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenTwoHandsWithStraightFlush_whenScoreHands_thenHandWithStraightFlushOfTheHigherCardWins() {
        String[] black = {"AH","KH","QH","JH","TH"};
        String[] white = {"9D","TD","JD","QD","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenHandWithHighCard_whenScoreHands_thenHighCardWins() {
        String[] black = {"2H","6D","5S","9C","AD"};
        String[] white = {"2H","6D","5S","9C","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenTwoHandsWithSameHighCard_whenScoreHands_thenTheGameIsADraw() {
        String[] black = {"2H","6D","5S","KC","AD"};
        String[] white = {"2H","6D","5S","QC","AD"};
        Game sut = new Game(black, white);

        assertEquals("Draw", sut.getWinner());
    }

    @Test
    public void givenHandWithPair_whenScoreHands_thenPairWins() {
        String[] black = {"2H","2D","5S","9C","AD"};
        String[] white = {"2H","6D","5S","9C","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenTwosHandWithSamePair_whenScoreHands_thenPairWithHighCardWins() {
        String[] black = {"2H","2D","5S","9C","AD"};
        String[] white = {"2H","2D","5S","9C","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenTwosHandWithDifferentPair_whenScoreHands_thenHighPairWins() {
        String[] black = {"3H","3D","5S","9C","KD"};
        String[] white = {"2H","2D","5S","9C","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenTwosHandWithThreeOfKind_whenScoreHands_thenHandWithHighThreeOfKindWins() {
        String[] black = {"3H","3D","3S","9C","AD"};
        String[] white = {"2H","2D","2S","9C","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenTwosHandWithFourOfKind_whenScoreHands_thenHandWithHighFourOfKindWins() {
        String[] black = {"3H","3D","3S","3C","AD"};
        String[] white = {"2H","2D","2S","2C","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenHandWithFourOfKindAndHandWithThreeOfKind_whenScoreHands_thenHandWithFourOfKindWins() {
        String[] black = {"3H","3D","3S","3C","AD"};
        String[] white = {"2H","2D","2S","AC","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenHandWithStraightAndHandWithPair_whenScoreHands_thenStraightWins() {
        String[] black = {"5H","6D","7S","8C","9D"};
        String[] white = {"2H","2D","6S","7C","KD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenHandWithStraightAndHandWithFullHouse_whenScoreHands_thenFullHouseWins() {
        String[] black = {"2H","2D","7S","7C","7D"};
        String[] white = {"5H","6D","7S","8C","9D"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenTwoHandsWithFullHouse_whenScoreHands_thenBiggerThreePairWins() {
        String[] black = {"2H","2D","7S","7C","7D"};
        String[] white = {"2H","2D","6S","6C","6D"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenTwoHandsWithFullHouseAndWhiteHasTheHighCard_whenScoreHands_thenWhiteWins() {
        String[] black = {"2H","2D","6S","6C","6D"};
        String[] white = {"2H","2D","7S","7C","7D"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }

    @Test
    public void givenWhiteHandsWithFullHouseAndBlackHandWithHighCard_whenScoreHands_thenWhiteWins() {
        String[] black = {"3H","2D","6S","JC","7D"};
        String[] white = {"2H","2D","7S","7C","7D"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }

    @Test
    public void givenHandWithTwoPairAndHandWithPair_whenScoreHands_thenTwoPairWins() {
        String[] black = {"2H","2D","7S","7C","AD"};
        String[] white = {"5H","5D","7S","8C","9D"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenHandWithTwoPairAndHandWithTwoPairWithSameHighCard_whenScoreHands_thenResultsInADraw() {
        String[] black = {"2H","2D","7S","7C","AD"};
        String[] white = {"2H","2D","7S","7C","AD"};
        Game sut = new Game(black, white);

        assertEquals("Draw", sut.getWinner());
    }

    @Test
    public void givenHandWithTwoPairAndHandWithTwoPairAndWhiteWithHighCard_whenScoreHands_thenWhiteWins() {
        String[] black = {"2H","2D","7S","7C","KD"};
        String[] white = {"2H","2D","7S","7C","AD"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }

    @Test
    public void givenHandWithTwoPairAndHandWithTwoPairAndSecondPairIsHigher_whenScoreHands_thenHighSecondPairWins() {
        String[] black = {"3H","3D","7S","7C","AD"};
        String[] white = {"2H","2D","7S","7C","AD"};
        Game sut = new Game(black, white);

        assertEquals("Black", sut.getWinner());
    }

    @Test
    public void givenHandWithTwoPairAndHandWithTwoPairAndWhiteHandSecondPairIsHigher_whenScoreHands_thenWhiteWins() {
        String[] black = {"2H","2D","7S","7C","AD"};
        String[] white = {"3H","3D","7S","7C","AD"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }

    @Test
    public void givenWhiteHandHighPairAndBlackHandWithPair_whenScoreHands_thenWhiteHandWins() {
        String[] black = {"2H","3D","8S","8C","JD"};
        String[] white = {"2H","3D","9S","9C","AD"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }

    @Test
    public void givenHandWithTwoPairAndHandWithTwoPairWithWhiteHighCard_whenScoreHands_thenWhiteHandWins() {
        String[] black = {"2H","2D","7S","7C","JD"};
        String[] white = {"2H","2D","7S","7C","AD"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }


    @Test
    public void givenWhiteHandWithHighCard_whenScoreHands_thenWhiteHandWins() {
        String[] black = {"2H","3D","7S","8C","KD"};
        String[] white = {"5H","3D","7S","8C","AD"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }

    @Test
    public void givenTwoHandsWithStraight_whenScoreHands_thenHighStraightHandWins() {
        String[] black = {"2H","3H","4H","5D","6H"};
        String[] white = {"3D","4D","5D","6H","7D"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }

    @Test
    public void givenTwoHandsWithTheSameStraightFlush_whenScoreHands_thenResultsInADraw() {
        String[] black = {"2H","3H","4H","5H","6H"};
        String[] white = {"2D","3D","4D","5D","6D"};
        Game sut = new Game(black, white);

        assertEquals("Draw", sut.getWinner());
    }

    @Test
    public void givenTwoHandsWithTheSameFlushAndWhiteHasHighCard_whenScoreHands_thenWhiteWins() {
        String[] black = {"2H","3H","KH","5H","6H"};
        String[] white = {"2D","3D","AD","5D","6D"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }

    @Test
    public void givenTwoHandsWithTheSamePairAndSameHighCard_whenScoreHands_thenResultsInDraw() {
        String[] black = {"2H","2H","AH","5H","6H"};
        String[] white = {"2D","2D","AD","5D","6D"};
        Game sut = new Game(black, white);

        assertEquals("Draw", sut.getWinner());
    }

    @Test
    public void givenTwoHandsWithTheSamePairAndWhiteHasHighCard_whenScoreHands_thenWhiteWins() {
        String[] black = {"2H","2H","KH","5H","6H"};
        String[] white = {"2D","2D","AD","5D","6D"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }

    @Test
    public void givenWhiteHandWithPair_whenScoreHands_thenWhiteWins() {
        String[] black = {"2H","3H","KH","5H","6H"};
        String[] white = {"2D","2D","AD","5D","6D"};
        Game sut = new Game(black, white);

        assertEquals("White", sut.getWinner());
    }

}
