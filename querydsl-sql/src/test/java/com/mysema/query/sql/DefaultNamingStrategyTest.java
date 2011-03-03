/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 *
 */
package com.mysema.query.sql;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.mysema.codegen.model.Types;
import com.mysema.query.codegen.EntityType;

public class DefaultNamingStrategyTest {

    private NamingStrategy namingStrategy = new DefaultNamingStrategy();

    private EntityType entityModel;
    
    @Before
    public void setUp(){
        entityModel = new EntityType(Types.OBJECT);
        entityModel.addAnnotation(new TableImpl("OBJECT"));
    }
    
    @Test
    public void GetClassName() {
        assertEquals("UserData", namingStrategy.getClassName("user_data"));
        assertEquals("U", namingStrategy.getClassName("u"));
        assertEquals("Us",namingStrategy.getClassName("us"));
        assertEquals("U", namingStrategy.getClassName("u_"));
        assertEquals("Us",namingStrategy.getClassName("us_"));
    }

    @Test
    public void GetPropertyName() {
        assertEquals("whileCol", namingStrategy.getPropertyName("while", entityModel));
        assertEquals("name", namingStrategy.getPropertyName("name", entityModel));
        assertEquals("userId", namingStrategy.getPropertyName("user_id", entityModel));
        assertEquals("accountEventId", namingStrategy.getPropertyName("accountEvent_id", entityModel));
    }

    @Test
    public void GetPropertyNameForInverseForeignKey(){
        assertEquals("_superiorFk", namingStrategy.getPropertyNameForInverseForeignKey("fk_superior", entityModel));
    }
    
    @Test
    public void GetPropertyNameForForeignKey(){
        assertEquals("superiorFk", namingStrategy.getPropertyNameForForeignKey("fk_superior", entityModel));
        assertEquals("superiorFk", namingStrategy.getPropertyNameForForeignKey("FK_SUPERIOR", entityModel));        
    }
    
    @Test
    public void GetDefaultVariableName(){
        assertEquals("object", namingStrategy.getDefaultVariableName(entityModel));
    }
    
}
