package a03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//= = = =   Do Not Modify This Class = = = =
/**
* Tests the methods specified in NumberList.
* 
* @author CSIS
*/
public class NumberListTest {

    private NumberList list;  // empty list
    private NumberList list3; // {1.1, 2.2, 3.3}

    @BeforeEach
    public void setUp() {
        list = new NumberList();
        
        list3 = new NumberList();
        list3.add(1.1);
        list3.add(2.2);
        list3.add(3.3);
    }
    
    // = = = size = = = 
    @Test
    public void size_EmptyList() {
        assertEquals(0, list.size());
    }

    @Test
    public void size_MultipleElements() {
        assertEquals(3, list3.size());
    }

    // = = = isEmpty = = = 
    @Test
    public void isEmpty_EmptyList() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmpty_MultipleElements() {
        assertFalse(list3.isEmpty());;
    }  
    
    // = = = add = = = 
    @Test
    public void add_SingleElement() {
        list.add(5.2);
        assertEquals("5.2 ", list.toString());
        assertEquals(1, list.size());
    }

    @Test
    public void add_TwoElements() {
        list.add(5.2);
        list.add(1.1);
        assertEquals("5.2 1.1 ", list.toString());
        assertEquals(2, list.size());
    }
    
    @Test
    public void add_MultipleElements() {
    	list3.add(4.8);
        assertEquals("1.1 2.2 3.3 4.8 ", list3.toString());
        assertEquals(4, list3.size());
    }
    
    // = = = firstElement = = = 
    @Test
    public void firstElement_EmptyList() {
        assertThrows(NoSuchElementException.class, () -> list.firstElement());
    }
    
    @Test
    public void firstElement_SingleElement() {
    	list.add(2.7);
        assertEquals(2.7, list.firstElement());
    }

    @Test
    public void firstElement_MultipleElements() {
    	assertEquals(1.1, list3.firstElement());
    }
    
    // = = = endsPositive = = = 
    @Test
    public void endsPositive_EmptyList() {
        assertThrows(IllegalStateException.class, () -> list.endsPositive());
    }
    
    @Test
    public void endsPositive_SingleElement_Positive() {
    	list.add(2.7);
        assertTrue(list.endsPositive());
    }
    
    @Test
    public void endsPositive_LastElementNegative() {
    	list.add(2.7);
    	list.add(-3.2);
        assertFalse(list.endsPositive());
    }

    @Test
    public void endsPositive_MultipleElements_EndsOnZero() {
    	list3.add(0);
    	assertFalse(list3.endsPositive());
    }
    
    // = = = average = = = 
    @Test
    public void average_EmptyList() {
        assertThrows(IllegalStateException.class, () -> {
        	list.average();
        });
    }

    @Test
    public void average_SingleElement() {
        list.add(5.1);
        assertEquals(5.1, list.average());
    }

    @Test
    public void average_MultipleElements() {
    	list3.add(1.8);
        assertEquals(2.1, list3.average());
    }   
    
    // = = = fill = = = 
    @Test
    public void fill_EmptyList() {
    	list.fill(2.2);
    	
        assertTrue(list.isEmpty());
        assertEquals("", list.toString());
    }

    @Test
    public void fill_SingleElement() {
    	list.add(1.5);
    	list.fill(2.2);
    	
        assertEquals(1, list.size());
        assertEquals("2.2 ", list.toString());
    }

    @Test
    public void fill_MultipleElements() {
    	list3.fill(2.2);
    	
        assertEquals(3, list3.size());
        assertEquals("2.2 2.2 2.2 ", list3.toString());
    }

    // = = = insert = = = 
    @Test
    public void testInsert_EmptyList() {
        list.insert(0, 5.5);
        assertEquals(1, list.size());
        assertEquals("5.5 ", list.toString());
    }

    @Test
    public void testInsert_AtBeginning() {
    	list3.insert(0, 7.2);
        assertEquals(4, list3.size());
        assertEquals("7.2 1.1 2.2 3.3 ", list3.toString());
    }

    @Test
    public void testInsert_AtEnd() {
        list3.insert(3, 7.2);
        assertEquals(4, list3.size());
        assertEquals("1.1 2.2 3.3 7.2 ", list3.toString());
    }

    @Test
    public void testInsert_InBetween() {
        list3.insert(1, 7.2);
        assertEquals(4, list3.size());
        assertEquals("1.1 7.2 2.2 3.3 ", list3.toString());
    }
    
    // = = = remove = = = 
    @Test
    public void testRemove_EmptyList() {
        assertFalse(list.remove(1.1));
    }

    @Test
    public void testRemove_SingleElement() {
    	list.add(0.1);
    	
        assertTrue(list.remove(0.1));
        assertTrue(list.isEmpty());
        assertEquals("", list.toString());
    }
    
