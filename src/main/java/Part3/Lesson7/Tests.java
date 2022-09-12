package Part3.Lesson7;

public class Tests {
    @BeforeSuite
    public void methodBefore() {
        System.out.println("");
    }

    @AfterSuite
    public void methodAfter() {
        System.out.println("");
    }

    @Test(priority = 1)
    public void methodTest1() {
        System.out.println("");
    }

    @Test(priority = 8)
    public void methodTest2() {
        System.out.println("");
    }

    @Test(priority = 2)
    public void methodTest3() {
        System.out.println("");
    }

    @Test(priority = 10)
    public void methodTest4() {
        System.out.println("");
    }

    @Test(priority = 7)
    public void methodTest5() {
        System.out.println("");
    }

}

