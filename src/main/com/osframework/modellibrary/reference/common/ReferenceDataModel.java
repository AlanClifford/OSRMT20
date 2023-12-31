/*
     * The Reference model is a domain object which stores lookup table id and display values
 * such as for gender, countries, patient types etc.   Whereever possible reference type
 * data should be stored in this table to reduce the number of tables in the schema.
 * The ReferenceDataModel is auto generated by generator.GenerateModel.getModelSource()
 * and is subclassed by ReferenceModel generated once by GenerateModel.getExtendedModelSouce().
 * Any business logic should be added to ReferenceModel.  The ReferenceList is a collection
 * of ReferenceModels and is auto generated by GenerateModel.getListSource.  How the list stores
 * the models depends on the parameters defined in osrmt_schem.mdb ModelLibrary.

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
package com.osframework.modellibrary.reference.common;
import java.util.*;
import com.osframework.framework.locale.*;
import com.osframework.framework.logging.*;
import com.osframework.framework.utility.*;
import com.osframework.framework.exceptions.*;
import com.osframework.ejb.reference.common.*;
import com.osframework.ejb.reference.security.*;
import com.osframework.modellibrary.common.*;
import com.osframework.modellibrary.reference.group.*;
import com.osframework.appclient.services.*;
import com.osframework.modellibrary.reference.security.*;

/**
 * The Reference model is a domain object which stores lookup table id and display values
 * such as for gender, countries, patient types etc.   Whereever possible reference type
 * data should be stored in this table to reduce the number of tables in the schema.
 * The ReferenceDataModel is auto generated by generator.GenerateModel.getModelSource()
 * and is subclassed by ReferenceModel generated once by GenerateModel.getExtendedModelSouce().
 * Any business logic should be added to ReferenceModel.  The ReferenceList is a collection
 * of ReferenceModels and is auto generated by GenerateModel.getListSource.  How the list stores
 * the models depends on the parameters defined in osrmt_schem.mdb ModelLibrary.
*/
public class ReferenceDataModel implements IControlModel, java.io.Serializable {

	static final long serialVersionUID = 1L;
	private int hashsize = 15;
	private Hashtable modifiedFields = new Hashtable(hashsize);
	private boolean referenceSet = false;


	/** Unique identifier for reference table  */
	private int refId = 0;

	/** Reference group  */
	private String referenceGroup;

	/** Provides for subsets of the reference code based upon application needs  */
	private int appTypeRefId = 0;

	private String appTypeRefDisplay="";

	/** Identifies this display and is unique (within the group) when combined with sequence  */
	private String displayCode;

	/** Display sequence  */
	private int displaySequence = 0;

	/** Reference code display  */
	private String display;

	/** Description of this reference code  */
	private String description;

	/** Date the record was created  */
	private DbCalendar createDt = DbCalendar.getDbCalendar();

	/** User that created this record  */
	private int createUserId = 0;

	private String createUserName="";

	/** Date the record was updated  */
	private DbCalendar updateDt = DbCalendar.getDbCalendar();

	/** Date the record was last updated  */
	private int updateUserId = 0;

	private String updateUserName="";

	/** Number of times this record has been updated  */
	private int updateCount = 0;

	/** Active indicator 1=Active 0=Inactive  */
	private int activeInd = 1;

	/** 0: Customer defined >0:   */
	private int systemAssignedVersionNbr = 5;

	/** Identifies database row as Reference or Record and System or User entered  */
	private int recordTypeRefId = 321;

	private String recordTypeRefDisplay="";


	/** 
	 * Unique identifier for reference table
	 * 
	 */ 
	public int getRefId() {
		return refId;
	}

	/** 
	 * Unique identifier for reference table
	 * 
	 */ 
	public void setRefId(int refId) {
		if (!Comparison.areEqual(this.refId, refId)) {
			this.refId = refId;
			setModified("refId");
		};
	}

	/** 
	 * Reference group
	 * 
	 */ 
	public String getReferenceGroup() {
		return referenceGroup;
	}

	/** 
	 * Reference group
	 * 
	 */ 
	public void setReferenceGroup(String referenceGroup) {
		if (!Comparison.areEqual(this.referenceGroup, referenceGroup)) {
			this.referenceGroup = referenceGroup;
			setModified("referenceGroup");
		};
	}

