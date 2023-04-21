package in.bassure.training.batch7.java.collections;

import in.bassure.training.batch7.java.Chair;
import java.util.Comparator;

public class ChairPriceComparator implements Comparator<Chair> {
//public class ChairPriceComparator implements Comparator {

    //@Override
    public int compare(Chair a, Chair b) {
        if (a.getPrice() == b.getPrice()) {
            return 0;
        } else if (a.getPrice() < b.getPrice()) {
            return -1;
        }
        return 1;
    }

    //@Override
    public int compare1(Object a, Object b) {

        if (a instanceof Chair && b instanceof Chair) {
            Chair m = (Chair) a;
            Chair n = (Chair) b;

            if (m.getPrice() == n.getPrice()) {
                return 0;
            } else if (m.getPrice() < n.getPrice()) {
                return -1;
            }
            return 1;
        }

        throw new ClassCastException("Given objects are not Chair/Chair's");
    }

    public int compare2(Object a, Object b) {
        if (a instanceof Chair m && b instanceof Chair n) {
            if (m.getPrice() == n.getPrice()) {
                return 0;
            } else if (m.getPrice() < n.getPrice()) {
                return -1;
            }
            return 1;
        }

        throw new ClassCastException("Given objects are not Chair/Chair's");
    }
}
