import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.junit.runner.*;


import junit.textui.TestRunner;

public class ListTester {
    List<String> stringList;
    List<String> strListContainNull;
    List<String> strListContainNo; //list like containNull but no Null
    List<String> strListsInOrder;
    List<String> testing;
    List<String> testing2;
    List<String> expect ;

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestRunner.class);
        int exitStatus = result.wasSuccessful() ? 0 : result.getFailureCount();
        System.exit(exitStatus);
    }

    @Before
    public void setter(){
        stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("f");

        strListContainNull = new ArrayList<>();
        strListContainNull.add("c");
        strListContainNull.add(null);
        strListContainNull.add("g");
        strListContainNull.add("e");

        strListContainNo = new ArrayList<>();
        strListContainNo.add("c");
        strListContainNo.add("g");
        strListContainNo.add("e");

        strListsInOrder = new ArrayList<>();
        strListsInOrder.add("a");
        strListsInOrder.add("b");
        strListsInOrder.add("c");
        strListsInOrder.add("f");
        strListsInOrder.add("g");
        strListsInOrder.add("e");


        testing = new ArrayList<>();
        testing.add("a");
        testing.add("c");
        testing.add("e");

        testing2 = new ArrayList<>();
        testing2.add("b");
        testing2.add("d");

        expect = new ArrayList<>();
        expect.add("a");
        expect.add("b");
        expect.add("c");
        expect.add("d");
        expect.add("e");
    }

    @Test
    public void filterTester(){
         


        StringChecker checker = new StringChecker(){
            @Override
            public boolean checkString(String s){
                return s instanceof String;
            }
        };
        

        

        List<String> filtered = ListExamples.filter(stringList, checker);

        assertEquals("", stringList, filtered);

        List<String> filtered2 = ListExamples.filter(strListContainNull, checker);

        assertEquals("", strListContainNo, filtered2);

       



    }

    @Test
    public void mergeTester(){
        


        assertEquals("was not expect list",
            expect, ListExamples.merge(testing, testing2));
        assertEquals("was not expect list",
            strListsInOrder, ListExamples.merge(strListContainNo, stringList));

        

    }


   

}