	/** 
	 * Provides for subsets of the reference code based upon application needs
	 * 
	 */ 
	public int getAppTypeRefId() {
		return appTypeRefId;
	}

	/** 
	 * Provides for subsets of the reference code based upon application needs
	 * 
	 * Required database field.
	 */ 
	public void setAppTypeRefId(int appTypeRefId) {
		if (!Comparison.areEqual(this.appTypeRefId, appTypeRefId)) {
			this.appTypeRefId = appTypeRefId;
			setModified("appTypeRefId");
		};
	}

	/** 
	 * Provides for subsets of the reference code based upon application needs
	 * 
	 */ 
	public String getAppTypeRefDisplay() {
		return appTypeRefDisplay;
	}

	/** 
	 * Provides for subsets of the reference code based upon application needs
	 * 
	 */ 
	public void setAppTypeRefDisplay(String display) {
		this.appTypeRefDisplay = display;
	}

	/** 
	 * Identifies this display and is unique (within the group) when combined with sequence
	 * 
	 */ 
	public String getDisplayCode() {
		return displayCode;
	}

	/** 
	 * Identifies this display and is unique (within the group) when combined with sequence
	 * 
	 */ 
	public void setDisplayCode(String displayCode) {
		if (!Comparison.areEqual(this.displayCode, displayCode)) {
			this.displayCode = displayCode;
			setModified("displayCode");
		};
	}

	/** 
	 * Display sequence
	 * 
	 */ 
	public int getDisplaySequence() {
		return displaySequence;
	}

	/** 
	 * Display sequence
	 * 
	 * Required database field.
	 */ 
	public void setDisplaySequence(int displaySequence) {
		if (!Comparison.areEqual(this.displaySequence, displaySequence)) {
			this.displaySequence = displaySequence;
			setModified("displaySequence");
		};
	}

	/** 
	 * Reference code display
	 * 
	 */ 
	public String getDisplay() {
		return display;
	}

	/** 
	 * Reference code display
	 * 
	 */ 
	public void setDisplay(String display) {
		if (!Comparison.areEqual(this.display, display)) {
			this.display = display;
			setModified("display");
		};
	}

	/** 
	 * Description of this reference code
	 * 
	 */ 
	public String getDescription() {
		return description;
	}

	/** 
	 * Description of this reference code
	 * 
	 */ 
	public void setDescription(String description) {
		if (!Comparison.areEqual(this.description, description)) {
			this.description = description;
			setModified("description");
		};
	}

	/** 
	 * Date the record was created
	 * 
	 */ 
	public DbCalendar getCreateDt() {
		return createDt;
	}

	/** 
	 * Date the record was created
	 * 
	 */ 
	public void setCreateDt(GregorianCalendar createDt) {
		if (!Comparison.areEqual(this.createDt, createDt)) {
			this.createDt = new DbCalendar();
			if (createDt != null) {
				this.createDt.setTimeInMillis(createDt.getTimeInMillis());
			}
			setModified("createDt");
		};
	}

	/** 
	 * Date the record was created
	 * 
	 */ 
	public void setCreateDt(long milliseconds) {
		if (this.createDt==null) {
			this.createDt = new DbCalendar();
		}
		if (!Comparison.areEqual(this.createDt, createDt)) {
			this.createDt.setTimeInMillis(milliseconds);
			setModified("createDt");
		}

	}

	/** 
	 * User that created this record
	 * 
	 */ 
	public int getCreateUserId() {
		return createUserId;
	}

	/** 
	 * User that created this record
	 * 
	 * Required database field.
	 */ 
	public void setCreateUserId(int createUserId) {
		if (!Comparison.areEqual(this.createUserId, createUserId)) {
			this.createUserId = createUserId;
			setModified("createUserId");
		};
	}

	/** 
	 * User that created this record
	 * 
	 */ 
	public String getCreateUserName() {
		return createUserName;
	}

	/** 
	 * User that created this record
	 * 
	 */ 
	public void setCreateUserName(String userName) {
		this.createUserName = userName;
	}

	/** 
	 * Date the record was updated
	 * 
	 */ 
	public DbCalendar getUpdateDt() {
		return updateDt;
	}

