package com.ez.mybatisdynamicsourceplus.type;

/**
 * @Classname DataSourceType
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
public class DataSourceType {

	public enum DataBaseType {
		Master, Slave
	}

	// 使用ThreadLocal保证线程安全
	private static final ThreadLocal<DataBaseType> TYPE = new ThreadLocal<DataBaseType>();

	// 往当前线程里设置数据源类型
	public static void setDataBaseType(DataBaseType dataBaseType) {
		if (dataBaseType == null) {
			throw new NullPointerException();
		}
		TYPE.set(dataBaseType);
	}

	// 获取数据源类型
	public static DataBaseType getDataBaseType() {
		DataBaseType dataBaseType = TYPE.get() == null ? DataBaseType.Master : TYPE.get();
		return dataBaseType;
	}

	// 清空数据类型
	public static void clearDataBaseType() {
		TYPE.remove();
	}
}
