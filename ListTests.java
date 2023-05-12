import static org.junit.Assert.*;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;
import org.junit.*;

public class ListTests {

    @Before
    public void setter(){
        List<String> ListExamples = new ArrayList<>();
    }

    @Test
    public void filterTester(){




        List<String> stringList = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        answer.add("first");
        answer.add("1");
        answer.add("first");
        answer.add("second");
        stringList.add("first");
        stringList.add("1");
        stringList.add("first");
        stringList.add("second");  

        assertThat(ListExamples.filter(stringList),is(answer));

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
