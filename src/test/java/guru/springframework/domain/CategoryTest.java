package guru.springframework.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTest {

    Category category;

    @Rule
    public MockitoRule initRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        category = new Category();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenSomethingHappens(){
        ArrayList mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getId() {
        category.setId(28L);
        assertEquals(28L, (long)category.getId());
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        recipe.setId(22L);
    }

    @Test
    public void getDescription() {
        category.setDescription("Description lkjsdlf");
        assertEquals("Description lkjsdlf", category.getDescription());
    }
}