package com.ccc.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidConfigurationException {
        List<String>waring=new ArrayList<String>();
        boolean overwrite=true;
        String genCig="/generatorConfig.xml";
        File comfigFile=new File(Main.class.getResource(genCig).getFile());
        ConfigurationParser configurationParser=new ConfigurationParser(waring);
        Configuration configuration=null;

        try {
            configuration=configurationParser.parseConfiguration(comfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback=new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator=null;
        try {
            myBatisGenerator=new MyBatisGenerator(configuration,callback,waring);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
       myBatisGenerator.generate(null);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
