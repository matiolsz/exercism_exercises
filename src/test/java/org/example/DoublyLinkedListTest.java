package org.example;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
public class DoublyLinkedListTest {
    @Test
    public void testPushPop() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.push(10);
        list.push(20);
        list.push(30);
        Assert.assertTrue((list.pop()).equals(30));
        Assert.assertTrue((list.pop()).equals(20));
        Assert.assertTrue((list.pop()).equals(10));
    }
//    @Ignore("Remove to run test")
    @Test
    public void testPushShift() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.push("10");
        list.push("20");
        list.push("30");
        Assert.assertTrue(list.shift().equals("10"));
        Assert.assertTrue(list.shift().equals("20"));
        Assert.assertTrue(list.shift().equals("30"));
    }
//    @Ignore("Remove to run test")
    @Test
    public void testUnshiftShift() {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        list.unshift('1');
        list.unshift('2');
        list.unshift('3');
        Assert.assertTrue(list.shift().equals('3'));
        Assert.assertTrue(list.shift().equals('2'));
        Assert.assertTrue(list.shift().equals('1'));

    }
//    @Ignore("Remove to run test")
    @Test
    public void testUnshiftPop() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.unshift(10);
        list.unshift(20);
        list.unshift(30);
        Assert.assertTrue((list.pop()).equals(10));
        Assert.assertTrue((list.pop()).equals(20));
        Assert.assertTrue((list.pop()).equals(30));
    }
//    @Ignore("Remove to run test")
    @Test
    public void testExample() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.push("ten");
        list.push("twenty");
        Assert.assertTrue((list.pop()).equals(("twenty")));
        list.push("thirty");
        Assert.assertTrue((list.shift()).equals("ten"));
        list.unshift("forty");
        list.push("fifty");
        Assert.assertTrue((list.shift()).equals("forty"));
        Assert.assertTrue((list.pop()).equals("fifty"));
        Assert.assertTrue((list.shift()).equals("thirty"));
    }
}