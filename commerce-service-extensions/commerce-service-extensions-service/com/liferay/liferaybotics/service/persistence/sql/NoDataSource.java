package com.liferay.liferaybotics.service.persistence.sql;

import javax.sql.DataSource;

/**
 * class NoDataSource: A factory class to do nothing but return a null data
 * source object.
 *
 * @author Jack Bakker
 */
public class NoDataSource {
	/**
	 * getDataSource: Supposed to return a DataSource.
	 * 
	 * @return DataSource Always returns null.
	 */
	public static DataSource getDataSource() {
		return null;
	}
}