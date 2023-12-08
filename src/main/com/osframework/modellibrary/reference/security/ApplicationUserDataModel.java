/*
     * The User model is a domain object which stores the system application users
 * The user id is used throughout all tables following the convention <field>_user_id
 * e.g. create_user_id
 * The UserDataModel is auto generated by generator.GenerateModel.getModelSource()
 * and is subclassed by UserModel generated once by GenerateModel.getExtendedModelSouce().
 * Any business logic should be added to UserModel.  The UserList is a collection
 * of UserModels and is auto generated by GenerateModel.getListSource.  How the list stores
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
package com.osframework.modellibrary.reference.security;
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
 * The User model is a domain object which stores the system application users
 * The user id is used throughout all tables following the convention <field>_user_id
 * e.g. create_user_id
 * The UserDataModel is auto generated by generator.GenerateModel.getModelSource()
 * and is subclassed by UserModel generated once by GenerateModel.getExtendedModelSouce().
 * Any business logic should be added to UserModel.  The UserList is a collection
 * of UserModels and is auto generated by GenerateModel.getListSource.  How the list stores
 * the models depends on the parameters defined in osrmt_schem.mdb ModelLibrary.
*/
public class ApplicationUserDataModel implements IControlModel, java.io.Serializable {

	static final long serialVersionUID = 1L;
	private int hashsize = 17;
	private Hashtable modifiedFields = new Hashtable(hashsize);
	private boolean referenceSet = false;


	/** Unique identifier for the user table  */
	private int userId = 0;

	/** User first name  */
	private String firstName;

	/** User last name  */
	private String lastName;

	/** User formatted name  */
	private String displayName;

	/** User login name  */
	private String userLogin;

	/** Hashed password  */
	private String password;

	/** Indicates the password was reset and new password required  */
	private int passwordResetInd = 0;

	/** Email address  */
	private String email;

	/** User position foreign key to reference table  */
	private int positionRefId = 0;

	private String positionRefDisplay="";

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
	 * Unique identifier for the user table
	 * 
	 */ 
	public int getUserId() {
		return userId;
	}

	/** 
	 * Unique identifier for the user table
	 * 
	 */ 
	public void setUserId(int userId) {
		if (!Comparison.areEqual(this.userId, userId)) {
			this.userId = userId;
			setModified("userId");
		};
	}

	/** 
	 * User first name
	 * 
	 */ 
	public String getFirstName() {
		return firstName;
	}

	/** 
	 * User first name
	 * 
	 */ 
	public void setFirstName(String firstName) {
		if (!Comparison.areEqual(this.firstName, firstName)) {
			this.firstName = firstName;
			setModified("firstName");
		};
	}

	/** 
	 * User last name
	 * 
	 */ 
	public String getLastName() {
		return lastName;
	}

	/** 
	 * User last name
	 * 
	 */ 
	public void setLastName(String lastName) {
		if (!Comparison.areEqual(this.lastName, lastName)) {
			this.lastName = lastName;
			setModified("lastName");
		};
	}

	/** 
	 * User formatted name
	 * 
	 */ 
	public String getDisplayName() {
		return displayName;
	}

	/** 
	 * User formatted name
	 * 
	 */ 
	public void setDisplayName(String displayName) {
		if (!Comparison.areEqual(this.displayName, displayName)) {
			this.displayName = displayName;
			setModified("displayName");
		};
	}

	/** 
	 * User login name
	 * 
	 */ 
	public String getUserLogin() {
		return userLogin;
	}

	/** 
	 * User login name
	 * 
	 * Required database field.
	 */ 
	public void setUserLogin(String userLogin) {
		if (!Comparison.areEqual(this.userLogin, userLogin)) {
			this.userLogin = userLogin;
			setModified("userLogin");
		};
	}

	/** 
	 * Hashed password
	 * 
	 */ 
	public String getPassword() {
		return password;
	}

	/** 
	 * Hashed password
	 * 
	 */ 
	public void setPassword(String password) {
		if (!Comparison.areEqual(this.password, password)) {
			this.password = password;
			setModified("password");
		};
	}

	/** 
	 * Indicates the password was reset and new password required
	 * 
	 */ 
	public int getPasswordResetInd() {
		return passwordResetInd;
	}

	/** 
	 * Indicates the password was reset and new password required
	 * 
	 * Required database field.
	 */ 
	public void setPasswordResetInd(int passwordResetInd) {
		if (!Comparison.areEqual(this.passwordResetInd, passwordResetInd)) {
			this.passwordResetInd = passwordResetInd;
			setModified("passwordResetInd");
		};
	}

