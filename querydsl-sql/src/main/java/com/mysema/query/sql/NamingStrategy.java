/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 *
 */
package com.mysema.query.sql;

import com.mysema.query.codegen.EntityType;

/**
 * NamingStrategy defines a conversion strategy from table to class and column
 * to property names
 *
 * @author tiwe
 */
public interface NamingStrategy {

    /**
     * Convert the given tableName to a simple class name
     * @return
     */
    String getClassName(String tableName);

    /**
     * Get the default alias for the given EntityType
     *
     * @param entityType
     * @return
     */
    String getDefaultAlias(EntityType entityType);

    /**
     * Get the default variable name for the given EntityType
     *
     * @param entityType
     * @return
     */
    String getDefaultVariableName(EntityType entityType);

    /**
     * Get the class name for the foreign keys inner class
     * 
     * @return
     */
    String getForeignKeysClassName();

    /**
     * Get the field name for the foreign keys class instance
     * 
     * @return
     */
    String getForeignKeysVariable(EntityType entityType);

    /**
     * Get the class name for the primary keys inner class
     * 
     * @return
     */
    String getPrimaryKeysClassName();

    /**
     * Get the field name for the primary keys class instance
     * 
     * @return
     */
    String getPrimaryKeysVariable(EntityType entityType);

    /**
     * Convert the given column name to a property name
     *
     * @param columnName
     * @param entityType
     * @return
     */
    String getPropertyName(String columnName, EntityType entityType);

    /**
     * Convert the given foreign key name to a foreign key property name
     *
     * @param foreignKeyName
     * @param entityType
     * @return
     */
    String getPropertyNameForForeignKey(String foreignKeyName, EntityType entityType);
    
    /**
     * Convert the given foreign key name to a foreign key property name
     * 
     * @param name
     * @param model
     * @return
     */
    String getPropertyNameForInverseForeignKey(String name, EntityType model);
    
    /**
     * Convert the given primary key name to a primary key property name
     *
     * @param name
     * @param model
     * @return
     */
    String getPropertyNameForPrimaryKey(String name, EntityType model);
    
    /**
     * Convert the given column name and provide the opportunity to add quoted identifiers
     *
     * @param columnName
     * @return
     */
    String normalizeColumnName(String columnName);
    
    /**
     * Convert the given table name and provide the opportunity to add quoted identifiers
     *
     * @param tableName
     * @return
     */
    String normalizeTableName(String tableName);
    

    /**
     * Convert the given schema name and provide the opportunity to add quoted identifiers
     *
     * @param schemaName
     * @return
     */
    String normalizeSchemaName(String schemaName);

}
