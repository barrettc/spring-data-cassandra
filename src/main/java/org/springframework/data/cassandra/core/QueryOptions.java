/*
 * Copyright 2011-2013 the original author or authors.
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
package org.springframework.data.cassandra.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains Query Options for Cassandra queries. This controls the Consistency Tuning and Retry Policy for a Query.
 * 
 * @author David Webb
 * 
 */
public class QueryOptions {

	private ConsistencyLevel consistencyLevel;
	private RetryPolicy retryPolicy;
	private Integer ttl;

	/**
	 * Create a Map of all these options.
	 */
	public Map<String, Object> toMap() {

		Map<String, Object> m = new HashMap<String, Object>();

		if (getConsistencyLevel() != null) {
			m.put(QueryOptionMapKeys.CONSISTENCY_LEVEL, getConsistencyLevel());
		}
		if (getRetryPolicy() != null) {
			m.put(QueryOptionMapKeys.RETRY_POLICY, getRetryPolicy());
		}
		if (getTtl() != null) {
			m.put(QueryOptionMapKeys.TTL, getTtl());
		}

		return m;
	}

	/**
	 * @return Returns the consistencyLevel.
	 */
	public ConsistencyLevel getConsistencyLevel() {
		return consistencyLevel;
	}

	/**
	 * @param consistencyLevel The consistencyLevel to set.
	 */
	public void setConsistencyLevel(ConsistencyLevel consistencyLevel) {
		this.consistencyLevel = consistencyLevel;
	}

	/**
	 * @return Returns the retryPolicy.
	 */
	public RetryPolicy getRetryPolicy() {
		return retryPolicy;
	}

	/**
	 * @param retryPolicy The retryPolicy to set.
	 */
	public void setRetryPolicy(RetryPolicy retryPolicy) {
		this.retryPolicy = retryPolicy;
	}

	/**
	 * @return Returns the ttl.
	 */
	public Integer getTtl() {
		return ttl;
	}

	/**
	 * @param ttl The ttl to set.
	 */
	public void setTtl(Integer ttl) {
		this.ttl = ttl;
	}

	/**
	 * Constants for looking up Map Elements by Key
	 * 
	 * @author David Webb
	 * 
	 */
	public static interface QueryOptionMapKeys {
		public final String CONSISTENCY_LEVEL = "ConsistencyLevel";
		public final String RETRY_POLICY = "RetryPolicy";
		public final String TTL = "TTL";
	}
}
