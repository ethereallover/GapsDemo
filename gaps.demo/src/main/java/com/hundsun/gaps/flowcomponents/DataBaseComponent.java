package com.hundsun.gaps.flowcomponents;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataBaseComponent {

	private JdbcTemplate jdbcTemplate;

	public int save(String sql, String[] parameter) throws SQLException {
		return jdbcTemplate.update(sql, (Object[]) parameter);
	}

	public List<Map<String, Object>> query(String sql, String[] parameter) throws SQLException {
		return jdbcTemplate.query(sql, parameter, (result) -> {
			ResultSetMetaData resultSetMetaData = result.getMetaData();
			int colnum = resultSetMetaData.getColumnCount();

			List<Map<String, Object>> targetList = new ArrayList<>();
			while (result.next()) {
				Map<String, Object> targetMap = new HashMap<>(colnum);
				for (int i = 1; i <= colnum; i++) {
					targetMap.put(resultSetMetaData.getColumnLabel(i), result.getObject(i));
				}
				targetList.add(targetMap);
			}
			return targetList;

		});
	}

	@Autowired
	public void setDataSource(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}
}