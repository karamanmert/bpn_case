package com.karamanmert.bpn_case.prob3_invoice_service.new1;

import java.util.EnumMap;

public class DatabaseFactory {

    private static final EnumMap<DbType, Database> DATABASE_MAP = new EnumMap<>(DbType.class);

    private DatabaseFactory() {

    }

    static {
        DATABASE_MAP.put(DbType.Sql, new SqlDatabase());
        DATABASE_MAP.put(DbType.NoSql, new NoSQLDatabase());
    }

    public static Database createDb(DbType type) {

        if (type == null) {
            throw new RuntimeException("DbType must not be null");
        }

        if (!DATABASE_MAP.containsKey(type)) {
            throw new InvalidDbTypeException("DbType is not supported: " + type);
        }

        return DATABASE_MAP.get(type);
    }
}