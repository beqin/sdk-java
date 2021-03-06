/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package com.huawei.openstack4j.model.gbp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.huawei.openstack4j.common.Buildable;
import com.huawei.openstack4j.model.common.Resource;
import com.huawei.openstack4j.model.gbp.builder.PolicyActionCreateBuilder;

/**
 * Policy Action Model Entity
 * 
 * @author vinod borole
 */
public interface PolicyAction extends Buildable<PolicyActionCreateBuilder>, Resource {

    public enum PolicyActionProtocol{
        ALLOW,
        REDIRECT,
        COPY,
        LOG,
        QoS,
        UNRECOGNIZED;
        
        @JsonCreator
        public static PolicyActionProtocol forValue(String value) {
            if (value != null)
            {
                for (PolicyActionProtocol s : PolicyActionProtocol.values()) {
                    if (s.name().equalsIgnoreCase(value))
                        return s;
                }
            }
            return PolicyActionProtocol.UNRECOGNIZED;
        }
        
        @JsonValue
        public String value() {
            return name().toLowerCase();
        }
    }
    
    /**
     * Gets the Action value
     *
     * @return the Action value
     */
    String getActionValue();

    /**
     * Gets the Action Type
     *
     * @return the Action Type
     */
    PolicyActionProtocol getActionType();

    /**
     * Is Policy Action shared
     *
     * @return the true if shared and false if not shared
     */
    boolean isShared();

    /**
     * Gets the description
     *
     * @return the description
     */
    String getDescription();

}
  