	/** 
	 * Indicates the password was reset and new password required
	 * 
	 */ 
	public boolean isPasswordReset() {
		return passwordResetInd == 1;
	}

	/** 
	 * Indicates the password was reset and new password required
	 * 
	 */ 
	public boolean isNotPasswordReset() {
		return passwordResetInd == 0;
	}

	/** 
	 * Indicates the password was reset and new password required
	 * 
	 */ 
	public void setPasswordReset() {
		this.setPasswordResetInd(1);
	}

	public void setNotPasswordReset() {
		this.setPasswordResetInd(0);
	}

	/** 
	 * Email address
	 * 
	 */ 
	public String getEmail() {
		return email;
	}

	/** 
	 * Email address
	 * 
	 */ 
	public void setEmail(String email) {
		if (!Comparison.areEqual(this.email, email)) {
			this.email = email;
			setModified("email");
		};
	}

	/** 
	 * User position foreign key to reference table
	 * 
	 */ 
	public int getPositionRefId() {
		return positionRefId;
	}

	/** 
	 * User position foreign key to reference table
	 * 
	 * Required database field.
	 */ 
	public void setPositionRefId(int positionRefId) {
		if (!Comparison.areEqual(this.positionRefId, positionRefId)) {
			this.positionRefId = positionRefId;
			setModified("positionRefId");
		};
	}

	/** 
	 * User position foreign key to reference table
	 * 
	 */ 
	public String getPositionRefDisplay() {
		return positionRefDisplay;
	}

