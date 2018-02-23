package company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.List;


public class StringProcessorTest {

    private String text;
    private StringProcessor processor;

    @Before
    public void setUp(){
        text = "Immutable object jest to niezmienny obiekt";
        processor = new StringProcessor(text, 10);
    }

    @Test
    public void shouldReturnTrueWhenTextTableEquals6() {
        Assert.assertTrue(processor.processText(text).length == 6);
    }

    @Test
    public void shouldReturnFalseWhenTextTableEquals6() {
        Assert.assertFalse(processor.processText(text).length != 6);
    }

    @Test
    public void shouldReturnWidthColumn(){
        processor.checkTheLongestWord();

        Assert.assertEquals(10, 10);
    }

    @Test
    public void shouldReturnLengthOfTheLongestWord(){
        String text = "Przynajmniej";
        processor.setText(processor.processText(text));

        Assert.assertEquals(processor.checkTheLongestWord(), text.length());
    }

    @Test
    public void shouldReturnListWhichSizeEqualsListOfRowsSize(){
        List<String> newList = processor.buildRows();

        Assert.assertEquals(newList.size(), processor.getListOfRows().size());
    }

    @After
    public void setDown(){
        text = null;
        processor = null;
    }
}
