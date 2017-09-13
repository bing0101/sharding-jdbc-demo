package com.bing.sharding.jdbc.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/9/13.
 */
public class ShardingRuleConfig {
    public void config() throws SQLException {
        ShardingRule shardingRule = ShardingRule.builder().dataSourceRule()
                                                            .tableRules()
                                                            .databaseShardingStrategy()
                                                            .tableShardingStrategy()
                                                            .build();
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
        String sql = "";

        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

        }
    }

}
