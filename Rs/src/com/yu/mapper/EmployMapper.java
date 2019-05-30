package com.yu.mapper;

import com.yu.pojo.Employ;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployMapper {
    /**
     * 求职者申请指定公司职位
     */
    @Insert("insert into employ values(default,#{0},#{1},0,#{2})")
    public int insEmploy(int pid,int cid,String position);

    /**
     * 查询指定的求职者已经申请的公司
     */
    public List<Employ> selAppliedCom(int pid);

    /**
     * 查询指定公司申请的求职者
     */
    public List<Employ> selPersonByCid(int cid);

    /**
     * 修改是否通过简历
     */
    @Update("update employ set status=#{2} where cid=#{0} and pid=#{1} and position=#{3}")
    public int updateAgreeOrDis(int cid,int pid,int status,String position);
}
