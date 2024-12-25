package com.pkslow.bigdata.clickhouse;

import org.apache.flink.connector.jdbc.converter.JdbcRowConverter;
import org.apache.flink.connector.jdbc.dialect.AbstractDialect;
import org.apache.flink.table.types.logical.LogicalTypeRoot;
import org.apache.flink.table.types.logical.RowType;

import java.util.Optional;
import java.util.Set;

public class PkslowClickHouseDialect extends AbstractDialect {
    @Override
    public Set<LogicalTypeRoot> supportedTypes() {
        return Set.of(
                LogicalTypeRoot.NULL,

                LogicalTypeRoot.BOOLEAN,

                LogicalTypeRoot.TINYINT,
                LogicalTypeRoot.SMALLINT,
                LogicalTypeRoot.INTEGER,
                LogicalTypeRoot.BIGINT,

                LogicalTypeRoot.CHAR,
                LogicalTypeRoot.VARCHAR,

                LogicalTypeRoot.FLOAT,
                LogicalTypeRoot.DOUBLE,
                LogicalTypeRoot.DECIMAL,

                LogicalTypeRoot.DATE,
                LogicalTypeRoot.TIME_WITHOUT_TIME_ZONE,
                LogicalTypeRoot.TIMESTAMP_WITH_LOCAL_TIME_ZONE,
                LogicalTypeRoot.TIMESTAMP_WITHOUT_TIME_ZONE,
                LogicalTypeRoot.TIMESTAMP_WITH_TIME_ZONE,

                LogicalTypeRoot.ARRAY,

                LogicalTypeRoot.VARBINARY
                );
    }

    @Override
    public String dialectName() {
        return "ClickHouse";
    }

    @Override
    public JdbcRowConverter getRowConverter(RowType rowType) {
        return new PkslowClickHouseJdbcRowConverter(rowType);
    }

    @Override
    public String getLimitClause(long limit) {
        return "LIMIT " + limit;
    }

    @Override
    public Optional<String> defaultDriverName() {
        return Optional.of("com.clickhouse.jdbc.ClickHouseDriver");
    }

    @Override
    public String quoteIdentifier(String s) {
        return s;
    }

    @Override
    public Optional<String> getUpsertStatement(String tableName, String[] fieldNames, String[] uniqueKeyFields) {
        return Optional.of(getInsertIntoStatement(tableName, fieldNames));
    }
}
