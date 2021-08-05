package com.solvd.airport.classes.collections;

public class MyNode < E extends Comparable >
{
    private E info;
    private MyNode <E> next;

    public MyNode( )
    {
    }

    public MyNode(E x, MyNode <E> p)
    {
        info = x;
        next = p;
    }

    public MyNode <E> getNext()
    {
        return next;
    }

    public void setNext(MyNode <E> p)
    {
        next = p;
    }

    public E getInfo()
    {
        return info;
    }

    public void setInfo(E p)
    {
        info = p;
    }

    @Override
    public String toString()
    {
        return info.toString();
    }
}