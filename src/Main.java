public class Main {
    public static void main(String[] args) {
        // Skapa en klass som representerar en kortlek (max 52 kort)
        //  - array med kort
        //  - antal kort i kortleken för tillfället
        //
        // Skapa två kortlekar (två objekt)
        //  - alla klöver
        //  - alla klädda kort

        Deck d1 = new Deck();
        for (int i=0; i < 13; i++) {
            Card c = new Card();
            c.suit = Card.CLUBS;
            c.rank = (i+1);
            d1.cards[i] = c;
            d1.count++;
        }

//        for (int i=0; i < d1.count; i++) {
//            System.out.println(d1.cards[i]);
//        }

        Deck d2 = new Deck();
        int pos = 0;
        for (int suit=0; suit < 4; suit++) {
            for (int rank=11; rank <= 13; rank++) {
                Card c = new Card();
                c.suit = suit;
                c.rank = rank;
                d2.cards[pos] = c;
                d2.count++;
                pos++;
            }
        }

        for (int i=0; i < d2.count; i++) {
            System.out.println(d2.cards[i]);
        }

    }
}

class Deck {
    Card[] cards = new Card[52];
    int count;
}

class Card {
    static final int CLUBS = 0;
    static final int DIAMONDS = 1;
    static final int HEARTS = 2;
    static final int SPADES = 3;
    static String[] suits = {"Klöver", "Ruter", "Hjärter", "Spader"};
    static String[] ranks = {
            "ess", "två", "tre", "fyra", "fem", "sex", "sju",
            "åtta", "nio", "tio", "knekt", "dam", "kung"
    };

    int suit;
    int rank;

    @Override
    public String toString() {
        return suits[suit] + " " + ranks[rank-1];
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Card c) {
            return suit == c.suit && rank == c.rank;
        }
        return false;
    }

    void change(int suit, int rank) {
        if ((suit >= 0 && suit <= 3) && (rank >= 0 && rank <= 13)) {
            this.suit = suit;
            this.rank = rank;
        } else {
            throw new IllegalArgumentException("Felaktigt kort");
        }
    }
}