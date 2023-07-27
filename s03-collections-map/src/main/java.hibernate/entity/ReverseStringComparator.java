package entity;

import java.util.Comparator;

public class ReverseStringComparator implements Comparator<String> {

    @Override
    public int compare (final String o1, final String o2) {
        return o2.compareTo (o1);
    }
}
