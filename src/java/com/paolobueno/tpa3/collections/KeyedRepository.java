/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa3.collections;

/**
 *
 * @author 31227848
 */
interface KeyedRepository<TKey, T> {
    public boolean add(T entity);
    public boolean remove(TKey Entity);
    public T find(TKey key);
}
