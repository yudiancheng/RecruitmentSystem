package com.yu.mapper;

import com.yu.pojo.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 简历数据访问层接口
 */
@Repository
public interface ResumeMapper {
    /**
     *插入简历
     */
    @Insert("insert into resume values(default,#{0})")
    public int insResume(int pid);

    /**
     * 删除简历
     */
    @Delete("delete from resume where pid=#{0}")
    public int updResume(int pid);

    /**
     * 查询简历
     */
    public List<Person> selResume(HashMap<String,Object> map);

    /**
     * 查询符合条件的总记录数
     */
    public int selResumeCount(HashMap<String,Object> map);
}
