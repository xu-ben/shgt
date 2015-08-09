package shgt.logic;

import java.io.Serializable;
import java.sql.Date;

/**
 * 物品类
 * @author ben
 *
 */
public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 物品类型
	 */
	private GoodsType gt = null;
	
	/**
	 * id
	 */
	private int id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 价格(单位：元)
	 */
	private int price;
	
	/**
	 * 发布日期
	 */
	private Date releaseDate;
	
	/**
	 * 图片的本地路径
	 */
	private String picPath;
	
	/**
	 * 描述
	 */
	private String descriptoin;

	/**
	 * @return the gt
	 */
	public GoodsType getGt() {
		return gt;
	}

	/**
	 * @param gt the gt to set
	 */
	public void setGt(GoodsType gt) {
		this.gt = gt;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the picPath
	 */
	public String getPicPath() {
		return picPath;
	}

	/**
	 * @param picPath the picPath to set
	 */
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	/**
	 * @return the descriptoin
	 */
	public String getDescriptoin() {
		return descriptoin;
	}

	/**
	 * @param descriptoin the descriptoin to set
	 */
	public void setDescriptoin(String descriptoin) {
		this.descriptoin = descriptoin;
	}

}
