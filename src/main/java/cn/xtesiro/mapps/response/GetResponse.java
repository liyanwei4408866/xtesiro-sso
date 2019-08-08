package cn.xtesiro.mapps.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.xtesiro.mapps.common.entity.CommUser;
import cn.xtesiro.mapps.common.response.BaseResponse;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "result")
public class GetResponse extends BaseResponse
{
    @XmlElement(name = "total")
    private long         total;
    @XmlElement(name = "oaUserList")
	private List<CommUser> oaUserList;

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

	public List<CommUser> getOaUserList()
    {
        return oaUserList;
    }

	public void setOaUserList(List<CommUser> oaUserList)
    {
        this.oaUserList = oaUserList;
    }
}
