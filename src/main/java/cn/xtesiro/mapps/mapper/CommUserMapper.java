package cn.xtesiro.mapps.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.xtesiro.mapps.common.entity.CommUser;
import cn.xtesiro.mapps.common.mybatis.IBaseDao;

@Mapper
public interface CommUserMapper extends IBaseDao<CommUser>
{
	@Select("select id,authorities,descn,password,status,username,isDelete,userGroup_id as userGroupId,pinyin from Comm_User where username = #{username, jdbcType=VARCHAR} and password= #{password, jdbcType=VARCHAR}")
	CommUser getCommUser(@Param("username") String username, @Param("password") String password);
}
