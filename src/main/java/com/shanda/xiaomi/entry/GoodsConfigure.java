package com.shanda.xiaomi.entry;

public class GoodsConfigure {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_configure.id
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_configure.info
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    private String info;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_configure.goods_id
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    private Integer goodsId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_configure.id
     *
     * @return the value of goods_configure.id
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_configure.id
     *
     * @param id the value for goods_configure.id
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_configure.info
     *
     * @return the value of goods_configure.info
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_configure.info
     *
     * @param info the value for goods_configure.info
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_configure.goods_id
     *
     * @return the value of goods_configure.goods_id
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_configure.goods_id
     *
     * @param goodsId the value for goods_configure.goods_id
     *
     * @mbg.generated Tue Oct 19 20:32:21 CST 2021
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}