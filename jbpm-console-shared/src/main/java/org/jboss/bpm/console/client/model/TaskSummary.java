/**
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.bpm.console.client.model;

import java.io.Serializable;
import java.util.Date;
import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class TaskSummary
    implements
    Serializable {
    private long    id;

    private String  name;

    private String  subject;

    private String  description;
    // Was Status
    private String  status;

    private int     priority;

    private boolean skipable;
    //Was User
    private String    actualOwner;
    //Was User
    private String    createdBy;

    private Date    createdOn;

    private Date    activationTime;

    private Date    expirationTime;
    
    private long    processInstanceId;
    
    private String  processId;
    
    private int processSessionId;
    

    public TaskSummary(long id,
    		           long processInstanceId,
                       String name,
                       String subject,
                       String description,
                       String status,
                       int priority,
                       boolean skipable,
                       String actualOwner,
                       String createdBy,
                       Date createdOn,
                       Date activationTime,
                       Date expirationTime,
                       String processId,
                       int processSessionId) {
        super();
        this.id = id;
        this.processInstanceId = processInstanceId;
        this.name = name;
        this.subject = subject;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.skipable = skipable;
        this.actualOwner = actualOwner;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.activationTime = activationTime;
        this.expirationTime = expirationTime;
        this.processId = processId;
        this.processSessionId = processSessionId;
    }

    public TaskSummary() {
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getProcessInstanceId() {
    	return processInstanceId;
    }
    
    public void setProcessInstanceId(long processInstanceId) {
    	this.processInstanceId = processInstanceId;
    }
    
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isSkipable() {
        return skipable;
    }

    public void setSkipable(boolean skipable) {
        this.skipable = skipable;
    }

    public String getActualOwner() {
        return actualOwner;
    }

    public void setActualOwner(String actualOwner) {
        this.actualOwner = actualOwner;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(Date activationTime) {
        this.activationTime = activationTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }
    
    public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
	public int getProcessSessionId() {
		return processSessionId;
	}

	public void setProcessSessionId(int processSessionId) {
		this.processSessionId = processSessionId;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activationTime == null) ? 0 : activationTime.hashCode());
        result = prime * result + ((actualOwner == null) ? 0 : actualOwner.hashCode());
        result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
        result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((expirationTime == null) ? 0 : expirationTime.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (int) (processInstanceId ^ (processInstanceId >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + priority;
        result = prime * result + (skipable ? 1231 : 1237);
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        result = prime * result + ((processId == null) ? 0 : processId.hashCode());
        result = prime * result + processSessionId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if ( obj == null ) return false;
        if ( !(obj instanceof TaskSummary) ) return false;
        TaskSummary other = (TaskSummary) obj;
        if ( processInstanceId != other.processInstanceId) return false;
        if ( activationTime == null ) {
            if ( other.activationTime != null ) return false;
        } else if ( activationTime.getTime() != other.activationTime.getTime() ) return false;
        if ( actualOwner == null ) {
            if ( other.actualOwner != null ) return false;
        } else if ( !actualOwner.equals( other.actualOwner ) ) return false;
        if ( createdBy == null ) {
            if ( other.createdBy != null ) return false;
        } else if ( !createdBy.equals( other.createdBy ) ) return false;
        if ( createdOn == null ) {
            if ( other.createdOn != null ) return false;
        } else if ( createdOn.getTime() != other.createdOn.getTime() ) return false;
        if ( description == null ) {
            if ( other.description != null ) return false;
        } else if ( !description.equals( other.description ) ) return false;
        if ( expirationTime == null ) {
            if ( other.expirationTime != null ) return false;
        } else if ( expirationTime.getTime() != other.expirationTime.getTime() ) return false;
        if ( name == null ) {
            if ( other.name != null ) return false;
        } else if ( !name.equals( other.name ) ) return false;
        if ( priority != other.priority ) return false;
        if ( skipable != other.skipable ) return false;
        if ( status == null ) {
            if ( other.status != null ) return false;
        } else if ( !status.equals( other.status ) ) return false;
        if ( subject == null ) {
            if ( other.subject != null ) return false;
        } else if ( !subject.equals( other.subject ) ) return false;
        if ( processId == null ) {
            if ( other.processId != null ) return false;
        } else if ( !processId.equals( other.processId ) ) return false;
        if ( processSessionId != other.processSessionId ) return false;
        return true;
    }

}
