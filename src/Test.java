import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by tristanmenager on 06/04/2017.
 */
public class Test {
    public static List<Integer[]> listCoord = new LinkedList<>();
    public static void main(String[] args) {
        Integer [] list2 = new Integer[2];
        list2[0] = 1;
        list2[1] = 2;

        listCoord.add(list2);

        Integer [] list = new Integer[2];


        list[0] = 1;
        list[1] = 2;
        System.out.println(listCoord.contains(list));

        if (list.equals(list2)) {
            System.out.println("vraie");
        }

    }


}
