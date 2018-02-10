package gmail.alexspush.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Alexander Pushkarev on 10.2.18.
 */
public class TestUtils {

    public static String generateItemName() {
        return RandomStringUtils.randomAlphabetic(5);
    }


    /**
     * Returns a list containing elements from originalList
     * which does not exist in a given sublist
     * @param originalList
     * @param sublist
     * @return
     */
    public static <T> List<T> getListWithoutSublist(List<T> originalList, List<T> sublist) {
        final List<T> newList = new ArrayList<>();
        for(T listItem : originalList) {
            if(!sublist.contains(listItem)) {
                newList.add(listItem);
            }
        }
        return newList;
    }

}
