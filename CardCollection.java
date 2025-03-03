import java.util.*;

class Card {
    String symbol;
    String number;

    Card(String symbol, String number) {
        this.symbol = symbol;
        this.number = number;
    }

    @Override
    public String toString() {
        return number + " of " + symbol;
    }
}

public class CardCollection {
    private static Map<String, List<Card>> cardMap = new HashMap<>();

    public static void addCard(String symbol, String number) {
        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(new Card(symbol, number));
    }

    public static void findCardsBySymbol(String symbol) {
        List<Card> cards = cardMap.get(symbol);
        if (cards == null || cards.isEmpty()) {
            System.out.println("No cards found for symbol: " + symbol);
        } else {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }

    public static void main(String[] args) {
        addCard("Hearts", "2");
        addCard("Hearts", "3");
        addCard("Spades", "K");
        addCard("Clubs", "10");
        addCard("Hearts", "A");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter symbol to find cards: ");
        String symbol = scanner.nextLine();
        findCardsBySymbol(symbol);
        scanner.close();
    }
}
