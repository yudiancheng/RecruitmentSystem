package com.yu.mapper;

import com.yu.pojo.Needs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 人才需求数据访问层接口
 */
@Repository
public interface NeedsMapper {

    /**
     * 发布招聘信息
     */
    @Insert("insert into company_needs values(default,#{0},#{1},#{2})")
    public int insNeeds(int cid,String needs,String salary);

    /**
     * 撤销招聘信息
     */
    @Delete("delete from company_needs where cid=#{0} and needs=#{1}")
    public int delNeeds(int cid,String needs);

    /**
     * 通过cid查询企业需求
     */
    public List<Needs> selNeedsByCid(int cid);
}
