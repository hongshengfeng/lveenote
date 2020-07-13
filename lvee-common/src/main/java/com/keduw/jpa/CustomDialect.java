package com.keduw.jpa;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.IntegerType;

public class CustomDialect extends MySQLDialect {

    public CustomDialect(){
        super();
        registerFunction("bitand", new SQLFunctionTemplate(IntegerType.INSTANCE, "(?1 & ?2)"));
        registerFunction("bitor", new SQLFunctionTemplate(IntegerType.INSTANCE, "(?1 | ?2)"));
        registerFunction("bitxor", new SQLFunctionTemplate(IntegerType.INSTANCE, "(?1 ^ ?2)"));
    }
}
