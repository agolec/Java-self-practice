package utilityMethods;

import org.junit.Assert;
import org.junit.Test;

public class SearchUtilityTests {
    @Test
    public void KeyNotInStringReturnsNegativeOne(){
        final int EXPECTED_INDEX = -1;
        String kingLear = "When we are born, we cry that we are come " +
        "To this great stage of fools. " +
        "(Lear, Act 4 Scene 5)";
        int actualIndex = SearchUtility.sequentialSearchForTokenKey(kingLear,"Romeo");
        Assert.assertEquals(EXPECTED_INDEX,actualIndex);
    }
    @Test
    public void KeyInStringFirstIndexReturnsZero(){
        final int EXPECTED_INDEX = 0;
        final String SEARCH_KEY = "When";
        String kingLear = "When we are born, we cry that we are come " +
                "To this great stage of fools. " +
                "(Lear, Act 4 Scene 5)";
        int actualIndex = SearchUtility.sequentialSearchForTokenKey(kingLear,SEARCH_KEY);
        System.out.println("found at index: " + actualIndex);
        Assert.assertEquals(EXPECTED_INDEX,actualIndex);
    }
    public void KeyInStringLastIndexReturnsTokensLengthMinusOne(){
        final int EXPECTED_INDEX = 20;
        final String SEARCH_KEY = "5)";
        String kingLear = "When we are born, we cry that we are come " +
                "To this great stage of fools. " +
                "(Lear, Act 4 Scene 5)";
        int actualIndex = SearchUtility.sequentialSearchForTokenKey(kingLear,SEARCH_KEY);
        System.out.println("found at index: " + actualIndex);
        Assert.assertEquals(EXPECTED_INDEX,actualIndex);
    }
    public void KeyInMiddleOfStringReturnsExpectedIndex(){
        final int EXPECTED_INDEX = 15;
        final String SEARCH_KEY = "fools.";
        String kingLear = "When we are born, we cry that we are come " +
                "To this great stage of fools. " +
                "(Lear, Act 4 Scene 5)";
        int actualIndex = SearchUtility.sequentialSearchForTokenKey(kingLear,SEARCH_KEY);
        System.out.println("found at index: " + actualIndex);
        Assert.assertEquals(EXPECTED_INDEX,actualIndex);
    }
}
