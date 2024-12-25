package com.pkslow.bigdata.clickhouse;

import org.apache.flink.connector.jdbc.dialect.JdbcDialect;
import org.apache.flink.connector.jdbc.dialect.JdbcDialectFactory;

public class PkslowClickHouseJdbcDialectFactory implements JdbcDialectFactory {
    @Override
    public boolean acceptsURL(String url) {
        return url.startsWith("jdbc:clickhouse:");
    }

    @Override
    public JdbcDialect create() {
        return new PkslowClickHouseDialect();
    }
}