	/** 
	 * Date the record was updated
	 * 
	 */ 
	public void setUpdateDt(GregorianCalendar updateDt) {
		if (!Comparison.areEqual(this.updateDt, updateDt)) {
			this.updateDt = new DbCalendar();
			if (updateDt != null) {
				this.updateDt.setTimeInMillis(updateDt.getTimeInMillis());
			}
			setModified("updateDt");
		};
	}

	/** 
	 * Date the record was updated
	 * 
	 */ 
	public void setUpdateDt(long milliseconds) {
		if (this.updateDt==null) {
			this.updateDt = new DbCalendar();
		}
		if (!Comparison.areEqual(this.updateDt, updateDt)) {
			this.updateDt.setTimeInMillis(milliseconds);
			setModified("updateDt");
		}

	}

	/** 
	 * Date the record was last updated
	 * 
	 */ 
	public int getUpdateUserId() {
		return updateUserId;
	}

	/** 
	 * Date the record was last updated
	 * 
	 * Required database field.
	 */ 
	public void setUpdateUserId(int updateUserId) {
		if (!Comparison.areEqual(this.updateUserId, updateUserId)) {
			this.updateUserId = updateUserId;
			setModified("updateUserId");
		};
	}

	/** 
	 * Date the record was last updated
	 * 
	 */ 
	public String getUpdateUserName() {
		return updateUserName;
	}

	/** 
	 * Date the record was last updated
	 * 
	 */ 
	public void setUpdateUserName(String userName) {
		this.updateUserName = userName;
	}

	/** 
	 * Number of times this record has been updated
	 * 
	 */ 
	public int getUpdateCount() {
		return updateCount;
	}

	/** 
	 * Number of times this record has been updated
	 * 
	 * Required database field.
	 */ 
	public void setUpdateCount(int updateCount) {
		if (!Comparison.areEqual(this.updateCount, updateCount)) {
			this.updateCount = updateCount;
			setModified("updateCount");
		};
	}

	/** 
	 * Active indicator 1=Active 0=Inactive
	 * 
	 */ 
	public int getActiveInd() {
		return activeInd;
	}

	/** 
	 * Active indicator 1=Active 0=Inactive
	 * 
	 * Required database field.
	 */ 
	public void setActiveInd(int activeInd) {
		if (!Comparison.areEqual(this.activeInd, activeInd)) {
			this.activeInd = activeInd;
			setModified("activeInd");
		};
	}

	/** 
	 * Active indicator 1=Active 0=Inactive
	 * 
	 */ 
	public boolean isActive() {
		return activeInd == 1;
	}

	/** 
	 * Active indicator 1=Active 0=Inactive
	 * 
	 */ 
	public boolean isNotActive() {
		return activeInd == 0;
	}

	/** 
	 * Active indicator 1=Active 0=Inactive
	 * 
	 */ 
	public void setActive() {
		this.setActiveInd(1);
	}

	public void setNotActive() {
		this.setActiveInd(0);
	}

	/** 
	 * 0: Customer defined >0: 
	 * 
	 */ 
	public int getSystemAssignedVersionNbr() {
		return systemAssignedVersionNbr;
	}

	/** 
	 * 0: Customer defined >0: 
	 * 
	 * Required database field.
	 */ 
	public void setSystemAssignedVersionNbr(int systemAssignedVersionNbr) {
		if (!Comparison.areEqual(this.systemAssignedVersionNbr, systemAssignedVersionNbr)) {
			this.systemAssignedVersionNbr = systemAssignedVersionNbr;
			setModified("systemAssignedVersionNbr");
		};
	}

	/** 
	 * Identifies database row as Reference or Record and System or User entered
	 * 
	 */ 
	public int getRecordTypeRefId() {
		return recordTypeRefId;
	}

	/** 
	 * Identifies database row as Reference or Record and System or User entered
	 * 
	 * Required database field.
	 */ 
	public void setRecordTypeRefId(int recordTypeRefId) {
		if (!Comparison.areEqual(this.recordTypeRefId, recordTypeRefId)) {
			this.recordTypeRefId = recordTypeRefId;
			setModified("recordTypeRefId");
		};
	}

