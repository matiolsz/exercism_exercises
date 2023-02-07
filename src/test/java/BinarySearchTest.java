
import org.example.BinarySearch;
import org.example.ValueNotFoundException;
import org.junit.*;

import java.util.Collections;
import java.util.List;
public class BinarySearchTest {


    @Test
    public void findsAValueInAnArrayWithOneElement() throws ValueNotFoundException {
        List<Integer> listOfUnitLength = Collections.singletonList(6);
        BinarySearch search = new BinarySearch(listOfUnitLength);
        Assert.assertEquals(search.indexOf(6),(0));
    }
    @Test
    public void findsAValueInTheMiddleOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);
        BinarySearch search = new BinarySearch(sortedList);
        Assert.assertEquals(search.indexOf(6),3);
    }
    @Test
    public void findsAValueAtTheBeginningOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);
        BinarySearch search = new BinarySearch(sortedList);
        Assert.assertEquals(search.indexOf(1),0);    }

    @Test
    public void findsAValueAtTheEndOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);
        BinarySearch search = new BinarySearch(sortedList);
        Assert.assertEquals(search.indexOf(11),6);
    }
    @Test
    public void findsAValueInAnArrayOfOddLength() throws ValueNotFoundException {
        List<Integer> sortedListOfOddLength = List.of(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634);
        BinarySearch search = new BinarySearch(sortedListOfOddLength);
        Assert.assertEquals(search.indexOf(144),9);    }
    @Test
    public void findsAValueInAnArrayOfEvenLength() throws ValueNotFoundException {
        List<Integer> sortedListOfEvenLength = List.of(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377);
        BinarySearch search = new BinarySearch(sortedListOfEvenLength);
        Assert.assertEquals(search.indexOf(21),(5));
    }

//    @Test
//    public void identifiesThatAValueIsNotFoundInTheArray() throws ValueNotFoundException {
//        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);
//        BinarySearch search = new BinarySearch(sortedList);
//        Assert.assertEquals(ValueNotFoundException.class,
//                search.indexOf(7));}
//    @Ignore("Remove to run test")
//    @Test
//    public void aValueSmallerThanTheArraysSmallestValueIsNotFound() {
//        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);
//        BinarySearch search = new BinarySearch(sortedList);
//        assertThatExceptionOfType(ValueNotFoundException.class)
//                .isThrownBy(() -> search.indexOf(0))
//                .withMessage("Value not in array");
//    }
//    @Ignore("Remove to run test")
//    @Test
//    public void aValueLargerThanTheArraysSmallestValueIsNotFound() throws ValueNotFoundException {
//        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);
//        BinarySearch search = new BinarySearch(sortedList);
//        assertThatExceptionOfType(ValueNotFoundException.class)
//                .isThrownBy(() -> search.indexOf(13))
//                .withMessage("Value not in array");
//    }
//    @Ignore("Remove to run test")
//    @Test
//    public void nothingIsFoundInAnEmptyArray() throws ValueNotFoundException {
//        List<Integer> emptyList = Collections.emptyList();
//        BinarySearch search = new BinarySearch(emptyList);
//        assertThatExceptionOfType(ValueNotFoundException.class)
//                .isThrownBy(() -> search.indexOf(1))
//                .withMessage("Value not in array");
//    }
//    @Ignore("Remove to run test")
//    @Test
//    public void nothingIsFoundWhenTheLeftAndRightBoundCross() throws ValueNotFoundException {
//        List<Integer> sortedList = List.of(1, 2);
//        BinarySearch search = new BinarySearch(sortedList);
//        assertThatExceptionOfType(ValueNotFoundException.class)
//                .isThrownBy(() -> search.indexOf(0))
//                .withMessage("Value not in array");
//    }
}
