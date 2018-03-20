import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

public class StackRealizationTest {
    private StackRealization stackForTest;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("tests start working");
    }

    @BeforeEach
    public void setup() {
        stackForTest=new StackRealization(2);
    }

    @Test
    public void testPeek_NodeEmptyStackException() {
        Assertions.assertThrows(
                NodeEmptyStackException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        stackForTest.peek();
                    }
                }
        );
    }

    @Test
    public void testPop_NodeEmptyStackException() {
        Assertions.assertThrows(
                NodeEmptyStackException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        stackForTest.pop();
                    }
                }
        );
    }

    @Test
    public void testPush_NodeStackOverflowException() {
        stackForTest.push(new Object());
        stackForTest.push(new Object());
        Assertions.assertThrows(
                NodeStackOverflowException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        stackForTest.push(new Object());
                    }
                }
        );
    }

    @AfterAll
    public static void aftelAll() {
        System.out.println("tests stop working");
    }
}
