package cn.xtesiro.mapps.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.xtesiro.mapps.common.entity.CommResc;
import cn.xtesiro.mapps.common.mybatis.IBaseDao;

@Mapper
public interface CommRescMapper extends IBaseDao<CommResc> {
	@Select("select e.id,e.descn,e.name,e.presc,e.priority,e.res_code as resCode "
		  + "      ,e.res_string as resString,e.res_type as resType "
		  + "from comm_user a,comm_user_role b,comm_role c,comm_resc_role d,comm_resc e "
		  + "where a.id = #{userId, jdbcType=VARCHAR} "
		  + "  and a.id = b.user_id "
		  + "  and b.role_id = c.id "
		  + "  and c.id = d.role_id "
		  + "  and d.resc_id = e.id "
		  + "  and e.res_code like 'MENU%' "
		  + "  order by e.priority ")
	List<CommResc> getMenuRescByUserId(@Param("userId") String userId);

	@Select("select e.id,e.descn,e.name,e.presc,e.priority,e.res_code as resCode "
			  + "      ,e.res_string as resString,e.res_type as resType "
			  + "from comm_role c,comm_resc_role d,comm_resc e "
			  + "where c.id = #{roleId, jdbcType=VARCHAR} "
			  + "  and c.id = d.role_id "
			  + "  and d.resc_id = e.id "
			  + "  and e.res_code like 'MENU%' "
			  + "  order by e.priority ")
	List<CommResc> getMenuRescByRoleId(@Param("roleId") String roleId);
}