package My;

import java.util.regex.Pattern;

/**
 * Created by admin on 17.04.2017.
 */
public class ValidateNumberString {
    private static Pattern p = Pattern.compile("[-0-9]+");

    public boolean validateString(String stringValidate){
        return p.matcher(stringValidate).matches();
    }

}
