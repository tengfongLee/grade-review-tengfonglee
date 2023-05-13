import static org.junit.Assert.*;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;
import org.junit.*;

public class ListTester {
    @Test
    public void filterTester(){




        List<String> stringList = new ArrayList<>();
        stringList.add("first");
        stringList.add("1");
        stringList.add("2");
        stringList.add("second");  

        StringChecker checker = new StringChecker(){
            @Override
            public boolean checkString(String s){
                return s instanceof String;
            }
        };
        
        List<String> filtered = ListExamples.filter(stringList, checker);

        assertEquals("", stringList, filtered);
       



    }

    @Test
    public void mergeTester(){
        List<String> testing = new ArrayList<>();
        List<String> testing2 = new ArrayList<>();
        List<String> expect = new ArrayList<>();

        testing.add("a");
        testing.add("c");
        testing.add("e");
        testing2.add("b");
        testing2.add("d");
        
        expect.add("a");
        expect.add("b");
        expect.add("c");
        expect.add("d");
        expect.add("e");

        ListExamples.merge(testing, testing2);

        assertEquals("was not expect list", expect, ListExamples.merge(testing, testing2));

        

    }

   

}
