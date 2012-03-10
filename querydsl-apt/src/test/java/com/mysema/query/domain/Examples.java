package com.mysema.query.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysema.query.annotations.QueryEmbedded;
import com.mysema.query.annotations.QueryEntity;
import com.mysema.query.types.OrderSpecifier;

public class Examples {
    
    public static class Supertype {
        
        String supertypeProperty;
    }
    
    @QueryEntity
    public static class SimpleEntity extends Supertype{

    }

    @QueryEntity
    public static abstract class AbstractEntity<Id extends java.io.Serializable> {

        Id id;

        String first;

    }

    @QueryEntity
    public static class SubEntity extends AbstractEntity<java.lang.Long> {
     
        String second;
     
    } 
    
    @QueryEntity
    public static class ComplexCollections {
    
        @QueryEmbedded
        List<Complex<String>> list;
        
        @QueryEmbedded
        Map<String, Complex<String>> map;
        
        @QueryEmbedded
        Map<String, Complex<?>> map2;
        
        @QueryEmbedded
        Map<?, Complex<String>> map3;
                
                
    }
    
    
    public static class Complex<T extends Comparable<T>> implements Comparable<Complex<T>> {

        T a;
        
        @Override
        public int compareTo(Complex<T> arg0) {
            return 0;
        }
        
    }
    
    @QueryEntity
    public static class OrderBys {
        
        @QueryEmbedded
        List<OrderSpecifier<?>> orderBy = new ArrayList<OrderSpecifier<?>>();
    }

}
