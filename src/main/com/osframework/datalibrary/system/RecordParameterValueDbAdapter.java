/*
    //usage

    Copyright (C) 2006  Aron Lancout Smith

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA

*/
package com.osframework.datalibrary.system;

import java.sql.*;
import java.util.*;
import com.osframework.framework.exceptions.*;
import com.osframework.framework.logging.*;
import com.osframework.datalibrary.common.*;
import com.osframework.modellibrary.common.*;
import com.osframework.modellibrary.framework.*;
import com.osframework.ejb.reference.common.*;
import com.osframework.modellibrary.reference.group.*;
import com.osframework.ejb.reference.security.*;
import com.osframework.modellibrary.system.*;

/**
null
*/
public class RecordParameterValueDbAdapter extends BaseAdapter {
	

	private IReferenceMap reference;
	private ISecurity security;

	public RecordParameterValueDbAdapter(IReferenceMap reference, ISecurity security) {
		this.reference = reference;
		this.security = security;
	}


	public UpdateResult UpdateRecordParameterValue(RecordParameterValueModel m, ServiceCall call) throws DataUpdateException {
		DbConnection conn = null;
		try {
			conn = Db.getConnection();
			return UpdateRecordParameterValue(m, call, conn);
		} catch (Exception ex) {
			throw new DataUpdateException(ex);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}


	public UpdateResult UpdateRecordParameterValue(RecordParameterValueModel m, ServiceCall call, DbConnection conn) throws DataUpdateException {
		RecordParameterValueModel original = null;
		try {
			if (m == null) {
				throw new NullArgumentException();
			}
			if (m.isNew()) {
				m.setCreateUserId(call.getUserId());
				m.setCreateDt(new GregorianCalendar());
			}
			if (m.hasModified()) {
				original = getRecordParameterValue(m.getRecordParameterValueId(), conn);
				m.setUpdateDt(new GregorianCalendar());
				m.setUpdateUserId(call.getUserId());
				m.setUpdateCount(original.getUpdateCount()+1);
				m.setSystemAssignedVersionNbr(1);
				m.copyModifiedTo(original);
				UpdateResult result = save(original, conn);
				m.setRecordParameterValueId(original.getRecordParameterValueId());
				return result;
			} else {
				return new UpdateResult();
			}
		} catch (Exception ex) {
			if (original != null) {
				Debug.LogException(this, ex, original.toString());
			} else {
				Debug.LogException(this, ex);
			}
			throw new DataUpdateException(ex); 
		}
	}
	
	private UpdateResult save(RecordParameterValueModel m, DbConnection conn) throws SQLException, AccessDataTypeException {
		int nbrRows = 0;
		String sql = "";
		SQLResult result = null;
		Vector params = null;
		try {
			if (m.getRecordParameterValueId()==0) {
				m.setRecordParameterValueId(Db.getNextSequence(TableNameFramework.RECORDPARAMETERVALUE, conn));
				sql = getInsertSql();
				params = getInsertParameters(m);
				result = Db.getAccess().executeUpdate(getInsertSql(), getInsertParameters(m), conn);
				nbrRows = result.getRowsUpdated();
			} else {
				sql = getUpdateSql();
				params = getInsertParameters(m);
				result = Db.getAccess().executeUpdate(getUpdateSql(), getUpdateParameters(m), conn);
				nbrRows = result.getRowsUpdated();
			}
			return new UpdateResult(nbrRows,m.getRecordParameterValueId());
		} catch (SQLException ex) {
			Debug.LogError(ex.getMessage(), Db.getFormattedException(ex, sql, params));
			throw ex;
		}
	}
		
	protected int ImportRecordParameterValue(RecordParameterValueModel m) throws SQLException, AccessDataTypeException {
		int nbrRows = 0;
		String sql = "";
		SQLResult result = null;
		Vector params = null;
		try {
			sql = getInsertSql();
			params = getInsertParameters(m);
			result = Db.getAccess().executeUpdate(getInsertSql(), getInsertParameters(m));
			nbrRows = result.getRowsUpdated();
			return nbrRows;
		} catch (SQLException ex) {
			Debug.LogError(ex.getMessage(), Db.getFormattedException(ex, sql, params));
			throw ex;
		}
	}
		
	public int DeleteRecordParameterValue(RecordParameterValueModel m, DbConnection conn) throws DataUpdateException {
		SQLResult result = null;
		try {
			int nbrRows = 0;
			result = Db.getAccess().executeUpdate(getDeleteSql(), getDeleteParameters(m), conn);
			nbrRows = result.getRowsUpdated();
			return nbrRows;
		} catch (Exception ex) {
			Debug.LogException(this, ex);
			throw new DataUpdateException(ex);
		}
	}
	/**
	 * Maps the resultset to the model.
	 */
	public void mapRecordParameterValue(ResultSet rset, RecordParameterValueModel m) throws SQLException {
		if (columnExists(rset, "record_parameter_value_id")) {
			m.setRecordParameterValueId(rset.getInt("record_parameter_value_id"));
			if (rset.wasNull()) m.setRecordParameterValueId(0);
		}
		if (columnExists(rset, "record_parameter_id")) {
			m.setRecordParameterId(rset.getInt("record_parameter_id"));
			if (rset.wasNull()) m.setRecordParameterId(0);
		}
		if (columnExists(rset, "parameter_seq")) {
			m.setParameterSeq(rset.getInt("parameter_seq"));
			if (rset.wasNull()) m.setParameterSeq(0);
		}
		if (columnExists(rset, "data_type_ref_id")) {
			m.setDataTypeRefId(rset.getInt("data_type_ref_id"));
			if (rset.wasNull()) m.setDataTypeRefId(0);
		}
		if (columnExists(rset, "value_int")) {
			m.setValueInt(rset.getInt("value_int"));
			if (rset.wasNull()) m.setValueInt(0);
		}
		if (columnExists(rset, "value_double")) {
			m.setValueDouble(rset.getDouble("value_double"));
			if (rset.wasNull()) m.setValueDouble(0);
		}
		if (columnExists(rset, "value_string")) {
			m.setValueString(rset.getString("value_string"));
			if (rset.wasNull()) m.setValueString(null);
		}
		if (columnExists(rset, "value_date")) {
			m.setValueDate(Db.getCalendarDate(rset.getTimestamp("value_date")));
			if (rset.wasNull()) m.setValueDate(null);
		}
		if (columnExists(rset, "create_dt")) {
			m.setCreateDt(Db.getCalendarDate(rset.getTimestamp("create_dt")));
			if (rset.wasNull()) m.setCreateDt(null);
		}
		if (columnExists(rset, "create_user_id")) {
			m.setCreateUserId(rset.getInt("create_user_id"));
			if (rset.wasNull()) m.setCreateUserId(0);
		}
		if (columnExists(rset, "update_dt")) {
			m.setUpdateDt(Db.getCalendarDate(rset.getTimestamp("update_dt")));
			if (rset.wasNull()) m.setUpdateDt(null);
		}
		if (columnExists(rset, "update_user_id")) {
			m.setUpdateUserId(rset.getInt("update_user_id"));
			if (rset.wasNull()) m.setUpdateUserId(0);
		}
		if (columnExists(rset, "update_count")) {
			m.setUpdateCount(rset.getInt("update_count"));
			if (rset.wasNull()) m.setUpdateCount(0);
		}
		if (columnExists(rset, "active_ind")) {
			m.setActiveInd(rset.getInt("active_ind"));
			if (rset.wasNull()) m.setActiveInd(0);
		}
		if (columnExists(rset, "system_assigned_version_nbr")) {
			m.setSystemAssignedVersionNbr(rset.getInt("system_assigned_version_nbr"));
			if (rset.wasNull()) m.setSystemAssignedVersionNbr(0);
		}
		if (columnExists(rset, "record_type_ref_id")) {
			m.setRecordTypeRefId(rset.getInt("record_type_ref_id"));
			if (rset.wasNull()) m.setRecordTypeRefId(0);
		}
		m.resetModified();
	}

 /**
  * Execute the SQL and return a list for the result set
  */
	public RecordParameterValueList  getRecordParameterValue(String sql) throws DataAccessException {
		DbConnection conn = null;
		try {
			conn = Db.getConnection();
			return getRecordParameterValue(sql, conn);
		} catch (Exception ex) {
			throw new DataAccessException(ex);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	} /**
  * Execute the SQL and return a list for the result set
  */
	public RecordParameterValueList  getRecordParameterValue(String sql, DbConnection conn) throws DataAccessException {
		SQLResult result = null;
		try {
			RecordParameterValueList list = new RecordParameterValueList();
			result = Db.getAccess().executeQuery(sql, conn);
			ResultSet rset = result.getRset();
			while (rset.next()) {
				RecordParameterValueModel m = new RecordParameterValueModel();
				mapRecordParameterValue(rset, m);
				list.add(m);
			}
			list.setReferenceDisplay(reference, security);
			return list;
		} catch (SQLException se) {
			Debug.LogError(this, Db.getFormattedException(se, sql));
			throw new DataAccessException(se);
		} finally {
			try { if (result!=null) result.closeStatements();} catch (Exception ex) {}
		}
	}

 /**
  * Execute the SQL and return a list for the result set
  */
	public RecordParameterValueList  getRecordParameterValue(String sql, Vector params) throws DataAccessException {
		DbConnection conn = null;
		try {
			conn = Db.getConnection();
		return getRecordParameterValue(sql, params, conn);
		} catch (Exception ex) {
			throw new DataAccessException(ex);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

 /**
  * Execute the SQL and return a list for the result set
  */
	public RecordParameterValueList  getRecordParameterValue(String sql, Vector params, DbConnection conn) throws DataAccessException {
		SQLResult result = null;
		try {
			RecordParameterValueList list = new RecordParameterValueList();
			result = Db.getAccess().executeQuery(sql, params, conn);
			ResultSet rset = result.getRset();
			while (rset.next()) {
				RecordParameterValueModel m = new RecordParameterValueModel();
				mapRecordParameterValue(rset, m);
				list.add(m);
			}
			list.setReferenceDisplay(reference, security);
			return list;
		} catch (SQLException se) {
			Debug.LogError(this, Db.getFormattedException(se, sql, params));
			throw new DataAccessException(se);
		} catch (AccessDataTypeException ae) {
			throw new DataAccessException(ae);
		} finally {
			try { if (result!=null) result.closeStatements();} catch (Exception ex) {}
		}
	}

	/**
	 * Returns the model from the database.
	 * Returns an empty model if the id is 0 or not found
	 */
	public RecordParameterValueModel getRecordParameterValue(int id) throws DataAccessException { 
		DbConnection conn = null;
		try {
			conn = Db.getConnection();
			return getRecordParameterValue(id, conn);
		} catch (Exception ex) {
			throw new DataAccessException(ex);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * Returns the model from the database.
	 * Returns an empty model if the id is 0 or not found
	 */
	public RecordParameterValueModel getRecordParameterValue(int id, DbConnection conn) throws DataAccessException { 
		SQLResult result = null;
		try {
			RecordParameterValueModel m = new RecordParameterValueModel();
			// TODO This fails if you actually wanted to get the zero row
			if (id > 0) {
				result = Db.getAccess().executeQuery(getSelectSql(), Db.getParameter(id), conn);
				ResultSet rset = result.getRset();
				if (rset.next()) {
					mapRecordParameterValue(rset, m);
					m.resetModified();
				}
			}
			m.setReferenceDisplay(reference, security);
			return m;
		} catch (Exception ex) {
			Debug.LogException(this, ex, "RecordParameterValueModel" + id);
			throw new DataAccessException(ex);
		} finally {
			try { if (result!=null) result.closeStatements();} catch (Exception ex) {}
		}
	}

	public RecordParameterValueList exportRecordParameterValue() throws DataAccessException {
		int rows = Db.countTable("record_parameter_value");
		Debug.LogInfo(this, rows + " found in record_parameter_value");
		String sql = "select * from record_parameter_value where record_type_ref_id in (?, ?)";
		RecordParameterValueList list = this.getRecordParameterValue(sql, Db.getParameter(RecordTypeFramework.SYSTEMREFERENCE, RecordTypeFramework.USERREFERENCE)); 
		Debug.LogInfo(this,list.size()  + " record_parameter_value rows exported");
		return list;
	}

	public int importRecordParameterValue(RecordParameterValueList list) throws Exception {
		Enumeration e1 = list.elements();
		int rows = 0;
		while (e1.hasMoreElements()) {
			RecordParameterValueModel m = (RecordParameterValueModel) e1.nextElement();
			rows += ImportRecordParameterValue(m);
		}
		Debug.LogInfo(this, rows + " reference_group rows imported");
		return rows;
	}

	private String getSelectSql() {
		return "select record_parameter_value_id, record_parameter_id, parameter_seq, data_type_ref_id, "
			+ "value_int, value_double, value_string, value_date, "
			+ "create_dt, create_user_id, update_dt, update_user_id, "
			+ "update_count, active_ind, system_assigned_version_nbr, record_type_ref_id"
			+ " from record_parameter_value "
			+ " where record_parameter_value_id = ?";				 
	}
	
	private String getInsertSql() {
		return "insert into record_parameter_value (record_parameter_value_id, record_parameter_id, parameter_seq, data_type_ref_id, "
			+ "value_int, value_double, value_string, value_date, "
			+ "create_dt, create_user_id, update_dt, update_user_id, "
			+ "update_count, active_ind, system_assigned_version_nbr, record_type_ref_id)"
			+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";				 
	}
	
	private Vector getInsertParameters(RecordParameterValueModel m) {
		Vector v = new Vector(16);
		v.add(new Integer(m.getRecordParameterValueId()));
		v.add(new Integer(m.getRecordParameterId()));
		v.add(new Integer(m.getParameterSeq()));
		v.add(new Integer(m.getDataTypeRefId()));
		v.add(new Integer(m.getValueInt()));
		v.add(new Double(m.getValueDouble()));
		if (m.getValueString() != null) v.add(m.getValueString());
		else v.add(new Null(new String()));
		if (m.getValueDate() != null) v.add(m.getValueDate());
		else v.add(new Null(new GregorianCalendar()));
		if (m.getCreateDt() != null) v.add(m.getCreateDt());
		else v.add(new Null(new GregorianCalendar()));
		v.add(new Integer(m.getCreateUserId()));
		if (m.getUpdateDt() != null) v.add(m.getUpdateDt());
		else v.add(new Null(new GregorianCalendar()));
		v.add(new Integer(m.getUpdateUserId()));
		v.add(new Integer(m.getUpdateCount()));
		v.add(new Integer(m.getActiveInd()));
		v.add(new Integer(m.getSystemAssignedVersionNbr()));
		v.add(new Integer(m.getRecordTypeRefId()));
		return v;
	}
	
	private String getUpdateSql() {
		return "update record_parameter_value set  record_parameter_id = ?, parameter_seq = ?, data_type_ref_id = ?, "
			+ "value_int = ?, value_double = ?, value_string = ?, value_date = ?, "
			+ "create_dt = ?, create_user_id = ?, update_dt = ?, update_user_id = ?, "
			+ "update_count = ?, active_ind = ?, system_assigned_version_nbr = ?, record_type_ref_id = ? "
			+ " where record_parameter_value_id = ?";				 
	}
	
	private Vector getUpdateParameters(RecordParameterValueModel m) {
		Vector v = new Vector(16);
		v.add(new Integer(m.getRecordParameterId()));
		v.add(new Integer(m.getParameterSeq()));
		v.add(new Integer(m.getDataTypeRefId()));
		v.add(new Integer(m.getValueInt()));
		v.add(new Double(m.getValueDouble()));
		if (m.getValueString() != null) v.add(m.getValueString());
		else v.add(new Null(new String()));
		if (m.getValueDate() != null) v.add(m.getValueDate());
		else v.add(new Null(new GregorianCalendar()));
		if (m.getCreateDt() != null) v.add(m.getCreateDt());
		else v.add(new Null(new GregorianCalendar()));
		v.add(new Integer(m.getCreateUserId()));
		if (m.getUpdateDt() != null) v.add(m.getUpdateDt());
		else v.add(new Null(new GregorianCalendar()));
		v.add(new Integer(m.getUpdateUserId()));
		v.add(new Integer(m.getUpdateCount()));
		v.add(new Integer(m.getActiveInd()));
		v.add(new Integer(m.getSystemAssignedVersionNbr()));
		v.add(new Integer(m.getRecordTypeRefId()));
		v.add(new Integer(m.getRecordParameterValueId()));
		return v;
	}

	private Vector getDeleteParameters(RecordParameterValueModel m) {
		Vector v = new Vector(16);
		v.add(new Integer(m.getRecordParameterValueId()));
		return v;
	}

	private String getDeleteSql() {
		return "delete from record_parameter_value where record_parameter_value_id = ?";				 
	}

}
