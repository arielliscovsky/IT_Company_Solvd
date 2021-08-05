package com.solvd.airport.classes.collections;

import java.util.NoSuchElementException;

public class MyLinkedList <E extends Comparable> {
    private MyNode <E> front;
    private int amount;

    public MyLinkedList ()
    {
        front = null;
        amount = 0;
    }


    // Add object "x" at index position into the list. The first node is in the ¨cero¨¨ position.
    public void add(int index, E x)
    {
        MyNode <E> node = new MyNode<>( x, front );
        if( index == 0 ) { front = node; }
        else
        {
            MyNode <E> p = front;
            //convert to foreach statement
            for( int i = 0; i < index - 1; i++ ) { p = p.getNext(); }
            node.setNext( p.getNext() );
            p.setNext( node );
        }

        amount++;
    }


    public void addMiddle(E x){
        int middle = (int) size() / 2;
        add(middle, x);
    }

    public MyLinkedList<E> reverse(E x){

        MyLinkedList<E> linkedListAux = new MyLinkedList();

        MyNode <E> p = front;

        while (p != null) {
            linkedListAux.addFirst(p.getInfo());
            p = p.getNext();
        }
        return linkedListAux;

    }

    public void addFirst(E x)
    {
        if ( x == null ) { return; }

        MyNode < E > p = new MyNode <> (x, front);
        front = p;

        amount++;
    }


    public void addInOrder(E x)
    {
        MyNode <E> node = new MyNode <>( x, null );
        MyNode <E> p = front, q = null;
        while (p != null && x.compareTo( p.getInfo()) >= 0 )
        {
            q = p;
            p = p.getNext();
        }
        node.setNext( p );
        if( q != null ) {q.setNext( node ); }
        else { front = node; }

        amount++;
    }


    public void clear( )
    {
        this.front = null;
        this.amount = 0;
    }


    public boolean contains(E x)
    {
        MyNode <E> p = front;
        while ( p != null && x.compareTo(p.getInfo()) != 0) {p = p.getNext(); }
        return ( p != null );
    }


    public E get(int index )
    {
        if( index< 0 || index >= size() ) { throw new IndexOutOfBoundsException(); }

        MyNode <E> p = front;
        for( int i = 0; i < index; i++ ){  p = p.getNext(); }
        return p.getInfo();
    }
    public E getFirst()
    {
        if (front == null) {throw new NoSuchElementException("Error: empty list"); }
        return front.getInfo();
    }

    public boolean isEmpty()
    {
        return (front == null);
    }


    public E remove(int index)
    {
        if( index < 0 || index >= size()) { throw new IndexOutOfBoundsException(); }

        MyNode <E> p = front, q = null;
        for( int i = 0; i < index; i++ )
        {
            q = p;
            p = p.getNext();
        }

        E x = p.getInfo();
        if( q == null ) { front = p.getNext(); }
        else { q.setNext( p.getNext() ); }

        amount--;
        return x;
    }


    public E set( int index, E x )
    {
        if( index < 0 || index >= size() ) { throw new NoSuchElementException(); }

        MyNode <E> p = front;
        for( int i = 0; i < index; i++ ) { p = p.getNext(); }

        E ant = p.getInfo();
        p.setInfo( x );
        return ant;
    }


    public int size()
    {
        return this.amount;
    }


    @Override
    public String toString()
    {
        MyNode <E> p = front;
        String res = "[";
        while( p != null )
        {
            res = res + p.toString();
            if ( p.getNext() != null ) { res = res + ", "; }
            p = p.getNext();
        }
        res = res + "]";
        return res;
    }



    //public void reverseRecursive() { reverseRecursive(E x)}

    //private void reverseRecursive(E x) {}



}