	/** 
	 * User position foreign key to reference table
	 * 
	 */ 
	public void setPositionRefDisplay(String display) {
		this.positionRefDisplay = display;
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
		columns.addColumn("userId", Integer.class);
		columns.addColumn("firstName", String.class);
		columns.addColumn("lastName", String.class);
		columns.addColumn("displayName", String.class);
		columns.addColumn("userLogin", String.class);
		columns.addColumn("password", String.class);
		columns.addColumn("passwordResetInd", Integer.class);
		columns.addColumn("email", String.class);
		columns.addColumn("positionRefId", Integer.class);
		columns.addColumn("positionRefDisplay", String.class);
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
			if (reference != null && this.positionRefId > 0) setPositionRefDisplay(reference.getDisplay(this.positionRefId));
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
	public void copyModifiedTo(ApplicationUserDataModel m) {
		Enumeration e1 = modifiedFields.keys();
		while (e1.hasMoreElements()) {
			String fieldName = (String) e1.nextElement();

			if (fieldName.compareTo("userId")==0)
				m.setUserId(this.getUserId());
			else if (fieldName.compareTo("firstName")==0)
				m.setFirstName(this.getFirstName());
			else if (fieldName.compareTo("lastName")==0)
				m.setLastName(this.getLastName());
			else if (fieldName.compareTo("displayName")==0)
				m.setDisplayName(this.getDisplayName());
			else if (fieldName.compareTo("userLogin")==0)
				m.setUserLogin(this.getUserLogin());
			else if (fieldName.compareTo("password")==0)
				m.setPassword(this.getPassword());
			else if (fieldName.compareTo("passwordResetInd")==0)
				m.setPasswordResetInd(this.getPasswordResetInd());
			else if (fieldName.compareTo("email")==0)
				m.setEmail(this.getEmail());
			else if (fieldName.compareTo("positionRefId")==0)
				m.setPositionRefId(this.getPositionRefId());
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
	public void updateWith (ApplicationUserModel m) {

		this.setUserId(m.getUserId());
		this.setFirstName(m.getFirstName());
		this.setLastName(m.getLastName());
		this.setDisplayName(m.getDisplayName());
		this.setUserLogin(m.getUserLogin());
		this.setPassword(m.getPassword());
		this.setPasswordResetInd(m.getPasswordResetInd());
		this.setEmail(m.getEmail());
		this.setPositionRefId(m.getPositionRefId());
		this.setPositionRefDisplay(m.getPositionRefDisplay());
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
	public boolean isEqualTo (ApplicationUserModel m) {

		if (!Comparison.areEqual(this.getUserId(),  m.getUserId())) return false;
		if (!Comparison.areEqual(this.getFirstName(),  m.getFirstName())) return false;
		if (!Comparison.areEqual(this.getLastName(),  m.getLastName())) return false;
		if (!Comparison.areEqual(this.getDisplayName(),  m.getDisplayName())) return false;
		if (!Comparison.areEqual(this.getUserLogin(),  m.getUserLogin())) return false;
		if (!Comparison.areEqual(this.getPassword(),  m.getPassword())) return false;
		if (!Comparison.areEqual(this.getPasswordResetInd(),  m.getPasswordResetInd())) return false;
		if (!Comparison.areEqual(this.getEmail(),  m.getEmail())) return false;
		if (!Comparison.areEqual(this.getPositionRefId(),  m.getPositionRefId())) return false;
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
		if (getUserLogin()== null) v.add("userLogin");
		return v;
	}
	public String toString() {
		try {
			StringBuffer sb = new StringBuffer(1024);
			sb.append("ApplicationUserModel:\r\n");
			sb.append("user_id:" + getUserId());
			sb.append("\r\n");
			sb.append("first_name:" + getFirstName());
			sb.append("\r\n");
			sb.append("last_name:" + getLastName());
			sb.append("\r\n");
			sb.append("display_name:" + getDisplayName());
			sb.append("\r\n");
			sb.append("user_login:" + getUserLogin());
			sb.append("\r\n");
			sb.append("password:" + getPassword());
			sb.append("\r\n");
			sb.append("password_reset_ind:" + getPasswordResetInd());
			sb.append("\r\n");
			sb.append("email:" + getEmail());
			sb.append("\r\n");
			sb.append("position_ref_id:" + getPositionRefId());
			sb.append("\r\n");
			sb.append("position_ref_display:" + getPositionRefDisplay());
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
			return "ApplicationUserModel:"; 
		}
	}
	public void setModelColDataAt(Object o, int modelCol) {
			switch (modelCol) {
			case 536: setUserId(((Integer) o).intValue()); break;
			case 537: setFirstName((String) o); break;
			case 538: setLastName((String) o); break;
			case 539: setDisplayName((String) o); break;
			case 540: setUserLogin((String) o); break;
			case 541: setPassword((String) o); break;
			case 542: setPasswordResetInd(((Integer) o).intValue()); break;
			case 1408: setEmail((String) o); break;
			case 543: setPositionRefId(((Integer) o).intValue()); break;
			case 544: setCreateDt((GregorianCalendar) o); break;
			case 545: setCreateUserId(((Integer) o).intValue()); break;
			case 808: setCreateUserName((String) o); break;
			case 546: setUpdateDt((GregorianCalendar) o); break;
			case 547: setUpdateUserId(((Integer) o).intValue()); break;
			case 809: setUpdateUserName((String) o); break;
			case 548: setUpdateCount(((Integer) o).intValue()); break;
			case 549: setActiveInd(((Integer) o).intValue()); break;
			case 550: setSystemAssignedVersionNbr(((Integer) o).intValue()); break;
			case 551: setRecordTypeRefId(((Integer) o).intValue()); break;
			default: Debug.LogWarning(this, ReferenceServices.getMsg(SystemMessageFramework.SWITCHSTATEMENTFAILED) + " modelColRefId: " + modelCol);
	} 
}

	public Object getModelColDataAt(int modelCol) {
			if (modelCol == 536) return new Integer(userId);
			if (modelCol == 537) return firstName;
			if (modelCol == 538) return lastName;
			if (modelCol == 539) return displayName;
			if (modelCol == 540) return userLogin;
			if (modelCol == 541) return password;
			if (modelCol == 542) return new Integer(passwordResetInd);
			if (modelCol == 1408) return email;
			if (modelCol == 543) return new Integer(positionRefId);
			if (modelCol == 543) return positionRefDisplay;
			if (modelCol == 544) return createDt;
			if (modelCol == 545) return new Integer(createUserId);
			if (modelCol == 545) return createUserName;
			if (modelCol == 546) return updateDt;
			if (modelCol == 547) return new Integer(updateUserId);
			if (modelCol == 547) return updateUserName;
			if (modelCol == 548) return new Integer(updateCount);
			if (modelCol == 549) return new Integer(activeInd);
			if (modelCol == 550) return new Integer(systemAssignedVersionNbr);
			if (modelCol == 551) return new Integer(recordTypeRefId);
			if (modelCol == 551) return recordTypeRefDisplay;
		return null;
	}

	public int getModelColDatabaseDataType(int modelCol) {
			if (modelCol == 536) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 537) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 538) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 539) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 540) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 541) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 542) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 1408) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 543) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 543) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 544) return DatabaseDataTypeFramework.DATE;
			if (modelCol == 545) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 545) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 546) return DatabaseDataTypeFramework.DATE;
			if (modelCol == 547) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 547) return DatabaseDataTypeFramework.STRING;
			if (modelCol == 548) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 549) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 550) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 551) return DatabaseDataTypeFramework.INTEGER;
			if (modelCol == 551) return DatabaseDataTypeFramework.STRING;
			return DatabaseDataTypeFramework.STRING;
	}

	public boolean isNew() {
		return getUserId() == 0;
	}

	public Object getPrimaryValue() {
		return new Integer(getUserId());
	}

	public Object getDataAt(int i) {
			if (i == 0) return new Integer(userId);
			if (i == 1) return firstName;
			if (i == 2) return lastName;
			if (i == 3) return displayName;
			if (i == 4) return userLogin;
			if (i == 5) return password;
			if (i == 6) return new Integer(passwordResetInd);
			if (i == 7) return email;
			if (i == 8) return new Integer(positionRefId);
			if (i == 9) return positionRefDisplay;
			if (i == 10) return createDt;
			if (i == 11) return new Integer(createUserId);
			if (i == 12) return createUserName;
			if (i == 13) return updateDt;
			if (i == 14) return new Integer(updateUserId);
			if (i == 15) return updateUserName;
			if (i == 16) return new Integer(updateCount);
			if (i == 17) return new Integer(activeInd);
			if (i == 18) return new Integer(systemAssignedVersionNbr);
			if (i == 19) return new Integer(recordTypeRefId);
			if (i == 20) return recordTypeRefDisplay;
		return null;
	}

	public int getDatabaseDataType(int i) {
			if (i == 0) return DatabaseDataTypeFramework.INTEGER;
			if (i == 1) return DatabaseDataTypeFramework.STRING;
			if (i == 2) return DatabaseDataTypeFramework.STRING;
			if (i == 3) return DatabaseDataTypeFramework.STRING;
			if (i == 4) return DatabaseDataTypeFramework.STRING;
			if (i == 5) return DatabaseDataTypeFramework.STRING;
			if (i == 6) return DatabaseDataTypeFramework.INTEGER;
			if (i == 7) return DatabaseDataTypeFramework.STRING;
			if (i == 8) return DatabaseDataTypeFramework.INTEGER;
			if (i == 9) return DatabaseDataTypeFramework.STRING;
			if (i == 10) return DatabaseDataTypeFramework.DATE;
			if (i == 11) return DatabaseDataTypeFramework.INTEGER;
			if (i == 12) return DatabaseDataTypeFramework.STRING;
			if (i == 13) return DatabaseDataTypeFramework.DATE;
			if (i == 14) return DatabaseDataTypeFramework.INTEGER;
			if (i == 15) return DatabaseDataTypeFramework.STRING;
			if (i == 16) return DatabaseDataTypeFramework.INTEGER;
			if (i == 17) return DatabaseDataTypeFramework.INTEGER;
			if (i == 18) return DatabaseDataTypeFramework.INTEGER;
			if (i == 19) return DatabaseDataTypeFramework.INTEGER;
			if (i == 20) return DatabaseDataTypeFramework.STRING;
			return DatabaseDataTypeFramework.STRING;
	}

	public void setDataAt(Object o, int i) {
		switch(i) {
			case 0: setUserId(((Integer) o).intValue()); break;
			case 1: setFirstName((String) o); break;
			case 2: setLastName((String) o); break;
			case 3: setDisplayName((String) o); break;
			case 4: setUserLogin((String) o); break;
			case 5: setPassword((String) o); break;
			case 6: setPasswordResetInd(((Integer) o).intValue()); break;
			case 7: setEmail((String) o); break;
			case 8: setPositionRefId(((Integer) o).intValue()); break;
			case 9: setPositionRefDisplay((String) o); break;
			case 10: setCreateDt((GregorianCalendar) o); break;
			case 11: setCreateUserId(((Integer) o).intValue()); break;
			case 12: setCreateUserName((String) o); break;
			case 13: setUpdateDt((GregorianCalendar) o); break;
			case 14: setUpdateUserId(((Integer) o).intValue()); break;
			case 15: setUpdateUserName((String) o); break;
			case 16: setUpdateCount(((Integer) o).intValue()); break;
			case 17: setActiveInd(((Integer) o).intValue()); break;
			case 18: setSystemAssignedVersionNbr(((Integer) o).intValue()); break;
			case 19: setRecordTypeRefId(((Integer) o).intValue()); break;
			case 20: setRecordTypeRefDisplay((String) o); break;
		}
	}

}