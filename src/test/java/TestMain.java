import com.github.javafaker.App;
import model.sections.base.BaseHealth;
import model.sections.sectionc.ParallelChain;
import model.sections.sectionc.TwstftOffset;
import org.junit.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import tutorial.dao.utils.jpahibernate.service.SectionService;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestMain {
   SectionService sectionService=new SectionService();

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Test
    public void testTwtsftsSize() {

        List<TwstftOffset> retrievedTwstftOffsets = sectionService.getTwstftOffsets();
        Assert.assertEquals(retrievedTwstftOffsets.size(), 3);

    }

    @Test
    public void testTwtsftValues() {

        List<TwstftOffset> retrievedTwstftOffsets = sectionService.getTwstftOffsets();

        Assert.assertTrue(retrievedTwstftOffsets.stream()
                .allMatch(isValue10));
    }

    Predicate<TwstftOffset> isValue10 = (i) -> i.getValue() == 10;

    @Test
    public void testTwstftNames() {

        List<TwstftOffset> retrievedTwstftOffsets = sectionService.getTwstftOffsets();

        for (int i = 0; i < retrievedTwstftOffsets.size(); i++) {
            List<String> allNames = retrievedTwstftOffsets.stream()
                    .map(obj -> obj.getName()).collect(Collectors.toList());


            String ithTwstft = retrievedTwstftOffsets.get(i).getName();
             Assert.assertEquals(ithTwstft, allNames.get(i));

        }
        List<String> allNames = retrievedTwstftOffsets.stream()
                .map(obj -> obj.getName()).collect(Collectors.toList());
        System.out.println(allNames);
    }

//    @Test
//    public void testParallelChainNames() {
//
//        List<ParallelChain> retrievedParallelChain = AppMain.getParallelChains();
//
//        for (int i = 0; i < retrievedParallelChain.size(); i++) {
//            String ithChain = retrievedParallelChain.get(i).getName();
//            if (i == 0) {
//                Assert.assertEquals(ithChain, "inc1Server1");
//            } else if (i == 1) {
//                Assert.assertEquals(ithChain, "inc1Server2");
//            } else if (i == 2) {
//                Assert.assertEquals(ithChain, "inc2Server1");
//            } else if (i == 3) {
//                Assert.assertEquals(ithChain, "inc2Server2");
//            }
//
//        }
//
//
//    }
    @Test
    @DisplayName("Test to parallel Chain")
    public void testParallelChainNamesMethod1() {
        List<ParallelChain> retrievedParallelChain = sectionService.getParallelChains();
        String[] expectedChainNames = {"inc1Server1", "inc1Server2", "inc2Server1", "inc2Server2"};

        for (int i = 0; i < retrievedParallelChain.size(); i++) {
            String ithChain = retrievedParallelChain.get(i).getName();
            Assert.assertEquals(ithChain, expectedChainNames[i]);
        }
    }




    public static <T> void testListNames(List<T> list, String[] expectedNames, Function<T, String> nameExtractor) {
        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            String name = nameExtractor.apply(element);
            Assert.assertEquals(name, expectedNames[i]);
        }
    }
    @Test
    public void testParallelChainNamesMethod2() {
        List<ParallelChain> retrievedParallelChain = sectionService.getParallelChains();
        String[] expectedChainNames = {"inc1Server1", "inc1Server2", "inc2Server1", "inc2Server2"};

        testListNames(retrievedParallelChain, expectedChainNames, parallelChain -> parallelChain.getName());
    }
    @Test
    public void testParallelChainNamesMethod3UsingFunctionalProg() {
        List<ParallelChain> retrievedParallelChain = sectionService.getParallelChains();
        List<String> expectedChainNames = List.of("inc1Server1", "inc1Server2", "inc2Server1", "inc2Server2");
        List<String> names=retrievedParallelChain.stream()
                .map(obj->obj.getName()).collect(Collectors.toList());

        Assertions.assertIterableEquals(expectedChainNames,names);

    }






}


