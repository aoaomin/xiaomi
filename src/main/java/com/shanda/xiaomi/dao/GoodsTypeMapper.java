package com.shanda.xiaomi.dao;

import com.shanda.xiaomi.entry.GoodsType;
import com.shanda.xiaomi.entry.GoodsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    long countByExample(GoodsTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    int deleteByExample(GoodsTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    int insert(GoodsType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    int insertSelective(GoodsType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    List<GoodsType> selectByExample(GoodsTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    GoodsType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    int updateByExampleSelective(@Param("record") GoodsType record, @Param("example") GoodsTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    int updateByExample(@Param("record") GoodsType record, @Param("example") GoodsTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    int updateByPrimaryKeySelective(GoodsType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    int updateByPrimaryKey(GoodsType record);
}