	/** 
	 * Identifies database row as Reference or Record and System or User entered
	 * 
	 */ 
	public String getRecordTypeRefDisplay() {
		return recordTypeRefDisplay;
	}

	/** 
	 * Identifies database row as Reference or Record and System or User entered
	 * 
	 */ 
	public void setRecordTypeRefDisplay(String display) {
		this.recordTypeRefDisplay = display;
	}


public static ResultColumnList getResultColumnList() {
	ResultColumnList columns = new ResultColumnList();
		columns.addColumn("refId", Integer.class);
		columns.addColumn("referenceGroup", String.class);
		columns.addColumn("appTypeRefId", Integer.class);
		columns.addColumn("appTypeRefDisplay", String.class);
		columns.addColumn("displayCode", String.class);
		columns.addColumn("displaySequence", Integer.class);
		columns.addColumn("display", String.class);
		columns.addColumn("description", String.class);
		columns.addColumn("createDt", GregorianCalendar.class);
		columns.addColumn("createUserId", Integer.class);
		columns.addColumn("createUserName", String.class);
		columns.addColumn("updateDt", GregorianCalendar.class);
		columns.addColumn("updateUserId", Integer.class);
		columns.addColumn("updateUserName", String.class);
		columns.addColumn("updateCount", Integer.class);
		columns.addColumn("activeInd", Integer.class);
		columns.addColumn("systemAssignedVersionNbr", Integer.class);
		columns.addColumn("recordTypeRefId", Integer.class);
		columns.addColumn("recordTypeRefDisplay", String.class);
		return columns;
	}
		
	/** 
	 * Flags this field as being modified
	 */ 
	public void setReferenceDisplay(IReferenceMap reference, ISecurity security) {
		try {
			if (referenceSet) {
				return;
			}
		referenceSet = true;
			if (reference != null && this.appTypeRefId > 0) setAppTypeRefDisplay(reference.getDisplay(this.appTypeRefId));
			if (security != null && this.createUserId > 0) setCreateUserName(security.getUser(this.createUserId).getDisplayName());
			if (security != null && this.updateUserId > 0) setUpdateUserName(security.getUser(this.updateUserId).getDisplayName());
			if (reference != null && this.recordTypeRefId > 0) setRecordTypeRefDisplay(reference.getDisplay(this.recordTypeRefId));
		} catch (Exception e) {
			Debug.LogException(this, e);
		}
	}		
	/** 
	 * Flags this field as being modified
	 */ 
	public void setModified(String fieldName) {
		if (!modifiedFields.containsKey(fieldName)) {
			modifiedFields.put(fieldName, "1");
		}
	}

	/** 
	 * Resets flagged fields so none are marked as modified
	 */ 
	public void resetModified() {
		modifiedFields = new Hashtable(hashsize);
	}

	public boolean hasModified() {
		return modifiedFields.size() > 0;
	}

	
		
	/** 
	 * Copys the values of all modified fields to object m
	 */ 
	public void copyModifiedTo(ReferenceDataModel m) {
		Enumeration e1 = modifiedFields.keys();
		while (e1.hasMoreElements()) {
			String fieldName = (String) e1.nextElement();

			if (fieldName.compareTo("refId")==0)
				m.setRefId(this.getRefId());
			else if (fieldName.compareTo("referenceGroup")==0)
				m.setReferenceGroup(this.getReferenceGroup());
			else if (fieldName.compareTo("appTypeRefId")==0)
				m.setAppTypeRefId(this.getAppTypeRefId());
			else if (fieldName.compareTo("displayCode")==0)
				m.setDisplayCode(this.getDisplayCode());
			else if (fieldName.compareTo("displaySequence")==0)
				m.setDisplaySequence(this.getDisplaySequence());
			else if (fieldName.compareTo("display")==0)
				m.setDisplay(this.getDisplay());
			else if (fieldName.compareTo("description")==0)
				m.setDescription(this.getDescription());
			else if (fieldName.compareTo("createDt")==0)
				m.setCreateDt(this.getCreateDt());
			else if (fieldName.compareTo("createUserId")==0)
				m.setCreateUserId(this.getCreateUserId());
			else if (fieldName.compareTo("updateDt")==0)
				m.setUpdateDt(this.getUpdateDt());
			else if (fieldName.compareTo("updateUserId")==0)
				m.setUpdateUserId(this.getUpdateUserId());
			else if (fieldName.compareTo("updateCount")==0)
				m.setUpdateCount(this.getUpdateCount());
			else if (fieldName.compareTo("activeInd")==0)
				m.setActiveInd(this.getActiveInd());
			else if (fieldName.compareTo("systemAssignedVersionNbr")==0)
				m.setSystemAssignedVersionNbr(this.getSystemAssignedVersionNbr());
			else if (fieldName.compareTo("recordTypeRefId")==0)
				m.setRecordTypeRefId(this.getRecordTypeRefId());
			else 		
				Debug.LogError(this, ExceptionInfo.invalidCopyModifiedField + " " + fieldName);
	}
}