    @Test
    public void testRemove_AtBeginning() {
        list.add(5.5);
        list.add(1.1);
        list.add(7.2);

        assertTrue(list.remove(5.5));
        assertEquals(2, list.size());
        assertEquals("1.1 7.2 ", list.toString());
    }  
    
    
    @Test
    public void testRemove_InMiddle() {
        list.add(5.5);
        list.add(4.4);
        list.add(3.3);
        list.add(2.2);
        list.add(1.1);

        assertTrue(list.remove(3.3));
        assertEquals(4, list.size());
        assertEquals("5.5 4.4 2.2 1.1 ", list.toString());
    }
    
    @Test
    public void testRemove_AtEnd() {
        list.add(5.5);
        list.add(1.1);
        list.add(7.2);

        assertTrue(list.remove(7.2));
        assertEquals(2, list.size());
        assertEquals("5.5 1.1 ", list.toString());
    }

    @Test
    public void testRemove_NonExistingElement() {
        list.add(5.5);
        list.add(1.1);
        list.add(7.2);

        assertFalse(list.remove(2.2));
        assertEquals(3, list.size());
        assertEquals("5.5 1.1 7.2 ", list.toString());
    }
   
    // = = = removeDuplicates = = = 
    @Test
    public void testRemoveDuplicates_EmptyList() {
        list.removeDuplicates();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveDuplicates_NoDuplicates() {
        list.add(1.1);
        list.add(2.2);

        list.removeDuplicates();
        assertEquals(2, list.size());
        assertEquals("1.1 2.2 ", list.toString());
    }

    @Test
    public void testRemoveDuplicates_DuplicatesInMiddle() {
        list.add(0.5);
        list.add(5.5);
        list.add(5.5);
        list.add(1.1);
        list.add(5.5);
        list.add(2.2);
        
        list.removeDuplicates();
        assertEquals(4, list.size());
        assertEquals("0.5 5.5 1.1 2.2 ", list.toString());
    }
    
    @Test
    public void testRemoveDuplicates_DuplicatesBeginningAndEnd() {
        list.add(0.5);
        list.add(3.5);
        list.add(4.5);
        list.add(1.5);
        list.add(5.5);
        list.add(0.5);
        
        list.removeDuplicates();
        assertEquals(5, list.size());
        assertEquals("0.5 3.5 4.5 1.5 5.5 ", list.toString());
    }
    
    @Test
    public void testRemoveDuplicates_multipleDuplicates() {
        list.add(1.1);
        list.add(4.4);
        list.add(2.2);
        list.add(1.1);
        list.add(1.1);
        list.add(3.3);
        list.add(2.2);
        list.add(1.1);
        
        list.removeDuplicates();
        assertEquals(4, list.size());
        assertEquals("1.1 4.4 2.2 3.3 ", list.toString());
    }
    
    // = = = rotateRight = = = 
    @Test
    public void testRotateRight_EmptyList() {
        list.rotateRight(2);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRotateRight_SingleElement() {
        list.add(5.2);
        list.rotateRight(3);
        
        assertEquals("5.2 ", list.toString());
        assertEquals(1, list.size());
    }

    @Test
    public void testRotateRight_MultipleElements() {
        list.add(1.1);
        list.add(2.2);
        list.add(3.3);
        list.add(4.4);
        list.add(5.5);
        list.rotateRight(2);
        
        assertEquals("4.4 5.5 1.1 2.2 3.3 ", list.toString());
        assertEquals(5, list.size());
    }
    
    @Test
    public void testRotateRight_positionsGreaterN() {
        list.add(1.1);
        list.add(2.2);
        list.add(3.3);
        list.add(4.4);
        list.rotateRight(11);
        
        assertEquals("2.2 3.3 4.4 1.1 ", list.toString());
        assertEquals(4, list.size());
    }

    @Test
    public void testRotateRight_PositionsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
        	list.rotateRight(-2);
        });
    }
    @Test
    public void testRotateRight_PositionsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
        	list.rotateRight(0);
        });
    }
    
    // = = = toString = = = 
    @Test
    public void toString_EmptyList() {
        assertEquals("", list.toString());
    }
    
    @Test
    public void toString_SingleElement() {
        list.add(5.2);
        assertEquals("5.2 ", list.toString());
    }

    @Test
    public void toSTring_TwoElements() {
        list.add(5.2);
        list.add(6.2);
        assertEquals("5.2 6.2 ", list.toString());
    }
    
    @Test
    public void toString_MultipleElements() {
    	list3.add(4.4);
        assertEquals("1.1 2.2 3.3 4.4 ", list3.toString());
    }
}
