package cn.xtesiro.mapps.entity;

import java.util.Date;

public class LrmsInstrument {
    private String id;

    private String instrumentName;

    private String instrumentPic;

    private Integer isCharges;

    private String manufacturer;

    private Double purchasePrice;

    private String reservationInformation;

    private String resettlementAddr;

    private String specification;

    private Integer status;

    private Integer isDelete;

    private Date time;

    private String member_id;

    private String attachment;

    private Double chargesMoney;

    private Integer isShow;

    private String lab_id;

    private String assetNo;

    private Boolean isRepeat;

    private Boolean isStudy;

    private String instrumentDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName == null ? null : instrumentName.trim();
    }

    public String getInstrumentPic() {
        return instrumentPic;
    }

    public void setInstrumentPic(String instrumentPic) {
        this.instrumentPic = instrumentPic == null ? null : instrumentPic.trim();
    }

    public Integer getIsCharges() {
        return isCharges;
    }

    public void setIsCharges(Integer isCharges) {
        this.isCharges = isCharges;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getReservationInformation() {
        return reservationInformation;
    }

    public void setReservationInformation(String reservationInformation) {
        this.reservationInformation = reservationInformation == null ? null : reservationInformation.trim();
    }

    public String getResettlementAddr() {
        return resettlementAddr;
    }

    public void setResettlementAddr(String resettlementAddr) {
        this.resettlementAddr = resettlementAddr == null ? null : resettlementAddr.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id == null ? null : member_id.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public Double getChargesMoney() {
        return chargesMoney;
    }

    public void setChargesMoney(Double chargesMoney) {
        this.chargesMoney = chargesMoney;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getLab_id() {
        return lab_id;
    }

    public void setLab_id(String lab_id) {
        this.lab_id = lab_id == null ? null : lab_id.trim();
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo == null ? null : assetNo.trim();
    }

    public Boolean getIsRepeat() {
        return isRepeat;
    }

    public void setIsRepeat(Boolean isRepeat) {
        this.isRepeat = isRepeat;
    }

    public Boolean getIsStudy() {
        return isStudy;
    }

    public void setIsStudy(Boolean isStudy) {
        this.isStudy = isStudy;
    }

    public String getInstrumentDescription() {
        return instrumentDescription;
    }

    public void setInstrumentDescription(String instrumentDescription) {
        this.instrumentDescription = instrumentDescription == null ? null : instrumentDescription.trim();
    }
}