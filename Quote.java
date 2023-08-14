import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class Quote {
    public static void main(String[] args) {
        String[][] quotes = {
            {"galileo", "eppur si muove"},
            {"archimedes", "eureka!"},
            {"erasmus", "in regione caecorum rex est luscus"},
            {"socrates", "I know nothing except the fact of my ignorance"},
            {"rené descartes", "cogito, ergo sum"},
            {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
        };
        
        LocalDate currentDate = LocalDate.now();

        LocalDate januaryFirst = LocalDate.of(currentDate.getYear(), 1, 1);

        long differenceInDays = ChronoUnit.DAYS.between(januaryFirst, currentDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'the' d'th of' MMMM");

        String formattedDate = currentDate.format(formatter);

        String[] quoteOTD = getQuote(quotes, differenceInDays);
        
        String formattedQuote = quoteOTD[1].substring(0, 1).toUpperCase() + quoteOTD[1].substring(1);
        
        char lastChar = formattedQuote.charAt(formattedQuote.length() - 1);
        if (lastChar != '.' && lastChar != '!' && lastChar != '?' && lastChar != ';' && lastChar != ':') {
            formattedQuote += ".";
        }
        
        String[] nameWords = quoteOTD[0].split(" ");
        StringBuilder formattedNameBuilder = new StringBuilder();
        for (String word : nameWords) {
            String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1);
            formattedNameBuilder.append(capitalizedWord).append(" ");
        }
        String formattedName = formattedNameBuilder.toString();
        
        System.out.println("Quote for " + formattedDate + ": \n\"" + formattedQuote + "\"" + " -- " + formattedName); 
    }

    public static String[] getQuote(String[][] quotes, long differenceInDays) {
        int whichQuote = (int) (differenceInDays % 6);
        return quotes[whichQuote];
    }
}
