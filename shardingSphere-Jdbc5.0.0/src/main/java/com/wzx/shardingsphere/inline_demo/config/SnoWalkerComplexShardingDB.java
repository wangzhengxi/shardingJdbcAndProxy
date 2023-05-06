//package com.yl.shardingsphere.inline_demo.Config;
//
//import com.google.common.collect.Sets;
//import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
//import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
//
//import java.util.*;
//
//public class SnoWalkerComplexShardingDB implements ComplexKeysShardingAlgorithm {
//
//    @Override
//    public Collection<String> doSharding(Collection collection, ComplexKeysShardingValue complexKeysShardingValue) {
//        System.out.println("collection:"+collection);
//        System.out.println("complexKeysShardingValue:"+complexKeysShardingValue);
//
//        String orderIdValue = getOrderId(complexKeysShardingValue, "order_id");
//        Long userIdValue = getUserId(complexKeysShardingValue, "user_id");
//        List<String> shardingSuffix = new ArrayList<>();
//        /**例如：根据user_id + order_id 双分片键来进行分表*/
//        String suffix =complexKeysShardingValue.getLogicTableName()+(orderIdValue.hashCode()+userIdValue)%2 ;
//
//        Set<List<Integer>> valueResult = Sets.cartesianProduct(orderIdValue, userIdValue);
//        for (Long userIdVal : userIdValues) {
//            for (Long orderIdVal : orderIdValues) {
//                String suffix = userIdVal % 2 + "_" + orderIdVal % 2;
//                collection.forEach(x -> {
//                    if (x.endsWith(suffix)) {
//                        shardingSuffix.add(x);
//                    }
//                });
//            }
//        }
//
//        return shardingSuffix;
//    }
//
//    private String getOrderId(ComplexKeysShardingValue shardingValues, final String key) {
//
//        Map columnNameAndShardingValuesMap = shardingValues.getColumnNameAndShardingValuesMap();
//        List o = (List)columnNameAndShardingValuesMap.get(key);
//
//        return o.get(0).toString();
//    }
//
//
//    private Long getUserId(ComplexKeysShardingValue shardingValues, final String key) {
//
//        Map columnNameAndShardingValuesMap = shardingValues.getColumnNameAndShardingValuesMap();
//        List o = (List)columnNameAndShardingValuesMap.get(key);
//
//        return Long.parseLong(o.get(0).toString());
//    }
//
//}