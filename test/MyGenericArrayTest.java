import com.jorzolek.arrays.MyGenericArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyGenericArrayTest {
    private MyGenericArray<String> myGenericArrayWithNumbers =
            new MyGenericArray<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});

    @Test
    public void create_array() {
        String[] strings = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i < strings.length; i++) {
            assertEquals(strings[i], myGenericArrayWithNumbers.pick(i));
        }
        assertEquals(10, myGenericArrayWithNumbers.size());
    }

    @Test
    public void create_empty_array() {
        MyGenericArray<Integer> myGenericArray = new MyGenericArray<>();
        assertEquals(0, myGenericArray.size());
    }

    @Test
    public void find_element_that_exists_in_array() {
        int index = myGenericArrayWithNumbers.find("5");
        assertEquals(4, index);
    }

    @Test
    public void find_element_that_does_not_exist_in_array() {
        int index = myGenericArrayWithNumbers.find("20");
        assertEquals(-1, index);
    }

    @Test
    public void pick_element_within_array_bounds() {
        String element = myGenericArrayWithNumbers.pick(5);
        assertEquals("6", element);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pick_element_out_of_array_lower_bound() {
        String element = myGenericArrayWithNumbers.pick(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pick_element_out_of_array_upper_bound() {
        String element = myGenericArrayWithNumbers.pick(10);
    }

    @Test
    public void push_element() {
        myGenericArrayWithNumbers.push("11");
        assertEquals(11, myGenericArrayWithNumbers.size());
        assertEquals("11", myGenericArrayWithNumbers.pick(10));
    }

    @Test
    public void pop_element() {
        String string = myGenericArrayWithNumbers.pop();
        assertEquals(9, myGenericArrayWithNumbers.size());
        assertEquals("10", string);
    }

    @Test
    public void shift_element() {
        String string = myGenericArrayWithNumbers.shift();
        assertEquals(9, myGenericArrayWithNumbers.size());
        assertEquals("1", string);
    }

    @Test
    public void unshift_element() {
        myGenericArrayWithNumbers.unshift("0");
        assertEquals(11, myGenericArrayWithNumbers.size());
        assertEquals("0", myGenericArrayWithNumbers.pick(0));
    }

    @Test
    public void insert_element_within_bounds() {
        myGenericArrayWithNumbers.insert(5, "a");
        assertEquals("a", myGenericArrayWithNumbers.pick(5));
        String[] strings = new String[]{"6", "7", "8", "9", "10"};
        for (int i = 0; i < strings.length; i++) {
            assertEquals(strings[i], myGenericArrayWithNumbers.pick(i + 6));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insert_element_out_of_lower_bound() {
        myGenericArrayWithNumbers.insert(-1, "a");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insert_element_out_of_upper_bound() {
        myGenericArrayWithNumbers.insert(10, "a");
    }

    @Test
    public void remove_element_within_bounds() {
        String remove = myGenericArrayWithNumbers.remove(5);
        assertEquals(remove, "6");
        String[] strings = new String[]{"7", "8", "9", "10"};
        for (int i = 0; i < strings.length; i++) {
            assertEquals(strings[i], myGenericArrayWithNumbers.pick(i + 5));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove_element_out_of_lower_bound() {
        myGenericArrayWithNumbers.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove_element_out_of_upper_bound() {
        myGenericArrayWithNumbers.remove(10);
    }

/*    @Test
    public void reverse() {
        MyGenericArray<String> reverse = myGenericArrayWithNumbers.reverse();
        String[] reversed = new String[]{"10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
        assertEquals(reversed, reverse);
    }*/
}
