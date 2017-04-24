package Tests;

import My.ValidateNumberString;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by admin on 22.04.2017.
 */
public class Tests {
    @Test
    public void TestValidation() throws Exception {
        ValidateNumberString validateNumberString = new ValidateNumberString();
        assertTrue(validateNumberString.validateString("5687"));
        assertFalse(validateNumberString.validateString("56e87"));
        assertTrue(validateNumberString.validateString("56a87"));
    }
}