	/**
	 * Update this object with the data from m
	 */
	public void updateWith (ReferenceModel m) {

		this.setRefId(m.getRefId());
		this.setReferenceGroup(m.getReferenceGroup());
		this.setAppTypeRefId(m.getAppTypeRefId());
		this.setAppTypeRefDisplay(m.getAppTypeRefDisplay());
		this.setDisplayCode(m.getDisplayCode());
		this.setDisplaySequence(m.getDisplaySequence());
		this.setDisplay(m.getDisplay());
		this.setDescription(m.getDescription());
		this.setCreateDt(m.getCreateDt());
		this.setCreateUserId(m.getCreateUserId());
		this.setCreateUserName(m.getCreateUserName());
		this.setUpdateDt(m.getUpdateDt());
		this.setUpdateUserId(m.getUpdateUserId());
		this.setUpdateUserName(m.getUpdateUserName());
		this.setUpdateCount(m.getUpdateCount());
		this.setActiveInd(m.getActiveInd());
		this.setSystemAssignedVersionNbr(m.getSystemAssignedVersionNbr());
		this.setRecordTypeRefId(m.getRecordTypeRefId());
		this.setRecordTypeRefDisplay(m.getRecordTypeRefDisplay());
	}

	/**
	 * Compare the two objects
	 */
	public boolean isEqualTo (ReferenceModel m) {

		if (!Comparison.areEqual(this.getRefId(),  m.getRefId())) return false;
		if (!Comparison.areEqual(this.getReferenceGroup(),  m.getReferenceGroup())) return false;
		if (!Comparison.areEqual(this.getAppTypeRefId(),  m.getAppTypeRefId())) return false;
		if (!Comparison.areEqual(this.getDisplayCode(),  m.getDisplayCode())) return false;
		if (!Comparison.areEqual(this.getDisplaySequence(),  m.getDisplaySequence())) return false;
		if (!Comparison.areEqual(this.getDisplay(),  m.getDisplay())) return false;
		if (!Comparison.areEqual(this.getDescription(),  m.getDescription())) return false;
		if (!Comparison.areEqual(this.getCreateDt(),  m.getCreateDt())) return false;
		if (!Comparison.areEqual(this.getCreateUserId(),  m.getCreateUserId())) return false;
		if (!Comparison.areEqual(this.getUpdateCount(),  m.getUpdateCount())) return false;
		if (!Comparison.areEqual(this.getActiveInd(),  m.getActiveInd())) return false;
		if (!Comparison.areEqual(this.getSystemAssignedVersionNbr(),  m.getSystemAssignedVersionNbr())) return false;
		if (!Comparison.areEqual(this.getRecordTypeRefId(),  m.getRecordTypeRefId())) return false;
		return true;
	}
	/**
	 * Returns a list of all field names which are required and are null
	 */
	public Vector getMissingRequired () {

		Vector v = new Vector();
		return v;
	}
	public String toString() {
		try {
			StringBuffer sb = new StringBuffer(1024);
			sb.append("ReferenceModel:\r\n");
			sb.append("ref_id:" + getRefId());
			sb.append("\r\n");
			sb.append("reference_group:" + getReferenceGroup());
			sb.append("\r\n");
			sb.append("app_type_ref_id:" + getAppTypeRefId());
			sb.append("\r\n");
			sb.append("app_type_ref_display:" + getAppTypeRefDisplay());
			sb.append("\r\n");
			sb.append("display_code:" + getDisplayCode());
			sb.append("\r\n");
			sb.append("display_sequence:" + getDisplaySequence());
			sb.append("\r\n");
			sb.append("display:" + getDisplay());
			sb.append("\r\n");
			sb.append("description:" + getDescription());
			sb.append("\r\n");
			sb.append("create_dt:" + CalendarUtility.Format(getCreateDt(),AppFormats.getLongDateTimeFormat()));
			sb.append("\r\n");
			sb.append("create_user_id:" + getCreateUserId());
			sb.append("\r\n");
			sb.append("create_user_name:" + getCreateUserName());
			sb.append("\r\n");
			sb.append("update_dt:" + CalendarUtility.Format(getUpdateDt(),AppFormats.getLongDateTimeFormat()));
			sb.append("\r\n");
			sb.append("update_user_id:" + getUpdateUserId());
			sb.append("\r\n");
			sb.append("update_user_name:" + getUpdateUserName());
			sb.append("\r\n");
			sb.append("update_count:" + getUpdateCount());
			sb.append("\r\n");
			sb.append("active_ind:" + getActiveInd());
			sb.append("\r\n");
			sb.append("system_assigned_version_nbr:" + getSystemAssignedVersionNbr());
			sb.append("\r\n");
			sb.append("record_type_ref_id:" + getRecordTypeRefId());
			sb.append("\r\n");
			sb.append("record_type_ref_display:" + getRecordTypeRefDisplay());
			sb.append("\r\n");
			return sb.toString();
		} catch (Exception ex) {
			return "ReferenceModel:"; 
		}
	}
	public void setModelColDataAt(Object o, int modelCol) {
			switch (modelCol) {
			case 492: setRefId(((Integer) o).intValue()); break;
			case 493: setReferenceGroup((String) o); break;
			case 494: setAppTypeRefId(((Integer) o).intValue()); break;
			case 495: setDisplayCode((String) o); break;
			case 496: setDisplaySequence(((Integer) o).intValue()); break;
			case 497: setDisplay((String) o); break;
			case 498: setDescription((String) o); break;
			case 499: setCreateDt((GregorianCalendar) o); break;
			case 500: setCreateUserId(((Integer) o).intValue()); break;
			case 794: setCreateUserName((String) o); break;
			case 501: setUpdateDt((GregorianCalendar) o); break;
			case 502: setUpdateUserId(((Integer) o).intValue()); break;
			case 795: setUpdateUserName((String) o); break;
			case 503: setUpdateCount(((Integer) o).intValue()); break;
			case 504: setActiveInd(((Integer) o).intValue()); break;
			case 505: setSystemAssignedVersionNbr(((Integer) o).intValue()); break;
			case 506: setRecordTypeRefId(((Integer) o).intValue()); break;
			default: Debug.LogWarning(this, ReferenceServices.getMsg(SystemMessageFramework.SWITCHSTATEMENTFAILED) + " modelColRefId: " + modelCol);
	} 
}

