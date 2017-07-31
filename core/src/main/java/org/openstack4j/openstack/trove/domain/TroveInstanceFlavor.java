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
package org.openstack4j.openstack.trove.domain;

import java.util.List;

import org.openstack4j.model.ModelEntity;
import org.openstack4j.openstack.common.ListResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Model represent for attributes of Database instance Flavor
 *
 * @author QianBiao.NG
 * @date   2017-07-31 11:12:39
 */
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("flavor")
public class TroveInstanceFlavor implements ModelEntity {
    
	private static final long serialVersionUID = 1640365078802343096L;
	
    private String id;
    
	private String name;
    
    @JsonProperty("str_id")
    private String strId;

    private int ram;
    private int vcpus;
    private int disk;


    public static class Flavors extends ListResult<TroveInstanceFlavor> {

        private static final long serialVersionUID = 1L;
        
        @JsonProperty("flavors")
        private List<TroveInstanceFlavor> troveInstanceFlavorList;

        @Override
        protected List<TroveInstanceFlavor> value() {
            return troveInstanceFlavorList;
        }

    }

}
