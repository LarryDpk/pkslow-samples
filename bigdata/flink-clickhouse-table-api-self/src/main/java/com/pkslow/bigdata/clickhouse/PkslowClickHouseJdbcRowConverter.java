package com.pkslow.bigdata.clickhouse;

import org.apache.flink.connector.jdbc.converter.AbstractJdbcRowConverter;
import org.apache.flink.table.types.logical.RowType;

public class PkslowClickHouseJdbcRowConverter extends AbstractJdbcRowConverter {
    public PkslowClickHouseJdbcRowConverter(RowType rowType) {
        super(rowType);
    }

    @Override
    public String converterName() {
        return "ClickHouse";
    }
}
