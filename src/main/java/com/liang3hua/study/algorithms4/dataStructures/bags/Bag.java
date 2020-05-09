package com.liang3hua.study.algorithms4.dataStructures.bags;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author lianghuarong
 * @date 2020-05-09  9:00
 */
public class Bag<Element> implements Iterable<Element> {

    private Node<Element> firstElement;
    private int size;

    private class Node<Element>{
        private Element content;
        private Node<Element> nextElement;
    }

    public Bag(){
        firstElement = null;
        size = 0;
    }

    public boolean isEmpty(){
        return firstElement == null;
    }

    public int size(){
        return size;
    }

    public void add(Element element){
        Node<Element> oldFirst = firstElement;
        firstElement = new Node<>();
        firstElement.content = element;
        firstElement.nextElement = oldFirst;
        size ++;
    }

    public boolean contains(Element element) {
        Iterator<Element> iterator = iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Element> iterator() {
        return new ListIterator<>(firstElement);
    }

    @SuppressWarnings("hiding")
    private class ListIterator<Element> implements Iterator<Element> {
        private Node<Element> currentElement;

        private ListIterator(Node<Element> firstElement){
            currentElement = firstElement;
        }

        @Override
        public boolean hasNext() {
            return currentElement != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Element next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Element element = currentElement.content;
            currentElement = currentElement.nextElement;
            return element;
        }
    }
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();

        bag.add("1");
        bag.add("1");
        bag.add("2");

        System.out.println("size of bag = " + bag.size());
        for (String s : bag) {
            System.out.println(s);
        }

        System.out.println(bag.contains(null));
        System.out.println(bag.contains("1"));
        System.out.println(bag.contains("3"));
    }

}
