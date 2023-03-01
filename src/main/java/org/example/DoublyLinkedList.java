package org.example;

class DoublyLinkedList<T> {
    private Element<T> head;

    void push(T value) {
        if (this.head == null) {
            this.head = new Element<>(value, null, null);
            return;
        }
        if (head.prev == (null)) {
            this.head.prev = new Element<T>(value, null, head);
        } else {
            Element<T> element = getPrevEl(this.head.prev);
            Element<T> nextEl = head.prev;
            while (element != null) {
                nextEl = element;
                element = getPrevEl(element);
            }
            nextEl.prev = new Element<T>(value, null, nextEl);
        }
    }

    T pop() {
        Element<T> element = this.head;
        if (element.prev == null) {
            this.head = null;
            return element.value;
        }
        while (element.prev != null) {
            element = getPrevEl(element);
        }
        Element<T> secondLastEl = element.next;
        secondLastEl.prev = null;
        return element.value;
    }

    void unshift(T value) {
        if (this.head == null) {
            this.head = new Element<>(value, null, null);
        } else {
            Element<T> lastHead = this.head;
            this.head = new Element<>(value, this.head, null);
            lastHead.next = this.head;
        }
    }

    T shift() {
        if (head.prev == null) {
            return head.value;
        } else {
            Element<T> elToReturn = head;
            Element<T> elToTheLeft = this.head.prev;
            this.head = elToTheLeft;
            elToTheLeft.next = null;
            return elToReturn.value;
        }
    }

    Element<T> getPrevEl(Element<T> el) {
        return el.prev;
    }

    Element<T> getNextEl(Element<T> el) {
        return el.next;
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
