/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.nifi.registry.flow;

import java.util.Objects;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class VersionedRemoteGroupPort extends VersionedComponent {
    private String groupId;
    private Integer concurrentlySchedulableTaskCount;
    private Boolean useCompression;
    private BatchSize batchSize;
    private ComponentType componentType;

    @ApiModelProperty("The number of task that may transmit flowfiles to the target port concurrently.")
    public Integer getConcurrentlySchedulableTaskCount() {
        return concurrentlySchedulableTaskCount;
    }

    public void setConcurrentlySchedulableTaskCount(Integer concurrentlySchedulableTaskCount) {
        this.concurrentlySchedulableTaskCount = concurrentlySchedulableTaskCount;
    }

    @ApiModelProperty("The id of the remote process group that the port resides in.")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }


    @ApiModelProperty("Whether the flowfiles are compressed when sent to the target port.")
    public Boolean isUseCompression() {
        return useCompression;
    }

    public void setUseCompression(Boolean useCompression) {
        this.useCompression = useCompression;
    }

    @ApiModelProperty("The batch settings for data transmission.")
    public BatchSize getBatchSize() {
        return batchSize;
    }

    public void setBatchSettings(BatchSize batchSize) {
        this.batchSize = batchSize;
    }

    @Override
    public int hashCode() {
        return 923847 + String.valueOf(getName()).hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof VersionedRemoteGroupPort)) {
            return false;
        }

        final VersionedRemoteGroupPort other = (VersionedRemoteGroupPort) obj;
        return Objects.equals(getName(), other.getName());
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(final ComponentType componentType) {
        if (componentType != ComponentType.REMOTE_INPUT_PORT && componentType != ComponentType.REMOTE_OUTPUT_PORT) {
            throw new IllegalArgumentException();
        }

        this.componentType = componentType;
    }
}
