package org.seckill.dao;import org.apache.ibatis.annotations.Param;import org.seckill.entity.SuccessKilled;/** * Created by saplmm on 2016/10/12. */public interface SuccessKilledDao {    /**     * 插入购买明细,可过滤重复     *     * @param seckillId     * @param userPhone     * @return 插入的行数，返回0表示插入失败     */    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);    /**     * 更具id查询successKilled并且带秒杀产品对象实体..     *     * @param seckillId     * @return     */    SuccessKilled queryByIdWithSeckill(long seckillId);}