	public Object getModelColDataAt(int modelCol) {
			if (modelCol == 492) return new Integer(refId);
			if (modelCol == 493) return referenceGroup;
			if (modelCol == 494) return new Integer(appTypeRefId);
			if (modelCol == 494) return appTypeRefDisplay;
			if (modelCol == 495) return displayCode;
			if (modelCol == 496) return new Integer(displaySequence);
			if (modelCol == 497) return display;
			if (modelCol == 498) return description;
			if (modelCol == 499) return createDt;
			if (modelCol == 500) return new Integer(createUserId);
			if (modelCol == 500) return createUserName;
			if (modelCol == 501) return updateDt;
			if (modelCol == 502) return new Integer(updateUserId);
			if (modelCol == 502) return updateUserName;
			if (modelCol == 503) return new Integer(updateCount);
			if (modelCol == 504) return new Integer(activeInd);
			if (modelCol == 505) return new Integer(systemAssignedVersionNbr);
			if (modelCol == 506) return new Integer(recordTypeRefId);
			if (modelCol == 506) return recordTypeRefDisplay;
		return null;
	}

	public int getModelColDatabaseDataType(int modelCol) {
			if (modelCol == 492) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 493) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 494) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 494) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 495) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 496) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 497) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 498) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 499) return DatabaseDataTypeFramework.DATE;
			if (modelCol == 500) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 500) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 501) return DatabaseDataTypeFramework.DATE;
			if (modelCol == 502) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 502) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 503) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 504) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 505) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 506) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 506) return DatabaseDataTypeFramework.STRING;
			return DatabaseDataTypeFramework.STRING;
	}

	public boolean isNew() {
		return getRefId() == 0;
	}

	public Object getPrimaryValue() {
		return new Integer(getRefId());
	}

	public Object getDataAt(int i) {
			if (i == 0) return new Integer(refId);
			if (i == 1) return referenceGroup;
			if (i == 2) return new Integer(appTypeRefId);
			if (i == 3) return appTypeRefDisplay;
			if (i == 4) return displayCode;
			if (i == 5) return new Integer(displaySequence);
			if (i == 6) return display;
			if (i == 7) return description;
			if (i == 8) return createDt;
			if (i == 9) return new Integer(createUserId);
			if (i == 10) return createUserName;
			if (i == 11) return updateDt;
			if (i == 12) return new Integer(updateUserId);
			if (i == 13) return updateUserName;
			if (i == 14) return new Integer(updateCount);
			if (i == 15) return new Integer(activeInd);
			if (i == 16) return new Integer(systemAssignedVersionNbr);
			if (i == 17) return new Integer(recordTypeRefId);
			if (i == 18) return recordTypeRefDisplay;
		return null;
	}

	public int getDatabaseDataType(int i) {
			if (i == 0) return DatabaseDataTypeFramework.INTEGER;
			if (i == 1) return DatabaseDataTypeFramework.STRING;
			if (i == 2) return DatabaseDataTypeFramework.INTEGER;
			if (i == 3) return DatabaseDataTypeFramework.STRING;
			if (i == 4) return DatabaseDataTypeFramework.STRING;
			if (i == 5) return DatabaseDataTypeFramework.INTEGER;
			if (i == 6) return DatabaseDataTypeFramework.STRING;
			if (i == 7) return DatabaseDataTypeFramework.STRING;
			if (i == 8) return DatabaseDataTypeFramework.DATE;
			if (i == 9) return DatabaseDataTypeFramework.INTEGER;
			if (i == 10) return DatabaseDataTypeFramework.STRING;
			if (i == 11) return DatabaseDataTypeFramework.DATE;
			if (i == 12) return DatabaseDataTypeFramework.INTEGER;
			if (i == 13) return DatabaseDataTypeFramework.STRING;
			if (i == 14) return DatabaseDataTypeFramework.INTEGER;
			if (i == 15) return DatabaseDataTypeFramework.INTEGER;
			if (i == 16) return DatabaseDataTypeFramework.INTEGER;
			if (i == 17) return DatabaseDataTypeFramework.INTEGER;
			if (i == 18) return DatabaseDataTypeFramework.STRING;
			return DatabaseDataTypeFramework.STRING;
	}

	public void setDataAt(Object o, int i) {
		switch(i) {
			case 0: setRefId(((Integer) o).intValue()); break;
			case 1: setReferenceGroup((String) o); break;
			case 2: setAppTypeRefId(((Integer) o).intValue()); break;
			case 3: setAppTypeRefDisplay((String) o); break;
			case 4: setDisplayCode((String) o); break;
			case 5: setDisplaySequence(((Integer) o).intValue()); break;
			case 6: setDisplay((String) o); break;
			case 7: setDescription((String) o); break;
			case 8: setCreateDt((GregorianCalendar) o); break;
			case 9: setCreateUserId(((Integer) o).intValue()); break;
			case 10: setCreateUserName((String) o); break;
			case 11: setUpdateDt((GregorianCalendar) o); break;
			case 12: setUpdateUserId(((Integer) o).intValue()); break;
			case 13: setUpdateUserName((String) o); break;
			case 14: setUpdateCount(((Integer) o).intValue()); break;
			case 15: setActiveInd(((Integer) o).intValue()); break;
			case 16: setSystemAssignedVersionNbr(((Integer) o).intValue()); break;
			case 17: setRecordTypeRefId(((Integer) o).intValue()); break;
			case 18: setRecordTypeRefDisplay((String) o); break;
		}
	}

}