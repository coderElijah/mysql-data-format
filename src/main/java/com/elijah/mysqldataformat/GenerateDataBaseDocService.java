package com.elijah.mysqldataformat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author elijahliu
 * @Note Talk is cheap,just show me ur code.- -!
 * ProjectName:mysql-data-format
 * PackageName: com.elijah.mysqldataformat
 * Date: 2019/12/11 15:30
 */
@Service
public class GenerateDataBaseDocService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GenerateDataBaseDocDao generateDataBaseDocDao;

    public String generateDataBaseDocByName(String databaseName, String tableName, String tableChineseName, String version) {
        List<Map> infoMapList = generateDataBaseDocDao.selectTableInfoByName(databaseName, tableName);
        if (CollectionUtils.isEmpty(infoMapList)) {
            throw new RuntimeException("there is no table named " + tableName + ",check it out motherfxcker!");
        }
        return this.buildDatabaseDocString(infoMapList, tableName, tableChineseName, version);
    }

    private String buildDatabaseDocString(List<Map> infoMapList, String tableName, String tableChineseName, String version) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("* ").append(tableName.toUpperCase()).append(" `").append(tableChineseName).append("` `").append(version).append("`\n\n").append("> |字段                |类型         |说明           |版本         |\n" +
                "> |-----               |-----        |-----          |-----        |\n");
        for (Map map : infoMapList) {
            stringBuffer.append("> |").append(map.get("column_name")).append("|").append(map.get("column_type")).append("|").append(map.get("column_comment")).append("||\n");
        }
        return stringBuffer.toString();
    }
}
