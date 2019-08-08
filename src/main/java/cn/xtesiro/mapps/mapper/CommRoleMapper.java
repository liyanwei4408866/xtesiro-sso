package cn.xtesiro.mapps.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.xtesiro.mapps.common.entity.CommRole;
import cn.xtesiro.mapps.common.mybatis.IBaseDao;

public interface CommRoleMapper extends IBaseDao<CommRole> {
	@Select("select c.id,c.descn,c.name "
		  + "from comm_user a,comm_user_role b,comm_role c "
		  + "where a.id = #{userId, jdbcType=VARCHAR} "
		  + "  and a.id = b.user_id "
		  + "  and b.role_id = c.id ")
	List<CommRole> getCommRoleByUserId(@Param("userId") String userId);

	@Delete("delete from comm_role where role_id in "
		  + "( "
		  + "  select b.role_id from comm_user a,comm_user_role b"
		  + "  where a.id = #{userId, jdbcType=VARCHAR} "
		  + "    and a.id = b.user_id"
		  + ") ")
	public int delByUserId(@Param("userId") String userId);
}