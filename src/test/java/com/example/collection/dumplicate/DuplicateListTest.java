package com.example.collection.dumplicate;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * List集合去重
 *
 * @author hongwei.lian
 * @date 2018年3月11日 下午8:54:57
 */
public class DuplicateListTest {
    private final int SIZE_INITIAL_CAPACITY=10;
    /**
     * 存储没有去重的明细对象的List集合
     */
    private List<TradeDetail> tradeDetailList;
    /**
     * 存储去重后的明细对象的List集合
     */
    private List<TradeDetail> duplicateTradeDetailList;
    /**
     * 存储去重后的明细对象的Set集合
     */
    private Set<TradeDetail> tradeDetailSet;

    /**
     * 初始化tradeDetailList
     *
     * @author hongwei.lian
     * @date 2018年3月11日 下午9:04:45
     */
    @Before
    public void InitTradeDetailList() {
        tradeDetailList = new ArrayList<TradeDetail>(SIZE_INITIAL_CAPACITY);
        tradeDetailList.add(new TradeDetail(1, "600010", "账户一", new BigDecimal(100.00)));
        tradeDetailList.add(new TradeDetail(2, "600011", "账户二", new BigDecimal(100.00)));
        tradeDetailList.add(new TradeDetail(3, "600010", "账户一", new BigDecimal(-100.00)));
        tradeDetailList.add(new TradeDetail(4, "600010", "账户一", new BigDecimal(-100.00)));

        tradeDetailList.add(new TradeDetail(1, "600010", "账户一", new BigDecimal(100.00)));
        tradeDetailList.add(new TradeDetail(2, "600011", "账户二", new BigDecimal(100.00)));
        tradeDetailList.add(new TradeDetail(3, "600010", "账户一", new BigDecimal(-100.00)));
        tradeDetailList.add(new TradeDetail(4, "600010", "账户一", new BigDecimal(-100.00)));

        tradeDetailList.add(new TradeDetail(1, "600010", "账户一", new BigDecimal(100.00)));
        tradeDetailList.add(new TradeDetail(2, "600011", "账户二", new BigDecimal(100.00)));
        tradeDetailList.add(new TradeDetail(3, "600010", "账户一", new BigDecimal(-100.00)));
        tradeDetailList.add(new TradeDetail(4, "600010", "账户一", new BigDecimal(-100.00)));
    }

    /**
     * 使用Set接口的实现类HashSet进行List集合去重
     *
     * @author hongwei.lian
     * @date 2018年3月11日 下午9:37:51
     */
    @Test
    public void testDuplicateListWithHashSet() {
        //-- 前提是TradeDetail根据规则重写hashCode()方法和equals()方法
        tradeDetailSet = new HashSet<TradeDetail>(tradeDetailList);
        tradeDetailSet.forEach(System.out::println);
    }

    /**
     * 使用Map集合进行List集合去重
     *
     * @author hongwei.lian
     * @date 2018年3月11日 下午9:05:49
     */
    @Test
    public void testDuplicateListWithIterator() {
        duplicateTradeDetailList = new ArrayList<>();
        Map<String, TradeDetail> tradeDetailMap = tradeDetailList.stream()
                .collect(Collectors.toMap(
                        tradeDetail -> tradeDetail.getAccountNo(),
                        tradeDetail -> tradeDetail,
                        (oldValue, newValue) -> newValue));
        tradeDetailMap.forEach(
                (accountNo, tradeDetail) -> duplicateTradeDetailList.add(tradeDetail)
        );
        duplicateTradeDetailList.forEach(System.out::println);
//-- 参考文章
//http://blog.jobbole.com/104067/
//https://www.cnblogs.com/java-zhao/p/5492122.html
    }

    /**
     * 使用Set接口的实现类TreeSet进行List集合去重
     * <p>
     * TreeSet实现类
     * 构造方法：
     * public TreeSet(Comparator<? super E> comparator)
     *
     * @author hongwei.lian
     * @date 2018年3月11日 下午9:37:48
     */
    @Test
    public void testDuplicateListWithTreeSet() {
        tradeDetailSet = new TreeSet<TradeDetail>(
                (tradeDetail1, tradeDetail2) ->
                        tradeDetail1.getAccountNo().compareTo(tradeDetail2.getAccountNo())
        );
        tradeDetailSet.addAll(tradeDetailList);
        tradeDetailSet.forEach(System.out::println);
    }

    public void testDumplicateListWithTreeSet2(){
        tradeDetailSet=new TreeSet<>(new Comparator<TradeDetail>() {
            @Override
            public int compare(TradeDetail o1, TradeDetail o2) {
                return o1.getAccountNo().compareTo(o2.getAccountNo());
            }
        });
    }


}
