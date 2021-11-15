package stefDef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class GetCarRegistration {

    public static List<String> getCarRegistrations(String textFromFile) throws IOException {
        Pattern regex = Pattern.compile("[A-Z][A-Z]\\S?([0][2-9]|[0-9][0-9])\\s?[A-Z]{3}");
        Matcher regexMatcher = regex.matcher(textFromFile);
        List<String> carsList = new ArrayList<String>();
        while (regexMatcher.find()) {
            if (regexMatcher.group(0) != null) {
                carsList.add(regexMatcher.group(0).replaceAll(" ", "").trim());
            }
        }
        System.out.println("Registration Numbers Extracted from the file ..." + carsList);
        return carsList.stream().sorted().collect(Collectors.toList());
    }
}