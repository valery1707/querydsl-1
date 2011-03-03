/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 *
 */
package com.mysema.query;

import java.io.File;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.mysema.query.sql.DefaultNamingStrategy;
import com.mysema.query.sql.MetaDataExporter;
import com.mysema.query.sql.NamingStrategy;
import com.mysema.testutil.FilteringTestRunner;

@RunWith(FilteringTestRunner.class)
public abstract class ExportBaseTest {
    
    @Test
    public void Export() throws SQLException{
        File folder = new File("target", getClass().getSimpleName());
        folder.mkdirs();
        NamingStrategy namingStrategy = new DefaultNamingStrategy();
//        Serializer serializer = new MetaDataSerializer("Q", "", "", "", null, namingStrategy, false);
        MetaDataExporter exporter = new MetaDataExporter();
        exporter.setPackageName("test");
        exporter.setTargetFolder(folder);
        exporter.setNamingStrategy(namingStrategy);
//        exporter.setSerializer(serializer);
        exporter.export(Connections.getConnection().getMetaData());
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws SQLException {
        Connections.close();
    }

}
